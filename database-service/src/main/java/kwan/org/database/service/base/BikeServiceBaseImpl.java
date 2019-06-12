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

package kwan.org.database.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import kwan.org.database.model.Bike;
import kwan.org.database.service.BikeService;
import kwan.org.database.service.persistence.BikePersistence;
import kwan.org.database.service.persistence.StudentFinder;
import kwan.org.database.service.persistence.StudentPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the bike remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link kwan.org.database.service.impl.BikeServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see kwan.org.database.service.impl.BikeServiceImpl
 * @see kwan.org.database.service.BikeServiceUtil
 * @generated
 */
public abstract class BikeServiceBaseImpl extends BaseServiceImpl
	implements BikeService, IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link kwan.org.database.service.BikeServiceUtil} to access the bike remote service.
	 */

	/**
	 * Returns the bike local service.
	 *
	 * @return the bike local service
	 */
	public kwan.org.database.service.BikeLocalService getBikeLocalService() {
		return bikeLocalService;
	}

	/**
	 * Sets the bike local service.
	 *
	 * @param bikeLocalService the bike local service
	 */
	public void setBikeLocalService(
		kwan.org.database.service.BikeLocalService bikeLocalService) {
		this.bikeLocalService = bikeLocalService;
	}

	/**
	 * Returns the bike remote service.
	 *
	 * @return the bike remote service
	 */
	public BikeService getBikeService() {
		return bikeService;
	}

	/**
	 * Sets the bike remote service.
	 *
	 * @param bikeService the bike remote service
	 */
	public void setBikeService(BikeService bikeService) {
		this.bikeService = bikeService;
	}

	/**
	 * Returns the bike persistence.
	 *
	 * @return the bike persistence
	 */
	public BikePersistence getBikePersistence() {
		return bikePersistence;
	}

	/**
	 * Sets the bike persistence.
	 *
	 * @param bikePersistence the bike persistence
	 */
	public void setBikePersistence(BikePersistence bikePersistence) {
		this.bikePersistence = bikePersistence;
	}

	/**
	 * Returns the student local service.
	 *
	 * @return the student local service
	 */
	public kwan.org.database.service.StudentLocalService getStudentLocalService() {
		return studentLocalService;
	}

	/**
	 * Sets the student local service.
	 *
	 * @param studentLocalService the student local service
	 */
	public void setStudentLocalService(
		kwan.org.database.service.StudentLocalService studentLocalService) {
		this.studentLocalService = studentLocalService;
	}

	/**
	 * Returns the student remote service.
	 *
	 * @return the student remote service
	 */
	public kwan.org.database.service.StudentService getStudentService() {
		return studentService;
	}

	/**
	 * Sets the student remote service.
	 *
	 * @param studentService the student remote service
	 */
	public void setStudentService(
		kwan.org.database.service.StudentService studentService) {
		this.studentService = studentService;
	}

	/**
	 * Returns the student persistence.
	 *
	 * @return the student persistence
	 */
	public StudentPersistence getStudentPersistence() {
		return studentPersistence;
	}

	/**
	 * Sets the student persistence.
	 *
	 * @param studentPersistence the student persistence
	 */
	public void setStudentPersistence(StudentPersistence studentPersistence) {
		this.studentPersistence = studentPersistence;
	}

	/**
	 * Returns the student finder.
	 *
	 * @return the student finder
	 */
	public StudentFinder getStudentFinder() {
		return studentFinder;
	}

	/**
	 * Sets the student finder.
	 *
	 * @param studentFinder the student finder
	 */
	public void setStudentFinder(StudentFinder studentFinder) {
		this.studentFinder = studentFinder;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService getClassNameLocalService() {
		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService) {
		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name remote service.
	 *
	 * @return the class name remote service
	 */
	public com.liferay.portal.kernel.service.ClassNameService getClassNameService() {
		return classNameService;
	}

	/**
	 * Sets the class name remote service.
	 *
	 * @param classNameService the class name remote service
	 */
	public void setClassNameService(
		com.liferay.portal.kernel.service.ClassNameService classNameService) {
		this.classNameService = classNameService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {
		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.kernel.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.kernel.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
	}

	public void destroy() {
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return BikeService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Bike.class;
	}

	protected String getModelClassName() {
		return Bike.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = bikePersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = kwan.org.database.service.BikeLocalService.class)
	protected kwan.org.database.service.BikeLocalService bikeLocalService;
	@BeanReference(type = BikeService.class)
	protected BikeService bikeService;
	@BeanReference(type = BikePersistence.class)
	protected BikePersistence bikePersistence;
	@BeanReference(type = kwan.org.database.service.StudentLocalService.class)
	protected kwan.org.database.service.StudentLocalService studentLocalService;
	@BeanReference(type = kwan.org.database.service.StudentService.class)
	protected kwan.org.database.service.StudentService studentService;
	@BeanReference(type = StudentPersistence.class)
	protected StudentPersistence studentPersistence;
	@BeanReference(type = StudentFinder.class)
	protected StudentFinder studentFinder;
	@ServiceReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameService.class)
	protected com.liferay.portal.kernel.service.ClassNameService classNameService;
	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@ServiceReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserService.class)
	protected com.liferay.portal.kernel.service.UserService userService;
	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
}