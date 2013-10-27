package main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UnitDao;

public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("id")!=null){
			Long UnitId = Long.parseLong(request.getParameter("id"));
			request.setAttribute("Unit",new UnitDao().findById(UnitId));
		}
			request.setAttribute("UnitList",new UnitDao().getAllUnits());
		
		request.getRequestDispatcher("WEB-INF/Add.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String code = request.getParameter("code");
		
		if(name != null && code != null)
		{
			try {
				Unit unit = new Unit();
				unit.setName(name);
				unit.setCode(code);
				
				if(request.getParameter("superUnitCode")!=null){
				Long superUnitId = Long.parseLong(request.getParameter("superUnitCode"));
				Unit superUnit = new UnitDao().findById(superUnitId);
				if(superUnit!=null)
				{
					unit.setSuperUnit(superUnit);
				}}
				
				new UnitDao().save(unit);
			} catch (Exception e) {
				
			}
		}
        response.sendRedirect("Search");
	}

}