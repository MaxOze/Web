const login = document.getElementById('floatingLogin')

$(document).ready(function() {
    $('#floatingLogin').on("input", function(e) {
        const div = login.parentElement;
        const message = document.getElementById('loginMsg');
        if(login.value.trim() == null || login.value.trim() === "") {
            div.className = 'form-floating error';
            message.innerText = "Login cannot be empty";
        } else {
            $.ajax({
                type: 'post',
                url: "/signup/check",
                data: JSON.stringify({ input: $('#floatingLogin').val()} ),
                contentType: "application/json; charset=utf-8",
                cache: false,
                statusCode: {
                    500: function(xhr) {
                        div.className = 'form-floating success';
                    },
                    200: function (xhr) {
                        div.className = 'form-floating error';
                        message.innerText = "Login already taken";
                    }
                }
            })
        }
    })
})