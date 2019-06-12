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

import kwan.org.database.model.Bike;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the bike service. This utility wraps {@link kwan.org.database.service.persistence.impl.BikePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BikePersistence
 * @see kwan.org.database.service.persistence.impl.BikePersistenceImpl
 * @generated
 */
@ProviderType
public class BikeUtil {
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
	public static void clearCache(Bike bike) {
		getPersistence().clearCache(bike);
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
	public static List<Bike> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Bike> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Bike> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator<Bike> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Bike update(Bike bike) {
		return getPersistence().update(bike);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Bike update(Bike bike, ServiceContext serviceContext) {
		return getPersistence().update(bike, serviceContext);
	}

	/**
	* Returns all the bikes where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching bikes
	*/
	public static List<Bike> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the bikes where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BikeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of bikes
	* @param end the upper bound of the range of bikes (not inclusive)
	* @return the range of matching bikes
	*/
	public static List<Bike> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the bikes where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BikeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of bikes
	* @param end the upper bound of the range of bikes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching bikes
	*/
	public static List<Bike> findByUuid(String uuid, int start, int end,
		OrderByComparator<Bike> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the bikes where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BikeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of bikes
	* @param end the upper bound of the range of bikes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching bikes
	*/
	public static List<Bike> findByUuid(String uuid, int start, int end,
		OrderByComparator<Bike> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first bike in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bike
	* @throws NoSuchBikeException if a matching bike could not be found
	*/
	public static Bike findByUuid_First(String uuid,
		OrderByComparator<Bike> orderByComparator)
		throws kwan.org.database.exception.NoSuchBikeException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first bike in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bike, or <code>null</code> if a matching bike could not be found
	*/
	public static Bike fetchByUuid_First(String uuid,
		OrderByComparator<Bike> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last bike in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bike
	* @throws NoSuchBikeException if a matching bike could not be found
	*/
	public static Bike findByUuid_Last(String uuid,
		OrderByComparator<Bike> orderByComparator)
		throws kwan.org.database.exception.NoSuchBikeException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last bike in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bike, or <code>null</code> if a matching bike could not be found
	*/
	public static Bike fetchByUuid_Last(String uuid,
		OrderByComparator<Bike> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the bikes before and after the current bike in the ordered set where uuid = &#63;.
	*
	* @param bikeId the primary key of the current bike
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next bike
	* @throws NoSuchBikeException if a bike with the primary key could not be found
	*/
	public static Bike[] findByUuid_PrevAndNext(long bikeId, String uuid,
		OrderByComparator<Bike> orderByComparator)
		throws kwan.org.database.exception.NoSuchBikeException {
		return getPersistence()
				   .findByUuid_PrevAndNext(bikeId, uuid, orderByComparator);
	}

	/**
	* Removes all the bikes where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of bikes where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching bikes
	*/
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the bike where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchBikeException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching bike
	* @throws NoSuchBikeException if a matching bike could not be found
	*/
	public static Bike findByUUID_G(String uuid, long groupId)
		throws kwan.org.database.exception.NoSuchBikeException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the bike where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching bike, or <code>null</code> if a matching bike could not be found
	*/
	public static Bike fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the bike where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching bike, or <code>null</code> if a matching bike could not be found
	*/
	public static Bike fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the bike where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the bike that was removed
	*/
	public static Bike removeByUUID_G(String uuid, long groupId)
		throws kwan.org.database.exception.NoSuchBikeException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of bikes where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching bikes
	*/
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the bikes where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching bikes
	*/
	public static List<Bike> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the bikes where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BikeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of bikes
	* @param end the upper bound of the range of bikes (not inclusive)
	* @return the range of matching bikes
	*/
	public static List<Bike> findByUuid_C(String uuid, long companyId,
		int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the bikes where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BikeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of bikes
	* @param end the upper bound of the range of bikes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching bikes
	*/
	public static List<Bike> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<Bike> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the bikes where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BikeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of bikes
	* @param end the upper bound of the range of bikes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching bikes
	*/
	public static List<Bike> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<Bike> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first bike in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bike
	* @throws NoSuchBikeException if a matching bike could not be found
	*/
	public static Bike findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<Bike> orderByComparator)
		throws kwan.org.database.exception.NoSuchBikeException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first bike in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bike, or <code>null</code> if a matching bike could not be found
	*/
	public static Bike fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<Bike> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last bike in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bike
	* @throws NoSuchBikeException if a matching bike could not be found
	*/
	public static Bike findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<Bike> orderByComparator)
		throws kwan.org.database.exception.NoSuchBikeException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last bike in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bike, or <code>null</code> if a matching bike could not be found
	*/
	public static Bike fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<Bike> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the bikes before and after the current bike in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param bikeId the primary key of the current bike
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next bike
	* @throws NoSuchBikeException if a bike with the primary key could not be found
	*/
	public static Bike[] findByUuid_C_PrevAndNext(long bikeId, String uuid,
		long companyId, OrderByComparator<Bike> orderByComparator)
		throws kwan.org.database.exception.NoSuchBikeException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(bikeId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the bikes where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of bikes where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching bikes
	*/
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the bikes where brand = &#63;.
	*
	* @param brand the brand
	* @return the matching bikes
	*/
	public static List<Bike> findByBrand(String brand) {
		return getPersistence().findByBrand(brand);
	}

	/**
	* Returns a range of all the bikes where brand = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BikeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param brand the brand
	* @param start the lower bound of the range of bikes
	* @param end the upper bound of the range of bikes (not inclusive)
	* @return the range of matching bikes
	*/
	public static List<Bike> findByBrand(String brand, int start, int end) {
		return getPersistence().findByBrand(brand, start, end);
	}

	/**
	* Returns an ordered range of all the bikes where brand = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BikeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param brand the brand
	* @param start the lower bound of the range of bikes
	* @param end the upper bound of the range of bikes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching bikes
	*/
	public static List<Bike> findByBrand(String brand, int start, int end,
		OrderByComparator<Bike> orderByComparator) {
		return getPersistence().findByBrand(brand, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the bikes where brand = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BikeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param brand the brand
	* @param start the lower bound of the range of bikes
	* @param end the upper bound of the range of bikes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching bikes
	*/
	public static List<Bike> findByBrand(String brand, int start, int end,
		OrderByComparator<Bike> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByBrand(brand, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first bike in the ordered set where brand = &#63;.
	*
	* @param brand the brand
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bike
	* @throws NoSuchBikeException if a matching bike could not be found
	*/
	public static Bike findByBrand_First(String brand,
		OrderByComparator<Bike> orderByComparator)
		throws kwan.org.database.exception.NoSuchBikeException {
		return getPersistence().findByBrand_First(brand, orderByComparator);
	}

	/**
	* Returns the first bike in the ordered set where brand = &#63;.
	*
	* @param brand the brand
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bike, or <code>null</code> if a matching bike could not be found
	*/
	public static Bike fetchByBrand_First(String brand,
		OrderByComparator<Bike> orderByComparator) {
		return getPersistence().fetchByBrand_First(brand, orderByComparator);
	}

	/**
	* Returns the last bike in the ordered set where brand = &#63;.
	*
	* @param brand the brand
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bike
	* @throws NoSuchBikeException if a matching bike could not be found
	*/
	public static Bike findByBrand_Last(String brand,
		OrderByComparator<Bike> orderByComparator)
		throws kwan.org.database.exception.NoSuchBikeException {
		return getPersistence().findByBrand_Last(brand, orderByComparator);
	}

	/**
	* Returns the last bike in the ordered set where brand = &#63;.
	*
	* @param brand the brand
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bike, or <code>null</code> if a matching bike could not be found
	*/
	public static Bike fetchByBrand_Last(String brand,
		OrderByComparator<Bike> orderByComparator) {
		return getPersistence().fetchByBrand_Last(brand, orderByComparator);
	}

	/**
	* Returns the bikes before and after the current bike in the ordered set where brand = &#63;.
	*
	* @param bikeId the primary key of the current bike
	* @param brand the brand
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next bike
	* @throws NoSuchBikeException if a bike with the primary key could not be found
	*/
	public static Bike[] findByBrand_PrevAndNext(long bikeId, String brand,
		OrderByComparator<Bike> orderByComparator)
		throws kwan.org.database.exception.NoSuchBikeException {
		return getPersistence()
				   .findByBrand_PrevAndNext(bikeId, brand, orderByComparator);
	}

	/**
	* Removes all the bikes where brand = &#63; from the database.
	*
	* @param brand the brand
	*/
	public static void removeByBrand(String brand) {
		getPersistence().removeByBrand(brand);
	}

	/**
	* Returns the number of bikes where brand = &#63;.
	*
	* @param brand the brand
	* @return the number of matching bikes
	*/
	public static int countByBrand(String brand) {
		return getPersistence().countByBrand(brand);
	}

	/**
	* Returns all the bikes where studentId = &#63;.
	*
	* @param studentId the student ID
	* @return the matching bikes
	*/
	public static List<Bike> findByStudentId(long studentId) {
		return getPersistence().findByStudentId(studentId);
	}

	/**
	* Returns a range of all the bikes where studentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BikeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param studentId the student ID
	* @param start the lower bound of the range of bikes
	* @param end the upper bound of the range of bikes (not inclusive)
	* @return the range of matching bikes
	*/
	public static List<Bike> findByStudentId(long studentId, int start, int end) {
		return getPersistence().findByStudentId(studentId, start, end);
	}

	/**
	* Returns an ordered range of all the bikes where studentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BikeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param studentId the student ID
	* @param start the lower bound of the range of bikes
	* @param end the upper bound of the range of bikes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching bikes
	*/
	public static List<Bike> findByStudentId(long studentId, int start,
		int end, OrderByComparator<Bike> orderByComparator) {
		return getPersistence()
				   .findByStudentId(studentId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the bikes where studentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BikeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param studentId the student ID
	* @param start the lower bound of the range of bikes
	* @param end the upper bound of the range of bikes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching bikes
	*/
	public static List<Bike> findByStudentId(long studentId, int start,
		int end, OrderByComparator<Bike> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByStudentId(studentId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first bike in the ordered set where studentId = &#63;.
	*
	* @param studentId the student ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bike
	* @throws NoSuchBikeException if a matching bike could not be found
	*/
	public static Bike findByStudentId_First(long studentId,
		OrderByComparator<Bike> orderByComparator)
		throws kwan.org.database.exception.NoSuchBikeException {
		return getPersistence()
				   .findByStudentId_First(studentId, orderByComparator);
	}

	/**
	* Returns the first bike in the ordered set where studentId = &#63;.
	*
	* @param studentId the student ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bike, or <code>null</code> if a matching bike could not be found
	*/
	public static Bike fetchByStudentId_First(long studentId,
		OrderByComparator<Bike> orderByComparator) {
		return getPersistence()
				   .fetchByStudentId_First(studentId, orderByComparator);
	}

	/**
	* Returns the last bike in the ordered set where studentId = &#63;.
	*
	* @param studentId the student ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bike
	* @throws NoSuchBikeException if a matching bike could not be found
	*/
	public static Bike findByStudentId_Last(long studentId,
		OrderByComparator<Bike> orderByComparator)
		throws kwan.org.database.exception.NoSuchBikeException {
		return getPersistence()
				   .findByStudentId_Last(studentId, orderByComparator);
	}

	/**
	* Returns the last bike in the ordered set where studentId = &#63;.
	*
	* @param studentId the student ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bike, or <code>null</code> if a matching bike could not be found
	*/
	public static Bike fetchByStudentId_Last(long studentId,
		OrderByComparator<Bike> orderByComparator) {
		return getPersistence()
				   .fetchByStudentId_Last(studentId, orderByComparator);
	}

	/**
	* Returns the bikes before and after the current bike in the ordered set where studentId = &#63;.
	*
	* @param bikeId the primary key of the current bike
	* @param studentId the student ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next bike
	* @throws NoSuchBikeException if a bike with the primary key could not be found
	*/
	public static Bike[] findByStudentId_PrevAndNext(long bikeId,
		long studentId, OrderByComparator<Bike> orderByComparator)
		throws kwan.org.database.exception.NoSuchBikeException {
		return getPersistence()
				   .findByStudentId_PrevAndNext(bikeId, studentId,
			orderByComparator);
	}

	/**
	* Removes all the bikes where studentId = &#63; from the database.
	*
	* @param studentId the student ID
	*/
	public static void removeByStudentId(long studentId) {
		getPersistence().removeByStudentId(studentId);
	}

	/**
	* Returns the number of bikes where studentId = &#63;.
	*
	* @param studentId the student ID
	* @return the number of matching bikes
	*/
	public static int countByStudentId(long studentId) {
		return getPersistence().countByStudentId(studentId);
	}

	/**
	* Returns all the bikes where groupId = &#63; and studentId = &#63;.
	*
	* @param groupId the group ID
	* @param studentId the student ID
	* @return the matching bikes
	*/
	public static List<Bike> findByG_S(long groupId, long studentId) {
		return getPersistence().findByG_S(groupId, studentId);
	}

	/**
	* Returns a range of all the bikes where groupId = &#63; and studentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BikeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param studentId the student ID
	* @param start the lower bound of the range of bikes
	* @param end the upper bound of the range of bikes (not inclusive)
	* @return the range of matching bikes
	*/
	public static List<Bike> findByG_S(long groupId, long studentId, int start,
		int end) {
		return getPersistence().findByG_S(groupId, studentId, start, end);
	}

	/**
	* Returns an ordered range of all the bikes where groupId = &#63; and studentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BikeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param studentId the student ID
	* @param start the lower bound of the range of bikes
	* @param end the upper bound of the range of bikes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching bikes
	*/
	public static List<Bike> findByG_S(long groupId, long studentId, int start,
		int end, OrderByComparator<Bike> orderByComparator) {
		return getPersistence()
				   .findByG_S(groupId, studentId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the bikes where groupId = &#63; and studentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BikeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param studentId the student ID
	* @param start the lower bound of the range of bikes
	* @param end the upper bound of the range of bikes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching bikes
	*/
	public static List<Bike> findByG_S(long groupId, long studentId, int start,
		int end, OrderByComparator<Bike> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByG_S(groupId, studentId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first bike in the ordered set where groupId = &#63; and studentId = &#63;.
	*
	* @param groupId the group ID
	* @param studentId the student ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bike
	* @throws NoSuchBikeException if a matching bike could not be found
	*/
	public static Bike findByG_S_First(long groupId, long studentId,
		OrderByComparator<Bike> orderByComparator)
		throws kwan.org.database.exception.NoSuchBikeException {
		return getPersistence()
				   .findByG_S_First(groupId, studentId, orderByComparator);
	}

	/**
	* Returns the first bike in the ordered set where groupId = &#63; and studentId = &#63;.
	*
	* @param groupId the group ID
	* @param studentId the student ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bike, or <code>null</code> if a matching bike could not be found
	*/
	public static Bike fetchByG_S_First(long groupId, long studentId,
		OrderByComparator<Bike> orderByComparator) {
		return getPersistence()
				   .fetchByG_S_First(groupId, studentId, orderByComparator);
	}

	/**
	* Returns the last bike in the ordered set where groupId = &#63; and studentId = &#63;.
	*
	* @param groupId the group ID
	* @param studentId the student ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bike
	* @throws NoSuchBikeException if a matching bike could not be found
	*/
	public static Bike findByG_S_Last(long groupId, long studentId,
		OrderByComparator<Bike> orderByComparator)
		throws kwan.org.database.exception.NoSuchBikeException {
		return getPersistence()
				   .findByG_S_Last(groupId, studentId, orderByComparator);
	}

	/**
	* Returns the last bike in the ordered set where groupId = &#63; and studentId = &#63;.
	*
	* @param groupId the group ID
	* @param studentId the student ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bike, or <code>null</code> if a matching bike could not be found
	*/
	public static Bike fetchByG_S_Last(long groupId, long studentId,
		OrderByComparator<Bike> orderByComparator) {
		return getPersistence()
				   .fetchByG_S_Last(groupId, studentId, orderByComparator);
	}

	/**
	* Returns the bikes before and after the current bike in the ordered set where groupId = &#63; and studentId = &#63;.
	*
	* @param bikeId the primary key of the current bike
	* @param groupId the group ID
	* @param studentId the student ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next bike
	* @throws NoSuchBikeException if a bike with the primary key could not be found
	*/
	public static Bike[] findByG_S_PrevAndNext(long bikeId, long groupId,
		long studentId, OrderByComparator<Bike> orderByComparator)
		throws kwan.org.database.exception.NoSuchBikeException {
		return getPersistence()
				   .findByG_S_PrevAndNext(bikeId, groupId, studentId,
			orderByComparator);
	}

	/**
	* Removes all the bikes where groupId = &#63; and studentId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param studentId the student ID
	*/
	public static void removeByG_S(long groupId, long studentId) {
		getPersistence().removeByG_S(groupId, studentId);
	}

	/**
	* Returns the number of bikes where groupId = &#63; and studentId = &#63;.
	*
	* @param groupId the group ID
	* @param studentId the student ID
	* @return the number of matching bikes
	*/
	public static int countByG_S(long groupId, long studentId) {
		return getPersistence().countByG_S(groupId, studentId);
	}

	/**
	* Caches the bike in the entity cache if it is enabled.
	*
	* @param bike the bike
	*/
	public static void cacheResult(Bike bike) {
		getPersistence().cacheResult(bike);
	}

	/**
	* Caches the bikes in the entity cache if it is enabled.
	*
	* @param bikes the bikes
	*/
	public static void cacheResult(List<Bike> bikes) {
		getPersistence().cacheResult(bikes);
	}

	/**
	* Creates a new bike with the primary key. Does not add the bike to the database.
	*
	* @param bikeId the primary key for the new bike
	* @return the new bike
	*/
	public static Bike create(long bikeId) {
		return getPersistence().create(bikeId);
	}

	/**
	* Removes the bike with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bikeId the primary key of the bike
	* @return the bike that was removed
	* @throws NoSuchBikeException if a bike with the primary key could not be found
	*/
	public static Bike remove(long bikeId)
		throws kwan.org.database.exception.NoSuchBikeException {
		return getPersistence().remove(bikeId);
	}

	public static Bike updateImpl(Bike bike) {
		return getPersistence().updateImpl(bike);
	}

	/**
	* Returns the bike with the primary key or throws a {@link NoSuchBikeException} if it could not be found.
	*
	* @param bikeId the primary key of the bike
	* @return the bike
	* @throws NoSuchBikeException if a bike with the primary key could not be found
	*/
	public static Bike findByPrimaryKey(long bikeId)
		throws kwan.org.database.exception.NoSuchBikeException {
		return getPersistence().findByPrimaryKey(bikeId);
	}

	/**
	* Returns the bike with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param bikeId the primary key of the bike
	* @return the bike, or <code>null</code> if a bike with the primary key could not be found
	*/
	public static Bike fetchByPrimaryKey(long bikeId) {
		return getPersistence().fetchByPrimaryKey(bikeId);
	}

	public static java.util.Map<java.io.Serializable, Bike> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the bikes.
	*
	* @return the bikes
	*/
	public static List<Bike> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the bikes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BikeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bikes
	* @param end the upper bound of the range of bikes (not inclusive)
	* @return the range of bikes
	*/
	public static List<Bike> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the bikes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BikeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bikes
	* @param end the upper bound of the range of bikes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of bikes
	*/
	public static List<Bike> findAll(int start, int end,
		OrderByComparator<Bike> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the bikes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BikeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bikes
	* @param end the upper bound of the range of bikes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of bikes
	*/
	public static List<Bike> findAll(int start, int end,
		OrderByComparator<Bike> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the bikes from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of bikes.
	*
	* @return the number of bikes
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static BikePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<BikePersistence, BikePersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(BikePersistence.class);

		ServiceTracker<BikePersistence, BikePersistence> serviceTracker = new ServiceTracker<BikePersistence, BikePersistence>(bundle.getBundleContext(),
				BikePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}