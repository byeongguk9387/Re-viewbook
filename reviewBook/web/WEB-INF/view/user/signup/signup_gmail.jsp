<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/signlogin/signupuser_second.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/all/header.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/all/reset.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/all/all.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/all/footer.css">

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RVB</title>
<script src="/resources/js/signlogin/js_signup.js"></script>
</head>
<body>
	<%@ include file="../../../view/template_header.jsp"%>
	<div class="signup_body2">
		<nav class="sidemenu">
			<ul class="sidemenu_signup2">
				<li><a class="sidemenu_item sidemenu_topmenu">회원가입</a></li>
				<li><a class="sidemenu_item">이메일 인증</a></li>
			</ul>
		</nav>
		<div class="signupuser_second_content">
			<form action="<%=request.getContextPath()%>/gmailsendaction"
				method="get">
				<table>
					<tr>
						<td class="signupuser_input_text">
							<p class="fontnormal signup_infoname">이메일</p>
						</td>
						<td class="signupuser_input_input"><input type="email"
							name="usEmail" class="signup_infoinput" id="usEmail"
							required="required"></td>
						<td class="signupuser_input_btn"><button type="submit"
								id="btn_email" class="signupinfo_emailcheck"
								onclick="winopen3()">
								<p class="fontnothing signup_infobtn">이메일 인증하기</p>
							</button></td>
					</tr>
					<!-- <tr>
						<td class="signupuser_input_text">
							<p class="fontnormal signup_infoname">인증번호</p>
						</td>
						<td class="signupuser_input_input"><input type="text"
							name="usEmail_chk" class="signup_infoinput" id="usEmail"
							required="required"></td>
						<td class="signupuser_input_btn"><button type="submit"
								id="btn_email_chk" class="signupinfo_emailcheck"
								onclick="winopen4()">
								<p class="fontnothing signup_infobtn">인증확인</p>
							</button></td>
					</tr> -->

				</table>
			</form>

		</div>
	</div>
	<%@ include file="../../../view/template_footer.jsp"%>
	<!-- <script>
		
		function winopen3() {
			window.open("gmailsendaction?usEmail="
					+ document.frmRegister.usEmail.value, "",
					"width=500, height=300")
		}
		function winopen4() {
			window.open("gmailcheckaction", "", "width=500, height=300")
		} 
	</script> -->
</body>
</html>