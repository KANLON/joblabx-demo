 var i = 1;
        function autoChangeImage(i){				//�Զ��ı�ͼƬ
            setTimeout("changeImage(i++); ", 1500);
            setTimeout("back(i); ", 1000);
            setTimeout("autoChangeImage(i = (i%5)); ", 1500);
        }
        function changeImage(idNum){
            document.getElementById("radio" + idNum).checked = "checked";
            switch(idNum){
                case 0:
                    document.getElementById("imgIndex").style.backgroundImage = "url(Images/1.jpg)";//�ı���ҳͼƬ
                    break;
                case 1:
                    document.getElementById("imgIndex").style.backgroundImage = "url(Images/2.jpg)";
                    break;
                case 2:
                    document.getElementById("imgIndex").style.backgroundImage = "url(Images/3.jpg)";
                    break;
                case 3:
                    document.getElementById("imgIndex").style.backgroundImage = "url(Images/4.jpg)";
                    break;
            }
        }