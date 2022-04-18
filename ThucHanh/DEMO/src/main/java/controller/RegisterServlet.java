package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import dao.UserDAO;
import entities.User;



@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private UserDAO userDAO;
    public RegisterServlet() {
        super();
        this.userDAO= new UserDAO();
    }

	protected void doGet(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		request.setAttribute("view", "/views/register.jsp");
		request.getRequestDispatcher("/views/layout.jsp")
			.forward(request, response);
	}

	protected void doPost(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		User entity = new User();
		try {
			BeanUtils.populate(entity, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.userDAO.create(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
