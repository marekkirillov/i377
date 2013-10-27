package main;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import dao.SetupDao;

public class DbInitListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent arg0) {
		try {
			new SetupDao().createSchema();
			new SetupDao().addSampleData();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void contextDestroyed(ServletContextEvent arg0){
	
	}
}