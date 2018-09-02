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

package com.personservice.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.personservice.model.PersonDetails;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the person details service. This utility wraps {@link com.personservice.service.persistence.impl.PersonDetailsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersonDetailsPersistence
 * @see com.personservice.service.persistence.impl.PersonDetailsPersistenceImpl
 * @generated
 */
@ProviderType
public class PersonDetailsUtil {
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
	public static void clearCache(PersonDetails personDetails) {
		getPersistence().clearCache(personDetails);
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
	public static List<PersonDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PersonDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PersonDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PersonDetails> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PersonDetails update(PersonDetails personDetails) {
		return getPersistence().update(personDetails);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PersonDetails update(PersonDetails personDetails,
		ServiceContext serviceContext) {
		return getPersistence().update(personDetails, serviceContext);
	}

	/**
	* Returns all the person detailses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching person detailses
	*/
	public static List<PersonDetails> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
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
	public static List<PersonDetails> findByUuid(java.lang.String uuid,
		int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
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
	public static List<PersonDetails> findByUuid(java.lang.String uuid,
		int start, int end, OrderByComparator<PersonDetails> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
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
	public static List<PersonDetails> findByUuid(java.lang.String uuid,
		int start, int end, OrderByComparator<PersonDetails> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first person details in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching person details
	* @throws NoSuchPersonDetailsException if a matching person details could not be found
	*/
	public static PersonDetails findByUuid_First(java.lang.String uuid,
		OrderByComparator<PersonDetails> orderByComparator)
		throws com.personservice.exception.NoSuchPersonDetailsException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first person details in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching person details, or <code>null</code> if a matching person details could not be found
	*/
	public static PersonDetails fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<PersonDetails> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last person details in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching person details
	* @throws NoSuchPersonDetailsException if a matching person details could not be found
	*/
	public static PersonDetails findByUuid_Last(java.lang.String uuid,
		OrderByComparator<PersonDetails> orderByComparator)
		throws com.personservice.exception.NoSuchPersonDetailsException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last person details in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching person details, or <code>null</code> if a matching person details could not be found
	*/
	public static PersonDetails fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<PersonDetails> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
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
	public static PersonDetails[] findByUuid_PrevAndNext(long PersonDetailId,
		java.lang.String uuid,
		OrderByComparator<PersonDetails> orderByComparator)
		throws com.personservice.exception.NoSuchPersonDetailsException {
		return getPersistence()
				   .findByUuid_PrevAndNext(PersonDetailId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the person detailses where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of person detailses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching person detailses
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the person details where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchPersonDetailsException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching person details
	* @throws NoSuchPersonDetailsException if a matching person details could not be found
	*/
	public static PersonDetails findByUUID_G(java.lang.String uuid, long groupId)
		throws com.personservice.exception.NoSuchPersonDetailsException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the person details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching person details, or <code>null</code> if a matching person details could not be found
	*/
	public static PersonDetails fetchByUUID_G(java.lang.String uuid,
		long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the person details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching person details, or <code>null</code> if a matching person details could not be found
	*/
	public static PersonDetails fetchByUUID_G(java.lang.String uuid,
		long groupId, boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the person details where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the person details that was removed
	*/
	public static PersonDetails removeByUUID_G(java.lang.String uuid,
		long groupId)
		throws com.personservice.exception.NoSuchPersonDetailsException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of person detailses where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching person detailses
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the person detailses where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching person detailses
	*/
	public static List<PersonDetails> findByUuid_C(java.lang.String uuid,
		long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
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
	public static List<PersonDetails> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
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
	public static List<PersonDetails> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<PersonDetails> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
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
	public static List<PersonDetails> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<PersonDetails> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
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
	public static PersonDetails findByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<PersonDetails> orderByComparator)
		throws com.personservice.exception.NoSuchPersonDetailsException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first person details in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching person details, or <code>null</code> if a matching person details could not be found
	*/
	public static PersonDetails fetchByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<PersonDetails> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
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
	public static PersonDetails findByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<PersonDetails> orderByComparator)
		throws com.personservice.exception.NoSuchPersonDetailsException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last person details in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching person details, or <code>null</code> if a matching person details could not be found
	*/
	public static PersonDetails fetchByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<PersonDetails> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
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
	public static PersonDetails[] findByUuid_C_PrevAndNext(
		long PersonDetailId, java.lang.String uuid, long companyId,
		OrderByComparator<PersonDetails> orderByComparator)
		throws com.personservice.exception.NoSuchPersonDetailsException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(PersonDetailId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the person detailses where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of person detailses where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching person detailses
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the person detailses where userId = &#63; and FirstName = &#63;.
	*
	* @param userId the user ID
	* @param FirstName the first name
	* @return the matching person detailses
	*/
	public static List<PersonDetails> findByUserIdAndFirstName(long userId,
		java.lang.String FirstName) {
		return getPersistence().findByUserIdAndFirstName(userId, FirstName);
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
	public static List<PersonDetails> findByUserIdAndFirstName(long userId,
		java.lang.String FirstName, int start, int end) {
		return getPersistence()
				   .findByUserIdAndFirstName(userId, FirstName, start, end);
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
	public static List<PersonDetails> findByUserIdAndFirstName(long userId,
		java.lang.String FirstName, int start, int end,
		OrderByComparator<PersonDetails> orderByComparator) {
		return getPersistence()
				   .findByUserIdAndFirstName(userId, FirstName, start, end,
			orderByComparator);
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
	public static List<PersonDetails> findByUserIdAndFirstName(long userId,
		java.lang.String FirstName, int start, int end,
		OrderByComparator<PersonDetails> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUserIdAndFirstName(userId, FirstName, start, end,
			orderByComparator, retrieveFromCache);
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
	public static PersonDetails findByUserIdAndFirstName_First(long userId,
		java.lang.String FirstName,
		OrderByComparator<PersonDetails> orderByComparator)
		throws com.personservice.exception.NoSuchPersonDetailsException {
		return getPersistence()
				   .findByUserIdAndFirstName_First(userId, FirstName,
			orderByComparator);
	}

	/**
	* Returns the first person details in the ordered set where userId = &#63; and FirstName = &#63;.
	*
	* @param userId the user ID
	* @param FirstName the first name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching person details, or <code>null</code> if a matching person details could not be found
	*/
	public static PersonDetails fetchByUserIdAndFirstName_First(long userId,
		java.lang.String FirstName,
		OrderByComparator<PersonDetails> orderByComparator) {
		return getPersistence()
				   .fetchByUserIdAndFirstName_First(userId, FirstName,
			orderByComparator);
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
	public static PersonDetails findByUserIdAndFirstName_Last(long userId,
		java.lang.String FirstName,
		OrderByComparator<PersonDetails> orderByComparator)
		throws com.personservice.exception.NoSuchPersonDetailsException {
		return getPersistence()
				   .findByUserIdAndFirstName_Last(userId, FirstName,
			orderByComparator);
	}

	/**
	* Returns the last person details in the ordered set where userId = &#63; and FirstName = &#63;.
	*
	* @param userId the user ID
	* @param FirstName the first name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching person details, or <code>null</code> if a matching person details could not be found
	*/
	public static PersonDetails fetchByUserIdAndFirstName_Last(long userId,
		java.lang.String FirstName,
		OrderByComparator<PersonDetails> orderByComparator) {
		return getPersistence()
				   .fetchByUserIdAndFirstName_Last(userId, FirstName,
			orderByComparator);
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
	public static PersonDetails[] findByUserIdAndFirstName_PrevAndNext(
		long PersonDetailId, long userId, java.lang.String FirstName,
		OrderByComparator<PersonDetails> orderByComparator)
		throws com.personservice.exception.NoSuchPersonDetailsException {
		return getPersistence()
				   .findByUserIdAndFirstName_PrevAndNext(PersonDetailId,
			userId, FirstName, orderByComparator);
	}

	/**
	* Removes all the person detailses where userId = &#63; and FirstName = &#63; from the database.
	*
	* @param userId the user ID
	* @param FirstName the first name
	*/
	public static void removeByUserIdAndFirstName(long userId,
		java.lang.String FirstName) {
		getPersistence().removeByUserIdAndFirstName(userId, FirstName);
	}

	/**
	* Returns the number of person detailses where userId = &#63; and FirstName = &#63;.
	*
	* @param userId the user ID
	* @param FirstName the first name
	* @return the number of matching person detailses
	*/
	public static int countByUserIdAndFirstName(long userId,
		java.lang.String FirstName) {
		return getPersistence().countByUserIdAndFirstName(userId, FirstName);
	}

	/**
	* Caches the person details in the entity cache if it is enabled.
	*
	* @param personDetails the person details
	*/
	public static void cacheResult(PersonDetails personDetails) {
		getPersistence().cacheResult(personDetails);
	}

	/**
	* Caches the person detailses in the entity cache if it is enabled.
	*
	* @param personDetailses the person detailses
	*/
	public static void cacheResult(List<PersonDetails> personDetailses) {
		getPersistence().cacheResult(personDetailses);
	}

	/**
	* Creates a new person details with the primary key. Does not add the person details to the database.
	*
	* @param PersonDetailId the primary key for the new person details
	* @return the new person details
	*/
	public static PersonDetails create(long PersonDetailId) {
		return getPersistence().create(PersonDetailId);
	}

	/**
	* Removes the person details with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PersonDetailId the primary key of the person details
	* @return the person details that was removed
	* @throws NoSuchPersonDetailsException if a person details with the primary key could not be found
	*/
	public static PersonDetails remove(long PersonDetailId)
		throws com.personservice.exception.NoSuchPersonDetailsException {
		return getPersistence().remove(PersonDetailId);
	}

	public static PersonDetails updateImpl(PersonDetails personDetails) {
		return getPersistence().updateImpl(personDetails);
	}

	/**
	* Returns the person details with the primary key or throws a {@link NoSuchPersonDetailsException} if it could not be found.
	*
	* @param PersonDetailId the primary key of the person details
	* @return the person details
	* @throws NoSuchPersonDetailsException if a person details with the primary key could not be found
	*/
	public static PersonDetails findByPrimaryKey(long PersonDetailId)
		throws com.personservice.exception.NoSuchPersonDetailsException {
		return getPersistence().findByPrimaryKey(PersonDetailId);
	}

	/**
	* Returns the person details with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PersonDetailId the primary key of the person details
	* @return the person details, or <code>null</code> if a person details with the primary key could not be found
	*/
	public static PersonDetails fetchByPrimaryKey(long PersonDetailId) {
		return getPersistence().fetchByPrimaryKey(PersonDetailId);
	}

	public static java.util.Map<java.io.Serializable, PersonDetails> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the person detailses.
	*
	* @return the person detailses
	*/
	public static List<PersonDetails> findAll() {
		return getPersistence().findAll();
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
	public static List<PersonDetails> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<PersonDetails> findAll(int start, int end,
		OrderByComparator<PersonDetails> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<PersonDetails> findAll(int start, int end,
		OrderByComparator<PersonDetails> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the person detailses from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of person detailses.
	*
	* @return the number of person detailses
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static PersonDetailsPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PersonDetailsPersistence, PersonDetailsPersistence> _serviceTracker =
		ServiceTrackerFactory.open(PersonDetailsPersistence.class);
}