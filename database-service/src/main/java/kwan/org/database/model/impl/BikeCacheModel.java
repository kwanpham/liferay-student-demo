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

package kwan.org.database.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import kwan.org.database.model.Bike;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Bike in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Bike
 * @generated
 */
@ProviderType
public class BikeCacheModel implements CacheModel<Bike>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BikeCacheModel)) {
			return false;
		}

		BikeCacheModel bikeCacheModel = (BikeCacheModel)obj;

		if (bikeId == bikeCacheModel.bikeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, bikeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", bikeId=");
		sb.append(bikeId);
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
		sb.append(", bikeName=");
		sb.append(bikeName);
		sb.append(", brand=");
		sb.append(brand);
		sb.append(", studentId=");
		sb.append(studentId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Bike toEntityModel() {
		BikeImpl bikeImpl = new BikeImpl();

		if (uuid == null) {
			bikeImpl.setUuid("");
		}
		else {
			bikeImpl.setUuid(uuid);
		}

		bikeImpl.setBikeId(bikeId);
		bikeImpl.setGroupId(groupId);
		bikeImpl.setCompanyId(companyId);
		bikeImpl.setUserId(userId);

		if (userName == null) {
			bikeImpl.setUserName("");
		}
		else {
			bikeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			bikeImpl.setCreateDate(null);
		}
		else {
			bikeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			bikeImpl.setModifiedDate(null);
		}
		else {
			bikeImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (bikeName == null) {
			bikeImpl.setBikeName("");
		}
		else {
			bikeImpl.setBikeName(bikeName);
		}

		if (brand == null) {
			bikeImpl.setBrand("");
		}
		else {
			bikeImpl.setBrand(brand);
		}

		bikeImpl.setStudentId(studentId);

		bikeImpl.resetOriginalValues();

		return bikeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		bikeId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		bikeName = objectInput.readUTF();
		brand = objectInput.readUTF();

		studentId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(bikeId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (bikeName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(bikeName);
		}

		if (brand == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(brand);
		}

		objectOutput.writeLong(studentId);
	}

	public String uuid;
	public long bikeId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String bikeName;
	public String brand;
	public long studentId;
}