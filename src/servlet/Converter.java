package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Converter", urlPatterns = {"/converter"})
public class Converter extends HttpServlet {



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String from = request.getParameter("from");
        String to = request.getParameter("to");

        System.out.println("from " + from);
        System.out.println("to" + to);

        try {
            MppManager mm = new MppManager(from, to);
            mm.converter();
        } catch (Exception e) {
            System.out.println(e);
        }
        out.println(from + to);

    }


}
