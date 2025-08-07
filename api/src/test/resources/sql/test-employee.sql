-- Departments
SET IDENTITY_INSERT HumanResources.Department ON;
INSERT INTO HumanResources.Department (DepartmentID, Name, GroupName, ModifiedDate)
VALUES (999, 'Test Department', 'Test Group', GETDATE());
SET IDENTITY_INSERT HumanResources.Department OFF;

-- Shifts
SET IDENTITY_INSERT HumanResources.Shift ON;
INSERT INTO HumanResources.Shift (ShiftID, Name, StartTime, EndTime, ModifiedDate)
VALUES (99, 'Test Shift', '08:00:00', '16:00:00', GETDATE());
SET IDENTITY_INSERT HumanResources.Shift OFF;

-- CountryRegion
INSERT INTO Person.CountryRegion (CountryRegionCode, Name)
VALUES ('XX', 'Test Country');

-- StateProvince
SET IDENTITY_INSERT Person.StateProvince ON;
INSERT INTO Person.StateProvince (StateProvinceID, StateProvinceCode , CountryRegionCode, Name, TerritoryID, Rowguid, ModifiedDate)
VALUES (9999, 'XX', 'XX', 'Test State', 1, NEWID(), GETDATE());
SET IDENTITY_INSERT Person.StateProvince OFF;
