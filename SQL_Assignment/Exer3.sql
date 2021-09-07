--select * from Purchasing.PurchaseOrderHeader

SELECT TOP 5 *
FROM(
	SELECT so.*, TotalPerAccount=SUM(ss.LineTotal) OVER (PARTITION BY so.AccountNumber ORDER BY so.AccountNumber)
	FROM Sales.SalesOrderHeader AS so
	JOIN Sales.SalesOrderDetail ss
	ON so.SalesOrderID = ss.SalesOrderID
	) AS s
WHERE s.TotalPerAccount > 70000