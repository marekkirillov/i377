<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Üksuse lisamine</title>

<link rel="stylesheet" type="text/css" href="style.css" />

</head>


<body>


	<ul id="menu">
		<li><a href="Search" id="menu_Search">Otsi</a></li>
		<li><a href="Add" id="menu_Add">Lisa</a></li>
		<li><a href="Admin?action=remove" id="menu_ClearData">Tühjenda</a></li>
<!-- 		<li><a href="Admin?action=insert" id="menu_InsertData">Sisesta näidisandmed</a></li> -->
	</ul>

<br /><br /><br />

  <form method="post" action="Add">

    <table class="formTable" id="formTable">
      <tbody>
        <tr>
          <td>Nimi:</td>
          <td><input name="name" id="nameBox" value="${param.name}" /></td>
        </tr>
        <tr>
          <td>Kood:</td>
          <td><input name="code" id="codeBox" value="${param.code}" /></td>
        </tr>
         <tr>
          <td>Ülemüksus:</td>
          <td>
          <select id="superUnitCode" name="superUnitCode">
          					<option value=""></option>
          					<c:forEach var="unit" items="${UnitList}">
          					<option value="${unit.code}" label="${unit.name}"></option>
          					</c:forEach>
          </select>
          </td>
        </tr>
        <tr>
          <td>Alamüksused:</td>
          <td>
            
          </td>
        </tr>
        <tr>
          <td colspan="2" align="right"><br/>
            <input type="submit" value="Lisa" id="addButton"/>
          </td>
        </tr>
      </tbody>
    </table>
  </form>
</body>
</html>
