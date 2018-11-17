//登录时的表单验证
$(function(){
    $("#goin").click(function(){
        $("#mymodal").css('display','block');
    });
    $("#go").click(function(){
        if($("#yonghu").val() == "guyahui" && $("#mima").val() == "123456789")
        {
            alert("登录成功!");
            $("#goin").html($("#yonghu").val());
            $("#mymodal").modal('hide');   //模态框隐藏，背景恢复亮度
        }
        else {
            alert("输入有误");
        }
    });
});
