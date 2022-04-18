package controllers.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import dao.UserDAO;
import entities.User;
import utils.EncryptUtil;

@WebServlet({ "/users/index", // GET
		"/users/create", // GET
		"/users/store", // POST
		"/users/edit", // GET
		"/users/update", // POST
		"/users/delete", // GET
})
public class QLUserServlert extends HttpServlet {
	private UserDAO userDAO;

	public QLUserServlert() {
		super();
		this.userDAO = new UserDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();

		if (uri.contains("index")) {
			this.index(request, response);
		} else if (uri.contains("create")) {
			this.create(request, response);
		} else if (uri.contains("edit")) {
			this.edit(request, response);
		} else if (uri.contains("delete")) {
			this.delete(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();

		if (uri.contains("store")) {
			this.store(request, response);
		} else if (uri.contains("update")) {
			this.update(request, response);
		}
	}

	private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> ds = this.userDAO.all();

//		User o1 = new User(1, "Ng Van A", "Hà Nội", "0335185796", "a@gmail.com", "12345"),
//				o2 = new User(2, "Ng Van B", "Hà Nội", "0335185796", "a@gmail.com", "12345"),
//				o3 = new User(3, "Ng Van C", "Hà Nội", "0335185796", "a@gmail.com", "12345");
//		ds.add(o1);
//		ds.add(o2);
//		ds.add(o3);

		request.setAttribute("ds", ds);
		request.setAttribute("view", "/views/admin/users/index.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}

	private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("view", "/views/admin/users/create.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id"); // do hàm getParameter trả về kiểu dữ liệu String nên  phải ép kiểu
		int id = Integer.parseInt(idStr);

		User entity = this.userDAO.findById(id);
		request.setAttribute("user", entity);
		request.setAttribute("view", "/views/admin/users/edit.jsp");
		request.getRequestDispatcher("/views/layout.jsp")
		.forward(request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id")); // do hàm getParameter trả về kiểu dữ liệu String nên
																// phải ép kiểu
		User entity = this.userDAO.findById(id);
		try {
			this.userDAO.delete(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}

		response.sendRedirect("/DEMO/users/index");
	}

	private void store(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		try {
			User entity = new User();
			BeanUtils.populate(entity, request.getParameterMap());
			String encrypted = EncryptUtil.encrypt(request.getParameter("password"));
			entity.setPassword(encrypted);
			this.userDAO.create(entity);
			session.setAttribute("message", "Thêm mới thành công");
			response.sendRedirect("/DEMO/users/index");
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("error", "Thêm mới thất bại");
			response.sendRedirect("/DEMO/users/create");
		}
	}
	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			User entity = new User();
			BeanUtils.populate(entity, request.getParameterMap()); //Bóc dữ liệu gửi lên thông qua beanUtil
			User oldUser = this.userDAO.findById(entity.getId());
			entity.setPassword(oldUser.getPassword());
			this.userDAO.update(entity);
			response.sendRedirect("/DEMO/users/index");
		} catch (Exception e) {
			e.printStackTrace();
			String id = request.getParameter("id");
			response.sendRedirect("/DEMO/users/edit?id=" + id);
		}
	}
}
