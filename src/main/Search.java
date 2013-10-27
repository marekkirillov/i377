package main;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UnitDao;

public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		String param = request.getParameter("searchString");

		if (action != null && action.equals("removeUnit")) {
			Integer id = Integer.parseInt(request.getParameter("unitId"));
			new UnitDao().removeUnit(id);
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

	private List<Unit> searchUnits(String param)
	{
		List<Unit> units = new ArrayList<Unit>();
		if(param.equals("") || param==null){
				new UnitDao().getAllUnits();
		}else{
			new UnitDao().searchUnits(param);
		}
		return units;
	}
}