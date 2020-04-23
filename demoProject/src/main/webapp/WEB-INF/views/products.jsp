<%@ page import="org.rado.app.db.entity.Product" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Product Page</title>
</head>
<body>

<h3>Products Page</h3>
<% @SuppressWarnings("unchecked") List<Product> products = (List<Product>) request.getAttribute("products"); %>
<table cellpadding="2" cellspacing="2" border="1">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Photo</th>
        <th>Price</th>
        <th>Buy</th>
    </tr>
        <% for (Product product : products) { %>
    <tr>
        <td><%= product.getId() %>
        </td>
        <td><%= product.getName() %>
        </td>
        <td>IMAGE</td>
        <td><%= String.format("%.2f$", product.getPrice()) %>
        </td>
        <td>
            <a href="/cart/buy/<%= product.getId() %>">Buy now</a>
        </td>
    </tr>
        <% } %>

</body>
</html>
