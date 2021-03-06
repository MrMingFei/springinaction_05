<%--
  Created by IntelliJ IDEA.
  User: 18330
  Date: 2018/11/5
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Spitter</title>
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/resources/style.css" /> ">
</head>
<body>
    <h1>Register</h1>
    <%--<form method="POST">--%>
        <%--First Name: <input type="text" name="firstName" /><br/>--%>
        <%--Last Name: <input type="text" name="lastName" /><br/>--%>
        <%--Email: <input type="text" name="email" /><br/>--%>
        <%--Username: <input type="text" name="username" /><br/>--%>
        <%--Password: <input type="text" name="password" /><br/>--%>
        <%--<input type="submit" value="Register" />--%>
    <%--</form>--%>
    <sf:form method="post" modelAttribute="spitter">
        <sf:errors path="*" element="div" cssClass="errors" />

        <sf:label path="firstName" cssErrorClass="error">First Name</sf:label>:
        <sf:input path="firstName" cssErrorClass="error" /><br/>
        <sf:label path="lastName" cssErrorClass="error">Last Name</sf:label>:
        <sf:input path="lastName" cssErrorClass="error" /><br/>
        <sf:label path="email" cssErrorClass="error">Email</sf:label>:
        <sf:input path="email" cssErrorClass="error" /><br/>
        <sf:label path="username" cssErrorClass="error">Username</sf:label>:
        <sf:input path="username" cssErrorClass="error" /><br/>
        <sf:label path="password" cssErrorClass="error">Password</sf:label>:
        <sf:password path="password" cssErrorClass="error" /><br/>

        <input type="submit" value="Register" />
    </sf:form>
</body>
</html>
