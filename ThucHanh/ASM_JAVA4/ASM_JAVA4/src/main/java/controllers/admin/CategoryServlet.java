package controllers.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import dao.categoryDAO;
import entities.Category;
import entities.User;


@WebServlet({ 
	"/categories/index", // GET
	"/categories/create", // GET
	"/categories/store", // POST
	"/categories/edit", // GET
	"/categories/update", // POST
	"/categories/delete", // GET
	
})
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
	private categoryDAO categoryDAO;
	
    public CategoryServlet() {
        super();
        this.userDAO = new UserDAO();
        this.categoryDAO = new categoryDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		if (uri.contains("index")) {
			this.index(request, response);
		} else if (uri.contains("create")) {
			this.create(request, response);
		} 
		else if (uri.contains("edit")) {
			this.edit(request, response);
		} else if (uri.contains("delete")) {
			this.delete(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		if (uri.contains("store")) {
			this.store(request, response);
		} else if (uri.contains("update")) {
			this.update(request, response);
		}
	}
	
	private void index(HttpServletRequest request,
			HttpServletResponse response
	)throws ServletException, IOException {
		List<Category> ds= this.categoryDAO.all();
		request.setAttribute("ds", ds);
		request.setAttribute("view", "/views/admin/categories/index.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);	
	}
	
	private void create(HttpServletRequest request,
			HttpServletResponse response
	) throws ServletException, IOException {
		List<User> ds = this.userDAO.all();
		request.setAttribute("ds", ds);
		
		request.setAttribute("view", "/views/admin/categories/create.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
		
	}
	
	private void delete(HttpServletRequest request,
			HttpServletResponse response
	) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Category entity = this.categoryDAO.findById(id);
		try {
			this.categoryDAO.delete(entity);
			response.sendRedirect("/ASM_JAVA4/categories/index");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void edit(HttpServletRequest request,
			HttpServletResponse response
	) throws ServletException, IOException {
		
		List<User> ds = this.userDAO.all();
		request.setAttribute("ds", ds);
		String idS = request.getParameter("id");  ///lấy gtri và gán đọc dl
		int id = Integer.parseInt(idS);
		Category entity = this.categoryDAO.findById(id);
		System.out.println(id);
		User u = entity.getUser();
		int userId = u.getId();
		User user = this.userDAO.findById(userId);
		request.setAttribute("user", user);
		request.setAttribute("category", entity);
		System.out.println(entity.getTen());
		request.setAttribute("view", "/views/admin/categories/edit.jsp");
		request.getRequestDispatcher("/views/layout.jsp")
		.forward(request, response);
	}
	
	private void update(HttpServletRequest request,
			HttpServletResponse response
	) throws ServletException, IOException{
		HttpSession session = request.getSession();
		try {
	String userID = request.getParameter("user_id"); //lấy gtri và đọc dl từ 1 tham số
	String categoryID=request.getParameter("id");
	String tenString =request.getParameter("ten");
	User user = this.userDAO.findById(Integer.parseInt(userID));
	Category category =this.categoryDAO.findById(Integer.parseInt(categoryID));
	category.setTen(tenString);
	category.setUser(user);
	this.categoryDAO.update(category);
			session.setAttribute("message", 
					"Sửa thành công");
			response.sendRedirect("/ASM_JAVA4/categories/index");
			System.out.println("Thanh cong");
			
		} catch (Exception e) {
			e.printStackTrace();
			String id = request.getParameter("id");
			session.setAttribute("error", 
					"Sửa thất bại");
			response.sendRedirect("/ASM_JAVA4/categories/edit?id=" +id);
			
		}
	}
	
	private void store(HttpServletRequest request,
			HttpServletResponse response
	)throws ServletException, IOException  {
		String ten = request.getParameter("ten");    //lấy gtri và đọc dl từ 1 tham số
		String userIdStr = request.getParameter("user_id");
		int userId = Integer.parseInt(userIdStr);
		User u = this.userDAO.findById(userId);
		
		Category c = new Category();
		c.setTen(ten);
		c.setUser(u);
		try {
			this.categoryDAO.create(c);
			response.sendRedirect("/ASM_JAVA4/categories/index");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("/ASM_JAVA4/categories/create.jsp");
		}
	}

}
