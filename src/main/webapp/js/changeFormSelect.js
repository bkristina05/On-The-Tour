/**
 * Created by Daria on 13.12.2014.
 */

// Создаем новый объект связанных списков
var syncList1 = new syncList;

// Определяем значения подчиненных списков (2 и 3 селектов)
syncList1.dataList = {

    /* Определяем элементы второго списка в зависимости
     от выбранного значения в первом списке */

    'Санкт-Петербург':{
        'Исаакиевский собор':'Исаакиевский собор',
        'Петергоф - Петродворец':'Петергоф - Петродворец',
        '1':'1'
    },

    'Москва':{
        'Коломенское':'Коломенское'
    }
};

// Включаем синхронизацию связанных списков
syncList1.sync("select1","select2");


function find(){
    var town = $("#select1").val();
    var place = $("#select2").val();
    $.ajax({
        url : 'searchTours',
        type: 'GET',
        dataType: 'json',
        contentType: 'application/json',
        mimeType: 'application/json',
        data : "town=" + town +
            "&place=" + place,
        success: function (data) {
            $("#resultSelect").html(data.text);
        }
    });
}