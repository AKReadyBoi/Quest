<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Quest</title>
</head>
<body>
<h1>${question}</h1>
<form action="" method="post">
    <label><input type="radio" name="option" value="1" id="option1">${option1}</label><br>
    <label><input type="radio" name="option" value="2" id="option2">${option2}</label><br>
    <input type="submit" value="Подтвердить" id="submit-button" disabled>
</form>
<h2>Количество сыгранных игр: ${numberOfGames}</h2>
<h2>Имя: ${userName}</h2>
<h2>IP-адрес: ${ip}</h2>
<script>
    document.addEventListener("DOMContentLoaded", function () {
        const option1 = document.getElementById("option1");
        const option2 = document.getElementById("option2");
        const submitButton = document.getElementById("submit-button");

        option1.addEventListener("change", function () {
            if (option1.checked || option2.checked) {
                submitButton.removeAttribute("disabled");
            } else {
                submitButton.setAttribute("disabled", "disabled");
            }
        });

        option2.addEventListener("change", function () {
            if (option1.checked || option2.checked) {
                submitButton.removeAttribute("disabled");
            } else {
                submitButton.setAttribute("disabled", "disabled");
            }
        });
    });
</script>
</body>
</html>
