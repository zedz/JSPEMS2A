package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import entity.User;

public class UserServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;utf-8");
		String uri=request.getRequestURI();
		String action=uri.substring(uri.lastIndexOf("/")+1, uri.lastIndexOf("."));
		
		String username=request.getParameter("username");
		String pwd=request.getParameter("pwd");
		String realName=request.getParameter("realname");
		String gender=request.getParameter("gender");
		String codeInput=request.getParameter("number");

		if("regist".equals(action)){
			
			HttpSession session=request.getSession();
			String code=((String)session.getAttribute("code")).toLowerCase();
			codeInput=codeInput.toLowerCase();
			if(!code.equals(codeInput)){
				request.setAttribute("code_wrong", "���������������");
				request.getRequestDispatcher("regist.jsp").forward(request, response);
				return;
			}
			UserDAO dao=new UserDAO();
			User checkuser=dao.findByUsername(username);
			if(checkuser==null){
				User user=new User(username, pwd, realName, gender);
				dao.save(user);
				response.sendRedirect("login.jsp");
			}else{
				request.setAttribute("user_exist", "������������������");
				request.getRequestDispatcher("regist.jsp").forward(request, response);
			}
		}else if("login".equals(action)){
			UserDAO dao=new UserDAO();
			User user=dao.findByUsername(username);
			if(pwd.equals(user.getPwd())){
				HttpSession session=request.getSession();
				session.setAttribute("user", user);
				response.sendRedirect("list.do");
			}else{
				request.setAttribute("login_failed", "������������������������");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}else if("admin".equals(action)){
			UserDAO dao=new UserDAO();
			List<User> users=dao.findall();
			request.setAttribute("users", users);
			request.getRequestDispatcher("admin.jsp").forward(request, response);
		}else if ("check_uname".equals(action)) {
			UserDAO dao=new UserDAO();
			User checkUser=dao.findByUsername(username);
			PrintWriter out=response.getWriter();
			if(checkUser==null){
				out.println("该用户名可以使用");
			}else {
				out.println("该用户名以被占用");
			}
		}

	}

}
