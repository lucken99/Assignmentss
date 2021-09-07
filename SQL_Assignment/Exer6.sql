CREATE TRIGGER Production.trgrLimitPriceChanges
ON Production.Product
FOR UPDATE AS
IF EXISTS(
	SELECT * FROM inserted i JOIN deleted d 
	ON i.ProductID = d.ProductID
	WHERE i.ListPrice > (d.ListPrice*1.15)
	)
BEGIN
RAISERROR(' list price can never be raised more than 15 Percent in a single change.', 16, 1)
ROLLBACK TRAN
END
GO

--Altering trgrLimitPriceChanges
ALTER TRIGGER Production.trgrLimitPriceChanges
ON Production.Product
FOR UPDATE AS
IF UPDATE(ListPrice)
BEGIN
IF EXISTS(
	SELECT *
	FROM inserted AS i JOIN deleted AS d
	ON i.ProductID = d.ProductID
	WHERE i.ListPrice > (d.ListPrice*1.15)
	)
BEGIN RAISERROR('list price can never be raised more than 15 Percent in a single change.', 16, 1)
ROLLBACK TRAN
END
END
GO