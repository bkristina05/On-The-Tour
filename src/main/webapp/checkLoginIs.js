/**
 * Created by Daria on 11.12.2014.
 */
function checkLoginIs() {

    var login = $("#login").val();
    var password =$("#password").val();

    $.ajax({
        url : 'login',
        type: 'GET',
        dataType: 'json',
        contentType: 'application/json',
        mimeType: 'application/json',
        data : "login=" + login + "&password=" + password,
            success: function (data) {
                if(data.text=="true")  location.href = '/homePage.jsp';
                else $("#result").html(data.text);
            }
    });

}

function registration(){
    var registration = $("#registration").val();
    if(registration='Регистрация') location.href = '/signup.jsp';
}