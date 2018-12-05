function enDes() {
    const enKey = $("#exampleInput").val();
    const text = $("#exampleTextarea").val();
    const pageContext = $("#pageContext").val();
    const data = JSON.stringify({
        "key":enKey,
        "text":text,
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
                $("#exampleTextareas").html(data.value)
            }
        }
    })
}
function syntaxHighlight(json) {
    if (typeof json != 'string') {
        json = JSON.stringify(json, undefined, 2);
    }
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
    var json = $("#exampleTextarea").val();
    console.log(syntaxHighlight(json));
    $('#result').html(syntaxHighlight(json));
}