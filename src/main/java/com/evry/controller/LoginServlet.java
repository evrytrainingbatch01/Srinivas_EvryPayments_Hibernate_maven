package com.evry.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.evry.model.Customer;
import com.evry.service.LoginService;

public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
