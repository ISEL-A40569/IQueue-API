drop database if exists iqueuedb

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
telephoneNumber varchar(15),
[address] varchar(200),
userProfileId int not null,
)

go

create table UserCredentials(
userId int primary key references [User](userId),
[password] varchar(128) not null
)

go

create table Operator(
operatorId int identity primary key,
operatorDescription varchar(100) not null,
email varchar(100),
phoneNumber int,
[address] varchar(200)
)

go

create table OperatorUser(
operatorId int references Operator(operatorId),
userId int  references [User](userId),
primary key(operatorId, userId)
)

go

create table Beacon(
beaconId int identity primary key,
beaconMacAddress varchar(12) unique not null,
namespaceId varchar(10) not null,
instanceId varchar(6) unique not null,
manufacturer varchar(50) not null,
model varchar(50) not null
)

go

create table OperatorBeacon(
operatorId int references Operator(operatorId), 
beaconId int references Beacon(beaconId),
primary key(operatorId, beaconId)
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

create table ServiceQueue(
serviceQueueId int identity primary key,
operatorId int references Operator(operatorId) not null,
serviceQueueDescription varchar(100) not null,
serviceQueueTypeId int not null,
dailyLimit int
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

create table Desk(
deskId int identity primary key,
serviceQueueId int references ServiceQueue(serviceQueueId),
deskDescription varchar(50)
)

go

create table DeskUser(
deskId int references Desk(deskId),
userId int references [User](userId),
primary key(deskId, userId)
)

go

create table Attendance(
attendanceId int identity primary key,
serviceQueueId int references ServiceQueue(serviceQueueId), not null,
deskId int references Desk(deskId),
clientId int references [User](userId) not null,
startWaitingDateTime datetime not null,
startAttendanceDateTime datetime,
endAttendanceTime datetime,
attendanceStatusId int not null
)

go

create table AttendanceClassification(
attendanceId int primary key references Attendance,
classificationCreationDateTime datetime not null,
rate int not null,
observations varchar(200)
)

go

create table [Log](
logId int identity primary key,
logCreationDateTime datetime not null,
requestMethod varchar(6) not null,
requestUri varchar(256) not null,
requestHeaders varchar(1024) not null,
requestBody varchar(1024) not null,
responseStatus int not null,
responseHeaders varchar(1024) not null,
responseBody varchar(1024) not null,
)

go

-- Create Parameters Data
begin transaction
insert into Language values(1, 'English')
insert into Language values(2, 'Português')

insert into UserProfile values(1, 1, 'Master')
insert into UserProfile values(2, 1, 'Manager')
insert into UserProfile values(3, 1, 'Service')
insert into UserProfile values(4, 1, 'Client')
insert into UserProfile values(1, 2, 'Administrador')
insert into UserProfile values(2, 2, 'Gerente')
insert into UserProfile values(3, 2, 'Serviço')
insert into UserProfile values(4, 2, 'Cliente')

insert into ServiceQueueType values(1, 1, 'Single Desk No Antecipation')
insert into ServiceQueueType values(2, 1, 'Multi Desk No Antecipation')
insert into ServiceQueueType values(3, 1, 'Single Desk With Antecipation')
insert into ServiceQueueType values(4, 1, 'Multi Desk With Antecipation')
insert into ServiceQueueType values(1, 2, 'Balcão Único Sem Antecipação')
insert into ServiceQueueType values(2, 2, 'Múltiplos Balcão Sem Antecipação')
insert into ServiceQueueType values(3, 2, 'Balcão Único Com Antecipação')
insert into ServiceQueueType values(4, 2, 'Múltiplos Balcão Com Antecipação')

insert into AttendanceStatus values(1, 1, 'Waiting')
insert into AttendanceStatus values(2, 1, 'In Attendance')
insert into AttendanceStatus values(3, 1, 'Done')
insert into AttendanceStatus values(4, 1, 'Quit')
insert into AttendanceStatus values(5, 1, 'No Show')
insert into AttendanceStatus values(1, 2, 'Em Espera')
insert into AttendanceStatus values(2, 2, 'Em Atendimento')
insert into AttendanceStatus values(3, 2, 'Concluído')
insert into AttendanceStatus values(4, 2, 'Desistência')
insert into AttendanceStatus values(5, 2, 'Falta')

insert into [User] values('Administrator', 'admin@email.com', null, null, 1)
insert into UserCredentials values(1, '$2a$10$7FSwcv.GcqzRXI3o6UB/X.U1xAnKGVDpk18KUY3D2JzLP./qUZBkC')

commit

select * from [User] 
select * from UserCredentials

