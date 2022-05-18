<%@ page language="java" session="true" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <!-- Thêm session -->
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

<a class="btn btn-success" href="/DEMO/users/create">Thêm mới</a>
<c:if test="${ !empty ds }">
	<table class="table">
		<thead>
			<th>ID</th>
			<th>Họ tên</th>
			<th>Địa chỉ</th>
			<th>SĐT</th>
			<th>Email</th>
		<!-- <th>Password</th>  -->	
			<th colspan="2">Thao tác</th>
		</thead>
		<tbody>
			<c:forEach items="${ ds }" var="obj">
				<tr>
					<td>${ obj.id }</td>
					<td>${ obj.hoTen }</td>
					<td>${ obj.diaChi }</td>
					<td>${ obj.sdt }</td>
					<td>${ obj.email }</td>
					<!-- <td>${ obj.password }</td> -->
					<td >
						<a class="btn btn-primary"
						href="/DEMO/users/edit?id=${ obj.id }">
							Cập nhật
						</a>
					</td>
					<td >
						<a class="btn btn-danger"
						href="/DEMO/users/delete?id=${ obj.id }">
							Xóa
						</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</c:if>
