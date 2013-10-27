package main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SetupDao;
import dao.UnitDao;

public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
	
			if(request.getParameter("action").equals("remove"))
			{
				new UnitDao().removeAllEntries();
			}
			if(request.getParameter("action").equals("insert"))
			{
				new SetupDao().addSampleData();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("Search");

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

}