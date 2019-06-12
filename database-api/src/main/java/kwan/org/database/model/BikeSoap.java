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

package kwan.org.database.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link kwan.org.database.service.http.BikeServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see kwan.org.database.service.http.BikeServiceSoap
 * @generated
 */
@ProviderType
public class BikeSoap implements Serializable {
	public static BikeSoap toSoapModel(Bike model) {
		BikeSoap soapModel = new BikeSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setBikeId(model.getBikeId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setBikeName(model.getBikeName());
		soapModel.setBrand(model.getBrand());
		soapModel.setStudentId(model.getStudentId());

		return soapModel;
	}

	public static BikeSoap[] toSoapModels(Bike[] models) {
		BikeSoap[] soapModels = new BikeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BikeSoap[][] toSoapModels(Bike[][] models) {
		BikeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BikeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BikeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BikeSoap[] toSoapModels(List<Bike> models) {
		List<BikeSoap> soapModels = new ArrayList<BikeSoap>(models.size());

		for (Bike model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BikeSoap[soapModels.size()]);
	}

	public BikeSoap() {
	}

	public long getPrimaryKey() {
		return _bikeId;
	}

	public void setPrimaryKey(long pk) {
		setBikeId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getBikeId() {
		return _bikeId;
	}

	public void setBikeId(long bikeId) {
		_bikeId = bikeId;
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

	public String getBikeName() {
		return _bikeName;
	}

	public void setBikeName(String bikeName) {
		_bikeName = bikeName;
	}

	public String getBrand() {
		return _brand;
	}

	public void setBrand(String brand) {
		_brand = brand;
	}

	public long getStudentId() {
		return _studentId;
	}

	public void setStudentId(long studentId) {
		_studentId = studentId;
	}

	private String _uuid;
	private long _bikeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _bikeName;
	private String _brand;
	private long _studentId;
}