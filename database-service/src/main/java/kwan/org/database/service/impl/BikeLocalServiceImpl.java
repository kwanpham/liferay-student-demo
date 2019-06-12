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

import kwan.org.database.service.base.BikeLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.Date;
import java.util.List;

import kwan.org.database.model.Bike;

/**
 * The implementation of the bike local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link kwan.org.database.service.BikeLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BikeLocalServiceBaseImpl
 * @see kwan.org.database.service.BikeLocalServiceUtil
 */
public class BikeLocalServiceImpl extends BikeLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link kwan.org.database.service.BikeLocalServiceUtil} to access the bike local service.
	 */
	
	public List<Bike> getBikes(String brand) {

		return bikePersistence.findByBrand(brand);
	}

	public List<Bike> getBikes(long studentId) {

		return bikePersistence.findByStudentId(studentId);
	}
	
	public List<Bike> getBikes(long groupId  , long studentId) {
		return bikePersistence.findByG_S(groupId, studentId);
	}

	public Bike addBike(long userId, String bikeName, String brand, long studentId, ServiceContext serviceContext)
			throws PortalException {

		long groupid = serviceContext.getScopeGroupId();

		User user = userLocalService.getUserById(userId);

		long bikeId = counterLocalService.increment();

		Date now = new Date();

		Bike bike = bikePersistence.create(bikeId);

		bike.setUuid(serviceContext.getUuid());
		bike.setUserId(userId);
		bike.setGroupId(groupid);
		bike.setCompanyId(user.getCompanyId());
		bike.setUserName(user.getFullName());
		bike.setCreateDate(serviceContext.getCreateDate(now));
		bike.setModifiedDate(serviceContext.getModifiedDate(now));

		bike.setBikeName(bikeName);
		bike.setBrand(brand);
		bike.setStudentId(studentId);
		bike.setExpandoBridgeAttributes(serviceContext);

		bikePersistence.update(bike);

		return bike;

	}

	public Bike updateBike(long userId, long bikeId, String bikeName, String brand, long studentId,
			ServiceContext serviceContext) throws PortalException {

		Date now = new Date();

		Bike bike = getBike(bikeId);

		User user = userLocalService.getUserById(userId);

		bike.setUserId(userId);
		bike.setUserName(user.getFullName());
		bike.setModifiedDate(serviceContext.getModifiedDate(now));

		bike.setBikeName(bikeName);
		bike.setBrand(brand);

		bikePersistence.update(bike);

		return bike;

	}

	public Bike deleteBike(long bikeId, ServiceContext serviceContext) throws PortalException {

		Bike bike = getBike(bikeId);

		bike = deleteBike(bike);

		return bike;

	}

}