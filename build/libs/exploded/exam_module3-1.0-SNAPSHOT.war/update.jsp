<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 12/11/2020
  Time: 10:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Edit customer</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/product">Back to product list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Product information</legend>
        <table>
            <input type="hidden" name="id" value="${requestScope["products"].getId()}">
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name" id="name" value="${requestScope["products"].getName()}"></td>
            </tr>
            <tr>
                <td>Price: </td>
                <td><input type="text" name="price" value="${requestScope["products"].getPrice()}"></td>
            </tr>
            <tr>
                <td>Quantity: </td>
                <td><input type="text" name="quantity" value="${requestScope["products"].getQuantity()}"></td>
            </tr>
            <tr>
                <td>Color: </td>
                <td><input type="text" name="color" value="${requestScope["products"].getColor()}"></td>
            </tr>
            <tr>
                <td>Description: </td>
                <td><input type="text" name="description" value="${requestScope["products"].getDescription()}"></td>
            </tr>
            <tr>
                <td>Category: </td>
                <td><select name="category">
                    <option value="1">Phone</option>
                    <option value="2">Television</option>
                </select></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update product"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
