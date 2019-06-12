<%@include file="../init.jsp"%>

<%
	String mvcPath = ParamUtil.getString(request, "mvcPath");

	ResultRow row = (ResultRow) request.getAttribute("SEARCH_CONTAINER_RESULT_ROW");

	Student student = (Student) row.getObject();
%>




<liferay-ui:icon-menu>

	<portlet:renderURL var="listBikeUrl">
		<portlet:param name="studentId"
			value="<%=String.valueOf(student.getStudentId())%>" />
		<portlet:param name="mvcPath" value="/bikeportlet/view_bike.jsp" />
	</portlet:renderURL>

	<liferay-ui:icon message="List Bike"
		url="<%=listBikeUrl.toString()%>" />


	<portlet:renderURL var="addBikeUrl">
		<portlet:param name="studentId"
			value="<%=String.valueOf(student.getStudentId())%>" />
		<portlet:param name="mvcPath" value="/bikeportlet/edit_bike.jsp" />
	</portlet:renderURL>

	<liferay-ui:icon message="Add Bike"
		url="<%=addBikeUrl.toString()%>" />

	<portlet:renderURL var="editURL">
		<portlet:param name="studentId"
			value="<%=String.valueOf(student.getStudentId())%>" />
		<portlet:param name="mvcPath"
			value="/studentadminportlet/edit_student.jsp" />
	</portlet:renderURL>

	<liferay-ui:icon image="edit" message="Edit"
		url="<%=editURL.toString()%>" />

	<portlet:actionURL name="deleteStudent" var="deleteURL">
		<portlet:param name="studentId"
			value="<%=String.valueOf(student.getStudentId())%>" />
	</portlet:actionURL>



	<liferay-ui:icon-delete url="<%=deleteURL.toString()%>" />

	

</liferay-ui:icon-menu>