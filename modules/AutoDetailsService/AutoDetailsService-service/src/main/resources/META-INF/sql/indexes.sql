create index IX_85182826 on autodetails (userId, Model[$COLUMN_LENGTH:75$]);
create index IX_6289B6C4 on autodetails (userId, Year);
create index IX_C7B6AA6D on autodetails (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_31D0E82F on autodetails (uuid_[$COLUMN_LENGTH:75$], groupId);