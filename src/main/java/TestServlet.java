package main.java;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet("/")
public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        //PrintWriter printWriter = resp.getWriter();
        String name = req.getParameter("name");
        if (name == null){
            req.setAttribute("name","Anonimus");
            //printWriter.write("Hello!");
        }
        else {
            req.setAttribute("name",name);
            //printWriter.write("Hello, " + name + "!");
        }
        getServletContext().getRequestDispatcher("/ind.jsp").forward(req, resp);
        //req.getRequestDispatcher("/ind.jsp").forward(req, resp);
        //printWriter.close();
    }
}
