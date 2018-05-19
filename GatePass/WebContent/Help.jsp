<%@ include file="header.jsp"%>

<center>

	<table>
		<tr>
			<td>
				<h2>
					<strong><font color="blue">SMS Format</font></strong>
				</h2>
			</td>
		</tr>
		<tr>
			<td>
				<table>
					<tr>
						<td><font color="black">Schedule Visitor :</font></td>
						<td><font color="black">INIDSE &lt;tower code&gt;
								&lt;date&gt; &lt;time&gt; &lt;purpose code&gt;</font></td>
					</tr>
					<tr>
						<td><font color="black">Example:</font></td>
						<td><font color="black">INIDSE&nbsp;1055555&nbsp;11.05.2015&nbsp;11.05&nbsp;AD</font></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td><font color="black">UnSchedule Visitor :</font></td>
						<td><font color="black">INIDUE &lt;tower code&gt;
								&lt;date&gt; &lt;time&gt; &lt;Company Name&gt; &lt;first
								name&gt;</font></td>
					</tr>
					<tr>
						<td><font color="black">Example:</font></td>
						<td><font color="black">INIDUE&nbsp;1055555&nbsp;11.05.2015&nbsp;11.05&nbsp;RTIZEN&nbsp;ABCD</font></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td><font color="black">Cancel Visit::</font></td>
						<td><font color="black">INIDCN &lt;gatepassno&gt;</font></td>
					</tr>
					<tr>
						<td><font color="black">Example:</font></td>
						<td><font color="black">INIDCN 12345678910562</font></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td><font color="black">Visit Confirmation:</font></td>
						<td><font color="black">INIDVC &lt;gatepassno&gt;
								&lt;Site Specific Info&gt;</font></td>
					</tr>
					<tr>
						<td><font color="black">Example:</font></td>
						<td><font color="black">INIDVC 12345678910562 &lt;piu
								meter reading&gt;</font></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td><strong><font color="violet">Message URL</font></strong></td>
		</tr>
		<tr>
			<td>
				<table>


					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td><font color="black">Schedule :</font></td>
						<td><font color="black">http://www.indusrobportal.com:8080/GatePass/JSPS/sms_INIDSE.jsp?mob=mobileno&amp;text=messagetxt</font></td>
					</tr>
					<tr>
						<td><font color="black">Example:</font></td>
						<td><font color="black">http://www.indusrobportal.com:8080/GatePass/JSPS/sms_INIDSE.jsp?mob=919876543210&amp;text=INIDSE&nbsp;1055555&nbsp;11.05.2015&nbsp;11.05&nbsp;AD</font></td>
					</tr>
					<tr>
						<td>&nbsp;</td>

					</tr>
					<tr>
						<td><font color="black">UnSchedule:</font></td>
						<td><font color="black">http://www.indusrobportal.com:8080/GatePass/JSPS/sms_INIDUE.jsp?mob=mobileno&amp;text=messagetxt</font></td>
					</tr>
					<tr>
						<td><font color="black">Example:</font></td>
						<td><font color="black">http://www.indusrobportal.com:8080/GatePass/JSPS/sms_INIDUE.jsp?mob=919876543210&amp;text=INIDUE&nbsp;1055555&nbsp;11.05.2015&nbsp;11.05&nbsp;RTIZEN&nbsp;ABCD</font></td>
					</tr>
					<tr>
						<td>&nbsp;</td>

					</tr>
					<tr>
						<td><font color="black">Cancel Visit::</font></td>
						<td><font color="black">http://www.indusrobportal.com:8080/GatePass/JSPS/sms_INIDVC.jsp?mob=mobileno&amp;text=messagetxt</font></td>
					</tr>
					<tr>
						<td><font color="black">Example:</font></td>
						<td><font color="black">http://www.indusrobportal.com:8080/GatePass/JSPS/sms_INIDVC.jsp?mob=919876543210&amp;text=INIDCN12345678910562</font></td>
					</tr>
					<tr>
						<td>&nbsp;</td>

					</tr>
					<tr>
						<td><font color="black">Visit Confirmation:</font></td>
						<td><font color="black">http://www.indusrobportal.com:8080/GatePass/JSPS/sms_INIDCN.jsp?mob=mobileno&amp;text=messagetxt</font></td>
					</tr>
					<tr>
						<td><font color="black">Example:</font></td>
						<td><font color="black">http://www.indusrobportal.com:8080/GatePass/JSPS/sms_INIDCN.jsp?mob=919876543210&amp;text=INIDVC12345678910562
								&lt;piu meter reading&gt;</font></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>


	</font>
</center>



<%@ include file="footer.jsp"%>