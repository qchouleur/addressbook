<%@ tag body-content="empty" %>
<%@ attribute name="address" required="true" type="fr.esiea.addressbook.models.Address" %>

<div class="card address" style="margin:auto;margin-top:15px">
	<div class="card-top green">
    	<a href="#">
    		<img src="assets/img/silhouette_homer.png" alt=""/>
    	</a>
    	<form name="remove" class="pull-right" method="post" action="${pageContext.request.contextPath}/address/delete/${id}/${address.id}">
				<button class="btn btn-default navbar-btn" title="Supprimer l'adresse" type="submit">
					<i class="fa fa-close"></i>
				</button>
			</form>

			<button class="btn btn-default navbar-btn pull-right"
				title="Edition"
				onclick="window.location ='${pageContext.request.contextPath}/address/edit/${id}/${address.id}'">
				<i class="fa fa-cog"></i>
			</button>
    </div>
    <div class="card-info" style="margin: auto;">
    <table>
    <tr>
    <td>
    	<a class="title" href="#"><i class="fa fa-envelope" style="margin-right:10px"></i></a><br>
    </td>
    <td>
    	${address.alias}
    	<div class="desc">${address.number} ${address.street}</div>
		<div class="desc">${address.zipcode} ${address.city}</div>
	</td>
	</table>
   	</div>
</div>
