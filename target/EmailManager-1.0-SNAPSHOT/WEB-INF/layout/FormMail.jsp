<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Objects" %><%--
 Created by IntelliJ IDEA.
  User: EDUCATION
  Date: 17/10/2022
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ListEmail</title>
    <link href="${pageContext.request.contextPath}/Style/custom.css" rel="stylesheet" type="text/css">
</head>
<body>
${msg}
<c:set var="list" value="${emlist}"/>

<h1> List email </h1>
<div class="listmail">
    <c:choose>
        <c:when test ="${list!=null}">
            <c:forEach items="${list}" var="value">
                <c:choose>
                    <c:when test ="${value!=null}">
                        <p><c:out value="${value}"/></p>
                    </c:when>
                </c:choose>
            </c:forEach>
        </c:when>
    </c:choose>
</div>
<div class="form-group">
    <form method="post" action="FormMail">
        <label for="email">Please enter your e-mail address</label>
        <input type="email" name="email" class="email" placeholder="Exemple@gmail.com">
        ${alert}
        <input type="submit" name="sb" value="subscribe"  class="btn-subscribe btn">
        <input type="submit" name="sb" value="unsubscribe" class="btn-unsubscribe btn">
    </form>
</div>
</body>
</html>
