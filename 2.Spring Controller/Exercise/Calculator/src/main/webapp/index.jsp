<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
  <title>Calculator</title>
</head>
<body>
<h2>Calculator</h2>
<form method="post" action="/calculator">
  <div>
    <input name="num1">
    <input name="num2">
    <input type="hidden" name="operator" id="operator">
  </div>
  <div>
    <button type="submit" onclick="document.getElementById('operator').value = '+'">Addition (+)</button>
    <button type="submit" onclick="document.getElementById('operator').value = '-'">Subtraction (-)</button>
    <button type="submit" onclick="document.getElementById('operator').value = '*'">Multiplication (*)</button>
    <button type="submit" onclick="document.getElementById('operator').value = '/'">Division (/)</button>
  </div>
</form>

<c:if test="${not empty result}">
  <h2>Result: ${result}</h2>
</c:if>

</body>
</html>