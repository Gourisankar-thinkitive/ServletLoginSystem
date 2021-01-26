package auth;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Registration")
public class Registration extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

    public Registration() 
    {
        super();
    }
    
    @Override
    public void init() throws ServletException 
    {
    	super.init();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int id = Integer.parseInt(request.getParameter("empid"));
		String userName = request.getParameter("empname");
		String pass = request.getParameter("pass");
		
		DBOperations op = new DBOperations();
		
		op.SignUp(id, userName, pass);
		
		PrintWriter out = response.getWriter();
		
		out.println("SignUp successful..");
	}
	
}
