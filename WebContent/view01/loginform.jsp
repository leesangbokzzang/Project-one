<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	Cookie[] cookies = request.getCookies();
	String idsave = "";
    for(Cookie cookie:cookies){
    	System.out.println("쿠키명 : "+cookie.getName());
    	System.out.println("쿠키값 : "+cookie.getValue());
    }
    if(cookies.length>0){
    idsave = cookies[0].getValue();
    } 

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.sub-section-wrap1 {/* height:100%; */ width:25%; margin:0 auto;}
.btnSubmit{
    font-size: 15px;
    display: inline-flex;
    padding: 7px 17px;
    color: #fff;
    background-color: #325694;
    border-radius: 6px;
    margin : 0 auto;
}
</style>
<link rel="stylesheet" href="css/import.css"/>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
	$(function(){
		$('#cancel').on('click',function(){
			history.back();
		});
	});
</script>
</head>
<body>
	<div class="sub-main-wrap">
		<div class="sub-container-wrap">
			<div class="sub-container">
				<div class="sub-section-wrap1 join-section">
					<div>
						<section>
							<div class="section-tit">
								<h3>회원 로그인</h3>
							</div>
							<div class="table-wrap scro-y-auto hp44">
								<form action="/user?cmd=LOGIN" method="POST" autocomplete=off id="userForm">
								<input type="hidden" name="referer" value="${referer }" />
								<table class="table-type02 freeBoard">
										<caption>로그인 테이블</caption>
										<colgroup>
											<col class="wp25">
											<col class="wauto">
										</colgroup>
										<caption>
											<h2>로그인</h2>
										</caption>
										<tr>
											<th>아이디</th><td><input type="text" name="in_id" class="wp70" value="<%=idsave%>"></td>
										</tr>
										<tr>
											<th>비밀번호</th><td><input type="password" name="in_pw" class="wp70"></td>
										</tr>
										<tr>
										<c:set var="idsave" value="<%=idsave %>" />
										<c:choose>
										<c:when test="${idsave eq ''}">
											<td colspan="2"><input type="checkbox" id="idrmb" name="idrmb"/> <b class="blue"> 아이디 기억하기</b></td>
										</c:when>
										<c:otherwise>
											<td colspan="2"><input type="checkbox" id="idrmb" name="idrmb" checked="checked"/> <b class="blue"> 아이디 기억하기</b></td>
										</c:otherwise>
										</c:choose>
										</tr>
										<tr>
											<td colspan="2">
											<input type="submit" class="btnSubmit" value="로그인" />
											<input type="button" id="cancel" class="btnSubmit" value="취소">
											</td>
										</tr>
								</form>
							</div>
						</section>
					</div>
				</div>
			</div>
			<!--//sub-container-->
		</div>
	</div>
	<!--//sub-main-wrap-->
</body>
</html>