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

package com.autodetservice.service.base;

import aQute.bnd.annotation.ProviderType;

import com.autodetservice.model.AutoDetails;

import com.autodetservice.service.AutoDetailsLocalService;
import com.autodetservice.service.persistence.AutoDetailsPersistence;

import com.liferay.exportimport.kernel.lar.ExportImportHelperUtil;
import com.liferay.exportimport.kernel.lar.ManifestSummary;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalServiceRegistry;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the auto details local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.autodetservice.service.impl.AutoDetailsLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.autodetservice.service.impl.AutoDetailsLocalServiceImpl
 * @see com.autodetservice.service.AutoDetailsLocalServiceUtil
 * @generated
 */
@ProviderType
public abstract class AutoDetailsLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements AutoDetailsLocalService,
		IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.autodetservice.service.AutoDetailsLocalServiceUtil} to access the auto details local service.
	 */

	/**
	 * Adds the auto details to the database. Also notifies the appropriate model listeners.
	 *
	 * @param autoDetails the auto details
	 * @return the auto details that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public AutoDetails addAutoDetails(AutoDetails autoDetails) {
		autoDetails.setNew(true);

		return autoDetailsPersistence.update(autoDetails);
	}

	/**
	 * Creates a new auto details with the primary key. Does not add the auto details to the database.
	 *
	 * @param autodetailId the primary key for the new auto details
	 * @return the new auto details
	 */
	@Override
	public AutoDetails createAutoDetails(long autodetailId) {
		return autoDetailsPersistence.create(autodetailId);
	}

	/**
	 * Deletes the auto details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param autodetailId the primary key of the auto details
	 * @return the auto details that was removed
	 * @throws PortalException if a auto details with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public AutoDetails deleteAutoDetails(long autodetailId)
		throws PortalException {
		return autoDetailsPersistence.remove(autodetailId);
	}

	/**
	 * Deletes the auto details from the database. Also notifies the appropriate model listeners.
	 *
	 * @param autoDetails the auto details
	 * @return the auto details that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public AutoDetails deleteAutoDetails(AutoDetails autoDetails) {
		return autoDetailsPersistence.remove(autoDetails);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(AutoDetails.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return autoDetailsPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.autodetservice.model.impl.AutoDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end) {
		return autoDetailsPersistence.findWithDynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.autodetservice.model.impl.AutoDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator) {
		return autoDetailsPersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return autoDetailsPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) {
		return autoDetailsPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public AutoDetails fetchAutoDetails(long autodetailId) {
		return autoDetailsPersistence.fetchByPrimaryKey(autodetailId);
	}

	/**
	 * Returns the auto details matching the UUID and group.
	 *
	 * @param uuid the auto details's UUID
	 * @param groupId the primary key of the group
	 * @return the matching auto details, or <code>null</code> if a matching auto details could not be found
	 */
	@Override
	public AutoDetails fetchAutoDetailsByUuidAndGroupId(String uuid,
		long groupId) {
		return autoDetailsPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the auto details with the primary key.
	 *
	 * @param autodetailId the primary key of the auto details
	 * @return the auto details
	 * @throws PortalException if a auto details with the primary key could not be found
	 */
	@Override
	public AutoDetails getAutoDetails(long autodetailId)
		throws PortalException {
		return autoDetailsPersistence.findByPrimaryKey(autodetailId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery = new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(autoDetailsLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(AutoDetails.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("autodetailId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		IndexableActionableDynamicQuery indexableActionableDynamicQuery = new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(autoDetailsLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(AutoDetails.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"autodetailId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {
		actionableDynamicQuery.setBaseLocalService(autoDetailsLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(AutoDetails.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("autodetailId");
	}

	@Override
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		final PortletDataContext portletDataContext) {
		final ExportActionableDynamicQuery exportActionableDynamicQuery = new ExportActionableDynamicQuery() {
				@Override
				public long performCount() throws PortalException {
					ManifestSummary manifestSummary = portletDataContext.getManifestSummary();

					StagedModelType stagedModelType = getStagedModelType();

					long modelAdditionCount = super.performCount();

					manifestSummary.addModelAdditionCount(stagedModelType,
						modelAdditionCount);

					long modelDeletionCount = ExportImportHelperUtil.getModelDeletionCount(portletDataContext,
							stagedModelType);

					manifestSummary.addModelDeletionCount(stagedModelType,
						modelDeletionCount);

					return modelAdditionCount;
				}
			};

		initActionableDynamicQuery(exportActionableDynamicQuery);

		exportActionableDynamicQuery.setAddCriteriaMethod(new ActionableDynamicQuery.AddCriteriaMethod() {
				@Override
				public void addCriteria(DynamicQuery dynamicQuery) {
					portletDataContext.addDateRangeCriteria(dynamicQuery,
						"modifiedDate");
				}
			});

		exportActionableDynamicQuery.setCompanyId(portletDataContext.getCompanyId());

		exportActionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<AutoDetails>() {
				@Override
				public void performAction(AutoDetails autoDetails)
					throws PortalException {
					StagedModelDataHandlerUtil.exportStagedModel(portletDataContext,
						autoDetails);
				}
			});
		exportActionableDynamicQuery.setStagedModelType(new StagedModelType(
				PortalUtil.getClassNameId(AutoDetails.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {
		return autoDetailsLocalService.deleteAutoDetails((AutoDetails)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {
		return autoDetailsPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the auto detailses matching the UUID and company.
	 *
	 * @param uuid the UUID of the auto detailses
	 * @param companyId the primary key of the company
	 * @return the matching auto detailses, or an empty list if no matches were found
	 */
	@Override
	public List<AutoDetails> getAutoDetailsesByUuidAndCompanyId(String uuid,
		long companyId) {
		return autoDetailsPersistence.findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of auto detailses matching the UUID and company.
	 *
	 * @param uuid the UUID of the auto detailses
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of auto detailses
	 * @param end the upper bound of the range of auto detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching auto detailses, or an empty list if no matches were found
	 */
	@Override
	public List<AutoDetails> getAutoDetailsesByUuidAndCompanyId(String uuid,
		long companyId, int start, int end,
		OrderByComparator<AutoDetails> orderByComparator) {
		return autoDetailsPersistence.findByUuid_C(uuid, companyId, start, end,
			orderByComparator);
	}

	/**
	 * Returns the auto details matching the UUID and group.
	 *
	 * @param uuid the auto details's UUID
	 * @param groupId the primary key of the group
	 * @return the matching auto details
	 * @throws PortalException if a matching auto details could not be found
	 */
	@Override
	public AutoDetails getAutoDetailsByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {
		return autoDetailsPersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the auto detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.autodetservice.model.impl.AutoDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of auto detailses
	 * @param end the upper bound of the range of auto detailses (not inclusive)
	 * @return the range of auto detailses
	 */
	@Override
	public List<AutoDetails> getAutoDetailses(int start, int end) {
		return autoDetailsPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of auto detailses.
	 *
	 * @return the number of auto detailses
	 */
	@Override
	public int getAutoDetailsesCount() {
		return autoDetailsPersistence.countAll();
	}

	/**
	 * Updates the auto details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param autoDetails the auto details
	 * @return the auto details that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public AutoDetails updateAutoDetails(AutoDetails autoDetails) {
		return autoDetailsPersistence.update(autoDetails);
	}

	/**
	 * Returns the auto details local service.
	 *
	 * @return the auto details local service
	 */
	public AutoDetailsLocalService getAutoDetailsLocalService() {
		return autoDetailsLocalService;
	}

	/**
	 * Sets the auto details local service.
	 *
	 * @param autoDetailsLocalService the auto details local service
	 */
	public void setAutoDetailsLocalService(
		AutoDetailsLocalService autoDetailsLocalService) {
		this.autoDetailsLocalService = autoDetailsLocalService;
	}

	/**
	 * Returns the auto details persistence.
	 *
	 * @return the auto details persistence
	 */
	public AutoDetailsPersistence getAutoDetailsPersistence() {
		return autoDetailsPersistence;
	}

	/**
	 * Sets the auto details persistence.
	 *
	 * @param autoDetailsPersistence the auto details persistence
	 */
	public void setAutoDetailsPersistence(
		AutoDetailsPersistence autoDetailsPersistence) {
		this.autoDetailsPersistence = autoDetailsPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService getClassNameLocalService() {
		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService) {
		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {
		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		persistedModelLocalServiceRegistry.register("com.autodetservice.model.AutoDetails",
			autoDetailsLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"com.autodetservice.model.AutoDetails");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return AutoDetailsLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return AutoDetails.class;
	}

	protected String getModelClassName() {
		return AutoDetails.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = autoDetailsPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = AutoDetailsLocalService.class)
	protected AutoDetailsLocalService autoDetailsLocalService;
	@BeanReference(type = AutoDetailsPersistence.class)
	protected AutoDetailsPersistence autoDetailsPersistence;
	@ServiceReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@ServiceReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@ServiceReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry persistedModelLocalServiceRegistry;
}