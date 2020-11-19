import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@WebServlet("/servlet")
public class Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        PrintWriter pw = resp.getWriter();

        String url = "jdbc:mariadb://localhost:3306/Task4";
        String username = "root";
        String password = "root";
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            String surname = req.getParameter("surname");
            String name  = req.getParameter("name");
            String lastname = req.getParameter("lastname");
            String dateInString = req.getParameter("dateOfBirth");
            DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDateTime.parse("2020",DateTimeFormatter.ofPattern("yyyy"));
            LocalDate dateOfBirth = LocalDate.parse(dateInString, format);

            String sql = "insert into Visitors (Surname, Name, Lastname, DateOfBirth)  values (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, surname);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, lastname);
            preparedStatement.setDate(4, Date.valueOf(dateOfBirth));
            ResultSet resultSet = preparedStatement.executeQuery();

            //ResultSet resultSet = statement.executeQuery("insert into Visitors (Surname, Name, Lastname, DateOfBirth)  values (surname, name, lastname, dateOfBirth);");
            resultSet = statement.executeQuery("SELECT * FROM Visitors");
            while (resultSet.next()){
                pw.println("VisitorID: " + resultSet.getInt(1) + "<br>");
                pw.println("Surname: " + resultSet.getString(2) + "<br>");
                pw.println("Name: " + resultSet.getString(3) + "<br>");
                pw.println("Lastname: " + resultSet.getString(4) + "<br>");
                pw.println("DateOfBirth: " + resultSet.getDate(5) + "<br>");
                pw.println("<br>");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
