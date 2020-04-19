use iqueuedb

-- Language SPs

go

create or alter procedure SelectLanguage @languageId int
as
declare @query nvarchar(max),
		@params nvarchar(max)

set @query = 'select * from [Language]'

set @params = '@languageId INT'

if @languageId is not null
begin
	set @query = @query + ' where languageId = @languageId'
end

exec sp_executesql @query, @params, @languageId = @languageId

go

create or alter procedure InsertLanguage @languageId int, @languageDescription varchar(20)
as
begin transaction set transaction isolation level serializable
begin try
insert into [Language] values (@languageId, @languageDescription)
commit
end try
begin catch
rollback
end catch

go

create or alter procedure DeleteLanguage @languageId int
as
begin transaction set transaction isolation level serializable
begin try
delete [Language] where languageId = @languageId
commit
end try
begin catch
rollback
end catch

go

create or alter procedure UpdateLanguage @languageId int, @languageDescription varchar(20)
as
begin transaction set transaction isolation level serializable
begin try
update [Language] 
	set languageDescription = @languageDescription 
	where languageId = @languageId
commit
end try
begin catch
rollback
end catch

go

-- UserProfile SPs

create or alter procedure SelectUserProfile @userProfileId int, @languageId int
as

declare @query nvarchar(max),
		@params nvarchar(max)

set @query = 'select * from UserProfile'

set @params = '@userProfileId int, @languageId int'

	if @userProfileId is not null and @languageId is not null
	begin
		set @query = @query + ' where userProfileId = @userProfileId and languageId = @languageId'
	end

	if @userProfileId is null and @languageId is not null
	begin
		set @query = @query + ' where languageId = @languageId'
	end

	exec sp_executesql @query, @params, @userProfileId = @userProfileId, @languageId = @languageId

go

create or alter procedure InsertUserProfile @userProfileId int, @languageId int, @userProfileDescription varchar(50)
as
begin transaction set transaction isolation level serializable
begin try
insert into UserProfile values (@userProfileId, @languageId, @userProfileDescription)
commit
end try
begin catch
rollback
end catch

go

create or alter procedure DeleteUserProfile @userProfileId int, @languageId int
as
declare @query nvarchar(max),
		@params nvarchar(max)

set @query = 'delete UserProfile'

set @params = '@userProfileId int, @languageId int'
begin transaction set transaction isolation level serializable
begin try
if @userProfileId is not null and @languageId is not null
begin
	set @query = @query + ' where userProfileId = @userProfileId and languageId = @languageId'
end

if @userProfileId is not null and @languageId is null
begin
	set @query = @query + ' where userProfileId = @userProfileId'
end

if @userProfileId is null and @languageId is not null
begin
	set @query = @query + ' where languageId = @languageId'
end

exec sp_executesql @query, @params, @userProfileId = @userProfileId, @languageId = @languageId
commit
end try
begin catch
rollback
end catch

go

create or alter procedure UpdateUserProfile @userProfileId int, @languageId int, @userProfileDescription varchar(50)
as
begin transaction set transaction isolation level serializable
begin try
update UserProfile 
	set userProfileDescription = @userProfileDescription 
	where userProfileId  = @userProfileId and languageId = @languageId
commit
end try
begin catch
rollback
end catch

go

-- User SPs

create or alter procedure SelectUser @userId int
as
 
declare @query nvarchar(max),
		@params nvarchar(max)

set @query = 'select * from [User]'

set @params = '@userId int'

if @userId is not null
begin
	set @query = @query + ' where userId = @userId'
end

exec sp_executesql @query, @params, @userId = @userId

go

create or alter procedure InsertUser @userName varchar(100), @email varchar(100), @phoneNumber int, @address varchar(200), @userProfileId int
as
begin transaction set transaction isolation level serializable
begin try
insert into [User] values (@userName, @email, @phoneNumber, @address, @userProfileId)
select scope_identity()
commit
end try
begin catch
rollback
end catch

go

create or alter procedure DeleteUser @userId int
as
begin transaction set transaction isolation level serializable
begin try
delete [User] where userId = @userId
commit
end try
begin catch
rollback
end catch

go

