<%@page import="javatpoint.LoginDao"%>
<%if (LoginDao.admin==1){ %>

<jsp:include page="admin.jsp"></jsp:include>
<%} else {
%>
<jsp:include page="standard.jsp"></jsp:include>
<%} %>
<%@ taglib uri="/struts-tags" prefix="s" %>  
Employee Doesn't Exist