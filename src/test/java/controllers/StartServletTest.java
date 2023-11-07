package controllers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

public class StartServletTest {
    @Mock
    HttpServletRequest request;
    @Mock
    HttpServletResponse response;
    @Mock
    HttpSession session;
    @Mock
    RequestDispatcher requestDispatcher;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testQuestWhenOption1() throws ServletException, IOException {
        StartServlet servlet = new StartServlet();
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("progress")).thenReturn(1);
        when(request.getRequestDispatcher("start.jsp")).thenReturn(requestDispatcher);
        servlet.doGet(request, response);
        verify(request).setAttribute("question", "Вы и ваш экипаж прибываете на остров, который, как говорят легенды, скрывает сокровища Черной Бороды. После длительных поисков, вы находите старый заброшенный маяк, где, кажется, спрятаны сокровища. Ваши действия?");
        verify(requestDispatcher).forward(request, response);
    }

    @Test
    void testQuestWhenOption2() throws ServletException, IOException {
        StartServlet servlet = new StartServlet();
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("progress")).thenReturn(2);
        when(request.getRequestDispatcher("restart.jsp")).thenReturn(requestDispatcher);
        servlet.doGet(request, response);
        verify(requestDispatcher).forward(request, response);
    }
}

