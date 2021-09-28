package demo.jee;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException; 

@WebServlet(urlPatterns="/login.do")
public class LoginServlet extends HttpServlet{
	
	private UserValidationService service = new UserValidationService(); 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
//		PrintWriter writer = response.getWriter(); 
//		writer.println("Working"); 
		String name = request.getParameter("name"); 
		request.setAttribute("name", name);
		
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
//			PrintWriter writer = response.getWriter(); 
//			writer.println("Working"); 
			String name = request.getParameter("name"); 
			String password = request.getParameter("password"); 
			
			boolean isUserValid = service.isUserValid(name, password); 
			
			if(isUserValid) {
			request.setAttribute("name", name);
			request.setAttribute("password", password);
			request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request, response);
			
			}
			else
			{
				request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request, response); 
			}
	
		}
}