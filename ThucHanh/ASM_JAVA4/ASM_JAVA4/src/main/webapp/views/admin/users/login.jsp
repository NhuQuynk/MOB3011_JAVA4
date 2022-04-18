<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="/ASM_JAVA4/css/bootstrap.min.css"></link>
<body>
	<div class="container">
		<div class="col-md-5 offset-4">
			<div class="card">
				<div class="card-header text-center">Login</div>
				<div class="card-body">
					<form action="/ASM_JAVA4/login" method="post">
						<div class="row mb-3">
							<label>Email</label>
							<div class="col p-0">
								<input class="form-control" type="text" name="email">
							</div>
						</div>
						<div class="row mb-3">
							<label>Password</label>
							<div class="col p-0">
								<input class="form-control" type="password" name="password">
							</div>
						</div>
				</div>

				<div class="card-footer text-center">
					<button class="btn btn-primary">Dang Nhap</button>
					</form>
				</div>
			</div>

		</div>
	</div>

	<script src="/ASM_JAVA4/js/jquery.min.js"></script>
	<script src="/ASM_JAVA4/js/popper.min.js"></script>
	<script src="/ASM_JAVA4/js/bootstrap.min.js"></script>

</body>
</html>