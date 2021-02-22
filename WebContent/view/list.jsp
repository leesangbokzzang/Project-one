<%@page import="java.util.List"%>
<%@page import="pjt.one.com.vo.BoardListVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
<link rel="stylesheet" href="css/import.css" />
<style></style>
<script>
	$(function() {

	});
</script>
</head>
<body>
	<form action="" method="POST">
		<table>
			<caption>
				<!-- 캡션 추가는 했는데 stylesheet에서 안보이게 설정되어 있네요, 일단 그냥 뒀음 -->
				<h2>게시판 페이지</h2>
			</caption>
			<tr>
				<th style="text-align: left;" colspan="5">BOARD <!-- 새글쓰기 버튼 추가, CMD는 BOARDWRITE -->
					<input type="button" style="float: right" value="글쓰기"
					onclick="location.href='/board?cmd=BOARDWRITE'" /></th>
					<!-- 새글쓰기 CMD명 BOARDWRITE -->
			</tr>
			<tr>
				<th>글번호</th>
				<th>글제목</th>
				<th>작성일</th>
				<th>작성자</th>
				<th>조회수</th>
			</tr>
			<c:forEach var="board" items="${requestScope.boardList }">
				<tr>
					<td>${ board.IDX }</td>
					<!-- 게시글읽기 CMD명 BOARDREAD -->
					<td><a href="/board?cmd=BOARDREAD&IDX=${ board.IDX }">${ board.TITLE }</a></td>
					<td>${ board.REGDATE }</td>
					<td>${ board.USER_ID }</td>
					<td>${ board.READCOUNT }</td>
				</tr>
			</c:forEach>
			
		</table>
	</form>
</body>
</html>