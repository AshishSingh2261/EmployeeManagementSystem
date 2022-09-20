<jsp:include page="admin.jsp"></jsp:include>

<%@ taglib uri="/struts-tags" prefix="s"%>


<s:form action="remove_emp">
<s:textfield name="name" label="Name"></s:textfield>
<s:submit value="Remove"></s:submit>
</s:form>