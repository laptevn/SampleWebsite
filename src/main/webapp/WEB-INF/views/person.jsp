<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Person details</title>
</head>

<div class="jumbotron">
    <div class="container">
        <h1>Name: ${name}</h1>
        <c:if test="${not empty email}">
            <h1>Email: ${email}</h1>
        </c:if>

        <c:if test="${not empty age}">
            <h1>Age: ${age}</h1>
        </c:if>
    </div>
</div>

<body/>
</html>