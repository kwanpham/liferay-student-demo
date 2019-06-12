<%@include file="../init.jsp"%>

<%@page import="kwan.org.database.service.StudentLocalServiceUtil"%>
<%@page import="kwan.org.database.model.Student"%>







<%

	
	final DateFormat DD_MM_YYYYY = new SimpleDateFormat("dd/MM/yyyy");
	final String DATE_EMPTY_FORMAT = "--/--/----";
	final String FEMALE = LanguageUtil.get(request, "database-portlet.student-list.gender.female");
	final String MALE = LanguageUtil.get(request, "database-portlet.student-list.gender.male");
	List<Student> students = StudentLocalServiceUtil.getStudents();
	
%>
<p>
	<b><liferay-ui:message key="database-portlet.student-list" /></b>
</p>


<%
	if (students != null && !students.isEmpty()) {
		
%>



<liferay-ui:search-container
	total="<%=StudentLocalServiceUtil.getStudentsCount()%>">

	<liferay-ui:search-container-results
		results="${results}" />

	<liferay-ui:search-container-row
		className="kwan.org.database.model.Student" modelVar="student">

		<liferay-ui:search-container-column-text property="code" />

		<liferay-ui:search-container-column-text property="fullName" />

		<liferay-ui:search-container-column-date property="birthday" />

		<liferay-ui:search-container-column-text property="address" />

		
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
