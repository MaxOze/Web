$(document).ready(function() {
    $('#floatingLogin').on("input", function(e) {
        $('#loginMsg').hide();
        if($('#floatingLogin').val() == null || $('#floatingLogin').val() === "") {
            $('#loginMsg').show();
            $("#loginMsg").html("Login is a required field.").css("color", "red");
        } else {
            $.ajax({
                type: 'post',
                url: "/signup/check",
                data: JSON.stringify({ input: $('#floatingLogin').val()} ),
                contentType: "application/json; charset=utf-8",
                cache: false,
                statusCode: {
                    500: function(xhr) {
                        $('#loginMsg').show();
                        $('#loginMsg').html("Login available.").css("color", "green");
                    },
                    200: function (xhr) {
                        $('#loginMsg').show();
                        $("#loginMsg").html("Login already taken").css("color", "red");
                    }
                }
            })
        }
    })
})

// вместо .show сделать как в validator