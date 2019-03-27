<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bienvenido a cine app</title>

<spring:url value="/resources" var="urlPublic"></spring:url>

<link rel="stylesheet" 	href="${urlPublic}/bootstrap/css/bootstrap.min.css">

</head>
<body>

	<div class="panel panel-default">
		<div class="panel-heading">Lista de peliculas</div>
		<div class="panel-body">

			<table class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th>Id</th>
						<th>Titulo</th>
						<th>Duracion</th>
						<th>Clasificacion</th>
						<th>Genero</th>
						<th>imagen</th>
						<th>Fecha Estreno</th>
						<th>Estado</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${ peliculas }" var="pelicula">
						<tr>
							<td>${pelicula.id}</td>
							<td>${pelicula.titulo}</td>
							<td>${pelicula.duracion}min.</td>
							<td>${pelicula.clasificacion}</td>
							<td>${pelicula.genero}</td>
							<td><img src="${urlPublic}/images/${pelicula.imagen}" width="80" height="100"></td>
							<td><fmt:formatDate value="${pelicula.fechaEstreno }" pattern="dd--MM-yyyy"/></td>
							<td>
								<c:choose>
									<c:when test="${pelicula.status == 'Activa'}">
										<span class="label label-success">ACTIVA</span>									
									</c:when>
									<c:otherwise>
										<span class="label label-danger">INACTIVA</span>
									
									</c:otherwise>
								
								</c:choose>
								
							
							</td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
		</div>
	</div>
</body>

</html>