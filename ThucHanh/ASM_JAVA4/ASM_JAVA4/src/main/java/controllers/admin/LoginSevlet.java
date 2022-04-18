package controllers.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import entities.User;
import utils.EncryptUtil;

@WebServlet("/login")
public class LoginSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
	public LoginSevlet() {
		super();
		this.userDAO = new UserDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/views/admin/users/login.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email"),
				password = request.getParameter("password");  //lấy gtri và đọc dl
		System.out.println(email + "-" + password);
		User user = this.userDAO.findByEmail(email);

		HttpSession session = request.getSession();
		boolean check = EncryptUtil.check(password, user.getPassword());
		if (check == true) {
			// Đăng nhập thành công
			session.setAttribute("user", user);
			response.sendRedirect("/ASM_JAVA4/video/index");
			System.out.println("Thành công");
		} else {
			// Đăng nhập thất bại
			response.sendRedirect("/ASM_JAVA4/login");
			System.out.println("Thất bại");
		}
	}

}
