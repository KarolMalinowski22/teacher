var values = [''];
var flag = false;

jQuery(document).ready(function ($) {

    $(".clickRowToUpdate").click(function () {
        window.location = $(this).find("a").attr("href");
    });

    $(".expandable").hover(function () {
        $(this).stop().animate({"height": "99%"}, 1000).addClass("dropped");
    }, function () {
        $(this).stop().animate({"height": "40px"}, 1000).removeClass("dropped");
    });


    //multiselect boxes - to extract

    $("#choice").chosen().change(function(e, params) {
        console.log("inside function to change 'values'");

        values = $("#choice").chosen().val();
        //values is an array containing all the results.
    });

    $("#choice").chosen().ready(function(e, params){
        console.log("inside first function to change 'values'");

        values = $("#choice").chosen().val();
        console.log(values);
        //values is an array containing all the results.
    });

    $('#choice').chosen(console.log("weszłem"));




});
function processDto(formId)
{
    var transporter = document.getElementById("transporter");

    transporter.value = values;

    console.log(transporter.value);

    document.getElementById(formId).submit();
}

