function reply(author_id, author) {
	$('#comment-form #textarea').attr('placeholder', '回复:' + author)
    $('#comment-form input[name=rid]').val(author_id);
    $('#comment-form input[name=r]').val(author);
//    $("html,body").animate({ scrollTop: $('div.comment-container').offset().top }, 500);
}

function subComment() {
    $.ajax({
        type: 'post',
        url: '/comment',
        data: $('#comment-form').serialize(),
        async: false,
        dataType: 'json',
        success: function(result) {
            $('#comment-form input[name=rid]').val('');
            $('#comment-form input[name=r]').val('');
            if (result && result.success) {
                alert("评论已提交至后台审核!");
                window.location.reload()
                
            } else {
                if (result.msg) {
                    alert(result.msg);
                }
            }
        }
    });
    return false;
}
