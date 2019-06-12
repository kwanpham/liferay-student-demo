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

import kwan.org.database.exception.NoSuchBikeException;
import kwan.org.database.model.Bike;

/**
 * The persistence interface for the bike service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see kwan.org.database.service.persistence.impl.BikePersistenceImpl
 * @see BikeUtil
 * @generated
 */
@ProviderType
public interface BikePersistence extends BasePersistence<Bike> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BikeUtil} to access the bike persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the bikes where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching bikes
	*/
	public java.util.List<Bike> findByUuid(String uuid);

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
	public java.util.List<Bike> findByUuid(String uuid, int start, int end);

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
	public java.util.List<Bike> findByUuid(String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Bike> orderByComparator);

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
	public java.util.List<Bike> findByUuid(String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Bike> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first bike in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bike
	* @throws NoSuchBikeException if a matching bike could not be found
	*/
	public Bike findByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Bike> orderByComparator)
		throws NoSuchBikeException;

	/**
	* Returns the first bike in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bike, or <code>null</code> if a matching bike could not be found
	*/
	public Bike fetchByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Bike> orderByComparator);

	/**
	* Returns the last bike in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bike
	* @throws NoSuchBikeException if a matching bike could not be found
	*/
	public Bike findByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Bike> orderByComparator)
		throws NoSuchBikeException;

	/**
	* Returns the last bike in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bike, or <code>null</code> if a matching bike could not be found
	*/
	public Bike fetchByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Bike> orderByComparator);

	/**
	* Returns the bikes before and after the current bike in the ordered set where uuid = &#63;.
	*
	* @param bikeId the primary key of the current bike
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next bike
	* @throws NoSuchBikeException if a bike with the primary key could not be found
	*/
	public Bike[] findByUuid_PrevAndNext(long bikeId, String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Bike> orderByComparator)
		throws NoSuchBikeException;

	/**
	* Removes all the bikes where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(String uuid);

	/**
	* Returns the number of bikes where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching bikes
	*/
	public int countByUuid(String uuid);

	/**
	* Returns the bike where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchBikeException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching bike
	* @throws NoSuchBikeException if a matching bike could not be found
	*/
	public Bike findByUUID_G(String uuid, long groupId)
		throws NoSuchBikeException;

	/**
	* Returns the bike where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching bike, or <code>null</code> if a matching bike could not be found
	*/
	public Bike fetchByUUID_G(String uuid, long groupId);

	/**
	* Returns the bike where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching bike, or <code>null</code> if a matching bike could not be found
	*/
	public Bike fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache);

	/**
	* Removes the bike where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the bike that was removed
	*/
	public Bike removeByUUID_G(String uuid, long groupId)
		throws NoSuchBikeException;

	/**
	* Returns the number of bikes where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching bikes
	*/
	public int countByUUID_G(String uuid, long groupId);

	/**
	* Returns all the bikes where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching bikes
	*/
	public java.util.List<Bike> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<Bike> findByUuid_C(String uuid, long companyId,
		int start, int end);

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
	public java.util.List<Bike> findByUuid_C(String uuid, long companyId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Bike> orderByComparator);

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
	public java.util.List<Bike> findByUuid_C(String uuid, long companyId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Bike> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first bike in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bike
	* @throws NoSuchBikeException if a matching bike could not be found
	*/
	public Bike findByUuid_C_First(String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Bike> orderByComparator)
		throws NoSuchBikeException;

	/**
	* Returns the first bike in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bike, or <code>null</code> if a matching bike could not be found
	*/
	public Bike fetchByUuid_C_First(String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Bike> orderByComparator);

	/**
	* Returns the last bike in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bike
	* @throws NoSuchBikeException if a matching bike could not be found
	*/
	public Bike findByUuid_C_Last(String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Bike> orderByComparator)
		throws NoSuchBikeException;

	/**
	* Returns the last bike in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bike, or <code>null</code> if a matching bike could not be found
	*/
	public Bike fetchByUuid_C_Last(String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Bike> orderByComparator);

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
	public Bike[] findByUuid_C_PrevAndNext(long bikeId, String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Bike> orderByComparator)
		throws NoSuchBikeException;

	/**
	* Removes all the bikes where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(String uuid, long companyId);

	/**
	* Returns the number of bikes where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching bikes
	*/
	public int countByUuid_C(String uuid, long companyId);

	/**
	* Returns all the bikes where brand = &#63;.
	*
	* @param brand the brand
	* @return the matching bikes
	*/
	public java.util.List<Bike> findByBrand(String brand);

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
	public java.util.List<Bike> findByBrand(String brand, int start, int end);

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
	public java.util.List<Bike> findByBrand(String brand, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Bike> orderByComparator);

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
	public java.util.List<Bike> findByBrand(String brand, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Bike> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first bike in the ordered set where brand = &#63;.
	*
	* @param brand the brand
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bike
	* @throws NoSuchBikeException if a matching bike could not be found
	*/
	public Bike findByBrand_First(String brand,
		com.liferay.portal.kernel.util.OrderByComparator<Bike> orderByComparator)
		throws NoSuchBikeException;

	/**
	* Returns the first bike in the ordered set where brand = &#63;.
	*
	* @param brand the brand
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bike, or <code>null</code> if a matching bike could not be found
	*/
	public Bike fetchByBrand_First(String brand,
		com.liferay.portal.kernel.util.OrderByComparator<Bike> orderByComparator);

	/**
	* Returns the last bike in the ordered set where brand = &#63;.
	*
	* @param brand the brand
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bike
	* @throws NoSuchBikeException if a matching bike could not be found
	*/
	public Bike findByBrand_Last(String brand,
		com.liferay.portal.kernel.util.OrderByComparator<Bike> orderByComparator)
		throws NoSuchBikeException;

	/**
	* Returns the last bike in the ordered set where brand = &#63;.
	*
	* @param brand the brand
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bike, or <code>null</code> if a matching bike could not be found
	*/
	public Bike fetchByBrand_Last(String brand,
		com.liferay.portal.kernel.util.OrderByComparator<Bike> orderByComparator);

	/**
	* Returns the bikes before and after the current bike in the ordered set where brand = &#63;.
	*
	* @param bikeId the primary key of the current bike
	* @param brand the brand
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next bike
	* @throws NoSuchBikeException if a bike with the primary key could not be found
	*/
	public Bike[] findByBrand_PrevAndNext(long bikeId, String brand,
		com.liferay.portal.kernel.util.OrderByComparator<Bike> orderByComparator)
		throws NoSuchBikeException;

	/**
	* Removes all the bikes where brand = &#63; from the database.
	*
	* @param brand the brand
	*/
	public void removeByBrand(String brand);

	/**
	* Returns the number of bikes where brand = &#63;.
	*
	* @param brand the brand
	* @return the number of matching bikes
	*/
	public int countByBrand(String brand);

	/**
	* Returns all the bikes where studentId = &#63;.
	*
	* @param studentId the student ID
	* @return the matching bikes
	*/
	public java.util.List<Bike> findByStudentId(long studentId);

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
	public java.util.List<Bike> findByStudentId(long studentId, int start,
		int end);

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
	public java.util.List<Bike> findByStudentId(long studentId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Bike> orderByComparator);

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
	public java.util.List<Bike> findByStudentId(long studentId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Bike> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first bike in the ordered set where studentId = &#63;.
	*
	* @param studentId the student ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bike
	* @throws NoSuchBikeException if a matching bike could not be found
	*/
	public Bike findByStudentId_First(long studentId,
		com.liferay.portal.kernel.util.OrderByComparator<Bike> orderByComparator)
		throws NoSuchBikeException;

	/**
	* Returns the first bike in the ordered set where studentId = &#63;.
	*
	* @param studentId the student ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bike, or <code>null</code> if a matching bike could not be found
	*/
	public Bike fetchByStudentId_First(long studentId,
		com.liferay.portal.kernel.util.OrderByComparator<Bike> orderByComparator);

	/**
	* Returns the last bike in the ordered set where studentId = &#63;.
	*
	* @param studentId the student ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bike
	* @throws NoSuchBikeException if a matching bike could not be found
	*/
	public Bike findByStudentId_Last(long studentId,
		com.liferay.portal.kernel.util.OrderByComparator<Bike> orderByComparator)
		throws NoSuchBikeException;

	/**
	* Returns the last bike in the ordered set where studentId = &#63;.
	*
	* @param studentId the student ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bike, or <code>null</code> if a matching bike could not be found
	*/
	public Bike fetchByStudentId_Last(long studentId,
		com.liferay.portal.kernel.util.OrderByComparator<Bike> orderByComparator);

	/**
	* Returns the bikes before and after the current bike in the ordered set where studentId = &#63;.
	*
	* @param bikeId the primary key of the current bike
	* @param studentId the student ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next bike
	* @throws NoSuchBikeException if a bike with the primary key could not be found
	*/
	public Bike[] findByStudentId_PrevAndNext(long bikeId, long studentId,
		com.liferay.portal.kernel.util.OrderByComparator<Bike> orderByComparator)
		throws NoSuchBikeException;

	/**
	* Removes all the bikes where studentId = &#63; from the database.
	*
	* @param studentId the student ID
	*/
	public void removeByStudentId(long studentId);

	/**
	* Returns the number of bikes where studentId = &#63;.
	*
	* @param studentId the student ID
	* @return the number of matching bikes
	*/
	public int countByStudentId(long studentId);

	/**
	* Returns all the bikes where groupId = &#63; and studentId = &#63;.
	*
	* @param groupId the group ID
	* @param studentId the student ID
	* @return the matching bikes
	*/
	public java.util.List<Bike> findByG_S(long groupId, long studentId);

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
	public java.util.List<Bike> findByG_S(long groupId, long studentId,
		int start, int end);

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
	public java.util.List<Bike> findByG_S(long groupId, long studentId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Bike> orderByComparator);

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
	public java.util.List<Bike> findByG_S(long groupId, long studentId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Bike> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first bike in the ordered set where groupId = &#63; and studentId = &#63;.
	*
	* @param groupId the group ID
	* @param studentId the student ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bike
	* @throws NoSuchBikeException if a matching bike could not be found
	*/
	public Bike findByG_S_First(long groupId, long studentId,
		com.liferay.portal.kernel.util.OrderByComparator<Bike> orderByComparator)
		throws NoSuchBikeException;

	/**
	* Returns the first bike in the ordered set where groupId = &#63; and studentId = &#63;.
	*
	* @param groupId the group ID
	* @param studentId the student ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bike, or <code>null</code> if a matching bike could not be found
	*/
	public Bike fetchByG_S_First(long groupId, long studentId,
		com.liferay.portal.kernel.util.OrderByComparator<Bike> orderByComparator);

	/**
	* Returns the last bike in the ordered set where groupId = &#63; and studentId = &#63;.
	*
	* @param groupId the group ID
	* @param studentId the student ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bike
	* @throws NoSuchBikeException if a matching bike could not be found
	*/
	public Bike findByG_S_Last(long groupId, long studentId,
		com.liferay.portal.kernel.util.OrderByComparator<Bike> orderByComparator)
		throws NoSuchBikeException;

	/**
	* Returns the last bike in the ordered set where groupId = &#63; and studentId = &#63;.
	*
	* @param groupId the group ID
	* @param studentId the student ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bike, or <code>null</code> if a matching bike could not be found
	*/
	public Bike fetchByG_S_Last(long groupId, long studentId,
		com.liferay.portal.kernel.util.OrderByComparator<Bike> orderByComparator);

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
	public Bike[] findByG_S_PrevAndNext(long bikeId, long groupId,
		long studentId,
		com.liferay.portal.kernel.util.OrderByComparator<Bike> orderByComparator)
		throws NoSuchBikeException;

	/**
	* Removes all the bikes where groupId = &#63; and studentId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param studentId the student ID
	*/
	public void removeByG_S(long groupId, long studentId);

	/**
	* Returns the number of bikes where groupId = &#63; and studentId = &#63;.
	*
	* @param groupId the group ID
	* @param studentId the student ID
	* @return the number of matching bikes
	*/
	public int countByG_S(long groupId, long studentId);

	/**
	* Caches the bike in the entity cache if it is enabled.
	*
	* @param bike the bike
	*/
	public void cacheResult(Bike bike);

	/**
	* Caches the bikes in the entity cache if it is enabled.
	*
	* @param bikes the bikes
	*/
	public void cacheResult(java.util.List<Bike> bikes);

	/**
	* Creates a new bike with the primary key. Does not add the bike to the database.
	*
	* @param bikeId the primary key for the new bike
	* @return the new bike
	*/
	public Bike create(long bikeId);

	/**
	* Removes the bike with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bikeId the primary key of the bike
	* @return the bike that was removed
	* @throws NoSuchBikeException if a bike with the primary key could not be found
	*/
	public Bike remove(long bikeId) throws NoSuchBikeException;

	public Bike updateImpl(Bike bike);

	/**
	* Returns the bike with the primary key or throws a {@link NoSuchBikeException} if it could not be found.
	*
	* @param bikeId the primary key of the bike
	* @return the bike
	* @throws NoSuchBikeException if a bike with the primary key could not be found
	*/
	public Bike findByPrimaryKey(long bikeId) throws NoSuchBikeException;

	/**
	* Returns the bike with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param bikeId the primary key of the bike
	* @return the bike, or <code>null</code> if a bike with the primary key could not be found
	*/
	public Bike fetchByPrimaryKey(long bikeId);

	@Override
	public java.util.Map<java.io.Serializable, Bike> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the bikes.
	*
	* @return the bikes
	*/
	public java.util.List<Bike> findAll();

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
	public java.util.List<Bike> findAll(int start, int end);

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
	public java.util.List<Bike> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Bike> orderByComparator);

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
	public java.util.List<Bike> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Bike> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the bikes from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of bikes.
	*
	* @return the number of bikes
	*/
	public int countAll();

	@Override
	public java.util.Set<String> getBadColumnNames();
}