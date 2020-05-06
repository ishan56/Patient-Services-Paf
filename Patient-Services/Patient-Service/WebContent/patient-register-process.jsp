<%@page import="com.paf.model.PatientDAO"%>
<jsp:useBean id="patient" class="com.paf.bean.Patient"></jsp:useBean>
<jsp:setProperty property="*" name="patient"/>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
	String status = PatientDAO.registerPatient(patient);

	session.setAttribute("patient_registraton_status", status);
	
	response.sendRedirect("patient-register.jsp");
%>

<%

%>

</body>
</html>