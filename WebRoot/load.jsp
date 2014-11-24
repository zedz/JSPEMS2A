<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@page import="entity.Emp"%>
<%@include file="header.jsp" %>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						更新员工信息：
					</h1>
					
					
					<form action="modify.do" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									id:
								</td>
								<td valign="middle" align="left">
									${emp.id }
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									姓名：
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="name" value="${emp.name }"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									薪水：
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="salary" value="${emp.salary }"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									年龄：
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="age" value="${emp.age }"/>
								</td>
							</tr>
						</table>
						<p><input type='hidden' name='id' value='${emp.id }'/>
							<input type="submit" class="button" value="确认" />
						</p>
					</form>
				</div>
<%@include file="footer.jsp" %>
