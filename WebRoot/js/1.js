/*
       * 是否同意协议
       */
      function isAgree() {
        var agreeDOM = document.getElementById('agree');
        var submitDOM = document.getElementById('submit');
        if (agreeDOM.checked) {
          submitDOM.disabled = false;
        } else {
          submitDOM.disabled = true;
        }
      }
       /*
      *账号验证
      */
      function checkCode() {
        var result = true;/*getElementById指获得括号里的该元素*/
        var code = document.getElementById('code').value;
        if (code == '') { 
          document.getElementById('codeInfo').innerHTML = '<span style="color:red;">账号不能为空!</span>';
          result = false;
        }
        else if (code.length <6 || code.length >12) {
          document.getElementById('codeInfo').innerHTML = '<span style="color:red;">账号必须为6~12位之间!</span>';
          result = false;/*innerHTML返回了表格行的 inner HTML，
          <span> 来组合行内元素，以便通过样式来格式化它们*/
        }
        else if (!/^[0-9A-z]+$/.test(code)) { 
          document.getElementById('codeInfo').innerHTML = '<span style="color:red;">账号必须为数字或者字母组成!</span>';
          result = false;
        }else {
          document.getElementById('codeInfo').innerHTML = '<img src="tupian/accept.jpg" width="17" height="17"/>';
           result = true;
        }
        
        return result;
      }
      /*
      *密码验证
      */
      function password(){
        var result = true;
        var password = document.getElementById('password').value;
        if(!/^[0-9A-z]+$/.test(password)){
             document.getElementById('passwordInfo').innerHTML = '<span style="color:red;">密码必须为数字或者字母组成!</span>';
             result = false;
        }else if(password.length < 8 || password.length > 12 || password == '') {
          document.getElementById('passwordInfo').innerHTML = '<span style="color:red;">密码必须为8~12位之间!</span>';
          result = false;
        }
        else {
          document.getElementById('passwordInfo').innerHTML = '<img src="tupian/accept.jpg" width="17" height="17"/>';
          result = true;
        }
        return result;
      }
        function password2(){
        var result = true;
        var password = document.getElementById('password').value;
        var password2 = document.getElementById('password2').value;
        if (password2 == ''){
          document.getElementById('password2Info').innerHTML = '<span style="color:red;">请输入密码！</span>';
          result = false;
        }else if(password2 != password) {
          document.getElementById('password2Info').innerHTML = '<span style="color:red;">两次密码输入不一致！</span>';
          result = false;
        }else {
          document.getElementById('password2Info').innerHTML = '<img src="tupian/accept.jpg" width="17" height="17"/>';
          result = true;
        }
        return result;
      }
      /*
      *性别验证
      */
      function gender(){
        var result = true;
        var gender = document.getElementsByName('gender');
        var genderCount = 0;
        for (var i = 0; i < gender.length; i++) {
          if (gender[i].checked) {//如果已经选中了就break;
            break;
          } else {
            genderCount++;//如果没有选中按钮就增加，最后没有选中的按钮等于所有按钮则没有进行选择，出现提示
          }
        }
        if (genderCount == gender.length) {
          document.getElementById('genderInfo').innerHTML = '<span style="color:red;">性别不能为空！</span>';
          result = false;
        } else {
          document.getElementById('genderInfo').innerHTML = '<img src="tupian/accept.jpg" width="17" height="17"/>';
          result = true;
        }
        return result;
      }
    

       /*
       * 年龄验证
       */
       function age(){
        var result = true;
        var age = document.getElementById('age').value;/*获得age里面的值*/
        if (age == '') {
          document.getElementById('ageInfo').innerHTML = '<span style="color:red;">年龄选项不能为空！</span>';
          result = false;
        } else {
          document.getElementById('ageInfo').innerHTML = '<img src="tupian/accept.jpg" width="17" height="17"/>';
          result = true;
        }
        return result;
       }
      
      /*
      *表单的Submit验证
      */
      function Rabbit(){

        var Rabit = new Array();
        Rabit[0] = checkCode();//账号
        Rabit[1] = password();//密码
        Rabit[2] = password2();//重复密码
        Rabit[3] = gender();//性别
        Rabit[4] = age();//年龄
        return Rabit;
       
        //alert('请正确并完整的输入注册信息');
      }
      /**
      *提交后的判断
      */
      function index(){
        var w = new Array();
        w = Rabbit();
        var a = 0;
        var s = 1;
        for (var i = 0; i <= 4; i++) {
          if(w[i]==true){
          a++;console.warn(a);
          }
          console.warn(w[i]);
        }
        if (a == 8) {
          window.location.href='Rabbit.html'; 
        }
        else{
        alert('请按规定输入完整的注册资料！');
        var Rabit;
        Rabit = age();
         if (Rabit == false) {
          var agefocus = document.getElementById('age');
          agefocus.focus();
        }
        Rabit = gender();
         if (Rabit == false) {
          var genderfocus = document.getElementById('man');
          genderfocus.focus();
        }
  
        Rabit = password2();
         if (Rabit == false) {
          var password2focus = document.getElementById('password2');
          password2focus.focus();
        }
        Rabit = password();
        if (Rabit == false) {
          var passwordfocus = document.getElementById('password');
          passwordfocus.focus();
        }
        Rabit = checkCode();
        if (Rabit == false) {
          var codefocus = document.getElementById('code');
          codefocus.focus();
        }

        }
      }