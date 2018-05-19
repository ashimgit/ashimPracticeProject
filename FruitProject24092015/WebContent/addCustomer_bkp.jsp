

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <%//@include file="header.jsp" %>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>COMS-Add Customer</title>
    </head>
    <body>
    <form  action="CustomerServlet" method="post">
    
        <table>
            <tr>
                <td colspan="2">
                    Add Customer :
                </td>
            </tr>
            <tr>
            	<td>
            		Enter Type :
            	</td>
            	
            	<td>
            		<select name="s_type" id="s_type">
            		    <option  value="customer">Customer</option>
            			<option  value="supplier">Supplier</option>            			
            			<option  value="godown">Godown</option>
            			
            		</select>
            	
            	</td>
            	</tr>
            	<tr>
                <td>
                    Customer Name
                </td>
                <td>
                    <input type="text" name="customerName" id="customerName" value="" >
                </td>
            </tr>
            <tr>
                <td>
                    Customer Address Line 1
                </td>
                <td>
                	 <textarea name="customerAddress1" id="customerAddress1" > </textarea>
                </td>
            </tr>
            <tr>
                <td>
                    Customer Address Line 2
                </td>
                <td>
                    <textarea name="customerAddress2" id="customerAddress2" > </textarea>
                </td>
            </tr>
            <tr>
                <td>
                    Customer Phone No 1
                    
                </td>
                <td>
                     <input type="text" name="customerPhone1" id="customerPhone1" value="" />
                </td>
            </tr><tr>
                <td>
                    Customer Phone No 2
                </td>
                <td>
                	<input type="text" name="customerPhone2" id="customerPhone2" value="" />
                </td>
            </tr>
            
            <tr>
                <td>

                </td>
                <td>
                    <input type="reset" name="reset" value="RESET" />
                    <input type="submit" name="submit" value="SUBMIT" />
                </td>
            </tr>
        </table>
        
        </form>
    </body>
</html>
