<jsp:include page="admin.jsp"></jsp:include>

<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<head>
 <sx:head/>
</head>


<s:form action="insert_emp">
<s:textfield name="name" label="Name"></s:textfield>
<s:textfield name="role" label="Role"></s:textfield>



<sx:autocompleter label="Manager: " 
name="managerName" autoComplete="false"
list="nameList" />

<s:textfield name="email" label="Email-ID"></s:textfield>

<sx:autocompleter label="Department: " 
name="departmentName" autoComplete="false"
list="departmentList" />

<s:submit value="insert"></s:submit>
</s:form>

<s:form action="insert_other" autocomplete="off">
<s:textfield name="departmentName" label="Department Name"></s:textfield>
<sx:autocompleter label="Department Under which it falls " 
name="headDeptName" autoComplete="false"
list="departmentList" />
<s:submit value="Insert Department"></s:submit>
</s:form>

