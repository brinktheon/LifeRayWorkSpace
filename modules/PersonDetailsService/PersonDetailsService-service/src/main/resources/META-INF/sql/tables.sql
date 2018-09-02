create table persondetails (
	uuid_ VARCHAR(75) null,
	PersonDetailId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	FirstName VARCHAR(75) null,
	SecondName VARCHAR(75) null,
	Age INTEGER,
	Specialty VARCHAR(75) null,
	Experience VARCHAR(75) null
);