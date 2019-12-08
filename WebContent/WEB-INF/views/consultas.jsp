<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="formulario" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Test Backend</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<script src="https://kit.fontawesome.com/bc70d92a38.js" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
				<nav class="navbar navbar-expand-lg navbar-light bg-light">
				  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
				    <span class="navbar-toggler-icon"></span>
				  </button>
				
				  <div class="collapse navbar-collapse" id="navbarSupportedContent">
				    <ul class="navbar-nav mr-auto">
				      <li class="nav-item">
				        <a class="nav-link" href='<c:url value="/"/>'>Registro</a>
				      </li>
				      <li class="nav-item  active">
				        <a class="nav-link" href='<c:url value="/consultas"/>'>Consultas</a>
				      </li>
				    </ul>
				  </div>
				</nav>
			</div>
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" style="padding-top:50px;">
				<h3>Consultar información registrada</h3>
 				
 				<formulario:form action="${pageContext.request.contextPath}/persona/procesar" method="post" modelAttribute="persona">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>Id</th>
								<th>Nombre</th>
								<th>Apellido</th>
								<th>Procesado</th>
								<th>Fecha de registro</th>
								<th>Selección</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${registros}" var="registro" begin="0">
								<c:set var="color" value='${(registro[3])?"#10ac84":"#ee5253"}'/>
								<tr>
									<td>${registro[0]}</td>
									<td>${registro[1]}</td>
									<td>${registro[2]}</td>
									<td style="background: ${color};color:#FFFFFF;">${registro[3]}</td>
									<td>${registro[4]}</td>
									<td>
										<input style="width: 30px;height: 30px;" type="checkbox" name="procesar" value="${registro[0]}"/>
									</td>
								</tr>
							</c:forEach>
						</tbody>
						<tfoot>
							<tr>
								<th></th>
								<th></th>
								<th></th>
								<th></th>
								<th></th>
								<th>
									<button type="submit" class="btn btn-primary btn-block">Procesar</button>
								</th>
							</tr>
						</tfoot>
					</table>
				</formulario:form>
			</div>
		</div>
	</div>	
</body>
</html>