<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Test Backend</title>
</head>
<body>
	<h3>Datos Seleccionados</h3>
	<c:forEach items="${procesar}" var="dato" begin="0">
		<c:out value="${dato}"></c:out>
	</c:forEach>
</body>
</html>