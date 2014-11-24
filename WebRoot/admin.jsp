<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@page import="java.util.List"%>
<%@page import="entity.Emp"%>
<%@page import="entity.User"%>


<%@include file="header.jsp" %>

<% 
User user=(User)session.getAttribute("user"); 
if("0".equals(user.getAuth())){
%>

<script>
var timer;
var count=5;
var counting=function(){
	count--;
	var span=document.querySelector('span');
	span.innerHTML=count>0?count:0;
	if(count==0){
		window.open('login.jsp');
	}
}
window.onload=function(){
	timer=window.setInterval(counting,1000);
}

var stop=function(){
	timer=window.clearInterval(timer);
}

</script>
<p>您的权限不够<span>5</span>秒后自动跳转，<a href="login.jsp">马上跳转</a></p>


<%
	return;
}
%>

				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						Welcome!
					</h1>
					<table class="table">
						<tr class="table_header">
							<td>
								用户名
							</td>
							<td>
								姓名
							</td>
							<td>
								性别
							</td>
							<td>
								权限
							</td>
						</tr>
						<% 

						List<User> users=(List<User>)request.getAttribute("users");
						if(users!=null){
							for(int i=0;i<users.size();i++){
								User u=users.get(i); 
						%>
							<tr class="row<%=i%2==0?1:2 %>">
							<td><%=u.getUsername() %></td>
							<td><%=u.getRealName() %></td>
							<td><%="m".equals(u.getGender())?"男":"女" %></td>
							<td><%="1".equals(u.getAuth())?"超级管理员":"普通用户" %></td>

						<%
							}
						}
 						%>
					</table>
					<p>
						<input type="button" class="button" value="添加新用户" onclick="location='regist.jsp'"/>



					</p>
				</div>
		<%@include file="footer.jsp"%>