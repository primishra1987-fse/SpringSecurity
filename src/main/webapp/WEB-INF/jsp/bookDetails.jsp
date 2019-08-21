<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<script>

function bookInfo(event,id){
	console.log(event);
	console.log(id);
	event.preventDefault();
	var xhttp = new XMLHttpRequest();

	  xhttp.onreadystatechange = function() {
		  	
	    if (this.readyState == 4 && this.status == 200) {
	   
	     document.getElementById("bookInfo").innerHTML = this.responseText;
	    }
	  };
	  
	  
	 xhttp.open("GET", "/bookDetails/book?id="+id, true);
	  xhttp.send();
}
function bookInfo(){
	 var id = document.getElementById("searchbookID").value;
	var xhttp = new XMLHttpRequest();

	  xhttp.onreadystatechange = function() {
		  if (this.readyState == 4 && this.status == 200) {
	   
	     document.getElementById("bookInfo").innerHTML = this.responseText;
	    }
	  };
	  
	  
	 xhttp.open("GET", "/bookDetails/book?id="+id, true);
	  xhttp.send();
}


function deleteBook(event,id){
	console.log(event);
	console.log(id);
	event.preventDefault();
	var xhttp = new XMLHttpRequest();

	  xhttp.onreadystatechange = function() {
		  	
	    if (this.readyState == 4 && this.status == 200) {
	   
	     document.getElementById("bookInfo").innerHTML = this.responseText;
	    }
	  };
	  
	  
	 xhttp.open("GET", "/bookDetails/deleteBook?id="+id, true);
	  xhttp.send();
}

</script>
<body>

<h2>Book Details</h2>
<table border="2" class="table table-striped table-bordered table-hover">
<tbody>
<tr>
	<td>Book ID</td>
	<td>Book Title</td>
	<td>Price</td>
	<td>Volume</td>
	<td>Publish Date</td>
	<td>Action</td>
	
</tr>
<c:forEach items="${bookList}" var="book"> 
  <tr>
    <td><a href="book.bookId" onclick="bookInfo(event,${book.bookId})">${book.bookId}</a></td>
    
    <td>${book.title}</td>
    <td>${book.price}</td>
    <td>${book.volume}</td>
    <td>${book.publishDate}</td>
    <td><a href="deleteBook" onclick="deleteBook(event,${book.bookId})">Delete</a></td>
  </tr>
 
</c:forEach>
</tbody>
</table>
<input type="long" id ="searchbookID">

<button type="submit" onclick="bookInfo()" >Search</button>
<div id="bookInfo">
</div>
</body>
</html>