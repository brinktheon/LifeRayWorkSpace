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

package com.personservice.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for PersonDetails. This utility wraps
 * {@link com.personservice.service.impl.PersonDetailsLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see PersonDetailsLocalService
 * @see com.personservice.service.base.PersonDetailsLocalServiceBaseImpl
 * @see com.personservice.service.impl.PersonDetailsLocalServiceImpl
 * @generated
 */
@ProviderType
public class PersonDetailsLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.personservice.service.impl.PersonDetailsLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the person details to the database. Also notifies the appropriate model listeners.
	*
	* @param personDetails the person details
	* @return the person details that was added
	*/
	public static com.personservice.model.PersonDetails addPersonDetails(
		com.personservice.model.PersonDetails personDetails) {
		return getService().addPersonDetails(personDetails);
	}

	/**
	* Creates a new person details with the primary key. Does not add the person details to the database.
	*
	* @param PersonDetailId the primary key for the new person details
	* @return the new person details
	*/
	public static com.personservice.model.PersonDetails createPersonDetails(
		long PersonDetailId) {
		return getService().createPersonDetails(PersonDetailId);
	}

	/**
	* Deletes the person details from the database. Also notifies the appropriate model listeners.
	*
	* @param personDetails the person details
	* @return the person details that was removed
	*/
	public static com.personservice.model.PersonDetails deletePersonDetails(
		com.personservice.model.PersonDetails personDetails) {
		return getService().deletePersonDetails(personDetails);
	}

	/**
	* Deletes the person details with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PersonDetailId the primary key of the person details
	* @return the person details that was removed
	* @throws PortalException if a person details with the primary key could not be found
	*/
	public static com.personservice.model.PersonDetails deletePersonDetails(
		long PersonDetailId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersonDetails(PersonDetailId);
	}

	public static com.personservice.model.PersonDetails fetchPersonDetails(
		long PersonDetailId) {
		return getService().fetchPersonDetails(PersonDetailId);
	}

	/**
	* Returns the person details matching the UUID and group.
	*
	* @param uuid the person details's UUID
	* @param groupId the primary key of the group
	* @return the matching person details, or <code>null</code> if a matching person details could not be found
	*/
	public static com.personservice.model.PersonDetails fetchPersonDetailsByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return getService().fetchPersonDetailsByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the person details with the primary key.
	*
	* @param PersonDetailId the primary key of the person details
	* @return the person details
	* @throws PortalException if a person details with the primary key could not be found
	*/
	public static com.personservice.model.PersonDetails getPersonDetails(
		long PersonDetailId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersonDetails(PersonDetailId);
	}

	/**
	* Returns the person details matching the UUID and group.
	*
	* @param uuid the person details's UUID
	* @param groupId the primary key of the group
	* @return the matching person details
	* @throws PortalException if a matching person details could not be found
	*/
	public static com.personservice.model.PersonDetails getPersonDetailsByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersonDetailsByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Updates the person details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param personDetails the person details
	* @return the person details that was updated
	*/
	public static com.personservice.model.PersonDetails updatePersonDetails(
		com.personservice.model.PersonDetails personDetails) {
		return getService().updatePersonDetails(personDetails);
	}

	/**
	* Returns the number of person detailses.
	*
	* @return the number of person detailses
	*/
	public static int getPersonDetailsesCount() {
		return getService().getPersonDetailsesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.personservice.model.impl.PersonDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.personservice.model.impl.PersonDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static java.util.List<com.personservice.model.PersonDetails> findAll() {
		return getService().findAll();
	}

	public static java.util.List<com.personservice.model.PersonDetails> findByComparator(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.personservice.model.PersonDetails> orderByComparator) {
		return getService().findByComparator(start, end, orderByComparator);
	}

	/**
	* Returns a range of all the person detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.personservice.model.impl.PersonDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of person detailses
	* @param end the upper bound of the range of person detailses (not inclusive)
	* @return the range of person detailses
	*/
	public static java.util.List<com.personservice.model.PersonDetails> getPersonDetailses(
		int start, int end) {
		return getService().getPersonDetailses(start, end);
	}

	/**
	* Returns all the person detailses matching the UUID and company.
	*
	* @param uuid the UUID of the person detailses
	* @param companyId the primary key of the company
	* @return the matching person detailses, or an empty list if no matches were found
	*/
	public static java.util.List<com.personservice.model.PersonDetails> getPersonDetailsesByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return getService().getPersonDetailsesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns a range of person detailses matching the UUID and company.
	*
	* @param uuid the UUID of the person detailses
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of person detailses
	* @param end the upper bound of the range of person detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching person detailses, or an empty list if no matches were found
	*/
	public static java.util.List<com.personservice.model.PersonDetails> getPersonDetailsesByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.personservice.model.PersonDetails> orderByComparator) {
		return getService()
				   .getPersonDetailsesByUuidAndCompanyId(uuid, companyId,
			start, end, orderByComparator);
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

	public static PersonDetailsLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PersonDetailsLocalService, PersonDetailsLocalService> _serviceTracker =
		ServiceTrackerFactory.open(PersonDetailsLocalService.class);
}