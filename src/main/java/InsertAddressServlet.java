import DAO.VisitorService;
import models.Address;
import models.Visitor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet("/insertAddressServlet")
public class InsertAddressServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        PrintWriter pw = resp.getWriter();

        VisitorService visitorService = new VisitorService();
        Address addressFromForm = new Address();

        addressFromForm.setFlat(Integer.parseInt(req.getParameter("flat")));
        addressFromForm.setHouse(req.getParameter("house"));
        addressFromForm.setStreet(req.getParameter("street"));
        addressFromForm.setVisitor(visitorService.findVisitorById(Integer.parseInt(req.getParameter("visitorsList"))));
        //addressFromForm.setVisitor(visitorService.findVisitorById(req.getParameter("visitor"))));
        //это если id пользователя получаем как int, иначе надо убрать конструкцию с parseInt
        visitorService.insertAddress(addressFromForm);

        List <Visitor> allVisitors = visitorService.getAllVisitors();

        for (Visitor v : allVisitors){
            v.print(pw);
        }

        /*

        Visitor visitorFromForm = new Visitor();

        visitorFromForm.setSurname(req.getParameter("surname"));
        visitorFromForm.setName(req.getParameter("name"));
        visitorFromForm.setLastname(req.getParameter("lastname"));
        String dateInString = req.getParameter("dateOfBirth");
        visitorFromForm.setDateOfBirth(LocalDate.parse(dateInString));

        VisitorService visitorService = new VisitorService();
        visitorService.insertVisitor(visitorFromForm);

        List <Visitor> allVisitors= visitorService.getAllVisitors();
        /*for (Visitor v: allVisitors){
            v.print(pw);
        }

        req.setAttribute("allVisitors", allVisitors);*/
        //getServletContext().getRequestDispatcher("/insertAddress.jsp").forward(req, resp);
    }
}
