CREATE PROCEDURE uspGetNameInfo2 @Name varchar(50)
AS
SELECT
	FirstName,
	MiddleName,
	LastName
FROM
	Person.Person
WHERE
	FirstName = ISNULL(@Name, 'Ken')
GO

--EXEC uspGetNameInfo2 @Name='Terri'
--select * from Person.Person