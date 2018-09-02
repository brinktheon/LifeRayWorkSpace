<%@include file="init.jsp" %>

<%
	SearchContainer searchContainer = (SearchContainer)request.getAttribute("liferay-ui:search:searchContainer");
	DisplayTerms displayTerms = searchContainer.getDisplayTerms();
%>

<liferay-ui:search-toggle buttonLabel="PersonDetail Search" displayTerms="<%= displayTerms %>" id="toggle_id_persondetail_search">
	<aui:input label="PersonDetail age" name="age" value='<%= age==0 ? " ":age %>'/>
	<aui:input label="PersonDetail firstName" name="firstName" value='<%= firstName %>'/>
</liferay-ui:search-toggle>