package week6;

import java.io.IOException;
import java.net.http.HttpResponse;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/search")
public class SearchServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		String txt=request.getParameter("txt");
	 	String search=request.getParameter("search");
	 	if(txt==null) {
	 		response.sendRedirect("index.jsp");
	 	}
	 	else {
	 		if(search=="baidu") {
	 			response.sendRedirect("https://www.baidu.com/s?wd="+txt);
	 		}
	 		else if(search=="bing"){
	 			response.sendRedirect("https://cn.bing.com/search?q="+txt);
	 		}
	 		else if(search=="google"){
	 			response.sendRedirect("https://www.google.com/search?q="+txt);
	 		}
	 	}
	}
	
}