create or alter procedure UpdateUser @userId int, @userName varchar(100), @email varchar(100), 
									@phoneNumber int, @address varchar(200), @userProfileId int 
as
begin transaction set transaction isolation level serializable
begin try
update [User] 
set userName = @userName,
	email = @email,
	phoneNumber = @phoneNumber,
	[address] = @address,
	userProfileId = @userProfileId
where userId  = @userId 
commit
end try
begin catch
rollback
end catch

go

-- ServiceQueueType SPs

create or alter procedure SelectServiceQueueType @serviceQueueTypeId int, @languageId int
as

declare @query nvarchar(max),
		@params nvarchar(max)

set @query = 'select * from ServiceQueueType'

set @params = '@serviceQueueTypeId int, @languageId int'

if @serviceQueueTypeId is not null and @languageId is not null
begin
	set @query = @query + ' where serviceQueueTypeId = @serviceQueueTypeId and languageId = @languageId'
end

if @serviceQueueTypeId is null and @languageId is not null
begin
set @query = @query + ' where languageId = @languageId'
end

exec sp_executesql @query, @params, @serviceQueueTypeId = @serviceQueueTypeId, @languageId = @languageId

go

create or alter procedure InsertServiceQueueType @serviceQueueTypeId int, @languageId int, @serviceQueueTypeDescription varchar(50)
as
begin transaction set transaction isolation level serializable
begin try
insert into ServiceQueueType values (@serviceQueueTypeId, @languageId, @serviceQueueTypeDescription)
commit
end try
begin catch
rollback
end catch

go

create or alter procedure DeleteServiceQueueType @serviceQueueTypeId int, @languageId int
as
declare @query nvarchar(max),
		@params nvarchar(max)

set @query = 'delete ServiceQueueType'

set @params = '@serviceQueueTypeId int, @languageId int'
begin transaction set transaction isolation level serializable
begin try
if @serviceQueueTypeId is not null and @languageId is not null
begin
	set @query = @query + ' where serviceQueueTypeId = @serviceQueueTypeId and languageId = @languageId'
end

if @serviceQueueTypeId is not null and @languageId is null
begin
	set @query = @query + ' where serviceQueueTypeId = @serviceQueueTypeId'
end

if @serviceQueueTypeId is null and @languageId is not null
begin
	set @query = @query + ' where languageId = @languageId'
end

exec sp_executesql @query, @params, @serviceQueueTypeId = @serviceQueueTypeId, @languageId = @languageId

delete ServiceQueueType where serviceQueueTypeId = @serviceQueueTypeId and languageId = @languageId
commit
end try
begin catch
rollback
end catch

go

create  or alter procedure UpdateServiceQueueType @serviceQueueTypeId int, @languageId int, @serviceQueueTypeDescription varchar(50)
as
begin transaction set transaction isolation level serializable
begin try
update ServiceQueueType 
set serviceQueueTypeDescription = @serviceQueueTypeDescription 
where serviceQueueTypeId  = @serviceQueueTypeId and languageId = @languageId
commit
end try
begin catch
rollback
end catch

go

-- ServiceQueueDeskUser SPs

create or alter procedure SelectServiceQueueDeskUser @operatorId int, @serviceQueueId int, @deskId int, @userId int, @date date
as

declare @query nvarchar(max),
		@params nvarchar(max)

set @query = 'select * from ServiceQueueDeskUser'

set @params = '@operatorId int, @serviceQueueId int, @deskId int, @userId int, @date date'

if @operatorId is not null
begin
	set @query = @query + ' where operatorId = @operatorId'

	if @serviceQueueId is not null
	begin
	set @query = @query + ' and serviceQueueId = @serviceQueueId'
	end

	if @deskId is not null
	begin
	set @query = @query + ' and deskId = @deskId'
	end

	if @userId is not null
	begin
	set @query = @query + ' and userId = @userId'
	end
end
else
begin
	if @userId is not null
	begin
	set @query = @query + ' where userId = @userId'
	end
end

if @date is not null
begin
	set @query = @query + ' and [date] = @date'
end

exec sp_executesql @query, @params, @operatorId = @operatorId, @serviceQueueId = @serviceQueueId, 
				@deskId = @deskId, @userId = @userId, @date = @date

