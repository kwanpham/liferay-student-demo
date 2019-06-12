<%@page import="kwan.org.database.model.Bike"%>
<%@page import="kwan.org.database.service.BikeLocalServiceUtil"%>
<%@ include file="../init.jsp"%>


<%
	Bike bike;
	long studentId = ParamUtil.getLong(request, "studentId");
	String action = ParamUtil.getString(request, "action");
	long bikeId = ParamUtil.getLong(request , "bikeId");
	String actionURL = "/addBike";
	if (bikeId > 0) {
		actionURL = "updateBike";
		bike = BikeLocalServiceUtil.getBike(bikeId);
	}
	
	System.out.print("action");
	
%>

<portlet:actionURL var="editBikeURL"
	name='<%=actionURL%>' />





<aui:form action="<%=editBikeURL%>" method="post">

	<aui:input type="hidden" name="bikeId"
		value='<%=bikeId == 0 ? "" : String.valueOf(bikeId)%>' />

	<aui:input label="Student ID" name="studentId" type="text"
		readonly="readonly" value="<%=String.valueOf(studentId)%>"/>
	<aui:input label="Bike Name" name="bikeName" type="text" value="" />
	<aui:input label="Brand" name="brand" type="text" value="" />

	<aui:button type="submit" />
</aui:form>