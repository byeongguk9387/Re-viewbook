<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/header.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/reset.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/all.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/footer.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/main.css">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>ReviewBook</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
	<div id="main_wrap">
<%@ include file="./view/template_header.jsp" %>
		<div class="wrap content">
            <div id="content">
            </div>
		</div>
<%@ include file="./view/template_footer.jsp" %>
    </div>
</body>
</html>