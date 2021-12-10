$(document).ready(function(){
    if($.cookie('username') != null) {
        let username = $.cookie('username');
        let description = $.cookie('description');
        $("<br/><span style='color: black;'>" + username + "<span/><br/>").insertAfter('#info-username');
        $("<br/><span style='color: black;'>" + description + "<span/><br/>").insertAfter('#info-description');
    } else {
        $("<br/><span style='color: lightgray;'>" + "Not Logged In" + "<span/><br/>").insertAfter('#info-username');
        $("<br/><span style='color: lightgray;'>" + "Not Logged In" + "<span/><br/>").insertAfter('#info-description');
    }
    function getUrl() {
        let httpPath = window.document.location.href;
        // http://localhost:8080/akynazh/index.html
        let pathName = window.document.location.pathname;
        // /akynazh/index.html
        let pos = httpPath.indexOf(pathName);
        // '/' 's index
        let localhostPath = httpPath.substring(0, pos);
        // http://localhost:8080
        let projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
        // /akynazh
        return localhostPath + projectName + '/'; // // http://localhost:8080/akynazh/
    }

    $('#form-submit').click(function() {
        let name = $('#uname').val();
        let pwd = $('#pwd').val();
        let type = $("input[name='type']:checked").val();
        if (type == null || name == null || name === "" || pwd == null || pwd === "") {
            alert("=_= please fill in the blank completely =_=");
            return false;
        }
        $.ajax({
            type: "post",
            url: getUrl() + "formServlet",
            data: $("#myForm").serialize(),
            success: function (data) {
                $.cookie("id", data.id, {expires: 7, path: '/'});
                $.cookie("username", data.username, {expires: 7, path: '/'});
                $.cookie("description", data.description, {expires: 7, path: '/'});
                location.href = getUrl() + "index.html";
            },
            error: function () {
                alert("=_= fail =_=");
            },
            dataType: "json"
        });
    });

    $('#log-out').click(function () {
        $.removeCookie('id', {path: '/'});
        $.removeCookie('username', {path: '/'});
        $.removeCookie('description', {path: '/'});
        location.href = getUrl() + "index.html";
    });

    $('#diary-submit').click(function() {
        if ($.cookie("username") == null) {
            alert("=_= please login first =_=");
            return false;
        }
        let id = $.cookie("id");

        let diary_text = $('#diary').val();
        if (diary_text === '' || diary_text == null) {
            alert("=_= no content =_=");
            return false;
        }
        $.ajax({
            type: "post",
            url: getUrl() + "writeDiaryServlet",
            data: {"diary_text":diary_text, "id": id},
            success: function (data) {
                $('<br/><span>' + data.create_date + "<br/>" + data.diary_text + '<span/><br/>').insertAfter('#new');
            },
            error: function () {
                alert("=_= fail =_=")
            },
            dataType: "json"
        });
    });

    $('#diary-get').click(function() {
        if ($('#tag').length !== 0) {
            return false;
        }
        if ($.cookie("username") == null) {
            alert("=_= please login first =_=");
            return false;
        }
        let id = $.cookie("id");

        $.ajax({
            type: "post",
            url: getUrl() + "getDiaryServlet",
            data: {"id": id},
            success: function (data) {
                $("<p id='tag'></p>").insertAfter('#old');
                for (let i = 0; i < data.length; i++) {
                    $('<br/><span>' + data[i].create_date + '<br/>' + data[i].diary_text +
                    '&nbsp;<input type="button" value="delete" onclick="window.location.href=\'' + getUrl() + 'deleteDiaryServlet?create_date=' + data[i].create_date + '\'">').insertAfter('#old');
                }
            },
            error: function () {
                alert("=_= fail =_=")
            },
            dataType: "json"
        });
    });
});
