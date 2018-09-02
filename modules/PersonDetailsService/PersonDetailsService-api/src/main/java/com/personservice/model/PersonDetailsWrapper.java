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

package com.personservice.model;

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
 * This class is a wrapper for {@link PersonDetails}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersonDetails
 * @generated
 */
@ProviderType
public class PersonDetailsWrapper implements PersonDetails,
	ModelWrapper<PersonDetails> {
	public PersonDetailsWrapper(PersonDetails personDetails) {
		_personDetails = personDetails;
	}

	@Override
	public Class<?> getModelClass() {
		return PersonDetails.class;
	}

	@Override
	public String getModelClassName() {
		return PersonDetails.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("PersonDetailId", getPersonDetailId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("FirstName", getFirstName());
		attributes.put("SecondName", getSecondName());
		attributes.put("Age", getAge());
		attributes.put("Specialty", getSpecialty());
		attributes.put("Experience", getExperience());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long PersonDetailId = (Long)attributes.get("PersonDetailId");

		if (PersonDetailId != null) {
			setPersonDetailId(PersonDetailId);
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

		String FirstName = (String)attributes.get("FirstName");

		if (FirstName != null) {
			setFirstName(FirstName);
		}

		String SecondName = (String)attributes.get("SecondName");

		if (SecondName != null) {
			setSecondName(SecondName);
		}

		Integer Age = (Integer)attributes.get("Age");

		if (Age != null) {
			setAge(Age);
		}

		String Specialty = (String)attributes.get("Specialty");

		if (Specialty != null) {
			setSpecialty(Specialty);
		}

		String Experience = (String)attributes.get("Experience");

		if (Experience != null) {
			setExperience(Experience);
		}
	}

	@Override
	public PersonDetails toEscapedModel() {
		return new PersonDetailsWrapper(_personDetails.toEscapedModel());
	}

	@Override
	public PersonDetails toUnescapedModel() {
		return new PersonDetailsWrapper(_personDetails.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _personDetails.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _personDetails.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _personDetails.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _personDetails.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<PersonDetails> toCacheModel() {
		return _personDetails.toCacheModel();
	}

	@Override
	public int compareTo(PersonDetails personDetails) {
		return _personDetails.compareTo(personDetails);
	}

	/**
	* Returns the age of this person details.
	*
	* @return the age of this person details
	*/
	@Override
	public int getAge() {
		return _personDetails.getAge();
	}

	@Override
	public int hashCode() {
		return _personDetails.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _personDetails.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new PersonDetailsWrapper((PersonDetails)_personDetails.clone());
	}

	/**
	* Returns the experience of this person details.
	*
	* @return the experience of this person details
	*/
	@Override
	public java.lang.String getExperience() {
		return _personDetails.getExperience();
	}

	/**
	* Returns the first name of this person details.
	*
	* @return the first name of this person details
	*/
	@Override
	public java.lang.String getFirstName() {
		return _personDetails.getFirstName();
	}

	/**
	* Returns the second name of this person details.
	*
	* @return the second name of this person details
	*/
	@Override
	public java.lang.String getSecondName() {
		return _personDetails.getSecondName();
	}

	/**
	* Returns the specialty of this person details.
	*
	* @return the specialty of this person details
	*/
	@Override
	public java.lang.String getSpecialty() {
		return _personDetails.getSpecialty();
	}

	/**
	* Returns the user name of this person details.
	*
	* @return the user name of this person details
	*/
	@Override
	public java.lang.String getUserName() {
		return _personDetails.getUserName();
	}

	/**
	* Returns the user uuid of this person details.
	*
	* @return the user uuid of this person details
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _personDetails.getUserUuid();
	}

	/**
	* Returns the uuid of this person details.
	*
	* @return the uuid of this person details
	*/
	@Override
	public java.lang.String getUuid() {
		return _personDetails.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _personDetails.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _personDetails.toXmlString();
	}

	/**
	* Returns the create date of this person details.
	*
	* @return the create date of this person details
	*/
	@Override
	public Date getCreateDate() {
		return _personDetails.getCreateDate();
	}

	/**
	* Returns the modified date of this person details.
	*
	* @return the modified date of this person details
	*/
	@Override
	public Date getModifiedDate() {
		return _personDetails.getModifiedDate();
	}

	/**
	* Returns the company ID of this person details.
	*
	* @return the company ID of this person details
	*/
	@Override
	public long getCompanyId() {
		return _personDetails.getCompanyId();
	}

	/**
	* Returns the group ID of this person details.
	*
	* @return the group ID of this person details
	*/
	@Override
	public long getGroupId() {
		return _personDetails.getGroupId();
	}

	/**
	* Returns the person detail ID of this person details.
	*
	* @return the person detail ID of this person details
	*/
	@Override
	public long getPersonDetailId() {
		return _personDetails.getPersonDetailId();
	}

	/**
	* Returns the primary key of this person details.
	*
	* @return the primary key of this person details
	*/
	@Override
	public long getPrimaryKey() {
		return _personDetails.getPrimaryKey();
	}

	/**
	* Returns the user ID of this person details.
	*
	* @return the user ID of this person details
	*/
	@Override
	public long getUserId() {
		return _personDetails.getUserId();
	}

	@Override
	public void persist() {
		_personDetails.persist();
	}

	/**
	* Sets the age of this person details.
	*
	* @param Age the age of this person details
	*/
	@Override
	public void setAge(int Age) {
		_personDetails.setAge(Age);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_personDetails.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this person details.
	*
	* @param companyId the company ID of this person details
	*/
	@Override
	public void setCompanyId(long companyId) {
		_personDetails.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this person details.
	*
	* @param createDate the create date of this person details
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_personDetails.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_personDetails.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_personDetails.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_personDetails.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the experience of this person details.
	*
	* @param Experience the experience of this person details
	*/
	@Override
	public void setExperience(java.lang.String Experience) {
		_personDetails.setExperience(Experience);
	}

	/**
	* Sets the first name of this person details.
	*
	* @param FirstName the first name of this person details
	*/
	@Override
	public void setFirstName(java.lang.String FirstName) {
		_personDetails.setFirstName(FirstName);
	}

	/**
	* Sets the group ID of this person details.
	*
	* @param groupId the group ID of this person details
	*/
	@Override
	public void setGroupId(long groupId) {
		_personDetails.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this person details.
	*
	* @param modifiedDate the modified date of this person details
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_personDetails.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_personDetails.setNew(n);
	}

	/**
	* Sets the person detail ID of this person details.
	*
	* @param PersonDetailId the person detail ID of this person details
	*/
	@Override
	public void setPersonDetailId(long PersonDetailId) {
		_personDetails.setPersonDetailId(PersonDetailId);
	}

	/**
	* Sets the primary key of this person details.
	*
	* @param primaryKey the primary key of this person details
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_personDetails.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_personDetails.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the second name of this person details.
	*
	* @param SecondName the second name of this person details
	*/
	@Override
	public void setSecondName(java.lang.String SecondName) {
		_personDetails.setSecondName(SecondName);
	}

	/**
	* Sets the specialty of this person details.
	*
	* @param Specialty the specialty of this person details
	*/
	@Override
	public void setSpecialty(java.lang.String Specialty) {
		_personDetails.setSpecialty(Specialty);
	}

	/**
	* Sets the user ID of this person details.
	*
	* @param userId the user ID of this person details
	*/
	@Override
	public void setUserId(long userId) {
		_personDetails.setUserId(userId);
	}

	/**
	* Sets the user name of this person details.
	*
	* @param userName the user name of this person details
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_personDetails.setUserName(userName);
	}

	/**
	* Sets the user uuid of this person details.
	*
	* @param userUuid the user uuid of this person details
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_personDetails.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this person details.
	*
	* @param uuid the uuid of this person details
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_personDetails.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PersonDetailsWrapper)) {
			return false;
		}

		PersonDetailsWrapper personDetailsWrapper = (PersonDetailsWrapper)obj;

		if (Objects.equals(_personDetails, personDetailsWrapper._personDetails)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _personDetails.getStagedModelType();
	}

	@Override
	public PersonDetails getWrappedModel() {
		return _personDetails;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _personDetails.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _personDetails.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_personDetails.resetOriginalValues();
	}

	private final PersonDetails _personDetails;
}