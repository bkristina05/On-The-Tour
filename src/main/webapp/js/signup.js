/**
 * Created by Daria on 12.12.2014.
 */
function signup() {

    var name = $("#name").val();
    var login = $("#login").val();
    var password =$("#password").val();
    var confirmation_password =$("#confirmation_password").val();
    var age = $("#age").val();
    var town =$("#town").val();
    var email = $("#email").val();
    var phone =$("#phone").val();

    $.ajax({
        url : 'signup',
        type: 'GET',
        dataType: 'json',
        contentType: 'application/json',
        mimeType: 'application/json',
        data : "login=" + login +
                "&password=" + password +
                "&name=" + name +
                "&confirmation_password=" + confirmation_password +
                "&age=" + age +
                "&town=" + town +
                "&email=" + email +
                "&phone=" + phone,
        success: function (data) {
             $("#resultSignup").html(data.text);
        }
    });

}

function enter(){
    var enter = $("#enter").val();
    if(enter='Войти') location.href = '/login.jsp';
}
