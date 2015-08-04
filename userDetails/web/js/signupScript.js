var submitStatus = true;
$(document).ready(function() {

    $('#submitBtn').click(function() {
        return frmValidation();
    });

    $(".confrm-password").blur(function() {
        if ($('.password').val() !== $('.confrm-password').val()) {
            addInvalidClass('.password-status', "Password Mismatch");
            submitStatus = false;
        } else {
            addValidClass('.password-status', "Password Matched");
            submitStatus = true;
        }
    });
    $(".confrm-email").blur(function() {
        if ($('.email').val() !== $('.confrm-email').val()) {
            addInvalidClass('.email-match-status', "Email Mismatch");
            submitStatus = false;
        } else {
            addValidClass('.email-match-status', "Email Matched");
            submitStatus = true;
        }
    });

    $('#user-email').blur(function() {
        if ($(this).val() != '') {
            $.ajax({
                url: 'chkuser',
                type: 'POST',
                data: {email: $(this).val()},
                success: function(data) {
                    if (data.toString() === "1") {
                        addInvalidClass('.singnupForm .email-status', "Email already exist");
                        submitStatus = true;
                        $('#user-email').focus();
                    } else {
                        addValidClass('.singnupForm .email-status', "Email available");
                        submitStatus = false;
                    }

                },
                error: function(e) {
                    alert("Error while accessing server");
                }
            });
        } else {
            addInvalidClass('.singnupForm .email-status', "Email is empty");
            submitStatus = false;
        }
    });


});
function frmValidation() {
    if (!submitStatus || $('.password').val() === '') {
        addInvalidClass('.form-status', 'Error while submitting form');
        return false;
    }

    return true;

}

function addValidClass(className, value) {
    $(className).removeClass("status-invalid");
    $(className).addClass("status-valid");
    $(className).html(value);
}
function addInvalidClass(className, value) {
    $(className).removeClass("status-valid");
    $(className).addClass("status-invalid");
    $(className).html(value);
}
