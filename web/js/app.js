$(document).ready(function () {
    function msg(){
        let val = $("#msg").val();
        if(val == "yes"){
            alert("Form submitted successfully")
        }
    }
    setTimeout(msg,1500);

    $("#booking").submit(function (event) {
        let checkin = $("#checkinDate").val();
        let checkout = $("#checkoutDate").val();
        if (checkin > checkout){
            event.preventDefault();
            $("#checkinDate").val("");
            $("#checkoutDate").val("");
            alert("Check-in Date should be before check-out Date");
        }
    })
});

