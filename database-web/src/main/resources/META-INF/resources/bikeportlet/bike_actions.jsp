<%@page import="kwan.org.database.model.Bike"%>
<%@include file="../init.jsp"%>

<%
	String mvcPath = ParamUtil.getString(request, "mvcPath");

	ResultRow row = (ResultRow) request.getAttribute("SEARCH_CONTAINER_RESULT_ROW");

	Bike bike = (Bike) row.getObject();
%>

<liferay-ui:icon-menu>


	<portlet:renderURL var="editBikeURL">
	<portlet:param name="action"
			value="edit" />
		<portlet:param name="bikeId"
			value="<%=String.valueOf(bike.getBikeId())%>" />
		<portlet:param name="studentId"
			value="<%=String.valueOf(bike.getStudentId())%>" />
		<portlet:param name="mvcPath"
			value="/bikeportlet/edit_bike.jsp" />
	</portlet:renderURL>

	<liferay-ui:icon image="edit" message="Edit"
		url="<%=editBikeURL.toString()%>" />

	<portlet:actionURL name="deleteBike" var="deleteBikeURL">
		<portlet:param name="bikeID"
			value="<%=String.valueOf(bike.getBikeId())%>" />
	</portlet:actionURL>



	<liferay-ui:icon-delete url="<%=deleteBikeURL.toString()%>" />

	

</liferay-ui:icon-menu>