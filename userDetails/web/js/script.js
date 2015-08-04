$(document).ready(function() {

    searchContact();

    $('.searchbox').blur(function() {
        searchContact();
    });

    $('.search-contact').click(function() {
        searchContact();
    });

//    $('.contact-heading').click(function() {
//        $(this).parent('.contact').parent('.contacts').children('.contact').children('.contact-details').hide(300);
//        $(this).parent('.contact').children('.contact-details').toggle(300);
//    });

    $(".cont-menu ul li").click(function() {
        var cl = $(this).html().toLowerCase().replace(/\s+/g, '-');
        $('.cont .sub-cont').hide(0, function() {
            $('.cont .' + cl).show();
        });
        // $('.cont .' + cl).show();
    });
    
    $('.btn-update').click(function() {
        $('.addrss-update').submit();
    });
    $('.btn-update-password').click(function() {

        if ($('.newpassword').val() !== $('.confrmpassword').val()) {
            alert("Password is mismatch");
            return;
        }

        if ($('.newpassword').val() === "" || $('.oldpassword').val() === "") {
            alert("one or more field(s) are empty");
            return;
        }
        $('.update-password').submit();
    });
});

function searchContact() {
    $.ajax({
        url: '/search',
        type: 'POST',
        data: {searchword: $('.searchbox').val()},
        success: function(data) {
            $('.search-result').html(data.toString());
        },
        error: function(e) {
            $('.search-result').html(e.responseText);
        }
    });
}