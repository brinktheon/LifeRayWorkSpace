<%@page import= "java.util.Objects" %>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.List"%>
<%@page import="com.autodetservice.model.AutoDetails"%>
<%@page import="com.autodetservice.service.AutoDetailsLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletURLUtil"%>
<%@page import="com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil"%>



<%@ include file="init.jsp" %>


<%
    PortletURL myViewURL = null;
	String displayStyle = ParamUtil.getString(request, "displayStyle", "descriptive");

	String orderByCol = ParamUtil.getString(request, "orderByCol", "Model");
	if (orderByCol.equals("")){
		orderByCol = ParamUtil.getString(request, "orderByCol", "Year");
	}
	
	boolean orderByAsc = false;
	
	String orderByType = ParamUtil.getString(request, "orderByType", "asc");
	
	if (orderByType.equals("asc")) {
	    orderByAsc = true;
	}
	
	OrderByComparator<AutoDetails> orderByComparator =  null;
	
	if (orderByCol.equals("Model")) {
	    orderByComparator = new AutoDetailComparator(orderByAsc);
	} 
	else {
		 orderByComparator = new AutoDetailComparatorByYear(orderByAsc);
	}
%>


<liferay-portlet:renderURL varImpl="viewPageURL">
			<portlet:param name="mvcPath" value="/view.jsp" />
		    <portlet:param name="orderByCol" value="<%= orderByCol %>" />
		    <portlet:param name="orderByType" value="<%= orderByType %>" />
</liferay-portlet:renderURL>

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
			  orderColumns='<%= new String[] {"Model", "Year"} %>'
			  portletURL="<%=PortletURLUtil.clone(viewPageURL, renderResponse) %>"
		/>
		</liferay-frontend:management-bar-filters>
		
	</liferay-frontend:management-bar-buttons>
    
</liferay-frontend:management-bar>




<liferay-ui:search-container 
		  delta="5"
		  id="someContainer" 
		  emptyResultsMessage="No Records Found"
		  headerNames="Icon,Year,Model,VIN,Manufacturer,Bodystyle"
		  iteratorURL="<%=viewPageURL%>"
		  deltaConfigurable="true"
		  >
	<liferay-ui:search-container-results >
		<%
			
			List<AutoDetails> autoDetailsList = AutoDetailsLocalServiceUtil
			.findSomething(searchContainer.getStart(), searchContainer.getEnd(), orderByComparator);
				
			if (autoDetailsList.isEmpty()){
				autoDetailsList = AutoDetailsLocalServiceUtil.findAll();
			}
					
			results = ListUtil.subList(autoDetailsList, searchContainer.getStart(), searchContainer.getEnd());
					
			searchContainer.setTotal(autoDetailsList.size());
			searchContainer.setResults(results);
		
		%>
	</liferay-ui:search-container-results>
	
	<liferay-ui:search-container-row className="AutoDetails"
		keyProperty="autoDetailId" modelVar="currentFeedback">
		<c:choose>
			<c:when test='<%= Objects.equals(displayStyle, "descriptive") %>'>
				<liferay-ui:search-container-column-icon name="Icon"
					icon="quote-left"
				/>
				<liferay-ui:search-container-column-text name="Year"
					property="year" />
				<liferay-ui:search-container-column-text name="Model"
					property="model" />
				<liferay-ui:search-container-column-text name="VIN"
					property="VIN" />
				<liferay-ui:search-container-column-text name="Manufacturer"
					property="manufacturer" />
				<liferay-ui:search-container-column-text name="Bodystyle"
					property="bodystyle" />
				
			</c:when>
			<c:when test='<%= Objects.equals(displayStyle, "list") %>'>
				<liferay-ui:search-container-column-text name="Year"
					property="year" />
				<liferay-ui:search-container-column-text name="Model"
					property="model" />
				<liferay-ui:search-container-column-text name="VIN"
					property="VIN" />
				<liferay-ui:search-container-column-text name="Manufacturer"
					property="manufacturer" />
				<liferay-ui:search-container-column-text name="Bodystyle"
					property="bodystyle" />
			</c:when>
			<c:when test='<%= Objects.equals(displayStyle, "icon") %>'>
			
				<liferay-ui:search-container-column-text name="Year"
					property="year" />
				<liferay-ui:search-container-column-text name="Model"
					property="model" />
				<liferay-ui:search-container-column-text name="VIN"
					property="VIN" />
				<liferay-ui:search-container-column-text name="Manufacturer"
					property="manufacturer" />
				<liferay-ui:search-container-column-text name="Bodystyle"
					property="bodystyle" />
			</c:when>
</c:choose>
		
		
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator searchContainer="<%=searchContainer%>" />

</liferay-ui:search-container>