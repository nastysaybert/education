import DAO.VisitorService;
import models.Visitor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;


@WebServlet("/servlet")
public class Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        PrintWriter pw = resp.getWriter();

        Visitor visitorFromForm = new Visitor();

        visitorFromForm.setSurname(req.getParameter("surname"));
        visitorFromForm.setName(req.getParameter("name"));
        visitorFromForm.setLastname(req.getParameter("lastname"));
        String dateInString = req.getParameter("dateOfBirth");
        visitorFromForm.setDateOfBirth(LocalDate.parse(dateInString));

        VisitorService visitorService = new VisitorService();
        visitorService.insertVisitor(visitorFromForm);

        List <Visitor> allVisitors= visitorService.getAllVisitors();
        for (Visitor v: allVisitors){
            v.print(pw);
        }

    }
}
