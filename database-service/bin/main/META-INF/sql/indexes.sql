create index IX_44A10F37 on FOO_Bike (brand[$COLUMN_LENGTH:75$]);
create index IX_85109D3C on FOO_Bike (groupId, studentId);
create index IX_E2C2CDA6 on FOO_Bike (studentId);
create index IX_D38D5734 on FOO_Bike (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_2F2A1AB6 on FOO_Bike (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_1B738522 on Student (Code[$COLUMN_LENGTH:75$]);
create index IX_CC7FA8E on Student (Gender, Address[$COLUMN_LENGTH:75$]);
create index IX_202F5ED5 on Student (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_FA3B9697 on Student (uuid_[$COLUMN_LENGTH:75$], groupId);