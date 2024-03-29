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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Bike service. Represents a row in the &quot;FOO_Bike&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link kwan.org.database.model.impl.BikeModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link kwan.org.database.model.impl.BikeImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Bike
 * @see kwan.org.database.model.impl.BikeImpl
 * @see kwan.org.database.model.impl.BikeModelImpl
 * @generated
 */
@ProviderType
public interface BikeModel extends BaseModel<Bike>, GroupedModel, ShardedModel,
	StagedAuditedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a bike model instance should use the {@link Bike} interface instead.
	 */

	/**
	 * Returns the primary key of this bike.
	 *
	 * @return the primary key of this bike
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this bike.
	 *
	 * @param primaryKey the primary key of this bike
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this bike.
	 *
	 * @return the uuid of this bike
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this bike.
	 *
	 * @param uuid the uuid of this bike
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the bike ID of this bike.
	 *
	 * @return the bike ID of this bike
	 */
	public long getBikeId();

	/**
	 * Sets the bike ID of this bike.
	 *
	 * @param bikeId the bike ID of this bike
	 */
	public void setBikeId(long bikeId);

	/**
	 * Returns the group ID of this bike.
	 *
	 * @return the group ID of this bike
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this bike.
	 *
	 * @param groupId the group ID of this bike
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this bike.
	 *
	 * @return the company ID of this bike
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this bike.
	 *
	 * @param companyId the company ID of this bike
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this bike.
	 *
	 * @return the user ID of this bike
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this bike.
	 *
	 * @param userId the user ID of this bike
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this bike.
	 *
	 * @return the user uuid of this bike
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this bike.
	 *
	 * @param userUuid the user uuid of this bike
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this bike.
	 *
	 * @return the user name of this bike
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this bike.
	 *
	 * @param userName the user name of this bike
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this bike.
	 *
	 * @return the create date of this bike
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this bike.
	 *
	 * @param createDate the create date of this bike
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this bike.
	 *
	 * @return the modified date of this bike
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this bike.
	 *
	 * @param modifiedDate the modified date of this bike
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the bike name of this bike.
	 *
	 * @return the bike name of this bike
	 */
	@AutoEscape
	public String getBikeName();

	/**
	 * Sets the bike name of this bike.
	 *
	 * @param bikeName the bike name of this bike
	 */
	public void setBikeName(String bikeName);

	/**
	 * Returns the brand of this bike.
	 *
	 * @return the brand of this bike
	 */
	@AutoEscape
	public String getBrand();

	/**
	 * Sets the brand of this bike.
	 *
	 * @param brand the brand of this bike
	 */
	public void setBrand(String brand);

	/**
	 * Returns the student ID of this bike.
	 *
	 * @return the student ID of this bike
	 */
	public long getStudentId();

	/**
	 * Sets the student ID of this bike.
	 *
	 * @param studentId the student ID of this bike
	 */
	public void setStudentId(long studentId);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(Bike bike);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Bike> toCacheModel();

	@Override
	public Bike toEscapedModel();

	@Override
	public Bike toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}