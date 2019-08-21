<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body class="container">

<form:form method="POST" action="/bookRegistration/addBook"
  modelAttribute="bookModel">
  
  <h3>Add Book Form</h3>
  <br><br>
	<div class="row">
            <div class="form-group col-md-12">
               <label class="col-md-3 " for="subjectID">Subject ID</label>
               <div class="col-md-7">
                    <form:input type="long" path="subjectID"  class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="subjectID" class="text-danger"/>
                    </div>
                </div>
            </div>
        </div>
        
        	<div class="row">
            <div class="form-group col-md-12">
               <label class="col-md-3 " for="bookId">Book ID</label>
               <div class="col-md-7">
                    <form:input type="long" path="bookId"  class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="bookId" class="text-danger"/>
                    </div>
                </div>
            </div>
        </div>
        
	<div class="row">
            <div class="form-group col-md-12">
               <label class="col-md-3 control-lable" for="title">Sub Title</label>
               <div class="col-md-7">
                    <form:input type="text" path="title" id="title" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="title" class="text-danger"/>
                    </div>
                </div>
            </div>
        </div>
    <div class="row">
            <div class="form-group col-md-12">
               <label class="col-md-3 control-lable" for="price">Price</label>
               <div class="col-md-7">
                    <form:input type="double" path="price" id="price" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="price" class="text-danger"/>
                    </div>
                </div>
            </div>
        </div>
        
         <div class="row">
            <div class="form-group col-md-12">
               <label class="col-md-3 control-lable" for="volume">Volume</label>
               <div class="col-md-7">
                    <form:input type="int" path="volume" id="volume" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="volume" class="text-danger"/>
                    </div>
                </div>
            </div>
        </div>
        
         <div class="row">
            <div class="form-group col-md-12">
               <label class="col-md-3 control-lable" for="price">Publish Date</label>
               <div class="col-md-7">
               
                    <form:input type="Date" pattern = "dd-MM-yyyy" path="publishDate" id="publishDate" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="publishDate" class="text-danger"/>
                    </div>
                </div>
            </div>
        </div>
        
       
     <input type="submit" value="Submit" />

</form:form>
</body>
</html>