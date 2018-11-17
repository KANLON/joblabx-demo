/*增删改（curd）数据操作的js文件*/

$(function(){   //$表示JQuery对象,当页面加载完毕时执行这个函数

    //删除
    $("button.del").click(function(){  //点击class属性为del的按钮时运行remove函数，删除被选元素父元素的一行表格
        $(this).parents("tr").remove(); 
    });

    //添加
    $("#add").click(function(){
        $("#mymodal").css('display','block');   //表示元素生成为块级元素
        $("#adds").click(function () {      //遍历到“last”最后一个元素（即添加按钮），在它之前添加所输入的信息
            $("tr:last").before("<tr>"+"<td>"+$("#num1").val()+"</td>"+"<td>"+$("#num2").val()+"</td>"+"<td>"+$("#cla").val()+"</td>"+"<td>"+$("#sex").val()+"</td>"+"<td>"+$("#name").val()+"</td>"+"<td>"+$("#phone").val()+"</td>"+"</tr>");
            $("#mymodal").modal('hide');   //模态框隐藏，背景恢复亮度
            $("#num1").val()="";
            $("#num2").val()="";
            $("#cla").val()="";
            $("#sex").val()="";
            $("#name").val()="";
            $("#phone").val()="";
        });
    });

    //修改
	var i=0;
	var a = new Array();
    $("button.mod").click(function(){
        $("#mymodal").css('display','block');
        a[i]=$(this).parents("tr");
        $("#mo").click(function() {
            a[i].find(".td1").html($("#num1").val());
            a[i].find(".td2").html($("#num2").val());
            a[i].find(".td3").html($("#cla").val());
            a[i].find(".td4").html($("#sex").val());
            a[i].find(".td5").html($("#name").val());
            a[i].find(".td6").html($("#phone").val());
			i++;
            $("#mymodal").modal('hide');
        });
    });
    
});
    