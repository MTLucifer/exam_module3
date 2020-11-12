<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 12/11/2020
  Time: 10:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Delete customer</h1>
<p>
    <a href="/product">Back to product list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Are you sure</legend>
        <table>
            <input type="hidden" name="id" value="${requestScope["products"].getId()}">
            <tr>
                <td>Name: </td>
                <td>${requestScope["products"].getName()}</td>
            </tr>
            <tr>
                <td>Price: </td>
                <td>${requestScope["products"].getPrice()}</td>
            </tr>
            <tr>
                <td>Quantity: </td>
                <td>${requestScope["products"].getQuantity()}</td>
            </tr>
            <tr>
                <td>Color: </td>
                <td>${requestScope["products"].getColor()}</td>
            </tr>
            <tr>
                <td>Description: </td>
                <td>${requestScope["products"].getDescription()}</td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Delete product"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
