create index IX_6E46BCFE on persondetails (userId, FirstName[$COLUMN_LENGTH:75$]);
create index IX_33DD9507 on persondetails (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_5805B149 on persondetails (uuid_[$COLUMN_LENGTH:75$], groupId);