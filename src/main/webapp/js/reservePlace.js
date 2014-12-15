/**
 * Created by Daria on 15.12.2014.
 */
function reservePlace() {

    var login = $("#login").val();
    var idExcursion = $("#idExcursion").val();
    var town = $("#town").val();
    var place = $("#place").val();
    var availablePlaces =$("#availablePlaces").val();
    var duration =$("#duration").val();
    var numberPersons = $("#numberPersons").val();


    $.ajax({
        url : 'reservePlace',
        type: 'GET',
        dataType: 'json',
        contentType: 'application/json',
        mimeType: 'application/json',
        data : "place=" + place +
            "&login=" + login +
            "&idExcursion=" + idExcursion +
            "&town=" + town +
            "&availablePlaces=" + availablePlaces +
            "&duration=" + duration +
            "&numberPersons=" + numberPersons,
        success: function (data) {
            $("#resultReservePlace").html(data.text);
        }
    });

}

