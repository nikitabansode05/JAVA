package com.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class SimpleServlet extends HttpServlet {
	@Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response)
     throws ServletException,IOException{
        
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println("<h1>Hello from get request !!!</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{

        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println("<h1>Hello from post request !!</h1>");
        out.println("<h2>Welcome "+request.getParameter("name")+"</h2>");
        out.println("<h2>The password is : "+request.getParameter("password")+"/<h2>");
    }
}
