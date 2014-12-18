/**
 * Created by Daria on 15.12.2014.
 */
function reservePlace() {

    var login = $("#login").val();
    var idExcursion = $("#idExcursion").val();
    var numberPersons = $("#numberPersons").val();


    $.ajax({
        url : 'reservePlace',
        type: 'GET',
        dataType: 'json',
        contentType: 'application/json',
        mimeType: 'application/json',
        data : "login=" + login +
            "&idExcursion=" + idExcursion +
            "&numberPersons=" + numberPersons,
        success: function (data) {
            $("#resultReservePlace").html(data.text);
        }
    });

}

