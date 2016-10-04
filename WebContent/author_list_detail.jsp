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
<table align="center" width="500" border="1">
<tr>
<th>ISBN</th>
<th>Title</th>
<th>AuthorID</th>
<th>Publisher</th>
<th>Publishdate</th>
<th>Price</th>
<th>edit</th>
</tr>
 
<% 
ArrayList<String>list=(ArrayList<String>)  session.getAttribute("list");

	if(list.size()>0){
for(int i=0;i<list.size();i++)
{

String str=(String)list.get(i);
out.print("<tr><td align=\"center\" >"+str+"</td>");
i++;
str=(String)list.get(i);
out.print(" <td align=\"center\" >" + str + "</td>");
i++;
str=(String)list.get(i);
out.print(" <td align=\"center\" >" + str + "</td>");
i++;
str=(String)list.get(i);
out.print(" <td align=\"center\" >" + str + "</td>");
i++;
str=(String)list.get(i);
out.print(" <td align=\"center\" >" + str + "</td>");
i++;
str=(String)list.get(i);
out.print(" <td align=\"center\" >" + str + "</td>");

  out.println("<td align=\"center\"><a href=\"update.jsp\"> edit </a></td></tr>");

	}
%>
<% }%>
</table>
</body>
</html>