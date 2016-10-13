<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
</head>
<body>
<h1 align="center">National Library Of Australia</h1>
<h2>People List</h2>
<div class="container">
  <table class="table table-bordered table-hove">
    <thead>
      <tr>
        <th>Name</th>
        <th>Phone</th>
        <th>Email</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${persons}" var="person"> 
 		 <tr>
    		<td>${person.name}</td>
    		<td>${person.phone}</td>
    		<td>${person.email}</td>
    	  </tr>
	  </c:forEach>
    </tbody>
  </table>
</div>


<script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>
