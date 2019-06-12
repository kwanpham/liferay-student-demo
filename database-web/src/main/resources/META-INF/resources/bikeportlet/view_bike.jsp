<%@page import="kwan.org.database.service.BikeLocalServiceUtil"%>
<%@page import="kwan.org.database.model.Bike"%>

<%@ include file="../init.jsp"%>


<%
	long studentId = ParamUtil.getLong(request, "studentId");

%>

<aui:button-row cssClass="guestbook-buttons">

	<portlet:renderURL var="addStudentURL">
		<portlet:param name="mvcPath" value="/bikeportlet/edit_bike.jsp" />
		<portlet:param name="studentId" value="<%=String.valueOf(studentId) %>" />
	</portlet:renderURL>

	<aui:button onClick="<%=addStudentURL.toString()%>" value="Add Bike"></aui:button>

</aui:button-row>


<%
	System.out.print(""+studentId);
	List<Bike> bikes = BikeLocalServiceUtil.getBikes(studentId);
%>
<p>
	<b><liferay-ui:message key="database-portlet.bike-list" /></b>
</p>


<%
	if (bikes != null && !bikes.isEmpty()) {
%>

<liferay-ui:search-container total="<%=bikes.size()%>">

	<liferay-ui:search-container-results results="<%=bikes%>" />

	<liferay-ui:search-container-row
		className="kwan.org.database.model.Bike" modelVar="bike">

		<liferay-ui:search-container-column-text property="studentId" />

		<liferay-ui:search-container-column-text property="bikeName" />

		<liferay-ui:search-container-column-text property="brand" />



	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />

</liferay-ui:search-container>

<%
	} else {
%>
<b><liferay-ui:message key="database-portlet.student-list.empty" /></b>
<%
	}
%>