go

create or alter procedure InsertServiceQueueDeskUser @operatorId int, @serviceQueueId int, @deskId int, @userId int, @date date
as
begin transaction set transaction isolation level serializable
begin try
insert into ServiceQueueDeskUser values (@operatorId, @serviceQueueId, @deskId, @userId, @date)
commit
end try
begin catch
rollback
end catch

go
-- TODO: review this SP query
create or alter procedure DeleteServiceQueueDeskUser @operatorId int, @serviceQueueId int, @deskId int, @userId int, @date date
as
begin transaction set transaction isolation level serializable
begin try
delete ServiceQueueDeskUser where operatorId = @operatorId and 
								serviceQueueId = @serviceQueueId and
								deskId = @deskId and 
								userId = @userId and
								[date] = @date
commit
end try
begin catch
rollback
end catch
go

-- ServiceQueueDesk SPs

create or alter procedure SelectServiceQueueDesk @operatorId int, @serviceQueueId int
as

declare @query nvarchar(max),
		@params nvarchar(max)

set @query = 'select * from ServiceQueueDesk'

set @params = '@operatorId int, @serviceQueueId int'

if @operatorId is not null and @serviceQueueId is not null
begin
	set @query = @query + ' where operatorId = @operatorId and serviceQueueId = @serviceQueueId'
end

exec sp_executesql @query, @params, @operatorId = @operatorId, @serviceQueueId = @serviceQueueId

go

create or alter procedure InsertServiceQueueDesk  @operatorId int, @serviceQueueId int, @deskDescription varchar(50)
as
begin transaction set transaction isolation level serializable
begin try
insert into ServiceQueueDesk values( @operatorId, @serviceQueueId, @deskDescription)
select scope_identity()
commit
end try
begin catch
rollback
end catch

go

create or alter procedure UpdateServiceQueueDesk  @deskId int, @deskDescription varchar(50)
as
begin transaction set transaction isolation level serializable
begin try
update ServiceQueueDesk set deskDescription = @deskDescription
where deskId = @deskId
commit
end try
begin catch
rollback
end catch

go

create or alter procedure DeleteServiceQueueDesk @operatorId int, @serviceQueueId int, @deskId int 
as
begin transaction set transaction isolation level serializable
begin try
delete ServiceQueueDesk where deskId = @deskId and
operatorId = @operatorId and
serviceQueueId = @serviceQueueId
commit
end try
begin catch
rollback
end catch

go

create or alter procedure UpdateServiceQueueDesk @deskId int, @deskDescription varchar(50)--, @operatorId int, @serviceQueueId int,
as
begin transaction set transaction isolation level serializable
begin try
update ServiceQueueDesk set deskDescription = @deskDescription
where deskId = @deskId
commit
end try
begin catch
rollback
end catch

go

-- OperatorUser SPs

create or alter procedure SelectOperatorUser @operatorId int, @userId int
as

declare @query nvarchar(max),
		@params nvarchar(max)

set @query = 'select * from OperatorUser'

set @params = '@operatorId int, @userId int'

if @operatorId is not null
begin
	set @query = @query + ' where operatorId = @operatorId'
end

if @userId is not null
begin
	set @query = @query + ' where userId = @userId'
end

exec sp_executesql @query, @params, @operatorId = @operatorId, @userId = @userId 

go

create or alter procedure InsertOperatorUser @operatorId int, @userId int
as
begin transaction set transaction isolation level serializable
begin try
insert into OperatorUser values(@operatorId, @userId)
commit
end try
begin catch
rollback
end catch

go

create or alter procedure DeleteOperatorUser  @operatorId int, @userId int
as
begin transaction set transaction isolation level serializable
begin try
delete OperatorUser where operatorId = @operatorId and
							userId = @userId
end try
begin catch
rollback
end catch

go

-- OperatorServiceQueue SPs

create or alter procedure SelectOperatorServiceQueue @operatorId int, @serviceQueueId int
as

declare @query nvarchar(max),
		@params nvarchar(max)

set @query = 'select * from OperatorServiceQueue'

set @params = '@operatorId int, @serviceQueueId int'

if @operatorId is not null
begin
	set @query = @query + ' where operatorId = @operatorId'
