<%@ include file="init.jsp"%>

<%
    PortletURL myViewURL = null;
	String displayStyle = ParamUtil.getString(request, "displayStyle", "descriptive");

	String orderByCol = ParamUtil.getString(request, "orderByCol", "firstName-key");
	if (orderByCol.equals("")){
		orderByCol = ParamUtil.getString(request, "orderByCol", "age-key");
	}
	
	boolean orderByAsc = false;
	
	String orderByType = ParamUtil.getString(request, "orderByType", "asc");
	
	if (orderByType.equals("asc")) {
	    orderByAsc = true;
	}
	
	OrderByComparator<PersonDetails> orderByComparator =  null;
	
	if (orderByCol.equals("firstName-key")) {
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
			  orderColumns='<%= new String[] {"firstName-key", "age-key"} %>'
			  portletURL="<%=PortletURLUtil.clone(viewPageURL, renderResponse) %>"
		/>
		</liferay-frontend:management-bar-filters>
		
	</liferay-frontend:management-bar-buttons>
</liferay-frontend:management-bar>

<liferay-ui:search-container 
		delta="10"
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
				<liferay-ui:search-container-column-icon name="icon-key"
					icon="quote-left"
				/>
				<liferay-ui:search-container-column-text name="firstName-key"
						property="firstName" />
				<liferay-ui:search-container-column-text name="secondName-key"
						property="secondName" />
				<liferay-ui:search-container-column-text name="age-key"
						property="age" />
				<liferay-ui:search-container-column-text name="specialty-key"
						property="specialty" />
				<liferay-ui:search-container-column-text name="experience-key"
						property="experience" />
			</c:when>
			<c:when test='<%= Objects.equals(displayStyle, "list") %>'>
				<liferay-ui:search-container-column-text name="firstName-key"
						property="firstName" />
				<liferay-ui:search-container-column-text name="secondName-key"
						property="secondName" />
				<liferay-ui:search-container-column-text name="age-key"
						property="age" />
				<liferay-ui:search-container-column-text name="specialty-key"
						property="specialty" />
				<liferay-ui:search-container-column-text name="experience-key"
						property="experience" />
			</c:when>
			<c:when test='<%= Objects.equals(displayStyle, "icon") %>'>
			
				<liferay-ui:search-container-column-text name="firstName-key"
						property="firstName" />
				<liferay-ui:search-container-column-text name="secondName-key"
						property="secondName" />
				<liferay-ui:search-container-column-text name="age-key"
						property="age" />
				<liferay-ui:search-container-column-text name="specialty-key"
						property="specialty" />
				<liferay-ui:search-container-column-text name="experience-key"
						property="experience" />
			</c:when>
		</c:choose>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator searchContainer="<%=searchContainer%>"/>
</liferay-ui:search-container>

</aui:form>