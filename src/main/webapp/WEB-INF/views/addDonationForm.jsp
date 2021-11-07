<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>




<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Document</title>
    <link rel="stylesheet" href="<c:url value="../../resources/css/style.css"/>"/>

</head>
<body>
<header class="header--main-page">
    <nav class="container container--70">
        <ul class="nav--actions">
            <li><a href="" class="btn btn--small btn--without-border">Zaloguj</a></li>
            <li><a href="/add/user" class="btn btn--small btn--highlighted">Załóż konto</a></li>
        </ul>

        <ul>
            <li><a href="#" class="btn btn--without-border active">Start</a></li>
            <li><a href="#" class="btn btn--without-border">O co chodzi?</a></li>
            <li><a href="#" class="btn btn--without-border">O nas</a></li>
            <li><a href="#" class="btn btn--without-border">Fundacje i organizacje</a></li>
            <li><a href="#" class="btn btn--without-border">Kontakt</a></li>
        </ul>
    </nav>

    <div class="slogan container container--90">
        <div class="slogan--item">
            <h1>
                Zacznij pomagać!<br/>
                Oddaj niechciane rzeczy w zaufane ręce
            </h1>
        </div>
    </div>
</header>
<h2>
    Formularz darowizny
</h2>
<div class="form-group">
<form:form modelAttribute="donation" method="post" action="/add/donation" cssClass="form--contact">

     <form:input path="quantity" placeholder="Liczba worków" /><br>
     <form:select items="${categories}" path="category" itemValue="id" itemLabel="name" /><br>

    <form:select  items="${institutions}" path="institution" itemValue="id" itemLabel="name" /><br>
     <form:input path="street" placeholder="Ulica" /><br>
     <form:input path="city" placeholder="Miasto" /><br>
    <form:input path="zipCode" placeholder="Kod pocztowy" /><br>
    <form:textarea path="pickUpComment" placeholder="Uwagi" /><br>
    <label>Podaj datę odbioru:</label><br>
    <form:input type="date" path="pickUpDate" /><br>
    <label>Podaj godzinę odbioru:</label><br>
    <form:input type="time" path="pickUpTime"  /><br>

    <button type="submit" class="btn">Wyślij</button>

    <form:errors path="*"/>




</form:form>
</div>

<footer>
    <div class="contact">
        <h2>Skontaktuj się z nami</h2>
        <h3>Formularz kontaktowy</h3>
        <form class="form--contact">
            <div class="form-group form-group--50"><input type="text" name="name" placeholder="Imię"/></div>
            <div class="form-group form-group--50"><input type="text" name="surname" placeholder="Nazwisko"/></div>

            <div class="form-group"><textarea name="message" placeholder="Wiadomość" rows="1"></textarea></div>

            <button class="btn" type="submit">Wyślij</button>
        </form>
    </div>
    <div class="bottom-line">
        <span class="bottom-line--copy">Copyright &copy; 2018</span>
        <div class="bottom-line--icons">
            <a href="#" class="btn btn--small"><img src="images/icon-facebook.svg"/></a> <a href="#"
                                                                                            class="btn btn--small"><img
                src="images/icon-instagram.svg"/></a>
        </div>
    </div>
</footer>

<script src="<c:url value="resources/js/app.js"/>"></script>

</body>


</html>