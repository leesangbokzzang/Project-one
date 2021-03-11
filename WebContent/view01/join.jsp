<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.red {color : red; font-size: 0.5rem;}
.blue {color : blue; font-size: 0.5rem;}
.btnSubmit{
    font-size: 15px;
    display: block;
    padding: 7px 17px;
    color: #fff;
    background-color: #325694;
    border-radius: 6px;
}
.sub-section-wrap1 {/* height:100%; */ width:40%; margin:0 auto;}
</style>
<link rel="stylesheet" href="css/import.css"/>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	$(function() {
		$('#in_id').keyup(function() { // idcheck 서블릿으로 정보 넘기기
			if ($('#in_id').val().length >= 4) {
				var in_id = $(this).val();
				$.ajax({
					url : '/idcheck',
					data : {
						in_id : in_id
					},
					type : 'POST',
					//리턴받은 result값 html에 뿌리기
					success : function(result) {
						if (result == "true") {
							$("#id_check").html(result);
						} else {
							$("#id_check").html(result);
						}
					}
				});
			};
		});//id keyup 이벤트 끝
		$('#in_pw').keyup(function() { // pwcheck 서블릿으로 정보 넘기기
			if ($('#in_pw').val().length >= 8) {
				var in_pw = $(this).val();
				$.ajax({
					url : '/pwcheck',
					data : {
						in_pw : in_pw
					},
					type : 'POST',
					//리턴받은 result값 html에 뿌리기
					success : function(result) {
						if (result == "true") {
							$("#pw_check").html(result);
						} else {
							$("#pw_check").html(result);
						}
					}
				});
			};
		}); // pw keyup 이벤트 끝
		$('#in_pw_cf').keyup(function() { // pwcheck 서블릿으로 정보 넘기기
			if ($('#in_pw_cf').val().length >= 8) {
				var in_pw = $('#in_pw').val();
				var in_pw_cf = $(this).val();
				$.ajax({
					url : '/pwconfirm',
					data : {
						in_pw : in_pw,
						in_pw_cf : in_pw_cf
					},
					type : 'POST',
					//리턴받은 result값 html에 뿌리기
					success : function(result) {
						$("#pw_check_cf").html(result);
					}
				});
			};
		});// pw check key up 이벤트 끝
		$('#in_name').keyup(function(){
			if($('#in_name').val().length>0){
				$('#name_check').children().eq(0).attr('class','blue');
				$('#name_check').children().eq(0).empty();
			}
			if($('#in_name').val().length==0){
				$('#name_check').children().eq(0).attr('class','red');
				$('#name_check').children().eq(0).html('필수입력');
			}
		});
		$("#in_tel").change(function() { // 전화번호 국번 선택
			//alert($(this).val()); 값 확인
			if ($("#in_tel").val() == "기타") { // 기타 일 때 직접입력
				$("#telbox1").val('');
				$("#telbox1").attr("readonly", false);
				$("#telbox1").focus();
			} else { // 그 외 번호 fill-in 하고 read only
				$("#telbox1").val($("#in_tel").val());
				$("#telbox1").attr("readonly", true);
				$("#telbox2").focus();
			}
		});
		$('#in_addr1').focusout(function(){
			if($('#in_addr1').val().length>0){
				$('#addr_check').children().eq(0).attr('class','blue');
				$('#addr_check').children().eq(0).empty();
			}
			if($('#in_addr1').val().length==0){
				$('#addr_check').children().eq(0).attr('class','red');
				$('#addr_check').children().eq(0).html('필수입력');
			}
		});
		$('#addr,#in_addr1').on('click', function() { // 우편번호 찾기 클릭 (daum api 감사합니다)
			new daum.Postcode({
				oncomplete : function(data) {
					//alert(data.zonecode); 값불러오기 확인
					$('#in_addr1').val(data.zonecode + ' ' + data.address);
					$('#in_addr1').attr("readonly", true);
					$('#in_addr2').val(data.buildingName);
					$('#in_addr1').focus();
				}
			}).open();
		});
		$("#emailselect").change(function() { // 이메일 선택
			//alert($(this).val()); 값 확인
			if ($("#emailselect").val() == "직접입력") { // 직접입력
				$("#in_email2").val('');
				$("#in_email2").attr("readonly", false);
				$("#in_email1").focus();
			} else { // 그 외 항목 fill-in 하고 read only
				$("#in_email2").val($("#emailselect").val());
				$("#in_email2").attr("readonly", true);
				$("#in_email1").focus();
			}
		});
		$('#in_email1,#in_email2').focusout(function() { //이메일 정규식
			var in_email1 = $('#in_email1').val();
			var in_email2 = $('#in_email2').val();
			$.ajax({
				url : '/emailcheck',
				data : {
					in_email1 : in_email1,
					in_email2 : in_email2
				},
				type : 'POST',
				//리턴받은 result값 html에 뿌리기
				success : function(result) {
					$("#email_check").html(result);
				}
			});
		});
		$("form").on("submit",function(){	//submit 시 부적합하면 포커싱
			if($('#id_check').children().attr('class')=='red'||$('#in_id').val().length==0){
				$('#in_id').focus();
				return false;
			}
			if($('#pw_check').children().attr('class')=='red'||$('#in_pw').val().length==0){
				$('#in_pw').focus();
				return false;
			}
			if($('#pw_check_cf').children().attr('class')=='red'||$('#in_pw_cf').val().length==0){
				$('#in_pw_cf').focus();
				return false;
			}
			if($('#email_check').children().attr('class')=='red'){
				$('#in_email1').focus();
				return false;
			}
			if($('#in_name').val().length==0){
				$('#in_name').focus();
				return false;
			}
			if($('#telbox1').val().length==0||$('#telbox2').val().length==0||$('#telbox3').val().length==0){
				$('#telbox2').focus();
				return false;
			}
			if($('#in_addr1').val().length==0){
				$('#in_addr1').focus();
				return false;
			}
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
								<h3>회원가입</h3>
							</div>
							<div class="table-wrap scro-y-auto hp44">
								<form action="/user?cmd=JOIN" method="POST" autocomplete=off id="userForm">
									<table class="table-type02 freeBoard">
										<caption>회원가입 테이블</caption>
										<colgroup>
											<col class="wp25">
											<col class="wauto">
										</colgroup>
										<caption>
											<h2>회원가입</h2>
										</caption>
										<tr>
											<th>아이디</th>
											<td><input type="text" name="in_id" id="in_id" class="wp50"/>
											<br><span id="id_check" required><b class="red">필수입력</b></span>
											</td>
											
											
										</tr>
										<tr>
											<th>비밀번호</th>
											<td><input type="password" name="in_pw" id="in_pw" class="wp50"/>
											<br><span id="pw_check"><b class="red">필수입력</b></span>
											</td>
											
										</tr>
										<tr>
											<th>비밀번호 확인</th>
											<td><input type="password" name="in_pw_cf" id="in_pw_cf" class="wp50"/>
											<br><span id="pw_check_cf"><b class="red">필수입력</b></span>
											</td>
										</tr>
										<tr>
											<th>이름</th>
											<td><input type="text" name="in_name" id="in_name" class="wp50"/>
											<br><span id="name_check"><b class="red">필수입력</b></span>
											</td>
										</tr>
										<tr>
											<th>성별</th>
											<td><input type="radio" name="in_gender" value="남자"
												checked="checked" />남자 <input type="radio" name="in_gender"
												value="여자" />여자</td>
										</tr>
										<tr>
											<th>전화번호</th>
											<td><select name="in_tel" id="in_tel">
													<option value="" selected="selected">-</option>
													<option value="010">010</option>
													<option value="011">011</option>
													<option value="016">016</option>
													<option value="017">017</option>
													<option value="019">019</option>
													<option value="070">070</option>
													<option value="기타">기타</option>
											</select> <input type="text" id="telbox1" name="telbox1"
												maxlength="8" class="wp20" readonly />- <input type="text" id="telbox2"
												name="telbox2" class="wp20" maxlength="4"
												onKeyup="this.value=this.value.replace(/[^0-9]/g,'');" />- <input
												type="text" id="telbox3" name="telbox3" class="wp20"
												maxlength="4"
												onKeyup="this.value=this.value.replace(/[^0-9]/g,'');" /></td>
										</tr>
										<tr>
											<th>주소</th>
											<td><input type="text" name="in_addr1" id="in_addr1" class="wp65"/>
											<br><span id="addr_check"><b class="red">필수입력</b></span>
												<div class="btn-box" style="float:right">
													<ul>
														<li><a href="#" id="addr">우편번호</a></li>
													</ul>
												</div>
											</td>
										</tr>
										<tr>
											<th></th>
											<td><input type="text" name="in_addr2" id="in_addr2"
												class="wp100" placeholder="상세주소" /></td>
										</tr>
										<tr>
											<th>이메일</th>
											<td><input type="text" name="in_email1" id="in_email1"
												class="wp30" />@ <input type="text" name="in_email2"
												id="in_email2" class="wp30" /> <select name="emailselect"
												id="emailselect" class="wp30">
													<option value="직접입력" selected="selected">직접입력</option>
													<option value="naver.com">네이버</option>
													<option value="daum.net">다음(한메일)</option>
													<option value="gmail.com">구글</option>
													<option value="nate.com">네이트</option>
													<option value="hotmail.com">핫메일</option>
											</select>
											<br><span id="email_check"><b class="red">필수입력</b></span>
											</td>

										</tr>
										<tr>
											<td colspan="3">
											<input type="submit" class="btnSubmit" value="가입" /></td>
										</tr>


									</table>
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