<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    
<%@page import="java.util.*" %>
<%@page import="br.com.qi.form.OficinaForm"%>

<html>
<head>
<title>Oficinas</title>
</head>
<body>
	<%List<OficinaForm> oficinas =  (List<OficinaForm>) request.getAttribute("lista"); %>
	<table>
	  <%for(OficinaForm oficina:oficinas) {%>
		<tr>			
			<td>
				<%= oficina.getNome()%>
			</td>
			<td>
				<%= oficina.getTelefone()%>
			</td>			
			<td>
				<%= oficina.getEmail()%>
			</td>			
		</tr> 
		<%} %>
	</table>
</body>
</html>
