<%@page import="java.util.List"%>
<%@page import="com.autodetservice.model.AutoDetails"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ include file="init.jsp"%>
<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/details.jsp" />
</liferay-portlet:renderURL>


		
		
<liferay-ui:search-container emptyResultsMessage="there-are-no-students"
	headerNames="Year,Model,VIN"
	iteratorURL="<%=iteratorURL%>" delta="10" deltaConfigurable="true">
	<liferay-ui:search-container-results>
		<%
		
			List<AutoDetails> autoDetailsList = AutoDetailsLocalServiceUtil.findAll() ;
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
		<liferay-ui:search-container-column-text name="VIN"
			property="VIN" />
		
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator searchContainer="<%=searchContainer%>" />
</liferay-ui:search-container>