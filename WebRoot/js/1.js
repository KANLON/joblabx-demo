/*
       * �Ƿ�ͬ��Э��
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
      *�˺���֤
      */
      function checkCode() {
        var result = true;/*getElementByIdָ���������ĸ�Ԫ��*/
        var code = document.getElementById('code').value;
        if (code == '') { 
          document.getElementById('codeInfo').innerHTML = '<span style="color:red;">�˺Ų���Ϊ��!</span>';
          result = false;
        }
        else if (code.length <6 || code.length >12) {
          document.getElementById('codeInfo').innerHTML = '<span style="color:red;">�˺ű���Ϊ6~12λ֮��!</span>';
          result = false;/*innerHTML�����˱���е� inner HTML��
          <span> ���������Ԫ�أ��Ա�ͨ����ʽ����ʽ������*/
        }
        else if (!/^[0-9A-z]+$/.test(code)) { 
          document.getElementById('codeInfo').innerHTML = '<span style="color:red;">�˺ű���Ϊ���ֻ�����ĸ���!</span>';
          result = false;
        }else {
          document.getElementById('codeInfo').innerHTML = '<img src="tupian/accept.jpg" width="17" height="17"/>';
           result = true;
        }
        
        return result;
      }
      /*
      *������֤
      */
      function password(){
        var result = true;
        var password = document.getElementById('password').value;
        if(!/^[0-9A-z]+$/.test(password)){
             document.getElementById('passwordInfo').innerHTML = '<span style="color:red;">�������Ϊ���ֻ�����ĸ���!</span>';
             result = false;
        }else if(password.length < 8 || password.length > 12 || password == '') {
          document.getElementById('passwordInfo').innerHTML = '<span style="color:red;">�������Ϊ8~12λ֮��!</span>';
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
          document.getElementById('password2Info').innerHTML = '<span style="color:red;">���������룡</span>';
          result = false;
        }else if(password2 != password) {
          document.getElementById('password2Info').innerHTML = '<span style="color:red;">�����������벻һ�£�</span>';
          result = false;
        }else {
          document.getElementById('password2Info').innerHTML = '<img src="tupian/accept.jpg" width="17" height="17"/>';
          result = true;
        }
        return result;
      }
      /*
      *�Ա���֤
      */
      function gender(){
        var result = true;
        var gender = document.getElementsByName('gender');
        var genderCount = 0;
        for (var i = 0; i < gender.length; i++) {
          if (gender[i].checked) {//����Ѿ�ѡ���˾�break;
            break;
          } else {
            genderCount++;//���û��ѡ�а�ť�����ӣ����û��ѡ�еİ�ť�������а�ť��û�н���ѡ�񣬳�����ʾ
          }
        }
        if (genderCount == gender.length) {
          document.getElementById('genderInfo').innerHTML = '<span style="color:red;">�Ա���Ϊ�գ�</span>';
          result = false;
        } else {
          document.getElementById('genderInfo').innerHTML = '<img src="tupian/accept.jpg" width="17" height="17"/>';
          result = true;
        }
        return result;
      }
    

       /*
       * ������֤
       */
       function age(){
        var result = true;
        var age = document.getElementById('age').value;/*���age�����ֵ*/
        if (age == '') {
          document.getElementById('ageInfo').innerHTML = '<span style="color:red;">����ѡ���Ϊ�գ�</span>';
          result = false;
        } else {
          document.getElementById('ageInfo').innerHTML = '<img src="tupian/accept.jpg" width="17" height="17"/>';
          result = true;
        }
        return result;
       }
      
      /*
      *����Submit��֤
      */
      function Rabbit(){

        var Rabit = new Array();
        Rabit[0] = checkCode();//�˺�
        Rabit[1] = password();//����
        Rabit[2] = password2();//�ظ�����
        Rabit[3] = gender();//�Ա�
        Rabit[4] = age();//����
        return Rabit;
       
        //alert('����ȷ������������ע����Ϣ');
      }
      /**
      *�ύ����ж�
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
        alert('�밴�涨����������ע�����ϣ�');
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