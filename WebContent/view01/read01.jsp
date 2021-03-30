<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <style>
		.contHeight{height: 500px;}
		.contHeight > th {vertical-align: top;}	
		.contHeight > td {vertical-align: top;}	
	</style>
<%@include file="/layout/header.jsp" %>

<script>
	function commentOK(){
		var boardComment = $("#boardComment").val();
		if(boardComment == ""){
			alert("댓글의 내용을 작성하십시오.");
			return false;
		}else{
		$.ajax({
			url : '/board01?cmd=COMMENTINSERT',
			data : {
				idx : $("#commnt_idx").val(),
				user_id : $("#commnt_id").val(),
				boardComment : $("#boardComment").val()
			},
			type : 'POST',
			success : function(data){
				//댓글 보여주는 section 에서 새로고침해주고 쓴 댓글을 보여준다.
				window.location.reload();
			},
			error : function(xhr){
				xhr.status+", "+ xhr.statusText;
			}
		});
		}
	}
	function userMention(user){
		$("#boardComment").val("@"+user+" ");
		$("#boardComment").focus();
	}
</script>
	
<div class="sub-main-wrap">
        <div class="sub-container-wrap">
            <div class="sub-container">
            	<div class="btn-box">
            		<ul>
            			<li><a href="/board01?cmd=BOARDWRITEFORM" title="글쓰기">글쓰기</a></li>
            			<li><a href="/board01?cmd=FIRSTLIST" title="목록으로">목록으로</a></li>
            			<li><a href="/board01?cmd=EDIT&idx=${vo.getIDX()}" title="수정">수정</a></li>
            			<li><a href="/board01?cmd=DELETE&idx=${vo.getIDX()}" title="삭제">삭제</a></li>
            		</ul>
            	</div>
                <div class="sub-section-wrap main-dashboard">
                    <div>
                        <section>
                            <div class="section-tit">
                                <h3>자유게시판</h3>
                            </div>
                            <div class="table-wrap scro-y-auto">
                                <table class="table-type02">
                                    <caption>검토대기현황 테이블</caption>
                                    <colgroup>
                                        <col class="wp6">
                                        <col class="wauto">
                                        <col class="wp5">
                                        <col class="wp5">
                                    </colgroup>
                                    <tbody>
                                        <tr>
                                        	<th>제목</th>
                                        	<td>${requestScope.vo.getTITLE()}</td>
                                        	<th>조회수</th>
                                        	<td style="text-align:right">${requestScope.vo.getREADCOUNT()}</td>
                                        </tr>
                                        <tr class="contHeight">
                                        	<th>내용</th>
                                        	<td colspan="3">${requestScope.vo.getCONT()}</td>
                                        </tr>
                                        <tr>
                                        	<th>작성일자</th>
                                        	<td colspan="3">${requestScope.vo.getREGDATE()}</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                            <div class="section-tit">
                                <h3>댓글</h3>
                            </div>
                            <div class="table-wrap scro-y-auto">
                             <form action ="/board?cmd=WRITEPROC" id="boardWriteFm" method= "POST">
                                <table class="table-type02 freeBoard">
                                    <caption>글읽기 테이블</caption>
                                    <colgroup>
                                        <col class="wp6">
                                        <col class="wauto">
                                    </colgroup>
                                    <tbody>
                                    	<c:forEach var="coment" items="${commentList}">
                                    		<tr>
	                                    		<th><a href="javascript:userMention('${coment.getUser_id()}')"> ${coment.getUser_id()}</a></th>
											    <td colspan="5">${coment.getCont()} <span style="font-size:12px; color:#bdbdbd; float:right;"> - ${coment.getRegdate()}</span></td>
	                                    	</tr>
                                    	</c:forEach>
                                    </tbody>
                                </table>
                                </form>
                            </div>
                        </section>
                    </div>
                </div>
                <div class="sub-section-wrap main-dashboard">
                    <div>
                        <section>
                            <div class="section-tit">
                                <h3>댓글 쓰기</h3>
                            </div>
                            <div class="table-wrap scro-y-auto">
                             <form action ="/board?cmd=WRITEPROC" id="boardWriteFm" method= "POST">
                                <table class="table-type02 freeBoard">
                                    <caption>댓글 테이블</caption>
                                    <colgroup>
                                        <col class="wp8">
                                        <col class="wauto">
                                    </colgroup>
                                    <tbody>
                                    	<tr>
                                    		<th>${user_name}(${user_id})</th>
										    <td colspan="5">
										    	<input type="text" name="boardComment" id="boardComment" value=""/>
										    </td>
										    <input type="hidden" name="user_id" id="commnt_id" value="${sessionScope.user_id}"/>
										    <input type="hidden" name="idx" id="commnt_idx" value="${vo.getIDX()}"/>
                                    	</tr>
                                    	<tr>
                                    		<td colspan="2">
                                    			<div class="btn-box">
                                    				<ul>
                                    					<li><a href="javascript:commentOK()">OK</a></li>
                                    				</ul>
                                    			</div>
                                    		</td>
                                    	</tr>
                                    </tbody>
                                </table>
                                </form>
                            </div>
                        </section>
                    </div>
                </div>
            </div><!--//sub-container-->
        </div>
    </div><!--//sub-main-wrap-->
	
</body>
</html>	
	
	
	<!-- 
	파라미터전달 확인<br>
	idx : ${requestScope.vo.getIDX() }<br>
	title : ${requestScope.vo.getTITLE()}<br>
	regdate : ${requestScope.vo.getREGDATE()}<br>
	user_id : ${requestScope.vo.getUSER_ID()}<br>
	readcount : ${requestScope.vo.getREADCOUNT()}<br>
	cont : ${requestScope.vo.getCONT()}
	 -->
