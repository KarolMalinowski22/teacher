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
        console.log(values);

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
function extractPresenceFromCheckbox() {
    var presenceObjects;
    var presenceValues = [''];
    var presenceCheckboxContainer = document.getElementById("presenceCheckboxContainer");
    presenceObjects = presenceCheckboxContainer.getElementsByTagName("presence");
    var i;
    var length = presenceObjects.length;
    for(i = 0; i < length; i++){
        if(presenceObjects[i].checked){
            presenceValues.push(presenceObjects[i].value)
        }
    }

    var presenceDto = document.getElementById("presenceDto");
    presenceDto.value=null;
    presenceDto.value = presenceValues;
    console.log(presenceValues.value);
}

function processDto(formId)
{
    var teachersSelected = document.getElementById("teachersSelected");

    teachersSelected.value = values;

    console.log(teachersSelected.value);

    document.getElementById(formId).submit();
}

