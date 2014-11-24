<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="/tag" prefix="d" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>emplist</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="css/style.css" />
			<script type="text/javascript">
	function $(id){
		return document.getElementById(id);
	}
	function $F(id){
		return $(id).value;
	}

	function getXHR(){
		xhr=null;
		if(window.XMLHttpRequest){
			xhr=new XMLHttpRequest();
		}else{
			xhr=new ActiveXObject('microsoft.XMLHTTP');
		}
		return xhr;
	}
	
	function check_uname(){
		var xhr=getXHR();
		xhr.open('get', 'check_uname.user?username='+$F('username'), true);
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4){
				var txt=xhr.responseText;
				$('checkuname_msg').innerHTML=txt;
			}
		}
		xhr.send(null);
	}
	
	
</script>
	</head>

	<body>
		<div id="wrap">
			<div id="top_content"> 
				<div id="header">
					<div id="rightheader">
						<p>
							在线人数：${applicationScope.count}&emsp;<d:date pattern="yyyy/MM/dd"/>
							<br />
						</p>
					</div>
					<div id="topheader">
						<h1 id="title">
							<a href="#">main</a>
						</h1>
					</div>
					<div id="navigation">
					</div>
				</div>