<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Information Input</title>
</head>
<body>
<h2>New Information For A Book</h2>
<form action="insert">
<input name="ISBN" type="text" placeholder="ISBN" required/></br>
<input name="AuthorID" type="text" placeholder="AuthorID" required/></br>
<input name="Title" type="text" placeholder="name of the book" required/></br>
<input name="Publisher" type="text" placeholder="publisher" required/></br>
<input name="Pubishdate" type="text" placeholder="pubishdate" required/></br>
<input name="Price" type="text" placeholder="price" required/></br>
<input name="Name" type="text" placeholder="name of the author" required/></br>
<input name="Country" type="text" placeholder="country" required/></br>
<input name="Age" type="text" placeholder="age" required/></br>
<input type="submit" value="submit"/>
</form>
</body>
</html>