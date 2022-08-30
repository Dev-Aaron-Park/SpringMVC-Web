package com.aaron.springmvcproject.member;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaron.springmvcproject.board.BoardDAO;
import com.aaron.springmvcproject.board.BoardMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class MemberDAO {
	
	@Autowired
	private BoardDAO bDAO;
	
	@Autowired
	private SqlSession ss;

	public void delete(HttpServletRequest req) {
		try {
			Member m = (Member) req.getSession().getAttribute("loginMember");
			int msgCount = ss.getMapper(BoardMapper.class).getMemberPostingsCount(m);
			if (ss.getMapper(MemberMapper.class).delete(m) == 1) {
				bDAO.setReadAllCount(msgCount);
				req.setAttribute("r", "Delete Success");
				String path = req.getSession().getServletContext().getRealPath("resources/img/profilePhoto");
				String photo = URLDecoder.decode(m.getSpm_photo(), "utf-8");
				new File(path + "/" + photo).delete();
			} else {
				req.setAttribute("r", "Delete Failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "Delete Failed");
		}
	}
	
	public void edit(Member m, HttpServletRequest req) {
		String path = req.getSession().getServletContext().getRealPath("resources/img/profilePhoto");
		MultipartRequest mr = null;
		try {
			mr = new MultipartRequest(req, path, 31457280,
					"utf-8", new DefaultFileRenamePolicy());
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "Edit Failed(Photo)");
			return;
		}
		
		Member loginedMember = (Member) req.getSession().getAttribute("loginMember");
		String oldPhoto = loginedMember.getSpm_photo();
		String newPhoto = null;
		try {
			String id = mr.getParameter("editId");
			String pw = mr.getParameter("editPw");
			String bcn = mr.getParameter("editBcn");
			String name = mr.getParameter("editName");
			String birth1 = mr.getParameter("editBirth1");
			String birth2 = mr.getParameter("editBirth2");
			String addr1 = mr.getParameter("editAddr1");
			String addr2 = mr.getParameter("editAddr2");
			String addr3 = mr.getParameter("editAddr3");
			birth1 = String.format(Integer.parseInt(birth2) < 3 ? "19%s" : "20%s", birth1);
			Date birthday = new SimpleDateFormat("yyyyMMdd").parse(birth1);
			String address = addr2 + "!" + addr3 + "!" + addr1;

			newPhoto = mr.getFilesystemName("editPhoto");
			if (newPhoto == null) {
				newPhoto = oldPhoto;
			} else {
				newPhoto = URLEncoder.encode(newPhoto, "utf-8").replace("+", " ");
			}
			
			m.setSpm_id(id);
			m.setSpm_pw(pw);
			m.setSpm_bcn(bcn);
			m.setSpm_name(name);
			m.setSpm_birthday(birthday);
			m.setSpm_address(address);
			m.setSpm_photo(newPhoto);
			
			if (ss.getMapper(MemberMapper.class).update(m) == 1) {
				req.setAttribute("r", "Update Success");
				req.getSession().setAttribute("loginMember", m);
				if (!newPhoto.equals(oldPhoto)) {
					oldPhoto = URLDecoder.decode(oldPhoto, "utf-8");
					new File(path + "/" + oldPhoto).delete();
				}
			} else {
				req.setAttribute("r", "Update Failed");
				if (!newPhoto.equals(oldPhoto)) {
					newPhoto = URLDecoder.decode(newPhoto, "utf-8");
					new File(path + "/" + oldPhoto).delete();
				}
			}
			
		} catch (Exception e) {
			req.setAttribute("r", "Update Failed");
			if (!newPhoto.equals(oldPhoto)) {
				try {
					newPhoto = URLDecoder.decode(newPhoto, "utf-8");
				} catch (UnsupportedEncodingException e1) {
				}
				new File(path + "/" + oldPhoto).delete();
			}
		}
	}
	
	public void getMemberInfo(HttpServletRequest req) {
		req.setAttribute("newBlockChainHash", "0x95b67ef448e248996a8cfeec200e4f5b423e2898ecc007d4b5b5b7b96fd8bbbe");
		
		Member m = (Member) req.getSession().getAttribute("loginMember");
		Date birthday = m.getSpm_birthday();
		String[] address = m.getSpm_address().split("!");
		
		req.setAttribute("birth", new SimpleDateFormat("yyMMdd").format(birthday));
		req.setAttribute("addr1", address[2]);
		req.setAttribute("addr2", address[0]);
		req.setAttribute("addr3", address[1]);
	}
	
	public Members getMemberInfo(Member m) {
		List<Member> l = ss.getMapper(MemberMapper.class).getMemberByIDList(m);
		Members members = new Members(l);
		return members;
	}
	
	public boolean isLogined(HttpServletRequest req) {
		Member m = (Member) req.getSession().getAttribute("loginMember");
		if (m != null) {
			req.setAttribute("loginPage", "member/afterLogin.jsp");
			return true;
		}
		req.setAttribute("loginPage", "member/login.jsp");
		return false;
	}
	
	public void join(Member m, HttpServletRequest req) {
		String path = req.getSession().getServletContext().getRealPath("resources/img/profilePhoto");
		// D:\eGovFrameDev-3.9.0-64bit\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\SpringMVC_Project\resources\img\profilePhoto
		MultipartRequest mr = null;
		try {
			mr = new MultipartRequest(req, path, 31457280,
					"utf-8", new DefaultFileRenamePolicy());
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "Join Failed(Photo Error)");
			return;
		}
		
		try {
			String id = mr.getParameter("joinId");
			String pw = mr.getParameter("joinPw");
			String bcn = mr.getParameter("joinBcn");
			String name = mr.getParameter("joinName");
			String birth1 = mr.getParameter("joinBirth1");
			String birth2 = mr.getParameter("joinBirth2");
			String addr1 = mr.getParameter("joinAddr1");
			String addr2 = mr.getParameter("joinAddr2");
			String addr3 = mr.getParameter("joinAddr3");
			String photo = mr.getFilesystemName("joinPhoto");
			photo = URLEncoder.encode(photo, "utf-8").replace("+", " ");
			
			birth1 = String.format(Integer.parseInt(birth2) < 3 ? "19%s" : "20%s", birth1);
			Date birthday = new SimpleDateFormat("yyyyMMdd").parse(birth1);
			String address = addr2 + "!" + addr3 + "!" + addr1;
			
			m.setSpm_id(id);
			m.setSpm_pw(pw);
			m.setSpm_bcn(bcn);
			m.setSpm_name(name);
			m.setSpm_birthday(birthday);
			m.setSpm_address(address);
			m.setSpm_photo(photo);

			if (ss.getMapper(MemberMapper.class).join(m) == 1) {
				req.setAttribute("r", "Join Success");
			} else {
				new File(path+ "/" + mr.getFilesystemName("joinPhoto")).delete();
				req.setAttribute("r", "Join Failed");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			new File(path+ "/" + mr.getFilesystemName("joinPhoto")).delete();
			req.setAttribute("r", "Join Failed");
		}
	}

	public void login(Member inputMember, HttpServletRequest req) {
		
		try {
			Member dbMember = ss.getMapper(MemberMapper.class).getMemberByID(inputMember);
			if (dbMember != null) {
				if (inputMember.getSpm_pw().equals(dbMember.getSpm_pw())) {
					if (inputMember.getSpm_bcn().equals("820")) {
						req.getSession().setAttribute("loginMember", dbMember);
						System.out.println("Login Success");
					} else {
						System.out.println("Login Failed(Block Chain)");
					}
				} else {
					System.out.println("Login Failed(Password)");
				}
			} else {
				System.out.println("Login Failed(None Member)");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Login Failed(DB)");
		}
		
	}

	public void logout(HttpServletRequest req) {
		req.getSession().setAttribute("loginMember", null);
	}
	
}
