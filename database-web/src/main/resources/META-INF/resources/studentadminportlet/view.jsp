<%@page import="kwan.org.database.service.StudentLocalService"%>
<%@page import="kwan.org.database.service.BikeLocalService"%>
<%@include file="../init.jsp"%>

<%@page import="kwan.org.database.service.StudentLocalServiceUtil"%>
<%@page import="kwan.org.database.model.Student"%>



<portlet:actionURL
	var="searchNameStudentURL1">
	<portlet:param name="mvcPath" value="/studentadminportlet/view.jsp" />
	<portlet:param name="type" value="search" />
</portlet:actionURL>

<aui:form action="${searchNameStudentURL1}" method="POST">

	<div class="row">
		<div class="col-md-8">
			<aui:input inlineLabel="left" label="" name="keywords"
				placeholder="search-entries" size="256" />
		</div>

		<div class="col-md-4">
			<aui:button type="submit" value="search" />
		</div>
	</div>
</aui:form>


<aui:button-row cssClass="guestbook-buttons">

	<portlet:renderURL var="addStudentURL">
		<portlet:param name="mvcPath"
			value="/studentadminportlet/edit_student.jsp" />
	</portlet:renderURL>

	<aui:button onClick="<%=addStudentURL.toString()%>" value="Add Student"></aui:button>

</aui:button-row>

<%


	String keywords = ParamUtil.getString(request, "keywords");

	List<Student> students;
	StudentLocalService _studentLocalService = (StudentLocalService) request
			.getAttribute("StudentLocalService");
	final DateFormat DD_MM_YYYYY = new SimpleDateFormat("dd/MM/yyyy");
	final String DATE_EMPTY_FORMAT = "--/--/----";
	final String FEMALE = LanguageUtil.get(request, "database-portlet.student-list.gender.female");
	final String MALE = LanguageUtil.get(request, "database-portlet.student-list.gender.male");
	
	if(keywords == null || keywords.equals("")){
		students = _studentLocalService.getStudents();
		
	} else {
		students = _studentLocalService.findByFullName(keywords);
		System.out.println(students.toString());
		System.out.println(students.size());
	}
	
	
%>
<p>
	<b><liferay-ui:message key="database-portlet.student-list" /></b>
</p>


<%
	if (students != null && !students.isEmpty()) {
%>



<liferay-ui:search-container
	total="<%=students.size()%>">

	<liferay-ui:search-container-results results="<%=students%>" />

	<liferay-ui:search-container-row
		className="kwan.org.database.model.Student" modelVar="student">

		<liferay-ui:search-container-column-text property="code" />

		<liferay-ui:search-container-column-text property="fullName" />

		<liferay-ui:search-container-column-date property="birthday" />

		<liferay-ui:search-container-column-text property="address" />

		<liferay-ui:search-container-column-jsp
			path="/studentadminportlet/student_actions.jsp" align="right" />

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

<liferay-util:dynamic-include key="kwan.org.database.customs#/view.jsp#pre" />

 

<liferay-util:dynamic-include key="kwan.org.database.customs#/view.jsp#post" />
