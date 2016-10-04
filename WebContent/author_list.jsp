<%@ page language="java" import="java.net.*"  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.io.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Booklist</title>
</head>
<body>
<table align="center" width="450" border="1">
<tr>
<th>ISBN</th>
<th>Title</th>
<th>delete</th>
</tr>
<% 
ArrayList<String>list=(ArrayList<String>)  session.getAttribute("list");

	if(list.size()>0){
for(int i=0;i<list.size();i++)
{

String str1=(String)list.get(i);
out.print("<tr><td align=\"center\" >"+str1+"</td>");
i++;
String str2=(String)list.get(i);
out.print(" <td align=\"center\" ><a href=detail?Name="+str2+ ">" + str2 + "</a></td>");

  out.println("<td align=\"center\"><a href=delete?Name="+str2+ ">"+"       delete           </a></td></tr>");

	}
%></td>
<% }%>
</table>
</body>
</html>