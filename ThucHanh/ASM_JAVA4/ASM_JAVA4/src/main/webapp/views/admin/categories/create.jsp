<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Category</title>
</head>
<body>
	<c:if test="${!empty sessionScope.error}">
		<div class=" alert alert-danger">${sessionScope.error}</div>
		<c:remove var="error" scope="session"></c:remove>
	</c:if>
	<div class="col-sm-9">

		<form method="POST"
			action="/ASM_JAVA4/categories/store">
			<div class="mb-3">
				<label>Tên thể loại</label> <input type="text" class="form-control"
					name="ten" />
			</div>
			<div class="mb-3">
				<label>Người tạo</label> <select class="form-control" name="user_id">
					<c:forEach items="${ ds }" var="obj">
						<option value="${ obj.id }">${ obj.fullname }</option>
					</c:forEach>
				</select>
			</div>

			<button class="btn btn-success">Thêm mới</button>
			<button class="btn btn-danger" type="reset">Xóa form</button>
		</form>
	</div>

</body>
</html>