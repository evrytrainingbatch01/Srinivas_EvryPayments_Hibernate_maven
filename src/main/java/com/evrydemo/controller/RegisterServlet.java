package com.evrydemo.controller;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.evrydemo.model.Customer;
import com.evrydemo.service.RegisterService;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 PrintWriter out = response.getWriter();
	     String customerName = request.getParameter("customerName");
	     String age = request.getParameter("age");
	     String email = request.getParameter("email");
	     String address = request.getParameter("address");
	     String password = request.getParameter("password");
	     String mobileno = request.getParameter("mobileno");
	     Customer customer = new Customer(customerName,age,email, address,password, mobileno);
	             
	     try { 
	         RegisterService registerService = new RegisterService();
	         boolean result = registerService.register(customer);      
	         out.println("<html>");
	         out.println("<head>");      
	         out.println("<title>Registration Successful</title>");    
	         out.println("</head>");
	         out.println("<body>");
	         out.println("<center>");
	         if(result){
	             out.println("<h1>Thanks for Registering with us :</h1>");
	             out.println("To login with  CustomeName and Password<a href=login.jsp>Click here</a>");
	         }else{
	             out.println("<h1>Registration Failed</h1>");
	             out.println("To try again<a href=register.jsp>Click here</a>");
	         }
	         out.println("</center>");
	         out.println("</body>");
	         out.println("</html>");
	     } finally {       
	         out.close();
	     }
	}

}
