create table FOO_Bike (
	uuid_ VARCHAR(75) null,
	bikeId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	bikeName VARCHAR(75) null,
	brand VARCHAR(75) null,
	studentId LONG
);

create table Student (
	uuid_ VARCHAR(75) null,
	StudentId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	Code VARCHAR(75) null,
	FullName VARCHAR(75) null,
	Birthday DATE null,
	Gender BOOLEAN,
	Address VARCHAR(75) null
);