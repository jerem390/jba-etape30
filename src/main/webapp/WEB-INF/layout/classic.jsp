<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles-extras"
	prefix="tilesx"%>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<!-- Latest compiled and minified CSS -->

<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.15.0/jquery.validate.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name="title" /></title>
</head>
<body>
	<tilesx:useAttribute name="current" />






	
	
	<div class="container">
	
	 <!-- Fixed navbar -->
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
       <a class="navbar-brand" href='<spring:url value="/"/>'>JBA</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
       
         <ul class="nav navbar-nav">
						<li class="${current=='index'?'active':''}"><a
							href='<spring:url value="/"/>'>Home</a></li>
						<security:authorize access="hasRole('ROLE_ADMIN')"> 
						<li class="${current=='users'?'active':''}"><a
							href='<spring:url value="/users.html"/>'>Users</a></li>
						</security:authorize>
						
						<li class="${current=='register'?'active':''}"><a
							href='<spring:url value="/register.html"/>'>Register</a></li>

					

<security:authorize access="isAuthenticated()">
						<li class="${current=='users'?'active':''}"><a href='<spring:url value="/account.html"/>'>My account</a></li>
</security:authorize>



					</ul>
					<ul class="nav navbar-nav navbar-right">
              	<security:authorize access="!isAuthenticated()">
							<li class="${current=='login'?'active':''}"><a
								href='<spring:url value="/login.html"/>'>Login</a></li>
						</security:authorize>

						<security:authorize access="isAuthenticated()">
							<li><a href='<spring:url value="/logout.html"/>'>Logout</a></li>
						</security:authorize>
            </ul>
        </div>
      </div>
    </nav>
<br/><br/><br/><br/>
	<tiles:insertAttribute name="body" />


		<br/> <br/>
		<hr/>
		<center>
			<tiles:insertAttribute name="footer" />
		</center>


</div>









</body>
</html>