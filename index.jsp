<%@ page import="com.util.*"%>
<%@ page import="java.net.*"%>

<html>
<head>
<%
//int no=Utility.parse(request.getParameter("no"));
%>
<link href="<%=request.getContextPath()%>/Files/CSS/style.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/Files/CSS/message.css"
	rel="stylesheet" type="text/css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/Files/CSS/login.css"
	type="text/css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/Files/JS/style.js"></script>
<link href="<%=request.getContextPath()%>/Files/CSS/styles.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/Files/CSS/logins.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/Files/CSS/popup.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath()%>/Files/JS/jquery-1.6.4.min.js" type="text/javascript"></script>

<%InetAddress thisIp = InetAddress.getLocalHost(); 
String ip=thisIp.getHostAddress();

%>

</head>

<body   onload="startTimer()" >
<div 	style="position: centre;  left: -10px;"	>
	<img src="<%=request.getContextPath()%>/Files/Images/cooltext11.png" width=100%></img>  


	<div class="TabMenu" id="label"	style="position: absolute;  right: 0px;"	>
	
		<a href="#overlay" id="button1"><span style="position: absolute; top: 110px; height:120; width:120">
		 
		<img src="<%=request.getContextPath() %>/Files/Images/admin1.png" align="center" height="120" width="120"  />
			</a>
		</span> 
		
		<a href="#overlay_signup" id="button1"><span style="position: absolute; top: 210px; height:120; width:120"> 
		<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		 <img src="<%=request.getContextPath() %>/Files/Images/user1.png" height="120" width="120" />
			<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;
			
		</span> 
		
	
		
	</div>

	<!-- Admin Login Pop Up -->


	 <div id="overlay"> 

		 <div id="popup"> 
			<a href=""> <img class="close_button" src="<%=request.getContextPath() %>/Files/Images/c.png"height="30"
				width="30" onmouseover="this.src='../Files/Images/c1.png';" onmouseout="this.src='../Files/Images/c.png';" /></a>

			<form class="login" action="<%=request.getContextPath()%>/AdminLogin"
				method="post">

				<center>
					<label><font
						style="font-family: Monotype Corsiva; font-size: 35px; color: blue;">ADMIN LOGIN</font></label>
				</center>
				<br> <label><font style="color: brown;">AdminID</font></label>&nbsp;&nbsp; <input type="text" tabindex="1" class="input"
					placeholder="Admin Id" name="name" required><br> <br>

				<label><font style="color: BROWN;">Password</font></label> <input
					type="password" class="input" tabindex="2" name="pass"
					placeholder="Password" required><br> <br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="image" id=""
					value="submit" src="<%=request.getContextPath() %>/Files/Images/login2.png"alt="submit Button"
					class="gradientbuttons"
					width="120" height="80">
			</form>
		 </div> 

 </div> 

	<!-- User Login Pop Up -->

	<div id="overlay_signup">
		<div id="popup">
			<a href=""><img class="close_button" src="<%=request.getContextPath() %>/Files/Images/c.jpg"height="30"
				width="30" /></a>

			<form class="login" action="<%=request.getContextPath()%>/UserLogin"
				method="post">
				
				<input type="hidden" name="clientip" value="<%=ip%>">
				 <input type="hidden" name="ip" value=<%=ip%>>
                <%session.setAttribute("ipadd",ip); %>
				<center>
					<label><font
						style="font-family: Monotype Corsiva; font-size: 35px; color: blue;">USER LOGIN</font></label>
				</center>
				<br> <label><font style="color: brown;">UserID</font></label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text"
					tabindex="1" class="input" name="name" placeholder="User Id"
					required><br> <br> <label><font
					style="color: BROWN;">Password</font></label><input type="password"
					class="input" tabindex="2" name="pass" placeholder="Password"
					required><br> <br> <br>

				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="image" id=""
					value="submit" src="<%=request.getContextPath() %>/Files/Images/login2.png" alt="submit Button"
					 class="gradientbuttons"
					width="120" height="80">&nbsp;&nbsp;&nbsp;&nbsp; 
				
			</form>
		</div>
	</div>

	<!-- Tpa Login Pop Up -->
	<!--  <div id="overlay-tpa">

		<div id="popup">
			<a href=""> <img class="close_button" src="<%=request.getContextPath() %>/Files/Images/close.png" height="50"
			width="50"/></a>

			<form class="login" action="<%=request.getContextPath()%>/AuditorLogin"
				method="post">

				<center>
					<label><font
						style="font-family: Monotype Corsiva; font-size: 35px; color: #DAA520;">Auditor's
							Login</font></label>
				</center>
				<br> <label><font style="color: #336633;">Auditor's Id</font></label>&nbsp;&nbsp;
				<input type="text" tabindex="1" class="input" placeholder="Tpa Id"
					name="name" required><br> <br> <label><font
					style="color: #336633;">Password</font></label> <input type="password"
					class="input" tabindex="2" name="pass" placeholder="Password"
					required><br> <br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="image" id=""
					value="submit" src="<%=request.getContextPath() %>/Files/Images/login2.png" alt="submit Button"
					 class="gradientbuttons"
					width="120" height="80">
			</form>
		</div></div>-->
		<%
		int noo=Utility.parse(request.getParameter("no"));
		if(noo==1)
{
	%>
		
			<div class="error" id="message" style="height: 65; width: 250px; top:180" >	
			<p>Opp's,your Id or password is wrong ..!</p>
		</div>
			
	<%
}
		%>
</body>
</html>