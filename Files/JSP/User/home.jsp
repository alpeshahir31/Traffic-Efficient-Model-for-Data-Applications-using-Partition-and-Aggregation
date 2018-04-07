<html>
<%
	String user=request.getAttribute("user").toString();
	System.out.println("user name isss "+user);
%>
<script language="JavaScript" type="text/javascript">
javascript:window.history.forward(-1);
</script>

<head>
<link href="<%=request.getContextPath() %>/Files/CSS/style.css"
	rel="stylesheet" type="text/css" />
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/Files/CSS/button.css"
	type="text/css" />
</head>
<body>
<center>
	<img src="<%=request.getContextPath() %>/Files/Images/cooltext11.png" width="1000px" alt=""></img>
	</center>


	<div style="position: absolute; top: 190px; left: 10px;">
		<font
			style='font-family: Monotype Corsiva; font-size: 25px; color: purple;'>Welcome
			<%=user %></font> <br>
		<br /> <a class="button_example"
			href="<%=request.getContextPath() %>/UserProfile?name=<%=user %>"
			target="afrm">&nbsp;Show Profile &nbsp;</a><br></br> <a
			class="button_example"
			href="<%=request.getContextPath() %>/UploadFile?name=<%=user %>&amp;submit=get"
			target="afrm">&nbsp;Upload File &nbsp;&nbsp;</a><br></br> <a
			class="button_example"
			href="<%=request.getContextPath() %>/DownloadFile?name=<%=user %>&amp;submit=get"
			target="afrm">Download File</a><br></br> <a class="button_example"
			href="<%=request.getContextPath() %>/Trans?name=<%=user%>"
			target="afrm">&nbsp;Transactions</a><br></br> <a>
			 
			
			<!--   <a class="button_example"
			href="<%=request.getContextPath() %>/AuditRequest?name=<%=user%>"
			target="afrm">&nbsp;Send Request &nbsp;</a><br></br> <a> -->
			
			
			
			<a class="button_example" href="<%=request.getContextPath() %>/Files/JSP/User/logout.jsp?name=<%=user %>">&nbsp;&nbsp;&nbsp;Sign Out&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>

	</div>


	<div style="position: absolute; top: 140px; left: 150px;">
		<iframe frameborder="0" scrolling="auto" name="afrm" height="470"
			width="900"></iframe>
	</div>
</body>
</html>