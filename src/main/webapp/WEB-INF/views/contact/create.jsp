<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<!DOCTYPE html>
    <html>
    	<head>
    		<title>Your AdressBook</title>
    		<meta name="viewport" content="width=device-width, initial-scale=1.0">
    		
    		<link href="<c:url value="/resources/css/bootplus.css" />" rel="stylesheet">
    
    		<link href="<c:url value="/resources/css/bootplus.min.css" />" rel="stylesheet" media="screen">
    		<link href="<c:url value="/resources/css/bootplus-responsive.min.css" />" rel="stylesheet" media="screen">
    		<link href="<c:url value="/resources/css/addressbook.css" />" rel="stylesheet" media="screen">
    		
    		<link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
			<!--[if IE 7]>
    		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootplus-ie7.min.css">
    		<![endif]-->
    		
    		
		</head>
	<body style="padding-top:50px">
		<tags:navbar search_action="${pageContext.request.contextPath}"/>

	<div class="container" style="margin-top:50px">
		<form:form action="${pageContext.request.contextPath}/contact/create" class="form-horizontal" commandName="contact">
	    	<fieldset>
	    		
	    		<tags:form_field label="Prénom" name="firstName" placeholder="Prénom" path="firstName"/>
	    		<tags:form_field label="Nom" name="lastName" placeholder="Nom" path="lastName"/>
	    		<tags:form_field label="Date de naissance" name="dateOfBirth" placeholder="JJ/MM/AAA" path="dateOfBirth"/>
		    	<tags:form_field label="Email" name="email" placeholder="email@example.com" path="email"/>	     
		     
			     <div class="control-group">
					<div class="controls">
		
						<button type="submit" class="btn btn-success">Enregistrer</button>
					</div>
				</div>
	    	</fieldset>
		</form:form>
	</div>
		<script src="http://code.jquery.com/jquery.js"></script>
    	<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
</body>
</html>