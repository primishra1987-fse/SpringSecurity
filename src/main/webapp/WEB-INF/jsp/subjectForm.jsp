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
<h2>Add Subject Page</h2>
<form:form method="POST" action="/subjectRegistration/addSubject"
  modelAttribute="subjectModel">
	<div class="row">
            <div class="form-group col-md-12">
               <label class="col-md-3 " for="subjectID">ID</label>
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
               <label class="col-md-3 control-lable" for="subTitle">Sub Title</label>
               <div class="col-md-7">
                    <form:input type="text" path="subTitle" id="subTitle" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="subTitle" class="text-danger"/>
                    </div>
                </div>
            </div>
        </div>
    <div class="row">
            <div class="form-group col-md-12">
               <label class="col-md-3 control-lable" for="durationHours">Duration Hours</label>
               <div class="col-md-7">
                    <form:input type="int" path="durationHours" id="durationHours" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="durationHours" class="text-danger"/>
                    </div>
                </div>
            </div>
        </div>
     <input type="submit" value="Submit" />

</form:form>
</body>
</html>