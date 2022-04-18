<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/ASM_JAVA4/css/bootstrap.min.css"></link>
</head>
<body>
	<div class="col-sm-6 offset-3">
		<form action="/ASM_JAVA4/users/update?id=${user.id}" method="post">
			<div class="col-sm-9 mb-3">
				<label>Họ và Tên</label> <input class="form-control" type="text"
					name="fullname" value="${user.fullname} ">
			</div>
			<div class="col-sm-9 mb-3">
				<label>Email</label> <input class="form-control" type="email"
					name="email" value="${user.email}">
			</div>
			<button class="btn btn-success">Cap Nhat</button>
			<button class="btn btn-danger" type="reset">Xóa form</button>
		</form>
	</div>

	<!--/.Footer-->
	<script src="/ASM_JAVA4/js/jquery.min.js"></script>
	<script src="/ASM_JAVA4/js/popper.min.js"></script>
	<script src="/ASM_JAVA4/js/bootstrap.min.js"></script>

</body>
</html>