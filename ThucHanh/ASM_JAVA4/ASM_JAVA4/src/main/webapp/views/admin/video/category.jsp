<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<c:if test="${empty dsC}">
	<p class="alert alert-warning">Không có dữ liệu</p>
</c:if>


<c:if test="${!empty dsC}">
<div class="card bg-light mb-3">
	<div class="text-white text-uppercase ">
			<c:forEach items="${dsC}" var="obj">
				<li class="list-group-item text-white " href="obj.ten"></li>
			</c:forEach>
	</div>
</div>
</c:if>