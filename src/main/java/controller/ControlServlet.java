package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControlServlet extends HttpServlet{
	public static String PHONE_NUMBER = "phoneNumber";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String phoneNumber = req.getParameter("phoneNumber");
		String password = req.getParameter("password");
		
		
		super.doPost(req, resp);
	}
	
	

}
