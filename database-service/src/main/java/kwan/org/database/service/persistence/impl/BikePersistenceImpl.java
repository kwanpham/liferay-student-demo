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

package kwan.org.database.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import kwan.org.database.exception.NoSuchBikeException;
import kwan.org.database.model.Bike;
import kwan.org.database.model.impl.BikeImpl;
import kwan.org.database.model.impl.BikeModelImpl;
import kwan.org.database.service.persistence.BikePersistence;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the bike service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BikePersistence
 * @see kwan.org.database.service.persistence.BikeUtil
 * @generated
 */
@ProviderType
public class BikePersistenceImpl extends BasePersistenceImpl<Bike>
	implements BikePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BikeUtil} to access the bike persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BikeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BikeModelImpl.ENTITY_CACHE_ENABLED,
			BikeModelImpl.FINDER_CACHE_ENABLED, BikeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BikeModelImpl.ENTITY_CACHE_ENABLED,
			BikeModelImpl.FINDER_CACHE_ENABLED, BikeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BikeModelImpl.ENTITY_CACHE_ENABLED,
			BikeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(BikeModelImpl.ENTITY_CACHE_ENABLED,
			BikeModelImpl.FINDER_CACHE_ENABLED, BikeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(BikeModelImpl.ENTITY_CACHE_ENABLED,
			BikeModelImpl.FINDER_CACHE_ENABLED, BikeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			BikeModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(BikeModelImpl.ENTITY_CACHE_ENABLED,
			BikeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the bikes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching bikes
	 */
	@Override
	public List<Bike> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Bike> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<Bike> findByUuid(String uuid, int start, int end,
		OrderByComparator<Bike> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<Bike> findByUuid(String uuid, int start, int end,
		OrderByComparator<Bike> orderByComparator, boolean retrieveFromCache) {
		uuid = Objects.toString(uuid, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<Bike> list = null;

		if (retrieveFromCache) {
			list = (List<Bike>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Bike bike : list) {
					if (!uuid.equals(bike.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_BIKE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BikeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<Bike>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Bike>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first bike in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bike
	 * @throws NoSuchBikeException if a matching bike could not be found
	 */
	@Override
	public Bike findByUuid_First(String uuid,
		OrderByComparator<Bike> orderByComparator) throws NoSuchBikeException {
		Bike bike = fetchByUuid_First(uuid, orderByComparator);

		if (bike != null) {
			return bike;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchBikeException(msg.toString());
	}

	/**
	 * Returns the first bike in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bike, or <code>null</code> if a matching bike could not be found
	 */
	@Override
	public Bike fetchByUuid_First(String uuid,
		OrderByComparator<Bike> orderByComparator) {
		List<Bike> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bike in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bike
	 * @throws NoSuchBikeException if a matching bike could not be found
	 */
	@Override
	public Bike findByUuid_Last(String uuid,
		OrderByComparator<Bike> orderByComparator) throws NoSuchBikeException {
		Bike bike = fetchByUuid_Last(uuid, orderByComparator);

		if (bike != null) {
			return bike;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchBikeException(msg.toString());
	}

	/**
	 * Returns the last bike in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bike, or <code>null</code> if a matching bike could not be found
	 */
	@Override
	public Bike fetchByUuid_Last(String uuid,
		OrderByComparator<Bike> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Bike> list = findByUuid(uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Bike[] findByUuid_PrevAndNext(long bikeId, String uuid,
		OrderByComparator<Bike> orderByComparator) throws NoSuchBikeException {
		uuid = Objects.toString(uuid, "");

		Bike bike = findByPrimaryKey(bikeId);

		Session session = null;

		try {
			session = openSession();

			Bike[] array = new BikeImpl[3];

			array[0] = getByUuid_PrevAndNext(session, bike, uuid,
					orderByComparator, true);

			array[1] = bike;

			array[2] = getByUuid_PrevAndNext(session, bike, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Bike getByUuid_PrevAndNext(Session session, Bike bike,
		String uuid, OrderByComparator<Bike> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BIKE_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(BikeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(bike);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Bike> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bikes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Bike bike : findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(bike);
		}
	}

	/**
	 * Returns the number of bikes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching bikes
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BIKE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "bike.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "bike.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(bike.uuid IS NULL OR bike.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(BikeModelImpl.ENTITY_CACHE_ENABLED,
			BikeModelImpl.FINDER_CACHE_ENABLED, BikeImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			BikeModelImpl.UUID_COLUMN_BITMASK |
			BikeModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(BikeModelImpl.ENTITY_CACHE_ENABLED,
			BikeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the bike where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchBikeException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching bike
	 * @throws NoSuchBikeException if a matching bike could not be found
	 */
	@Override
	public Bike findByUUID_G(String uuid, long groupId)
		throws NoSuchBikeException {
		Bike bike = fetchByUUID_G(uuid, groupId);

		if (bike == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchBikeException(msg.toString());
		}

		return bike;
	}

	/**
	 * Returns the bike where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching bike, or <code>null</code> if a matching bike could not be found
	 */
	@Override
	public Bike fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the bike where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching bike, or <code>null</code> if a matching bike could not be found
	 */
	@Override
	public Bike fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof Bike) {
			Bike bike = (Bike)result;

			if (!Objects.equals(uuid, bike.getUuid()) ||
					(groupId != bike.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_BIKE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<Bike> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					Bike bike = list.get(0);

					result = bike;

					cacheResult(bike);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Bike)result;
		}
	}

	/**
	 * Removes the bike where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the bike that was removed
	 */
	@Override
	public Bike removeByUUID_G(String uuid, long groupId)
		throws NoSuchBikeException {
		Bike bike = findByUUID_G(uuid, groupId);

		return remove(bike);
	}

	/**
	 * Returns the number of bikes where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching bikes
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_BIKE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "bike.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "bike.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(bike.uuid IS NULL OR bike.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "bike.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(BikeModelImpl.ENTITY_CACHE_ENABLED,
			BikeModelImpl.FINDER_CACHE_ENABLED, BikeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(BikeModelImpl.ENTITY_CACHE_ENABLED,
			BikeModelImpl.FINDER_CACHE_ENABLED, BikeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			BikeModelImpl.UUID_COLUMN_BITMASK |
			BikeModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(BikeModelImpl.ENTITY_CACHE_ENABLED,
			BikeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the bikes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching bikes
	 */
	@Override
	public List<Bike> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Bike> findByUuid_C(String uuid, long companyId, int start,
		int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<Bike> findByUuid_C(String uuid, long companyId, int start,
		int end, OrderByComparator<Bike> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<Bike> findByUuid_C(String uuid, long companyId, int start,
		int end, OrderByComparator<Bike> orderByComparator,
		boolean retrieveFromCache) {
		uuid = Objects.toString(uuid, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] { uuid, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] {
					uuid, companyId,
					
					start, end, orderByComparator
				};
		}

		List<Bike> list = null;

		if (retrieveFromCache) {
			list = (List<Bike>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Bike bike : list) {
					if (!uuid.equals(bike.getUuid()) ||
							(companyId != bike.getCompanyId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_BIKE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BikeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				if (!pagination) {
					list = (List<Bike>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Bike>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Bike findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<Bike> orderByComparator) throws NoSuchBikeException {
		Bike bike = fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (bike != null) {
			return bike;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchBikeException(msg.toString());
	}

	/**
	 * Returns the first bike in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bike, or <code>null</code> if a matching bike could not be found
	 */
	@Override
	public Bike fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<Bike> orderByComparator) {
		List<Bike> list = findByUuid_C(uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Bike findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<Bike> orderByComparator) throws NoSuchBikeException {
		Bike bike = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (bike != null) {
			return bike;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchBikeException(msg.toString());
	}

	/**
	 * Returns the last bike in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bike, or <code>null</code> if a matching bike could not be found
	 */
	@Override
	public Bike fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<Bike> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Bike> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Bike[] findByUuid_C_PrevAndNext(long bikeId, String uuid,
		long companyId, OrderByComparator<Bike> orderByComparator)
		throws NoSuchBikeException {
		uuid = Objects.toString(uuid, "");

		Bike bike = findByPrimaryKey(bikeId);

		Session session = null;

		try {
			session = openSession();

			Bike[] array = new BikeImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, bike, uuid, companyId,
					orderByComparator, true);

			array[1] = bike;

			array[2] = getByUuid_C_PrevAndNext(session, bike, uuid, companyId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Bike getByUuid_C_PrevAndNext(Session session, Bike bike,
		String uuid, long companyId, OrderByComparator<Bike> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_BIKE_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(BikeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(bike);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Bike> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bikes where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Bike bike : findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(bike);
		}
	}

	/**
	 * Returns the number of bikes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching bikes
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_BIKE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "bike.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "bike.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(bike.uuid IS NULL OR bike.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "bike.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BRAND = new FinderPath(BikeModelImpl.ENTITY_CACHE_ENABLED,
			BikeModelImpl.FINDER_CACHE_ENABLED, BikeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByBrand",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BRAND = new FinderPath(BikeModelImpl.ENTITY_CACHE_ENABLED,
			BikeModelImpl.FINDER_CACHE_ENABLED, BikeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByBrand",
			new String[] { String.class.getName() },
			BikeModelImpl.BRAND_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BRAND = new FinderPath(BikeModelImpl.ENTITY_CACHE_ENABLED,
			BikeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByBrand",
			new String[] { String.class.getName() });

	/**
	 * Returns all the bikes where brand = &#63;.
	 *
	 * @param brand the brand
	 * @return the matching bikes
	 */
	@Override
	public List<Bike> findByBrand(String brand) {
		return findByBrand(brand, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Bike> findByBrand(String brand, int start, int end) {
		return findByBrand(brand, start, end, null);
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
	@Override
	public List<Bike> findByBrand(String brand, int start, int end,
		OrderByComparator<Bike> orderByComparator) {
		return findByBrand(brand, start, end, orderByComparator, true);
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
	@Override
	public List<Bike> findByBrand(String brand, int start, int end,
		OrderByComparator<Bike> orderByComparator, boolean retrieveFromCache) {
		brand = Objects.toString(brand, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BRAND;
			finderArgs = new Object[] { brand };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BRAND;
			finderArgs = new Object[] { brand, start, end, orderByComparator };
		}

		List<Bike> list = null;

		if (retrieveFromCache) {
			list = (List<Bike>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Bike bike : list) {
					if (!brand.equals(bike.getBrand())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_BIKE_WHERE);

			boolean bindBrand = false;

			if (brand.isEmpty()) {
				query.append(_FINDER_COLUMN_BRAND_BRAND_3);
			}
			else {
				bindBrand = true;

				query.append(_FINDER_COLUMN_BRAND_BRAND_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BikeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindBrand) {
					qPos.add(brand);
				}

				if (!pagination) {
					list = (List<Bike>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Bike>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first bike in the ordered set where brand = &#63;.
	 *
	 * @param brand the brand
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bike
	 * @throws NoSuchBikeException if a matching bike could not be found
	 */
	@Override
	public Bike findByBrand_First(String brand,
		OrderByComparator<Bike> orderByComparator) throws NoSuchBikeException {
		Bike bike = fetchByBrand_First(brand, orderByComparator);

		if (bike != null) {
			return bike;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("brand=");
		msg.append(brand);

		msg.append("}");

		throw new NoSuchBikeException(msg.toString());
	}

	/**
	 * Returns the first bike in the ordered set where brand = &#63;.
	 *
	 * @param brand the brand
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bike, or <code>null</code> if a matching bike could not be found
	 */
	@Override
	public Bike fetchByBrand_First(String brand,
		OrderByComparator<Bike> orderByComparator) {
		List<Bike> list = findByBrand(brand, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bike in the ordered set where brand = &#63;.
	 *
	 * @param brand the brand
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bike
	 * @throws NoSuchBikeException if a matching bike could not be found
	 */
	@Override
	public Bike findByBrand_Last(String brand,
		OrderByComparator<Bike> orderByComparator) throws NoSuchBikeException {
		Bike bike = fetchByBrand_Last(brand, orderByComparator);

		if (bike != null) {
			return bike;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("brand=");
		msg.append(brand);

		msg.append("}");

		throw new NoSuchBikeException(msg.toString());
	}

	/**
	 * Returns the last bike in the ordered set where brand = &#63;.
	 *
	 * @param brand the brand
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bike, or <code>null</code> if a matching bike could not be found
	 */
	@Override
	public Bike fetchByBrand_Last(String brand,
		OrderByComparator<Bike> orderByComparator) {
		int count = countByBrand(brand);

		if (count == 0) {
			return null;
		}

		List<Bike> list = findByBrand(brand, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Bike[] findByBrand_PrevAndNext(long bikeId, String brand,
		OrderByComparator<Bike> orderByComparator) throws NoSuchBikeException {
		brand = Objects.toString(brand, "");

		Bike bike = findByPrimaryKey(bikeId);

		Session session = null;

		try {
			session = openSession();

			Bike[] array = new BikeImpl[3];

			array[0] = getByBrand_PrevAndNext(session, bike, brand,
					orderByComparator, true);

			array[1] = bike;

			array[2] = getByBrand_PrevAndNext(session, bike, brand,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Bike getByBrand_PrevAndNext(Session session, Bike bike,
		String brand, OrderByComparator<Bike> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BIKE_WHERE);

		boolean bindBrand = false;

		if (brand.isEmpty()) {
			query.append(_FINDER_COLUMN_BRAND_BRAND_3);
		}
		else {
			bindBrand = true;

			query.append(_FINDER_COLUMN_BRAND_BRAND_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(BikeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindBrand) {
			qPos.add(brand);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(bike);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Bike> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bikes where brand = &#63; from the database.
	 *
	 * @param brand the brand
	 */
	@Override
	public void removeByBrand(String brand) {
		for (Bike bike : findByBrand(brand, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(bike);
		}
	}

	/**
	 * Returns the number of bikes where brand = &#63;.
	 *
	 * @param brand the brand
	 * @return the number of matching bikes
	 */
	@Override
	public int countByBrand(String brand) {
		brand = Objects.toString(brand, "");

		FinderPath finderPath = FINDER_PATH_COUNT_BY_BRAND;

		Object[] finderArgs = new Object[] { brand };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BIKE_WHERE);

			boolean bindBrand = false;

			if (brand.isEmpty()) {
				query.append(_FINDER_COLUMN_BRAND_BRAND_3);
			}
			else {
				bindBrand = true;

				query.append(_FINDER_COLUMN_BRAND_BRAND_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindBrand) {
					qPos.add(brand);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_BRAND_BRAND_1 = "bike.brand IS NULL";
	private static final String _FINDER_COLUMN_BRAND_BRAND_2 = "bike.brand = ?";
	private static final String _FINDER_COLUMN_BRAND_BRAND_3 = "(bike.brand IS NULL OR bike.brand = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STUDENTID =
		new FinderPath(BikeModelImpl.ENTITY_CACHE_ENABLED,
			BikeModelImpl.FINDER_CACHE_ENABLED, BikeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStudentId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STUDENTID =
		new FinderPath(BikeModelImpl.ENTITY_CACHE_ENABLED,
			BikeModelImpl.FINDER_CACHE_ENABLED, BikeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStudentId",
			new String[] { Long.class.getName() },
			BikeModelImpl.STUDENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STUDENTID = new FinderPath(BikeModelImpl.ENTITY_CACHE_ENABLED,
			BikeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStudentId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the bikes where studentId = &#63;.
	 *
	 * @param studentId the student ID
	 * @return the matching bikes
	 */
	@Override
	public List<Bike> findByStudentId(long studentId) {
		return findByStudentId(studentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Bike> findByStudentId(long studentId, int start, int end) {
		return findByStudentId(studentId, start, end, null);
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
	@Override
	public List<Bike> findByStudentId(long studentId, int start, int end,
		OrderByComparator<Bike> orderByComparator) {
		return findByStudentId(studentId, start, end, orderByComparator, true);
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
	@Override
	public List<Bike> findByStudentId(long studentId, int start, int end,
		OrderByComparator<Bike> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STUDENTID;
			finderArgs = new Object[] { studentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STUDENTID;
			finderArgs = new Object[] { studentId, start, end, orderByComparator };
		}

		List<Bike> list = null;

		if (retrieveFromCache) {
			list = (List<Bike>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Bike bike : list) {
					if ((studentId != bike.getStudentId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_BIKE_WHERE);

			query.append(_FINDER_COLUMN_STUDENTID_STUDENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BikeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(studentId);

				if (!pagination) {
					list = (List<Bike>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Bike>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first bike in the ordered set where studentId = &#63;.
	 *
	 * @param studentId the student ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bike
	 * @throws NoSuchBikeException if a matching bike could not be found
	 */
	@Override
	public Bike findByStudentId_First(long studentId,
		OrderByComparator<Bike> orderByComparator) throws NoSuchBikeException {
		Bike bike = fetchByStudentId_First(studentId, orderByComparator);

		if (bike != null) {
			return bike;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("studentId=");
		msg.append(studentId);

		msg.append("}");

		throw new NoSuchBikeException(msg.toString());
	}

	/**
	 * Returns the first bike in the ordered set where studentId = &#63;.
	 *
	 * @param studentId the student ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bike, or <code>null</code> if a matching bike could not be found
	 */
	@Override
	public Bike fetchByStudentId_First(long studentId,
		OrderByComparator<Bike> orderByComparator) {
		List<Bike> list = findByStudentId(studentId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bike in the ordered set where studentId = &#63;.
	 *
	 * @param studentId the student ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bike
	 * @throws NoSuchBikeException if a matching bike could not be found
	 */
	@Override
	public Bike findByStudentId_Last(long studentId,
		OrderByComparator<Bike> orderByComparator) throws NoSuchBikeException {
		Bike bike = fetchByStudentId_Last(studentId, orderByComparator);

		if (bike != null) {
			return bike;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("studentId=");
		msg.append(studentId);

		msg.append("}");

		throw new NoSuchBikeException(msg.toString());
	}

	/**
	 * Returns the last bike in the ordered set where studentId = &#63;.
	 *
	 * @param studentId the student ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bike, or <code>null</code> if a matching bike could not be found
	 */
	@Override
	public Bike fetchByStudentId_Last(long studentId,
		OrderByComparator<Bike> orderByComparator) {
		int count = countByStudentId(studentId);

		if (count == 0) {
			return null;
		}

		List<Bike> list = findByStudentId(studentId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Bike[] findByStudentId_PrevAndNext(long bikeId, long studentId,
		OrderByComparator<Bike> orderByComparator) throws NoSuchBikeException {
		Bike bike = findByPrimaryKey(bikeId);

		Session session = null;

		try {
			session = openSession();

			Bike[] array = new BikeImpl[3];

			array[0] = getByStudentId_PrevAndNext(session, bike, studentId,
					orderByComparator, true);

			array[1] = bike;

			array[2] = getByStudentId_PrevAndNext(session, bike, studentId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Bike getByStudentId_PrevAndNext(Session session, Bike bike,
		long studentId, OrderByComparator<Bike> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BIKE_WHERE);

		query.append(_FINDER_COLUMN_STUDENTID_STUDENTID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(BikeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(studentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(bike);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Bike> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bikes where studentId = &#63; from the database.
	 *
	 * @param studentId the student ID
	 */
	@Override
	public void removeByStudentId(long studentId) {
		for (Bike bike : findByStudentId(studentId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(bike);
		}
	}

	/**
	 * Returns the number of bikes where studentId = &#63;.
	 *
	 * @param studentId the student ID
	 * @return the number of matching bikes
	 */
	@Override
	public int countByStudentId(long studentId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STUDENTID;

		Object[] finderArgs = new Object[] { studentId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BIKE_WHERE);

			query.append(_FINDER_COLUMN_STUDENTID_STUDENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(studentId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_STUDENTID_STUDENTID_2 = "bike.studentId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_S = new FinderPath(BikeModelImpl.ENTITY_CACHE_ENABLED,
			BikeModelImpl.FINDER_CACHE_ENABLED, BikeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S = new FinderPath(BikeModelImpl.ENTITY_CACHE_ENABLED,
			BikeModelImpl.FINDER_CACHE_ENABLED, BikeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_S",
			new String[] { Long.class.getName(), Long.class.getName() },
			BikeModelImpl.GROUPID_COLUMN_BITMASK |
			BikeModelImpl.STUDENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_S = new FinderPath(BikeModelImpl.ENTITY_CACHE_ENABLED,
			BikeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_S",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the bikes where groupId = &#63; and studentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param studentId the student ID
	 * @return the matching bikes
	 */
	@Override
	public List<Bike> findByG_S(long groupId, long studentId) {
		return findByG_S(groupId, studentId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Bike> findByG_S(long groupId, long studentId, int start, int end) {
		return findByG_S(groupId, studentId, start, end, null);
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
	@Override
	public List<Bike> findByG_S(long groupId, long studentId, int start,
		int end, OrderByComparator<Bike> orderByComparator) {
		return findByG_S(groupId, studentId, start, end, orderByComparator, true);
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
	@Override
	public List<Bike> findByG_S(long groupId, long studentId, int start,
		int end, OrderByComparator<Bike> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S;
			finderArgs = new Object[] { groupId, studentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_S;
			finderArgs = new Object[] {
					groupId, studentId,
					
					start, end, orderByComparator
				};
		}

		List<Bike> list = null;

		if (retrieveFromCache) {
			list = (List<Bike>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Bike bike : list) {
					if ((groupId != bike.getGroupId()) ||
							(studentId != bike.getStudentId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_BIKE_WHERE);

			query.append(_FINDER_COLUMN_G_S_GROUPID_2);

			query.append(_FINDER_COLUMN_G_S_STUDENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BikeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(studentId);

				if (!pagination) {
					list = (List<Bike>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Bike>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Bike findByG_S_First(long groupId, long studentId,
		OrderByComparator<Bike> orderByComparator) throws NoSuchBikeException {
		Bike bike = fetchByG_S_First(groupId, studentId, orderByComparator);

		if (bike != null) {
			return bike;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", studentId=");
		msg.append(studentId);

		msg.append("}");

		throw new NoSuchBikeException(msg.toString());
	}

	/**
	 * Returns the first bike in the ordered set where groupId = &#63; and studentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param studentId the student ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bike, or <code>null</code> if a matching bike could not be found
	 */
	@Override
	public Bike fetchByG_S_First(long groupId, long studentId,
		OrderByComparator<Bike> orderByComparator) {
		List<Bike> list = findByG_S(groupId, studentId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Bike findByG_S_Last(long groupId, long studentId,
		OrderByComparator<Bike> orderByComparator) throws NoSuchBikeException {
		Bike bike = fetchByG_S_Last(groupId, studentId, orderByComparator);

		if (bike != null) {
			return bike;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", studentId=");
		msg.append(studentId);

		msg.append("}");

		throw new NoSuchBikeException(msg.toString());
	}

	/**
	 * Returns the last bike in the ordered set where groupId = &#63; and studentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param studentId the student ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bike, or <code>null</code> if a matching bike could not be found
	 */
	@Override
	public Bike fetchByG_S_Last(long groupId, long studentId,
		OrderByComparator<Bike> orderByComparator) {
		int count = countByG_S(groupId, studentId);

		if (count == 0) {
			return null;
		}

		List<Bike> list = findByG_S(groupId, studentId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Bike[] findByG_S_PrevAndNext(long bikeId, long groupId,
		long studentId, OrderByComparator<Bike> orderByComparator)
		throws NoSuchBikeException {
		Bike bike = findByPrimaryKey(bikeId);

		Session session = null;

		try {
			session = openSession();

			Bike[] array = new BikeImpl[3];

			array[0] = getByG_S_PrevAndNext(session, bike, groupId, studentId,
					orderByComparator, true);

			array[1] = bike;

			array[2] = getByG_S_PrevAndNext(session, bike, groupId, studentId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Bike getByG_S_PrevAndNext(Session session, Bike bike,
		long groupId, long studentId,
		OrderByComparator<Bike> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_BIKE_WHERE);

		query.append(_FINDER_COLUMN_G_S_GROUPID_2);

		query.append(_FINDER_COLUMN_G_S_STUDENTID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(BikeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(studentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(bike);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Bike> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bikes where groupId = &#63; and studentId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param studentId the student ID
	 */
	@Override
	public void removeByG_S(long groupId, long studentId) {
		for (Bike bike : findByG_S(groupId, studentId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(bike);
		}
	}

	/**
	 * Returns the number of bikes where groupId = &#63; and studentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param studentId the student ID
	 * @return the number of matching bikes
	 */
	@Override
	public int countByG_S(long groupId, long studentId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_S;

		Object[] finderArgs = new Object[] { groupId, studentId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_BIKE_WHERE);

			query.append(_FINDER_COLUMN_G_S_GROUPID_2);

			query.append(_FINDER_COLUMN_G_S_STUDENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(studentId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_G_S_GROUPID_2 = "bike.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_S_STUDENTID_2 = "bike.studentId = ?";

	public BikePersistenceImpl() {
		setModelClass(Bike.class);

		try {
			Field field = BasePersistenceImpl.class.getDeclaredField(
					"_dbColumnNames");

			field.setAccessible(true);

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("uuid", "uuid_");

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the bike in the entity cache if it is enabled.
	 *
	 * @param bike the bike
	 */
	@Override
	public void cacheResult(Bike bike) {
		entityCache.putResult(BikeModelImpl.ENTITY_CACHE_ENABLED,
			BikeImpl.class, bike.getPrimaryKey(), bike);

		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { bike.getUuid(), bike.getGroupId() }, bike);

		bike.resetOriginalValues();
	}

	/**
	 * Caches the bikes in the entity cache if it is enabled.
	 *
	 * @param bikes the bikes
	 */
	@Override
	public void cacheResult(List<Bike> bikes) {
		for (Bike bike : bikes) {
			if (entityCache.getResult(BikeModelImpl.ENTITY_CACHE_ENABLED,
						BikeImpl.class, bike.getPrimaryKey()) == null) {
				cacheResult(bike);
			}
			else {
				bike.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all bikes.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(BikeImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the bike.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Bike bike) {
		entityCache.removeResult(BikeModelImpl.ENTITY_CACHE_ENABLED,
			BikeImpl.class, bike.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((BikeModelImpl)bike, true);
	}

	@Override
	public void clearCache(List<Bike> bikes) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Bike bike : bikes) {
			entityCache.removeResult(BikeModelImpl.ENTITY_CACHE_ENABLED,
				BikeImpl.class, bike.getPrimaryKey());

			clearUniqueFindersCache((BikeModelImpl)bike, true);
		}
	}

	protected void cacheUniqueFindersCache(BikeModelImpl bikeModelImpl) {
		Object[] args = new Object[] {
				bikeModelImpl.getUuid(), bikeModelImpl.getGroupId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args, bikeModelImpl,
			false);
	}

	protected void clearUniqueFindersCache(BikeModelImpl bikeModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					bikeModelImpl.getUuid(), bikeModelImpl.getGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		if ((bikeModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					bikeModelImpl.getOriginalUuid(),
					bikeModelImpl.getOriginalGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new bike with the primary key. Does not add the bike to the database.
	 *
	 * @param bikeId the primary key for the new bike
	 * @return the new bike
	 */
	@Override
	public Bike create(long bikeId) {
		Bike bike = new BikeImpl();

		bike.setNew(true);
		bike.setPrimaryKey(bikeId);

		String uuid = PortalUUIDUtil.generate();

		bike.setUuid(uuid);

		bike.setCompanyId(companyProvider.getCompanyId());

		return bike;
	}

	/**
	 * Removes the bike with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bikeId the primary key of the bike
	 * @return the bike that was removed
	 * @throws NoSuchBikeException if a bike with the primary key could not be found
	 */
	@Override
	public Bike remove(long bikeId) throws NoSuchBikeException {
		return remove((Serializable)bikeId);
	}

	/**
	 * Removes the bike with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the bike
	 * @return the bike that was removed
	 * @throws NoSuchBikeException if a bike with the primary key could not be found
	 */
	@Override
	public Bike remove(Serializable primaryKey) throws NoSuchBikeException {
		Session session = null;

		try {
			session = openSession();

			Bike bike = (Bike)session.get(BikeImpl.class, primaryKey);

			if (bike == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBikeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(bike);
		}
		catch (NoSuchBikeException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Bike removeImpl(Bike bike) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(bike)) {
				bike = (Bike)session.get(BikeImpl.class, bike.getPrimaryKeyObj());
			}

			if (bike != null) {
				session.delete(bike);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (bike != null) {
			clearCache(bike);
		}

		return bike;
	}

	@Override
	public Bike updateImpl(Bike bike) {
		boolean isNew = bike.isNew();

		if (!(bike instanceof BikeModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(bike.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(bike);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in bike proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Bike implementation " +
				bike.getClass());
		}

		BikeModelImpl bikeModelImpl = (BikeModelImpl)bike;

		if (Validator.isNull(bike.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			bike.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (bike.getCreateDate() == null)) {
			if (serviceContext == null) {
				bike.setCreateDate(now);
			}
			else {
				bike.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!bikeModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				bike.setModifiedDate(now);
			}
			else {
				bike.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (bike.isNew()) {
				session.save(bike);

				bike.setNew(false);
			}
			else {
				bike = (Bike)session.merge(bike);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!BikeModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { bikeModelImpl.getUuid() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] {
					bikeModelImpl.getUuid(), bikeModelImpl.getCompanyId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
				args);

			args = new Object[] { bikeModelImpl.getBrand() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_BRAND, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BRAND,
				args);

			args = new Object[] { bikeModelImpl.getStudentId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_STUDENTID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STUDENTID,
				args);

			args = new Object[] {
					bikeModelImpl.getGroupId(), bikeModelImpl.getStudentId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_G_S, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((bikeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { bikeModelImpl.getOriginalUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { bikeModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((bikeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						bikeModelImpl.getOriginalUuid(),
						bikeModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						bikeModelImpl.getUuid(), bikeModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((bikeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BRAND.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { bikeModelImpl.getOriginalBrand() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_BRAND, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BRAND,
					args);

				args = new Object[] { bikeModelImpl.getBrand() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_BRAND, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BRAND,
					args);
			}

			if ((bikeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STUDENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						bikeModelImpl.getOriginalStudentId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_STUDENTID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STUDENTID,
					args);

				args = new Object[] { bikeModelImpl.getStudentId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_STUDENTID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STUDENTID,
					args);
			}

			if ((bikeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						bikeModelImpl.getOriginalGroupId(),
						bikeModelImpl.getOriginalStudentId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_G_S, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S,
					args);

				args = new Object[] {
						bikeModelImpl.getGroupId(), bikeModelImpl.getStudentId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_G_S, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S,
					args);
			}
		}

		entityCache.putResult(BikeModelImpl.ENTITY_CACHE_ENABLED,
			BikeImpl.class, bike.getPrimaryKey(), bike, false);

		clearUniqueFindersCache(bikeModelImpl, false);
		cacheUniqueFindersCache(bikeModelImpl);

		bike.resetOriginalValues();

		return bike;
	}

	/**
	 * Returns the bike with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the bike
	 * @return the bike
	 * @throws NoSuchBikeException if a bike with the primary key could not be found
	 */
	@Override
	public Bike findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBikeException {
		Bike bike = fetchByPrimaryKey(primaryKey);

		if (bike == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBikeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return bike;
	}

	/**
	 * Returns the bike with the primary key or throws a {@link NoSuchBikeException} if it could not be found.
	 *
	 * @param bikeId the primary key of the bike
	 * @return the bike
	 * @throws NoSuchBikeException if a bike with the primary key could not be found
	 */
	@Override
	public Bike findByPrimaryKey(long bikeId) throws NoSuchBikeException {
		return findByPrimaryKey((Serializable)bikeId);
	}

	/**
	 * Returns the bike with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the bike
	 * @return the bike, or <code>null</code> if a bike with the primary key could not be found
	 */
	@Override
	public Bike fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(BikeModelImpl.ENTITY_CACHE_ENABLED,
				BikeImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Bike bike = (Bike)serializable;

		if (bike == null) {
			Session session = null;

			try {
				session = openSession();

				bike = (Bike)session.get(BikeImpl.class, primaryKey);

				if (bike != null) {
					cacheResult(bike);
				}
				else {
					entityCache.putResult(BikeModelImpl.ENTITY_CACHE_ENABLED,
						BikeImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(BikeModelImpl.ENTITY_CACHE_ENABLED,
					BikeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return bike;
	}

	/**
	 * Returns the bike with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bikeId the primary key of the bike
	 * @return the bike, or <code>null</code> if a bike with the primary key could not be found
	 */
	@Override
	public Bike fetchByPrimaryKey(long bikeId) {
		return fetchByPrimaryKey((Serializable)bikeId);
	}

	@Override
	public Map<Serializable, Bike> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Bike> map = new HashMap<Serializable, Bike>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Bike bike = fetchByPrimaryKey(primaryKey);

			if (bike != null) {
				map.put(primaryKey, bike);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(BikeModelImpl.ENTITY_CACHE_ENABLED,
					BikeImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Bike)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_BIKE_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(",");
		}

		query.setIndex(query.index() - 1);

		query.append(")");

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (Bike bike : (List<Bike>)q.list()) {
				map.put(bike.getPrimaryKeyObj(), bike);

				cacheResult(bike);

				uncachedPrimaryKeys.remove(bike.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(BikeModelImpl.ENTITY_CACHE_ENABLED,
					BikeImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the bikes.
	 *
	 * @return the bikes
	 */
	@Override
	public List<Bike> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Bike> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Bike> findAll(int start, int end,
		OrderByComparator<Bike> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Bike> findAll(int start, int end,
		OrderByComparator<Bike> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Bike> list = null;

		if (retrieveFromCache) {
			list = (List<Bike>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_BIKE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BIKE;

				if (pagination) {
					sql = sql.concat(BikeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Bike>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Bike>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the bikes from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Bike bike : findAll()) {
			remove(bike);
		}
	}

	/**
	 * Returns the number of bikes.
	 *
	 * @return the number of bikes
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_BIKE);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return BikeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the bike persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(BikeImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_BIKE = "SELECT bike FROM Bike bike";
	private static final String _SQL_SELECT_BIKE_WHERE_PKS_IN = "SELECT bike FROM Bike bike WHERE bikeId IN (";
	private static final String _SQL_SELECT_BIKE_WHERE = "SELECT bike FROM Bike bike WHERE ";
	private static final String _SQL_COUNT_BIKE = "SELECT COUNT(bike) FROM Bike bike";
	private static final String _SQL_COUNT_BIKE_WHERE = "SELECT COUNT(bike) FROM Bike bike WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "bike.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Bike exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Bike exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(BikePersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}