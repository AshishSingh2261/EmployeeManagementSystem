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

.test{
  border: 1px solid black;
  background-color:#D3D3D3;
  font-size: 20px;
  text-align: center;
  padding: 15px 0px;
  
}

.wrapper{
    height: 80%;
    
    overflow-y:auto;
    display: flex;
    
}

.wrapper::-webkit-scrollbar{
    width: 0;
}

.container{
	width: 80%;
	text-align: center;
	padding: 10px 10px;
	margin: 10px 10px;
	border: 100px white;
	background-color:blue;
	opacity: 0.0 - 1.0;
}


button {
	background-color:#D3D3D3;
	border: none;
	color: white;
	
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	border-radius: 12px;
}

dept-el{
margin: 0 3px 3px 3px; padding: 0.4em; 
}


</style>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<link href = "https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
         rel = "stylesheet">
      <script src = "https://code.jquery.com/jquery-1.10.2.js"></script>
      <script src = "https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
</head>
<body >
		<div style="position:relative;width:100%;height:auto;">
		
		        
           <s:iterator var="stat" begin="1" end="maxLevel" >
           
           <div id = <s:property value="%{#stat*10}"/> class="wrapper" style="min-width: 100px; width: 20%;float: left;display: inline-block">
           <level-no num=<s:property value="stat"/>></level-no>
           
    
           </div>
           </s:iterator>
       </div>
       <script type="text/javascript" src="${pageContext.request.contextPath}/js/utility.js"> </script>
       <script type="text/javascript" src="${pageContext.request.contextPath}/js/group.js"> </script>
       <script type="text/javascript" src="${pageContext.request.contextPath}/js/deptnode.js"> </script>
       <script type="text/javascript" src="${pageContext.request.contextPath}/js/level.js"> </script>
       
</body>
</html>