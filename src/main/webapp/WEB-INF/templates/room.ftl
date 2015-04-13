<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ROOM</title>
    <script src="http://libs.baidu.com/jquery/1.9.1/jquery.min.js"></script>
    <script src="jquery.form.min.js"></script>
</head>
<script>
    MAXID = -1;
    $(function(){
        $('#messageForm').ajaxForm({
            success: function(data) {
                $('#msgBox').append('<div>我说：'+ $('#content').val() + '</div>');
                $('#messageForm').resetForm();
            },
            error: function() {
                alert('发送失败');
            }
        });
        $.ajax({
            url: 'message/maxId',
            success: function(data) {
                MAXID = data;
            }
        });
        setInterval(function(){
            try {
                $.ajax({
                    url:"message",
                    data: {
                      id: MAXID
                    },
                    success: function(data) {
                        console.log(data);
                        for(var i = 0; i < data.length; i++) {
                            var msg = data[i];
                            if(msg.sender.id != ${Session.user.id}) {// 发送给自己的忽略
                                $('#msgBox').append('<div>'+ msg.sender.username + ':' + msg.content + '</div>');
                            }
                        }
                        if(data.length > 0) {
                            MAXID = data[data.length - 1].id;
                        }
                    },
                    error: function() {
                        alert('网络中断或服务端异常');
                    }
                });
            } catch (e) {
                console.error(e);
            }
        },5000);
    });
</script>
<body>
    <span>欢迎您：${Session.user.password}</span>
    <div id="msgBox" style="width: 100%"></div>
    <div>
        <form id="messageForm" method="post" action="message">
            <input name="content" id="content" />
            <input type="submit" value="发送" />
        </form>
    </div>
<a href="user/logout">退出</a>
</body>