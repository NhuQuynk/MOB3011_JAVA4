<%@ page language="java" session="true" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<c:if test="${ !empty sessionScope.error }">
	<div class="alert alert-danger">
		${ sessionScope.error }
	</div>
	<c:remove var="error" scope="session"></c:remove>
</c:if>
<c:if test="${ !empty sessionScope.message }">
	<div class="alert alert-success">
		${ sessionScope.message }
	</div>
	<c:remove var="message" scope="session"></c:remove>
</c:if>
<c:if test="${ empty ds }">
	<p class="alert alert-warning">Không có dữ liệu</p>
</c:if>
<form method="POST"
		action="/DEMO/users/store">
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
			<button>Thêm mới</button>
			<button type="reset">Xóa form</button>
		</div>
	</form>