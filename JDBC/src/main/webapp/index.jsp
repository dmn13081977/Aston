<%@ page contentType="text/html; charset=UTF-8"%>

<html>
<head>
  <title>Index JSP</title>
</head>
<body>
<h1>Test</h1>
<p>
  <%
    java.util.Date now = new java.util.Date();
    String s = "Текущая дата: " + now;
  %>
  <%= s %>
</p

<br/>
<br/>

<a href="books">One to many</a>

<br/>
<br/>

<a href="authors">Many to many</a>

</body>
</html>
