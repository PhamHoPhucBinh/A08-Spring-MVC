<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 21-Apr-23
  Time: 10:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>hiih</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<h1>view-edit</h1>
<table>
  <form:form method="post" modelAttribute="setting" action="/save">
    <tr>
      <td>Languages</td>
      <td>
        <form:select path="language" cssClass="form-select">
          <form:option value="English">English</form:option>
          <form:option value="Vietnamese">Vietnamese</form:option>
          <form:option value="Japanese">Japanese</form:option>
          <form:option value="Chinese">Chinese</form:option>
        </form:select>
      </td>
    </tr>
    <tr>
      <td>Page Size:</td>
      <td>
        Show
        <form:select path="pageSize">
          <form:option value="5">5</form:option>
          <form:option value="10">10</form:option>
          <form:option value="15">15</form:option>
          <form:option value="25">25</form:option>
          <form:option value="50">50</form:option>
          <form:option value="100">100</form:option>
        </form:select>
        emails per page
      </td>
    </tr>
    <tr>
      <td>Spams filter:</td>
      <td class="d-flex">
        <form:checkbox path="spamFilter" value="true" cssClass="form-check"/>
        Enable spams filter
      </td>
    </tr>
    <tr>
      <td>Signature</td>
      <td>
        <form:textarea path="signature" rows="7" cols="20"></form:textarea>
      </td>
    </tr>
    <tr>
      <td></td>
      <td>
        <button type="submit">Update</button>
        <button type="button">Cancel</button>
      </td>
    </tr>
  </form:form>
</table>
</body>
</html>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"></script>
