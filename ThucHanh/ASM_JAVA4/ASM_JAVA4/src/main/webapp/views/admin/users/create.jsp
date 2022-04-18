<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<c:if test="${!empty sessionScope.error}">
	<div class=" alert alert-danger">${sessionScope.error}</div>
	<c:remove var="error" scope="session"></c:remove>
</c:if>

<form action="/ASM_JAVA4/users/store" method="post">
	<div class="col-sm-9 mb-3">
		<label>Họ và Tên</label> <input class="form-control" type="text"
			name="fullname">
	</div>

	<div class="col-sm-9 mb-3">
		<label>Email</label> <input class="form-control" type="email"
			name="email">
	</div>

	<div class="col-sm-9 mb-3">
		<label>Password</label> <input class="form-control" type="password"
			name="password">
	</div>
	<!-- <div class="form-input-group mt-4 mb-3">
		<label class="me-4">Vai trò</label> <input type="radio"
			class="form-check-input" name="role" value="true"> <label>Admin</label>
		<input type="radio" class="form-check-input" name="role" value="false"
			checked> <label>User</label>
	</div>  -->
	<button class="btn btn-success">Thêm</button>
	<button class="btn btn-danger" type="reset">Xóa form</button>
</form>