// package com.tap.servlet;

// import java.io.IOException;
// import java.util.Date;

// import jakarta.servlet.ServletException;
// import jakarta.servlet.annotation.WebServlet;
// import jakarta.servlet.http.HttpServlet;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;

// @WebServlet("/jstl")
// public class Testjstl extends HttpServlet{
//     protected void doGet(HttpServletRequest request, HttpServletResponse response) 
//             throws ServletException, IOException {
        
//         // Set attributes to use in JSP
//         request.setAttribute("now", new Date()); // for today's date
//         request.setAttribute("user", "Nikita Bansode"); // optional, can override <c:set>
        
//         // Forward to JSP page
//         request.getRequestDispatcher("jstl.jsp").forward(request, response);
//     }
// }

package com.tap.servlet;

import java.io.IOException;
import java.util.Date;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/testjstl")
public class Testjstl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // set attributes for JSP
        request.setAttribute("now", new Date());
        request.setAttribute("user", "Nikita Bansode");

        // forward to jstl.jsp
        request.getRequestDispatcher("jstl.jsp").forward(request, response);
    }
}
