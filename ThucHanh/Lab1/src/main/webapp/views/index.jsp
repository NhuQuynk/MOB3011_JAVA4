<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<c:if test="${ empty list }">
	<p class="alert alert-warning">Không có dữ liệu</p>
</c:if>
<c:if test="${ !empty list }">
	<table class="table">
		<thead>
			<th>Mã sv</th>
			<th>Họ tên</th>
			<th>Giới tính</th>
			<th>Chuyên ngành</th>
			<th>SĐT</th>
			<th>Email</th>
			<th>Thời gian tạo</th>
		</thead>
		<tbody>
			<c:forEach items="${ list }" var="obj">
				<tr>
					<td>${ obj.maSv }</td>
					<td>${ obj.hoTen }</td>
					<td>
						<c:choose>
							<c:when test="${ obj.gioiTinh == 1 }">Nam</c:when>
							<c:when test="${ obj.gioiTinh == 0 }">Nữ</c:when>
							<c:otherwise> - </c:otherwise>
						</c:choose>
					</td>
					<td>
						<c:choose>
							<c:when test="${ obj.chuyenNganh == 0 }">UDPM</c:when>
							<c:when test="${ obj.chuyenNganh == 1 }">TKDH</c:when>
							<c:when test="${ obj.chuyenNganh == 2 }">KSDL</c:when>
							<c:otherwise>-</c:otherwise>
						</c:choose>
					</td>
					<td>${ obj.sdt }</td>
					<td>${ obj.email }</td>
					<td>${ obj.thoiGian }</td>
					
					
				</tr>
			</c:forEach>
		</tbody>
	</table>

</c:if>