package com.tap.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class TestServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request , HttpServletResponse response) throws  ServletException,IOException {
        request.setAttribute("message","Hello from Servlet!");
        request.getRequestDispatcher("/test.jsp").forward(request,response);
    }
}
