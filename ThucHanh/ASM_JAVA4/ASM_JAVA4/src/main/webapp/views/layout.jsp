<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ASM</title>
<link rel="stylesheet" href="/ASM_JAVA4/css/bootstrap.min.css" />

</head>

<body>
	<!-- PHẦN HEADER -->
	<div>
		<div
			style="position: sticky !important; top: 0px; z-index: 99999 !important;">
			<header class="row  header-responsive "
				style="background-color: white; height: 70px">
				<div class="col-2 mt-3 ">
					<a href="/ASM_JAVA4/video/index" class="ms-5"> <img
						src="https://cdn.gumac.vn/Content/Image/WebImage/logo_new.png"
						height="30px" width="160" alt="">
					</a>
				</div>
				<div class="col-8 mt-3">
					<form class="d-flex">
						<input class="form-control me-2" type="search" name="keyword"
							placeholder="Nhập từ khóa..." aria-label="Nhập nội dung tìm kiếm">
						<button class="btn btn-outline-success ms-2" type="submit" >Search</button>
					</form>
				</div>

				<div class="col-1 btn-group " style="background-color: white;">
					<button class="btn  btn-sm dropdown-toggle" type="button"
						data-bs-toggle="dropdown" aria-expanded="false">Tài khoản
					</button>
					<ul class="dropdown-menu">
						<li><a class="dropdown-item"
							href="/ASM_JAVA4/views/admin/users/login.jsp">Đăng nhập</a></li>
						<li><a class="dropdown-item" href="#">Đổi mật khẩu</a></li>
						<li><a class="dropdown-item" href="#">Quên mật khẩu</a></li>
						<li><a class="dropdown-item" href="/ASM_JAVA4/users/index">Quản
								lý tài khoản</a></li>
						<li><a class="dropdown-item" href="#">Đăng xuất</a></li>
					</ul>
				</div>
				<div class="col-1 btn-group  buttonn">
					<button class="btn  btn-sm dropdown-toggle" type="button"
						data-bs-toggle="dropdown" aria-expanded="false">Khác</button>
					<ul class="dropdown-menu">
						<li><a class="dropdown-item" href="#">Lịch sử xem</a></li>
						<li><a class="dropdown-item" href="/ASM_JAVA4/categories/index">Quản lý thể loại</a></li>
						<li><a class="dropdown-item" href="/ASM_JAVA4/video/create">Quản
								lý video</a></li>
					</ul>
				</div>
			</header>
			<!-- PHẦN NAV -->
			<nav class="row  bg-secondary">
				<marquee direction="left" behavior="scroll">
					<h5 class="text-warning">Xem phim lẻ full HD, tổng hợp Phim lẻ
						hay nhất 2022 tại GUMAC</h5>
				</marquee>
			</nav>
		</div>
		<!-- PHẦN ASIDE VÀ ARTICLE -->
		<div class="container">
			<jsp:include page="${ view }"></jsp:include>
		</div>
		<!-- PHẦN FOOTER -->
		<div class="row text-center p-2 mt-3">
			<footer class="bg-secondary">
				<div class="container">
					<div class="row">
						<div class="col-4 ">
							<p class="title text-warning mt-3">Phim lẻ</p>
							<div>
								<a href="#" class="text-dark">Phim hành động</a>
							</div>
							<div>
								<a href="https://247phim.com/phim/phim-le/kiem-hiep"
									class="text-dark">Phim kiếm hiệp</a>
							</div>
							<div>
								<a href="https://247phim.com/phim/phim-le/kinh-di"
									class="text-dark">Phim kinh dị</a>
							</div>
							<div>
								<a href="https://247phim.com/phim/phim-le/vien-tuong"
									class="text-dark">Phim viễn tưởng</a>
							</div>
							<div>
								<a href="https://247phim.com/phim/phim-le/hoat-hinh"
									class="text-dark">Phim hoạt hình</a>
							</div>
						</div>

						<div class="col-4 ">
							<p class="title">&nbsp;</p>
							<div>
								<a href="https://247phim.com/phim/phim-le/sieu-anh-hung"
									class="text-dark">Phim siêu anh hùng</a>
							</div>
							<div>
								<a href="https://247phim.com/phim/phim-le/tinh-cam"
									class="text-dark">Phim tình cảm</a>
							</div>
							<div>
								<a href="https://247phim.com/phim/phim-le/tai-lieu"
									class="text-dark">Phim tài liệu</a>
							</div>
							<div>
								<a href="https://247phim.com/phim/phim-le/hai-huoc"
									class="text-dark">Phim hài</a>
							</div>
							<div>
								<a href="https://247phim.com/phim/phim-le/tham-hoa"
									class="text-dark">Phim thảm họa</a>
							</div>
						</div>

						<div class="col-4 ">
							<p class="title text-warning mt-3">Phim bộ</p>
							<div>
								<a href="https://247phim.com/phim/quoc-gia/phim-bo/han-quoc"
									class="text-dark">Phim bộ Hàn Quốc</a>
							</div>
							<div>
								<a href="https://247phim.com/phim/quoc-gia/phim-bo/trung-quoc"
									class="text-dark">Phim bộ Trung Quốc</a>
							</div>
							<div>
								<a href="https://247phim.com/phim/quoc-gia/phim-bo/my"
									class="text-dark">Phim bộ Mỹ</a>
							</div>
							<div>
								<a href="https://247phim.com/phim/quoc-gia/phim-bo/viet-nam"
									class="text-dark">Phim bộ Việt Nam</a>
							</div>
							<div>
								<a href="https://247phim.com/phim/quoc-gia/phim-bo/hong-kong"
									class="text-dark">Phim bộ Hồng Kông</a>
							</div>
						</div>
					</div> 

					
					</div>
					<div class="row mt-4">
						<div class="col-lg-4 col-12 copyright">© 2020 GUMAC.com</div>
						<div class="col-lg-4 col-12 da-dang-ky"></div>

					</div>
				</div>
			</footer>
		</div>
	</div>

	<!-- End Footer -->
	<script src="/ASM_JAVA4/js/jquery.min.js"></script>
	<script src="/ASM_JAVA4/js/popper.min.js"></script>
	<script src="/ASM_JAVA4/js/bootstrap.min.js"></script>
</body>
</html>