<%@ include file="init.jsp"%>

<portlet:actionURL name="autoDetailsSubmit" var="autoDetailsSubmit" />

<aui:form action="<%=autoDetailsSubmit%>" method="post"
name="autoDetailsSubmit">

	<!-- MANUFACTURER -->
	<aui:fieldset>
		<aui:select label="Manufacturer" name="manufacturer">
			<aui:option label="AUDI" />
			<aui:option label="BMW" />
			<aui:option label="GM" />
			<aui:option label="VOLVO" />
			<aui:option label="TATA" />
		</aui:select>
	</aui:fieldset>

	<!-- YEAR -->
	<aui:fieldset>
		<aui:select label="Year Of Manufactoring" name="year">
			<aui:option label="2011" />
			<aui:option label="2012" />
			<aui:option label="2013" />
			<aui:option label="2014" />
			<aui:option label="2015" />
		</aui:select>
	</aui:fieldset>


	<aui:input name="vin" label="VIN" />

	<aui:input name="bodystyle" label="Bodystyle" />
	<aui:input name="model" label="Model" />



	<aui:button class="btn btn-success" name="Submit" type="submit" />

</aui:form>