end

if @serviceQueueId is not null
begin
	set @query = @query + ' and serviceQueueId = @serviceQueueId'
end

exec sp_executesql @query, @params, @operatorId = @operatorId, @serviceQueueId = @serviceQueueId

go

create or alter procedure InsertOperatorServiceQueue @operatorId int, @serviceQueueDescription varchar(100),
													@serviceQueueTypeId int, @dailyLimit int
as
begin transaction set transaction isolation level serializable
begin try
insert into OperatorServiceQueue values(@operatorId, @serviceQueueDescription, @serviceQueueTypeId, @dailyLimit)
select scope_identity()
commit
end try
begin catch
rollback
end catch

go

create or alter procedure DeleteOperatorServiceQueue @operatorId int, @serviceQueueId int
as
begin transaction set transaction isolation level serializable
begin try
delete OperatorServiceQueue where operatorId = @operatorId and
								serviceQueueId = @serviceQueueId
commit
end try
begin catch
rollback
end catch

go

create or alter procedure UpdateOperatorServiceQueue @operatorId int, @serviceQueueId int, @serviceQueueDescription varchar(100),
													@serviceQueueTypeId int, @dailyLimit int
as
begin transaction set transaction isolation level serializable
begin try
update OperatorServiceQueue set serviceQueueDescription = @serviceQueueDescription, 
								serviceQueueTypeId = @serviceQueueTypeId, 
								dailyLimit = @dailyLimit
where operatorId = @operatorId and
	  serviceQueueId = @serviceQueueId
commit
end try
begin catch
rollback
end catch

go

-- OperatorBeacon SPs

create or alter procedure SelectOperatorBeacon @operatorId int, @beaconId int
as

declare @query nvarchar(max),
		@params nvarchar(max)

set @query = 'select * from OperatorBeacon'

set @params = '@operatorId int, @beaconId int'

if @operatorId is not null
begin 
	set @query = @query + ' where operatorId = @operatorId'
end

if @beaconId is not null
begin 
	set @query = @query + ' where beaconId = @beaconId'
end

exec sp_executesql @query, @params, @operatorId = @operatorId, @beaconId = @beaconId

go

create or alter procedure InsertOperatorBeacon @operatorId int, @beaconId int
as
begin transaction set transaction isolation level serializable
begin try
insert into OperatorBeacon  values(@operatorId, @beaconId)
commit
end try
begin catch
rollback
end catch

go

create or alter procedure DeleteOperatorBeacon @operatorId int, @beaconId int
as
begin transaction set transaction isolation level serializable
begin try
delete OperatorBeacon where operatorId = @operatorId and
							beaconId = @beaconId
commit
end try
begin catch
rollback
end catch

go

-- Operator SPs
create or alter procedure SelectOperator @operatorId int
as

declare @query nvarchar(max),
		@params nvarchar(max)

set @query = 'select * from Operator'

set @params = '@operatorId int'

if @operatorId is not null
begin
	set @query = @query + ' where operatorId = @operatorId'
end

exec sp_executesql @query, @params, @operatorId = @operatorId

go

create or alter procedure InsertOperator @operatorDescription varchar(100), @email varchar(100), @phoneNumber int, @address varchar(200)
as
begin transaction set transaction isolation level serializable
begin try
insert into Operator values(@operatorDescription, @email, @phoneNumber, @address)
select scope_identity()
commit
end try
begin catch
rollback
end catch

go

create or alter procedure DeleteOperator @operatorId int
as
begin transaction set transaction isolation level serializable
begin try
delete Operator where operatorId = @operatorId
commit
end try
begin catch
rollback
end catch

go

create or alter procedure UpdateOperator @operatorId int, @operatorDescription varchar(100), 
										@email varchar(100), @phoneNumber int, @address varchar(200)
as
begin transaction set transaction isolation level serializable
begin try
update Operator set operatorDescription = @operatorDescription,
					email = @email,
					phoneNumber = @phoneNumber,
					[address] = @address
where operatorId = @operatorId
commit
end try
begin catch
rollback
end catch

go

-- Client SPs
create or alter procedure SelectClient @clientId int
as
declare @query nvarchar(max),
		@params nvarchar(max)

