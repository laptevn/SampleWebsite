<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Welcome page</title>
</head>

<div class="jumbotron">
    <div class="container">
        <h1>Welcome to my first web app</h1>

        <form action="query">
            First name: <input type="text" name="name" value="Sam Wilson"><br>
            <input type="submit" value="Submit">
        </form>
    </div>
</div>

<body/>
</html>