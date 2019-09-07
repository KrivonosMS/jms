package ru.krivonos;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/produce")
public class ProducerServlet extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(ProducerServlet.class.getName());
    @EJB
    private Producer producer;
    public  void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            long price = Long.valueOf(request.getParameter("price"));
            producer.sendMessage(price);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.getMessage(), e);
            response.getWriter().write(e.getMessage());
        }
    }
}
