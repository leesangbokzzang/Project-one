<%@page import="java.util.List"%>
<%@page import="pjt.one.com.vo.BoardListVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String html ="";
List<BoardListVo> list = (List<BoardListVo>) request.getAttribute("boardlist");
for(int i=0;i<list.size();i++){
	BoardListVo vo = list.get(i);
	html += "<tr>";		
	html += "<td>" + vo.getIDX() + "</td>";		
	html += "<td>" + vo.getTITLE()	 + "</td>";		
	html += "<td>" + vo.getREADCOUNT() + "</td>";		
	html += "</tr>";		
}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
<link rel="stylesheet" href="css/import.css" />
<style></style>
<script>
	$(function(){
		
	});
</script>
</head>
<body>
	<h1>게시판페이지</h1>
	
	<%=html %>
</body>
</html>