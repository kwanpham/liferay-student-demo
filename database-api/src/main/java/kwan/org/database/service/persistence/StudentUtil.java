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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import kwan.org.database.model.Student;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the student service. This utility wraps {@link kwan.org.database.service.persistence.impl.StudentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StudentPersistence
 * @see kwan.org.database.service.persistence.impl.StudentPersistenceImpl
 * @generated
 */
@ProviderType
public class StudentUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Student student) {
		getPersistence().clearCache(student);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Student> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Student> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Student> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Student> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Student update(Student student) {
		return getPersistence().update(student);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Student update(Student student, ServiceContext serviceContext) {
		return getPersistence().update(student, serviceContext);
	}

	/**
	* Returns all the students where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching students
	*/
	public static List<Student> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<Student> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<Student> findByUuid(String uuid, int start, int end,
		OrderByComparator<Student> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<Student> findByUuid(String uuid, int start, int end,
		OrderByComparator<Student> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first student in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student
	* @throws NoSuchStudentException if a matching student could not be found
	*/
	public static Student findByUuid_First(String uuid,
		OrderByComparator<Student> orderByComparator)
		throws kwan.org.database.exception.NoSuchStudentException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first student in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student, or <code>null</code> if a matching student could not be found
	*/
	public static Student fetchByUuid_First(String uuid,
		OrderByComparator<Student> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last student in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student
	* @throws NoSuchStudentException if a matching student could not be found
	*/
	public static Student findByUuid_Last(String uuid,
		OrderByComparator<Student> orderByComparator)
		throws kwan.org.database.exception.NoSuchStudentException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last student in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student, or <code>null</code> if a matching student could not be found
	*/
	public static Student fetchByUuid_Last(String uuid,
		OrderByComparator<Student> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the students before and after the current student in the ordered set where uuid = &#63;.
	*
	* @param studentId the primary key of the current student
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next student
	* @throws NoSuchStudentException if a student with the primary key could not be found
	*/
	public static Student[] findByUuid_PrevAndNext(long studentId, String uuid,
		OrderByComparator<Student> orderByComparator)
		throws kwan.org.database.exception.NoSuchStudentException {
		return getPersistence()
				   .findByUuid_PrevAndNext(studentId, uuid, orderByComparator);
	}

	/**
	* Removes all the students where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of students where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching students
	*/
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the student where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchStudentException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching student
	* @throws NoSuchStudentException if a matching student could not be found
	*/
	public static Student findByUUID_G(String uuid, long groupId)
		throws kwan.org.database.exception.NoSuchStudentException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the student where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching student, or <code>null</code> if a matching student could not be found
	*/
	public static Student fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the student where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching student, or <code>null</code> if a matching student could not be found
	*/
	public static Student fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the student where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the student that was removed
	*/
	public static Student removeByUUID_G(String uuid, long groupId)
		throws kwan.org.database.exception.NoSuchStudentException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of students where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching students
	*/
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the students where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching students
	*/
	public static List<Student> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static List<Student> findByUuid_C(String uuid, long companyId,
		int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static List<Student> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<Student> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

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
	public static List<Student> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<Student> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first student in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student
	* @throws NoSuchStudentException if a matching student could not be found
	*/
	public static Student findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<Student> orderByComparator)
		throws kwan.org.database.exception.NoSuchStudentException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first student in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student, or <code>null</code> if a matching student could not be found
	*/
	public static Student fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<Student> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last student in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student
	* @throws NoSuchStudentException if a matching student could not be found
	*/
	public static Student findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<Student> orderByComparator)
		throws kwan.org.database.exception.NoSuchStudentException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last student in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student, or <code>null</code> if a matching student could not be found
	*/
	public static Student fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<Student> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

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
	public static Student[] findByUuid_C_PrevAndNext(long studentId,
		String uuid, long companyId,
		OrderByComparator<Student> orderByComparator)
		throws kwan.org.database.exception.NoSuchStudentException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(studentId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the students where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of students where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching students
	*/
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the students where gender = &#63;.
	*
	* @param gender the gender
	* @return the matching students
	*/
	public static List<Student> findByGender(boolean gender) {
		return getPersistence().findByGender(gender);
	}

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
	public static List<Student> findByGender(boolean gender, int start, int end) {
		return getPersistence().findByGender(gender, start, end);
	}

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
	public static List<Student> findByGender(boolean gender, int start,
		int end, OrderByComparator<Student> orderByComparator) {
		return getPersistence()
				   .findByGender(gender, start, end, orderByComparator);
	}

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
	public static List<Student> findByGender(boolean gender, int start,
		int end, OrderByComparator<Student> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByGender(gender, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first student in the ordered set where gender = &#63;.
	*
	* @param gender the gender
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student
	* @throws NoSuchStudentException if a matching student could not be found
	*/
	public static Student findByGender_First(boolean gender,
		OrderByComparator<Student> orderByComparator)
		throws kwan.org.database.exception.NoSuchStudentException {
		return getPersistence().findByGender_First(gender, orderByComparator);
	}

	/**
	* Returns the first student in the ordered set where gender = &#63;.
	*
	* @param gender the gender
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student, or <code>null</code> if a matching student could not be found
	*/
	public static Student fetchByGender_First(boolean gender,
		OrderByComparator<Student> orderByComparator) {
		return getPersistence().fetchByGender_First(gender, orderByComparator);
	}

	/**
	* Returns the last student in the ordered set where gender = &#63;.
	*
	* @param gender the gender
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student
	* @throws NoSuchStudentException if a matching student could not be found
	*/
	public static Student findByGender_Last(boolean gender,
		OrderByComparator<Student> orderByComparator)
		throws kwan.org.database.exception.NoSuchStudentException {
		return getPersistence().findByGender_Last(gender, orderByComparator);
	}

	/**
	* Returns the last student in the ordered set where gender = &#63;.
	*
	* @param gender the gender
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student, or <code>null</code> if a matching student could not be found
	*/
	public static Student fetchByGender_Last(boolean gender,
		OrderByComparator<Student> orderByComparator) {
		return getPersistence().fetchByGender_Last(gender, orderByComparator);
	}

	/**
	* Returns the students before and after the current student in the ordered set where gender = &#63;.
	*
	* @param studentId the primary key of the current student
	* @param gender the gender
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next student
	* @throws NoSuchStudentException if a student with the primary key could not be found
	*/
	public static Student[] findByGender_PrevAndNext(long studentId,
		boolean gender, OrderByComparator<Student> orderByComparator)
		throws kwan.org.database.exception.NoSuchStudentException {
		return getPersistence()
				   .findByGender_PrevAndNext(studentId, gender,
			orderByComparator);
	}

	/**
	* Removes all the students where gender = &#63; from the database.
	*
	* @param gender the gender
	*/
	public static void removeByGender(boolean gender) {
		getPersistence().removeByGender(gender);
	}

	/**
	* Returns the number of students where gender = &#63;.
	*
	* @param gender the gender
	* @return the number of matching students
	*/
	public static int countByGender(boolean gender) {
		return getPersistence().countByGender(gender);
	}

	/**
	* Returns the student where code = &#63; or throws a {@link NoSuchStudentException} if it could not be found.
	*
	* @param code the code
	* @return the matching student
	* @throws NoSuchStudentException if a matching student could not be found
	*/
	public static Student findByCode(String code)
		throws kwan.org.database.exception.NoSuchStudentException {
		return getPersistence().findByCode(code);
	}

	/**
	* Returns the student where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param code the code
	* @return the matching student, or <code>null</code> if a matching student could not be found
	*/
	public static Student fetchByCode(String code) {
		return getPersistence().fetchByCode(code);
	}

	/**
	* Returns the student where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param code the code
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching student, or <code>null</code> if a matching student could not be found
	*/
	public static Student fetchByCode(String code, boolean retrieveFromCache) {
		return getPersistence().fetchByCode(code, retrieveFromCache);
	}

	/**
	* Removes the student where code = &#63; from the database.
	*
	* @param code the code
	* @return the student that was removed
	*/
	public static Student removeByCode(String code)
		throws kwan.org.database.exception.NoSuchStudentException {
		return getPersistence().removeByCode(code);
	}

	/**
	* Returns the number of students where code = &#63;.
	*
	* @param code the code
	* @return the number of matching students
	*/
	public static int countByCode(String code) {
		return getPersistence().countByCode(code);
	}

	/**
	* Returns the student where studentId = &#63; or throws a {@link NoSuchStudentException} if it could not be found.
	*
	* @param studentId the student ID
	* @return the matching student
	* @throws NoSuchStudentException if a matching student could not be found
	*/
	public static Student findByStudentId(long studentId)
		throws kwan.org.database.exception.NoSuchStudentException {
		return getPersistence().findByStudentId(studentId);
	}

	/**
	* Returns the student where studentId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param studentId the student ID
	* @return the matching student, or <code>null</code> if a matching student could not be found
	*/
	public static Student fetchByStudentId(long studentId) {
		return getPersistence().fetchByStudentId(studentId);
	}

	/**
	* Returns the student where studentId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param studentId the student ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching student, or <code>null</code> if a matching student could not be found
	*/
	public static Student fetchByStudentId(long studentId,
		boolean retrieveFromCache) {
		return getPersistence().fetchByStudentId(studentId, retrieveFromCache);
	}

	/**
	* Removes the student where studentId = &#63; from the database.
	*
	* @param studentId the student ID
	* @return the student that was removed
	*/
	public static Student removeByStudentId(long studentId)
		throws kwan.org.database.exception.NoSuchStudentException {
		return getPersistence().removeByStudentId(studentId);
	}

	/**
	* Returns the number of students where studentId = &#63;.
	*
	* @param studentId the student ID
	* @return the number of matching students
	*/
	public static int countByStudentId(long studentId) {
		return getPersistence().countByStudentId(studentId);
	}

	/**
	* Returns all the students where gender = &#63; and address = &#63;.
	*
	* @param gender the gender
	* @param address the address
	* @return the matching students
	*/
	public static List<Student> findByG_A(boolean gender, String address) {
		return getPersistence().findByG_A(gender, address);
	}

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
	public static List<Student> findByG_A(boolean gender, String address,
		int start, int end) {
		return getPersistence().findByG_A(gender, address, start, end);
	}

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
	public static List<Student> findByG_A(boolean gender, String address,
		int start, int end, OrderByComparator<Student> orderByComparator) {
		return getPersistence()
				   .findByG_A(gender, address, start, end, orderByComparator);
	}

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
	public static List<Student> findByG_A(boolean gender, String address,
		int start, int end, OrderByComparator<Student> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByG_A(gender, address, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first student in the ordered set where gender = &#63; and address = &#63;.
	*
	* @param gender the gender
	* @param address the address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student
	* @throws NoSuchStudentException if a matching student could not be found
	*/
	public static Student findByG_A_First(boolean gender, String address,
		OrderByComparator<Student> orderByComparator)
		throws kwan.org.database.exception.NoSuchStudentException {
		return getPersistence()
				   .findByG_A_First(gender, address, orderByComparator);
	}

	/**
	* Returns the first student in the ordered set where gender = &#63; and address = &#63;.
	*
	* @param gender the gender
	* @param address the address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student, or <code>null</code> if a matching student could not be found
	*/
	public static Student fetchByG_A_First(boolean gender, String address,
		OrderByComparator<Student> orderByComparator) {
		return getPersistence()
				   .fetchByG_A_First(gender, address, orderByComparator);
	}

	/**
	* Returns the last student in the ordered set where gender = &#63; and address = &#63;.
	*
	* @param gender the gender
	* @param address the address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student
	* @throws NoSuchStudentException if a matching student could not be found
	*/
	public static Student findByG_A_Last(boolean gender, String address,
		OrderByComparator<Student> orderByComparator)
		throws kwan.org.database.exception.NoSuchStudentException {
		return getPersistence()
				   .findByG_A_Last(gender, address, orderByComparator);
	}

	/**
	* Returns the last student in the ordered set where gender = &#63; and address = &#63;.
	*
	* @param gender the gender
	* @param address the address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student, or <code>null</code> if a matching student could not be found
	*/
	public static Student fetchByG_A_Last(boolean gender, String address,
		OrderByComparator<Student> orderByComparator) {
		return getPersistence()
				   .fetchByG_A_Last(gender, address, orderByComparator);
	}

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
	public static Student[] findByG_A_PrevAndNext(long studentId,
		boolean gender, String address,
		OrderByComparator<Student> orderByComparator)
		throws kwan.org.database.exception.NoSuchStudentException {
		return getPersistence()
				   .findByG_A_PrevAndNext(studentId, gender, address,
			orderByComparator);
	}

	/**
	* Removes all the students where gender = &#63; and address = &#63; from the database.
	*
	* @param gender the gender
	* @param address the address
	*/
	public static void removeByG_A(boolean gender, String address) {
		getPersistence().removeByG_A(gender, address);
	}

	/**
	* Returns the number of students where gender = &#63; and address = &#63;.
	*
	* @param gender the gender
	* @param address the address
	* @return the number of matching students
	*/
	public static int countByG_A(boolean gender, String address) {
		return getPersistence().countByG_A(gender, address);
	}

	/**
	* Caches the student in the entity cache if it is enabled.
	*
	* @param student the student
	*/
	public static void cacheResult(Student student) {
		getPersistence().cacheResult(student);
	}

	/**
	* Caches the students in the entity cache if it is enabled.
	*
	* @param students the students
	*/
	public static void cacheResult(List<Student> students) {
		getPersistence().cacheResult(students);
	}

	/**
	* Creates a new student with the primary key. Does not add the student to the database.
	*
	* @param studentId the primary key for the new student
	* @return the new student
	*/
	public static Student create(long studentId) {
		return getPersistence().create(studentId);
	}

	/**
	* Removes the student with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param studentId the primary key of the student
	* @return the student that was removed
	* @throws NoSuchStudentException if a student with the primary key could not be found
	*/
	public static Student remove(long studentId)
		throws kwan.org.database.exception.NoSuchStudentException {
		return getPersistence().remove(studentId);
	}

	public static Student updateImpl(Student student) {
		return getPersistence().updateImpl(student);
	}

	/**
	* Returns the student with the primary key or throws a {@link NoSuchStudentException} if it could not be found.
	*
	* @param studentId the primary key of the student
	* @return the student
	* @throws NoSuchStudentException if a student with the primary key could not be found
	*/
	public static Student findByPrimaryKey(long studentId)
		throws kwan.org.database.exception.NoSuchStudentException {
		return getPersistence().findByPrimaryKey(studentId);
	}

	/**
	* Returns the student with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param studentId the primary key of the student
	* @return the student, or <code>null</code> if a student with the primary key could not be found
	*/
	public static Student fetchByPrimaryKey(long studentId) {
		return getPersistence().fetchByPrimaryKey(studentId);
	}

	public static java.util.Map<java.io.Serializable, Student> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the students.
	*
	* @return the students
	*/
	public static List<Student> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<Student> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<Student> findAll(int start, int end,
		OrderByComparator<Student> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<Student> findAll(int start, int end,
		OrderByComparator<Student> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the students from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of students.
	*
	* @return the number of students
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static StudentPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<StudentPersistence, StudentPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(StudentPersistence.class);

		ServiceTracker<StudentPersistence, StudentPersistence> serviceTracker = new ServiceTracker<StudentPersistence, StudentPersistence>(bundle.getBundleContext(),
				StudentPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}