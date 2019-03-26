jQuery(document).ready(function ($) {

    $(".clickRowToUpdate").click(function () {
        window.location = $(this).find("a").attr("href");
    });

    $(".expandable").hover(function () {
        $(this).stop().animate({"height": "99%"}, 1000).addClass("dropped");
    }, function () {
        $(this).stop().animate({"height": "40px"}, 1000).removeClass("dropped");
    });

    $('.chosen-select').chosen();

});
