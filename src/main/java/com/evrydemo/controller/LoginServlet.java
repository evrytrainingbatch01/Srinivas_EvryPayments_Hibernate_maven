package com.evrydemo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.evrydemo.model.Customer;
import com.evrydemo.service.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String customerName = request.getParameter("customerName");   
	     String password = request.getParameter("password");
	     LoginService loginService = new LoginService();
	     boolean result = loginService.authenticateCustomer(customerName, password);
	     Customer customer = loginService.getCustomerByName(customerName);
	     if(result == true){
	         request.getSession().setAttribute("customer", customer);      
	         response.sendRedirect("home.jsp");
	     }
	     else{
	         response.sendRedirect("error.jsp");
	     }
	}
	}

