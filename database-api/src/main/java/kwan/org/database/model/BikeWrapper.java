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
 * This class is a wrapper for {@link Bike}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Bike
 * @generated
 */
@ProviderType
public class BikeWrapper implements Bike, ModelWrapper<Bike> {
	public BikeWrapper(Bike bike) {
		_bike = bike;
	}

	@Override
	public Class<?> getModelClass() {
		return Bike.class;
	}

	@Override
	public String getModelClassName() {
		return Bike.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("bikeId", getBikeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("bikeName", getBikeName());
		attributes.put("brand", getBrand());
		attributes.put("studentId", getStudentId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long bikeId = (Long)attributes.get("bikeId");

		if (bikeId != null) {
			setBikeId(bikeId);
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

		String bikeName = (String)attributes.get("bikeName");

		if (bikeName != null) {
			setBikeName(bikeName);
		}

		String brand = (String)attributes.get("brand");

		if (brand != null) {
			setBrand(brand);
		}

		Long studentId = (Long)attributes.get("studentId");

		if (studentId != null) {
			setStudentId(studentId);
		}
	}

	@Override
	public Object clone() {
		return new BikeWrapper((Bike)_bike.clone());
	}

	@Override
	public int compareTo(Bike bike) {
		return _bike.compareTo(bike);
	}

	/**
	* Returns the bike ID of this bike.
	*
	* @return the bike ID of this bike
	*/
	@Override
	public long getBikeId() {
		return _bike.getBikeId();
	}

	/**
	* Returns the bike name of this bike.
	*
	* @return the bike name of this bike
	*/
	@Override
	public String getBikeName() {
		return _bike.getBikeName();
	}

	/**
	* Returns the brand of this bike.
	*
	* @return the brand of this bike
	*/
	@Override
	public String getBrand() {
		return _bike.getBrand();
	}

	/**
	* Returns the company ID of this bike.
	*
	* @return the company ID of this bike
	*/
	@Override
	public long getCompanyId() {
		return _bike.getCompanyId();
	}

	/**
	* Returns the create date of this bike.
	*
	* @return the create date of this bike
	*/
	@Override
	public Date getCreateDate() {
		return _bike.getCreateDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _bike.getExpandoBridge();
	}

	/**
	* Returns the group ID of this bike.
	*
	* @return the group ID of this bike
	*/
	@Override
	public long getGroupId() {
		return _bike.getGroupId();
	}

	/**
	* Returns the modified date of this bike.
	*
	* @return the modified date of this bike
	*/
	@Override
	public Date getModifiedDate() {
		return _bike.getModifiedDate();
	}

	/**
	* Returns the primary key of this bike.
	*
	* @return the primary key of this bike
	*/
	@Override
	public long getPrimaryKey() {
		return _bike.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _bike.getPrimaryKeyObj();
	}

	/**
	* Returns the student ID of this bike.
	*
	* @return the student ID of this bike
	*/
	@Override
	public long getStudentId() {
		return _bike.getStudentId();
	}

	/**
	* Returns the user ID of this bike.
	*
	* @return the user ID of this bike
	*/
	@Override
	public long getUserId() {
		return _bike.getUserId();
	}

	/**
	* Returns the user name of this bike.
	*
	* @return the user name of this bike
	*/
	@Override
	public String getUserName() {
		return _bike.getUserName();
	}

	/**
	* Returns the user uuid of this bike.
	*
	* @return the user uuid of this bike
	*/
	@Override
	public String getUserUuid() {
		return _bike.getUserUuid();
	}

	/**
	* Returns the uuid of this bike.
	*
	* @return the uuid of this bike
	*/
	@Override
	public String getUuid() {
		return _bike.getUuid();
	}

	@Override
	public int hashCode() {
		return _bike.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _bike.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _bike.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _bike.isNew();
	}

	@Override
	public void persist() {
		_bike.persist();
	}

	/**
	* Sets the bike ID of this bike.
	*
	* @param bikeId the bike ID of this bike
	*/
	@Override
	public void setBikeId(long bikeId) {
		_bike.setBikeId(bikeId);
	}

	/**
	* Sets the bike name of this bike.
	*
	* @param bikeName the bike name of this bike
	*/
	@Override
	public void setBikeName(String bikeName) {
		_bike.setBikeName(bikeName);
	}

	/**
	* Sets the brand of this bike.
	*
	* @param brand the brand of this bike
	*/
	@Override
	public void setBrand(String brand) {
		_bike.setBrand(brand);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_bike.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this bike.
	*
	* @param companyId the company ID of this bike
	*/
	@Override
	public void setCompanyId(long companyId) {
		_bike.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this bike.
	*
	* @param createDate the create date of this bike
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_bike.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_bike.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_bike.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_bike.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this bike.
	*
	* @param groupId the group ID of this bike
	*/
	@Override
	public void setGroupId(long groupId) {
		_bike.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this bike.
	*
	* @param modifiedDate the modified date of this bike
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_bike.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_bike.setNew(n);
	}

	/**
	* Sets the primary key of this bike.
	*
	* @param primaryKey the primary key of this bike
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_bike.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_bike.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the student ID of this bike.
	*
	* @param studentId the student ID of this bike
	*/
	@Override
	public void setStudentId(long studentId) {
		_bike.setStudentId(studentId);
	}

	/**
	* Sets the user ID of this bike.
	*
	* @param userId the user ID of this bike
	*/
	@Override
	public void setUserId(long userId) {
		_bike.setUserId(userId);
	}

	/**
	* Sets the user name of this bike.
	*
	* @param userName the user name of this bike
	*/
	@Override
	public void setUserName(String userName) {
		_bike.setUserName(userName);
	}

	/**
	* Sets the user uuid of this bike.
	*
	* @param userUuid the user uuid of this bike
	*/
	@Override
	public void setUserUuid(String userUuid) {
		_bike.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this bike.
	*
	* @param uuid the uuid of this bike
	*/
	@Override
	public void setUuid(String uuid) {
		_bike.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Bike> toCacheModel() {
		return _bike.toCacheModel();
	}

	@Override
	public Bike toEscapedModel() {
		return new BikeWrapper(_bike.toEscapedModel());
	}

	@Override
	public String toString() {
		return _bike.toString();
	}

	@Override
	public Bike toUnescapedModel() {
		return new BikeWrapper(_bike.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _bike.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BikeWrapper)) {
			return false;
		}

		BikeWrapper bikeWrapper = (BikeWrapper)obj;

		if (Objects.equals(_bike, bikeWrapper._bike)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _bike.getStagedModelType();
	}

	@Override
	public Bike getWrappedModel() {
		return _bike;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _bike.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _bike.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_bike.resetOriginalValues();
	}

	private final Bike _bike;
}