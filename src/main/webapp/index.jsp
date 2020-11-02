<%@page import="main.java.Servlet1"%>
<%@page import="main.java.Servlet2"%>
<%@page contentType="text/html; charset=UTF-8" language="java" %>

<html>
    <body>
        <h2>Hello World!</h2>
        <form action="servlet1" method="POST">
            <fieldset>
                <legend>Введите имя:</legend>
                <label>Имя    <input name="name" type="text" required placeholder="John Doe"></label>
            </fieldset>
            <br>
            <button type="submit">Servlet1</button>
            <button type="submit">Servlet2</button>
        </form>

    </body>
</html>
