<%@page import="java.util.List"%>
<%@page import="com.personservice.model.PersonDetails"%>
<%@page import="com.personservice.service.PersonDetailsLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletURLUtil"%>
<%@page import= "java.util.Objects" %>

<%@ include file="init.jsp"%>

<%
    PortletURL myViewURL = null;
	String displayStyle = ParamUtil.getString(request, "displayStyle", "descriptive");

	String orderByCol = ParamUtil.getString(request, "orderByCol", "FirstName");
	if (orderByCol.equals("")){
		orderByCol = ParamUtil.getString(request, "orderByCol", "Age");
	}
	
	boolean orderByAsc = false;
	
	String orderByType = ParamUtil.getString(request, "orderByType", "asc");
	
	if (orderByType.equals("asc")) {
	    orderByAsc = true;
	}
	
	OrderByComparator<PersonDetails> orderByComparator =  null;
	
	if (orderByCol.equals("FirstName")) {
	    orderByComparator = new PersonDetailComparatorByFirstName(orderByAsc);
	} 
	else {
		 orderByComparator = new PersonDetailComparatorByAge(orderByAsc);
	}
%>


<liferay-portlet:renderURL varImpl="viewPageURL">
	<portlet:param name="mvcPath" value="/detailsList.jsp" />
	<portlet:param name="age" value="<%=String.valueOf(age)%>"/>
    <portlet:param name="firstName" value="<%=firstName%>"/>
</liferay-portlet:renderURL>


<aui:form action="<%= viewPageURL %>" method="post" name="fm">
<liferay-portlet:renderURLParams varImpl="viewPageURL" />

<liferay-frontend:management-bar
    includeCheckBox="<%= true %>"
    searchContainerId="someContainer"
>
	 <liferay-frontend:management-bar-buttons>
 	 
		<liferay-frontend:management-bar-display-buttons
			displayViews='<%= new String[] {"descriptive", "icon", "list"} %>'
			portletURL="<%= viewPageURL %>"
			selectedDisplayStyle="<%= displayStyle %>"
		/>
		
	   <liferay-frontend:management-bar-filters>
		  <liferay-frontend:management-bar-navigation
		    navigationKeys='<%= new String[] {"all"} %>'
		    portletURL="<%= viewPageURL %>"
		  />
		  
		 <liferay-frontend:management-bar-sort
			  orderByCol="<%= orderByCol %>"
			  orderByType="<%= orderByType %>"
			  orderColumns='<%= new String[] {"FirstName", "Age"} %>'
			  portletURL="<%=PortletURLUtil.clone(viewPageURL, renderResponse) %>"
		/>
		</liferay-frontend:management-bar-filters>
		
	</liferay-frontend:management-bar-buttons>
</liferay-frontend:management-bar>

<liferay-ui:search-container 
		delta="5"
		displayTerms="<%= new DisplayTerms(renderRequest) %>"
		iteratorURL="<%= viewPageURL %>" 
		emptyResultsMessage="No Records Found"
		id="someContainer"
		deltaConfigurable="true">

<liferay-ui:search-form page="/search.jsp" servletContext="<%= application %>" />
	
<liferay-ui:search-container-results >
<%
	DisplayTerms displayTerms = searchContainer.getDisplayTerms();
	String keywords = displayTerms.getKeywords(); 
	List<PersonDetails> personList =  Collections.emptyList();
	
	if (displayTerms.isAdvancedSearch()) {//Advance Search
		personList = PersonDetailHelper.getPersons(age, firstName, displayTerms.isAndOperator());
		searchContainer.setTotal(personList.size());
		searchContainer.setResults(ListUtil.subList(personList, searchContainer.getStart(),searchContainer.getEnd()));
	}  
	else if(!Validator.isBlank(keywords)){//Basic Search
		personList = PersonDetailHelper.getPersonsByKeyWord(keywords);
		searchContainer.setTotal(personList.size());
		searchContainer.setResults(ListUtil.subList(personList, searchContainer.getStart(),searchContainer.getEnd()));
	}
	else{//No Search
		 personList = PersonDetailsLocalServiceUtil.findByComparator(searchContainer.getStart(),searchContainer.getEnd(), orderByComparator);
		 searchContainer.setTotal(personList.size());		 
		 searchContainer.setResults(ListUtil.subList(personList, searchContainer.getStart(),searchContainer.getEnd()));
	}  
%>
</liferay-ui:search-container-results>
    <liferay-ui:search-container-row className="PersonDetails"
		keyProperty="autoDetailId" modelVar="currentFeedback">
		<c:choose>
			<c:when test='<%= Objects.equals(displayStyle, "descriptive") %>'>
				<liferay-ui:search-container-column-icon name="Icon"
					icon="quote-left"
				/>
				<liferay-ui:search-container-column-text name="FirstName"
						property="firstName" />
				<liferay-ui:search-container-column-text name="SecondName"
						property="secondName" />
				<liferay-ui:search-container-column-text name="Age"
						property="age" />
				<liferay-ui:search-container-column-text name="Specialty"
						property="specialty" />
				<liferay-ui:search-container-column-text name="Experience"
						property="experience" />
			</c:when>
			<c:when test='<%= Objects.equals(displayStyle, "list") %>'>
				<liferay-ui:search-container-column-text name="FirstName"
						property="firstName" />
				<liferay-ui:search-container-column-text name="SecondName"
						property="secondName" />
				<liferay-ui:search-container-column-text name="Age"
						property="age" />
				<liferay-ui:search-container-column-text name="Specialty"
						property="specialty" />
				<liferay-ui:search-container-column-text name="Experience"
						property="experience" />
			</c:when>
			<c:when test='<%= Objects.equals(displayStyle, "icon") %>'>
			
				<liferay-ui:search-container-column-text name="FirstName"
						property="firstName" />
				<liferay-ui:search-container-column-text name="SecondName"
						property="secondName" />
				<liferay-ui:search-container-column-text name="Age"
						property="age" />
				<liferay-ui:search-container-column-text name="Specialty"
						property="specialty" />
				<liferay-ui:search-container-column-text name="Experience"
						property="experience" />
			</c:when>
		</c:choose>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator searchContainer="<%=searchContainer%>"/>
</liferay-ui:search-container>

</aui:form>