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

package com.autodetservice.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.autodetservice.exception.NoSuchAutoDetailsException;

import com.autodetservice.model.AutoDetails;
import com.autodetservice.model.impl.AutoDetailsImpl;
import com.autodetservice.model.impl.AutoDetailsModelImpl;

import com.autodetservice.service.persistence.AutoDetailsPersistence;

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
import com.liferay.portal.kernel.util.ReflectionUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.Field;

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
 * The persistence implementation for the auto details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AutoDetailsPersistence
 * @see com.autodetservice.service.persistence.AutoDetailsUtil
 * @generated
 */
@ProviderType
public class AutoDetailsPersistenceImpl extends BasePersistenceImpl<AutoDetails>
	implements AutoDetailsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AutoDetailsUtil} to access the auto details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AutoDetailsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AutoDetailsModelImpl.ENTITY_CACHE_ENABLED,
			AutoDetailsModelImpl.FINDER_CACHE_ENABLED, AutoDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AutoDetailsModelImpl.ENTITY_CACHE_ENABLED,
			AutoDetailsModelImpl.FINDER_CACHE_ENABLED, AutoDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AutoDetailsModelImpl.ENTITY_CACHE_ENABLED,
			AutoDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(AutoDetailsModelImpl.ENTITY_CACHE_ENABLED,
			AutoDetailsModelImpl.FINDER_CACHE_ENABLED, AutoDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(AutoDetailsModelImpl.ENTITY_CACHE_ENABLED,
			AutoDetailsModelImpl.FINDER_CACHE_ENABLED, AutoDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			AutoDetailsModelImpl.UUID_COLUMN_BITMASK |
			AutoDetailsModelImpl.MODEL_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(AutoDetailsModelImpl.ENTITY_CACHE_ENABLED,
			AutoDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the auto detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching auto detailses
	 */
	@Override
	public List<AutoDetails> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the auto detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AutoDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of auto detailses
	 * @param end the upper bound of the range of auto detailses (not inclusive)
	 * @return the range of matching auto detailses
	 */
	@Override
	public List<AutoDetails> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the auto detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AutoDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of auto detailses
	 * @param end the upper bound of the range of auto detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching auto detailses
	 */
	@Override
	public List<AutoDetails> findByUuid(String uuid, int start, int end,
		OrderByComparator<AutoDetails> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the auto detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AutoDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of auto detailses
	 * @param end the upper bound of the range of auto detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching auto detailses
	 */
	@Override
	public List<AutoDetails> findByUuid(String uuid, int start, int end,
		OrderByComparator<AutoDetails> orderByComparator,
		boolean retrieveFromCache) {
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

		List<AutoDetails> list = null;

		if (retrieveFromCache) {
			list = (List<AutoDetails>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AutoDetails autoDetails : list) {
					if (!Objects.equals(uuid, autoDetails.getUuid())) {
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

			query.append(_SQL_SELECT_AUTODETAILS_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
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
				query.append(AutoDetailsModelImpl.ORDER_BY_JPQL);
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
					list = (List<AutoDetails>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AutoDetails>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first auto details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching auto details
	 * @throws NoSuchAutoDetailsException if a matching auto details could not be found
	 */
	@Override
	public AutoDetails findByUuid_First(String uuid,
		OrderByComparator<AutoDetails> orderByComparator)
		throws NoSuchAutoDetailsException {
		AutoDetails autoDetails = fetchByUuid_First(uuid, orderByComparator);

		if (autoDetails != null) {
			return autoDetails;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAutoDetailsException(msg.toString());
	}

	/**
	 * Returns the first auto details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching auto details, or <code>null</code> if a matching auto details could not be found
	 */
	@Override
	public AutoDetails fetchByUuid_First(String uuid,
		OrderByComparator<AutoDetails> orderByComparator) {
		List<AutoDetails> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last auto details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching auto details
	 * @throws NoSuchAutoDetailsException if a matching auto details could not be found
	 */
	@Override
	public AutoDetails findByUuid_Last(String uuid,
		OrderByComparator<AutoDetails> orderByComparator)
		throws NoSuchAutoDetailsException {
		AutoDetails autoDetails = fetchByUuid_Last(uuid, orderByComparator);

		if (autoDetails != null) {
			return autoDetails;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAutoDetailsException(msg.toString());
	}

	/**
	 * Returns the last auto details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching auto details, or <code>null</code> if a matching auto details could not be found
	 */
	@Override
	public AutoDetails fetchByUuid_Last(String uuid,
		OrderByComparator<AutoDetails> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<AutoDetails> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the auto detailses before and after the current auto details in the ordered set where uuid = &#63;.
	 *
	 * @param autodetailId the primary key of the current auto details
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next auto details
	 * @throws NoSuchAutoDetailsException if a auto details with the primary key could not be found
	 */
	@Override
	public AutoDetails[] findByUuid_PrevAndNext(long autodetailId, String uuid,
		OrderByComparator<AutoDetails> orderByComparator)
		throws NoSuchAutoDetailsException {
		AutoDetails autoDetails = findByPrimaryKey(autodetailId);

		Session session = null;

		try {
			session = openSession();

			AutoDetails[] array = new AutoDetailsImpl[3];

			array[0] = getByUuid_PrevAndNext(session, autoDetails, uuid,
					orderByComparator, true);

			array[1] = autoDetails;

			array[2] = getByUuid_PrevAndNext(session, autoDetails, uuid,
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

	protected AutoDetails getByUuid_PrevAndNext(Session session,
		AutoDetails autoDetails, String uuid,
		OrderByComparator<AutoDetails> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_AUTODETAILS_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
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
			query.append(AutoDetailsModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(autoDetails);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AutoDetails> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the auto detailses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (AutoDetails autoDetails : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(autoDetails);
		}
	}

	/**
	 * Returns the number of auto detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching auto detailses
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_AUTODETAILS_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "autoDetails.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "autoDetails.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(autoDetails.uuid IS NULL OR autoDetails.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(AutoDetailsModelImpl.ENTITY_CACHE_ENABLED,
			AutoDetailsModelImpl.FINDER_CACHE_ENABLED, AutoDetailsImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			AutoDetailsModelImpl.UUID_COLUMN_BITMASK |
			AutoDetailsModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(AutoDetailsModelImpl.ENTITY_CACHE_ENABLED,
			AutoDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the auto details where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchAutoDetailsException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching auto details
	 * @throws NoSuchAutoDetailsException if a matching auto details could not be found
	 */
	@Override
	public AutoDetails findByUUID_G(String uuid, long groupId)
		throws NoSuchAutoDetailsException {
		AutoDetails autoDetails = fetchByUUID_G(uuid, groupId);

		if (autoDetails == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchAutoDetailsException(msg.toString());
		}

		return autoDetails;
	}

	/**
	 * Returns the auto details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching auto details, or <code>null</code> if a matching auto details could not be found
	 */
	@Override
	public AutoDetails fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the auto details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching auto details, or <code>null</code> if a matching auto details could not be found
	 */
	@Override
	public AutoDetails fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof AutoDetails) {
			AutoDetails autoDetails = (AutoDetails)result;

			if (!Objects.equals(uuid, autoDetails.getUuid()) ||
					(groupId != autoDetails.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_AUTODETAILS_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
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

				List<AutoDetails> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					AutoDetails autoDetails = list.get(0);

					result = autoDetails;

					cacheResult(autoDetails);

					if ((autoDetails.getUuid() == null) ||
							!autoDetails.getUuid().equals(uuid) ||
							(autoDetails.getGroupId() != groupId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, autoDetails);
					}
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
			return (AutoDetails)result;
		}
	}

	/**
	 * Removes the auto details where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the auto details that was removed
	 */
	@Override
	public AutoDetails removeByUUID_G(String uuid, long groupId)
		throws NoSuchAutoDetailsException {
		AutoDetails autoDetails = findByUUID_G(uuid, groupId);

		return remove(autoDetails);
	}

	/**
	 * Returns the number of auto detailses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching auto detailses
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_AUTODETAILS_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "autoDetails.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "autoDetails.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(autoDetails.uuid IS NULL OR autoDetails.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "autoDetails.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(AutoDetailsModelImpl.ENTITY_CACHE_ENABLED,
			AutoDetailsModelImpl.FINDER_CACHE_ENABLED, AutoDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(AutoDetailsModelImpl.ENTITY_CACHE_ENABLED,
			AutoDetailsModelImpl.FINDER_CACHE_ENABLED, AutoDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			AutoDetailsModelImpl.UUID_COLUMN_BITMASK |
			AutoDetailsModelImpl.COMPANYID_COLUMN_BITMASK |
			AutoDetailsModelImpl.MODEL_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(AutoDetailsModelImpl.ENTITY_CACHE_ENABLED,
			AutoDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the auto detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching auto detailses
	 */
	@Override
	public List<AutoDetails> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the auto detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AutoDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of auto detailses
	 * @param end the upper bound of the range of auto detailses (not inclusive)
	 * @return the range of matching auto detailses
	 */
	@Override
	public List<AutoDetails> findByUuid_C(String uuid, long companyId,
		int start, int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the auto detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AutoDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of auto detailses
	 * @param end the upper bound of the range of auto detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching auto detailses
	 */
	@Override
	public List<AutoDetails> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<AutoDetails> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the auto detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AutoDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of auto detailses
	 * @param end the upper bound of the range of auto detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching auto detailses
	 */
	@Override
	public List<AutoDetails> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<AutoDetails> orderByComparator,
		boolean retrieveFromCache) {
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

		List<AutoDetails> list = null;

		if (retrieveFromCache) {
			list = (List<AutoDetails>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AutoDetails autoDetails : list) {
					if (!Objects.equals(uuid, autoDetails.getUuid()) ||
							(companyId != autoDetails.getCompanyId())) {
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

			query.append(_SQL_SELECT_AUTODETAILS_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
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
				query.append(AutoDetailsModelImpl.ORDER_BY_JPQL);
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
					list = (List<AutoDetails>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AutoDetails>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first auto details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching auto details
	 * @throws NoSuchAutoDetailsException if a matching auto details could not be found
	 */
	@Override
	public AutoDetails findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<AutoDetails> orderByComparator)
		throws NoSuchAutoDetailsException {
		AutoDetails autoDetails = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (autoDetails != null) {
			return autoDetails;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAutoDetailsException(msg.toString());
	}

	/**
	 * Returns the first auto details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching auto details, or <code>null</code> if a matching auto details could not be found
	 */
	@Override
	public AutoDetails fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<AutoDetails> orderByComparator) {
		List<AutoDetails> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last auto details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching auto details
	 * @throws NoSuchAutoDetailsException if a matching auto details could not be found
	 */
	@Override
	public AutoDetails findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<AutoDetails> orderByComparator)
		throws NoSuchAutoDetailsException {
		AutoDetails autoDetails = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (autoDetails != null) {
			return autoDetails;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAutoDetailsException(msg.toString());
	}

	/**
	 * Returns the last auto details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching auto details, or <code>null</code> if a matching auto details could not be found
	 */
	@Override
	public AutoDetails fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<AutoDetails> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<AutoDetails> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the auto detailses before and after the current auto details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param autodetailId the primary key of the current auto details
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next auto details
	 * @throws NoSuchAutoDetailsException if a auto details with the primary key could not be found
	 */
	@Override
	public AutoDetails[] findByUuid_C_PrevAndNext(long autodetailId,
		String uuid, long companyId,
		OrderByComparator<AutoDetails> orderByComparator)
		throws NoSuchAutoDetailsException {
		AutoDetails autoDetails = findByPrimaryKey(autodetailId);

		Session session = null;

		try {
			session = openSession();

			AutoDetails[] array = new AutoDetailsImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, autoDetails, uuid,
					companyId, orderByComparator, true);

			array[1] = autoDetails;

			array[2] = getByUuid_C_PrevAndNext(session, autoDetails, uuid,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AutoDetails getByUuid_C_PrevAndNext(Session session,
		AutoDetails autoDetails, String uuid, long companyId,
		OrderByComparator<AutoDetails> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_AUTODETAILS_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
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
			query.append(AutoDetailsModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(autoDetails);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AutoDetails> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the auto detailses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (AutoDetails autoDetails : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(autoDetails);
		}
	}

	/**
	 * Returns the number of auto detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching auto detailses
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_AUTODETAILS_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "autoDetails.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "autoDetails.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(autoDetails.uuid IS NULL OR autoDetails.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "autoDetails.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_M_U = new FinderPath(AutoDetailsModelImpl.ENTITY_CACHE_ENABLED,
			AutoDetailsModelImpl.FINDER_CACHE_ENABLED, AutoDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByM_U",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_M_U = new FinderPath(AutoDetailsModelImpl.ENTITY_CACHE_ENABLED,
			AutoDetailsModelImpl.FINDER_CACHE_ENABLED, AutoDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByM_U",
			new String[] { Long.class.getName(), String.class.getName() },
			AutoDetailsModelImpl.USERID_COLUMN_BITMASK |
			AutoDetailsModelImpl.MODEL_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_M_U = new FinderPath(AutoDetailsModelImpl.ENTITY_CACHE_ENABLED,
			AutoDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByM_U",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the auto detailses where userId = &#63; and Model = &#63;.
	 *
	 * @param userId the user ID
	 * @param Model the model
	 * @return the matching auto detailses
	 */
	@Override
	public List<AutoDetails> findByM_U(long userId, String Model) {
		return findByM_U(userId, Model, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the auto detailses where userId = &#63; and Model = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AutoDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param Model the model
	 * @param start the lower bound of the range of auto detailses
	 * @param end the upper bound of the range of auto detailses (not inclusive)
	 * @return the range of matching auto detailses
	 */
	@Override
	public List<AutoDetails> findByM_U(long userId, String Model, int start,
		int end) {
		return findByM_U(userId, Model, start, end, null);
	}

	/**
	 * Returns an ordered range of all the auto detailses where userId = &#63; and Model = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AutoDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param Model the model
	 * @param start the lower bound of the range of auto detailses
	 * @param end the upper bound of the range of auto detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching auto detailses
	 */
	@Override
	public List<AutoDetails> findByM_U(long userId, String Model, int start,
		int end, OrderByComparator<AutoDetails> orderByComparator) {
		return findByM_U(userId, Model, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the auto detailses where userId = &#63; and Model = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AutoDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param Model the model
	 * @param start the lower bound of the range of auto detailses
	 * @param end the upper bound of the range of auto detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching auto detailses
	 */
	@Override
	public List<AutoDetails> findByM_U(long userId, String Model, int start,
		int end, OrderByComparator<AutoDetails> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_M_U;
			finderArgs = new Object[] { userId, Model };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_M_U;
			finderArgs = new Object[] {
					userId, Model,
					
					start, end, orderByComparator
				};
		}

		List<AutoDetails> list = null;

		if (retrieveFromCache) {
			list = (List<AutoDetails>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AutoDetails autoDetails : list) {
					if ((userId != autoDetails.getUserId()) ||
							!Objects.equals(Model, autoDetails.getModel())) {
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

			query.append(_SQL_SELECT_AUTODETAILS_WHERE);

			query.append(_FINDER_COLUMN_M_U_USERID_2);

			boolean bindModel = false;

			if (Model == null) {
				query.append(_FINDER_COLUMN_M_U_MODEL_1);
			}
			else if (Model.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_M_U_MODEL_3);
			}
			else {
				bindModel = true;

				query.append(_FINDER_COLUMN_M_U_MODEL_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AutoDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (bindModel) {
					qPos.add(Model);
				}

				if (!pagination) {
					list = (List<AutoDetails>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AutoDetails>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first auto details in the ordered set where userId = &#63; and Model = &#63;.
	 *
	 * @param userId the user ID
	 * @param Model the model
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching auto details
	 * @throws NoSuchAutoDetailsException if a matching auto details could not be found
	 */
	@Override
	public AutoDetails findByM_U_First(long userId, String Model,
		OrderByComparator<AutoDetails> orderByComparator)
		throws NoSuchAutoDetailsException {
		AutoDetails autoDetails = fetchByM_U_First(userId, Model,
				orderByComparator);

		if (autoDetails != null) {
			return autoDetails;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", Model=");
		msg.append(Model);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAutoDetailsException(msg.toString());
	}

	/**
	 * Returns the first auto details in the ordered set where userId = &#63; and Model = &#63;.
	 *
	 * @param userId the user ID
	 * @param Model the model
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching auto details, or <code>null</code> if a matching auto details could not be found
	 */
	@Override
	public AutoDetails fetchByM_U_First(long userId, String Model,
		OrderByComparator<AutoDetails> orderByComparator) {
		List<AutoDetails> list = findByM_U(userId, Model, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last auto details in the ordered set where userId = &#63; and Model = &#63;.
	 *
	 * @param userId the user ID
	 * @param Model the model
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching auto details
	 * @throws NoSuchAutoDetailsException if a matching auto details could not be found
	 */
	@Override
	public AutoDetails findByM_U_Last(long userId, String Model,
		OrderByComparator<AutoDetails> orderByComparator)
		throws NoSuchAutoDetailsException {
		AutoDetails autoDetails = fetchByM_U_Last(userId, Model,
				orderByComparator);

		if (autoDetails != null) {
			return autoDetails;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", Model=");
		msg.append(Model);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAutoDetailsException(msg.toString());
	}

	/**
	 * Returns the last auto details in the ordered set where userId = &#63; and Model = &#63;.
	 *
	 * @param userId the user ID
	 * @param Model the model
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching auto details, or <code>null</code> if a matching auto details could not be found
	 */
	@Override
	public AutoDetails fetchByM_U_Last(long userId, String Model,
		OrderByComparator<AutoDetails> orderByComparator) {
		int count = countByM_U(userId, Model);

		if (count == 0) {
			return null;
		}

		List<AutoDetails> list = findByM_U(userId, Model, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the auto detailses before and after the current auto details in the ordered set where userId = &#63; and Model = &#63;.
	 *
	 * @param autodetailId the primary key of the current auto details
	 * @param userId the user ID
	 * @param Model the model
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next auto details
	 * @throws NoSuchAutoDetailsException if a auto details with the primary key could not be found
	 */
	@Override
	public AutoDetails[] findByM_U_PrevAndNext(long autodetailId, long userId,
		String Model, OrderByComparator<AutoDetails> orderByComparator)
		throws NoSuchAutoDetailsException {
		AutoDetails autoDetails = findByPrimaryKey(autodetailId);

		Session session = null;

		try {
			session = openSession();

			AutoDetails[] array = new AutoDetailsImpl[3];

			array[0] = getByM_U_PrevAndNext(session, autoDetails, userId,
					Model, orderByComparator, true);

			array[1] = autoDetails;

			array[2] = getByM_U_PrevAndNext(session, autoDetails, userId,
					Model, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AutoDetails getByM_U_PrevAndNext(Session session,
		AutoDetails autoDetails, long userId, String Model,
		OrderByComparator<AutoDetails> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_AUTODETAILS_WHERE);

		query.append(_FINDER_COLUMN_M_U_USERID_2);

		boolean bindModel = false;

		if (Model == null) {
			query.append(_FINDER_COLUMN_M_U_MODEL_1);
		}
		else if (Model.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_M_U_MODEL_3);
		}
		else {
			bindModel = true;

			query.append(_FINDER_COLUMN_M_U_MODEL_2);
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
			query.append(AutoDetailsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (bindModel) {
			qPos.add(Model);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(autoDetails);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AutoDetails> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the auto detailses where userId = &#63; and Model = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param Model the model
	 */
	@Override
	public void removeByM_U(long userId, String Model) {
		for (AutoDetails autoDetails : findByM_U(userId, Model,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(autoDetails);
		}
	}

	/**
	 * Returns the number of auto detailses where userId = &#63; and Model = &#63;.
	 *
	 * @param userId the user ID
	 * @param Model the model
	 * @return the number of matching auto detailses
	 */
	@Override
	public int countByM_U(long userId, String Model) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_M_U;

		Object[] finderArgs = new Object[] { userId, Model };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_AUTODETAILS_WHERE);

			query.append(_FINDER_COLUMN_M_U_USERID_2);

			boolean bindModel = false;

			if (Model == null) {
				query.append(_FINDER_COLUMN_M_U_MODEL_1);
			}
			else if (Model.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_M_U_MODEL_3);
			}
			else {
				bindModel = true;

				query.append(_FINDER_COLUMN_M_U_MODEL_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (bindModel) {
					qPos.add(Model);
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

	private static final String _FINDER_COLUMN_M_U_USERID_2 = "autoDetails.userId = ? AND ";
	private static final String _FINDER_COLUMN_M_U_MODEL_1 = "autoDetails.Model IS NULL";
	private static final String _FINDER_COLUMN_M_U_MODEL_2 = "autoDetails.Model = ?";
	private static final String _FINDER_COLUMN_M_U_MODEL_3 = "(autoDetails.Model IS NULL OR autoDetails.Model = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_Y_U = new FinderPath(AutoDetailsModelImpl.ENTITY_CACHE_ENABLED,
			AutoDetailsModelImpl.FINDER_CACHE_ENABLED, AutoDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByY_U",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_Y_U = new FinderPath(AutoDetailsModelImpl.ENTITY_CACHE_ENABLED,
			AutoDetailsModelImpl.FINDER_CACHE_ENABLED, AutoDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByY_U",
			new String[] { Long.class.getName(), Integer.class.getName() },
			AutoDetailsModelImpl.USERID_COLUMN_BITMASK |
			AutoDetailsModelImpl.YEAR_COLUMN_BITMASK |
			AutoDetailsModelImpl.MODEL_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_Y_U = new FinderPath(AutoDetailsModelImpl.ENTITY_CACHE_ENABLED,
			AutoDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByY_U",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the auto detailses where userId = &#63; and Year = &#63;.
	 *
	 * @param userId the user ID
	 * @param Year the year
	 * @return the matching auto detailses
	 */
	@Override
	public List<AutoDetails> findByY_U(long userId, int Year) {
		return findByY_U(userId, Year, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the auto detailses where userId = &#63; and Year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AutoDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param Year the year
	 * @param start the lower bound of the range of auto detailses
	 * @param end the upper bound of the range of auto detailses (not inclusive)
	 * @return the range of matching auto detailses
	 */
	@Override
	public List<AutoDetails> findByY_U(long userId, int Year, int start, int end) {
		return findByY_U(userId, Year, start, end, null);
	}

	/**
	 * Returns an ordered range of all the auto detailses where userId = &#63; and Year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AutoDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param Year the year
	 * @param start the lower bound of the range of auto detailses
	 * @param end the upper bound of the range of auto detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching auto detailses
	 */
	@Override
	public List<AutoDetails> findByY_U(long userId, int Year, int start,
		int end, OrderByComparator<AutoDetails> orderByComparator) {
		return findByY_U(userId, Year, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the auto detailses where userId = &#63; and Year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AutoDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param Year the year
	 * @param start the lower bound of the range of auto detailses
	 * @param end the upper bound of the range of auto detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching auto detailses
	 */
	@Override
	public List<AutoDetails> findByY_U(long userId, int Year, int start,
		int end, OrderByComparator<AutoDetails> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_Y_U;
			finderArgs = new Object[] { userId, Year };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_Y_U;
			finderArgs = new Object[] {
					userId, Year,
					
					start, end, orderByComparator
				};
		}

		List<AutoDetails> list = null;

		if (retrieveFromCache) {
			list = (List<AutoDetails>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AutoDetails autoDetails : list) {
					if ((userId != autoDetails.getUserId()) ||
							(Year != autoDetails.getYear())) {
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

			query.append(_SQL_SELECT_AUTODETAILS_WHERE);

			query.append(_FINDER_COLUMN_Y_U_USERID_2);

			query.append(_FINDER_COLUMN_Y_U_YEAR_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AutoDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(Year);

				if (!pagination) {
					list = (List<AutoDetails>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AutoDetails>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first auto details in the ordered set where userId = &#63; and Year = &#63;.
	 *
	 * @param userId the user ID
	 * @param Year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching auto details
	 * @throws NoSuchAutoDetailsException if a matching auto details could not be found
	 */
	@Override
	public AutoDetails findByY_U_First(long userId, int Year,
		OrderByComparator<AutoDetails> orderByComparator)
		throws NoSuchAutoDetailsException {
		AutoDetails autoDetails = fetchByY_U_First(userId, Year,
				orderByComparator);

		if (autoDetails != null) {
			return autoDetails;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", Year=");
		msg.append(Year);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAutoDetailsException(msg.toString());
	}

	/**
	 * Returns the first auto details in the ordered set where userId = &#63; and Year = &#63;.
	 *
	 * @param userId the user ID
	 * @param Year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching auto details, or <code>null</code> if a matching auto details could not be found
	 */
	@Override
	public AutoDetails fetchByY_U_First(long userId, int Year,
		OrderByComparator<AutoDetails> orderByComparator) {
		List<AutoDetails> list = findByY_U(userId, Year, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last auto details in the ordered set where userId = &#63; and Year = &#63;.
	 *
	 * @param userId the user ID
	 * @param Year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching auto details
	 * @throws NoSuchAutoDetailsException if a matching auto details could not be found
	 */
	@Override
	public AutoDetails findByY_U_Last(long userId, int Year,
		OrderByComparator<AutoDetails> orderByComparator)
		throws NoSuchAutoDetailsException {
		AutoDetails autoDetails = fetchByY_U_Last(userId, Year,
				orderByComparator);

		if (autoDetails != null) {
			return autoDetails;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", Year=");
		msg.append(Year);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAutoDetailsException(msg.toString());
	}

	/**
	 * Returns the last auto details in the ordered set where userId = &#63; and Year = &#63;.
	 *
	 * @param userId the user ID
	 * @param Year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching auto details, or <code>null</code> if a matching auto details could not be found
	 */
	@Override
	public AutoDetails fetchByY_U_Last(long userId, int Year,
		OrderByComparator<AutoDetails> orderByComparator) {
		int count = countByY_U(userId, Year);

		if (count == 0) {
			return null;
		}

		List<AutoDetails> list = findByY_U(userId, Year, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the auto detailses before and after the current auto details in the ordered set where userId = &#63; and Year = &#63;.
	 *
	 * @param autodetailId the primary key of the current auto details
	 * @param userId the user ID
	 * @param Year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next auto details
	 * @throws NoSuchAutoDetailsException if a auto details with the primary key could not be found
	 */
	@Override
	public AutoDetails[] findByY_U_PrevAndNext(long autodetailId, long userId,
		int Year, OrderByComparator<AutoDetails> orderByComparator)
		throws NoSuchAutoDetailsException {
		AutoDetails autoDetails = findByPrimaryKey(autodetailId);

		Session session = null;

		try {
			session = openSession();

			AutoDetails[] array = new AutoDetailsImpl[3];

			array[0] = getByY_U_PrevAndNext(session, autoDetails, userId, Year,
					orderByComparator, true);

			array[1] = autoDetails;

			array[2] = getByY_U_PrevAndNext(session, autoDetails, userId, Year,
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

	protected AutoDetails getByY_U_PrevAndNext(Session session,
		AutoDetails autoDetails, long userId, int Year,
		OrderByComparator<AutoDetails> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_AUTODETAILS_WHERE);

		query.append(_FINDER_COLUMN_Y_U_USERID_2);

		query.append(_FINDER_COLUMN_Y_U_YEAR_2);

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
			query.append(AutoDetailsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		qPos.add(Year);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(autoDetails);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AutoDetails> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the auto detailses where userId = &#63; and Year = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param Year the year
	 */
	@Override
	public void removeByY_U(long userId, int Year) {
		for (AutoDetails autoDetails : findByY_U(userId, Year,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(autoDetails);
		}
	}

	/**
	 * Returns the number of auto detailses where userId = &#63; and Year = &#63;.
	 *
	 * @param userId the user ID
	 * @param Year the year
	 * @return the number of matching auto detailses
	 */
	@Override
	public int countByY_U(long userId, int Year) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_Y_U;

		Object[] finderArgs = new Object[] { userId, Year };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_AUTODETAILS_WHERE);

			query.append(_FINDER_COLUMN_Y_U_USERID_2);

			query.append(_FINDER_COLUMN_Y_U_YEAR_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(Year);

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

	private static final String _FINDER_COLUMN_Y_U_USERID_2 = "autoDetails.userId = ? AND ";
	private static final String _FINDER_COLUMN_Y_U_YEAR_2 = "autoDetails.Year = ?";

	public AutoDetailsPersistenceImpl() {
		setModelClass(AutoDetails.class);

		try {
			Field field = ReflectionUtil.getDeclaredField(BasePersistenceImpl.class,
					"_dbColumnNames");

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
	 * Caches the auto details in the entity cache if it is enabled.
	 *
	 * @param autoDetails the auto details
	 */
	@Override
	public void cacheResult(AutoDetails autoDetails) {
		entityCache.putResult(AutoDetailsModelImpl.ENTITY_CACHE_ENABLED,
			AutoDetailsImpl.class, autoDetails.getPrimaryKey(), autoDetails);

		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { autoDetails.getUuid(), autoDetails.getGroupId() },
			autoDetails);

		autoDetails.resetOriginalValues();
	}

	/**
	 * Caches the auto detailses in the entity cache if it is enabled.
	 *
	 * @param autoDetailses the auto detailses
	 */
	@Override
	public void cacheResult(List<AutoDetails> autoDetailses) {
		for (AutoDetails autoDetails : autoDetailses) {
			if (entityCache.getResult(
						AutoDetailsModelImpl.ENTITY_CACHE_ENABLED,
						AutoDetailsImpl.class, autoDetails.getPrimaryKey()) == null) {
				cacheResult(autoDetails);
			}
			else {
				autoDetails.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all auto detailses.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AutoDetailsImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the auto details.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AutoDetails autoDetails) {
		entityCache.removeResult(AutoDetailsModelImpl.ENTITY_CACHE_ENABLED,
			AutoDetailsImpl.class, autoDetails.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((AutoDetailsModelImpl)autoDetails, true);
	}

	@Override
	public void clearCache(List<AutoDetails> autoDetailses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AutoDetails autoDetails : autoDetailses) {
			entityCache.removeResult(AutoDetailsModelImpl.ENTITY_CACHE_ENABLED,
				AutoDetailsImpl.class, autoDetails.getPrimaryKey());

			clearUniqueFindersCache((AutoDetailsModelImpl)autoDetails, true);
		}
	}

	protected void cacheUniqueFindersCache(
		AutoDetailsModelImpl autoDetailsModelImpl) {
		Object[] args = new Object[] {
				autoDetailsModelImpl.getUuid(),
				autoDetailsModelImpl.getGroupId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
			autoDetailsModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		AutoDetailsModelImpl autoDetailsModelImpl, boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					autoDetailsModelImpl.getUuid(),
					autoDetailsModelImpl.getGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		if ((autoDetailsModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					autoDetailsModelImpl.getOriginalUuid(),
					autoDetailsModelImpl.getOriginalGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new auto details with the primary key. Does not add the auto details to the database.
	 *
	 * @param autodetailId the primary key for the new auto details
	 * @return the new auto details
	 */
	@Override
	public AutoDetails create(long autodetailId) {
		AutoDetails autoDetails = new AutoDetailsImpl();

		autoDetails.setNew(true);
		autoDetails.setPrimaryKey(autodetailId);

		String uuid = PortalUUIDUtil.generate();

		autoDetails.setUuid(uuid);

		autoDetails.setCompanyId(companyProvider.getCompanyId());

		return autoDetails;
	}

	/**
	 * Removes the auto details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param autodetailId the primary key of the auto details
	 * @return the auto details that was removed
	 * @throws NoSuchAutoDetailsException if a auto details with the primary key could not be found
	 */
	@Override
	public AutoDetails remove(long autodetailId)
		throws NoSuchAutoDetailsException {
		return remove((Serializable)autodetailId);
	}

	/**
	 * Removes the auto details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the auto details
	 * @return the auto details that was removed
	 * @throws NoSuchAutoDetailsException if a auto details with the primary key could not be found
	 */
	@Override
	public AutoDetails remove(Serializable primaryKey)
		throws NoSuchAutoDetailsException {
		Session session = null;

		try {
			session = openSession();

			AutoDetails autoDetails = (AutoDetails)session.get(AutoDetailsImpl.class,
					primaryKey);

			if (autoDetails == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAutoDetailsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(autoDetails);
		}
		catch (NoSuchAutoDetailsException nsee) {
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
	protected AutoDetails removeImpl(AutoDetails autoDetails) {
		autoDetails = toUnwrappedModel(autoDetails);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(autoDetails)) {
				autoDetails = (AutoDetails)session.get(AutoDetailsImpl.class,
						autoDetails.getPrimaryKeyObj());
			}

			if (autoDetails != null) {
				session.delete(autoDetails);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (autoDetails != null) {
			clearCache(autoDetails);
		}

		return autoDetails;
	}

	@Override
	public AutoDetails updateImpl(AutoDetails autoDetails) {
		autoDetails = toUnwrappedModel(autoDetails);

		boolean isNew = autoDetails.isNew();

		AutoDetailsModelImpl autoDetailsModelImpl = (AutoDetailsModelImpl)autoDetails;

		if (Validator.isNull(autoDetails.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			autoDetails.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (autoDetails.getCreateDate() == null)) {
			if (serviceContext == null) {
				autoDetails.setCreateDate(now);
			}
			else {
				autoDetails.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!autoDetailsModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				autoDetails.setModifiedDate(now);
			}
			else {
				autoDetails.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (autoDetails.isNew()) {
				session.save(autoDetails);

				autoDetails.setNew(false);
			}
			else {
				autoDetails = (AutoDetails)session.merge(autoDetails);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!AutoDetailsModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { autoDetailsModelImpl.getUuid() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] {
					autoDetailsModelImpl.getUuid(),
					autoDetailsModelImpl.getCompanyId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
				args);

			args = new Object[] {
					autoDetailsModelImpl.getUserId(),
					autoDetailsModelImpl.getModel()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_M_U, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_M_U,
				args);

			args = new Object[] {
					autoDetailsModelImpl.getUserId(),
					autoDetailsModelImpl.getYear()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_Y_U, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_Y_U,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((autoDetailsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						autoDetailsModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { autoDetailsModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((autoDetailsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						autoDetailsModelImpl.getOriginalUuid(),
						autoDetailsModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						autoDetailsModelImpl.getUuid(),
						autoDetailsModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((autoDetailsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_M_U.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						autoDetailsModelImpl.getOriginalUserId(),
						autoDetailsModelImpl.getOriginalModel()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_M_U, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_M_U,
					args);

				args = new Object[] {
						autoDetailsModelImpl.getUserId(),
						autoDetailsModelImpl.getModel()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_M_U, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_M_U,
					args);
			}

			if ((autoDetailsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_Y_U.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						autoDetailsModelImpl.getOriginalUserId(),
						autoDetailsModelImpl.getOriginalYear()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_Y_U, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_Y_U,
					args);

				args = new Object[] {
						autoDetailsModelImpl.getUserId(),
						autoDetailsModelImpl.getYear()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_Y_U, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_Y_U,
					args);
			}
		}

		entityCache.putResult(AutoDetailsModelImpl.ENTITY_CACHE_ENABLED,
			AutoDetailsImpl.class, autoDetails.getPrimaryKey(), autoDetails,
			false);

		clearUniqueFindersCache(autoDetailsModelImpl, false);
		cacheUniqueFindersCache(autoDetailsModelImpl);

		autoDetails.resetOriginalValues();

		return autoDetails;
	}

	protected AutoDetails toUnwrappedModel(AutoDetails autoDetails) {
		if (autoDetails instanceof AutoDetailsImpl) {
			return autoDetails;
		}

		AutoDetailsImpl autoDetailsImpl = new AutoDetailsImpl();

		autoDetailsImpl.setNew(autoDetails.isNew());
		autoDetailsImpl.setPrimaryKey(autoDetails.getPrimaryKey());

		autoDetailsImpl.setUuid(autoDetails.getUuid());
		autoDetailsImpl.setAutodetailId(autoDetails.getAutodetailId());
		autoDetailsImpl.setGroupId(autoDetails.getGroupId());
		autoDetailsImpl.setCompanyId(autoDetails.getCompanyId());
		autoDetailsImpl.setUserId(autoDetails.getUserId());
		autoDetailsImpl.setUserName(autoDetails.getUserName());
		autoDetailsImpl.setCreateDate(autoDetails.getCreateDate());
		autoDetailsImpl.setModifiedDate(autoDetails.getModifiedDate());
		autoDetailsImpl.setModel(autoDetails.getModel());
		autoDetailsImpl.setVIN(autoDetails.getVIN());
		autoDetailsImpl.setYear(autoDetails.getYear());
		autoDetailsImpl.setManufacturer(autoDetails.getManufacturer());
		autoDetailsImpl.setBodystyle(autoDetails.getBodystyle());

		return autoDetailsImpl;
	}

	/**
	 * Returns the auto details with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the auto details
	 * @return the auto details
	 * @throws NoSuchAutoDetailsException if a auto details with the primary key could not be found
	 */
	@Override
	public AutoDetails findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAutoDetailsException {
		AutoDetails autoDetails = fetchByPrimaryKey(primaryKey);

		if (autoDetails == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAutoDetailsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return autoDetails;
	}

	/**
	 * Returns the auto details with the primary key or throws a {@link NoSuchAutoDetailsException} if it could not be found.
	 *
	 * @param autodetailId the primary key of the auto details
	 * @return the auto details
	 * @throws NoSuchAutoDetailsException if a auto details with the primary key could not be found
	 */
	@Override
	public AutoDetails findByPrimaryKey(long autodetailId)
		throws NoSuchAutoDetailsException {
		return findByPrimaryKey((Serializable)autodetailId);
	}

	/**
	 * Returns the auto details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the auto details
	 * @return the auto details, or <code>null</code> if a auto details with the primary key could not be found
	 */
	@Override
	public AutoDetails fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(AutoDetailsModelImpl.ENTITY_CACHE_ENABLED,
				AutoDetailsImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		AutoDetails autoDetails = (AutoDetails)serializable;

		if (autoDetails == null) {
			Session session = null;

			try {
				session = openSession();

				autoDetails = (AutoDetails)session.get(AutoDetailsImpl.class,
						primaryKey);

				if (autoDetails != null) {
					cacheResult(autoDetails);
				}
				else {
					entityCache.putResult(AutoDetailsModelImpl.ENTITY_CACHE_ENABLED,
						AutoDetailsImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(AutoDetailsModelImpl.ENTITY_CACHE_ENABLED,
					AutoDetailsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return autoDetails;
	}

	/**
	 * Returns the auto details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param autodetailId the primary key of the auto details
	 * @return the auto details, or <code>null</code> if a auto details with the primary key could not be found
	 */
	@Override
	public AutoDetails fetchByPrimaryKey(long autodetailId) {
		return fetchByPrimaryKey((Serializable)autodetailId);
	}

	@Override
	public Map<Serializable, AutoDetails> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, AutoDetails> map = new HashMap<Serializable, AutoDetails>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			AutoDetails autoDetails = fetchByPrimaryKey(primaryKey);

			if (autoDetails != null) {
				map.put(primaryKey, autoDetails);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(AutoDetailsModelImpl.ENTITY_CACHE_ENABLED,
					AutoDetailsImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (AutoDetails)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_AUTODETAILS_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (AutoDetails autoDetails : (List<AutoDetails>)q.list()) {
				map.put(autoDetails.getPrimaryKeyObj(), autoDetails);

				cacheResult(autoDetails);

				uncachedPrimaryKeys.remove(autoDetails.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(AutoDetailsModelImpl.ENTITY_CACHE_ENABLED,
					AutoDetailsImpl.class, primaryKey, nullModel);
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
	 * Returns all the auto detailses.
	 *
	 * @return the auto detailses
	 */
	@Override
	public List<AutoDetails> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the auto detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AutoDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of auto detailses
	 * @param end the upper bound of the range of auto detailses (not inclusive)
	 * @return the range of auto detailses
	 */
	@Override
	public List<AutoDetails> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the auto detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AutoDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of auto detailses
	 * @param end the upper bound of the range of auto detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of auto detailses
	 */
	@Override
	public List<AutoDetails> findAll(int start, int end,
		OrderByComparator<AutoDetails> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the auto detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AutoDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of auto detailses
	 * @param end the upper bound of the range of auto detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of auto detailses
	 */
	@Override
	public List<AutoDetails> findAll(int start, int end,
		OrderByComparator<AutoDetails> orderByComparator,
		boolean retrieveFromCache) {
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

		List<AutoDetails> list = null;

		if (retrieveFromCache) {
			list = (List<AutoDetails>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_AUTODETAILS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_AUTODETAILS;

				if (pagination) {
					sql = sql.concat(AutoDetailsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AutoDetails>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AutoDetails>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the auto detailses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AutoDetails autoDetails : findAll()) {
			remove(autoDetails);
		}
	}

	/**
	 * Returns the number of auto detailses.
	 *
	 * @return the number of auto detailses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_AUTODETAILS);

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
		return AutoDetailsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the auto details persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(AutoDetailsImpl.class.getName());
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
	private static final String _SQL_SELECT_AUTODETAILS = "SELECT autoDetails FROM AutoDetails autoDetails";
	private static final String _SQL_SELECT_AUTODETAILS_WHERE_PKS_IN = "SELECT autoDetails FROM AutoDetails autoDetails WHERE autodetailId IN (";
	private static final String _SQL_SELECT_AUTODETAILS_WHERE = "SELECT autoDetails FROM AutoDetails autoDetails WHERE ";
	private static final String _SQL_COUNT_AUTODETAILS = "SELECT COUNT(autoDetails) FROM AutoDetails autoDetails";
	private static final String _SQL_COUNT_AUTODETAILS_WHERE = "SELECT COUNT(autoDetails) FROM AutoDetails autoDetails WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "autoDetails.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AutoDetails exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AutoDetails exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(AutoDetailsPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}