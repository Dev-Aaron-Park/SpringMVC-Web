package com.aaron.springmvcproject.gallery;

import java.io.File;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaron.springmvcproject.member.Member;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class GalleryDAO {
	
	@Autowired
	private SqlSession ss;

	public void delete(Gallery g, HttpServletRequest req) {
		try {
			Gallery gCheck = ss.getMapper(GalleryMapper.class).deleteCheck(g);
			Member m = (Member) req.getSession().getAttribute("loginMember");
			
			if (gCheck == null || !gCheck.getSpg_writer().equals(m.getSpm_id())) {
				req.setAttribute("r", "Delete Failed");
				return;
			} else {
				if (ss.getMapper(GalleryMapper.class).delete(g) == 1) {
					req.setAttribute("r", "Delete Success");
				} else {
					req.setAttribute("r", "Delete Failed");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "Delete Failed");
		}
	}
	
	public void upload(Gallery g, HttpServletRequest req) {
		String path = req.getSession().getServletContext().getRealPath("resources/img/galleryPhoto");
		// D:\eGovFrameDev-3.9.0-64bit\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\SpringMVC_Project\resources\img\galleryPhoto
		MultipartRequest mr = null;
		
		try {
			mr = new MultipartRequest(req, path, 31457280, "utf-8", new DefaultFileRenamePolicy());
		
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "Upload Failed(Photo Error)");
			return;
		}
		
		try {
			
			String token = mr.getParameter("token");
			String lastToken = (String) req.getSession().getAttribute("galleryUploadToken");
			
			if (lastToken != null && token.equals(lastToken)) {
				return;
			}
			
			Member m  = (Member) req.getSession().getAttribute("loginMember");
			String photo = mr.getFilesystemName("spg_photo");
			photo = URLEncoder.encode(photo, "utf-8").replace("+", " ");
			String memo = mr.getParameter("spg_memo");
			
			g.setSpg_writer(m.getSpm_id());
			g.setSpg_photo(photo);
			g.setSpg_memo(memo);
			
			if (ss.getMapper(GalleryMapper.class).upload(g) == 1) {
				req.setAttribute("r", "Upload Success");
				req.getSession().setAttribute("galleryUploadToken", token);
			} else {
				new File(path + "/" + mr.getFilesystemName("spg_photo")).delete();
				req.setAttribute("r", "Upload Failed");
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			new File(path + "/" + mr.getFilesystemName("spg_photo")).delete();
			req.setAttribute("r", "Upload Failed");
		}
	}

	public void readAllPhoto(HttpServletRequest req) {
		try {
			req.setAttribute("photos", ss.getMapper(GalleryMapper.class).readAllPhotos());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
