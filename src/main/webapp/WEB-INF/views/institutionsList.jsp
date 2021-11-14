<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Document</title>
    <link rel="stylesheet" href="<c:url value="../../resources/css/style.css"/>" />
</head>
<body>
<header>
    <nav class="container container--70">
        <ul class="nav--actions">
            <c:if test="${user.name != null }">
                <li><a href="/logout" class="btn btn--small btn--without-border">Wyloguj</a></li>
            </c:if>
        </ul>

        <ul>
            <li><a href="/" class="btn btn--without-border active">Start</a></li>
            <li><a href="/#steps" class="btn btn--without-border">O co chodzi?</a></li>
            <li><a href="/#aboutUs" class="btn btn--without-border">O nas</a></li>
            <li><a href="/#organizations" class="btn btn--without-border">Fundacje i organizacje</a></li>
            <li><a href="/#contact" class="btn btn--without-border">Kontakt</a></li>
        </ul>
    </nav>
</header>

<c:if test="${user.admin == 1}">
<section class="login-page">
    <h2>Lista organizacji:</h2>

    <ul>
    <c:forEach items="${institutionsList}" var="inst">
        <li style="font-size: 20px">${inst.name} <a href="/institution/delete/${inst.id}">Usuń</a> </li>



    </c:forEach>
    </ul>

</section>



<section class="login-page">
<h2>Dodaj instytucję</h2>

    <form method="post" action="/institution/add">
        <p style="font-size: larger">${errorsInstitution}</p>
        <div class="form-group">
            <input name="name" placeholder="Nazwa Instytucji" required/>
        </div>
        <div class="form-group">
            <textarea name="description" placeholder="Opis Instytucji" required></textarea>
        </div>

        <div class="form-group form-group--buttons">
            <button class="btn" type="submit">Dodaj instytucję</button>
        </div>
    </form>
</section>
</c:if>

<footer>
    <div class="contact">
        <h2>Skontaktuj się z nami</h2>
        <h3>Formularz kontaktowy</h3>
        <form>
            <div class="form-group form-group--50">
                <input type="text" name="name" placeholder="Imię" />
            </div>
            <div class="form-group form-group--50">
                <input type="text" name="surname" placeholder="Nazwisko" />
            </div>

            <div class="form-group">
            <textarea
                    name="message"
                    placeholder="Wiadomość"
                    rows="1"
            ></textarea>
            </div>

            <button class="btn" type="submit">Wyślij</button>
        </form>
    </div>
    <div class="bottom-line">
        <span class="bottom-line--copy">Copyright &copy; 2018</span>
        <div class="bottom-line--icons">
            <a href="#" class="btn btn--small"
            ><img src="images/icon-facebook.svg"
            /></a>
            <a href="#" class="btn btn--small"
            ><img src="images/icon-instagram.svg"
            /></a>
        </div>
    </div>
</footer>
</body>
</html>
