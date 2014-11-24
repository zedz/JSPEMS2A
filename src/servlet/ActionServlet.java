package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.EmpDAO;
import entity.Emp;
import entity.User;

public class ActionServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String uri=request.getRequestURI();
		String action=uri.substring(uri.lastIndexOf("/")+1, uri.lastIndexOf("."));
		
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String salary=request.getParameter("salary");
		String age=request.getParameter("age");
		
		if("list".equals(action)){
			HttpSession session=request.getSession();
			User user=(User)session.getAttribute("user");
			if(user==null){
				response.sendRedirect("login.jsp");
				return;
			}
			EmpDAO dao=new EmpDAO();
			List<Emp> emps=dao.findAll();
			request.setAttribute("emps", emps);
			request.getRequestDispatcher("list.jsp").forward(request, response);
		}else if("save".equals(action)){
			EmpDAO dao=new EmpDAO();
			Emp e=new Emp();
			e.setName(name);
			e.setSalary(Double.parseDouble(salary));
			e.setAge(Integer.parseInt(age));
			dao.save(e);
			response.sendRedirect("list.do");
		}else if("del".equals(action)){
			EmpDAO dao=new EmpDAO();
			dao.del(Integer.parseInt(id));
			response.sendRedirect("list.do");
		}else if("modify".equals(action)){
			Emp e=new Emp(Integer.parseInt(id), name, Double.parseDouble(salary), Integer.parseInt(age));
			EmpDAO dao=new EmpDAO();
			dao.modify(e);
			response.sendRedirect("list.do");
		}else if("load".equals(action)){
			EmpDAO dao=new EmpDAO();
			Emp e=dao.findById(Integer.parseInt(id));
			request.setAttribute("emp", e);
			request.getRequestDispatcher("load.jsp").forward(request, response);
		}
	}

}
