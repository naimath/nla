<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
    <script>
    function getBooks(id){
      var showData = $('#bookDetails'+id);
      showData.empty();

      $.getJSON('getbooks/'+id, '', function(data){
        showData.append(" Book Titiles: ")
        $.each(data, function(index, element) {
            showData.append(element.title+" ");
         });
      });
    }

    </script>
</head>
<body>
<h1 align="center">National Library Of Australia</h1>
<h2>People List</h2>
<div class="container">
  <table class="table table-bordered table-hover">
    <thead>
      <tr>
        <th>Name</th>
        <th>Phone</th>
        <th>Email</th>
        <th>Lend Books</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${persons}" var="person">
 		 <tr>
    		<td>${person.name}</td>
    		<td>${person.phone}</td>
    		<td>${person.email}</td>
        <td><input type="button" value="GetBooks" onclick="getBooks(${person.id})"><span id="bookDetails${person.id}"></span></td>
    	  </tr>
	  </c:forEach>
    </tbody>
  </table>
</div>

<h2>Book List</h2>
<div class="container">
  <table class="table table-bordered table-hover">
    <thead>
      <tr>
        <th>Title</th>
        <th>Author</th>
        <th>ISBN</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${books}" var="book">
 		 <tr>
    		<td>${book.title}</td>
    		<td>${book.author}</td>
    		<td>${book.isbn}</td>
    	  </tr>
	  </c:forEach>
    </tbody>
  </table>
</div>
<script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>
