

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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

    <div class="container">
        <form action="/RentAndRest/Room" method="post">
            <div class="form-group">
                <label>Room Number</label>
                <input type="text" name="number" class="form-control" /></div>
            <div class="form-group">
                <label>Room Title</label>
                <input type="text" name="title" class="form-control" /></div>
            <div class="form-group">
                <label>Room Description</label>
                <input type="text" name="description" class="form-control" /></div>
            <div class="form-group">
                <label>Cost</label>
                <input type="text" name="cost" class="form-control" /></div>

            <input type="file" name="fileupload" value="fileupload" id="fileupload">
            <label for="fileupload"> Select a file to upload</label>
            <br><input type="image" src="/wp-content/uploads/sendform.png" width="100">
            <input hidden type="text" id="msg" value="${msg}" />
            <button type="submit" class="btn btn-primary" >submit</button>
        </form>
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