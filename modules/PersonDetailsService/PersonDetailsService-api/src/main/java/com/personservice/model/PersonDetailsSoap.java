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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.personservice.service.http.PersonDetailsServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.personservice.service.http.PersonDetailsServiceSoap
 * @generated
 */
@ProviderType
public class PersonDetailsSoap implements Serializable {
	public static PersonDetailsSoap toSoapModel(PersonDetails model) {
		PersonDetailsSoap soapModel = new PersonDetailsSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setPersonDetailId(model.getPersonDetailId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setSecondName(model.getSecondName());
		soapModel.setAge(model.getAge());
		soapModel.setSpecialty(model.getSpecialty());
		soapModel.setExperience(model.getExperience());

		return soapModel;
	}

	public static PersonDetailsSoap[] toSoapModels(PersonDetails[] models) {
		PersonDetailsSoap[] soapModels = new PersonDetailsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PersonDetailsSoap[][] toSoapModels(PersonDetails[][] models) {
		PersonDetailsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PersonDetailsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PersonDetailsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PersonDetailsSoap[] toSoapModels(List<PersonDetails> models) {
		List<PersonDetailsSoap> soapModels = new ArrayList<PersonDetailsSoap>(models.size());

		for (PersonDetails model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PersonDetailsSoap[soapModels.size()]);
	}

	public PersonDetailsSoap() {
	}

	public long getPrimaryKey() {
		return _PersonDetailId;
	}

	public void setPrimaryKey(long pk) {
		setPersonDetailId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getPersonDetailId() {
		return _PersonDetailId;
	}

	public void setPersonDetailId(long PersonDetailId) {
		_PersonDetailId = PersonDetailId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getFirstName() {
		return _FirstName;
	}

	public void setFirstName(String FirstName) {
		_FirstName = FirstName;
	}

	public String getSecondName() {
		return _SecondName;
	}

	public void setSecondName(String SecondName) {
		_SecondName = SecondName;
	}

	public int getAge() {
		return _Age;
	}

	public void setAge(int Age) {
		_Age = Age;
	}

	public String getSpecialty() {
		return _Specialty;
	}

	public void setSpecialty(String Specialty) {
		_Specialty = Specialty;
	}

	public String getExperience() {
		return _Experience;
	}

	public void setExperience(String Experience) {
		_Experience = Experience;
	}

	private String _uuid;
	private long _PersonDetailId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _FirstName;
	private String _SecondName;
	private int _Age;
	private String _Specialty;
	private String _Experience;
}