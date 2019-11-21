<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<c:if test="${logged != 'OK'}">
    <c:redirect url="login.html"></c:redirect>
</c:if>

<!DOCTYPE html>
<html lang="en">
<%@ include file="fragment/head.jsp"%>
<body>
    <%@ include file="fragment/header.html"%>
    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>

    <h1 style="text-align: center; font-family: cursive; color: #bd4147">Rent and Rest</h1>

    <div class="container"><br/>
        <h2>Daily Check-Ins & Check-Outs</h2>
        <h3>From: ${fromDate}  to  ${toDate}</h3>
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Room Number</th>
                <th scope="col">Guest Name</th>
                <th scope="col"># Guests</th>
                <th scope="col">Stay Length</th>
                <th scope="col">Procedence</th>
                <th scope="col">Language</th>
                <th scope="col">CheckIn Date</th>
                <th scope="col">CheckIn Time</th>
                <th scope="col">CheckOut Date</th>
                <th scope="col">CheckOut Time </th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="bookingData" items="${bookingsList}" varStatus="iteration">
                <tr>
                    <th scope="row"><c:out value="${iteration.index+1}"></c:out>.</th>
                    <td><c:out value="${bookingData.room_number}"></c:out></td>
                    <td><c:out value="${bookingData.guest_name}"></c:out></td>
                    <td><c:out value="${bookingData.number_of_guests}"></c:out></td>
                    <td><c:out value="${bookingData.stay_length}"></c:out></td>
                    <td><c:out value="${bookingData.procedence}"></c:out></td>
                    <td><c:out value="${bookingData.language}"></c:out></td>
                    <td><c:out value="${bookingData.checkIn_date}"></c:out></td>
                    <td><c:out value="${bookingData.checkIn_time}"></c:out></td>
                    <td><c:out value="${bookingData.checkOut_date}"></c:out></td>
                    <td><c:out value="${bookingData.checkOut_time}"></c:out></td>
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
</body>
</html>
