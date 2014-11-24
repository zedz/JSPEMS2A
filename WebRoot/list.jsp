<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@page import="java.util.List"%>
<%@page import="entity.Emp"%>
<%@page import="entity.User"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="header.jsp" %>

<% 
User user=(User)session.getAttribute("user"); 
if(user==null){
	response.sendRedirect("login.jsp");
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
								ID
							</td>
							<td>
								姓名
							</td>
							<td>
								薪水
							</td>
							<td>
								年龄
							</td>
							<td>
								操作
							</td>
						</tr>

 						<c:forEach items="${emps}" var="e" varStatus="s">
 							<tr class="row${s.index%2+1}">
							<td>${e.id}</td>
							<td>${e.name}</td>
							<td>${e.salary}</td>
							<td>${e.age }</td>
							<td><a href='del.do?id=${e.id }'>删除</a>&nbsp;
							<a href='load.do?id=${e.id }'>更新</a></td></tr>
 						
 						</c:forEach>
 						
					</table>
					<p>
						<input type="button" class="button" value="添加新员工" onclick="location='add.jsp'"/>
					<%
					if(Integer.parseInt(user.getAuth())==1){
						%>
						<input type="button" class="button" value="查看管理员" onclick="location='admin.user'"/>
						<%
					}
					 %>
					</p>
				</div>
		<%@include file="footer.jsp"%>