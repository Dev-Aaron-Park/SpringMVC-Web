# Spring MVC Web Site / Toy Project

---

## About
> Spring MVC를 학습하며 익숙해지기 위해 제작한 개인 토이 프로젝트 입니다.
>
> 제작 기간 : 2022. 08. 17 ~ 2022. 08. 31 (15 Day)
>
> 목적 : Spring을 활용하여 사이트에 흔히 사용되는 기능을 구현하며 익숙해지고, 
>    예측하지 못했던 문제들을 해결하고 경험해보기 위해 시도되었습니다.

---

## Skill Set
- Frontend
	- HTML / CSS
	- JavaScript, JQuery
	
- Backend
	- Java
	- Spring MVC
	- Node.js
	
- Database
	- Oracle DB
	- MyBatis
	
- Etc.
	- Maven
	
---

## Function
---
- **Membership**
	- 로그인 / 로그아웃
	- 회원 가입 / 회원 탈퇴 / 회원 정보 수정
	- 프로필 사진
	
- **Board**
	- 글 생성 / 삭제 / 수정 / 검색
	- Page 기능
	- Search 기능
	
- **Comment**
	- 댓글 생성
	- 댓글 삭제
	
- **Gallery**
	- 사진 업로드
	- 사진 삭제
	
- **Food Finder** (Kakao Map, RoadView API)
	- 검색을 통한 음식점 찾기
	- 음식점 지도에 표시
	- 음식점 로드뷰 표시
	
- **Chat** (Node.js 사용)
	- 홈페이지 접속자간 소켓통신을 활용한 실시간 채팅 기능
	
- Canvas (Node.js 사용)
	- 홈페이지 접속자간 그림그리기 및 실시간 공유 가능
	- 색깔 변경 가능
	
---

## Structure

