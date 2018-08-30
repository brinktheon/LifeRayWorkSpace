
<%@include file="init.jsp" %>
<%
	SearchContainer searchContainer = (SearchContainer)request.getAttribute("liferay-ui:search:searchContainer");
	DisplayTerms displayTerms = searchContainer.getDisplayTerms();
%>
<liferay-ui:search-toggle buttonLabel="Autodetail Search" displayTerms="<%= displayTerms %>" id="toggle_id_autodetail_search">
	<aui:input label="AutoDetail year" name="year" value='<%= year==0 ? " ":year %>'/> <!-- If Id = 0 then set blank in field -->
	<aui:input label="AutoDetail model" name="model" value='<%= model %>'/>
</liferay-ui:search-toggle>