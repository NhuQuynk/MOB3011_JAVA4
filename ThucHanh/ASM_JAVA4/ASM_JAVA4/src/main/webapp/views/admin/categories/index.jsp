<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<c:if test="${ !empty sessionScope.error}">
	<div class=" alert alert-danger">${sessionScope.error}</div>
	<c:remove var="error" scope="session"></c:remove>
</c:if>
<c:if test="${ !empty sessionScope.message}">
	<div class=" alert alert-success">${sessionScope.message}</div>
	<c:remove var="message" scope="session"></c:remove>
</c:if>
<c:if test="${empty ds}">
	<p class="alert alert-warning">Không có dữ liệu</p>
</c:if>

<c:if test="${!empty ds}">
	<table class="table">
		<thead>
			<th>ID</th>
			<th>Tên</th>
			<th>Người tạo</th>
			<th colspan="2"></th>
		</thead>
		<tbody>
			<c:forEach items="${ds}" var="obj">
				<tr>
					<td>${obj.id}</td>
					<td>${obj.ten}</td>
					<td>${obj.user.fullname}</td>
					<td><a href="/ASM_JAVA4/categories/edit?id=${obj.id}"
						class="btn btn-primary">Cập nhật</a></td>
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
										<a href="/ASM_JAVA4/categories/delete?id=${obj.id}"
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
	<a class="btn btn-secondary" href="/ASM_JAVA4/categories/create">Thêm mới</a>

</c:if>