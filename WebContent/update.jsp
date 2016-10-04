<%@ page language="java" import="java.net.*"  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.io.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update</title>
</head>
<body>
<table align="center" width="500" border="1">
<tr>
<th>ISBN</th>
<th>Title</th>
<th>AuthorID</th>
<th>Publisher</th>
<th>Publishdate</th>
<th>Price</th>
</tr>
 <form action="updating">
<% 
ArrayList<String>list=(ArrayList<String>)  session.getAttribute("list");

	if(list.size()>0){
for(int i=0;i<list.size();i++)
{
String str1=(String)list.get(i);
out.print("<td align=\"center\" ><input name=\"ISBN\" type=\"text\" value = \""+str1+"\"  readonly required/>" +"</td>");
i++;
String str=(String)list.get(i);
out.print("<td align=\"center\" ><input name=\"Title\" type=\"text\" value = \""+str+"\" required/>" +"</td>");
i++;
str=(String)list.get(i);
out.print("<td align=\"center\" >"+str+"</td>");
i++;
str=(String)list.get(i);
out.print(" <td align=\"center\" ><input name=\"Publisher\" type=\"text\" value = \""+str+"\" required/>" +"</td>");
i++;
str=(String)list.get(i);
out.print(" <td align=\"center\" ><input name=\"Pubishdate\" type=\"text\" value = \""+str+"\" required/>" +"</td>");
i++;
str=(String)list.get(i);
out.print(" <td align=\"center\" ><input name=\"Price\" type=\"text\" value = \""+str+"\" required/>" +"</td>");



	}
%>
<% }%>
<input type="submit" value="submit"/>
</table>
</form>
</body>
</html>