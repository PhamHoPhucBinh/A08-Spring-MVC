<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 14-Apr-23
  Time: 6:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Money Exchange</title>
</head>
<br>
<div>
    <form action="/result" method="post">
        <p>USD</p>
        <input type="number" name="usd" id="floatingInput">
        </br>
        <button type="submit"> Exchange</button>
    </form>
    <p>${vnd}</p>

</div>

</body>
</html>
