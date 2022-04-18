package controllers.admin;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;

import dao.VideoDAO;
import dao.categoryDAO;
import entities.Category;
import entities.Video;

@MultipartConfig  //Khai báo servlet xử lý upload file
@WebServlet({"/video/index", // GET
	"/video/create", // GET
	"/video/store", // POST
	"/video/edit", // GET
	"/video/update", // POST
	"/video/delete", // GET
})
public class QLVideoSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private VideoDAO videoDAO;
    private categoryDAO categoryDAO;
    private static final int VIDEO_MAX_PAGE_SIZE = 2;

    public QLVideoSevlet() {
        super();
        this.videoDAO = new VideoDAO();
        this.categoryDAO = new categoryDAO();
    }

	protected void doGet(
			HttpServletRequest request, 
			HttpServletResponse response
			) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		if (uri.contains("index")) { 	//contain: so sánh
			this.index(request, response);
		} else if (uri.contains("create")) {
			this.create(request, response);
		} else if (uri.contains("edit")) {
			this.edit(request, response);
		} else if (uri.contains("delete")) {
			this.delete(request, response);
		}
	}

	protected void doPost(
			HttpServletRequest request,
			HttpServletResponse response
			) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		if (uri.contains("store")) {
			this.store(request, response);
		} else if (uri.contains("update")) {
			this.update(request, response);
		}
	}
	
	private void index(
			HttpServletRequest request,
			HttpServletResponse response
			) throws ServletException, IOException {
		List<Video> ds = this.videoDAO.all();
		request.setAttribute("ds", ds);
		
		List<Category> dsC = this.categoryDAO.all();
		request.setAttribute("dsC", dsC);
		request.setAttribute("view", "/views/admin/video/index.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);

	}
	private void delete(
			HttpServletRequest request,
			HttpServletResponse response
			) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Video entity = this.videoDAO.findById(id);
		try {
			this.videoDAO.delete(entity);
			response.sendRedirect("/ASM_JAVA4/video/create");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	private void edit(
			HttpServletRequest request,
			HttpServletResponse response
			) throws ServletException, IOException {
		List<Category> dsC = this.categoryDAO.all();
		request.setAttribute("dsC", dsC);
		List<Video> dsV = this.videoDAO.all();
		request.setAttribute("dsV", dsV); //thêm thuộc tính
		String idStr = request.getParameter("id");  //lấy gtri và đọc dl từ 1 tham số
		int id = Integer.parseInt(idStr);
		Video entity = this.videoDAO.findById(id);
		request.setAttribute("video", entity);
		Category c = entity.getCategory();
		int category_id = c.getId();
		Category category = this.categoryDAO.findById(category_id);
		request.setAttribute("category", category);
		
		request.setAttribute("view", "/views/admin/video/edit.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);

	}
	private void create(
			HttpServletRequest request,
			HttpServletResponse response
			) throws ServletException, IOException {
		List<Category> dsC = this.categoryDAO.all();
		request.setAttribute("dsC", dsC);
		List<Video> dsV = this.videoDAO.all();
		request.setAttribute("dsV", dsV); //thêm thuộc tính
		request.setAttribute("view", "/views/admin/video/create.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);

	}
	private void update(
			HttpServletRequest request,
			HttpServletResponse response
			) throws ServletException, IOException {

		HttpSession session = request.getSession();
		try {
			String id=request.getParameter("id"); //lấy gtri và đọc dl
			String title = request.getParameter("title");
			String poster = request.getParameter("poster");
			String description = request.getParameter("description");
			String views = request.getParameter("views");
			String category_id = request.getParameter("category_id");
			
			Category category = this.categoryDAO.findById(Integer.parseInt(category_id));
			Video video = this.videoDAO.findById(Integer.parseInt(id));
			
			video.setTitle(title); // set gtri
			video.setPoster(poster);
			video.setDescription(description);
			video.setViews(Integer.parseInt(views));
			video.setCategory(category);

			this.videoDAO.update(video);
			session.setAttribute("message", "Sửa thành công");
			response.sendRedirect("/ASM_JAVA4/video/create");
			System.out.println("Cập nhật thanh cong");

		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("error", "Sửa thất bại");
			String id = request.getParameter("id");
			response.sendRedirect("/ASM_JAVA4/video/edit?id=" + id);
		}
	}
	private void store(
			HttpServletRequest request,
			HttpServletResponse response
			) throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			
			////
			Video entity = new Video();
			BeanUtils.populate(entity, request.getParameterMap()); //đọc dl từ form
			List<Video> listVideo = this.videoDAO.all();
			request.setAttribute("ds", listVideo);
			for (Video video : listVideo) {
				System.out.println(video);
			}
			String cateIDString = request.getParameter("category_id");  //lấy gtri và đọc dl từ 1 tham số
			int category_id= Integer.parseInt(cateIDString);
			Category category =this.categoryDAO.findById(category_id);
			
			
			entity.setCategory(category);
			this.videoDAO.create(entity);
			session.setAttribute("message", "Thêm mới thành công");
			response.sendRedirect("/ASM_JAVA4/video/create");
			System.out.println("Thanh cong");
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("error", "Thêm mới thất bại");
			response.sendRedirect("/ASM_JAVA4/video/create");
		}
/////////////////////////////////////////////////////////
//		HttpSession session = request.getSession();
//		try {
//			Video entity = new Video();
//			String id=request.getParameter("id");
//			String title = request.getParameter("title");
//			Part part = request.getPart("poster"); //Lấy file upload theo tên 
//			
//			String realPath = request.getServletContext().getRealPath("/image");
//			String filename = Path.of(part.getSubmittedFileName()).getFileName().toString();
//			part.write(realPath+filename);
//			
//			String description = request.getParameter("description");
//			String views = request.getParameter("views");
//			
//			if (!Files.exists(Path.of(realPath))) {
//				Files.createDirectory(Path.of(realPath));
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			session.setAttribute("error", "Thêm mới thất bại");
//			response.sendRedirect("/ASM_JAVA4/video/create");
//		} 
//		
	}
	
}
