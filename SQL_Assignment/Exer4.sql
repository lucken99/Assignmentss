--select top(5) * from Sales.SalesOrderDetail
----select * from Sales.Currency
--select * from Sales.CurrencyRate
--order by ToCurrencyCode
--USE AdventureWorks14
--SELECT * from giveSalesOrderDetail(43659, 'ARS', '2011-05-31')
--from Sales.SalesOrderDetail AS sod


CREATE FUNCTION giveSalesOrderDetail(
	@SalesOrderID INT, @CurrencyCode nchar(30), @CurrencyRateDate datetime
	)
RETURNS TABLE
AS
	--Function body

	RETURN
	(
	SELECT sod.OrderQty, sod.ProductID, sod.UnitPrice, sod.UnitPrice*(select cr.EndOfDayRate from Sales.CurrencyRate AS cr where 
									cr.ToCurrencyCode=@CurrencyCode AND cr.CurrencyRateDate = @CurrencyRateDate) AS ConvertedPrice
	FROM Sales.SalesOrderDetail AS sod)

