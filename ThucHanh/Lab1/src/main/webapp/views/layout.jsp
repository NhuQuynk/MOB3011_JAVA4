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
		<form method="POST" action="">
		<h2>THÊM MỚI SINH VIÊN</h2>
		<div>
			<label>Mã sinh viên</label>
			<input type="text" name="maSv" />
		</div>
		<div>
			<label>Họ tên</label>
			<input type="text" name="hoTen" />
		</div>
		<div>
			<label>Giới tính</label>
			<input type="radio" name="gioiTinh" value="1"/>
			<label>Nam</label>
			<input type="radio" name="gioiTinh" value="0"/>
			<label>Nữ</label>
		</div>
		<div>
			<label>Chuyên ngành</label>
			<select name="chuyenNganh">
				<option value="0">UDPM</option>
				<option value="1">TKDH</option>
				<option value="2">KSDL</option>
			</select>
		</div>
		<div>
			<label>SĐT</label>
			<input type="text" name="sdt" />
		</div>
		<div>
			<label>Email</label>
			<input type="text" name="email" />
		</div>
		<div>
			<label>Thời gian tạo</label>
			<input type="text" name="thoiGian" />
		</div>
		<button type="submit">Submit</button>
	</form>
	</div>
	
	<script src="/Lab1/js/jquery.min.js"></script>
	<script src="/Lab1/js/popper.min.js"></script>
	<script src="/Lab1/js/bootstrap.min.js"></script>
</body>
</html>