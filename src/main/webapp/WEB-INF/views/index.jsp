<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"  %>


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
		
		<div class="container">
			<c:if test="${error!=null}"><div class="alert alert-error">${error}</div></c:if>
		</div>
		
		<div class="container" style="margin-left: 110px;">

			<c:forEach items="${contacts}" var="contact">
 				<tags:contact_card contact="${contact}"/>
    		</c:forEach>
    	</div>
    	
		<script src="http://code.jquery.com/jquery.js"></script>
    	<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
    	</body>
    </html>

