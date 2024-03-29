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

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import kwan.org.database.model.Bike;
import kwan.org.database.model.BikeModel;
import kwan.org.database.model.BikeSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Bike service. Represents a row in the &quot;FOO_Bike&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link BikeModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link BikeImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BikeImpl
 * @see Bike
 * @see BikeModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class BikeModelImpl extends BaseModelImpl<Bike> implements BikeModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a bike model instance should use the {@link Bike} interface instead.
	 */
	public static final String TABLE_NAME = "FOO_Bike";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "bikeId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "bikeName", Types.VARCHAR },
			{ "brand", Types.VARCHAR },
			{ "studentId", Types.BIGINT }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("bikeId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("bikeName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("brand", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("studentId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE = "create table FOO_Bike (uuid_ VARCHAR(75) null,bikeId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,bikeName VARCHAR(75) null,brand VARCHAR(75) null,studentId LONG)";
	public static final String TABLE_SQL_DROP = "drop table FOO_Bike";
	public static final String ORDER_BY_JPQL = " ORDER BY bike.bikeId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY FOO_Bike.bikeId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(kwan.org.database.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.kwan.org.database.model.Bike"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(kwan.org.database.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.kwan.org.database.model.Bike"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(kwan.org.database.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.kwan.org.database.model.Bike"),
			true);
	public static final long BRAND_COLUMN_BITMASK = 1L;
	public static final long COMPANYID_COLUMN_BITMASK = 2L;
	public static final long GROUPID_COLUMN_BITMASK = 4L;
	public static final long STUDENTID_COLUMN_BITMASK = 8L;
	public static final long UUID_COLUMN_BITMASK = 16L;
	public static final long BIKEID_COLUMN_BITMASK = 32L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Bike toModel(BikeSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Bike model = new BikeImpl();

		model.setUuid(soapModel.getUuid());
		model.setBikeId(soapModel.getBikeId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setBikeName(soapModel.getBikeName());
		model.setBrand(soapModel.getBrand());
		model.setStudentId(soapModel.getStudentId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Bike> toModels(BikeSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Bike> models = new ArrayList<Bike>(soapModels.length);

		for (BikeSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(kwan.org.database.service.util.ServiceProps.get(
				"lock.expiration.time.kwan.org.database.model.Bike"));

	public BikeModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _bikeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setBikeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _bikeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
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
	public long getBikeId() {
		return _bikeId;
	}

	@Override
	public void setBikeId(long bikeId) {
		_bikeId = bikeId;
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
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
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
	public String getBikeName() {
		if (_bikeName == null) {
			return "";
		}
		else {
			return _bikeName;
		}
	}

	@Override
	public void setBikeName(String bikeName) {
		_bikeName = bikeName;
	}

	@JSON
	@Override
	public String getBrand() {
		if (_brand == null) {
			return "";
		}
		else {
			return _brand;
		}
	}

	@Override
	public void setBrand(String brand) {
		_columnBitmask |= BRAND_COLUMN_BITMASK;

		if (_originalBrand == null) {
			_originalBrand = _brand;
		}

		_brand = brand;
	}

	public String getOriginalBrand() {
		return GetterUtil.getString(_originalBrand);
	}

	@JSON
	@Override
	public long getStudentId() {
		return _studentId;
	}

	@Override
	public void setStudentId(long studentId) {
		_columnBitmask |= STUDENTID_COLUMN_BITMASK;

		if (!_setOriginalStudentId) {
			_setOriginalStudentId = true;

			_originalStudentId = _studentId;
		}

		_studentId = studentId;
	}

	public long getOriginalStudentId() {
		return _originalStudentId;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				Bike.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Bike.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Bike toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Bike)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		BikeImpl bikeImpl = new BikeImpl();

		bikeImpl.setUuid(getUuid());
		bikeImpl.setBikeId(getBikeId());
		bikeImpl.setGroupId(getGroupId());
		bikeImpl.setCompanyId(getCompanyId());
		bikeImpl.setUserId(getUserId());
		bikeImpl.setUserName(getUserName());
		bikeImpl.setCreateDate(getCreateDate());
		bikeImpl.setModifiedDate(getModifiedDate());
		bikeImpl.setBikeName(getBikeName());
		bikeImpl.setBrand(getBrand());
		bikeImpl.setStudentId(getStudentId());

		bikeImpl.resetOriginalValues();

		return bikeImpl;
	}

	@Override
	public int compareTo(Bike bike) {
		long primaryKey = bike.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Bike)) {
			return false;
		}

		Bike bike = (Bike)obj;

		long primaryKey = bike.getPrimaryKey();

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
		BikeModelImpl bikeModelImpl = this;

		bikeModelImpl._originalUuid = bikeModelImpl._uuid;

		bikeModelImpl._originalGroupId = bikeModelImpl._groupId;

		bikeModelImpl._setOriginalGroupId = false;

		bikeModelImpl._originalCompanyId = bikeModelImpl._companyId;

		bikeModelImpl._setOriginalCompanyId = false;

		bikeModelImpl._setModifiedDate = false;

		bikeModelImpl._originalBrand = bikeModelImpl._brand;

		bikeModelImpl._originalStudentId = bikeModelImpl._studentId;

		bikeModelImpl._setOriginalStudentId = false;

		bikeModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Bike> toCacheModel() {
		BikeCacheModel bikeCacheModel = new BikeCacheModel();

		bikeCacheModel.uuid = getUuid();

		String uuid = bikeCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			bikeCacheModel.uuid = null;
		}

		bikeCacheModel.bikeId = getBikeId();

		bikeCacheModel.groupId = getGroupId();

		bikeCacheModel.companyId = getCompanyId();

		bikeCacheModel.userId = getUserId();

		bikeCacheModel.userName = getUserName();

		String userName = bikeCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			bikeCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			bikeCacheModel.createDate = createDate.getTime();
		}
		else {
			bikeCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			bikeCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			bikeCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		bikeCacheModel.bikeName = getBikeName();

		String bikeName = bikeCacheModel.bikeName;

		if ((bikeName != null) && (bikeName.length() == 0)) {
			bikeCacheModel.bikeName = null;
		}

		bikeCacheModel.brand = getBrand();

		String brand = bikeCacheModel.brand;

		if ((brand != null) && (brand.length() == 0)) {
			bikeCacheModel.brand = null;
		}

		bikeCacheModel.studentId = getStudentId();

		return bikeCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", bikeId=");
		sb.append(getBikeId());
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
		sb.append(", bikeName=");
		sb.append(getBikeName());
		sb.append(", brand=");
		sb.append(getBrand());
		sb.append(", studentId=");
		sb.append(getStudentId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("kwan.org.database.model.Bike");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bikeId</column-name><column-value><![CDATA[");
		sb.append(getBikeId());
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
			"<column><column-name>bikeName</column-name><column-value><![CDATA[");
		sb.append(getBikeName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>brand</column-name><column-value><![CDATA[");
		sb.append(getBrand());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>studentId</column-name><column-value><![CDATA[");
		sb.append(getStudentId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = Bike.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			Bike.class, ModelWrapper.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _bikeId;
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
	private String _bikeName;
	private String _brand;
	private String _originalBrand;
	private long _studentId;
	private long _originalStudentId;
	private boolean _setOriginalStudentId;
	private long _columnBitmask;
	private Bike _escapedModel;
}