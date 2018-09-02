<%@ include file="init.jsp" %>

<portlet:actionURL name="personDetailsSubmit" var="personDetailsSubmit" />

<aui:form action="<%=personDetailsSubmit%>" method="post"
name="personDetailsSubmit">

	<aui:input name="firstName" label="FirstName" />

	<aui:input name="secondName" label="SecondName" />

	<aui:input name="age" label="Age" />

	<aui:input name="specialty" label="Specialty" />
	
	<aui:input name="experience" label="Experience" />


	<aui:button class="btn btn-success" name="Submit" type="submit" />

</aui:form>