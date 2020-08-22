use master

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
telephoneNumber varchar(15),
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
namespaceId varchar(20) not null,
instanceId varchar(12) unique not null,
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
serviceQueueId int references ServiceQueue(serviceQueueId) not null,
deskId int references Desk(deskId),
clientId int references [User](userId) not null,
startWaitingDateTime datetime not null,
startAttendanceDateTime datetime,
endAttendanceDateTime datetime,
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

create table AttendanceTicket(
attendanceId int primary key references Attendance,
ticketNumber int
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
insert into AttendanceStatus values(1, 2, 'Em Espera')
insert into AttendanceStatus values(2, 2, 'Em Atendimento')
insert into AttendanceStatus values(3, 2, 'Concluído')
insert into AttendanceStatus values(4, 2, 'Desistência')

insert into [User] values('Administrator', 'admin@email.com', null, null, 1)
insert into UserCredentials values(1, '$2a$10$7FSwcv.GcqzRXI3o6UB/X.U1xAnKGVDpk18KUY3D2JzLP./qUZBkC')

commit

go

-- Trigger to fill AttendanceTicket on Attendance insert
create or alter trigger FillAttendanceTicket
on Attendance
after insert
as
begin
declare 
@serviceQueueId int,
@ticketNumber int

set @serviceQueueId = ( select serviceQueueId from Attendance where attendanceId = @@IDENTITY )

set @ticketNumber = ( select count(*) from Attendance
where serviceQueueId = @serviceQueueId and
convert(varchar(10), startWaitingDateTime, 120) = convert(varchar(10), GETDATE(), 120) )

if @ticketNumber > 0
	begin
		 insert into AttendanceTicket values(@@IDENTITY, @ticketNumber)
	end

end

go

-- Procedure to read ServiceQueue Attendance Stats
-- TODO: CAN WE OPTIMIZE THESE SELECTS!?
create or alter procedure
GetServiceQueueStatistics @serviceQueueId int
as 
begin
declare @tempStats table(
attendanceCount int,
averageWaitingSeconds int,
averageAttendanceSeconds int,
averageRate decimal(2,1),
quitCount int
)

declare
@attendanceCount int,
@averageWaitingSeconds int,
@averageAttendanceSeconds int,
@averageRate int,
@quitCount int

-- Average ServiceQueue Rate
set @averageRate = ( select AVG(t2.rate) from Attendance as t1
inner join AttendanceClassification as t2
on t1.attendanceId = t2.attendanceId
where t1.serviceQueueId = @serviceQueueId and
t1.attendanceStatusId = 3 )

-- ServiceQueue Attendance Count
set @attendanceCount = ( select count(*) from Attendance
where serviceQueueId = @serviceQueueId and
attendanceStatusId = 3 )

-- ServiceQueue Quit Count
set @quitCount = ( select count(*) from Attendance
where serviceQueueId = @serviceQueueId and
attendanceStatusId = 4 )

-- ServiceQueue Attendance Average Waiting Time
set @averageWaitingSeconds = ( select avg(DATEDIFF(ss, startWaitingDateTime, startAttendanceDateTime))
from Attendance
where serviceQueueId = 1 and
attendanceStatusId = 3 )

-- ServiceQueue Average Attendance Time
set @averageAttendanceSeconds = ( select avg(DATEDIFF(ss, startAttendanceDateTime, endAttendanceDateTime))
as averageAttendanceSeconds
from Attendance
where serviceQueueId = @serviceQueueId and
attendanceStatusId = 3 )

insert into @tempStats values(@attendanceCount, @averageWaitingSeconds, @averageAttendanceSeconds, @averageRate, @quitCount)

select * from @tempStats
end

go

-- Procedure to get ServiceQueue waiting count
create or alter procedure
GetServiceQueueWaitingCount @deskId int
as 
begin
declare @serviceQueueId int

set @serviceQueueId = ( select serviceQueueId from Desk where deskId = @deskId )

select count(*) as waitingCount from Attendance
where serviceQueueId = @serviceQueueId and
attendanceStatusId = 1 and
convert(varchar(10), startWaitingDateTime, 120) = convert(varchar(10), GETDATE(), 120) 
end

go

-- Procedure to get next Attendance for a given deskId
create or alter procedure GetNextAttendance @deskId int
as
begin
declare @serviceQueueId int

set @serviceQueueId = ( select serviceQueueId from Desk where deskId = @deskId )

select min(attendanceId) as nextAttendance from Attendance
where ServiceQueueId = @serviceQueueId and
attendanceStatusId = 1 and
convert(varchar(10), startWaitingDateTime, 120) = convert(varchar(10), GETDATE(), 120)
end


go


create or alter procedure GetCurrentAttendance @serviceQueueId int
as
begin
declare @attendanceId int

set @attendanceId = ( select min(attendanceId) 
from Attendance
where ServiceQueueId = @serviceQueueId and
attendanceStatusId = 2 and
convert(varchar(10), startWaitingDateTime, 120) = convert(varchar(10), GETDATE(), 120) )

select ticketNumber from AttendanceTicket
where attendanceId = @attendanceId
end

-- Rubish for tests - DELETE WHEN OK

--exec GetServiceQueueStatistics 1

--exec GetServiceQueueWaitingCount 1

--insert into Attendance values(1, null, 2, '2020-07-05 19:05:00.000', null, null, 1)

--select * from Attendance

--select * from AttendanceTicket 

--select * from AttendanceClassification

update Attendance n 
set attendanceStatusId = 3
where attendanceId = 106

go 

exec GetCurrentAttendance 3

--update Attendance
--set attendanceStatusId = 3
--where attendanceId = 8

--exec GetNextAttendance 1