### Frontend
![Frontend_JSP](https://user-images.githubusercontent.com/111879447/191286013-46f4e006-dce0-472f-aa0b-800fa52bb419.jpg)
![Frontend_CSS](https://user-images.githubusercontent.com/111879447/191286035-f7dc2dd6-0b44-4631-88e9-f06c339d18b8.jpg)
![Frontend_JS](https://user-images.githubusercontent.com/111879447/191286025-ec0e59ea-583d-4259-892a-67e865fd4977.jpg)

### Backend
![Backend](https://user-images.githubusercontent.com/111879447/191287020-78b2e5cb-bc04-44e3-8629-22647fc6a1d5.jpg)

### DataBase
![Database_Structure](https://user-images.githubusercontent.com/111879447/191286088-b612d174-8257-41da-aeb0-f8638a31a056.jpg)

---

## Time Line

> 2022.08.17

- Create Spring MVC + MyBatis(Oracle DB) Project
	- POST Request Parameter UTF-8 Encoding (web.xml)
	- 프로젝트에 필요한 라이브러리 Maven 이용하여 Import (pom.xml)
	- Create MemberMapper.java(interface)
	- Create memberMapper.xml
	- Connect Oracle DB
- Index Page Design
	- 'index.jsp' Layout Design
- Join Page Design
	- 'join.jsp' Layout Design
	- Form Design
	- Join Form Validation Check
- Member
	- Join Form 에서 입력된 값 서버로 받아오기
		(ID, PW, Name, Birthday, Address, Profile Photo)

> 2022.08.18

- Member
	- Create Member DB Table
	- Connect Member DB Table
	- Create Join(Membership) Function (INSERT)
- Login
	- Login Layout Design
	- Login Validation Check
	- Connect Member DB Table
	- Create Login Function (SELECT)
	- 로그인 후 로그인 Form 있던 자리에 표시될 프로필 사진, 회원 정보, 로그아웃 버튼 Design
	- Create Logout Function

> 2022.08.19

- Member
	- 회원 정보 수정 기능 추가
	- 회원 정보 수정 Validation Check
	- 회원 탈퇴 기능 추가
- Board
	- Board Page Design

> 2022.08.23

- Board
	- Page 기능 추가
	- 검색 기능 추가
	- Token 방식을 활용한 새로고침 글 중복 생성 방지
	- Detail View Design (클릭한 글 보여주기, 댓글(추가 예정))
- Login
	- Change Login Form Animation & Design

> 2022.08.24

- Board
	- 글 삭제 기능 추가
	- 글 수정 페이지 Design
	- 글 수정 기능 추가
	- 댓글 Table Design
- Comment
	- Create Comment DB Table
	- Connect Comment DB Table
	- 댓글 작성 기능 추가
	- 글 Detail 페이지에서 댓글 보여주기 기능 추가
	- Token 방식을 활용한 새로고침 댓글 중복 생성 방지

> 2022.08.25

- Comment
	- Board의 댓글 삭제 기능 추가
- Total
	- 전체 디자인 수정

> 2022.08.26

- Gallery
	- Gallery Design
	- Create Gallery DB Table
	- Connect Gallery DB Table
	- Photo Upload 기능 추가
	- Token 방식을 활용한 새로고침 사진 업로드 중복 방지

> 2022.08.27

- Gallery
	- 사진 삭제 기능 추가
		- Problem : 파라메터 조작을 통해 타인이 업로드한 사진을 무단 삭제 가능하다는
			문제점을 인지하여, 다음과 같이 처리
			1) Delete 버튼을 작성자에게만 보여지도록 수정
			2) 글 번호를 조회하여 현재 로그인 된 유저의 아이디와 삭제 요청된 글 작성자의
			   아이디를 매칭하여 동일한 경우 삭제될 수 있도록 수정
	- Upload Validation Check
		- 내용이 비어있거나, 사진 파일이 아닌 경우 업로드 불가
	- Delete 버튼 클릭 시 한번 다시 묻기

> 2022.08.29

- Member
	-  '/member.get' 페이지로 요청 시 회원의 DB 정보를 JSON 형태로 만들어 응답,
	  회원 가입 시 JQuery를 사용하여 회원 정보를 가져온 후에 가입하고자 하는 아이디가
	  이미 가입된 아이디인지 판단하여 가입된 아이디라면 텍스트 색깔이 빨간색으로 변경되어
	  경고를 주는 Event를 구현
	- Daum Address API를 사용하여 회원가입 시 주소 입력 편의성 증진
- Food Finder
	- Kakao REST API(Map, RoadView)를 사용하여, 지역/ 카테고리를 입력하면 가게 리스트를
	  보여준 뒤 클릭하면 Map에 위치를 표시하고 RoadView를 보여주는 기능 추가
		- Problem : 가게를 클릭하여 위치가 변경되면 RoadView가 제대로 표시되지 않는
		  문제가 발생하여 추후 해결 예정

> 2022.08.30

- Chat
	- Node.js Server를 구축, 소켓 프로그래밍을 사용하여 사이트에 접속된 유저끼리 실시간 
	  채팅할 수 있는 간단한 기능 구현
- Canvas
	- Node.js Server를 구축, 소켓 프로그래밍을 사용하여 사이트에 접속된 유저끼리 캔버스에
	  그림을 그리고 그 정보를 실시간으로 공유할 수 있도록 그림판 기능 구현

> 2022.08.31

- Food Finder
	- Problem Solved : RoadView가 제대로 표시되지 않는 문제가 발생
		- RoadViewClient Function을 다른 함수에서도 사용하기 위해 전역 함수로 변경했었는데,
		  Function 내에서 전역 함수를 읽어내지 못하는 오류 발생으로 추정.
		  (오류 원인 정확하게 파악 예정)

---

<center>1차 완성</center>

---

## Learn

- Spring의 대한 전반적인 이해 및 웹 제작에 대한 흐름 파악
	- MVC Pattern을 경험하며 분업의 이해와 필요성 파악
	- Servelt에서 불편했던 요소(분업의 어려움, Controller 관리의 불편함, ...)의 
	   해결로 인한 편의성 이해
	- Mybatis 사용을 통한 DB 다루기 및 관리의 편의성 이해
	- Maven 사용을 통한 라이브러리 사용 편의성 이해
	  
- HTTP 통신에 대한 흐름 이해
	- Request, Response 활용에 대한 이해
	- HTTP Method(GET, POST, ...) 활용에 대한 이해
	- Cookie와 Session의 차이에 대한 이해
	  
- Database
	- Oracle DB의 Query를 다루며 CRUD에 대한 이해와 활용
	- Primary Key와 Foreign Key를 이용한 RDBMS의 활용
	- Query를 활용한 Page 및 Search 기능 구현
	  
- JavaScript
	- Event 사용을 통한 Animation 구현
	- REST API를 사용하여 편리한 기능 구현
	- Server에 부담을 주지 않는 Frontend에서의 Validation Check 구현
	- GET 방식 요청 활용
	
- Node JS
	- Socket 통신에 대한 이해
	- Node JS의 편의성 이해
	
---

### Comment

	먼저, 개인 토이프로젝트를 진행해보며 WEB 에 많은 흥미를 느꼈고, 더 디테일한 기능 구현과
	더욱 철저한 보안이 필요하다는 생각이 들었다.
	
	여러 툴을 이용한 더욱 세련된 디자인을 구현해보고 싶다는 욕심이 생겼다.
	이번 프로젝트는 Spring의 전반적인 이해를 목적으로 제작하여 디자인에 시간 투자를 줄였지만
	그로 인해 완성도나 성취감에 대해 약간 아쉬움을 남겼다.
	
	Canvas나 Chat 기능을 구현하며 사용해본 Node JS는 굉장히 간편하다는 느낌을 받았다.
	빠른 기능 구현이나 변화에 유용할 것 같다.
	
	다음 프로젝트는 조금 더 완성도 있고 목적 있는 서비스를 구현해보는 것, 개인이 아닌
	단체로 프로젝트를 진행해보는 것이 목표이다.
	
	블록체인(이더리움)을 통해 보안을 강화한 로그인 기능을 구현해보려 했으나, 블록체인에 대한
	이해 부족으로 인해 미구현 상태이다.
	이해가 된다면 이후 이 프로젝트에 추가하여 테스트 해 볼 예정이다.

---
