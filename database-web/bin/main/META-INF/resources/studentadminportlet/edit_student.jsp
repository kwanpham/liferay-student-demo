<%@include file="../init.jsp"%>

<%
	long studentId = ParamUtil.getLong(request, "studentId");

	Student student = null;

	if (studentId > 0) {
		student = StudentLocalServiceUtil.getStudent(studentId);
	}
%>

<portlet:renderURL var="viewURL">
	<portlet:param name="mvcRenderCommandName" value="/studentadminportlet/view" />
</portlet:renderURL>

<portlet:actionURL
	name='<%=student == null ? "addStudent" : "updateStudent"%>'
	var="editStudentURL" />

<aui:form action="<%=editStudentURL%>" name="fm" method="POST">

	<aui:model-context bean="<%=student%>" model="<%=Student.class%>" />

	<aui:input type="hidden" name="studentId"
		value='<%=student == null ? "" : student.getStudentId()%>' />

	<aui:input label="code" name="code" type="text"
		value='<%=student == null ? "" : student.getCode()%>' />
	<aui:input label="name" name="fullName" type="text" value="" />
	<aui:input label="birthday" name="birthday" type="date" value="" />
	<aui:input label="gender" name="gender" type="checkbox" value="" />
	<aui:input label="address" name="address" type="text" value="" />

	<aui:button-row>
		<aui:button type="submit" />
		<aui:button onClick="<%= viewURL %>" type="cancel" />
	</aui:button-row>
</aui:form>