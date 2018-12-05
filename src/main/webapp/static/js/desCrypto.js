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