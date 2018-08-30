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

package com.autodetservice.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link AutoDetails}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AutoDetails
 * @generated
 */
@ProviderType
public class AutoDetailsWrapper implements AutoDetails,
	ModelWrapper<AutoDetails> {
	public AutoDetailsWrapper(AutoDetails autoDetails) {
		_autoDetails = autoDetails;
	}

	@Override
	public Class<?> getModelClass() {
		return AutoDetails.class;
	}

	@Override
	public String getModelClassName() {
		return AutoDetails.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("autodetailId", getAutodetailId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("Model", getModel());
		attributes.put("VIN", getVIN());
		attributes.put("Year", getYear());
		attributes.put("Manufacturer", getManufacturer());
		attributes.put("Bodystyle", getBodystyle());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long autodetailId = (Long)attributes.get("autodetailId");

		if (autodetailId != null) {
			setAutodetailId(autodetailId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String Model = (String)attributes.get("Model");

		if (Model != null) {
			setModel(Model);
		}

		String VIN = (String)attributes.get("VIN");

		if (VIN != null) {
			setVIN(VIN);
		}

		Integer Year = (Integer)attributes.get("Year");

		if (Year != null) {
			setYear(Year);
		}

		String Manufacturer = (String)attributes.get("Manufacturer");

		if (Manufacturer != null) {
			setManufacturer(Manufacturer);
		}

		String Bodystyle = (String)attributes.get("Bodystyle");

		if (Bodystyle != null) {
			setBodystyle(Bodystyle);
		}
	}

	@Override
	public AutoDetails toEscapedModel() {
		return new AutoDetailsWrapper(_autoDetails.toEscapedModel());
	}

	@Override
	public AutoDetails toUnescapedModel() {
		return new AutoDetailsWrapper(_autoDetails.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _autoDetails.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _autoDetails.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _autoDetails.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _autoDetails.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<AutoDetails> toCacheModel() {
		return _autoDetails.toCacheModel();
	}

	@Override
	public int compareTo(AutoDetails autoDetails) {
		return _autoDetails.compareTo(autoDetails);
	}

	/**
	* Returns the year of this auto details.
	*
	* @return the year of this auto details
	*/
	@Override
	public int getYear() {
		return _autoDetails.getYear();
	}

	@Override
	public int hashCode() {
		return _autoDetails.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _autoDetails.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new AutoDetailsWrapper((AutoDetails)_autoDetails.clone());
	}

	/**
	* Returns the bodystyle of this auto details.
	*
	* @return the bodystyle of this auto details
	*/
	@Override
	public java.lang.String getBodystyle() {
		return _autoDetails.getBodystyle();
	}

	/**
	* Returns the manufacturer of this auto details.
	*
	* @return the manufacturer of this auto details
	*/
	@Override
	public java.lang.String getManufacturer() {
		return _autoDetails.getManufacturer();
	}

	/**
	* Returns the model of this auto details.
	*
	* @return the model of this auto details
	*/
	@Override
	public java.lang.String getModel() {
		return _autoDetails.getModel();
	}

	/**
	* Returns the user name of this auto details.
	*
	* @return the user name of this auto details
	*/
	@Override
	public java.lang.String getUserName() {
		return _autoDetails.getUserName();
	}

	/**
	* Returns the user uuid of this auto details.
	*
	* @return the user uuid of this auto details
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _autoDetails.getUserUuid();
	}

	/**
	* Returns the uuid of this auto details.
	*
	* @return the uuid of this auto details
	*/
	@Override
	public java.lang.String getUuid() {
		return _autoDetails.getUuid();
	}

	/**
	* Returns the vin of this auto details.
	*
	* @return the vin of this auto details
	*/
	@Override
	public java.lang.String getVIN() {
		return _autoDetails.getVIN();
	}

	@Override
	public java.lang.String toString() {
		return _autoDetails.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _autoDetails.toXmlString();
	}

	/**
	* Returns the create date of this auto details.
	*
	* @return the create date of this auto details
	*/
	@Override
	public Date getCreateDate() {
		return _autoDetails.getCreateDate();
	}

	/**
	* Returns the modified date of this auto details.
	*
	* @return the modified date of this auto details
	*/
	@Override
	public Date getModifiedDate() {
		return _autoDetails.getModifiedDate();
	}

	/**
	* Returns the autodetail ID of this auto details.
	*
	* @return the autodetail ID of this auto details
	*/
	@Override
	public long getAutodetailId() {
		return _autoDetails.getAutodetailId();
	}

	/**
	* Returns the company ID of this auto details.
	*
	* @return the company ID of this auto details
	*/
	@Override
	public long getCompanyId() {
		return _autoDetails.getCompanyId();
	}

	/**
	* Returns the group ID of this auto details.
	*
	* @return the group ID of this auto details
	*/
	@Override
	public long getGroupId() {
		return _autoDetails.getGroupId();
	}

	/**
	* Returns the primary key of this auto details.
	*
	* @return the primary key of this auto details
	*/
	@Override
	public long getPrimaryKey() {
		return _autoDetails.getPrimaryKey();
	}

	/**
	* Returns the user ID of this auto details.
	*
	* @return the user ID of this auto details
	*/
	@Override
	public long getUserId() {
		return _autoDetails.getUserId();
	}

	@Override
	public void persist() {
		_autoDetails.persist();
	}

	/**
	* Sets the autodetail ID of this auto details.
	*
	* @param autodetailId the autodetail ID of this auto details
	*/
	@Override
	public void setAutodetailId(long autodetailId) {
		_autoDetails.setAutodetailId(autodetailId);
	}

	/**
	* Sets the bodystyle of this auto details.
	*
	* @param Bodystyle the bodystyle of this auto details
	*/
	@Override
	public void setBodystyle(java.lang.String Bodystyle) {
		_autoDetails.setBodystyle(Bodystyle);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_autoDetails.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this auto details.
	*
	* @param companyId the company ID of this auto details
	*/
	@Override
	public void setCompanyId(long companyId) {
		_autoDetails.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this auto details.
	*
	* @param createDate the create date of this auto details
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_autoDetails.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_autoDetails.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_autoDetails.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_autoDetails.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this auto details.
	*
	* @param groupId the group ID of this auto details
	*/
	@Override
	public void setGroupId(long groupId) {
		_autoDetails.setGroupId(groupId);
	}

	/**
	* Sets the manufacturer of this auto details.
	*
	* @param Manufacturer the manufacturer of this auto details
	*/
	@Override
	public void setManufacturer(java.lang.String Manufacturer) {
		_autoDetails.setManufacturer(Manufacturer);
	}

	/**
	* Sets the model of this auto details.
	*
	* @param Model the model of this auto details
	*/
	@Override
	public void setModel(java.lang.String Model) {
		_autoDetails.setModel(Model);
	}

	/**
	* Sets the modified date of this auto details.
	*
	* @param modifiedDate the modified date of this auto details
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_autoDetails.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_autoDetails.setNew(n);
	}

	/**
	* Sets the primary key of this auto details.
	*
	* @param primaryKey the primary key of this auto details
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_autoDetails.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_autoDetails.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the user ID of this auto details.
	*
	* @param userId the user ID of this auto details
	*/
	@Override
	public void setUserId(long userId) {
		_autoDetails.setUserId(userId);
	}

	/**
	* Sets the user name of this auto details.
	*
	* @param userName the user name of this auto details
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_autoDetails.setUserName(userName);
	}

	/**
	* Sets the user uuid of this auto details.
	*
	* @param userUuid the user uuid of this auto details
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_autoDetails.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this auto details.
	*
	* @param uuid the uuid of this auto details
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_autoDetails.setUuid(uuid);
	}

	/**
	* Sets the vin of this auto details.
	*
	* @param VIN the vin of this auto details
	*/
	@Override
	public void setVIN(java.lang.String VIN) {
		_autoDetails.setVIN(VIN);
	}

	/**
	* Sets the year of this auto details.
	*
	* @param Year the year of this auto details
	*/
	@Override
	public void setYear(int Year) {
		_autoDetails.setYear(Year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AutoDetailsWrapper)) {
			return false;
		}

		AutoDetailsWrapper autoDetailsWrapper = (AutoDetailsWrapper)obj;

		if (Objects.equals(_autoDetails, autoDetailsWrapper._autoDetails)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _autoDetails.getStagedModelType();
	}

	@Override
	public AutoDetails getWrappedModel() {
		return _autoDetails;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _autoDetails.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _autoDetails.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_autoDetails.resetOriginalValues();
	}

	private final AutoDetails _autoDetails;
}