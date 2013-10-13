package ITK;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import Daos.SetupDao;

public class DbInitListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent arg0) {
		try {
			SetupDao dao = new SetupDao();
			dao.createSchema("DatabaseSchema.sql");
			dao.createSchema("DatabaseData.sql");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void contextDestroyed(ServletContextEvent arg0){
	
	}
}