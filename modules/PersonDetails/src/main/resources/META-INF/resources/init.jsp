<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend" %>

<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.dao.search.DisplayTerms"%>

<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.OrderByComparator"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletURLUtil"%>

<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Collections"%>
<%@page import= "java.util.Objects"%>

<%@page import="com.person.helper.PersonDetailHelper"%>
<%@page import="com.personservice.comparators.PersonDetailComparatorByAge"%>
<%@page import="com.personservice.comparators.PersonDetailComparatorByFirstName"%>
<%@page import="com.personservice.model.PersonDetails"%>
<%@page import="com.personservice.service.PersonDetailsLocalServiceUtil"%>



<%
int age = ParamUtil.getInteger(request, "age");
String firstName = request.getParameter("firstName");
%>

<liferay-theme:defineObjects />

<portlet:defineObjects />