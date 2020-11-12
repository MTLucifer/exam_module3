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
<h1>Create new customer</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/product">Back to customer list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name" id="name"></td>
            </tr>
            <tr>
                <td>Price: </td>
                <td><input type="text" name="price" ></td>
            </tr>
            <tr>
                <td>Quantity: </td>
                <td><input type="text" name="quantity" ></td>
            </tr>
            <tr>
                <td>Color: </td>
                <td><input type="text" name="color" ></td>
            </tr>
            <tr>
                <td>Description: </td>
                <td><input type="text" name="description" ></td>
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
                <td><input type="submit" value="Create Product"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
