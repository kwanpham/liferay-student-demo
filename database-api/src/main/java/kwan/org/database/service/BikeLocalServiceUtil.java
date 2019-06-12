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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Bike. This utility wraps
 * {@link kwan.org.database.service.impl.BikeLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see BikeLocalService
 * @see kwan.org.database.service.base.BikeLocalServiceBaseImpl
 * @see kwan.org.database.service.impl.BikeLocalServiceImpl
 * @generated
 */
@ProviderType
public class BikeLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link kwan.org.database.service.impl.BikeLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the bike to the database. Also notifies the appropriate model listeners.
	*
	* @param bike the bike
	* @return the bike that was added
	*/
	public static kwan.org.database.model.Bike addBike(
		kwan.org.database.model.Bike bike) {
		return getService().addBike(bike);
	}

	public static kwan.org.database.model.Bike addBike(long userId,
		String bikeName, String brand, long studentId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .addBike(userId, bikeName, brand, studentId, serviceContext);
	}

	/**
	* Creates a new bike with the primary key. Does not add the bike to the database.
	*
	* @param bikeId the primary key for the new bike
	* @return the new bike
	*/
	public static kwan.org.database.model.Bike createBike(long bikeId) {
		return getService().createBike(bikeId);
	}

	/**
	* Deletes the bike from the database. Also notifies the appropriate model listeners.
	*
	* @param bike the bike
	* @return the bike that was removed
	*/
	public static kwan.org.database.model.Bike deleteBike(
		kwan.org.database.model.Bike bike) {
		return getService().deleteBike(bike);
	}

	/**
	* Deletes the bike with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bikeId the primary key of the bike
	* @return the bike that was removed
	* @throws PortalException if a bike with the primary key could not be found
	*/
	public static kwan.org.database.model.Bike deleteBike(long bikeId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteBike(bikeId);
	}

	public static kwan.org.database.model.Bike deleteBike(long bikeId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteBike(bikeId, serviceContext);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link kwan.org.database.model.impl.BikeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link kwan.org.database.model.impl.BikeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static kwan.org.database.model.Bike fetchBike(long bikeId) {
		return getService().fetchBike(bikeId);
	}

	/**
	* Returns the bike matching the UUID and group.
	*
	* @param uuid the bike's UUID
	* @param groupId the primary key of the group
	* @return the matching bike, or <code>null</code> if a matching bike could not be found
	*/
	public static kwan.org.database.model.Bike fetchBikeByUuidAndGroupId(
		String uuid, long groupId) {
		return getService().fetchBikeByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	/**
	* Returns the bike with the primary key.
	*
	* @param bikeId the primary key of the bike
	* @return the bike
	* @throws PortalException if a bike with the primary key could not be found
	*/
	public static kwan.org.database.model.Bike getBike(long bikeId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getBike(bikeId);
	}

	/**
	* Returns the bike matching the UUID and group.
	*
	* @param uuid the bike's UUID
	* @param groupId the primary key of the group
	* @return the matching bike
	* @throws PortalException if a matching bike could not be found
	*/
	public static kwan.org.database.model.Bike getBikeByUuidAndGroupId(
		String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getBikeByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the bikes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link kwan.org.database.model.impl.BikeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bikes
	* @param end the upper bound of the range of bikes (not inclusive)
	* @return the range of bikes
	*/
	public static java.util.List<kwan.org.database.model.Bike> getBikes(
		int start, int end) {
		return getService().getBikes(start, end);
	}

	public static java.util.List<kwan.org.database.model.Bike> getBikes(
		long studentId) {
		return getService().getBikes(studentId);
	}

	public static java.util.List<kwan.org.database.model.Bike> getBikes(
		long groupId, long studentId) {
		return getService().getBikes(groupId, studentId);
	}

	public static java.util.List<kwan.org.database.model.Bike> getBikes(
		String brand) {
		return getService().getBikes(brand);
	}

	/**
	* Returns all the bikes matching the UUID and company.
	*
	* @param uuid the UUID of the bikes
	* @param companyId the primary key of the company
	* @return the matching bikes, or an empty list if no matches were found
	*/
	public static java.util.List<kwan.org.database.model.Bike> getBikesByUuidAndCompanyId(
		String uuid, long companyId) {
		return getService().getBikesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns a range of bikes matching the UUID and company.
	*
	* @param uuid the UUID of the bikes
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of bikes
	* @param end the upper bound of the range of bikes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching bikes, or an empty list if no matches were found
	*/
	public static java.util.List<kwan.org.database.model.Bike> getBikesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<kwan.org.database.model.Bike> orderByComparator) {
		return getService()
				   .getBikesByUuidAndCompanyId(uuid, companyId, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of bikes.
	*
	* @return the number of bikes
	*/
	public static int getBikesCount() {
		return getService().getBikesCount();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the bike in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param bike the bike
	* @return the bike that was updated
	*/
	public static kwan.org.database.model.Bike updateBike(
		kwan.org.database.model.Bike bike) {
		return getService().updateBike(bike);
	}

	public static kwan.org.database.model.Bike updateBike(long userId,
		long bikeId, String bikeName, String brand, long studentId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .updateBike(userId, bikeId, bikeName, brand, studentId,
			serviceContext);
	}

	public static BikeLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<BikeLocalService, BikeLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(BikeLocalService.class);

		ServiceTracker<BikeLocalService, BikeLocalService> serviceTracker = new ServiceTracker<BikeLocalService, BikeLocalService>(bundle.getBundleContext(),
				BikeLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}