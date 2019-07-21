<%--
  Created by IntelliJ IDEA.
  User: 18330
  Date: 2018/11/1
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spitter</title>
    <link rel="stylesheet"
          type="text/css"
          href="<c:url value="/resources/style.css" />">
</head>
<body>
   <h1><s:message code="spitter.welcome" text="Welcome" /> </h1>

   <s:url value="/spitter/register" var="registerUrl" />

   <a href="<c:url value="/spittles" />">Spittles</a> |
   <a href="${registerUrl}">Register</a>
</body>
</html>
