<%--
  Created by IntelliJ IDEA.
  User: EDUCATION
  Date: 27/11/2022
  Time: 23:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Inscrit</title>
    <link href="${pageContext.request.contextPath}/Style/custom.css" rel="stylesheet" type="text/css">
</head>
<body>
    <div class="form-group">
    <form method="post" action="FormMail">
        <label for="email">Please enter your e-mail address</label>
        <input type="email" name="email" class="email" placeholder="Exemple@gmail.com">
        <input type="submit" name="sb" value="subscribe"  class="btn-subscribe btn">
        <input type="submit" name="sb" value="unsubscribe" class="btn-unsubscribe btn">
    </form>
    </div>
</body>
</html>
