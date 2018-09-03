<%@include file="init.jsp" %>

<%
	SearchContainer searchContainer = (SearchContainer)request.getAttribute("liferay-ui:search:searchContainer");
	DisplayTerms displayTerms = searchContainer.getDisplayTerms();
%>

<liferay-ui:search-toggle buttonLabel="PersonDetail Search" displayTerms="<%= displayTerms %>" id="toggle_id_persondetail_search">
	<aui:input label="personDetailAge-key" name="age" value='<%= age==0 ? " ":age %>'/>
	<aui:input label="personDetailFirstName-key" name="firstName" value='<%= firstName %>'/>
</liferay-ui:search-toggle>