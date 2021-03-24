<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String user_name = (String)session.getAttribute("user_name"); 
	//object테이터타입이기에 명시적형변환으로 (String)을 해줘야한다.
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/import.css"/>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
<style>
.black{color:#333 !important; font-size:13px;}
</style>
<script>
	$(document).ready(function() {
		//User
		$(".user-info-txt").click(function() {
			$(".user-info").toggle();
		});
		$(".user-info").mouseleave(function() {
			$(this).hide();
		});
		/* if('${user_name}'!=''){
		alert('${user_name}'+'님 반갑습니다');
		}; */
	});
</script>
</head>
<body>
<div class="header">
		<h1 class="logo"><a href="/board01?cmd=LIST" style="color: #fff">404 Team</a></h1>
		<c:choose>
				<c:when test="${empty sessionScope.user_id}">
					<ul>
						<li><a href="/board00?cmd=FIRSTLIST" title="게시판">게시판00</a></li>
						<li><a href="/board01?cmd=FIRSTLIST" title="게시판">게시판01</a></li>
						<li><a href="/board02?cmd=FIRSTLIST" title="게시판">게시판02</a></li>
						<li><a href="/user?cmd=JOINFORM" title="회원가입">회원가입</a></li>
						<li><a href="/user?cmd=LOGINFORM" title="로그인">로그인</a></li>
					</ul>
				</c:when>
				<c:otherwise>
					<ul>
						<li><a href="/board00?cmd=FIRSTLIST" title="게시판">게시판00</a></li>
						<li><a href="/board01?cmd=FIRSTLIST" title="게시판">게시판01</a></li>
						<li><a href="/board02?cmd=FIRSTLIST" title="게시판">게시판02</a></li>
						<li><a href="/act/Getpapago.html" >번역기(한>중)</a></li>
					</ul>
					<div class="user-wrap">
			               <div class="user-info-txt">
			                   <ul>
			                       <li class="user-name">${user_name}<span>님</span></li>
			                   </ul>
			               </div>
			               <div class="user-info">
			                   <div class="user-img">
			                       <a href="#" title="사용자 정보 더보기" class="user-open">
			                      <!--      <img src="img/girl-img.png" alt="사용자 이미지"> -->
			                       </a>
			                   </div>
			                   <p class="user-name">${user_name}</p>
			                   <p class="user-access">${accessTime}</p>
			                   <ul class="user-logout">
			                       <li><a href="/user?cmd=USERINFOUPDATE" title="회원정보수정" class="black">내정보</a></li>
			                       <li><a href="/user?cmd=LOGOUT" title="로그아웃" class="black">로그아웃</a></li>
			                   </ul>
			               </div>
			           </div>
				</c:otherwise>
			</c:choose>
</div>