
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
beaconId varchar(32) primary key,
latitude numeric(10,8),
longitude numeric(10,8),
manufacturer varchar(50),
model varchar(50),
serialNumber varchar(32)
)

go

create table iqueuedb.dbo.OperatorBeacon(
operatorId int references iqueuedb.dbo.Operator(operatorId), 
beaconId varchar(32) references iqueuedb.dbo.Beacon,
primary key(operatorId, beaconId),
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
clientId int,
[date] date,
startWaitingTime time,
endWaitingTime time,
startAttendanceTime time,
endAttendanceTime time,
attendanceStatusId int not null,
attendanceUserId int not null references [User](userId),
primary key(operatorId, operatorServiceQueueId, deskId, clientId, [date], startWaitingTime),
foreign key(operatorId, operatorServiceQueueId, deskId) references iqueuedb.dbo.ServiceQueueDesk(operatorId, operatorServiceQueueId, deskId)
)

go

create table iqueuedb.dbo.AttendanceClassification(
operatorId int,
operatorServiceQueueId int,
deskId int,
creationTime datetime,
rate int not null,
observations varchar(200),
primary key(operatorId, operatorServiceQueueId, deskId, creationTime),
foreign key(operatorId, operatorServiceQueueId, deskId) references iqueuedb.dbo.ServiceQueueDesk(operatorId, operatorServiceQueueId, deskId))

go

