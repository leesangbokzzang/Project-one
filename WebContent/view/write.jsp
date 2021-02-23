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
				alert('제목없음')
				title.focus();
				return false;
			}else{}
			
			
			 var ta= document.querySelector('textarea');
			var txt = ta.value;
			if(txt.indexOf('<') >=0 ) {
				txt = txt.replace(/</gim, '&lt;');
				txt.focus();
				alert('그거 아니야')
				return false;
			}else if(txt.indexOf('>') >=0 ) {
				txt = txt.replace(/</gim, '&gt;');
				txt.focus();
				alert('그거 아니야')
				return false;
			}else{}
			
			console.log(txt);
			alert(txt);
			 			
		}
		
		
	})



</script>
<!--@include 파일을 이어서 붙힘  -->

<div class="sub-main-wrap">
        <div class="sub-container-wrap">
            <div class="sub-container">
            	<!-- <div class="btn-box">
            		<ul>
            			<li><a href="/board?cmd=BOARD" title="작성">작성</a></li>
            		</ul>
            	</div> -->
                <div class="sub-section-wrap main-dashboard">
                    <div>
                        <section>
                            <div class="section-tit">
                                <h3>새 글 쓰기</h3>
                           <!--      <div class="btn-more">
                                    <ul>
                                        <li><a href="#" title=" 검토대기현황 더보기" class=""><img src="img/common/btn-more.png" alt="더보기"></a></li>
                                    </ul>
                                </div> -->
                            </div>
                            <div class="table-wrap scro-y-auto hp94">
                             <form action ="/board?cmd=BOARDWRITE" method= "POST">
                                <table class="table-type02 freeBoard">
                                    <caption>검토대기현황 테이블</caption>
                                    <colgroup>
                                        <col class="wp5">
                                        <col class="wauto">
                                    </colgroup>
                                    <tbody>
                                        <tr>
											 <th>제목</th>
											 <td><input type ="text" name ="title" /></td>
										</tr>
										<tr>
											 <th>내용</th>
											 <td><textarea name="cont" rows="10" cols ="80" maxlwngth ="1000"> </textarea> </td>
										</tr>
										<tr>
											<td colspan="2">
												<input type = "submit" value="작성" />
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