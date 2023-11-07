<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Quest</title>
</head>
<body>
<h1>${question}</h1>
<form action="${pageContext.request.contextPath}/restart" method="get">
    <input type="submit" value="Рестарт">
</form>
<h2>Количество сыгранных игр: ${numberOfGames}</h2>
<h2>IP-адрес: ${ip}</h2>
</body>
</html>
