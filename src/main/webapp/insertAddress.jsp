<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<body>
<h2>Приятно познакомиться!</h2>
<form action="insertAddress" method="POST">
    <fieldset>
        <table>
            <legend><h3>Теперь введем адрес:</h3></legend>
            <tr>
                <td align="left">Посетитель:</td>
                <td><select name="visitorsList" required>
                        <c:forEach var="visitor" items="${allVisitors}">
                            <option value="${visitor.getVisitorId()}">
                                    ${visitor.getSurname()} ${visitor.getName()} ${visitor.getLastname()}
                            </option>
                        </c:forEach>
                    </select></td>
            </tr>

            <tr>
                <td align="left">Улица</td>
                <td><input name="street" type="text" required placeholder="Творческая"></td>
            </tr>
            <tr>
                <td align="left">Дом</td>
                <td><input name="house" type="text" required placeholder="4б"></td>
            </tr>
            <tr>
                <td align="left">Квартиира</td>
                <td><input name="flat" type="number" required placeholder="58"></td>
            </tr>
        </table>
    </fieldset>
    <br>
    <button formaction="insertAddress" type="submit">Запомнить</button>
</form>

</body>
</html>