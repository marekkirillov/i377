package ITK;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionCounterListener implements HttpSessionListener
{

	private static int countOfSessions;
	
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		countOfSessions++;
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		countOfSessions--;		
	}
	
	public static int getSessionsCount(){
		return countOfSessions;
	}

}
