/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package kwan.org.database.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link StudentLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see StudentLocalService
 * @generated
 */
@ProviderType
public class StudentLocalServiceWrapper implements StudentLocalService,
	ServiceWrapper<StudentLocalService> {
	public StudentLocalServiceWrapper(StudentLocalService studentLocalService) {
		_studentLocalService = studentLocalService;
	}

	@Override
	public kwan.org.database.model.Student addStudent(long userId, String code,
		String fullname, java.util.Date birthday, boolean gender,
		String address,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _studentLocalService.addStudent(userId, code, fullname,
			birthday, gender, address, serviceContext);
	}

	/**
	* Adds the student to the database. Also notifies the appropriate model listeners.
	*
	* @param student the student
	* @return the student that was added
	*/
	@Override
	public kwan.org.database.model.Student addStudent(
		kwan.org.database.model.Student student) {
		return _studentLocalService.addStudent(student);
	}

	/**
	* Creates a new student with the primary key. Does not add the student to the database.
	*
	* @param studentId the primary key for the new student
	* @return the new student
	*/
	@Override
	public kwan.org.database.model.Student createStudent(long studentId) {
		return _studentLocalService.createStudent(studentId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _studentLocalService.deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the student with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param studentId the primary key of the student
	* @return the student that was removed
	* @throws PortalException if a student with the primary key could not be found
	*/
	@Override
	public kwan.org.database.model.Student deleteStudent(long studentId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _studentLocalService.deleteStudent(studentId);
	}

	@Override
	public kwan.org.database.model.Student deleteStudent(long studentId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _studentLocalService.deleteStudent(studentId, serviceContext);
	}

	/**
	* Deletes the student from the database. Also notifies the appropriate model listeners.
	*
	* @param student the student
	* @return the student that was removed
	*/
	@Override
	public kwan.org.database.model.Student deleteStudent(
		kwan.org.database.model.Student student) {
		return _studentLocalService.deleteStudent(student);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _studentLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _studentLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link kwan.org.database.model.impl.StudentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _studentLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link kwan.org.database.model.impl.StudentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _studentLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _studentLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _studentLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public kwan.org.database.model.Student fetchStudent(long studentId) {
		return _studentLocalService.fetchStudent(studentId);
	}

	/**
	* Returns the student matching the UUID and group.
	*
	* @param uuid the student's UUID
	* @param groupId the primary key of the group
	* @return the matching student, or <code>null</code> if a matching student could not be found
	*/
	@Override
	public kwan.org.database.model.Student fetchStudentByUuidAndGroupId(
		String uuid, long groupId) {
		return _studentLocalService.fetchStudentByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List<kwan.org.database.model.Student> findByFullName(
		String fullName) {
		return _studentLocalService.findByFullName(fullName);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _studentLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return _studentLocalService.getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _studentLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _studentLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _studentLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.util.List<kwan.org.database.model.Student> getStuden(
		boolean gender, String address) {
		return _studentLocalService.getStuden(gender, address);
	}

	/**
	* Returns the student with the primary key.
	*
	* @param studentId the primary key of the student
	* @return the student
	* @throws PortalException if a student with the primary key could not be found
	*/
	@Override
	public kwan.org.database.model.Student getStudent(long studentId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _studentLocalService.getStudent(studentId);
	}

	/**
	* Returns the student matching the UUID and group.
	*
	* @param uuid the student's UUID
	* @param groupId the primary key of the group
	* @return the matching student
	* @throws PortalException if a matching student could not be found
	*/
	@Override
	public kwan.org.database.model.Student getStudentByUuidAndGroupId(
		String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _studentLocalService.getStudentByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List<kwan.org.database.model.Student> getStudents() {
		return _studentLocalService.getStudents();
	}

	@Override
	public java.util.List<kwan.org.database.model.Student> getStudents(
		boolean gender) {
		return _studentLocalService.getStudents(gender);
	}

	/**
	* Returns a range of all the students.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link kwan.org.database.model.impl.StudentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of students
	* @param end the upper bound of the range of students (not inclusive)
	* @return the range of students
	*/
	@Override
	public java.util.List<kwan.org.database.model.Student> getStudents(
		int start, int end) {
		return _studentLocalService.getStudents(start, end);
	}

	@Override
	public java.util.List<kwan.org.database.model.Student> getStudents(
		String keywords) {
		return _studentLocalService.getStudents(keywords);
	}

	/**
	* Returns all the students matching the UUID and company.
	*
	* @param uuid the UUID of the students
	* @param companyId the primary key of the company
	* @return the matching students, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<kwan.org.database.model.Student> getStudentsByUuidAndCompanyId(
		String uuid, long companyId) {
		return _studentLocalService.getStudentsByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns a range of students matching the UUID and company.
	*
	* @param uuid the UUID of the students
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of students
	* @param end the upper bound of the range of students (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching students, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<kwan.org.database.model.Student> getStudentsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<kwan.org.database.model.Student> orderByComparator) {
		return _studentLocalService.getStudentsByUuidAndCompanyId(uuid,
			companyId, start, end, orderByComparator);
	}

	/**
	* Returns the number of students.
	*
	* @return the number of students
	*/
	@Override
	public int getStudentsCount() {
		return _studentLocalService.getStudentsCount();
	}

	@Override
	public kwan.org.database.model.Student updateStudent(long userId,
		long studentId, String code, String fullname, java.util.Date birthday,
		boolean gender, String address,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _studentLocalService.updateStudent(userId, studentId, code,
			fullname, birthday, gender, address, serviceContext);
	}

	/**
	* Updates the student in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param student the student
	* @return the student that was updated
	*/
	@Override
	public kwan.org.database.model.Student updateStudent(
		kwan.org.database.model.Student student) {
		return _studentLocalService.updateStudent(student);
	}

	@Override
	public StudentLocalService getWrappedService() {
		return _studentLocalService;
	}

	@Override
	public void setWrappedService(StudentLocalService studentLocalService) {
		_studentLocalService = studentLocalService;
	}

	private StudentLocalService _studentLocalService;
}