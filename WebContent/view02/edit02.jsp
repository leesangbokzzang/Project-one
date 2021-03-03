<%@page import="java.util.List"%>
<%@page import="pjt.one.com.vo.BoardListVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/layout/header.jsp" %>
<script> 
	$(function(){
		var form = document.querySelector('form');
		
		form.onsubmit = function(e) {
			var title = document.querySelector('[name=title]');
			if(title.value==''){
				alert('제목을 입력하세요.')
				title.focus();
				return false;
			}else{}
			
			 var ta= document.querySelector('textarea');
			var txt = ta.value;
			if(txt.indexOf('<') >=0 ) {
				txt = txt.replace(/</gim, '&lt;');
				txt.focus();
				return false;
			}else if(txt.indexOf('>') >=0 ) {
				txt = txt.replace(/</gim, '&gt;');
				txt.focus();
				return false;
			}else{}
			 			
		}
		
		
	})
</script>
<!--@include 파일을 이어서 붙힘  -->

<div class="sub-main-wrap">
        <div class="sub-container-wrap">
            <div class="sub-container">
            	<!-- <div class="btn-box">
            		<ul>
            			<li><a href="/board02?cmd=BOARD" title="작성">작성</a></li>
            		</ul>
            	</div> -->
                <div class="sub-section-wrap main-dashboard">
                    <div>
                    	<div class="btn-box">
                                    <ul>
                                        <li><a href="javascript:history.back();" title="취소">취소</a></li>
                                    </ul>
                                </div>
                        <section>
                            <div class="section-tit">
                                <h3>글 수정</h3>
                            </div>
                            <div class="table-wrap scro-y-auto hp94">
                             <form action ="/board02?cmd=BOARDUPDATE&idx=${listViewOne.getIDX()}" method="POST">
                                <table class="table-type02 freeBoard">
                                    <caption>글수정 테이블</caption>
                                    <colgroup>
                                        <col class="wp5">
                                        <col class="wauto">
                                    </colgroup>
                                    <tbody>
                                        <tr>
											 <th>제목</th>
											 <td><input type ="text" name="title" value="${listViewOne.getTITLE()}"></td>
										</tr>
										<tr>
											 <th>내용</th>
											 <td><textarea name="cont" rows="10" cols ="80" maxlwngth ="1000">${listViewOne.getCONT()} </textarea> </td>
										</tr>
										<tr>
											<td colspan="2">
												<input type = "submit" value="수정" />
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