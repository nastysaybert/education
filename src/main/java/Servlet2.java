package main.java;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@WebServlet("/servlet2")
public class Servlet2 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        //resp.addHeader("Content-Type","text/html; charset=UTF-8");
        PrintWriter pw = resp.getWriter();
        String name = req.getParameter("name");
        if (name == null){
            req.setAttribute("name","Anonimus");
        }
        else{
            req.setAttribute("name",name);
            //pw.println("Hello, " + req.getParameter("name") + "!");
        }
        getServletContext().getRequestDispatcher("/sayHello.jsp").forward(req, resp);
    }
}