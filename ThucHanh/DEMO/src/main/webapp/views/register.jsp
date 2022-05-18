<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IT16308 - Register</title>
</head>
<body>
	<form method="POST"
		action="/DEMO/register">
		<div>
			<label>Họ tên</label>
			<input type="text" name="hoTen" />
		</div>
		<div>
			<label>Địa chỉ</label>
			<input type="text" name="diaChi" />
		</div>
		<div>
			<label>Email</label>
			<input type="email" name="email" />
		</div>
		<div>
			<label>Password</label>
			<input type="password" name="password" />
		</div>
		<div>
			<label>SĐT</label>
			<input type="text" name="sdt" />
		</div>
		
		<div>
			<button>Đăng ký</button>
			<button type="reset">Xóa form</button>
		</div>
	</form>
</body>
</html>