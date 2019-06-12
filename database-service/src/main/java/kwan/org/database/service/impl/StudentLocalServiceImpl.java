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

package kwan.org.database.service.impl;

import kwan.org.database.service.base.StudentLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;

import java.util.Date;
import java.util.List;

import kwan.org.database.exception.StudentFullNameException;
import kwan.org.database.model.Bike;
import kwan.org.database.model.Student;

/**
 * The implementation of the student local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link kwan.org.database.service.StudentLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StudentLocalServiceBaseImpl
 * @see kwan.org.database.service.StudentLocalServiceUtil
 */
public class StudentLocalServiceImpl extends StudentLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link
	 * kwan.org.database.service.StudentLocalServiceUtil} to access the student
	 * local service.
	 */
	public List<Student> findByFullName(String fullName) {

		return studentFinder.findByFullName(fullName);
	}

	public List<Student> getStudents() {
		return studentPersistence.findAll();
	}

	public List<Student> getStudents(boolean gender) {
		return studentPersistence.findByGender(gender);
	}

	public List<Student> getStuden(boolean gender, String address) {
		return studentPersistence.findByG_A(gender, address);
	}

	

	public Student addStudent(long userId, String code, String fullname, Date birthday, boolean gender, String address,
			ServiceContext serviceContext) throws PortalException {

		validate(fullname);
		
		long groupId = serviceContext.getScopeGroupId();

		User user = userLocalService.getUserById(userId);

		long studentId = counterLocalService.increment();

		Date now = new Date();

		validate(fullname);

		Student student = studentPersistence.create(studentId);

		student.setUuid(serviceContext.getUuid());
		student.setUserId(userId);
		student.setGroupId(groupId);
		student.setCompanyId(user.getCompanyId());
		student.setUserName(user.getFullName());
		student.setCreateDate(serviceContext.getCreateDate(now));
		student.setModifiedDate(serviceContext.getModifiedDate(now));

		student.setCode(code);
		student.setFullName(fullname);
		student.setBirthday(birthday);
		student.setGender(gender);
		student.setAddress(address);

		student.setExpandoBridgeAttributes(serviceContext);

		studentPersistence.update(student);
		return student;

	}

	public Student updateStudent(long userId, long studentId, String code, String fullname, Date birthday,
			boolean gender, String address, ServiceContext serviceContext) throws PortalException {

		Date now = new Date();

		Student student = getStudent(studentId);

		User user = userLocalService.getUser(userId);

		validate(fullname);

		// student.setUuid(serviceContext.getUuid());
		student.setUserId(userId);
		// student.setGroupId(groupId);
		student.setCompanyId(user.getCompanyId());
		student.setUserName(user.getFullName());
		student.setModifiedDate(serviceContext.getModifiedDate(now));

		student.setCode(code);
		student.setFullName(fullname);
		student.setBirthday(birthday);
		student.setGender(gender);
		student.setAddress(address);

		studentPersistence.update(student);

		return student;

	}

	public Student deleteStudent(long studentId, ServiceContext serviceContext)
			throws PortalException, SystemException {

		Student student = getStudent(studentId);

		List<Bike> bikes = bikeLocalService.getBikes(studentId);

		for (Bike bike : bikes) {
			bikeLocalService.deleteBike(bike);
		}

		student = deleteStudent(student);

		return student;

	}

	protected void validate(String fullname) throws PortalException {

		if (Validator.isNull(fullname)) {
			throw new StudentFullNameException("Sai");
		}

	}

	@Override
	public List<Student> getStudents(String keywords) {
		// TODO Auto-generated method stub
		return studentFinder.findByFullName(keywords);
	}
}