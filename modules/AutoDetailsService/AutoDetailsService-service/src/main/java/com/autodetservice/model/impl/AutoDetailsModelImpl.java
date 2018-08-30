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

package com.autodetservice.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.autodetservice.model.AutoDetails;
import com.autodetservice.model.AutoDetailsModel;
import com.autodetservice.model.AutoDetailsSoap;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the AutoDetails service. Represents a row in the &quot;autodetails&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link AutoDetailsModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AutoDetailsImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AutoDetailsImpl
 * @see AutoDetails
 * @see AutoDetailsModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class AutoDetailsModelImpl extends BaseModelImpl<AutoDetails>
	implements AutoDetailsModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a auto details model instance should use the {@link AutoDetails} interface instead.
	 */
	public static final String TABLE_NAME = "autodetails";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "autodetailId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "Model", Types.VARCHAR },
			{ "VIN", Types.VARCHAR },
			{ "Year", Types.INTEGER },
			{ "Manufacturer", Types.VARCHAR },
			{ "Bodystyle", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("autodetailId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("Model", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("VIN", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("Year", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("Manufacturer", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("Bodystyle", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table autodetails (uuid_ VARCHAR(75) null,autodetailId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,Model VARCHAR(75) null,VIN VARCHAR(75) null,Year INTEGER,Manufacturer VARCHAR(75) null,Bodystyle VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table autodetails";
	public static final String ORDER_BY_JPQL = " ORDER BY autoDetails.Model ASC";
	public static final String ORDER_BY_SQL = " ORDER BY autodetails.Model ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.autodetservice.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.autodetservice.model.AutoDetails"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.autodetservice.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.autodetservice.model.AutoDetails"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.autodetservice.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.autodetservice.model.AutoDetails"),
			true);
	public static final long COMPANYID_COLUMN_BITMASK = 1L;
	public static final long GROUPID_COLUMN_BITMASK = 2L;
	public static final long UUID_COLUMN_BITMASK = 4L;
	public static final long MODEL_COLUMN_BITMASK = 8L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static AutoDetails toModel(AutoDetailsSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		AutoDetails model = new AutoDetailsImpl();

		model.setUuid(soapModel.getUuid());
		model.setAutodetailId(soapModel.getAutodetailId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setModel(soapModel.getModel());
		model.setVIN(soapModel.getVIN());
		model.setYear(soapModel.getYear());
		model.setManufacturer(soapModel.getManufacturer());
		model.setBodystyle(soapModel.getBodystyle());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<AutoDetails> toModels(AutoDetailsSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<AutoDetails> models = new ArrayList<AutoDetails>(soapModels.length);

		for (AutoDetailsSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.autodetservice.service.util.ServiceProps.get(
				"lock.expiration.time.com.autodetservice.model.AutoDetails"));

	public AutoDetailsModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _autodetailId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setAutodetailId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _autodetailId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

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

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getAutodetailId() {
		return _autodetailId;
	}

	@Override
	public void setAutodetailId(long autodetailId) {
		_autodetailId = autodetailId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return StringPool.BLANK;
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getModel() {
		if (_Model == null) {
			return StringPool.BLANK;
		}
		else {
			return _Model;
		}
	}

	@Override
	public void setModel(String Model) {
		_columnBitmask = -1L;

		_Model = Model;
	}

	@JSON
	@Override
	public String getVIN() {
		if (_VIN == null) {
			return StringPool.BLANK;
		}
		else {
			return _VIN;
		}
	}

	@Override
	public void setVIN(String VIN) {
		_VIN = VIN;
	}

	@JSON
	@Override
	public int getYear() {
		return _Year;
	}

	@Override
	public void setYear(int Year) {
		_Year = Year;
	}

	@JSON
	@Override
	public String getManufacturer() {
		if (_Manufacturer == null) {
			return StringPool.BLANK;
		}
		else {
			return _Manufacturer;
		}
	}

	@Override
	public void setManufacturer(String Manufacturer) {
		_Manufacturer = Manufacturer;
	}

	@JSON
	@Override
	public String getBodystyle() {
		if (_Bodystyle == null) {
			return StringPool.BLANK;
		}
		else {
			return _Bodystyle;
		}
	}

	@Override
	public void setBodystyle(String Bodystyle) {
		_Bodystyle = Bodystyle;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				AutoDetails.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			AutoDetails.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public AutoDetails toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (AutoDetails)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		AutoDetailsImpl autoDetailsImpl = new AutoDetailsImpl();

		autoDetailsImpl.setUuid(getUuid());
		autoDetailsImpl.setAutodetailId(getAutodetailId());
		autoDetailsImpl.setGroupId(getGroupId());
		autoDetailsImpl.setCompanyId(getCompanyId());
		autoDetailsImpl.setUserId(getUserId());
		autoDetailsImpl.setUserName(getUserName());
		autoDetailsImpl.setCreateDate(getCreateDate());
		autoDetailsImpl.setModifiedDate(getModifiedDate());
		autoDetailsImpl.setModel(getModel());
		autoDetailsImpl.setVIN(getVIN());
		autoDetailsImpl.setYear(getYear());
		autoDetailsImpl.setManufacturer(getManufacturer());
		autoDetailsImpl.setBodystyle(getBodystyle());

		autoDetailsImpl.resetOriginalValues();

		return autoDetailsImpl;
	}

	@Override
	public int compareTo(AutoDetails autoDetails) {
		int value = 0;

		value = getModel().compareTo(autoDetails.getModel());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AutoDetails)) {
			return false;
		}

		AutoDetails autoDetails = (AutoDetails)obj;

		long primaryKey = autoDetails.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		AutoDetailsModelImpl autoDetailsModelImpl = this;

		autoDetailsModelImpl._originalUuid = autoDetailsModelImpl._uuid;

		autoDetailsModelImpl._originalGroupId = autoDetailsModelImpl._groupId;

		autoDetailsModelImpl._setOriginalGroupId = false;

		autoDetailsModelImpl._originalCompanyId = autoDetailsModelImpl._companyId;

		autoDetailsModelImpl._setOriginalCompanyId = false;

		autoDetailsModelImpl._setModifiedDate = false;

		autoDetailsModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<AutoDetails> toCacheModel() {
		AutoDetailsCacheModel autoDetailsCacheModel = new AutoDetailsCacheModel();

		autoDetailsCacheModel.uuid = getUuid();

		String uuid = autoDetailsCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			autoDetailsCacheModel.uuid = null;
		}

		autoDetailsCacheModel.autodetailId = getAutodetailId();

		autoDetailsCacheModel.groupId = getGroupId();

		autoDetailsCacheModel.companyId = getCompanyId();

		autoDetailsCacheModel.userId = getUserId();

		autoDetailsCacheModel.userName = getUserName();

		String userName = autoDetailsCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			autoDetailsCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			autoDetailsCacheModel.createDate = createDate.getTime();
		}
		else {
			autoDetailsCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			autoDetailsCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			autoDetailsCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		autoDetailsCacheModel.Model = getModel();

		String Model = autoDetailsCacheModel.Model;

		if ((Model != null) && (Model.length() == 0)) {
			autoDetailsCacheModel.Model = null;
		}

		autoDetailsCacheModel.VIN = getVIN();

		String VIN = autoDetailsCacheModel.VIN;

		if ((VIN != null) && (VIN.length() == 0)) {
			autoDetailsCacheModel.VIN = null;
		}

		autoDetailsCacheModel.Year = getYear();

		autoDetailsCacheModel.Manufacturer = getManufacturer();

		String Manufacturer = autoDetailsCacheModel.Manufacturer;

		if ((Manufacturer != null) && (Manufacturer.length() == 0)) {
			autoDetailsCacheModel.Manufacturer = null;
		}

		autoDetailsCacheModel.Bodystyle = getBodystyle();

		String Bodystyle = autoDetailsCacheModel.Bodystyle;

		if ((Bodystyle != null) && (Bodystyle.length() == 0)) {
			autoDetailsCacheModel.Bodystyle = null;
		}

		return autoDetailsCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", autodetailId=");
		sb.append(getAutodetailId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", Model=");
		sb.append(getModel());
		sb.append(", VIN=");
		sb.append(getVIN());
		sb.append(", Year=");
		sb.append(getYear());
		sb.append(", Manufacturer=");
		sb.append(getManufacturer());
		sb.append(", Bodystyle=");
		sb.append(getBodystyle());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("com.autodetservice.model.AutoDetails");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>autodetailId</column-name><column-value><![CDATA[");
		sb.append(getAutodetailId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Model</column-name><column-value><![CDATA[");
		sb.append(getModel());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>VIN</column-name><column-value><![CDATA[");
		sb.append(getVIN());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Year</column-name><column-value><![CDATA[");
		sb.append(getYear());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Manufacturer</column-name><column-value><![CDATA[");
		sb.append(getManufacturer());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Bodystyle</column-name><column-value><![CDATA[");
		sb.append(getBodystyle());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = AutoDetails.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			AutoDetails.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _autodetailId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _Model;
	private String _VIN;
	private int _Year;
	private String _Manufacturer;
	private String _Bodystyle;
	private long _columnBitmask;
	private AutoDetails _escapedModel;
}