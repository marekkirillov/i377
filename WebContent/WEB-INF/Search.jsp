
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Otsing</title>

<link rel="stylesheet" type="text/css" href="style.css" />
</head>

<body>


	<ul id="menu">
		<li><a href="/Search" id="menu_Search">Otsi</a></li>
		<li><a href="/Add" id="menu_Add">Lisa</a></li>
		<li><a href="/Admin?action=remove" id="menu_ClearData">Tühjenda</a></li>
		<li><a href="/Admin?action=insert" id="menu_InsertData">Sisesta näidisandmed</a></li>
	</ul>

	<br />
	<br />
	<br />

	<form method="get" action="/Search">
		<input name="searchString" id="searchStringBox" value="${param.searchString}" /> <input
			type="submit" id="filterButton" value="Filtreeri" /> <br />
		<br />
		<table class="listTable" id="listTable">
			<thead>
				<tr>
					<th scope="col">Nimi</th>
					<th scope="col">Kood</th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>
					<c:forEach var="unit" items="${UnitList}">
					  <tr>
					   	<td>
					   		<div id="row_${unit.code}">
					   			<c:out value="${unit.name}"/>
					   		</div>
					   	</td>
					   	<td>
					   		<c:out value="${unit.code}"/>
					   	</td>
					   	<td>
					   		<a href="Search?action=removeUnit&unitId=${unit.id}" id="delete_${unit.code}">Kustuta</a>
					   	</td>
					  </tr>	
					</c:forEach>
			</tbody>
		</table>
	</form>
</body>
</html>
