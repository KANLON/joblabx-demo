/*function createTable() { 

//������ 
var setTable = document.createElement("table"); 
//���ñ������ 
setTable.setAttribute('border', '1'); 
setTable.setAttribute('id','tableid'); 
setTable.setAttribute('cellpadding','0'); 
setTable.setAttribute('cellspacing','0'); 
setTable.setAttribute('width','100%'); 

var tbody = document.createElement("tbody"); 
//������ 
var tr = document.createElement("tr"); 

//������Ԫ�� 
var td1 = document.createElement("td"); 
//���õ�Ԫ������� 
var cellContent1 = document.createTextNode("���"); 

var td2 = document.createElement("td"); 
var cellContent2 = document.createTextNode("���� "); 

var td3 = document.createElement("td"); 
var cellContent3 = document.createTextNode("ժҪ"); 

var td4 = document.createElement("td"); 
var cellContent4 = document.createTextNode("����"); 

var td5 = document.createElement("td"); 
var cellContent5 = document.createTextNode("���"); 

var td6 = document.createElement("td"); 
var cellContent6 = document.createTextNode("����"); 


td1.appendChild(cellContent1); 
tr.appendChild(td1); 
tbody.appendChild(tr); 

td2.appendChild(cellContent2); 
tr.appendChild(td2); 
tbody.appendChild(tr); 

td3.appendChild(cellContent3); 
tr.appendChild(td3); 
tbody.appendChild(tr); 

td4.appendChild(cellContent4); 
tr.appendChild(td4); 
tbody.appendChild(tr); 

td5.appendChild(cellContent5); 
tr.appendChild(td5); 
tbody.appendChild(tr); 

td6.appendChild(cellContent6); 
tr.appendChild(td6); 
tbody.appendChild(tr); 


setTable.appendChild(tbody); 

//����������ť 
var button = document.createElement("input"); 
button.type="button"; 
button.value="����"; 
button.id="addBtn"; 
button.onclick=function(){ 
trdadd(); 
} 
document.getElementById("tableDiv").appendChild(button); 
document.getElementById("tableDiv").appendChild(setTable); 

//��ʼ��ȫ�ֱ���table 
table = document.getElementById("tableid"); 

*************** 
form�� 
***************

//����form�� 
var form = document.createElement("form"); 
form.setAttribute("id", "formid"); 

//����table 
var createFormTable = document.createElement("table"); 
createFormTable.setAttribute("id", "aaid"); 

var form_table_tbody = document.createElement("tbody"); 

var form_table_tr1 = document.createElement("tr"); 
var form_table_tr2 = document.createElement("tr"); 

//��Ԫ�� 
var form_table_td1 = document.createElement("td"); 
form_table_td1.setAttribute("colspan", "6"); 

var form_table_td2 = document.createElement("td"); 
form_table_td2.setAttribute("colspan", "6"); 

//��Ԫ������ 
var form_table_td1_text = document.createTextNode("���⣺"); 
var form_table_td2_text = document.createTextNode("ժҪ��"); 


//���������ı��� 
var text1 = document.createElement("input"); 
text1.type="text"; 
text1.id="aid"; 
text1.size="30"; 

//����ժҪ�ı��� 
var text2 = document.createElement("input"); 
text2.type="text"; 
text2.id="bid"; 
text2.size="30"; 

form_table_td1.appendChild(form_table_td1_text); 
form_table_td1.appendChild(text1); 
form_table_tr1.appendChild(form_table_td1); 
form_table_tbody.appendChild(form_table_tr1); 

form_table_td2.appendChild(form_table_td2_text); 
form_table_td2.appendChild(text2); 
form_table_tr1.appendChild(form_table_td2); 
form_table_tbody.appendChild(form_table_tr1); 


//��Ԫ�� 
var form_table_td3 = document.createElement("td"); 
form_table_td3.setAttribute("colspan", "6"); 

var form_table_td4 = document.createElement("td"); 
form_table_td4.setAttribute("colspan", "6"); 

//��Ԫ������ 
var form_table_td3_text = document.createTextNode("���ߣ�"); 
var form_table_td4_text = document.createTextNode("���ͣ�"); 

//���������ı��� 
var text3 = document.createElement("input"); 
text3.type="text"; 
text3.id="cid"; 
text3.size="30"; 

//���������� 
var select = document.createElement("select"); 
select.id="eid"; 
select.name="myname"; 

//����������option 
var option1 = document.createElement("option"); 
option1.value="1"; 

var option2 = document.createElement("option"); 
option1.value="2"; 

var option3 = document.createElement("option"); 
option1.value="3"; 

//��������ʾ��ֵ 
var value1 = document.createTextNode("֤ȯ"); 
var value2 = document.createTextNode("����"); 
var value3 = document.createTextNode("����"); 


//save��ť 
var buttonSave = document.createElement("input"); 
buttonSave.type="button"; 
buttonSave.value="����"; 
buttonSave.id="saveBtn"; 
buttonSave.onclick=function(){ 
baocun(); 
} 

//reset��ť 
var buttonReset = document.createElement("input"); 
buttonReset.type="reset"; 
buttonReset.value="����"; 
buttonReset.id="resetBtn"; 
buttonReset.onclick=function(){ 
chongzhi(); 
} 


option1.appendChild(value1); 
option2.appendChild(value2); 
option3.appendChild(value3); 
select.appendChild(option1); 
select.appendChild(option2); 
select.appendChild(option3); 

form_table_td3.appendChild(form_table_td3_text); 
form_table_td3.appendChild(text3); 
form_table_tr2.appendChild(form_table_td3); 
form_table_tbody.appendChild(form_table_tr2); 

form_table_td4.appendChild(form_table_td4_text); 
form_table_td4.appendChild(select); 
form_table_tr2.appendChild(form_table_td4); 
form_table_tbody.appendChild(form_table_tr2); 

createFormTable.appendChild(form_table_tbody); 
form.appendChild(createFormTable); 
form.appendChild(buttonSave); 
form.appendChild(buttonReset); 
document.getElementById("fid").appendChild(form); 
} 

// ���� 
function trdadd() { 
flag = false; 
document.getElementById("fid").style.display = "block"; //������ʾ 
chongzhi(); 
document.getElementById("aid").disabled = false; //�������� 

} 

//���� 
function baocun() { 
if (flag == false) { 

add(flag); 
document.getElementById("fid").style.display = "none"; 
} else { 

add(flag); 
document.getElementById("fid").style.display = "none"; 

} 
} 

//���� 
function chongzhi() { 
document.getElementById("formid").reset(); 
} 

//ɾ�� 
function deleteRow(input) { 
var s = input.parentNode.parentNode.rowIndex; 
document.getElementById("tableid").deleteRow(s); 
var num = document.getElementById("tableid").rows.length; 
for ( var i = 1; i < num; i += 1) { 
table.rows[i].cells[0].innerHTML = i; //��ÿ�е�ÿһ����Ϊi 

} 
alert("ɾ���ɹ�����"); 
} 
</script> 

</head> 
<body onload="createTable()"> 

<div id="tableDiv"></div> 
<div id="fid" style="display: none"></div> 



<script type="text/javascript"> 
//ȫ�ֱ��� 
var table = null; 
var flag = false; 
var getselectrow; 
function getNum() { 
var haoRow = table.rows[0]; 
return haoRow.cells.length; 
} 

//��ӷ��� 

function add(flag) { 
if (!flag) { 
// var num=getNum(); 
var row = table.insertRow(-1); //Ϊ-1ʱ���¼ӣ����򣩣�Ϊ0ʱ���ϼӣ�id���� 
var add1 = row.insertCell(0); 
var add2 = row.insertCell(1); 
var add3 = row.insertCell(2); 
var add4 = row.insertCell(3); 
var add5 = row.insertCell(4); 
var add6 = row.insertCell(5); 

add1.innerHTML = document.getElementById("tableid").rows.length - 1;//����-1ʱid�Ӷ���ʼ��ԭ�򣺱���ռһ�� 
add2.innerHTML = document.getElementById("aid").value; 
add3.innerHTML = document.getElementById("bid").value; 
add4.innerHTML = document.getElementById("cid").value; 
var tall = document.getElementById("eid"); 
var index = tall.selectedIndex;// ��ǰ���� 
var option = tall.options[index]; 
add5.innerHTML = option.text; 
add6.innerHTML = "<input type='button' value='�޸�' onclick='updateRow(this)'> <input type='button' value='ɾ��' onclick='deleteRow(this)'>"; 
//alert(num); 
alert("��ӳɹ�����"); 

} else { 

var row2 = table.rows[getselectrow];//ѡ�е�ǰ�� 
//���޸ĺ��ֵ���õ���Ӧ���ı����� 
row2.cells[1].innerHTML = document.getElementById("aid").value; 
row2.cells[2].innerHTML = document.getElementById("bid").value; 
row2.cells[3].innerHTML = document.getElementById("cid").value; 
var pall = document.getElementById("eid"); 
var index = pall.selectedIndex; //��ǰ���� 
var option = pall.options[index]; 
row2.cells[4].innerHTML = option.text; 

alert("�޸ĳɹ�����"); 
} 
} 

//�޸� 
function updateRow(input) { 
flag = true 
document.getElementById("aid").disabled = true; //�������� 
document.getElementById("fid").style.display = "block"; 

var i = input.parentNode.parentNode.rowIndex; 

getselectrow = i; 
//�õ�ѡ���е����ݷŵ��ı��� 
document.getElementById("aid").value = table.rows[i].cells[1].innerHTML; 
document.getElementById("bid").value = table.rows[i].cells[2].innerHTML; 
document.getElementById("cid").value = table.rows[i].cells[3].innerHTML; 

var select = document.getElementById("eid"); 
var index = select.selectedIndex;// ��ǰ���� 
var option = select.options[index]; 
option.text = table.rows[i].cells[4].innerHTML; 

} */
 function createTable(parentNode,headres,datas){
        //�������
        var table = document.createElement("table");
        //�����׷�ӵ���������
        parentNode.appendChild(table);
        //����table����ʽ
        table.cellSpacing = 0;
        table.cellPadding = 0;
        table.border = "1px";
        //������ͷ
        var thead = document.createElement("thead");
        //������׷�ӵ�table��
        table.appendChild(thead);
        //����tr
        var tr =document.createElement("tr");
        //��tr׷�ӵ�thead��
        thead.appendChild(tr);
        //����tr����ʽ����
        tr.style.height="50px";
        tr.style.backgroundColor = "lightgray";
        //����headers�е�����
        for(var i =0;i<headres.length;i++){
            //����th
            var th = document.createElement("th");
            //��th׷�ӵ�thead�е�tr��
            tr.appendChild(th);
            //��headers�������ҵ���Ӧ��th�Ž�ȥ  �˴� �õ���setInnerText()���� ����common.js
            setInnerText(th,headres[i]);
        }
        //����tbodt
        createTbody(parentNode,table,datas);
    };
    function createTbody(parentNodes,table,datas){
        //����tbody
        var tbody = document.createElement("tbody");
        //��tbody׷�ӵ�table��
        table.appendChild(tbody);
        //����tbody����ʽ����
        tbody.style.textAlign = "center";
        //�����õ�����Դ
        for(var i=0;i<datas.length;i++){
            //��ȡû������
            var data =datas[i];
            //����tr
            tr = document.createElement("tr");
            //��tr׷�ӵ�tbody��
            tbody.appendChild(tr);
            //����tbody��tr������
            tr.style.height="40px";
            //�������������
            for(var key in data){
                //����td
                var td = document.createElement("td");
                //׷�ӵ�tbody�е�tr��
                tr.appendChild(td);
                //���õ���û��������ӵ�ÿһ��td��
                setInnerText(td,data[key]);
            }
            //����������
            td = document.createElement("td");
            //׷�ӵ�tr��
            tr.appendChild(td);
            //��td����a��ǩ
            td.innerHTML = "<a href='javaScript:;'>ɾ��</a>"
            //ע�����¼�
            //�ҵ�a��ǩ
            var link = td.children[0];
            //����a��ǩ������indexΪ1
            link.index = i;
            //ע���¼�
            link.onclick = function () {
                //�õ���ǰa��ǩ������ֵ
                var index = this.index;
                //ɾ��������ֵ����
                datas.splice(index,1);
                //ɾ��table
                parentNodes.removeChild(table);
                //���´���table
                createTable(parentNodes,headers,datas);
            };
            //�ж�tr���б�ɫ
            //����ƶ���ȥ������ʾ
                    if(i%2==0){
                        //������
                        tr.style.backgroundColor = "pink";
                    }else{
                        //ż����
                        tr.style.backgroundColor = "#B9FFCF";
                    }
                    //ע���¼�������ʾ
                    var bg;
                    //��꾭��
                    tr.onmouseover = function () {
                        bg = this.style.backgroundColor;
                        this.style.backgroundColor = "#4BE1FF";
                    };
                    //����뿪
                    tr.onmouseout = function(){
                        this.style.backgroundColor = bg;
                    };
        }
    };