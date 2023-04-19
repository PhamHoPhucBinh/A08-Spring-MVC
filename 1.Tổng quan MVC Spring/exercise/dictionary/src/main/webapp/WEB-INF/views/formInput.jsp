<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: TroubleMaker
  Date: 18-Apr-23
  Time: 5:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Translate Eng-Vi</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<form method="post">
    <table>
        <td>English: <input type="text" name="input" placeholder="input English"></td>
        <td><input type="submit" ></td>
    </table>
</form>
<p>Vietnamese: <fmt:formatNumber value="${output}" pattern="###,###"/></p>
</body>
</html>