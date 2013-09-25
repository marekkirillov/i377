package ITK;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class HomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sessioon = request.getSession();
		
		String sessionID = sessioon.getId();
		
		Object attribute = request.getParameter("param");
		
		if(attribute !=null)
		{
		sessioon.setAttribute("param", attribute);
		}
		
		String sessionAttribute = (String)sessioon.getAttribute("param");
		
		response.getWriter().println("Hello<br>");
		response.getWriter().println("Your session id is "+sessionID+"<br>");
		response.getWriter().println("Session attribute is "+sessionAttribute);
		
	}

}
