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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.autodetservice.service.http.AutoDetailsServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.autodetservice.service.http.AutoDetailsServiceSoap
 * @generated
 */
@ProviderType
public class AutoDetailsSoap implements Serializable {
	public static AutoDetailsSoap toSoapModel(AutoDetails model) {
		AutoDetailsSoap soapModel = new AutoDetailsSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setAutodetailId(model.getAutodetailId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setModel(model.getModel());
		soapModel.setVIN(model.getVIN());
		soapModel.setYear(model.getYear());
		soapModel.setManufacturer(model.getManufacturer());
		soapModel.setBodystyle(model.getBodystyle());

		return soapModel;
	}

	public static AutoDetailsSoap[] toSoapModels(AutoDetails[] models) {
		AutoDetailsSoap[] soapModels = new AutoDetailsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AutoDetailsSoap[][] toSoapModels(AutoDetails[][] models) {
		AutoDetailsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AutoDetailsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AutoDetailsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AutoDetailsSoap[] toSoapModels(List<AutoDetails> models) {
		List<AutoDetailsSoap> soapModels = new ArrayList<AutoDetailsSoap>(models.size());

		for (AutoDetails model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AutoDetailsSoap[soapModels.size()]);
	}

	public AutoDetailsSoap() {
	}

	public long getPrimaryKey() {
		return _autodetailId;
	}

	public void setPrimaryKey(long pk) {
		setAutodetailId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getAutodetailId() {
		return _autodetailId;
	}

	public void setAutodetailId(long autodetailId) {
		_autodetailId = autodetailId;
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

	public String getModel() {
		return _Model;
	}

	public void setModel(String Model) {
		_Model = Model;
	}

	public String getVIN() {
		return _VIN;
	}

	public void setVIN(String VIN) {
		_VIN = VIN;
	}

	public int getYear() {
		return _Year;
	}

	public void setYear(int Year) {
		_Year = Year;
	}

	public String getManufacturer() {
		return _Manufacturer;
	}

	public void setManufacturer(String Manufacturer) {
		_Manufacturer = Manufacturer;
	}

	public String getBodystyle() {
		return _Bodystyle;
	}

	public void setBodystyle(String Bodystyle) {
		_Bodystyle = Bodystyle;
	}

	private String _uuid;
	private long _autodetailId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _Model;
	private String _VIN;
	private int _Year;
	private String _Manufacturer;
	private String _Bodystyle;
}