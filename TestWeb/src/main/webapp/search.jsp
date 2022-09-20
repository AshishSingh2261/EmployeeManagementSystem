<%@page import="javatpoint.LoginDao"%>
<%if (LoginDao.admin==1){ %>

<jsp:include page="admin.jsp"></jsp:include>
<%} else {
%>
<jsp:include page="standard.jsp"></jsp:include>
<%} %>

<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

<s:form action="search_emp">

<sx:autocompleter label="Name of Employee: " 
name="name" autoComplete="false"
list="nameList" />
<s:submit value="search"></s:submit>
</s:form>