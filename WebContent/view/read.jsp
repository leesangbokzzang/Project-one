<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style></style>
<link rel="stylesheet" href="css/import.css" />
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
	$(function(){

		});
</script>
</head>
<body>
	<table>
	<caption><h2>게시글 읽기 - ${requestScope.vo.getTITLE()}</h2></caption>
	<tr>
		<td>${requestScope.vo.getTITLE()}</td> <td>${requestScope.vo.getREGDATE()}</td>
		<td>${requestScope.vo.getUSER_ID()}</td> <td>${requestScope.vo.getREADCOUNT()}</td>
	</tr>
	<tr>
		<td colspan="4">${requestScope.vo.getCONT()}</td>
	</tr>
	<tr>
		<td colspan="4">
			<input type="button" name="list" value="목록으로" onclick="javascript:history.back()" />
														<!-- 글수정 CMD명 EDIT -->
			<input type="button" name="edit" value="글수정" onclick="location.href='/board?cmd=EDIT'" />
														<!-- 글삭제 CMD명 DELETE -->
			<input type="button" name="delete" value="글삭제" onclick="location.href='/board?cmd=DELETE'" />
		</td>
	</tr>
	</table>
	<!-- 
	파라미터전달 확인<br>
	idx : ${requestScope.vo.getIDX() }<br>
	title : ${requestScope.vo.getTITLE()}<br>
	regdate : ${requestScope.vo.getREGDATE()}<br>
	user_id : ${requestScope.vo.getUSER_ID()}<br>
	readcount : ${requestScope.vo.getREADCOUNT()}<br>
	cont : ${requestScope.vo.getCONT()}
	 -->
</body>
</html>