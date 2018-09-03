<%@ include file="init.jsp" %>

<portlet:actionURL name="personDetailsSubmit" var="personDetailsSubmit" />

<aui:form action="<%=personDetailsSubmit%>" method="post"
name="personDetailsSubmit">

	<aui:input name="firstName" label="firstName-key" />

	<aui:input name="secondName" label="secondName-key" />

	<aui:input name="age" label="age-key" />

	<aui:input name="specialty" label="specialty-key" />
	
	<aui:input name="experience" label="experience-key" />

	<aui:button class="btn btn-success" name="Submit" type="submit" />

</aui:form>