<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title> welcome to Mylibrary</title>
</head>
<body>
<a href=insert_ini><button>Click here to add new Author or Book</button></a>
<h1>Search for Books</h1>
<form action="search" method ="get">
<br />
Author:<input type="text" name="Name" required/>
<input type="submit" value="Submit" />
</form>
<br/>

</body>
</html>
