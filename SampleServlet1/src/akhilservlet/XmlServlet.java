package akhilservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class XmlServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter Writer = response.getWriter();
		String userName = 	request.getParameter("name");
		HttpSession session = request.getSession();
		ServletContext context = request.getServletContext();
		if(userName != "" && userName != null)
		{
			session.setAttribute("SavedUserName", userName);
			context.setAttribute("SavedUserName", userName);
		}
		
		Writer.println("Request parameter has username as " + userName);
		Writer.println("Session parameter has username as " + (String) session.getAttribute("SavedUserName") );
		Writer.println("Context parameter has username as " + (String) context.getAttribute("SavedUserName") );
		
		Writer.println("Init parameter has default username as " + getServletConfig().getInitParameter("defaultUser"));
		
		}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userName = 	request.getParameter("userName");
		String fullName = 	request.getParameter("fullName");
		out.println("Hello called from POST! " + userName + "! your Full name is" + fullName );
		String prof = 	request.getParameter("prof");
		out.println("your prof are : " + prof);
		String[] location = request.getParameterValues("location");
		out.println("you are at : "  + location.length  + "  places "  );
//		out.println("\n");
//		System.out.println("\n");
		for(int i = 0; i<location.length;i++)
		{
			out.println(location[i]);
			//out.println("\n");
		}
	
		}
}
