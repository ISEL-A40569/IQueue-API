use iqueuedb

go

create procedure GetLanguages
as
begin transaction set transaction isolation level serializable
begin try
select * from [Language]
commit
end try
begin catch
rollback
end catch

go

create procedure GetLanguage @languageId int
as
begin transaction set transaction isolation level serializable
begin try
select * from [Language] where languageId = @languageId
commit
end try
begin catch
rollback
end catch

go

create procedure InsertLanguage @languageId int, @languageDescription varchar(50)
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

create procedure DeleteLanguage @languageId int
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

create procedure UpdateLanguage @languageId int, @languageDescription varchar(50)
as
begin transaction set transaction isolation level serializable
begin try
update [Language] set languageDescription = @languageDescription where languageId = @languageId
commit
end try
begin catch
rollback
end catch

go

