<%@page import="com.autodetservice.model.AutoDetails"%>
<%@page import="java.util.List"%>
<%@page import="com.autodetservice.service.AutoDetailsLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@ include file="init.jsp" %>

<liferay-portlet:renderURL varImpl="viewPageURL">
			<portlet:param name="mvcPath" value="/view.jsp" />
</liferay-portlet:renderURL>




<liferay-ui:search-container 
		  delta="5"
		  id="someContainer" 
		  emptyResultsMessage="No Records Found"
		  headerNames="Year,Model"
		  iteratorURL="<%=viewPageURL%>"
		  deltaConfigurable="true"
		  >
	<liferay-ui:search-container-results >
		<%
			
			List<AutoDetails> autoDetailsList = AutoDetailsLocalServiceUtil.getBY_U(themeDisplay.getUserId(), 2011);
				
					
			results = ListUtil.subList(autoDetailsList, searchContainer.getStart(), searchContainer.getEnd());		
			searchContainer.setTotal(autoDetailsList.size());
			searchContainer.setResults(results);
		
		%>
	</liferay-ui:search-container-results>
	
	<liferay-ui:search-container-row className="AutoDetails"
		keyProperty="autoDetailId" modelVar="currentFeedback">
		<liferay-ui:search-container-column-text name="Year"
			property="year" />
		<liferay-ui:search-container-column-text name="Model"
			property="model" />
		
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator searchContainer="<%=searchContainer%>" />

</liferay-ui:search-container>