set @query = 'select * from Client'

set @params = '@clientId int'

if @clientId is not null
begin
	set @query = @query + ' where clientId = @clientId'
end

exec sp_executesql @query, @params, @clientId = @clientId

go

create or alter procedure InsertClient @clientName varchar(100), @email varchar(100)
as
begin transaction set transaction isolation level serializable
begin try
insert into Client values(@clientName, @email)
select scope_identity()
commit
end try
begin catch
rollback
end catch

go

create or alter procedure UpdateClient @clientId int, @clientName varchar(100), @email varchar(100)
as
begin transaction set transaction isolation level serializable
begin try
update Client set clientName = @clientName, 
				email = @email
				where clientId = @clientId
commit
end try
begin catch
rollback
end catch

go

create or alter procedure DeleteClient @clientId int
as
begin transaction set transaction isolation level serializable
begin try
delete Client where clientId = @clientId
commit
end try
begin catch
rollback
end catch

go

-- Beacon SPs
create or alter procedure SelectBeacon @beaconId int
as
declare @query nvarchar(max),
		@params nvarchar(max)

set @query = 'select * from Beacon'

set @params = '@beaconId int'

if @beaconId is not null
begin
	set @query = @query + ' where beaconId = @beaconId'
end

exec sp_executesql @query, @params, @beaconId = @beaconId

go

create or alter procedure InsertBeacon @beaconMacAddress varchar(12), @uidNamespaceId varchar(10), @uidInstanceId varchar(6),
@ibeaconUuid varchar(32), @ibeaconMajor int, @ibeaconMinor int, @manufacturer varchar(50), @model varchar(50)
as
begin transaction set transaction isolation level serializable
begin try
insert into Beacon values(@beaconMacAddress, @uidNamespaceId, @uidInstanceId, @ibeaconUuid, @ibeaconMajor, @ibeaconMinor,
@manufacturer, @model)
select scope_identity()
commit
end try
begin catch
rollback
end catch

go

create or alter procedure UpdateBeacon @beaconId int, @uidNamespaceId varchar(10), @uidInstanceId varchar(6),
@ibeaconUuid varchar(32), @ibeaconMajor int, @ibeaconMinor int, @manufacturer varchar(50), @model varchar(50)
as
begin transaction set transaction isolation level serializable
begin try
update Beacon set uidNamespaceId = @uidNamespaceId,
					uidInstanceId =@uidInstanceId,
					ibeaconUuid = @ibeaconUuid,
					ibeaconMajor = @ibeaconMajor,
					ibeaconMinor = @ibeaconMinor,
					manufacturer = @manufacturer,
					model = @model
					where beaconId = @beaconId
commit
end try
begin catch
rollback
end catch

go

create or alter procedure DeleteBeacon @beaconId int
as
begin transaction set transaction isolation level serializable
begin try
delete Beacon where beaconId = @beaconId
commit
end try
begin catch
rollback
end catch

go

-- AttendanceStatus SPs
create or alter procedure SelectAttendanceStatus @attendanceStatusId int, @languageId int
as

declare @query nvarchar(max),
		@params nvarchar(max)

set @query = 'select * from AttendanceStatus'

set @params = '@attendanceStatusId int, @languageId int'

	if @attendanceStatusId is not null and @languageId is not null
	begin
		set @query = @query + ' where attendanceStatusId = @attendanceStatusId and languageId = @languageId'
	end

	if @attendanceStatusId is null and @languageId is not null
	begin
		set @query = @query + ' where languageId = @languageId'
	end

	exec sp_executesql @query, @params, @attendanceStatusId = @attendanceStatusId, @languageId = @languageId

go

create or alter procedure InsertAttendanceStatus @attendanceStatusId int, @languageId int, @attendanceStatusDescription varchar(50) 
as
begin transaction set transaction isolation level serializable
begin try
insert into AttendanceStatus values(@attendanceStatusId, @languageId, @attendanceStatusDescription)
select scope_identity()
commit
end try
begin catch
rollback
end catch

go

create or alter procedure DeleteAttendanceStatus @attendanceStatusId int, @languageId int
as
begin transaction set transaction isolation level serializable
begin try
delete AttendanceStatus where attendanceStatusId = @attendanceStatusId and
							languageId = @languageId
