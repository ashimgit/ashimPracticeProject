<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<!-- <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/jquery-ui.min.js"></script>
  -->   
  <!-- <script src="js/jquery-latest.js"></script> --> 
  <script src="resources/js/library/jquery-latest.js"></script>
<script type = "text/javascript" >
    /*
    history.pushState(null, null, 'pagename');
    window.addEventListener('popstate', function(event) {
    history.pushState(null, null, 'pagename');
    });
    */
    
  

    $(document).ready(function() {
        function disableBack() { window.history.forward(); //alert("got it"); 
        }

        window.onload = disableBack();
        window.onpageshow = function(evt) { if (evt.persisted) disableBack() }
        
       
    });
    

   
    
    
    
 </script>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%
/*
response.setHeader("Cache-Control","no-cache");
response.setHeader("Cache-Control","no-store");
response.setHeader("Pragma","no-cache");

*/
%>

<style type="text/css">
*{
	margin: 0px;
	padding: 0px;
}
body {
  background-color: #d4d4d4;
  font-family: 'Raleway', sans-serif;
  font-weight: 400;
  font-size: 14px;
  line-height: 26px;
  color: #666;
}

.clear {
  clear: both;
}

.wrapper {
  border: solid 2px #fff;
  box-shadow: 0 0px 0px 0 rgba(0, 0, 0, 0.1);
}

.top {
  min-height: 100px;
  background: #81DAF5;
  text-align: center;
}

.footer {
  min-height: 200px;
  padding: 20px;
  background: #e4e4e4;
}

.pageTitle {
  font-size: 24px;
  line-height: 40px;
  font-weight: 700;
  color: #000;
}

.navigation {
  list-style: none;
  padding: 0;
  margin: 0;
  background: rgb(58,58,58);
  border-top: solid 3px #fff;
  border-bottom: solid 3px #fff;
  /*
  box-shadow:  0px -2px 3px -1px rgba(0, 0, 0, 1);
  */
}

.navigation li {
  float: left;
}

.navigation li:hover {
  background: #222;
}

.navigation li:first-child {
  -webkit-border-radius: 5px 5px 0 0;
  border-radius: 5px 0 0 5px;
}

.navigation li a {
  display: block;
  padding: 0 20px;
  text-decoration: none;
  line-height: 40px;
  color: #fff;
}

.navigation ul {
  display: none;
  position: absolute;
  list-style: none;
  margin-left: -3px;
  padding: 0;
  overflow: hidden;
}

.navigation ul li {
  float: none;
}

.navigation li:hover > ul {
  width: 230px;
  display: block;
  background: #222;
  border: solid 3px #fff;
  border-top: 0;
  
  -webkit-border-radius: 0 0 8px 8px;
  border-radius: 0 0 8px 8px;
  
  -webkit-box-shadow:  0px 3px 3px 0px rgba(0, 0, 0, 0.25);
  box-shadow:  0px 3px 3px 0px rgba(0, 0, 0, 0.25);
}

.navigation li:hover > ul li:hover {
  -webkit-border-radius: 0 0 5px 5px;
  border-radius: 0 0 5px 5px;
}

.navigation li li a:hover {
  background: #000;
}

.navigation ul li:last-child a,
.navigation ul li:last-child a:hover {
  -webkit-border-radius: 0 0 5px 5px;
  border-radius: 0 0 5px 5px;
}
#f_footer {
	bottom: 0px;
	width: 100%;
	height: 30px;
	position: fixed;
	display: block;
	background-color: #222;
}
.f_text {
	right: 20px;
	position: absolute;
	color: #fff;
}
</style>
</head>
<body>
<div class="wrapper">
  
  <div class="top">
    <span style="height: 30px; display: block;"></span>
    <h1 style="font-size: 50px; font-family: verdana">Resnovae Home Appliances</h1>
  </div>
  
  <ul class="navigation">
    <li><a href="welcome.jsp" title="Home">Home</a></li>
    <li><a href="#" title="Master Entry">Master Entry</a>
      <ul>
        <li><a href="userEntry.do" title="Party Entry">Party Entry</a></li>
        <li><a href="productEntry.do" title="Product Entry">Product Entry</a></li>
        <li><a href="addCustomer.jsp" title="In Progress">Customer/ Go-Down/ Supplier</a></li>
        <li><a href="submitForm.do" title="Form Submit">SubmitFormTest</a></li>
        
      </ul>
    </li>
    <li><a href="#" title="Sales Entry">Sales Entry</a>
      <ul>
        <li><a href="sales.jsp" title="Sales">Sales</a></li>
        <li><a href="billPage.jsp" title="Bill">Bill</a></li>
      </ul>
    </li>
    <li><a href="purchase.jsp" title="Purchase">Purchase</a></li>
    <li><a href="#" title="Store">Stock</a>
    	<ul>
        <li><a href="stockTransfer.jsp" title="Stock Transfer">Stock Transfer</a></li>
        <li><a href="currentStock.jsp" title="View Stock">View Stock</a></li>
      </ul>
    </li>
    <li><a href="#" title="Customer Account">Transaction</a>
      <ul>
        <li><a href="customerAccount.jsp" title="Customer Due A/C">Customer Due A/C</a></li>
        <li><a href="transactionDetailsByDate.jsp" title="Customer Transaction Detail">Customer Transaction Detail</a></li>
        <li><a href="box.jsp" title="Box Send/Receive">Box Send/Receive</a></li>
      </ul>
    </li>
    <li><a href="#" title="View">View</a>
      <ul>
        <li><a href="#" title="View 1">View 1</a></li>
        <li><a href="#" title="View 2">View 2</a></li>
      </ul>
    </li>
     <li><a href="index.jsp" title="Click Here To Logout">Logout</a>
    </li>
    <div class="clear"></div>
  </ul>
</div>
<div id="f_footer">
<label class="f_text">&copy; NoVITA Technologies Ltd. 2017</label>
</div>
</body>
</html>