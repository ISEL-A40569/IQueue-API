drop database iqueuedb

go

create database iqueuedb

go

use iqueuedb

go

create table [Language](
languageId int primary key,
languageDescription varchar(20) not null
)

go

create table UserProfile(
userProfileId int,
languageId int,
userProfileDescription varchar(50) not null,
primary key(userProfileId, languageId),
foreign key(languageId) references [Language](languageId)
)

go

create table [User](
userId int identity primary key,
userName varchar(100) not null,
email varchar(100) not null,
phoneNumber int,
[address] varchar(200),
userProfileId int not null,
)

go

create table Operator(
operatorId int identity primary key,
operatorDescription varchar(100) not null,
email varchar(100),
phoneNumber int,
[address] varchar(200),
)

go

create table OperatorUser(
operatorId int references Operator(operatorId),
userId int  references [User](userId),
primary key(operatorId, userId),
)

go

create table Beacon(
beaconId int identity primary key,
beaconMacAddress varchar(12) unique not null,
uidNamespaceId varchar(10) not null,
uidInstanceId varchar(6) not null,
ibeaconUuid varchar(32) not null,
ibeaconMajor int not null,
ibeaconMinor int not null,
manufacturer varchar(50) not null,
model varchar(50) not null
)

go

create table OperatorBeacon(
operatorId int references Operator(operatorId), 
beaconId int references Beacon(beaconId),
primary key(operatorId, beaconId),
)

go

create table ServiceQueueType(
serviceQueueTypeId int,
languageId int,
serviceQueueTypeDescription varchar(50) not null,
primary key(serviceQueueTypeId, languageId),
foreign key(languageId) references [Language](languageId)
)

go

create table OperatorServiceQueue(
serviceQueueId int identity primary key,
operatorId int references Operator(operatorId) not null,
serviceQueueDescription varchar(100) not null,
serviceQueueTypeId int not null,
dailyLimit int,
)

go 

create table Client(
clientId int identity primary key,
clientName varchar(100) not null,
email varchar(100) not null
)

go

create table AttendanceStatus(
attendanceStatusId int,
languageId int,
attendanceStatusDescription varchar(50) not null,
primary key(attendanceStatusId, languageId),
foreign key(languageId) references [Language](languageId)
)

go

create table ServiceQueueDesk(
deskId int identity primary key,
operatorId int references Operator(operatorId),
serviceQueueId int references OperatorServiceQueue(serviceQueueId),
deskDescription varchar(50),
)

go

create table ServiceQueueDeskUser(
operatorId int references Operator(operatorId),
serviceQueueId int,
deskId int,
userId int,
[date] date,
primary key(operatorId, serviceQueueId, deskId, userId, [date]),
foreign key(serviceQueueId) references OperatorServiceQueue(serviceQueueId),
foreign key(userId) references [User](userId),
foreign key(deskId) references ServiceQueueDesk(deskId)
)

go

create table Attendance(
attendanceId int identity primary key,
operatorId int references Operator(operatorId) not null,
serviceQueueId int references OperatorServiceQueue(serviceQueueId) not null,
deskId int references ServiceQueueDesk(deskId) not null,
clientId int references Client(clientId) not null,
startWaitingTime datetime not null,
endWaitingTime datetime,
startAttendanceTime datetime,
endAttendanceTime datetime,
attendanceStatusId int not null,
attendanceUserId int references [User](userId) not null,
)

go

create table AttendanceClassification(
attendanceId int primary key references Attendance,
classificationCreationTime datetime not null,
rate int not null,
observations varchar(200),
)

go

