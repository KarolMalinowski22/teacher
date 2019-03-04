jQuery(document).ready(function($) {
    $(".clickRowToUpdate").click(function () {
        window.location = $(this).find("a").attr("href");
    });
});