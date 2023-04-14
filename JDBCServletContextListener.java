package week6;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class JDBCServletContextListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("I am in contextInitialized()");
		sce.getServletContext().removeAttribute("con");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext context=sce.getServletContext();
		String driver=context.getInitParameter("driver");
		String url=context.getInitParameter("url");
		String username=context.getInitParameter("username");
		String password=context.getInitParameter("password");
		try {
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url,username,password);
			System.out.println("I am in contextDestroy()-->"+con);
			context.setAttribute("con", con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
