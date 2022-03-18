<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lab1</title>
<link rel="stylesheet"
	href="/Lab1/css/bootstrap.min.css"/>
</head>
<body>
	<div class="container">
		<div class="table" style="height:200px ;">
			<jsp:include page="${ view }"></jsp:include>
		</div>
	</div>
	<script src="/Lab1/js/jquery.min.js"></script>
	<script src="/Lab1/js/popper.min.js"></script>
	<script src="/Lab1/js/bootstrap.min.js"></script>
</body>
</html>