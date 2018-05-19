<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.sql.*" %>
<%
//import java.sql.*; 
Connection con=null;

String username="root";
String password="db12345";
String dbName="fruitshopdb";
String url = "jdbc:mysql://localhost:12354/"+dbName;
try{
Class.forName("com.mysql.jdbc.Driver");
con = DriverManager.getConnection(url, username, password);
con.setAutoCommit(false);
}catch(Exception e){
	e.printStackTrace();
}


%>