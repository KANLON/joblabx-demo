
function HeadPortraitPicture() {
	if (document.getElementById('myfile').files[0] != null) {

		//判断上传的文件是否为空

		var fd = new FormData();

		fd.append("fileToUpload", document.getElementById('myfile').files[0]); //这是获取上传的文件

		var xhr = new XMLHttpRequest();

		xhr.open("POST", "/DEMO/SettingCode/Exceltolead?type=doExcel"); //要传到后台方法的路径

		xhr.upload.addEventListener("process", uploadProgress, false);

		xhr.addEventListener("load", uploadComplete, false); //返回来的数据

		xhr.addEventListener("error", uploadFailed, false); //返回异常

		xhr.addEventListener("abort", uploadCanceled, false); //返回连接异常

		xhr.send(fd); //放入文件发送到后台

	}

}

function uploadProgress(evt) {
	if (evt.lengthComputable) {

		//var percentComplete=Math.round(evt.loaded*100/evt.total);//可以在这里接收进度条数据

	} else {

		alert("无法计算!");

	}

}

function uploadComplete(evt) {

	/*服务器返回数据*/

	var message = evt.target.responseText; //接收返回来的数据

}

function uploadFailed(evt) {
	alert("上传出错");

}

function uploadCanceled(evt) {
	alert("上传已由用户或浏览器取消删除连接.");

}