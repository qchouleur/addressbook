<%@ tag body-content="empty" %>
<%@ attribute name="search_action" required="true" type="java.lang.String" %>

<div class="navbar navbar-fixed-top">
	<div class="navbar-inner">
		<div class="container">
			<a class="brand" href="${pageContext.request.contextPath}/"><i class="fa fa-book"></i>  AddressBook</a>
			<button class="btn btn-default navbar-btn pull-right" style="margin-top:5px;min-height:35px" 
					title="Ajouter un nouveau contact" onclick="window.location ='${pageContext.request.contextPath}/contact/create'">
				<i class="fa fa-plus fa-2x"></i>
			</button>
			<form class="navbar-search pull-right" method="get" action="${search_action}">
				<input type="text"class="search-query" style="margin:2px" placeholder="recherche ..." name="q">
				<input type="submit" style="position: absolute; left: -9999px; width: 1px; height: 1px;"/>
			</form>
		</div>
	</div>
</div>