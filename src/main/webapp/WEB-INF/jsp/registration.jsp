<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
</head>
<body class="container">

	<form:form method="POST" action="/register" modelAttribute="userModel">

		<h3>User Registration</h3>
		<br>
		<br>
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 " for="userName">User Name</label>
				<div class="col-md-7">
					<form:input type="string" path="userName"
						class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="userName" class="text-danger" />
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 " for="password">Password</label>
				<div class="col-md-7">
					<form:input type="string" path="password"
						class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="password" class="text-danger" />
					</div>
				</div>
			</div>
		</div>


		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="role">Role</label>
				<div class="col-md-7">
					<form:select path="role" id="role">
						<form:option value="">Select Role</form:option>
						<form:options items="${role}" />
					</form:select>
					<div class="has-error">
						<form:errors path="role" class="text-danger" />
					</div>
				</div>
			</div>
		</div>



		<input type="submit" value="Submit" />

	</form:form>
</body>
</html>