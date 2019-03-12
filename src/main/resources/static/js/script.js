jQuery(document).ready(function($) {
    $(".clickRowToUpdate").click(function () {
        window.location = $(this).find("a").attr("href");
    });
    $(".expandable").hover(function() {
        $(this).stop().animate({"height":"300px"},1000).addClass("dropped");
    }, function() {
        $(this).stop().animate({"height":"40px"},1000).removeClass("dropped");
    });
});
