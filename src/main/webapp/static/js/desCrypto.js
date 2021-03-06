$(function () {
    $("#inlineRadio2").click(function () {
        $("#exampleInput").attr("readonly",true);
    });
    $("#inlineRadio3").click(function () {
        $("#exampleInput").attr("readonly",true);
    });
    $("#inlineRadio4").click(function () {
        $("#exampleInput").attr("readonly",true);
    });
    $("#inlineRadio1").click(function () {
        $("#exampleInput").attr("readonly",false);
    });

})

/**
 * 加密请求
 */
function enDes() {
    const type= $("input[name='inlineRadioOptions']:checked").val();
    const enKey = $("#exampleInput").val();
    const text = $("#exampleTextarea").val();
    const pageContext = $("#pageContext").val();
    const data = JSON.stringify({
        "key":enKey,
        "text":text,
        "type":type
    })
    $.ajax({
        url:pageContext+"/getDesByEn",
        data:data,
        dataType:"json",
        type:"post",
        contentType: "application/json;charset=UTF-8",//提交的数据类型
        async:false,
        success:function (data) {
            console.log(data)
            if (data != null){
                $("#exampleTextareas").val(data.value)
            }
        }
    })
}

/**
 * 解密请求
 */
function decDes() {
    const type= $("input[name='inlineRadioOptions']:checked").val();
    const enKey = $("#exampleInput").val();
    const text = $("#exampleTextarea").val();
    const pageContext = $("#pageContext").val();
    const data = JSON.stringify({
        "key":enKey,
        "text":text,
        "type":type
    })
    if (type === "MD5"){
        alert("MD5无法解密");
        return;
    }
    $.ajax({
        url:pageContext+"/getDesByDes",
        data:data,
        dataType:"json",
        type:"post",
        contentType: "application/json;charset=UTF-8",//提交的数据类型
        async:false,
        success:function (data) {
            console.log(data)
            if (data != null){
                let json = data.value;
                $("#exampleTextareas").val(data.value)
                try {
                    $("#resultV").val("<p></p>");
                    json = JSON.parse(json);
                }catch (e) {
                    return;
                }
                $('#result').html(syntaxHighlight(json));
            }
        }
    })
}

function electricParam() {
    $("#myModal").modal({backdrop: 'static', keyboard: false});
    // $('#myModal').on('shown.bs.modal', function () {
    //     $('#myInput').focus()
    // })
}

/**
 * 格式化 JSON
 * @param json
 * @returns {void | string | never}
 */
function syntaxHighlight(json) {
    //if (typeof json != 'string') {
        json = JSON.stringify(json, undefined, 4);
    //}
    json = json.replace(/&/g, '&').replace(/</g, '<').replace(/>/g, '>');
    return json.replace(/("(\\u[a-zA-Z0-9]{4}|\\[^u]|[^\\"])*"(\s*:)?|\b(true|false|null)\b|-?\d+(?:\.\d*)?(?:[eE][+\-]?\d+)?)/g, function(match) {
        var cls = 'number';
        if (/^"/.test(match)) {
            if (/:$/.test(match)) {
                cls = 'key';
            } else {
                cls = 'string';
            }
        } else if (/true|false/.test(match)) {
            cls = 'boolean';
        } else if (/null/.test(match)) {
            cls = 'null';
        }
        return '<span class="' + cls + '">' + match + '</span>';
    });

}
function formatJson() {
    $("#resultV").html("<p></p>")
    let json = $("#exampleTextarea").val();
    try {
        json = JSON.parse(json);
    }catch (e) {
        $("#resultV").html("<p id='resultV' style='color: red'>json异常</p>")
        return;
    }
    $('#result').html(syntaxHighlight(json));
}

/**
 * 清空所有
 */
function clean() {
    $("#resultV").html("<p></p>")
    //$("#exampleInput").val("");
    $("#exampleTextarea").val("");
    $("#pageContext").val("");
    $("#exampleTextareas").val("");
}