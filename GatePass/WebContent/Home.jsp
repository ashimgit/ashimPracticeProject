<%@ include file="header.jsp"%>

<%@ include file="middle.jsp"%>
<style type="text/css">
.welcome {
	background-color:#DDFFDD;
	border:1px solid #009900;
	width:380px;
}
.welcome li{ 
	list-style: none; 
}
</style>
<center>
				<h1><font color="red"><ov:property value="outputtext1"/></font></h1>
				<h1><font color="blue"><ov:property value="outputtext2"/></font></h1>
				<h1><font color="yellow"><ov:property value="outputtext3"/></font></h1>
				<h1><font color="green"><ov:property value="outputtext4"/></font></h1>
				<br><br><br>
				<h1><font color="black"><ov:property value="outputtext5"/></font></h1>
				<ov:if test="hasActionMessages()">
      				<div class="welcome">
      					WARNING!!!!!!!!!!!!!!<ov:actionmessage/>
   					</div>
				</ov:if>
</center>				

<%@ include file="footer.jsp"%>