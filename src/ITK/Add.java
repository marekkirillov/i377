package ITK;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/Add.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String code = request.getParameter("code");
		
		if(name != null && code != null)
		{
			try {
				UnitDao dao = new UnitDao();
				dao.addUnit(name,code);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
        response.sendRedirect("Search");
	}

}