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

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AutoDetails in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see AutoDetails
 * @generated
 */
@ProviderType
public class AutoDetailsCacheModel implements CacheModel<AutoDetails>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AutoDetailsCacheModel)) {
			return false;
		}

		AutoDetailsCacheModel autoDetailsCacheModel = (AutoDetailsCacheModel)obj;

		if (autodetailId == autoDetailsCacheModel.autodetailId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, autodetailId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", autodetailId=");
		sb.append(autodetailId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", Model=");
		sb.append(Model);
		sb.append(", VIN=");
		sb.append(VIN);
		sb.append(", Year=");
		sb.append(Year);
		sb.append(", Manufacturer=");
		sb.append(Manufacturer);
		sb.append(", Bodystyle=");
		sb.append(Bodystyle);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AutoDetails toEntityModel() {
		AutoDetailsImpl autoDetailsImpl = new AutoDetailsImpl();

		if (uuid == null) {
			autoDetailsImpl.setUuid(StringPool.BLANK);
		}
		else {
			autoDetailsImpl.setUuid(uuid);
		}

		autoDetailsImpl.setAutodetailId(autodetailId);
		autoDetailsImpl.setGroupId(groupId);
		autoDetailsImpl.setCompanyId(companyId);
		autoDetailsImpl.setUserId(userId);

		if (userName == null) {
			autoDetailsImpl.setUserName(StringPool.BLANK);
		}
		else {
			autoDetailsImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			autoDetailsImpl.setCreateDate(null);
		}
		else {
			autoDetailsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			autoDetailsImpl.setModifiedDate(null);
		}
		else {
			autoDetailsImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (Model == null) {
			autoDetailsImpl.setModel(StringPool.BLANK);
		}
		else {
			autoDetailsImpl.setModel(Model);
		}

		if (VIN == null) {
			autoDetailsImpl.setVIN(StringPool.BLANK);
		}
		else {
			autoDetailsImpl.setVIN(VIN);
		}

		autoDetailsImpl.setYear(Year);

		if (Manufacturer == null) {
			autoDetailsImpl.setManufacturer(StringPool.BLANK);
		}
		else {
			autoDetailsImpl.setManufacturer(Manufacturer);
		}

		if (Bodystyle == null) {
			autoDetailsImpl.setBodystyle(StringPool.BLANK);
		}
		else {
			autoDetailsImpl.setBodystyle(Bodystyle);
		}

		autoDetailsImpl.resetOriginalValues();

		return autoDetailsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		autodetailId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		Model = objectInput.readUTF();
		VIN = objectInput.readUTF();

		Year = objectInput.readInt();
		Manufacturer = objectInput.readUTF();
		Bodystyle = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(autodetailId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (Model == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Model);
		}

		if (VIN == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(VIN);
		}

		objectOutput.writeInt(Year);

		if (Manufacturer == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Manufacturer);
		}

		if (Bodystyle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Bodystyle);
		}
	}

	public String uuid;
	public long autodetailId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String Model;
	public String VIN;
	public int Year;
	public String Manufacturer;
	public String Bodystyle;
}