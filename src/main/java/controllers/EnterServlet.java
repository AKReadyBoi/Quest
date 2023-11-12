package controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "enter", value = "")
public class EnterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userName = request.getParameter("userName");
        if (userName != null && !userName.isEmpty()) {
            HttpSession session = request.getSession();
            session.setAttribute("userName", userName);
        } else {
            userName = "огузок";
            HttpSession session = request.getSession();
            session.setAttribute("userName", userName);
        }
        response.sendRedirect("/start");
    }

}