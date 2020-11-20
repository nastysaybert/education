<!--%@page import="Servlet"% -->
<%@page contentType="text/html; charset=UTF-8" language="java" %>

<html>
<body>
<h2>Давайте знакомиться!</h2>
<form action="servlet" method="POST">
    <fieldset>
        <table>
            <legend><h3>Введите данные о себе:</h3></legend>
            <tr>
                <td align="left">Фамилия</td>
                <td><input name="surname" type="text" required placeholder="Иванов"></td>
            </tr>
            <tr>
                <td align="left">Имя</td>
                <td><input name="name" type="text" required placeholder="Иван"></td>
            </tr>
            <tr>
                <td align="left">Отчество</td>
                <td><input name="lastname" type="text" required placeholder="Иванович"></td>
            </tr>
            <tr>
                <td align="left">Дата рождения</td>
                <td><input name="dateOfBirth" type="date" required placeholder="01.01.1991"></td>
            </tr>
        </table>
    </fieldset>
    <br>
    <button formaction="servlet" type="submit">Запомнить</button>
</form>

</body>
</html>