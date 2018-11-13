function denglu()
{
    var flag=0;
    var x=document.getElementById("h2");
    var f1=document.getElementById("h1");
    if(!f1.value.match(/^[a-zA-Z0-9]{7,11}$/))
    {
        alert("请输入正确的用户名");
        flag=1;
    }
    if(!x.value.match(/^[a-zA-Z0-9]{6,16}$/))
    {
        alert("请输入正确的密码");
        flag=1;
    }
	 if(flag==0)
    {
        alert("登录成功！");
       return true;
    }
  	else{
		alert("密码或用户名错误");
					return false;
				}
				}
				