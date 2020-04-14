use iqueuedb

insert into [Language] values(1, 'English')
insert into [Language] values(2, 'Portuguese')

select * from [Language]

insert into UserProfile values (1, 1, 'Administrator')
insert into UserProfile values (2, 1, 'Manager')
insert into UserProfile values (3, 1, 'Service')

select * from UserProfile

insert into ServiceQueueType values (1, 1, 'Single Desk No Antecipation')
insert into ServiceQueueType values (2, 1, 'Multi Desk No Antecipation')
insert into ServiceQueueType values (3, 1, 'Single Desk With Antecipation')
insert into ServiceQueueType values (4, 1, 'Multi Desk With Antecipation')

select * from ServiceQueueType

insert into AttendanceStatus values (1, 1, 'Waiting')
insert into AttendanceStatus values (2, 1, 'In Attendance')
insert into AttendanceStatus values (3, 1, 'Done')
insert into AttendanceStatus values (4, 1, 'Quit')
insert into AttendanceStatus values (5, 1, 'No Show')

select * from AttendanceStatus

insert into Operator values ('Loja do Cidad�o das Laranjeiras', null, null, null)
insert into Operator values ('Loja do Cidad�o da Bela Vista', null, null, null)

select * from Operator

insert into [User] values ('Ze To', 'zeto@email.pt', null, null, 1)
insert into [User] values ('To Ze', 'toze@email.pt', null, null, 2)
insert into [User] values ('To Mane', 'tomane@email.pt', null, null, 3)
insert into [User] values ('Albertina', 'Albertina@email.pt', null, null, 3)

select * from [User]

insert into Beacon values ('123456789', 1, 2, 1, 1, 1, 'Minew', 'C3')
insert into Beacon values ('987654321', 1, 1, 2, 2, 2, 'Minew', 'C3')

select * from Beacon

insert into OperatorBeacon values (1, 3)
insert into OperatorBeacon values (2, 4)

select * from OperatorBeacon

exec SelectOperatorBeacon 1, null

insert into OperatorServiceQueue values (1, 'Passaporte', 2, null)
insert into OperatorServiceQueue values (1, 'Cart�o do Cidad�o', 2, null)
insert into OperatorServiceQueue values (1, 'Seguran�a Social', 2, null)
insert into OperatorServiceQueue values (2, 'Passaporte', 2, null)
insert into OperatorServiceQueue values (2, 'Cart�o do Cidad�o', 2, null)
insert into OperatorServiceQueue values (2, 'Seguran�a Social', 2, null)

select * from OperatorServiceQueue

insert into OperatorUser values (1, 2)
insert into OperatorUser values (1, 3)
insert into OperatorUser values (1, 4)

select * from OperatorUser

insert into ServiceQueueDesk values (1, 1, 1)
insert into ServiceQueueDesk values (1, 1, 2)
insert into ServiceQueueDesk values (1, 2, 1)
insert into ServiceQueueDesk values (1, 2, 2)
insert into ServiceQueueDesk values (1, 3, 1)
insert into ServiceQueueDesk values (1, 3, 2)

select * from ServiceQueueDesk

insert into Client values ('Malaquias', 'Malaquias@email.com')
insert into Client values ('Josefina', 'Josefina@email.com')
insert into Client values ('Barrabas', 'Barrabas@email.com')
insert into Client values ('Alzira', 'Alzira@email.com')

select * from Client


exec InsertClient 'test', 'test'

