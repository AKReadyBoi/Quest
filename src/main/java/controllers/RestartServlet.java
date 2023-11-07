package controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "restart", value = "/restart")
public class RestartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("progress", 0);
        Integer numberOfGames = (Integer) request.getSession().getAttribute("numberOfGames");
        numberOfGames++;
        session.setAttribute("numberOfGames", numberOfGames);
        response.sendRedirect("/start");
    }
}