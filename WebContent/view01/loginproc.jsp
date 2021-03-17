<%@page import="pjt.one.com.vo.UserListVo"%>
<%@page import="pjt.one.com.dao.UserDao01"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String in_id = request.getParameter("in_id");
	String in_pw = request.getParameter("in_pw");
	UserDao01 userDao = new UserDao01();
	UserListVo userVo = userDao.loginCheck(in_id, in_pw);
	System.out.println(userVo);
	
	if(userVo.getUser_id().equals(in_id)) {
		//로그인 성공 시 (user_id)
		session.setAttribute("userVo", userVo);
		String path = "../index.jsp";
		response.sendRedirect(path);
		
	} else {
		//로그인 실패 시 (user_id + incorrect)
		String path = "";
		
	}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style></style>
<link rel="stylesheet" href="css/import.css"/>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
	
</script>
</head>
<body>

</body>
</html>