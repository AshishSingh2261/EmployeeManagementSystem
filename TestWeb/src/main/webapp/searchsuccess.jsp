<%@page import="javatpoint.LoginDao"%>
<%if (LoginDao.admin==1){ %>

<jsp:include page="admin.jsp"></jsp:include>
<%} else {
%>
<jsp:include page="standard.jsp"></jsp:include>
<%} %>
<%@ taglib uri="/struts-tags" prefix="s" %>  
<html>
<head>
<style>
table, td, th {
	border: 1px solid black;
}

table {
	border-collapse: collapse;
	width: 100%;
}

th {
	height: 50px;
}

button {
	background-color: #008CBA;
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	border-radius: 12px;
}
</style>
</head>
<body >
		<div style="margin-top: 40px; margin-right: 150px; margin-left: 150px; text-align: center;">
			<table>
				<thead>
					<tr style="background-color: #E0E0E1;">
						<th>NAME</th>
						<th>EMAIL</th>
						<th>ROLE</th>
						<th>MANAGER</th>
						<th>LEVEL</th>
					</tr>
				</thead>
				<s:iterator value="list">
					<tr>
						<td><s:property value="name" /></td>
						<td><s:property value="email" /></td>
						<td><s:property value="role" /></td>
						<td><s:iterator var="stat" value="managerName">
						<s:property value="stat"/>
						</s:iterator></td>
						<td><s:property value="level" /></td>
						
					</tr>
				</s:iterator>
			</table>
		</div>
</body>
</html>