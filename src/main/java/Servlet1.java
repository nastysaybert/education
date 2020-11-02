package main.java;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

//@WebServlet("/servlet1")
public class Servlet1 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        resp.addHeader("Content-Type","text/html; charset=UTF-8");
        PrintWriter pw = resp.getWriter();
        if (req.getParameter("name").isEmpty()){
            pw.println("Hello, anonimus!");
        }
        else{
            pw.println("Hello, " + req.getParameter("name") + "!");
        }
        //getServletContext().getRequestDispatcher("/ind.jsp").forward(req, resp);
    }
}
