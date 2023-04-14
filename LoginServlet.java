package week5;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import util.JDBCtest;
//import org.apache.commons.dbutils.QueryRunner;
//import org.apache.commons.dbutils.handlers.BeanHandler;
//import org.apache.commons.dbutils.handlers.BeanListHandler;
//import org.apache.commons.dbutils;


@WebServlet(name="LoginServlet",value="/login")
public class LoginServlet extends HttpServlet {
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Connection con=null;
	@Override
	public void init() throws ServletException{
		super.init();
		con=(Connection) getServletContext().getAttribute("con");
		
	}
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("name");
	 	String password=request.getParameter("pwd");
//	 	response.setContentType("text/html");
	 	System.out.println(username);
	 	PrintWriter out=response.getWriter();
	 	Connection conn=null;
		conn=JDBCtest.getConnection();
	 	PreparedStatement ps=null;
	 	ResultSet rs=null;
	 	String sql="select * from person where username='"+username+"' and password='"+password+"'";
	 	try {
	 			
				ps=conn.prepareStatement(sql);
//				ps.setString(1,username);
//				ps.setString(2,password);
				System.out.print(sql);
				rs=ps.executeQuery();
				if(rs.next())
				{
					request.setAttribute("id", rs.getString("ID"));
					request.setAttribute("username", rs.getString("UserName"));
					request.setAttribute("password", rs.getString("PASSWORD"));
					request.setAttribute("email", rs.getString("Email"));
					request.setAttribute("gender", rs.getString("Gender"));
					request.setAttribute("birthdate", rs.getString("Birthdate"));
					request.getRequestDispatcher("userInfo.jsp").forward(request, response);
//					out.println("<body><h2>Login Success!!!</h2>");
//					out.println("<h3>Welcome "+username+"</h3></body>");
				}
				else
				{
					request.setAttribute("msg", "<body><h2>username or Password Error!!!</h2></body>");
					request.getRequestDispatcher("login.jsp").forward(request, response);
//					out.println("<body><h2>username or Password Error!!!</h2></body>");
				}
		     }catch (Exception e) {
		    	 e.printStackTrace();
			}
    }
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
