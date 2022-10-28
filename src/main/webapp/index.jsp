<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Accueil</title>
    <link href="${pageContext.request.contextPath}/Style/custom.css" rel="stylesheet" type="text/css">
</head>
<body>
<img class="img-responsive" src="${pageContext.request.contextPath}/img/background.png" alt="backrounded"/>
<header>
    <h1><%= "Bienvenu à Email Manager " %>
    </h1>
</header>


<a class="btn_priamry" href="ListEmailServlet">Gérer la liste d'email</a>
</body>
</html>

