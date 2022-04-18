package controller;

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

@WebServlet("/LoginSevlet")
public class LoginSevlet extends HttpServlet {
	private UserDAO userDAO;
       

    public LoginSevlet() {
        super();
        this.userDAO = new UserDAO();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/admin/users/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email"),
				pwd = request.getParameter("password");
		User u = this.userDAO.findByEmail(email);
		
		HttpSession session  = request.getSession();
		boolean check = EncryptUtil.check(pwd, u.getPassword());
		if (check == true) {
			// Đăng nhập thành công
			session.setAttribute("user", u);
			response.sendRedirect("/DEMO/users/index");
		} else {
			// Đăng nhập thất bại			
		}
	}

}
