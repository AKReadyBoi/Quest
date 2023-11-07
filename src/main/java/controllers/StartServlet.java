package controllers;

import jakarta.servlet.ServletException;
import model.Options;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "start", value = "/start")
public class StartServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer progress = (Integer) session.getAttribute("progress");
        Integer numberOfGames = (Integer) session.getAttribute("numberOfGames");
        if (progress == null)
            progress = 0;
        if (numberOfGames == null)
            numberOfGames = 0;
        session.setAttribute("progress", progress);
        session.setAttribute("numberOfGames", numberOfGames);
        session.setAttribute("ip", request.getRemoteAddr());
        request.setAttribute("question", Options.options.get(progress).get(0));
        if (Options.options.get(progress).size() == 3) {
            request.setAttribute("option1", Options.options.get(progress).get(1));
            request.setAttribute("option2", Options.options.get(progress).get(2));
            request.setAttribute("numberOfGames", numberOfGames);
            request.setAttribute("ip", request.getRemoteAddr());
            request.getRequestDispatcher("start.jsp").forward(request, response);
        } else {
            session.removeAttribute("progress");
            request.getRequestDispatcher("restart.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String selectedOption = request.getParameter("option");
        String restart = request.getParameter("restart");
        HttpSession session = request.getSession();
        Integer progress = (Integer) session.getAttribute("progress");
        if (selectedOption != null) {
            if (progress != 0) {
                progress += Integer.parseInt(selectedOption) + 1;
            } else {
                progress += Integer.parseInt(selectedOption);
            }
            session.setAttribute("progress", progress);
            response.sendRedirect("/start");
        } else {
            if (restart != null) {
                response.sendRedirect("/restart");
            } else {
                response.getWriter().write("Не выбран ни один вариант.");
            }
        }
    }
}
