<html>
<%
	String admin=request.getAttribute("admin").toString();
%>
<script language="JavaScript">
javascript:window.history.forward(-1);
</script>

<head>
	<link href="<%=request.getContextPath() %>/Files/CSS/style.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" href="<%=request.getContextPath() %>/Files/CSS/button.css" type="text/css"/>
	<link href="<%=request.getContextPath()%>/Files/CSS/styles.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath()%>/Files/CSS/logins.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath()%>/Files/CSS/popup.css" rel="stylesheet" type="text/css" />
	<script src="<%=request.getContextPath()%>/Files/JS/jquery-1.6.4.min.js" type="text/javascript"></script>
</head>
<body>
<center>
	 <img src="<%=request.getContextPath() %>/Files/Images/cooltext11.png" width=1000px></img> 
	 </center>
	

<div style="position:absolute;top:140px;left:10px;">
	<font style="font-family: Monotype Corsiva; font-size: 30px; color:;">Welcome <%=admin %></font>
	<br><br>	
	<a class="button_example" href="<%=request.getContextPath() %>/AdminProfile?name=<%=admin %>" target="afrm">Show Profile&nbsp;&nbsp;</a><br></br>
	<!--  <a class="button_example" href="<%=request.getContextPath()%>/GroupList?submit=get" target="afrm">Group List&nbsp;&nbsp;&nbsp;</a><br></br>-->
	 <a class="button_example" href="<%=request.getContextPath() %>/UserList?submit=get" target="afrm">User Details&nbsp;&nbsp;</a><br></br>
 	
    <a class="button_example" href="<%=request.getContextPath() %>/HashDetails?submit=get" target="afrm">Hash Details&nbsp;&nbsp;</a><br></br>
	<a class="button_example" href="<%=request.getContextPath() %>/Trans1?submit=get" target="afrm">Transactions&nbsp;</a><br></br>
	<a class="button_example" href="<%=request.getContextPath() %>/index.jsp">&nbsp;&nbsp;Sign Out&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
</div>		
	
	
	<div style="position:absolute;top:140px;left:150px;">
		<iframe frameborder="0" scrolling="auto" name="afrm" height="470" width="800" style;>
		</iframe>
	</div>
</body>
</html>