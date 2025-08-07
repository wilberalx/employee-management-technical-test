SET IDENTITY_INSERT Person.StateProvince ON;

INSERT INTO Person.StateProvince (StateProvinceID, StateProvinceCode, CountryRegionCode, Name, TerritoryID, Rowguid, ModifiedDate)
VALUES
(-1, 'Tst', 'XX', 'Test state name', 1, NEWID(), GETDATE());

SET IDENTITY_INSERT Person.StateProvince OFF;
