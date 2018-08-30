create table autodetails (
	uuid_ VARCHAR(75) null,
	autodetailId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	Model VARCHAR(75) null,
	VIN VARCHAR(75) null,
	Year INTEGER,
	Manufacturer VARCHAR(75) null,
	Bodystyle VARCHAR(75) null
);