commit
end try
begin catch
rollback
end catch

go

create or alter procedure UpdateAttendanceStatus @attendanceStatusId int, @languageId int, @attendanceStatusDescription varchar(50) 
as
begin transaction set transaction isolation level serializable
begin try
update AttendanceStatus set attendanceStatusDescription = @attendanceStatusDescription
where attendanceStatusId = @attendanceStatusId and
		languageId = @languageId
commit
end try
begin catch
rollback
end catch

go

-- AttendanceClassification SPs

create or alter procedure SelectAttendanceClassification @attendanceId int
as

declare @query nvarchar(max),
		@params nvarchar(max)

set @query = 'select * from AttendanceClassification'

set @params = '@attendanceId int'

	if @attendanceId is not null
	begin
		set @query = @query + ' where attendanceId = @attendanceId'
	end

	exec sp_executesql @query, @params, @attendanceId = @attendanceId

go

create or alter procedure InsertAttendanceClassification @attendanceId int, @classificationCreationTime datetime,
@rate int, @observations varchar(200)
as
begin transaction set transaction isolation level serializable
begin try
insert into AttendanceClassification values(@attendanceId, @classificationCreationTime, @rate, @observations)
commit
end try
begin catch
rollback
end catch

go

create or alter procedure DeleteAttendanceClassification @attendanceId int
as
begin transaction set transaction isolation level serializable
begin try
delete AttendanceClassification where attendanceId = @attendanceId
commit
end try
begin catch
rollback
end catch

go

-- Attendance SPs

create or alter procedure SelectAttendance @attendanceId int, @operatorId int, @serviceQueueId int, @deskId int, @clientId int,
@startWaitingTime datetime
as

declare @query nvarchar(max),
		@params nvarchar(max)

set @query = 'select * from Attendance'

set @params = '@attendanceId int, @operatorId int, @serviceQueueId int, @deskId int, @clientId int, @startWaitingTime datetime'

	if @attendanceId is not null
	begin
		set @query = @query + ' where attendanceId = @attendanceId'
	end
	else
	begin
		if @operatorId is not null
		begin
			set @query = @query + 'where operatorId = @operatorId'
		end

		if @serviceQueueId is not null
		begin
			set @query = @query + ' and serviceQueueId = @serviceQueueId'
		end

		if @deskId is not null
		begin
			set @query = @query + ' and deskId = @deskId'
		end

		if @clientId is not null
		begin
			set @query = @query + ' and clientId = @clientId'
		end

		if @startWaitingTime is not null
		begin
			set @query = @query + ' and startWaitingTime = @startWaitingTime'
		end

	end

	exec sp_executesql @query, @params, @attendanceId = @attendanceId, @operatorId = @operatorId, @serviceQueueId = @serviceQueueId,
	@deskId = @deskId, @clientId = @clientId, @startWaitingTime = @startWaitingTime

go

create or alter procedure InsertAttendance @operatorId int, @serviceQueueId int, @deskId int, @clientId int,
@startWaitingTime datetime, @attendanceStatusId int, @attendanceUserId int
as
begin transaction set transaction isolation level serializable
begin try
insert into Attendance values(@operatorId, @serviceQueueId, @deskId, @clientId, @startWaitingTime, null, null, null, @attendanceStatusId, @attendanceUserId)
select scope_identity()
commit
end try
begin catch
rollback
end catch

go

create or alter procedure DeleteAttendance @attendanceId int
as
begin transaction set transaction isolation level serializable
begin try
delete Attendance where attendanceId = @attendanceId
commit
end try
begin catch
rollback
end catch

go

create or alter procedure UpdateAttendance @attendanceId int, @endWaitingTime datetime, @startAttendanceTime datetime,
@endAttendanceTime datetime, @attendanceStatusId int
as
begin transaction set transaction isolation level serializable
begin try
update Attendance set endWaitingTime = @endWaitingTime,
startAttendanceTime = @startAttendanceTime,
endAttendanceTime = @endAttendanceTime,
attendanceStatusId = @attendanceStatusId
where attendanceId = @attendanceId
commit
end try
begin catch
rollback
end catch