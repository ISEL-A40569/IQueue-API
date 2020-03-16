
go

--create database iqueuedb

go

create table iqueuedb.dbo.UserProfile(
userProfileId int primary key,
userProfileDescription varchar(50) not null
)

go

create table iqueuedb.dbo.[User](
userId int identity primary key,
userName varchar(100) not null,
email varchar(100) not null,
phoneNumber int,
[address] varchar(200),
userProfileId int not null references iqueuedb.dbo.UserProfile(userProfileId),
)

go

create table iqueuedb.dbo.Operator(
operatorId int identity primary key,
operatorDescription varchar(100) not null,
email varchar(100),
phoneNumber int,
[address] varchar(200),
)

go

create table iqueuedb.dbo.OperatorUser(
operatorId int references iqueuedb.dbo.Operator(operatorId),
userId int  references iqueuedb.dbo.[User](userId),
primary key(operatorId, userId),
)

go

create table iqueuedb.dbo.Beacon(
beaconMacAddress varchar(12) primary key,
uidNamespaceId varchar(10) not null,
uidInstanceId varchar(6) not null,
ibeaconUuid varchar(32) not null,
ibeaconMajor int not null,
ibeaconMinor int not null,
manufacturer varchar(50) not null,
model varchar(50) not null
)

go

create table iqueuedb.dbo.OperatorBeacon(
operatorId int references iqueuedb.dbo.Operator(operatorId), 
beaconMacAddress varchar(12) references iqueuedb.dbo.Beacon,
primary key(operatorId, beaconMacAddress),
)

go

create table iqueuedb.dbo.ServiceQueueType(
serviceQueueTypeId int primary key,
serviceQueueTypeDescription varchar(50) not null
)

go

create table iqueuedb.dbo.OperatorServiceQueue(
operatorId int,
operatorServiceQueueId int identity ,
operatorServiceQueueDescription varchar(100) not null,
serviceQueueTypeId int not null references iqueuedb.dbo.ServiceQueueType(serviceQueueTypeId),
daylyLimit int,
primary key(operatorId, operatorServiceQueueId),
)

go 

create table iqueuedb.dbo.Client(
clientId int identity primary key,
clientName varchar(100) not null,
email varchar(100) not null
)

go

create table iqueuedb.dbo.AttendanceStatus(
AttendanceStatusId int primary key,
AttendanceStatusDescription varchar(50) not null
)

go


create table iqueuedb.dbo.ServiceQueueDesk(
operatorId int,
operatorServiceQueueId int,
deskId int,
primary key(operatorId, operatorServiceQueueId, deskId),
foreign key(operatorId, operatorServiceQueueId) references iqueuedb.dbo.OperatorServiceQueue(operatorId, operatorServiceQueueId)
)

go

create table iqueuedb.dbo.ServiceQueueDeskUser(
operatorId int,
operatorServiceQueueId int,
deskId int,
userId int,
[date] date not null,
primary key(operatorId, operatorServiceQueueId, deskId, userId, [date]),
foreign key(operatorId, operatorServiceQueueId) references iqueuedb.dbo.OperatorServiceQueue(operatorId, operatorServiceQueueId),
foreign key(userId) references iqueuedb.dbo.[User](userId)
)

go

create table iqueuedb.dbo.Attendance(
operatorId int,
operatorServiceQueueId int,
deskId int,
clientId int references iqueuedb.dbo.Client(clientId),
startWaitingTime datetime,
endWaitingTime datetime,
startAttendanceTime datetime,
endAttendanceTime datetime,
attendanceStatusId int not null references iqueuedb.dbo.AttendanceStatus(attendanceStatusId),
attendanceUserId int not null references iqueuedb.dbo.[User](userId),
primary key(operatorId, operatorServiceQueueId, deskId, clientId, startWaitingTime),
foreign key(operatorId, operatorServiceQueueId, deskId) references iqueuedb.dbo.ServiceQueueDesk(operatorId, operatorServiceQueueId, deskId)
)

go

create table iqueuedb.dbo.AttendanceClassification(
operatorId int,
operatorServiceQueueId int,
deskId int,
clientId int,
startWaitingTime datetime,
classificationCreationTime datetime,
rate int not null,
observations varchar(200),
primary key(operatorId, operatorServiceQueueId, deskId, clientId, startWaitingTime, classificationCreationTime),
foreign key(operatorId, operatorServiceQueueId, deskId, clientId, startWaitingTime) 
references iqueuedb.dbo.Attendance(operatorId, operatorServiceQueueId, deskId, clientId, startWaitingTime)
)

go

