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

package com.personservice.service.persistence.impl;

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
import com.liferay.portal.kernel.util.ReflectionUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.personservice.exception.NoSuchPersonDetailsException;

import com.personservice.model.PersonDetails;
import com.personservice.model.impl.PersonDetailsImpl;
import com.personservice.model.impl.PersonDetailsModelImpl;

import com.personservice.service.persistence.PersonDetailsPersistence;

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
 * The persistence implementation for the person details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersonDetailsPersistence
 * @see com.personservice.service.persistence.PersonDetailsUtil
 * @generated
 */
@ProviderType
public class PersonDetailsPersistenceImpl extends BasePersistenceImpl<PersonDetails>
	implements PersonDetailsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PersonDetailsUtil} to access the person details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PersonDetailsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PersonDetailsModelImpl.ENTITY_CACHE_ENABLED,
			PersonDetailsModelImpl.FINDER_CACHE_ENABLED,
			PersonDetailsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PersonDetailsModelImpl.ENTITY_CACHE_ENABLED,
			PersonDetailsModelImpl.FINDER_CACHE_ENABLED,
			PersonDetailsImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PersonDetailsModelImpl.ENTITY_CACHE_ENABLED,
			PersonDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(PersonDetailsModelImpl.ENTITY_CACHE_ENABLED,
			PersonDetailsModelImpl.FINDER_CACHE_ENABLED,
			PersonDetailsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(PersonDetailsModelImpl.ENTITY_CACHE_ENABLED,
			PersonDetailsModelImpl.FINDER_CACHE_ENABLED,
			PersonDetailsImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUuid", new String[] { String.class.getName() },
			PersonDetailsModelImpl.UUID_COLUMN_BITMASK |
			PersonDetailsModelImpl.FIRSTNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(PersonDetailsModelImpl.ENTITY_CACHE_ENABLED,
			PersonDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the person detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching person detailses
	 */
	@Override
	public List<PersonDetails> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the person detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PersonDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of person detailses
	 * @param end the upper bound of the range of person detailses (not inclusive)
	 * @return the range of matching person detailses
	 */
	@Override
	public List<PersonDetails> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the person detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PersonDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of person detailses
	 * @param end the upper bound of the range of person detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching person detailses
	 */
	@Override
	public List<PersonDetails> findByUuid(String uuid, int start, int end,
		OrderByComparator<PersonDetails> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the person detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PersonDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of person detailses
	 * @param end the upper bound of the range of person detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching person detailses
	 */
	@Override
	public List<PersonDetails> findByUuid(String uuid, int start, int end,
		OrderByComparator<PersonDetails> orderByComparator,
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

		List<PersonDetails> list = null;

		if (retrieveFromCache) {
			list = (List<PersonDetails>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PersonDetails personDetails : list) {
					if (!Objects.equals(uuid, personDetails.getUuid())) {
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

			query.append(_SQL_SELECT_PERSONDETAILS_WHERE);

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
				query.append(PersonDetailsModelImpl.ORDER_BY_JPQL);
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
					list = (List<PersonDetails>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<PersonDetails>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first person details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching person details
	 * @throws NoSuchPersonDetailsException if a matching person details could not be found
	 */
	@Override
	public PersonDetails findByUuid_First(String uuid,
		OrderByComparator<PersonDetails> orderByComparator)
		throws NoSuchPersonDetailsException {
		PersonDetails personDetails = fetchByUuid_First(uuid, orderByComparator);

		if (personDetails != null) {
			return personDetails;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPersonDetailsException(msg.toString());
	}

	/**
	 * Returns the first person details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching person details, or <code>null</code> if a matching person details could not be found
	 */
	@Override
	public PersonDetails fetchByUuid_First(String uuid,
		OrderByComparator<PersonDetails> orderByComparator) {
		List<PersonDetails> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last person details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching person details
	 * @throws NoSuchPersonDetailsException if a matching person details could not be found
	 */
	@Override
	public PersonDetails findByUuid_Last(String uuid,
		OrderByComparator<PersonDetails> orderByComparator)
		throws NoSuchPersonDetailsException {
		PersonDetails personDetails = fetchByUuid_Last(uuid, orderByComparator);

		if (personDetails != null) {
			return personDetails;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPersonDetailsException(msg.toString());
	}

	/**
	 * Returns the last person details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching person details, or <code>null</code> if a matching person details could not be found
	 */
	@Override
	public PersonDetails fetchByUuid_Last(String uuid,
		OrderByComparator<PersonDetails> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<PersonDetails> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the person detailses before and after the current person details in the ordered set where uuid = &#63;.
	 *
	 * @param PersonDetailId the primary key of the current person details
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next person details
	 * @throws NoSuchPersonDetailsException if a person details with the primary key could not be found
	 */
	@Override
	public PersonDetails[] findByUuid_PrevAndNext(long PersonDetailId,
		String uuid, OrderByComparator<PersonDetails> orderByComparator)
		throws NoSuchPersonDetailsException {
		PersonDetails personDetails = findByPrimaryKey(PersonDetailId);

		Session session = null;

		try {
			session = openSession();

			PersonDetails[] array = new PersonDetailsImpl[3];

			array[0] = getByUuid_PrevAndNext(session, personDetails, uuid,
					orderByComparator, true);

			array[1] = personDetails;

			array[2] = getByUuid_PrevAndNext(session, personDetails, uuid,
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

	protected PersonDetails getByUuid_PrevAndNext(Session session,
		PersonDetails personDetails, String uuid,
		OrderByComparator<PersonDetails> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PERSONDETAILS_WHERE);

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
			query.append(PersonDetailsModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(personDetails);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PersonDetails> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the person detailses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (PersonDetails personDetails : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(personDetails);
		}
	}

	/**
	 * Returns the number of person detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching person detailses
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PERSONDETAILS_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "personDetails.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "personDetails.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(personDetails.uuid IS NULL OR personDetails.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(PersonDetailsModelImpl.ENTITY_CACHE_ENABLED,
			PersonDetailsModelImpl.FINDER_CACHE_ENABLED,
			PersonDetailsImpl.class, FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			PersonDetailsModelImpl.UUID_COLUMN_BITMASK |
			PersonDetailsModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(PersonDetailsModelImpl.ENTITY_CACHE_ENABLED,
			PersonDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the person details where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchPersonDetailsException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching person details
	 * @throws NoSuchPersonDetailsException if a matching person details could not be found
	 */
	@Override
	public PersonDetails findByUUID_G(String uuid, long groupId)
		throws NoSuchPersonDetailsException {
		PersonDetails personDetails = fetchByUUID_G(uuid, groupId);

		if (personDetails == null) {
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

			throw new NoSuchPersonDetailsException(msg.toString());
		}

		return personDetails;
	}

	/**
	 * Returns the person details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching person details, or <code>null</code> if a matching person details could not be found
	 */
	@Override
	public PersonDetails fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the person details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching person details, or <code>null</code> if a matching person details could not be found
	 */
	@Override
	public PersonDetails fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof PersonDetails) {
			PersonDetails personDetails = (PersonDetails)result;

			if (!Objects.equals(uuid, personDetails.getUuid()) ||
					(groupId != personDetails.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_PERSONDETAILS_WHERE);

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

				List<PersonDetails> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					PersonDetails personDetails = list.get(0);

					result = personDetails;

					cacheResult(personDetails);

					if ((personDetails.getUuid() == null) ||
							!personDetails.getUuid().equals(uuid) ||
							(personDetails.getGroupId() != groupId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, personDetails);
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
			return (PersonDetails)result;
		}
	}

	/**
	 * Removes the person details where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the person details that was removed
	 */
	@Override
	public PersonDetails removeByUUID_G(String uuid, long groupId)
		throws NoSuchPersonDetailsException {
		PersonDetails personDetails = findByUUID_G(uuid, groupId);

		return remove(personDetails);
	}

	/**
	 * Returns the number of person detailses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching person detailses
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PERSONDETAILS_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "personDetails.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "personDetails.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(personDetails.uuid IS NULL OR personDetails.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "personDetails.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(PersonDetailsModelImpl.ENTITY_CACHE_ENABLED,
			PersonDetailsModelImpl.FINDER_CACHE_ENABLED,
			PersonDetailsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(PersonDetailsModelImpl.ENTITY_CACHE_ENABLED,
			PersonDetailsModelImpl.FINDER_CACHE_ENABLED,
			PersonDetailsImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			PersonDetailsModelImpl.UUID_COLUMN_BITMASK |
			PersonDetailsModelImpl.COMPANYID_COLUMN_BITMASK |
			PersonDetailsModelImpl.FIRSTNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(PersonDetailsModelImpl.ENTITY_CACHE_ENABLED,
			PersonDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the person detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching person detailses
	 */
	@Override
	public List<PersonDetails> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the person detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PersonDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of person detailses
	 * @param end the upper bound of the range of person detailses (not inclusive)
	 * @return the range of matching person detailses
	 */
	@Override
	public List<PersonDetails> findByUuid_C(String uuid, long companyId,
		int start, int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the person detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PersonDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of person detailses
	 * @param end the upper bound of the range of person detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching person detailses
	 */
	@Override
	public List<PersonDetails> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<PersonDetails> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the person detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PersonDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of person detailses
	 * @param end the upper bound of the range of person detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching person detailses
	 */
	@Override
	public List<PersonDetails> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<PersonDetails> orderByComparator,
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

		List<PersonDetails> list = null;

		if (retrieveFromCache) {
			list = (List<PersonDetails>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PersonDetails personDetails : list) {
					if (!Objects.equals(uuid, personDetails.getUuid()) ||
							(companyId != personDetails.getCompanyId())) {
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

			query.append(_SQL_SELECT_PERSONDETAILS_WHERE);

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
				query.append(PersonDetailsModelImpl.ORDER_BY_JPQL);
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
					list = (List<PersonDetails>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<PersonDetails>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first person details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching person details
	 * @throws NoSuchPersonDetailsException if a matching person details could not be found
	 */
	@Override
	public PersonDetails findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<PersonDetails> orderByComparator)
		throws NoSuchPersonDetailsException {
		PersonDetails personDetails = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (personDetails != null) {
			return personDetails;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPersonDetailsException(msg.toString());
	}

	/**
	 * Returns the first person details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching person details, or <code>null</code> if a matching person details could not be found
	 */
	@Override
	public PersonDetails fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<PersonDetails> orderByComparator) {
		List<PersonDetails> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last person details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching person details
	 * @throws NoSuchPersonDetailsException if a matching person details could not be found
	 */
	@Override
	public PersonDetails findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<PersonDetails> orderByComparator)
		throws NoSuchPersonDetailsException {
		PersonDetails personDetails = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (personDetails != null) {
			return personDetails;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPersonDetailsException(msg.toString());
	}

	/**
	 * Returns the last person details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching person details, or <code>null</code> if a matching person details could not be found
	 */
	@Override
	public PersonDetails fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<PersonDetails> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<PersonDetails> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the person detailses before and after the current person details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param PersonDetailId the primary key of the current person details
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next person details
	 * @throws NoSuchPersonDetailsException if a person details with the primary key could not be found
	 */
	@Override
	public PersonDetails[] findByUuid_C_PrevAndNext(long PersonDetailId,
		String uuid, long companyId,
		OrderByComparator<PersonDetails> orderByComparator)
		throws NoSuchPersonDetailsException {
		PersonDetails personDetails = findByPrimaryKey(PersonDetailId);

		Session session = null;

		try {
			session = openSession();

			PersonDetails[] array = new PersonDetailsImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, personDetails, uuid,
					companyId, orderByComparator, true);

			array[1] = personDetails;

			array[2] = getByUuid_C_PrevAndNext(session, personDetails, uuid,
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

	protected PersonDetails getByUuid_C_PrevAndNext(Session session,
		PersonDetails personDetails, String uuid, long companyId,
		OrderByComparator<PersonDetails> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_PERSONDETAILS_WHERE);

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
			query.append(PersonDetailsModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(personDetails);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PersonDetails> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the person detailses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (PersonDetails personDetails : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(personDetails);
		}
	}

	/**
	 * Returns the number of person detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching person detailses
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PERSONDETAILS_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "personDetails.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "personDetails.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(personDetails.uuid IS NULL OR personDetails.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "personDetails.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDANDFIRSTNAME =
		new FinderPath(PersonDetailsModelImpl.ENTITY_CACHE_ENABLED,
			PersonDetailsModelImpl.FINDER_CACHE_ENABLED,
			PersonDetailsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUserIdAndFirstName",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDFIRSTNAME =
		new FinderPath(PersonDetailsModelImpl.ENTITY_CACHE_ENABLED,
			PersonDetailsModelImpl.FINDER_CACHE_ENABLED,
			PersonDetailsImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUserIdAndFirstName",
			new String[] { Long.class.getName(), String.class.getName() },
			PersonDetailsModelImpl.USERID_COLUMN_BITMASK |
			PersonDetailsModelImpl.FIRSTNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERIDANDFIRSTNAME = new FinderPath(PersonDetailsModelImpl.ENTITY_CACHE_ENABLED,
			PersonDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUserIdAndFirstName",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the person detailses where userId = &#63; and FirstName = &#63;.
	 *
	 * @param userId the user ID
	 * @param FirstName the first name
	 * @return the matching person detailses
	 */
	@Override
	public List<PersonDetails> findByUserIdAndFirstName(long userId,
		String FirstName) {
		return findByUserIdAndFirstName(userId, FirstName, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the person detailses where userId = &#63; and FirstName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PersonDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param FirstName the first name
	 * @param start the lower bound of the range of person detailses
	 * @param end the upper bound of the range of person detailses (not inclusive)
	 * @return the range of matching person detailses
	 */
	@Override
	public List<PersonDetails> findByUserIdAndFirstName(long userId,
		String FirstName, int start, int end) {
		return findByUserIdAndFirstName(userId, FirstName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the person detailses where userId = &#63; and FirstName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PersonDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param FirstName the first name
	 * @param start the lower bound of the range of person detailses
	 * @param end the upper bound of the range of person detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching person detailses
	 */
	@Override
	public List<PersonDetails> findByUserIdAndFirstName(long userId,
		String FirstName, int start, int end,
		OrderByComparator<PersonDetails> orderByComparator) {
		return findByUserIdAndFirstName(userId, FirstName, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the person detailses where userId = &#63; and FirstName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PersonDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param FirstName the first name
	 * @param start the lower bound of the range of person detailses
	 * @param end the upper bound of the range of person detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching person detailses
	 */
	@Override
	public List<PersonDetails> findByUserIdAndFirstName(long userId,
		String FirstName, int start, int end,
		OrderByComparator<PersonDetails> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDFIRSTNAME;
			finderArgs = new Object[] { userId, FirstName };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDANDFIRSTNAME;
			finderArgs = new Object[] {
					userId, FirstName,
					
					start, end, orderByComparator
				};
		}

		List<PersonDetails> list = null;

		if (retrieveFromCache) {
			list = (List<PersonDetails>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PersonDetails personDetails : list) {
					if ((userId != personDetails.getUserId()) ||
							!Objects.equals(FirstName,
								personDetails.getFirstName())) {
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

			query.append(_SQL_SELECT_PERSONDETAILS_WHERE);

			query.append(_FINDER_COLUMN_USERIDANDFIRSTNAME_USERID_2);

			boolean bindFirstName = false;

			if (FirstName == null) {
				query.append(_FINDER_COLUMN_USERIDANDFIRSTNAME_FIRSTNAME_1);
			}
			else if (FirstName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USERIDANDFIRSTNAME_FIRSTNAME_3);
			}
			else {
				bindFirstName = true;

				query.append(_FINDER_COLUMN_USERIDANDFIRSTNAME_FIRSTNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PersonDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (bindFirstName) {
					qPos.add(FirstName);
				}

				if (!pagination) {
					list = (List<PersonDetails>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<PersonDetails>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first person details in the ordered set where userId = &#63; and FirstName = &#63;.
	 *
	 * @param userId the user ID
	 * @param FirstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching person details
	 * @throws NoSuchPersonDetailsException if a matching person details could not be found
	 */
	@Override
	public PersonDetails findByUserIdAndFirstName_First(long userId,
		String FirstName, OrderByComparator<PersonDetails> orderByComparator)
		throws NoSuchPersonDetailsException {
		PersonDetails personDetails = fetchByUserIdAndFirstName_First(userId,
				FirstName, orderByComparator);

		if (personDetails != null) {
			return personDetails;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", FirstName=");
		msg.append(FirstName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPersonDetailsException(msg.toString());
	}

	/**
	 * Returns the first person details in the ordered set where userId = &#63; and FirstName = &#63;.
	 *
	 * @param userId the user ID
	 * @param FirstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching person details, or <code>null</code> if a matching person details could not be found
	 */
	@Override
	public PersonDetails fetchByUserIdAndFirstName_First(long userId,
		String FirstName, OrderByComparator<PersonDetails> orderByComparator) {
		List<PersonDetails> list = findByUserIdAndFirstName(userId, FirstName,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last person details in the ordered set where userId = &#63; and FirstName = &#63;.
	 *
	 * @param userId the user ID
	 * @param FirstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching person details
	 * @throws NoSuchPersonDetailsException if a matching person details could not be found
	 */
	@Override
	public PersonDetails findByUserIdAndFirstName_Last(long userId,
		String FirstName, OrderByComparator<PersonDetails> orderByComparator)
		throws NoSuchPersonDetailsException {
		PersonDetails personDetails = fetchByUserIdAndFirstName_Last(userId,
				FirstName, orderByComparator);

		if (personDetails != null) {
			return personDetails;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", FirstName=");
		msg.append(FirstName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPersonDetailsException(msg.toString());
	}

	/**
	 * Returns the last person details in the ordered set where userId = &#63; and FirstName = &#63;.
	 *
	 * @param userId the user ID
	 * @param FirstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching person details, or <code>null</code> if a matching person details could not be found
	 */
	@Override
	public PersonDetails fetchByUserIdAndFirstName_Last(long userId,
		String FirstName, OrderByComparator<PersonDetails> orderByComparator) {
		int count = countByUserIdAndFirstName(userId, FirstName);

		if (count == 0) {
			return null;
		}

		List<PersonDetails> list = findByUserIdAndFirstName(userId, FirstName,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the person detailses before and after the current person details in the ordered set where userId = &#63; and FirstName = &#63;.
	 *
	 * @param PersonDetailId the primary key of the current person details
	 * @param userId the user ID
	 * @param FirstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next person details
	 * @throws NoSuchPersonDetailsException if a person details with the primary key could not be found
	 */
	@Override
	public PersonDetails[] findByUserIdAndFirstName_PrevAndNext(
		long PersonDetailId, long userId, String FirstName,
		OrderByComparator<PersonDetails> orderByComparator)
		throws NoSuchPersonDetailsException {
		PersonDetails personDetails = findByPrimaryKey(PersonDetailId);

		Session session = null;

		try {
			session = openSession();

			PersonDetails[] array = new PersonDetailsImpl[3];

			array[0] = getByUserIdAndFirstName_PrevAndNext(session,
					personDetails, userId, FirstName, orderByComparator, true);

			array[1] = personDetails;

			array[2] = getByUserIdAndFirstName_PrevAndNext(session,
					personDetails, userId, FirstName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PersonDetails getByUserIdAndFirstName_PrevAndNext(
		Session session, PersonDetails personDetails, long userId,
		String FirstName, OrderByComparator<PersonDetails> orderByComparator,
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

		query.append(_SQL_SELECT_PERSONDETAILS_WHERE);

		query.append(_FINDER_COLUMN_USERIDANDFIRSTNAME_USERID_2);

		boolean bindFirstName = false;

		if (FirstName == null) {
			query.append(_FINDER_COLUMN_USERIDANDFIRSTNAME_FIRSTNAME_1);
		}
		else if (FirstName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_USERIDANDFIRSTNAME_FIRSTNAME_3);
		}
		else {
			bindFirstName = true;

			query.append(_FINDER_COLUMN_USERIDANDFIRSTNAME_FIRSTNAME_2);
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
			query.append(PersonDetailsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (bindFirstName) {
			qPos.add(FirstName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(personDetails);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PersonDetails> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the person detailses where userId = &#63; and FirstName = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param FirstName the first name
	 */
	@Override
	public void removeByUserIdAndFirstName(long userId, String FirstName) {
		for (PersonDetails personDetails : findByUserIdAndFirstName(userId,
				FirstName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(personDetails);
		}
	}

	/**
	 * Returns the number of person detailses where userId = &#63; and FirstName = &#63;.
	 *
	 * @param userId the user ID
	 * @param FirstName the first name
	 * @return the number of matching person detailses
	 */
	@Override
	public int countByUserIdAndFirstName(long userId, String FirstName) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERIDANDFIRSTNAME;

		Object[] finderArgs = new Object[] { userId, FirstName };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PERSONDETAILS_WHERE);

			query.append(_FINDER_COLUMN_USERIDANDFIRSTNAME_USERID_2);

			boolean bindFirstName = false;

			if (FirstName == null) {
				query.append(_FINDER_COLUMN_USERIDANDFIRSTNAME_FIRSTNAME_1);
			}
			else if (FirstName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USERIDANDFIRSTNAME_FIRSTNAME_3);
			}
			else {
				bindFirstName = true;

				query.append(_FINDER_COLUMN_USERIDANDFIRSTNAME_FIRSTNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (bindFirstName) {
					qPos.add(FirstName);
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

	private static final String _FINDER_COLUMN_USERIDANDFIRSTNAME_USERID_2 = "personDetails.userId = ? AND ";
	private static final String _FINDER_COLUMN_USERIDANDFIRSTNAME_FIRSTNAME_1 = "personDetails.FirstName IS NULL";
	private static final String _FINDER_COLUMN_USERIDANDFIRSTNAME_FIRSTNAME_2 = "personDetails.FirstName = ?";
	private static final String _FINDER_COLUMN_USERIDANDFIRSTNAME_FIRSTNAME_3 = "(personDetails.FirstName IS NULL OR personDetails.FirstName = '')";

	public PersonDetailsPersistenceImpl() {
		setModelClass(PersonDetails.class);

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
	 * Caches the person details in the entity cache if it is enabled.
	 *
	 * @param personDetails the person details
	 */
	@Override
	public void cacheResult(PersonDetails personDetails) {
		entityCache.putResult(PersonDetailsModelImpl.ENTITY_CACHE_ENABLED,
			PersonDetailsImpl.class, personDetails.getPrimaryKey(),
			personDetails);

		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { personDetails.getUuid(), personDetails.getGroupId() },
			personDetails);

		personDetails.resetOriginalValues();
	}

	/**
	 * Caches the person detailses in the entity cache if it is enabled.
	 *
	 * @param personDetailses the person detailses
	 */
	@Override
	public void cacheResult(List<PersonDetails> personDetailses) {
		for (PersonDetails personDetails : personDetailses) {
			if (entityCache.getResult(
						PersonDetailsModelImpl.ENTITY_CACHE_ENABLED,
						PersonDetailsImpl.class, personDetails.getPrimaryKey()) == null) {
				cacheResult(personDetails);
			}
			else {
				personDetails.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all person detailses.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PersonDetailsImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the person details.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PersonDetails personDetails) {
		entityCache.removeResult(PersonDetailsModelImpl.ENTITY_CACHE_ENABLED,
			PersonDetailsImpl.class, personDetails.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((PersonDetailsModelImpl)personDetails, true);
	}

	@Override
	public void clearCache(List<PersonDetails> personDetailses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PersonDetails personDetails : personDetailses) {
			entityCache.removeResult(PersonDetailsModelImpl.ENTITY_CACHE_ENABLED,
				PersonDetailsImpl.class, personDetails.getPrimaryKey());

			clearUniqueFindersCache((PersonDetailsModelImpl)personDetails, true);
		}
	}

	protected void cacheUniqueFindersCache(
		PersonDetailsModelImpl personDetailsModelImpl) {
		Object[] args = new Object[] {
				personDetailsModelImpl.getUuid(),
				personDetailsModelImpl.getGroupId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
			personDetailsModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		PersonDetailsModelImpl personDetailsModelImpl, boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					personDetailsModelImpl.getUuid(),
					personDetailsModelImpl.getGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		if ((personDetailsModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					personDetailsModelImpl.getOriginalUuid(),
					personDetailsModelImpl.getOriginalGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new person details with the primary key. Does not add the person details to the database.
	 *
	 * @param PersonDetailId the primary key for the new person details
	 * @return the new person details
	 */
	@Override
	public PersonDetails create(long PersonDetailId) {
		PersonDetails personDetails = new PersonDetailsImpl();

		personDetails.setNew(true);
		personDetails.setPrimaryKey(PersonDetailId);

		String uuid = PortalUUIDUtil.generate();

		personDetails.setUuid(uuid);

		personDetails.setCompanyId(companyProvider.getCompanyId());

		return personDetails;
	}

	/**
	 * Removes the person details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param PersonDetailId the primary key of the person details
	 * @return the person details that was removed
	 * @throws NoSuchPersonDetailsException if a person details with the primary key could not be found
	 */
	@Override
	public PersonDetails remove(long PersonDetailId)
		throws NoSuchPersonDetailsException {
		return remove((Serializable)PersonDetailId);
	}

	/**
	 * Removes the person details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the person details
	 * @return the person details that was removed
	 * @throws NoSuchPersonDetailsException if a person details with the primary key could not be found
	 */
	@Override
	public PersonDetails remove(Serializable primaryKey)
		throws NoSuchPersonDetailsException {
		Session session = null;

		try {
			session = openSession();

			PersonDetails personDetails = (PersonDetails)session.get(PersonDetailsImpl.class,
					primaryKey);

			if (personDetails == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPersonDetailsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(personDetails);
		}
		catch (NoSuchPersonDetailsException nsee) {
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
	protected PersonDetails removeImpl(PersonDetails personDetails) {
		personDetails = toUnwrappedModel(personDetails);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(personDetails)) {
				personDetails = (PersonDetails)session.get(PersonDetailsImpl.class,
						personDetails.getPrimaryKeyObj());
			}

			if (personDetails != null) {
				session.delete(personDetails);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (personDetails != null) {
			clearCache(personDetails);
		}

		return personDetails;
	}

	@Override
	public PersonDetails updateImpl(PersonDetails personDetails) {
		personDetails = toUnwrappedModel(personDetails);

		boolean isNew = personDetails.isNew();

		PersonDetailsModelImpl personDetailsModelImpl = (PersonDetailsModelImpl)personDetails;

		if (Validator.isNull(personDetails.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			personDetails.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (personDetails.getCreateDate() == null)) {
			if (serviceContext == null) {
				personDetails.setCreateDate(now);
			}
			else {
				personDetails.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!personDetailsModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				personDetails.setModifiedDate(now);
			}
			else {
				personDetails.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (personDetails.isNew()) {
				session.save(personDetails);

				personDetails.setNew(false);
			}
			else {
				personDetails = (PersonDetails)session.merge(personDetails);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!PersonDetailsModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { personDetailsModelImpl.getUuid() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] {
					personDetailsModelImpl.getUuid(),
					personDetailsModelImpl.getCompanyId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
				args);

			args = new Object[] {
					personDetailsModelImpl.getUserId(),
					personDetailsModelImpl.getFirstName()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_USERIDANDFIRSTNAME,
				args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDFIRSTNAME,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((personDetailsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						personDetailsModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { personDetailsModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((personDetailsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						personDetailsModelImpl.getOriginalUuid(),
						personDetailsModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						personDetailsModelImpl.getUuid(),
						personDetailsModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((personDetailsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDFIRSTNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						personDetailsModelImpl.getOriginalUserId(),
						personDetailsModelImpl.getOriginalFirstName()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USERIDANDFIRSTNAME,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDFIRSTNAME,
					args);

				args = new Object[] {
						personDetailsModelImpl.getUserId(),
						personDetailsModelImpl.getFirstName()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USERIDANDFIRSTNAME,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDFIRSTNAME,
					args);
			}
		}

		entityCache.putResult(PersonDetailsModelImpl.ENTITY_CACHE_ENABLED,
			PersonDetailsImpl.class, personDetails.getPrimaryKey(),
			personDetails, false);

		clearUniqueFindersCache(personDetailsModelImpl, false);
		cacheUniqueFindersCache(personDetailsModelImpl);

		personDetails.resetOriginalValues();

		return personDetails;
	}

	protected PersonDetails toUnwrappedModel(PersonDetails personDetails) {
		if (personDetails instanceof PersonDetailsImpl) {
			return personDetails;
		}

		PersonDetailsImpl personDetailsImpl = new PersonDetailsImpl();

		personDetailsImpl.setNew(personDetails.isNew());
		personDetailsImpl.setPrimaryKey(personDetails.getPrimaryKey());

		personDetailsImpl.setUuid(personDetails.getUuid());
		personDetailsImpl.setPersonDetailId(personDetails.getPersonDetailId());
		personDetailsImpl.setGroupId(personDetails.getGroupId());
		personDetailsImpl.setCompanyId(personDetails.getCompanyId());
		personDetailsImpl.setUserId(personDetails.getUserId());
		personDetailsImpl.setUserName(personDetails.getUserName());
		personDetailsImpl.setCreateDate(personDetails.getCreateDate());
		personDetailsImpl.setModifiedDate(personDetails.getModifiedDate());
		personDetailsImpl.setFirstName(personDetails.getFirstName());
		personDetailsImpl.setSecondName(personDetails.getSecondName());
		personDetailsImpl.setAge(personDetails.getAge());
		personDetailsImpl.setSpecialty(personDetails.getSpecialty());
		personDetailsImpl.setExperience(personDetails.getExperience());

		return personDetailsImpl;
	}

	/**
	 * Returns the person details with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the person details
	 * @return the person details
	 * @throws NoSuchPersonDetailsException if a person details with the primary key could not be found
	 */
	@Override
	public PersonDetails findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPersonDetailsException {
		PersonDetails personDetails = fetchByPrimaryKey(primaryKey);

		if (personDetails == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPersonDetailsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return personDetails;
	}

	/**
	 * Returns the person details with the primary key or throws a {@link NoSuchPersonDetailsException} if it could not be found.
	 *
	 * @param PersonDetailId the primary key of the person details
	 * @return the person details
	 * @throws NoSuchPersonDetailsException if a person details with the primary key could not be found
	 */
	@Override
	public PersonDetails findByPrimaryKey(long PersonDetailId)
		throws NoSuchPersonDetailsException {
		return findByPrimaryKey((Serializable)PersonDetailId);
	}

	/**
	 * Returns the person details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the person details
	 * @return the person details, or <code>null</code> if a person details with the primary key could not be found
	 */
	@Override
	public PersonDetails fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(PersonDetailsModelImpl.ENTITY_CACHE_ENABLED,
				PersonDetailsImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		PersonDetails personDetails = (PersonDetails)serializable;

		if (personDetails == null) {
			Session session = null;

			try {
				session = openSession();

				personDetails = (PersonDetails)session.get(PersonDetailsImpl.class,
						primaryKey);

				if (personDetails != null) {
					cacheResult(personDetails);
				}
				else {
					entityCache.putResult(PersonDetailsModelImpl.ENTITY_CACHE_ENABLED,
						PersonDetailsImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(PersonDetailsModelImpl.ENTITY_CACHE_ENABLED,
					PersonDetailsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return personDetails;
	}

	/**
	 * Returns the person details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param PersonDetailId the primary key of the person details
	 * @return the person details, or <code>null</code> if a person details with the primary key could not be found
	 */
	@Override
	public PersonDetails fetchByPrimaryKey(long PersonDetailId) {
		return fetchByPrimaryKey((Serializable)PersonDetailId);
	}

	@Override
	public Map<Serializable, PersonDetails> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, PersonDetails> map = new HashMap<Serializable, PersonDetails>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			PersonDetails personDetails = fetchByPrimaryKey(primaryKey);

			if (personDetails != null) {
				map.put(primaryKey, personDetails);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(PersonDetailsModelImpl.ENTITY_CACHE_ENABLED,
					PersonDetailsImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (PersonDetails)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_PERSONDETAILS_WHERE_PKS_IN);

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

			for (PersonDetails personDetails : (List<PersonDetails>)q.list()) {
				map.put(personDetails.getPrimaryKeyObj(), personDetails);

				cacheResult(personDetails);

				uncachedPrimaryKeys.remove(personDetails.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(PersonDetailsModelImpl.ENTITY_CACHE_ENABLED,
					PersonDetailsImpl.class, primaryKey, nullModel);
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
	 * Returns all the person detailses.
	 *
	 * @return the person detailses
	 */
	@Override
	public List<PersonDetails> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the person detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PersonDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of person detailses
	 * @param end the upper bound of the range of person detailses (not inclusive)
	 * @return the range of person detailses
	 */
	@Override
	public List<PersonDetails> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the person detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PersonDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of person detailses
	 * @param end the upper bound of the range of person detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of person detailses
	 */
	@Override
	public List<PersonDetails> findAll(int start, int end,
		OrderByComparator<PersonDetails> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the person detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PersonDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of person detailses
	 * @param end the upper bound of the range of person detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of person detailses
	 */
	@Override
	public List<PersonDetails> findAll(int start, int end,
		OrderByComparator<PersonDetails> orderByComparator,
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

		List<PersonDetails> list = null;

		if (retrieveFromCache) {
			list = (List<PersonDetails>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PERSONDETAILS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PERSONDETAILS;

				if (pagination) {
					sql = sql.concat(PersonDetailsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<PersonDetails>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<PersonDetails>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the person detailses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PersonDetails personDetails : findAll()) {
			remove(personDetails);
		}
	}

	/**
	 * Returns the number of person detailses.
	 *
	 * @return the number of person detailses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PERSONDETAILS);

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
		return PersonDetailsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the person details persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(PersonDetailsImpl.class.getName());
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
	private static final String _SQL_SELECT_PERSONDETAILS = "SELECT personDetails FROM PersonDetails personDetails";
	private static final String _SQL_SELECT_PERSONDETAILS_WHERE_PKS_IN = "SELECT personDetails FROM PersonDetails personDetails WHERE PersonDetailId IN (";
	private static final String _SQL_SELECT_PERSONDETAILS_WHERE = "SELECT personDetails FROM PersonDetails personDetails WHERE ";
	private static final String _SQL_COUNT_PERSONDETAILS = "SELECT COUNT(personDetails) FROM PersonDetails personDetails";
	private static final String _SQL_COUNT_PERSONDETAILS_WHERE = "SELECT COUNT(personDetails) FROM PersonDetails personDetails WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "personDetails.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PersonDetails exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No PersonDetails exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(PersonDetailsPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}