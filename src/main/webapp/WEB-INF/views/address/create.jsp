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
		<tags:navbarAddress search_action="${pageContext.request.contextPath}/address"/>

	<div class="container" style="margin-top:50px">
		<form:form action="${pageContext.request.contextPath}/address/create/${contactId}" method="POST" class="form-horizontal" commandName="address">
	    	<fieldset>
	    		<table style="margin-left: 130px">
	    			<tr>
	    				<td>
	    					<label style="text-align: center;">Alias</label>
	    				</td>
	    				<td>
				    		<SELECT style="margin-left: 20px; margin-bottom: 15px" name="alias" size="1">
								<OPTION>Facturation</OPTION>
								<OPTION>Livraison</OPTION>
							</SELECT>
						</td>
					</tr>
				</table>
	    		<!--<tags:form_field label="Alias" name="alias" placeholder="Alias" path="alias"/>-->
	    		<tags:form_field label="Numéro" name="number" placeholder="Numéro" path="number"/>
	    		<tags:form_field label="Rue" name="street" placeholder="Rue" path="street"/>
	    		<tags:form_field label="Code postal" name="zipcode" placeholder="Code postal" path="zipcode"/>
		    	<tags:form_field label="Ville" name="city" placeholder="Ville" path="city"/>
		     
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