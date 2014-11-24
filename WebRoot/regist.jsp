<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="header.jsp" %>

				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						注册
					</h1>
					<form action="regist.user" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									用户名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="username" id="username" onblur="check_uname();"/><span id="checkuname_msg"></span>
								</td>
								<td>
								<% String msg1=(String)request.getAttribute("user_exist"); %>
								<%=msg1==null?"":msg1 %>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									真实姓名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="realname" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									密码:
								</td>
								<td valign="middle" align="left">
									<input type="password" class="inputgri" name="pwd" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									性别:
								</td>
								<td valign="middle" align="left">
									男
									<input type="radio" class="inputgri" name="gender" value="m" checked="checked"/>
									女
									<input type="radio" class="inputgri" name="gender" value="f"/>
								</td>
							</tr>
							
							<tr>
								<td valign="middle" align="right">
									验证码:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="number" />
								</td>
								<td>
								<img id="num" src="checkcode" border="1px" />
									<a href="javascript:;" onclick="document.getElementById('num').src = 'checkcode?'+(new Date()).getTime()">换一张</a>
						
								</td>
								<td>
								<% String msg=(String)request.getAttribute("code_wrong"); %>
								<%=msg==null?"":msg %>
								</td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" value="Submit &raquo;" />
						</p>
					</form>
				</div>
<%@include file="footer.jsp" %>