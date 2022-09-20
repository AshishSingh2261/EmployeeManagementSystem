<%@page import="javatpoint.InsertEmployee"%>
<%@page import="javatpoint.ViewAll"%>

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

.wrapper::-webkit-scrollbar{
    width: 0;
}


.wrapper{
    height: 80%;
    
    overflow-y:auto;
    display: flex;
    
}

.wrapper::-webkit-scrollbar{
    width: 0;
}

button {
	background-color:#D3D3D3;
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
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
</head>
<body >

		<div style="position:relative;width:100%;height:auto;">
		
		        
           <s:iterator var="stat" begin="1" end="maxLevel" >
           
           <div id = <s:property value="stat"/> class="wrapper" style="min-width: 200px; width: 20%;display: inline-block;">
           <level-no num=<s:property value="stat"/>></level-no>
           
           <s:iterator value="allList">
       		<s:if test="%{level == #stat}">
       		<br>
       		<box-el name=<s:property value="name"/>>
       		</box-el>
       		<br>
			</s:if>
			
			</s:iterator>
           </div>
           </s:iterator>
       
       </div>
       <script type="text/javascript" src="${pageContext.request.contextPath}/js/boxEl.js"> </script>
       <script type="text/javascript" src="${pageContext.request.contextPath}/js/level.js"> </script>
      
       
</body>
</html>