package controllers.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import entities.Category;
import entities.User;


@WebServlet("/Categorysevlet")
public class Categorysevlet extends HttpServlet {
	private UserDAO userDAO;
    public Categorysevlet() {
        super();
        this.userDAO = new UserDAO();

    }

	protected void doGet(
			HttpServletRequest request,
			HttpServletResponse response
			) throws ServletException, IOException {
		List<User> ds = this.userDAO.all();
		System.out.println(ds.size());
		request.setAttribute("ds", ds);
		request.getRequestDispatcher("/views/admin/categories/create.jsp")
		.forward(request, response);
	}


	protected void doPost(
			HttpServletRequest request, 
			HttpServletResponse response
			) throws ServletException, IOException {
		String ten = request.getParameter("ten");
		String userIdStr = request.getParameter("user_id");
		
		int userId = Integer.parseInt(userIdStr);
		User u = this.userDAO.findById(userId);
		Category c = new Category();
		c.setTen(ten);
		c.setUser(u);

	}

}
