<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-type" content="text/html; charset=utf-8"/>
		<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
		<meta http-equiv="Pragma" content="no-cache" />
		<meta http-equiv="Expires" content="0" /> 
		<link type="text/css" href="static/aia/css/Style.css" rel="stylesheet" />
		<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Varela+Round">
		<style>
			@charset "utf-8";
			@import url(http://weloveiconfonts.com/api/?family=fontawesome);
		</style>
		<noscript>
   			Browser does not support javascript
		</noscript>
			
	</head>	
		
	<body>		
	
	      <br><br>
	      <table style="border:1px black solid; align:center;" width="800px" height="500"  align="center" cellspacing="0" cellpadding="0">
	           <tr>
	              <td>
	                 <table style="background-color:#002060" width="100%" cellspacing="0" cellpadding="0">
	                       <tr  height="50">
				              <td ><img alt="" src="images/samsung_original_100x33.png"></td>
				              <td class="indexHeader" align="right">AIA-Vitality&nbsp;</td>
				           </tr>
				     </table>         
	             </tr>
	           <tr>
	              <td>
	                 <div id="login">
							<h2><span class="fontawesome-lock"></span>Sign In</h2>
							<form id="signinForm" method="post" action="j_spring_security_check">
								<fieldset>
									<%  if(request.getParameter("error")!=null && request.getParameter("error").equalsIgnoreCase("unsuccessful")){
										out.print("<font color='red'>Please check your user name and password.</font><br><br>");
										
									}
									     
									
									%>
									<p><label for="j_username">User Name</label></p>
									<p><input type="text" name="j_username" id="j_username" placeholder="Username" autocomplete="off" ></p>
				
									<p><label for="j_password">Password</label></p>
									<p><input type="password" name="j_password" id="j_username" placeholder="Password" autocomplete="off" ></p>
				
									<p><input type="submit" value="Sign In" ></p>
				
								</fieldset>
							</form>
						</div>
	              </td>
	           </tr>
	      </table>
	
	
	
	    
	</body>
</html>