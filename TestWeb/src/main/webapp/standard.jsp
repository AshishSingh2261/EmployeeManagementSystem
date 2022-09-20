<jsp:include page="index.jsp"></jsp:include>
<hr />
<%@ taglib uri="/struts-tags" prefix="s"%>

<br />

<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
.topnav {
  overflow: hidden;
  background-color: #333;
}

.topnav a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.topnav a:hover {
  background-color: #ddd;
  color: black;
}

.topnav a.active {
  background-color: #04AA6D;
  color: white;
}
</style>
</head>
<body>

<div class="topnav">
  <a href="standard.jsp">Home</a>
  <a href="<s:url action='view_details'/>">Profile</a>
  <a href="<s:url action='check_search'/>">Search</a>
  <a href="<s:url action='view_all'/>">Organisation Tree</a>
  <a href="<s:url action='dept_tree'/>">Department Tree</a>
</div>

</body>
</html>


Welcome Standard,











