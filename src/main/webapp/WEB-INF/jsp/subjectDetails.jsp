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

function subjectInfo(event,id){
	console.log(event);
	console.log(id);
	event.preventDefault();
	var xhttp = new XMLHttpRequest();

	  xhttp.onreadystatechange = function() {
		  if (this.readyState == 4 && this.status == 200) {
	   
	     document.getElementById("subjectInfo").innerHTML = this.responseText;
	    }
	  };
	  
	  
	 xhttp.open("GET", "/subjectDetails/subject?id="+id, true);
	  xhttp.send();
}
function subjectInfo(){
	 var id = document.getElementById("searchsubjectID").value;
	var xhttp = new XMLHttpRequest();

	  xhttp.onreadystatechange = function() {
		  if (this.readyState == 4 && this.status == 200) {
	   
	     document.getElementById("subjectInfo").innerHTML = this.responseText;
	    }
	  };
	  
	  
	 xhttp.open("GET", "/subjectDetails/subject?id="+id, true);
	  xhttp.send();
}




function deleteSubject(event,id){
	console.log(event);
	console.log(id);
	event.preventDefault();
	var xhttp = new XMLHttpRequest();

	  xhttp.onreadystatechange = function() {
		  	
	    if (this.readyState == 4 && this.status == 200) {
	   
	     document.getElementById("subjectInfo").innerHTML = this.responseText;
	    }
	  };
	  
	  
	 xhttp.open("GET", "/subjectDetails/deleteSubject?id="+id, true);
	  xhttp.send();
}



</script>
<body>

<h2>Subject Details</h2>
<table border="2" class="table table-striped table-bordered table-hover">
<tbody>
<tr>
	<td>ID</td>
	<td>Sub Title</td>
	<td>Designation</td>
	<td>Action</td>
</tr>
<c:forEach items="${subjectList}" var="subject"> 
  <tr>
    <td><a href="subject.subjectID" onclick="subjectInfo(event,${subject.subjectID})">${subject.subjectID}</a></td>
    <td>${subject.subTitle}</td>
    <td>${subject.durationHours}</td>
    <td><a href="deleteSubject" onclick="deleteSubject(event,${subject.subjectID})">Delete</a></td>
    
  </tr>
</c:forEach>
</tbody>
</table>
<input type="long" id ="searchsubjectID">

<button type="submit" onclick="subjectInfo()" >Search</button>
<div id="subjectInfo">
</div>
</body>
</html>