<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="util" %>


<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Document</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>" />
</head>
<body>


<header>
    <nav class="container container--70">
        <ul class="nav--actions">
            <sec:authorize access="isAuthenticated()">
                <form action="<c:url value='/logout'/>">
                    <li><button class="btn btn--small btn--without-border" type="submit">Wyloguj</button></li>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>
            </sec:authorize>
        </ul>

        <ul>
            <li><a href="/" class="btn btn--without-border active">Start</a></li>
            <li><a href="/institution/list" class="btn btn--without-border">Lista fundacji</a></li>
            <li><a href="/donation/list" class="btn btn--without-border">Lista darów</a></li>
            <li><a href="/donation/archive/list" class="btn btn--without-border">Archiwum darów</a></li>
        </ul>
    </nav>
</header>

<sec:authorize access="isAuthenticated()">

    <section class="login-page">
    <h3>Dary oczekujące na dostarczenie</h3>
    <ul>

<c:forEach items="${donationList.content}" var="donation">



    <li style="font-size: 20px"> ${donation.institution} ${donation.city} ${donation.street} ${donation.pickUpDate} ${donation.pickUpTime}
        <a href="/donation/delete/${donation.id}" >Usuń</a> <a href="/donation/archive/${donation.id}" >Archiwizuj</a></li>



</c:forEach>


    </ul>

        <util:pagination thispage="${donationList}"></util:pagination>

    </section>



</sec:authorize>





</body>
</html>
