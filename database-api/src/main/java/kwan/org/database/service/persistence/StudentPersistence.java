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

package kwan.org.database.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import kwan.org.database.exception.NoSuchStudentException;
import kwan.org.database.model.Student;

/**
 * The persistence interface for the student service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see kwan.org.database.service.persistence.impl.StudentPersistenceImpl
 * @see StudentUtil
 * @generated
 */
@ProviderType
public interface StudentPersistence extends BasePersistence<Student> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StudentUtil} to access the student persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the students where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching students
	*/
	public java.util.List<Student> findByUuid(String uuid);

	/**
	* Returns a range of all the students where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StudentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of students
	* @param end the upper bound of the range of students (not inclusive)
	* @return the range of matching students
	*/
	public java.util.List<Student> findByUuid(String uuid, int start, int end);

	/**
	* Returns an ordered range of all the students where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StudentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of students
	* @param end the upper bound of the range of students (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching students
	*/
	public java.util.List<Student> findByUuid(String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Student> orderByComparator);

	/**
	* Returns an ordered range of all the students where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StudentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of students
	* @param end the upper bound of the range of students (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching students
	*/
	public java.util.List<Student> findByUuid(String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Student> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first student in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student
	* @throws NoSuchStudentException if a matching student could not be found
	*/
	public Student findByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Student> orderByComparator)
		throws NoSuchStudentException;

	/**
	* Returns the first student in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student, or <code>null</code> if a matching student could not be found
	*/
	public Student fetchByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Student> orderByComparator);

	/**
	* Returns the last student in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student
	* @throws NoSuchStudentException if a matching student could not be found
	*/
	public Student findByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Student> orderByComparator)
		throws NoSuchStudentException;

	/**
	* Returns the last student in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student, or <code>null</code> if a matching student could not be found
	*/
	public Student fetchByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Student> orderByComparator);

	/**
	* Returns the students before and after the current student in the ordered set where uuid = &#63;.
	*
	* @param studentId the primary key of the current student
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next student
	* @throws NoSuchStudentException if a student with the primary key could not be found
	*/
	public Student[] findByUuid_PrevAndNext(long studentId, String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Student> orderByComparator)
		throws NoSuchStudentException;

	/**
	* Removes all the students where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(String uuid);

	/**
	* Returns the number of students where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching students
	*/
	public int countByUuid(String uuid);

	/**
	* Returns the student where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchStudentException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching student
	* @throws NoSuchStudentException if a matching student could not be found
	*/
	public Student findByUUID_G(String uuid, long groupId)
		throws NoSuchStudentException;

	/**
	* Returns the student where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching student, or <code>null</code> if a matching student could not be found
	*/
	public Student fetchByUUID_G(String uuid, long groupId);

	/**
	* Returns the student where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching student, or <code>null</code> if a matching student could not be found
	*/
	public Student fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache);

	/**
	* Removes the student where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the student that was removed
	*/
	public Student removeByUUID_G(String uuid, long groupId)
		throws NoSuchStudentException;

	/**
	* Returns the number of students where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching students
	*/
	public int countByUUID_G(String uuid, long groupId);

	/**
	* Returns all the students where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching students
	*/
	public java.util.List<Student> findByUuid_C(String uuid, long companyId);

	/**
	* Returns a range of all the students where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StudentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of students
	* @param end the upper bound of the range of students (not inclusive)
	* @return the range of matching students
	*/
	public java.util.List<Student> findByUuid_C(String uuid, long companyId,
		int start, int end);

	/**
	* Returns an ordered range of all the students where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StudentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of students
	* @param end the upper bound of the range of students (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching students
	*/
	public java.util.List<Student> findByUuid_C(String uuid, long companyId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Student> orderByComparator);

	/**
	* Returns an ordered range of all the students where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StudentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of students
	* @param end the upper bound of the range of students (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching students
	*/
	public java.util.List<Student> findByUuid_C(String uuid, long companyId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Student> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first student in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student
	* @throws NoSuchStudentException if a matching student could not be found
	*/
	public Student findByUuid_C_First(String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Student> orderByComparator)
		throws NoSuchStudentException;

	/**
	* Returns the first student in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student, or <code>null</code> if a matching student could not be found
	*/
	public Student fetchByUuid_C_First(String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Student> orderByComparator);

	/**
	* Returns the last student in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student
	* @throws NoSuchStudentException if a matching student could not be found
	*/
	public Student findByUuid_C_Last(String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Student> orderByComparator)
		throws NoSuchStudentException;

	/**
	* Returns the last student in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student, or <code>null</code> if a matching student could not be found
	*/
	public Student fetchByUuid_C_Last(String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Student> orderByComparator);

	/**
	* Returns the students before and after the current student in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param studentId the primary key of the current student
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next student
	* @throws NoSuchStudentException if a student with the primary key could not be found
	*/
	public Student[] findByUuid_C_PrevAndNext(long studentId, String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Student> orderByComparator)
		throws NoSuchStudentException;

	/**
	* Removes all the students where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(String uuid, long companyId);

	/**
	* Returns the number of students where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching students
	*/
	public int countByUuid_C(String uuid, long companyId);

	/**
	* Returns all the students where gender = &#63;.
	*
	* @param gender the gender
	* @return the matching students
	*/
	public java.util.List<Student> findByGender(boolean gender);

	/**
	* Returns a range of all the students where gender = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StudentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param gender the gender
	* @param start the lower bound of the range of students
	* @param end the upper bound of the range of students (not inclusive)
	* @return the range of matching students
	*/
	public java.util.List<Student> findByGender(boolean gender, int start,
		int end);

	/**
	* Returns an ordered range of all the students where gender = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StudentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param gender the gender
	* @param start the lower bound of the range of students
	* @param end the upper bound of the range of students (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching students
	*/
	public java.util.List<Student> findByGender(boolean gender, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Student> orderByComparator);

	/**
	* Returns an ordered range of all the students where gender = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StudentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param gender the gender
	* @param start the lower bound of the range of students
	* @param end the upper bound of the range of students (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching students
	*/
	public java.util.List<Student> findByGender(boolean gender, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Student> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first student in the ordered set where gender = &#63;.
	*
	* @param gender the gender
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student
	* @throws NoSuchStudentException if a matching student could not be found
	*/
	public Student findByGender_First(boolean gender,
		com.liferay.portal.kernel.util.OrderByComparator<Student> orderByComparator)
		throws NoSuchStudentException;

	/**
	* Returns the first student in the ordered set where gender = &#63;.
	*
	* @param gender the gender
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student, or <code>null</code> if a matching student could not be found
	*/
	public Student fetchByGender_First(boolean gender,
		com.liferay.portal.kernel.util.OrderByComparator<Student> orderByComparator);

	/**
	* Returns the last student in the ordered set where gender = &#63;.
	*
	* @param gender the gender
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student
	* @throws NoSuchStudentException if a matching student could not be found
	*/
	public Student findByGender_Last(boolean gender,
		com.liferay.portal.kernel.util.OrderByComparator<Student> orderByComparator)
		throws NoSuchStudentException;

	/**
	* Returns the last student in the ordered set where gender = &#63;.
	*
	* @param gender the gender
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student, or <code>null</code> if a matching student could not be found
	*/
	public Student fetchByGender_Last(boolean gender,
		com.liferay.portal.kernel.util.OrderByComparator<Student> orderByComparator);

	/**
	* Returns the students before and after the current student in the ordered set where gender = &#63;.
	*
	* @param studentId the primary key of the current student
	* @param gender the gender
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next student
	* @throws NoSuchStudentException if a student with the primary key could not be found
	*/
	public Student[] findByGender_PrevAndNext(long studentId, boolean gender,
		com.liferay.portal.kernel.util.OrderByComparator<Student> orderByComparator)
		throws NoSuchStudentException;

	/**
	* Removes all the students where gender = &#63; from the database.
	*
	* @param gender the gender
	*/
	public void removeByGender(boolean gender);

	/**
	* Returns the number of students where gender = &#63;.
	*
	* @param gender the gender
	* @return the number of matching students
	*/
	public int countByGender(boolean gender);

	/**
	* Returns the student where code = &#63; or throws a {@link NoSuchStudentException} if it could not be found.
	*
	* @param code the code
	* @return the matching student
	* @throws NoSuchStudentException if a matching student could not be found
	*/
	public Student findByCode(String code) throws NoSuchStudentException;

	/**
	* Returns the student where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param code the code
	* @return the matching student, or <code>null</code> if a matching student could not be found
	*/
	public Student fetchByCode(String code);

	/**
	* Returns the student where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param code the code
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching student, or <code>null</code> if a matching student could not be found
	*/
	public Student fetchByCode(String code, boolean retrieveFromCache);

	/**
	* Removes the student where code = &#63; from the database.
	*
	* @param code the code
	* @return the student that was removed
	*/
	public Student removeByCode(String code) throws NoSuchStudentException;

	/**
	* Returns the number of students where code = &#63;.
	*
	* @param code the code
	* @return the number of matching students
	*/
	public int countByCode(String code);

	/**
	* Returns the student where studentId = &#63; or throws a {@link NoSuchStudentException} if it could not be found.
	*
	* @param studentId the student ID
	* @return the matching student
	* @throws NoSuchStudentException if a matching student could not be found
	*/
	public Student findByStudentId(long studentId)
		throws NoSuchStudentException;

	/**
	* Returns the student where studentId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param studentId the student ID
	* @return the matching student, or <code>null</code> if a matching student could not be found
	*/
	public Student fetchByStudentId(long studentId);

	/**
	* Returns the student where studentId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param studentId the student ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching student, or <code>null</code> if a matching student could not be found
	*/
	public Student fetchByStudentId(long studentId, boolean retrieveFromCache);

	/**
	* Removes the student where studentId = &#63; from the database.
	*
	* @param studentId the student ID
	* @return the student that was removed
	*/
	public Student removeByStudentId(long studentId)
		throws NoSuchStudentException;

	/**
	* Returns the number of students where studentId = &#63;.
	*
	* @param studentId the student ID
	* @return the number of matching students
	*/
	public int countByStudentId(long studentId);

	/**
	* Returns all the students where gender = &#63; and address = &#63;.
	*
	* @param gender the gender
	* @param address the address
	* @return the matching students
	*/
	public java.util.List<Student> findByG_A(boolean gender, String address);

	/**
	* Returns a range of all the students where gender = &#63; and address = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StudentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param gender the gender
	* @param address the address
	* @param start the lower bound of the range of students
	* @param end the upper bound of the range of students (not inclusive)
	* @return the range of matching students
	*/
	public java.util.List<Student> findByG_A(boolean gender, String address,
		int start, int end);

	/**
	* Returns an ordered range of all the students where gender = &#63; and address = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StudentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param gender the gender
	* @param address the address
	* @param start the lower bound of the range of students
	* @param end the upper bound of the range of students (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching students
	*/
	public java.util.List<Student> findByG_A(boolean gender, String address,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Student> orderByComparator);

	/**
	* Returns an ordered range of all the students where gender = &#63; and address = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StudentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param gender the gender
	* @param address the address
	* @param start the lower bound of the range of students
	* @param end the upper bound of the range of students (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching students
	*/
	public java.util.List<Student> findByG_A(boolean gender, String address,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Student> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first student in the ordered set where gender = &#63; and address = &#63;.
	*
	* @param gender the gender
	* @param address the address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student
	* @throws NoSuchStudentException if a matching student could not be found
	*/
	public Student findByG_A_First(boolean gender, String address,
		com.liferay.portal.kernel.util.OrderByComparator<Student> orderByComparator)
		throws NoSuchStudentException;

	/**
	* Returns the first student in the ordered set where gender = &#63; and address = &#63;.
	*
	* @param gender the gender
	* @param address the address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student, or <code>null</code> if a matching student could not be found
	*/
	public Student fetchByG_A_First(boolean gender, String address,
		com.liferay.portal.kernel.util.OrderByComparator<Student> orderByComparator);

	/**
	* Returns the last student in the ordered set where gender = &#63; and address = &#63;.
	*
	* @param gender the gender
	* @param address the address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student
	* @throws NoSuchStudentException if a matching student could not be found
	*/
	public Student findByG_A_Last(boolean gender, String address,
		com.liferay.portal.kernel.util.OrderByComparator<Student> orderByComparator)
		throws NoSuchStudentException;

	/**
	* Returns the last student in the ordered set where gender = &#63; and address = &#63;.
	*
	* @param gender the gender
	* @param address the address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student, or <code>null</code> if a matching student could not be found
	*/
	public Student fetchByG_A_Last(boolean gender, String address,
		com.liferay.portal.kernel.util.OrderByComparator<Student> orderByComparator);

	/**
	* Returns the students before and after the current student in the ordered set where gender = &#63; and address = &#63;.
	*
	* @param studentId the primary key of the current student
	* @param gender the gender
	* @param address the address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next student
	* @throws NoSuchStudentException if a student with the primary key could not be found
	*/
	public Student[] findByG_A_PrevAndNext(long studentId, boolean gender,
		String address,
		com.liferay.portal.kernel.util.OrderByComparator<Student> orderByComparator)
		throws NoSuchStudentException;

	/**
	* Removes all the students where gender = &#63; and address = &#63; from the database.
	*
	* @param gender the gender
	* @param address the address
	*/
	public void removeByG_A(boolean gender, String address);

	/**
	* Returns the number of students where gender = &#63; and address = &#63;.
	*
	* @param gender the gender
	* @param address the address
	* @return the number of matching students
	*/
	public int countByG_A(boolean gender, String address);

	/**
	* Caches the student in the entity cache if it is enabled.
	*
	* @param student the student
	*/
	public void cacheResult(Student student);

	/**
	* Caches the students in the entity cache if it is enabled.
	*
	* @param students the students
	*/
	public void cacheResult(java.util.List<Student> students);

	/**
	* Creates a new student with the primary key. Does not add the student to the database.
	*
	* @param studentId the primary key for the new student
	* @return the new student
	*/
	public Student create(long studentId);

	/**
	* Removes the student with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param studentId the primary key of the student
	* @return the student that was removed
	* @throws NoSuchStudentException if a student with the primary key could not be found
	*/
	public Student remove(long studentId) throws NoSuchStudentException;

	public Student updateImpl(Student student);

	/**
	* Returns the student with the primary key or throws a {@link NoSuchStudentException} if it could not be found.
	*
	* @param studentId the primary key of the student
	* @return the student
	* @throws NoSuchStudentException if a student with the primary key could not be found
	*/
	public Student findByPrimaryKey(long studentId)
		throws NoSuchStudentException;

	/**
	* Returns the student with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param studentId the primary key of the student
	* @return the student, or <code>null</code> if a student with the primary key could not be found
	*/
	public Student fetchByPrimaryKey(long studentId);

	@Override
	public java.util.Map<java.io.Serializable, Student> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the students.
	*
	* @return the students
	*/
	public java.util.List<Student> findAll();

	/**
	* Returns a range of all the students.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StudentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of students
	* @param end the upper bound of the range of students (not inclusive)
	* @return the range of students
	*/
	public java.util.List<Student> findAll(int start, int end);

	/**
	* Returns an ordered range of all the students.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StudentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of students
	* @param end the upper bound of the range of students (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of students
	*/
	public java.util.List<Student> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Student> orderByComparator);

	/**
	* Returns an ordered range of all the students.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StudentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of students
	* @param end the upper bound of the range of students (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of students
	*/
	public java.util.List<Student> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Student> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the students from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of students.
	*
	* @return the number of students
	*/
	public int countAll();

	@Override
	public java.util.Set<String> getBadColumnNames();
}