package servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckCodeServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BufferedImage image=new BufferedImage(80, 30, BufferedImage.TYPE_INT_BGR);
		Graphics g=image.getGraphics();
		g.setColor(new Color(255,255,255));
		g.fillRect(0, 0, 80, 30);
		Random r=new Random();
		g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
		g.setFont(new Font(null, Font.ITALIC, 22));
		String code=getCode(5);
		
		HttpSession session=request.getSession();
		session.setAttribute("code", code);
		
		g.drawString(code, 10, 24);
		
		for(int i=0;i<6;i++){
			g.drawLine(r.nextInt(80), r.nextInt(30), r.nextInt(80), r.nextInt(30));
		}
		
		response.setContentType("image/jpeg");
		OutputStream ops=response.getOutputStream();
		javax.imageio.ImageIO.write(image, "jpeg", ops);
		
	}
	
	private String getCode(int size){
		String string="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		String code="";
		Random r=new Random();
		for(int i=0;i<size;i++){
			code+=string.charAt(r.nextInt(string.length()));
		}
		return code;
	}

}
