<%@page import="java.util.List"%>
<%@page import="pjt.one.com.vo.BoardListVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!--@include 파일을 이어서 붙힘  -->
<%@include file="/layout/header.jsp" %>

<div class="sub-main-wrap">
        <div class="sub-container-wrap">
            <div class="sub-container">
            	<div class="btn-box">
            		<ul>
            			<li><a href="/board01?cmd=BOARDWRITEFORM" title="글쓰기">글쓰기</a></li>
            		</ul>
            	</div>
                <div class="sub-section-wrap main-dashboard">
                    <div>
                        <section>
                            <div class="section-tit">
                                <h3>자유게시판</h3>
                           <!--      <div class="btn-more">
                                    <ul>
                                        <li><a href="#" title=" 검토대기현황 더보기" class=""><img src="img/common/btn-more.png" alt="더보기"></a></li>
                                    </ul>
                                </div> -->
                            </div>
                            <div class="table-wrap scro-y-auto hp94">
                                <table class="table-type01 freeBoard">
                                    <caption>검토대기현황 테이블</caption>
                                    <colgroup>
                                        <col class="wp5">
                                        <col class="wauto">
                                        <col class="wp10">
                                        <col class="wp8">
                                        <col class="wp8">
                                    </colgroup>
                                    <thead>
                                        <tr>
                                            <th>글번호</th>
											<th>글제목</th>
											<th>작성일</th>
											<th>작성자</th>
											<th>조회수</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="board" items="${requestScope.boardList }">
											<tr>
												<td>${ board.IDX }</td>
												<!-- 게시글읽기 CMD명 BOARDREAD -->
												<td><a href="/board01?cmd=BOARDREAD&idx=${ board.IDX }">${ board.TITLE }</a></td>
												<td>${ board.REGDATE }</td>
												<td>${ board.USER_ID }</td>
												<td>${ board.READCOUNT }</td>
											</tr>
										</c:forEach>
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