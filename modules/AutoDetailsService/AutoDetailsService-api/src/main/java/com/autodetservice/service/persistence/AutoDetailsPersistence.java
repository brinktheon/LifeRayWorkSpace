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

import com.autodetservice.exception.NoSuchAutoDetailsException;

import com.autodetservice.model.AutoDetails;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the auto details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.autodetservice.service.persistence.impl.AutoDetailsPersistenceImpl
 * @see AutoDetailsUtil
 * @generated
 */
@ProviderType
public interface AutoDetailsPersistence extends BasePersistence<AutoDetails> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AutoDetailsUtil} to access the auto details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the auto detailses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching auto detailses
	*/
	public java.util.List<AutoDetails> findByUuid(java.lang.String uuid);

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
	public java.util.List<AutoDetails> findByUuid(java.lang.String uuid,
		int start, int end);

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
	public java.util.List<AutoDetails> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AutoDetails> orderByComparator);

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
	public java.util.List<AutoDetails> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AutoDetails> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first auto details in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching auto details
	* @throws NoSuchAutoDetailsException if a matching auto details could not be found
	*/
	public AutoDetails findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AutoDetails> orderByComparator)
		throws NoSuchAutoDetailsException;

	/**
	* Returns the first auto details in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching auto details, or <code>null</code> if a matching auto details could not be found
	*/
	public AutoDetails fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AutoDetails> orderByComparator);

	/**
	* Returns the last auto details in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching auto details
	* @throws NoSuchAutoDetailsException if a matching auto details could not be found
	*/
	public AutoDetails findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AutoDetails> orderByComparator)
		throws NoSuchAutoDetailsException;

	/**
	* Returns the last auto details in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching auto details, or <code>null</code> if a matching auto details could not be found
	*/
	public AutoDetails fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AutoDetails> orderByComparator);

	/**
	* Returns the auto detailses before and after the current auto details in the ordered set where uuid = &#63;.
	*
	* @param autodetailId the primary key of the current auto details
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next auto details
	* @throws NoSuchAutoDetailsException if a auto details with the primary key could not be found
	*/
	public AutoDetails[] findByUuid_PrevAndNext(long autodetailId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AutoDetails> orderByComparator)
		throws NoSuchAutoDetailsException;

	/**
	* Removes all the auto detailses where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of auto detailses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching auto detailses
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns the auto details where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchAutoDetailsException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching auto details
	* @throws NoSuchAutoDetailsException if a matching auto details could not be found
	*/
	public AutoDetails findByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchAutoDetailsException;

	/**
	* Returns the auto details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching auto details, or <code>null</code> if a matching auto details could not be found
	*/
	public AutoDetails fetchByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns the auto details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching auto details, or <code>null</code> if a matching auto details could not be found
	*/
	public AutoDetails fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache);

	/**
	* Removes the auto details where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the auto details that was removed
	*/
	public AutoDetails removeByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchAutoDetailsException;

	/**
	* Returns the number of auto detailses where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching auto detailses
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns all the auto detailses where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching auto detailses
	*/
	public java.util.List<AutoDetails> findByUuid_C(java.lang.String uuid,
		long companyId);

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
	public java.util.List<AutoDetails> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end);

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
	public java.util.List<AutoDetails> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AutoDetails> orderByComparator);

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
	public java.util.List<AutoDetails> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AutoDetails> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first auto details in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching auto details
	* @throws NoSuchAutoDetailsException if a matching auto details could not be found
	*/
	public AutoDetails findByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AutoDetails> orderByComparator)
		throws NoSuchAutoDetailsException;

	/**
	* Returns the first auto details in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching auto details, or <code>null</code> if a matching auto details could not be found
	*/
	public AutoDetails fetchByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AutoDetails> orderByComparator);

	/**
	* Returns the last auto details in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching auto details
	* @throws NoSuchAutoDetailsException if a matching auto details could not be found
	*/
	public AutoDetails findByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AutoDetails> orderByComparator)
		throws NoSuchAutoDetailsException;

	/**
	* Returns the last auto details in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching auto details, or <code>null</code> if a matching auto details could not be found
	*/
	public AutoDetails fetchByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AutoDetails> orderByComparator);

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
	public AutoDetails[] findByUuid_C_PrevAndNext(long autodetailId,
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AutoDetails> orderByComparator)
		throws NoSuchAutoDetailsException;

	/**
	* Removes all the auto detailses where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of auto detailses where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching auto detailses
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns all the auto detailses where userId = &#63; and Model = &#63;.
	*
	* @param userId the user ID
	* @param Model the model
	* @return the matching auto detailses
	*/
	public java.util.List<AutoDetails> findByM_U(long userId,
		java.lang.String Model);

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
	public java.util.List<AutoDetails> findByM_U(long userId,
		java.lang.String Model, int start, int end);

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
	public java.util.List<AutoDetails> findByM_U(long userId,
		java.lang.String Model, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AutoDetails> orderByComparator);

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
	public java.util.List<AutoDetails> findByM_U(long userId,
		java.lang.String Model, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AutoDetails> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first auto details in the ordered set where userId = &#63; and Model = &#63;.
	*
	* @param userId the user ID
	* @param Model the model
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching auto details
	* @throws NoSuchAutoDetailsException if a matching auto details could not be found
	*/
	public AutoDetails findByM_U_First(long userId, java.lang.String Model,
		com.liferay.portal.kernel.util.OrderByComparator<AutoDetails> orderByComparator)
		throws NoSuchAutoDetailsException;

	/**
	* Returns the first auto details in the ordered set where userId = &#63; and Model = &#63;.
	*
	* @param userId the user ID
	* @param Model the model
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching auto details, or <code>null</code> if a matching auto details could not be found
	*/
	public AutoDetails fetchByM_U_First(long userId, java.lang.String Model,
		com.liferay.portal.kernel.util.OrderByComparator<AutoDetails> orderByComparator);

	/**
	* Returns the last auto details in the ordered set where userId = &#63; and Model = &#63;.
	*
	* @param userId the user ID
	* @param Model the model
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching auto details
	* @throws NoSuchAutoDetailsException if a matching auto details could not be found
	*/
	public AutoDetails findByM_U_Last(long userId, java.lang.String Model,
		com.liferay.portal.kernel.util.OrderByComparator<AutoDetails> orderByComparator)
		throws NoSuchAutoDetailsException;

	/**
	* Returns the last auto details in the ordered set where userId = &#63; and Model = &#63;.
	*
	* @param userId the user ID
	* @param Model the model
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching auto details, or <code>null</code> if a matching auto details could not be found
	*/
	public AutoDetails fetchByM_U_Last(long userId, java.lang.String Model,
		com.liferay.portal.kernel.util.OrderByComparator<AutoDetails> orderByComparator);

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
	public AutoDetails[] findByM_U_PrevAndNext(long autodetailId, long userId,
		java.lang.String Model,
		com.liferay.portal.kernel.util.OrderByComparator<AutoDetails> orderByComparator)
		throws NoSuchAutoDetailsException;

	/**
	* Removes all the auto detailses where userId = &#63; and Model = &#63; from the database.
	*
	* @param userId the user ID
	* @param Model the model
	*/
	public void removeByM_U(long userId, java.lang.String Model);

	/**
	* Returns the number of auto detailses where userId = &#63; and Model = &#63;.
	*
	* @param userId the user ID
	* @param Model the model
	* @return the number of matching auto detailses
	*/
	public int countByM_U(long userId, java.lang.String Model);

	/**
	* Returns all the auto detailses where userId = &#63; and Year = &#63;.
	*
	* @param userId the user ID
	* @param Year the year
	* @return the matching auto detailses
	*/
	public java.util.List<AutoDetails> findByY_U(long userId, int Year);

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
	public java.util.List<AutoDetails> findByY_U(long userId, int Year,
		int start, int end);

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
	public java.util.List<AutoDetails> findByY_U(long userId, int Year,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AutoDetails> orderByComparator);

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
	public java.util.List<AutoDetails> findByY_U(long userId, int Year,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AutoDetails> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first auto details in the ordered set where userId = &#63; and Year = &#63;.
	*
	* @param userId the user ID
	* @param Year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching auto details
	* @throws NoSuchAutoDetailsException if a matching auto details could not be found
	*/
	public AutoDetails findByY_U_First(long userId, int Year,
		com.liferay.portal.kernel.util.OrderByComparator<AutoDetails> orderByComparator)
		throws NoSuchAutoDetailsException;

	/**
	* Returns the first auto details in the ordered set where userId = &#63; and Year = &#63;.
	*
	* @param userId the user ID
	* @param Year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching auto details, or <code>null</code> if a matching auto details could not be found
	*/
	public AutoDetails fetchByY_U_First(long userId, int Year,
		com.liferay.portal.kernel.util.OrderByComparator<AutoDetails> orderByComparator);

	/**
	* Returns the last auto details in the ordered set where userId = &#63; and Year = &#63;.
	*
	* @param userId the user ID
	* @param Year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching auto details
	* @throws NoSuchAutoDetailsException if a matching auto details could not be found
	*/
	public AutoDetails findByY_U_Last(long userId, int Year,
		com.liferay.portal.kernel.util.OrderByComparator<AutoDetails> orderByComparator)
		throws NoSuchAutoDetailsException;

	/**
	* Returns the last auto details in the ordered set where userId = &#63; and Year = &#63;.
	*
	* @param userId the user ID
	* @param Year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching auto details, or <code>null</code> if a matching auto details could not be found
	*/
	public AutoDetails fetchByY_U_Last(long userId, int Year,
		com.liferay.portal.kernel.util.OrderByComparator<AutoDetails> orderByComparator);

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
	public AutoDetails[] findByY_U_PrevAndNext(long autodetailId, long userId,
		int Year,
		com.liferay.portal.kernel.util.OrderByComparator<AutoDetails> orderByComparator)
		throws NoSuchAutoDetailsException;

	/**
	* Removes all the auto detailses where userId = &#63; and Year = &#63; from the database.
	*
	* @param userId the user ID
	* @param Year the year
	*/
	public void removeByY_U(long userId, int Year);

	/**
	* Returns the number of auto detailses where userId = &#63; and Year = &#63;.
	*
	* @param userId the user ID
	* @param Year the year
	* @return the number of matching auto detailses
	*/
	public int countByY_U(long userId, int Year);

	/**
	* Caches the auto details in the entity cache if it is enabled.
	*
	* @param autoDetails the auto details
	*/
	public void cacheResult(AutoDetails autoDetails);

	/**
	* Caches the auto detailses in the entity cache if it is enabled.
	*
	* @param autoDetailses the auto detailses
	*/
	public void cacheResult(java.util.List<AutoDetails> autoDetailses);

	/**
	* Creates a new auto details with the primary key. Does not add the auto details to the database.
	*
	* @param autodetailId the primary key for the new auto details
	* @return the new auto details
	*/
	public AutoDetails create(long autodetailId);

	/**
	* Removes the auto details with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param autodetailId the primary key of the auto details
	* @return the auto details that was removed
	* @throws NoSuchAutoDetailsException if a auto details with the primary key could not be found
	*/
	public AutoDetails remove(long autodetailId)
		throws NoSuchAutoDetailsException;

	public AutoDetails updateImpl(AutoDetails autoDetails);

	/**
	* Returns the auto details with the primary key or throws a {@link NoSuchAutoDetailsException} if it could not be found.
	*
	* @param autodetailId the primary key of the auto details
	* @return the auto details
	* @throws NoSuchAutoDetailsException if a auto details with the primary key could not be found
	*/
	public AutoDetails findByPrimaryKey(long autodetailId)
		throws NoSuchAutoDetailsException;

	/**
	* Returns the auto details with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param autodetailId the primary key of the auto details
	* @return the auto details, or <code>null</code> if a auto details with the primary key could not be found
	*/
	public AutoDetails fetchByPrimaryKey(long autodetailId);

	@Override
	public java.util.Map<java.io.Serializable, AutoDetails> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the auto detailses.
	*
	* @return the auto detailses
	*/
	public java.util.List<AutoDetails> findAll();

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
	public java.util.List<AutoDetails> findAll(int start, int end);

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
	public java.util.List<AutoDetails> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AutoDetails> orderByComparator);

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
	public java.util.List<AutoDetails> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AutoDetails> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the auto detailses from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of auto detailses.
	*
	* @return the number of auto detailses
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}