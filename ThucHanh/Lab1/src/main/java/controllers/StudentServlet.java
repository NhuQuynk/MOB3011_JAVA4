package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import bean.form_data.Students;


@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public StudentServlet() {
        super();
    }
    List<Students> list ;
	protected void doGet(
			HttpServletRequest request, 
			HttpServletResponse response
			) throws ServletException, IOException {
		
		list = new ArrayList<Students>();
		Students o1 = new Students("PH16211", "Ng Van A", 1, 0, "0335187999", "A@gmail.com", "6/12/2002");
		Students o2 = new Students("PH16212", "Ng Van B", 0, 2, "0335187999", "B@gmail.com", "7/3/2000");
		Students o3 = new Students("PH16213", "Ng Van C", 0, 1, "0335187999", "B@gmail.com", "1/1/2000");
		list.add(o1);
		list.add(o2);
		list.add(o3);
		request.setAttribute("list", list);
		request.setAttribute("view", "layout.jsp");   
		request.getRequestDispatcher("/views/table.jsp").forward(request, response);
	}

	protected void doPost(
			HttpServletRequest request, 
			HttpServletResponse response
			) throws ServletException, IOException {
		Students beanStudents = new Students();
		try {
			BeanUtils.populate(beanStudents, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		list.add(beanStudents);
		request.setAttribute("list", list);
		request.setAttribute("view", "index.jsp");   
		request.getRequestDispatcher("/views/table.jsp").forward(request, response);
		System.out.println(beanStudents.getMaSv());
//		System.out.println(beanStudents.getMaSv());
//		System.out.println(beanStudents.getMaSv());
//		System.out.println(beanStudents.getMaSv());
//		System.out.println(beanStudents.getMaSv());
//		System.out.println(beanStudents.getMaSv());
	}
	
	

}
