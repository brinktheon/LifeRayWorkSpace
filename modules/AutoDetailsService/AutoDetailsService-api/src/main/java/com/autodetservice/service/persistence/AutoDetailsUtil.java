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

package com.autodetservice.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.autodetservice.model.AutoDetails;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the auto details service. This utility wraps {@link com.autodetservice.service.persistence.impl.AutoDetailsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AutoDetailsPersistence
 * @see com.autodetservice.service.persistence.impl.AutoDetailsPersistenceImpl
 * @generated
 */
@ProviderType
public class AutoDetailsUtil {
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
	public static void clearCache(AutoDetails autoDetails) {
		getPersistence().clearCache(autoDetails);
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
	public static List<AutoDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AutoDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AutoDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AutoDetails> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AutoDetails update(AutoDetails autoDetails) {
		return getPersistence().update(autoDetails);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AutoDetails update(AutoDetails autoDetails,
		ServiceContext serviceContext) {
		return getPersistence().update(autoDetails, serviceContext);
	}

	/**
	* Returns all the auto detailses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching auto detailses
	*/
	public static List<AutoDetails> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
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
	public static List<AutoDetails> findByUuid(java.lang.String uuid,
		int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
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
	public static List<AutoDetails> findByUuid(java.lang.String uuid,
		int start, int end, OrderByComparator<AutoDetails> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
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
	public static List<AutoDetails> findByUuid(java.lang.String uuid,
		int start, int end, OrderByComparator<AutoDetails> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first auto details in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching auto details
	* @throws NoSuchAutoDetailsException if a matching auto details could not be found
	*/
	public static AutoDetails findByUuid_First(java.lang.String uuid,
		OrderByComparator<AutoDetails> orderByComparator)
		throws com.autodetservice.exception.NoSuchAutoDetailsException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first auto details in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching auto details, or <code>null</code> if a matching auto details could not be found
	*/
	public static AutoDetails fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<AutoDetails> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last auto details in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching auto details
	* @throws NoSuchAutoDetailsException if a matching auto details could not be found
	*/
	public static AutoDetails findByUuid_Last(java.lang.String uuid,
		OrderByComparator<AutoDetails> orderByComparator)
		throws com.autodetservice.exception.NoSuchAutoDetailsException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last auto details in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching auto details, or <code>null</code> if a matching auto details could not be found
	*/
	public static AutoDetails fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<AutoDetails> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
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
	public static AutoDetails[] findByUuid_PrevAndNext(long autodetailId,
		java.lang.String uuid, OrderByComparator<AutoDetails> orderByComparator)
		throws com.autodetservice.exception.NoSuchAutoDetailsException {
		return getPersistence()
				   .findByUuid_PrevAndNext(autodetailId, uuid, orderByComparator);
	}

	/**
	* Removes all the auto detailses where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of auto detailses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching auto detailses
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the auto details where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchAutoDetailsException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching auto details
	* @throws NoSuchAutoDetailsException if a matching auto details could not be found
	*/
	public static AutoDetails findByUUID_G(java.lang.String uuid, long groupId)
		throws com.autodetservice.exception.NoSuchAutoDetailsException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the auto details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching auto details, or <code>null</code> if a matching auto details could not be found
	*/
	public static AutoDetails fetchByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the auto details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching auto details, or <code>null</code> if a matching auto details could not be found
	*/
	public static AutoDetails fetchByUUID_G(java.lang.String uuid,
		long groupId, boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the auto details where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the auto details that was removed
	*/
	public static AutoDetails removeByUUID_G(java.lang.String uuid, long groupId)
		throws com.autodetservice.exception.NoSuchAutoDetailsException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of auto detailses where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching auto detailses
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the auto detailses where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching auto detailses
	*/
	public static List<AutoDetails> findByUuid_C(java.lang.String uuid,
		long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
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
	public static List<AutoDetails> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
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
	public static List<AutoDetails> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<AutoDetails> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
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
	public static List<AutoDetails> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<AutoDetails> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
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
	public static AutoDetails findByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<AutoDetails> orderByComparator)
		throws com.autodetservice.exception.NoSuchAutoDetailsException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first auto details in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching auto details, or <code>null</code> if a matching auto details could not be found
	*/
	public static AutoDetails fetchByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<AutoDetails> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
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
	public static AutoDetails findByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<AutoDetails> orderByComparator)
		throws com.autodetservice.exception.NoSuchAutoDetailsException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last auto details in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching auto details, or <code>null</code> if a matching auto details could not be found
	*/
	public static AutoDetails fetchByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<AutoDetails> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
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
	public static AutoDetails[] findByUuid_C_PrevAndNext(long autodetailId,
		java.lang.String uuid, long companyId,
		OrderByComparator<AutoDetails> orderByComparator)
		throws com.autodetservice.exception.NoSuchAutoDetailsException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(autodetailId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the auto detailses where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of auto detailses where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching auto detailses
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Caches the auto details in the entity cache if it is enabled.
	*
	* @param autoDetails the auto details
	*/
	public static void cacheResult(AutoDetails autoDetails) {
		getPersistence().cacheResult(autoDetails);
	}

	/**
	* Caches the auto detailses in the entity cache if it is enabled.
	*
	* @param autoDetailses the auto detailses
	*/
	public static void cacheResult(List<AutoDetails> autoDetailses) {
		getPersistence().cacheResult(autoDetailses);
	}

	/**
	* Creates a new auto details with the primary key. Does not add the auto details to the database.
	*
	* @param autodetailId the primary key for the new auto details
	* @return the new auto details
	*/
	public static AutoDetails create(long autodetailId) {
		return getPersistence().create(autodetailId);
	}

	/**
	* Removes the auto details with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param autodetailId the primary key of the auto details
	* @return the auto details that was removed
	* @throws NoSuchAutoDetailsException if a auto details with the primary key could not be found
	*/
	public static AutoDetails remove(long autodetailId)
		throws com.autodetservice.exception.NoSuchAutoDetailsException {
		return getPersistence().remove(autodetailId);
	}

	public static AutoDetails updateImpl(AutoDetails autoDetails) {
		return getPersistence().updateImpl(autoDetails);
	}

	/**
	* Returns the auto details with the primary key or throws a {@link NoSuchAutoDetailsException} if it could not be found.
	*
	* @param autodetailId the primary key of the auto details
	* @return the auto details
	* @throws NoSuchAutoDetailsException if a auto details with the primary key could not be found
	*/
	public static AutoDetails findByPrimaryKey(long autodetailId)
		throws com.autodetservice.exception.NoSuchAutoDetailsException {
		return getPersistence().findByPrimaryKey(autodetailId);
	}

	/**
	* Returns the auto details with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param autodetailId the primary key of the auto details
	* @return the auto details, or <code>null</code> if a auto details with the primary key could not be found
	*/
	public static AutoDetails fetchByPrimaryKey(long autodetailId) {
		return getPersistence().fetchByPrimaryKey(autodetailId);
	}

	public static java.util.Map<java.io.Serializable, AutoDetails> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the auto detailses.
	*
	* @return the auto detailses
	*/
	public static List<AutoDetails> findAll() {
		return getPersistence().findAll();
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
	public static List<AutoDetails> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<AutoDetails> findAll(int start, int end,
		OrderByComparator<AutoDetails> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<AutoDetails> findAll(int start, int end,
		OrderByComparator<AutoDetails> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the auto detailses from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of auto detailses.
	*
	* @return the number of auto detailses
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static AutoDetailsPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AutoDetailsPersistence, AutoDetailsPersistence> _serviceTracker =
		ServiceTrackerFactory.open(AutoDetailsPersistence.class);
}