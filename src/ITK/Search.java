package ITK;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		String param = request.getParameter("searchString");

		if (action != null && action.equals("removeUnit")) {
			Integer id = Integer.parseInt(request.getParameter("unitId"));
			deleteRow(id);
		}

		if (param!=null && !param.isEmpty()) {
			request.setAttribute("UnitList", searchUnits(param));
		} else {
			request.setAttribute("UnitList", searchUnits(""));
		}
		request.getRequestDispatcher("WEB-INF/Search.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	private void deleteRow(Integer id)
	{
		try {
			UnitDao dao = new UnitDao();
			dao.removeUnit(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private List<Unit> searchUnits(String param)
	{
		List<Unit> units = new ArrayList<Unit>();
		if(param.equals("") || param==null){
			try {
				UnitDao dao = new UnitDao();
				units = dao.getAllUnits();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else{
			try {
				UnitDao dao = new UnitDao();
				units = dao.searchUnits(param);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return units;
	}
}