<%@ page import="org.rado.app.db.entity.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="java.math.BigDecimal" %>
<%@ page import="org.rado.app.db.entity.Item" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Cart</title>
</head>
<body>

<h3>Cart</h3>
<table cellpadding="2" cellspacing="2" border="1">
    <tr>
        <th>Option</th>
        <th>Id</th>
        <th>Name</th>
        <th>Photo</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Sub Total</th>
    </tr>
    <% BigDecimal total = new BigDecimal(0); %>
    <% @SuppressWarnings("unchecked") List<Item> cart = (List<Item>) session.getAttribute("cart"); %>
    <% for (Item item : cart) { %>
    <% total = total.add(total.add(item.getProduct().getPrice().multiply(new BigDecimal(item.getQuantity())))); %>
    <tr>
        <td align="center"><a href="/cart/remove/<%= item.getProduct().getId() %>"
                              onclick="return confirm('Are you sure?')">Remove</a></td>
        <td><%= item.getProduct().getId() %>
        </td>
        <td><%= item.getProduct().getName() %>
        </td>
        <td>IMAGE</td>
        <td><%= String.format("%.2f$", item.getProduct().getPrice()) %>
        </td>
        <td><%= item.getQuantity() %>
        </td>
        <td><%= String.format("%.2f$", item.getProduct().getPrice().multiply(new BigDecimal(item.getQuantity()))) %>
        </td>
    </tr>
    <% } %>
    <tr>
        <td colspan="6" align="right">Sum</td>
        <td><%= String.format("%.2f$", total) %>
        </td>
    </tr>
</table>
<br>
<a href="/">Continue Shopping</a>
</body>
</html>
