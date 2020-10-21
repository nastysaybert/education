<%@page import="main.java.TestServlet"%>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java" %>

<html>
<body>
<h2>Hello, <%= request.getAttribute("name").toString() %></h2>

<hr>
<p>Как сделал Женя</p>
<h3>${name}</h3>
</body>
</html>
