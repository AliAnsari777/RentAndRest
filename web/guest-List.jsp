<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:if test="${logged != 'OK'}">
    <c:redirect url="login.html"></c:redirect>
</c:if>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Hotel Template">
    <meta name="keywords" content="Hotel, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Rent And Rest</title>

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
          crossorigin="anonymous">
    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css?family=Taviraj:300,400,500,600,700,800,900&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800&display=swap" rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="css/flaticon.css" type="text/css">
    <link rel="stylesheet" href="css/linearicons.css" type="text/css">
    <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="css/magnific-popup.css" type="text/css">
    <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="css/style.css" type="text/css">
    <style>
        li.nav-item{
            padding-right: 20px;
        }
        #navbarColor01{
            margin-left: 3%;
        }
    </style>
</head>

<body>
<%@ include file="fragment/header.html" %>

<!-- Page Preloder -->
<div id="preloder">
    <div class="loader"></div>
</div>

<div class="container"><br/>
    <h2>List of Guests</h2>
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">guest Name</th>
            <th scope="col">rating</th>
            <th scope="col">procedence</th>
            <th scope="col">language</th>
            <th scope="col">notes</th>
            <th scope="col">&nbsp;</th>
            <th scope="col">&nbsp;</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="guest" items="${guests}" varStatus="iteration">
            <tr>
                <th scope="row"><c:out value="${iteration.index+1}"></c:out>.</th>
                <td><c:out value="${guest.guestName}"></c:out></td>
                <td><c:out value="${guest.rating}"></c:out></td>
                <td><c:out value="${guest.procedence}"></c:out></td>
                <td><c:out value="${guest.language}"></c:out></td>
                <td><c:out value="${guest.note}"></c:out></td>
                <td><a href="editGuestformData?id=${guest.id}"   class="btn  delBtn" >Edit</a></td>
                <td><a href="deleteGuest?id=${guest.id}"   class="btn  delBtn" >Delete</a></td>

            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<footer class="footer fixed-bottom container">
    <hr>
    <p>&copy; 2019 Maharaishi university of management.</p>
</footer>
<!-- Js Plugins -->
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.magnific-popup.min.js"></script>
<script src="js/jquery-ui.min.js"></script>
<script src="js/jquery.nice-select.min.js"></script>
<script src="js/jquery.slicknav.js"></script>
<script src="js/owl.carousel.min.js"></script>
<script src="js/main.js"></script>
<script src="js/app.js"></script>

</body>

</html>