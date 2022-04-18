<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<c:if test="${ !empty sessionScope.error}">
		<div class=" alert alert-danger">${sessionScope.error}</div>
		<c:remove var="error" scope="session"></c:remove>
	</c:if>
	<c:if test="${ !empty sessionScope.message}">
		<div class=" alert alert-success">${sessionScope.message}</div>
		<c:remove var="message" scope="session"></c:remove>
	</c:if>

	<form action="/ASM_JAVA4/video/store" method="post"
		enctype="multiart / form-data">
		<div class="col-sm-9 mb-3">
			<div class="col-md-4">
				<label>Tên phim: </label>
			</div>
			<div class="col-md-8">
				<input class="form-control" type="text" name="title">
			</div>
		</div>
</body>
</html>

<div class="col-sm-9 mb-3">
	<div class="col-md-4">
		<label>Poster: </label>
	</div>
	<div class="col-md-8">
		<input type="file" name="poster">
	</div>
</div>
<div class="col-sm-9 mb-3">
	<div class="col-md-4">
		<label>Mô tả: </label>
	</div>
	<div class="col-md-8">
		<input class="form-control" type="text" name="description">
	</div>
</div>
<div class="col-sm-9 mb-3">
	<div class="col-md-4">
		<label>Lượt xem: </label>
	</div>
	<div class="col-md-8">
		<input class="form-control" type="number" name="views">
	</div>
</div>

<div class="col-sm-9 mb-3">
	<div class="col-md-4">
		<label>Thể loại</label> 
	</div>
	<div class="col-md-8">
		<select class="form-control" name="category_id">
			<c:forEach items="${ dsC }" var="obj">
				<option value="${ obj.id }">${ obj.id }</option>
			</c:forEach>
		</select>
	</div>
</div>



<button class="btn btn-success">Thêm mới</button>
<button class="btn btn-danger" type="reset">Xóa form</button>

</form>
<c:if test="${empty dsV}">
	<p class="alert alert-warning">Không có dữ liệu</p>
</c:if>

<c:if test="${!empty dsV}">
	<table class="table">
		<thead>
			<tr>
			<th>Tên phim</th>
			<th>Poster</th>
			<th>Mô tả</th>
			<th>Lượt xem</th>
			<th>Thể loại</th>
			<th colspan="2"></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${dsV}" var="obj">
				<tr>
					<td>${obj.title}</td>
					<td><img
						src="${ pageContext.request.contextPath }/views/image/${ obj.poster }"
						class="card-img-top" alt="Card image card" height="70px"></td>

					<td>${obj.description}</td>
					<td>${obj.views}</td>
					<td>${obj.category.id}</td>
					<td><a href="/ASM_JAVA4/video/edit?id=${obj.id}"
						class="btn btn-primary">Cập Nhật</a></td>
					<td>
						<!-- Button trigger modal --> <a data-bs-toggle="modal"
						data-bs-target="#exampleModal${obj.id }" class="btn btn-danger">Xóa</a>
						<div class="modal fade" id="exampleModal${obj.id }" tabindex="-1"
							aria-labelledby="exampleModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLabel">Thông báo</h5>
										<button type="button" class="btn-close"
											data-bs-dismiss="modal" aria-label="Close"></button>
									</div>
									<div class="modal-body">Bạn có muốn xóa không</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											data-bs-dismiss="modal">Đóng</button>
										<a href="/ASM_JAVA4/video/delete?id=${obj.id}"
											class="btn btn-danger">OK</a>
									</div>
								</div>
							</div>
						</div>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a class="btn btn-secondary" href="/ASM_JAVA4/users/create">Them
		moi</a>

</c:if>