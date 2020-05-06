<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="patient" class="com.paf.bean.Patient"></jsp:useBean>
<jsp:setProperty property="*" name="patient"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
	response.sendRedirect("patient-register.jsp");
%>

</body>
</html>