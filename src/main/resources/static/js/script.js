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

    $("#teacherChoice").chosen().change(function(e, params) {
        console.log("inside function to change 'values'");

        values = $("#teacherChoice").chosen().val();
        //values is an array containing all the results.
    });

    $("#teacherChoice").chosen().ready(function(e, params){
        console.log("inside first function to change 'values'");

        values = $("#teacherChoice").chosen().val();
        console.log(values);
        //values is an array containing all the results.
    });

    $('#teacherChoice').chosen(console.log("weszłem"));




});
function processGroupDto(formId)
{
    var teachersTransporter = document.getElementById("teachersTransporter");

    teachersTransporter.value = values;

    console.log(teachersTransporter.value);

    document.getElementById('updateGroup').submit();
}

