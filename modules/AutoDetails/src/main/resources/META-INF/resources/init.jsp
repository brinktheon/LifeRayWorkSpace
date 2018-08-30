<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>


<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.autodetservice.service.AutoDetailsLocalServiceUtil"%>
<%@page import="com.autodetservice.model.AutoDetails"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.DisplayTerms"%>
<%@page import="java.util.List"%>
<%@page import="com.search.AutoDetailHelper"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.util.Collections"%>


<%
int year = ParamUtil.getInteger(request, "year");
String model = request.getParameter("model");
%>

<liferay-theme:defineObjects />

<portlet:defineObjects />