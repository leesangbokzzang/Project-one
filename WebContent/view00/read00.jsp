<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <style>
		.contHeight{height: 500px;}
		.contHeight > th {vertical-align: top;}	
		.contHeight > td {vertical-align: top;}	
</style>
<%@include file="/layout/header.jsp" %>

	<%-- <table>
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
				<input type="button" name="edit" value="글수정" onclick="location.href='/board00?cmd=EDIT'" />
															<!-- 글삭제 CMD명 DELETE -->
				<input type="button" name="delete" value="글삭제" onclick="location.href='/board00?cmd=DELETE'" />
			</td>
		</tr>
	</table> --%>
	
<div class="sub-main-wrap">
        <div class="sub-container-wrap">
            <div class="sub-container">
            	<div class="btn-box">
            		<ul>
            			<li><a href="/board00?cmd=BOARDWRITEFORM" title="글쓰기">글쓰기</a></li>
            			<li><a href="/board00?cmd=FIRSTLIST" title="목록으로">목록으로</a></li>
            			<li><a href="/board00?cmd=EDIT&idx=${vo.getIDX()}" title="수정">수정</a></li>
            			<li><a href="/board00?cmd=DELETE&idx=${vo.getIDX()}" title="삭제">삭제</a></li>
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
