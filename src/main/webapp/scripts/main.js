$(document).ready(function(){
    // change the navigator
    $('#navigator a').click(function(){
        $('#navigator a.active').removeClass("active");
        $(this).addClass("active");
    })
    // cookie change
    if ($.cookie('username') != null) {
        $('#description').html($.cookie('description'));
        $('#username').html($.cookie('username'));
    }
    $('#navigator').children('a').click(function () {
        if ($.cookie('username') != null) {
            $('#description').html($.cookie('description'));
            $('#username').html($.cookie('username'));
        }
    })
})