package week4;

import javax.servlet.*;
import javax.servlet.http.*;

import util.JDBCtest;

import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "RegisterServlet", value = "/register")
public class RegisterServlet extends HttpServlet {
	Connection con=null;
	@Override
	public void init() throws ServletException{
		super.init();
//		
//		ServletContext context=sce.getServletContext();
//		String driver=context.getInitParameter("driver");
//		String url=context.getInitParameter("url");
//		String username=context.getInitParameter("username");
//		String password=context.getInitParameter("password");
//		try {
//			Class.forName(driver);
//			Connection con=DriverManager.getConnection(url,username,password);
//			System.out.println("I am in contextDestroy()-->"+con);
//			context.setAttribute("con", con);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		con=(Connection) getServletContext().getAttribute("con");
	}
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String id=request.getParameter("id");
    	String username=request.getParameter("username");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        String gender=request.getParameter("gender");
        String birthdate=request.getParameter("birthdate");
        Connection conn=null;
        conn=JDBCtest.getConnection();
        PreparedStatement ps=null;
        java.sql.Statement stmt1=null;
     	
     	try {
     		stmt1=conn.createStatement();
			String sql="insert into person(ID,UserName,PASSWORD,Email,Gender,Birthdate) value('"+id+"','"+username+"','"+password+"','"+email+"','"+gender+"','"+birthdate+"')";
//			ps=conn.prepareStatement(sql);
//			ps.setString(1,id);
//			ps.setString(2,username);
//			ps.setString(3,password);
//			ps.setString(4,email);
//			ps.setString(5,gender);
//			ps.setString(6,birthdate);
//			ps.executeQuery();
			int n=stmt1.executeUpdate(sql);
			if(n==0) {
				System.out.print("FFF");
			}
			System.out.print(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

     	ResultSet rs=null;
     	String rsString="select * from person";
     	try {
			ps=conn.prepareStatement(rsString);
			rs=ps.executeQuery();
//			PrintWriter out=response.getWriter();
//			out.write("<table  border=1><tr><td>ID</td><td>Username</td><td>Password</td><td>Email</td><td>Gender</td><td>Birthdate</td></tr>");
//		    while(rs.next()) {
//		        	out.write("<tr>");
//		        	out.write("<td>"+rs.getString("id")+"</td>");
//		        	out.write("<td>"+rs.getString("UserName")+"</td>");
//		        	out.write("<td>"+rs.getString("PASSWORD")+"</td>");
//		        	out.write("<td>"+rs.getString("Email")+"</td>");
//		        	out.write("<td>"+rs.getString("Gender")+"</td>");
//		        	out.write("<td>"+rs.getString("Birthdate")+"</td>");
//		        	out.write("</tr>");
//		    }
//		    out.write("</table>");
//			request.setAttribute("rsname", rs);
//			request.getRequestDispatcher("userList.jsp").forward(request, response);
//			System.out.println("I am in Register-->dopost-->after forward()");
			response.sendRedirect("login.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     	
       



    }
}
