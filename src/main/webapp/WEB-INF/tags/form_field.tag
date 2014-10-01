<%@ tag body-content="empty" %>
<%@ attribute name="placeholder" required="true" type="java.lang.String" %>
<%@ attribute name="path" required="true" type="java.lang.String" %>
<%@ attribute name="label" required="true" type="java.lang.String" %>
<%@ attribute name="name" required="true" type="java.lang.String" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div class="control-group">
	<label class="control-label" for="inputaddressbook">${label}</label>
	<div class="controls">
		<form:input placeholder="${placeholder}" path="${path}" id="inputaddressbook"></form:input>
		<form:errors path="${path}" class="error"></form:errors>
	</div>
</div>