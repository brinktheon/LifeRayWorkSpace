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

package com.personservice.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import com.personservice.model.PersonDetails;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PersonDetails in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see PersonDetails
 * @generated
 */
@ProviderType
public class PersonDetailsCacheModel implements CacheModel<PersonDetails>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PersonDetailsCacheModel)) {
			return false;
		}

		PersonDetailsCacheModel personDetailsCacheModel = (PersonDetailsCacheModel)obj;

		if (PersonDetailId == personDetailsCacheModel.PersonDetailId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, PersonDetailId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", PersonDetailId=");
		sb.append(PersonDetailId);
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
		sb.append(", FirstName=");
		sb.append(FirstName);
		sb.append(", SecondName=");
		sb.append(SecondName);
		sb.append(", Age=");
		sb.append(Age);
		sb.append(", Specialty=");
		sb.append(Specialty);
		sb.append(", Experience=");
		sb.append(Experience);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PersonDetails toEntityModel() {
		PersonDetailsImpl personDetailsImpl = new PersonDetailsImpl();

		if (uuid == null) {
			personDetailsImpl.setUuid(StringPool.BLANK);
		}
		else {
			personDetailsImpl.setUuid(uuid);
		}

		personDetailsImpl.setPersonDetailId(PersonDetailId);
		personDetailsImpl.setGroupId(groupId);
		personDetailsImpl.setCompanyId(companyId);
		personDetailsImpl.setUserId(userId);

		if (userName == null) {
			personDetailsImpl.setUserName(StringPool.BLANK);
		}
		else {
			personDetailsImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			personDetailsImpl.setCreateDate(null);
		}
		else {
			personDetailsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			personDetailsImpl.setModifiedDate(null);
		}
		else {
			personDetailsImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (FirstName == null) {
			personDetailsImpl.setFirstName(StringPool.BLANK);
		}
		else {
			personDetailsImpl.setFirstName(FirstName);
		}

		if (SecondName == null) {
			personDetailsImpl.setSecondName(StringPool.BLANK);
		}
		else {
			personDetailsImpl.setSecondName(SecondName);
		}

		personDetailsImpl.setAge(Age);

		if (Specialty == null) {
			personDetailsImpl.setSpecialty(StringPool.BLANK);
		}
		else {
			personDetailsImpl.setSpecialty(Specialty);
		}

		if (Experience == null) {
			personDetailsImpl.setExperience(StringPool.BLANK);
		}
		else {
			personDetailsImpl.setExperience(Experience);
		}

		personDetailsImpl.resetOriginalValues();

		return personDetailsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		PersonDetailId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		FirstName = objectInput.readUTF();
		SecondName = objectInput.readUTF();

		Age = objectInput.readInt();
		Specialty = objectInput.readUTF();
		Experience = objectInput.readUTF();
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

		objectOutput.writeLong(PersonDetailId);

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

		if (FirstName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(FirstName);
		}

		if (SecondName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(SecondName);
		}

		objectOutput.writeInt(Age);

		if (Specialty == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Specialty);
		}

		if (Experience == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Experience);
		}
	}

	public String uuid;
	public long PersonDetailId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String FirstName;
	public String SecondName;
	public int Age;
	public String Specialty;
	public String Experience;
}