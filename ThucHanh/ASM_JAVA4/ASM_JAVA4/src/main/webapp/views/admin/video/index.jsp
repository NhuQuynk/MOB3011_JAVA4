<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!--<c:if test="${ !empty sessionScope.error}">
	<div class=" alert alert-danger">${sessionScope.error}</div>
	<c:remove var="error" scope="session"></c:remove>
</c:if>
<c:if test="${ !empty sessionScope.message}">
	<div class=" alert alert-success">${sessionScope.message}</div>
	<c:remove var="message" scope="session"></c:remove>
</c:if>-->
<c:if test="${empty ds}">
	<p class="alert alert-warning">Không có dữ liệu</p>
</c:if>
<h5 class="text-warning text-decoration-underlin">Phim mới</h5>
<c:if test="${!empty ds}">
	<div class="row card">
		<div class="row">
			<c:forEach items="${ds}" var="obj">
			<div class="col-2 mb-3 mt-2">
				<div class="view overlay">
					<img
						src="${ pageContext.request.contextPath }/views/image/${ obj.poster }"
						class="card-img-top" alt="Card image card">
				</div>
				<div class="card-body text-center">
					<!--Category & Title-->
					<a class="navbar-brand" href="">
						<h6 class="card-text">${ obj.title }</h6>
					</a>
				</div>

			</div>
		</c:forEach>
		</div>
	</div>
	<nav class="mt-3 " aria-label="Page navigation example">
		<ul class="pagination justify-content-center ">
			<!--justify-content-center: căn giữa -->

			<li class="page-item"><a class="page-link" href="#">1</a></li>
			<li class="page-item"><a class="page-link" href="#">2</a></li>
			<li class="page-item"><a class="page-link" href="#">3</a></li>
			<c:if test="${ currentPage == 1 }">
				<li class="page-item"><a class="page-link" href="#"
					aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
				</a></li>
			</c:if>
		</ul>
	</nav>

</c:if>