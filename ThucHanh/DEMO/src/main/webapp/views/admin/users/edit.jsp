<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form method="POST"
		action="/DEMO/users/update?id=${ user.id }">
		<div>
			<label>Họ tên</label>
			<input type="text" name="hoTen" value="${ user.hoTen }" />
		</div>
		<div>
			<label>Địa chỉ</label>
			<input type="text" name="diaChi" value="${ user.diaChi }" />
		</div>
		<div>
			<label>Email</label>
			<input type="email" name="email" value="${ user.email }" />
		</div>

		
		<div>
			<label>SĐT</label>
			<input type="text" name="sdt" value="${ user.sdt }" />
		</div>
		
		<div>
			<button>Cập nhật</button>
			<button type="reset">Xóa form</button>
		</div>
	</form>