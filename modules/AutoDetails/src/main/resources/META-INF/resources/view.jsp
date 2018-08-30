<%@page import="java.util.List"%>
<%@page import="com.autodetservice.model.AutoDetails"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ include file="init.jsp"%>


<liferay-portlet:renderURL varImpl="iteratorURL">
   <portlet:param name="mvcPath" value="/view.jsp" />
   <portlet:param name="year" value="<%=String.valueOf(year) %>"/>
   <portlet:param name="model" value="<%=model %>"/>
</liferay-portlet:renderURL>

<liferay-portlet:renderURL varImpl="autoDetailSearchURL">
    <portlet:param name="mvcPath" value="/view.jsp" />
</liferay-portlet:renderURL>

<aui:form action="<%= autoDetailSearchURL %>" method="post" name="fm">
<liferay-portlet:renderURLParams varImpl="autoDetailSearchURL" />

<liferay-ui:search-container delta="5"  displayTerms="<%= new DisplayTerms(renderRequest) %>" iteratorURL="<%= iteratorURL %>" 
emptyResultsMessage="No Records Found">

<liferay-ui:search-form page="/search.jsp" servletContext="<%= application %>" />
	
<liferay-ui:search-container-results >
<%
	DisplayTerms displayTerms =searchContainer.getDisplayTerms();
	String keywords = displayTerms.getKeywords(); 
	List<AutoDetails> employeeList =  Collections.emptyList();;
	if (displayTerms.isAdvancedSearch()) {//Advance Search
		employeeList = AutoDetailHelper.getEmployee(year, model, displayTerms.isAndOperator());
		searchContainer.setTotal(employeeList.size());
		searchContainer.setResults(ListUtil.subList(employeeList,searchContainer.getStart(),searchContainer.getEnd()));
	}  else if(!Validator.isBlank(keywords)){//Basic Search
		employeeList = AutoDetailHelper.getEmployeeByKeyWord(keywords);
		searchContainer.setTotal(employeeList.size());
		searchContainer.setResults(ListUtil.subList(employeeList,searchContainer.getStart(),searchContainer.getEnd()));
	}
	else{//No Search
		 employeeList = AutoDetailsLocalServiceUtil.getAutoDetailses(0, AutoDetailsLocalServiceUtil.getAutoDetailsesCount());
		 searchContainer.setTotal(employeeList.size());		 
		 searchContainer.setResults(ListUtil.subList(employeeList,searchContainer.getStart(),searchContainer.getEnd()));
	}  
%>
</liferay-ui:search-container-results>
    <liferay-ui:search-container-row className="com.autodetservice.model.AutoDetails" modelVar="aAutoDeteils" >
		<liferay-ui:search-container-column-text property="model" />
		<liferay-ui:search-container-column-text property="manufacturer" />
		<liferay-ui:search-container-column-text property="bodystyle" />
		<liferay-ui:search-container-column-text property="year" />	
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>

</aui:form>
