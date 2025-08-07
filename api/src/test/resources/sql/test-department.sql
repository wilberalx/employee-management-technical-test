SET IDENTITY_INSERT HumanResources.Department ON;

INSERT INTO HumanResources.Department (DepartmentID, Name, GroupName, ModifiedDate)
VALUES (-1, 'Engineering test', 'Research and Development', GETDATE());

SET IDENTITY_INSERT HumanResources.Department OFF;