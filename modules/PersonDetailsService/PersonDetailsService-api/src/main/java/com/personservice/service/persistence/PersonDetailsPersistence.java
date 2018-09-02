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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.personservice.exception.NoSuchPersonDetailsException;

import com.personservice.model.PersonDetails;

/**
 * The persistence interface for the person details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.personservice.service.persistence.impl.PersonDetailsPersistenceImpl
 * @see PersonDetailsUtil
 * @generated
 */
@ProviderType
public interface PersonDetailsPersistence extends BasePersistence<PersonDetails> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PersonDetailsUtil} to access the person details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the person detailses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching person detailses
	*/
	public java.util.List<PersonDetails> findByUuid(java.lang.String uuid);

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
	public java.util.List<PersonDetails> findByUuid(java.lang.String uuid,
		int start, int end);

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
	public java.util.List<PersonDetails> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersonDetails> orderByComparator);

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
	public java.util.List<PersonDetails> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersonDetails> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first person details in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching person details
	* @throws NoSuchPersonDetailsException if a matching person details could not be found
	*/
	public PersonDetails findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PersonDetails> orderByComparator)
		throws NoSuchPersonDetailsException;

	/**
	* Returns the first person details in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching person details, or <code>null</code> if a matching person details could not be found
	*/
	public PersonDetails fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PersonDetails> orderByComparator);

	/**
	* Returns the last person details in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching person details
	* @throws NoSuchPersonDetailsException if a matching person details could not be found
	*/
	public PersonDetails findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PersonDetails> orderByComparator)
		throws NoSuchPersonDetailsException;

	/**
	* Returns the last person details in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching person details, or <code>null</code> if a matching person details could not be found
	*/
	public PersonDetails fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PersonDetails> orderByComparator);

	/**
	* Returns the person detailses before and after the current person details in the ordered set where uuid = &#63;.
	*
	* @param PersonDetailId the primary key of the current person details
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next person details
	* @throws NoSuchPersonDetailsException if a person details with the primary key could not be found
	*/
	public PersonDetails[] findByUuid_PrevAndNext(long PersonDetailId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PersonDetails> orderByComparator)
		throws NoSuchPersonDetailsException;

	/**
	* Removes all the person detailses where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of person detailses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching person detailses
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns the person details where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchPersonDetailsException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching person details
	* @throws NoSuchPersonDetailsException if a matching person details could not be found
	*/
	public PersonDetails findByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchPersonDetailsException;

	/**
	* Returns the person details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching person details, or <code>null</code> if a matching person details could not be found
	*/
	public PersonDetails fetchByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns the person details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching person details, or <code>null</code> if a matching person details could not be found
	*/
	public PersonDetails fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache);

	/**
	* Removes the person details where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the person details that was removed
	*/
	public PersonDetails removeByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchPersonDetailsException;

	/**
	* Returns the number of person detailses where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching person detailses
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns all the person detailses where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching person detailses
	*/
	public java.util.List<PersonDetails> findByUuid_C(java.lang.String uuid,
		long companyId);

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
	public java.util.List<PersonDetails> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end);

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
	public java.util.List<PersonDetails> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersonDetails> orderByComparator);

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
	public java.util.List<PersonDetails> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersonDetails> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first person details in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching person details
	* @throws NoSuchPersonDetailsException if a matching person details could not be found
	*/
	public PersonDetails findByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<PersonDetails> orderByComparator)
		throws NoSuchPersonDetailsException;

	/**
	* Returns the first person details in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching person details, or <code>null</code> if a matching person details could not be found
	*/
	public PersonDetails fetchByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<PersonDetails> orderByComparator);

	/**
	* Returns the last person details in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching person details
	* @throws NoSuchPersonDetailsException if a matching person details could not be found
	*/
	public PersonDetails findByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<PersonDetails> orderByComparator)
		throws NoSuchPersonDetailsException;

	/**
	* Returns the last person details in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching person details, or <code>null</code> if a matching person details could not be found
	*/
	public PersonDetails fetchByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<PersonDetails> orderByComparator);

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
	public PersonDetails[] findByUuid_C_PrevAndNext(long PersonDetailId,
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<PersonDetails> orderByComparator)
		throws NoSuchPersonDetailsException;

	/**
	* Removes all the person detailses where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of person detailses where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching person detailses
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns all the person detailses where userId = &#63; and FirstName = &#63;.
	*
	* @param userId the user ID
	* @param FirstName the first name
	* @return the matching person detailses
	*/
	public java.util.List<PersonDetails> findByUserIdAndFirstName(long userId,
		java.lang.String FirstName);

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
	public java.util.List<PersonDetails> findByUserIdAndFirstName(long userId,
		java.lang.String FirstName, int start, int end);

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
	public java.util.List<PersonDetails> findByUserIdAndFirstName(long userId,
		java.lang.String FirstName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersonDetails> orderByComparator);

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
	public java.util.List<PersonDetails> findByUserIdAndFirstName(long userId,
		java.lang.String FirstName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersonDetails> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first person details in the ordered set where userId = &#63; and FirstName = &#63;.
	*
	* @param userId the user ID
	* @param FirstName the first name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching person details
	* @throws NoSuchPersonDetailsException if a matching person details could not be found
	*/
	public PersonDetails findByUserIdAndFirstName_First(long userId,
		java.lang.String FirstName,
		com.liferay.portal.kernel.util.OrderByComparator<PersonDetails> orderByComparator)
		throws NoSuchPersonDetailsException;

	/**
	* Returns the first person details in the ordered set where userId = &#63; and FirstName = &#63;.
	*
	* @param userId the user ID
	* @param FirstName the first name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching person details, or <code>null</code> if a matching person details could not be found
	*/
	public PersonDetails fetchByUserIdAndFirstName_First(long userId,
		java.lang.String FirstName,
		com.liferay.portal.kernel.util.OrderByComparator<PersonDetails> orderByComparator);

	/**
	* Returns the last person details in the ordered set where userId = &#63; and FirstName = &#63;.
	*
	* @param userId the user ID
	* @param FirstName the first name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching person details
	* @throws NoSuchPersonDetailsException if a matching person details could not be found
	*/
	public PersonDetails findByUserIdAndFirstName_Last(long userId,
		java.lang.String FirstName,
		com.liferay.portal.kernel.util.OrderByComparator<PersonDetails> orderByComparator)
		throws NoSuchPersonDetailsException;

	/**
	* Returns the last person details in the ordered set where userId = &#63; and FirstName = &#63;.
	*
	* @param userId the user ID
	* @param FirstName the first name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching person details, or <code>null</code> if a matching person details could not be found
	*/
	public PersonDetails fetchByUserIdAndFirstName_Last(long userId,
		java.lang.String FirstName,
		com.liferay.portal.kernel.util.OrderByComparator<PersonDetails> orderByComparator);

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
	public PersonDetails[] findByUserIdAndFirstName_PrevAndNext(
		long PersonDetailId, long userId, java.lang.String FirstName,
		com.liferay.portal.kernel.util.OrderByComparator<PersonDetails> orderByComparator)
		throws NoSuchPersonDetailsException;

	/**
	* Removes all the person detailses where userId = &#63; and FirstName = &#63; from the database.
	*
	* @param userId the user ID
	* @param FirstName the first name
	*/
	public void removeByUserIdAndFirstName(long userId,
		java.lang.String FirstName);

	/**
	* Returns the number of person detailses where userId = &#63; and FirstName = &#63;.
	*
	* @param userId the user ID
	* @param FirstName the first name
	* @return the number of matching person detailses
	*/
	public int countByUserIdAndFirstName(long userId, java.lang.String FirstName);

	/**
	* Caches the person details in the entity cache if it is enabled.
	*
	* @param personDetails the person details
	*/
	public void cacheResult(PersonDetails personDetails);

	/**
	* Caches the person detailses in the entity cache if it is enabled.
	*
	* @param personDetailses the person detailses
	*/
	public void cacheResult(java.util.List<PersonDetails> personDetailses);

	/**
	* Creates a new person details with the primary key. Does not add the person details to the database.
	*
	* @param PersonDetailId the primary key for the new person details
	* @return the new person details
	*/
	public PersonDetails create(long PersonDetailId);

	/**
	* Removes the person details with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PersonDetailId the primary key of the person details
	* @return the person details that was removed
	* @throws NoSuchPersonDetailsException if a person details with the primary key could not be found
	*/
	public PersonDetails remove(long PersonDetailId)
		throws NoSuchPersonDetailsException;

	public PersonDetails updateImpl(PersonDetails personDetails);

	/**
	* Returns the person details with the primary key or throws a {@link NoSuchPersonDetailsException} if it could not be found.
	*
	* @param PersonDetailId the primary key of the person details
	* @return the person details
	* @throws NoSuchPersonDetailsException if a person details with the primary key could not be found
	*/
	public PersonDetails findByPrimaryKey(long PersonDetailId)
		throws NoSuchPersonDetailsException;

	/**
	* Returns the person details with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PersonDetailId the primary key of the person details
	* @return the person details, or <code>null</code> if a person details with the primary key could not be found
	*/
	public PersonDetails fetchByPrimaryKey(long PersonDetailId);

	@Override
	public java.util.Map<java.io.Serializable, PersonDetails> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the person detailses.
	*
	* @return the person detailses
	*/
	public java.util.List<PersonDetails> findAll();

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
	public java.util.List<PersonDetails> findAll(int start, int end);

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
	public java.util.List<PersonDetails> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersonDetails> orderByComparator);

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
	public java.util.List<PersonDetails> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersonDetails> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the person detailses from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of person detailses.
	*
	* @return the number of person detailses
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}