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


@WebServlet("/insertAddress")
public class InsertAddressServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        PrintWriter pw = resp.getWriter();

        VisitorService visitorService = VisitorService.getInstance();
        Address addressFromForm = new Address();

        addressFromForm.setFlat(Integer.parseInt(req.getParameter("flat")));
        addressFromForm.setHouse(req.getParameter("house"));
        addressFromForm.setStreet(req.getParameter("street"));
        addressFromForm.setVisitor(visitorService.findVisitorById(Integer.parseInt(req.getParameter("visitorsList"))));
        visitorService.insertAddress(addressFromForm);

        List <Visitor> allVisitors = visitorService.getAllVisitors();

        for (Visitor v : allVisitors){
            v.print(pw);
        }
    }
}
