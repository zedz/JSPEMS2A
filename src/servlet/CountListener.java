package servlet;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class CountListener implements HttpSessionListener{

	public void sessionCreated(HttpSessionEvent arg0) {
		HttpSession session=arg0.getSession();
		ServletContext sctx=session.getServletContext();
		Integer count=(Integer)sctx.getAttribute("count");
		if(count==null){
			count=1;
		}else {
			count++;
		}
		sctx.setAttribute("count", count);
		
	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		HttpSession session=arg0.getSession();
		ServletContext sctx=session.getServletContext();
		Integer count=(Integer)sctx.getAttribute("count");
		if(count==null){
			count=1;
		}else {
			count--;
		}
		sctx.setAttribute("count", count);
		
	}

}
