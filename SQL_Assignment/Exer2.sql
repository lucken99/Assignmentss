/*	1. USING JOIN */
SELECT
		c.CustomerID
FROM 
	Sales.Customer AS c 
	LEFT JOIN
	Sales.SalesOrderHeader AS soh
	ON
	c.CustomerID = soh.CustomerID
WHERE 
	soh.SalesOrderID IS NULL


/* 2. USING SUBQUERY */
SELECT
	c.CustomerID
FROM
	Sales.Customer AS c
WHERE
	c.CustomerID NOT IN
	(
		SELECT 
			soh.CustomerID
		FROM
			Sales.SalesOrderHeader AS soh
		
	)
--select * from Sales.SalesOrderHeader

/* 3. USING CTE*/

WITH Allsoh
AS
(
	SELECT
		CustomerID,
		SalesOrderID
	FROM
		Sales.SalesOrderHeader
	)
--SELECT * from Allsoh
SELECT
	c.CustomerID
FROM
	Sales.Customer AS c
	LEFT JOIN
	Allsoh As asoh
	ON
	asoh.CustomerID = c.CustomerID
WHERE
	asoh.SalesOrderID IS NULL


/* USING EXISTS */

SELECT c.CustomerID,
	c.AccountNumber,
	c.PersonID,
	c.rowguid,
	c.ModifiedDate,
	c.StoreID,
	c.TerritoryID
FROM
	Sales.Customer c
	LEFT JOIN Sales.SalesOrderHeader s
	on
	c.customerID = s.customerID
WHERE EXISTS (SELECT
				c.CustomerID
			FROM 
				Sales.Customer AS c 
				LEFT JOIN
				Sales.SalesOrderHeader AS soh
				ON
				c.CustomerID = soh.CustomerID
			WHERE 
				soh.SalesOrderID IS NULL)
	AND
	s.SalesOrderID IS NULL
order by c.CustomerID

--SELECT
--	c.CustomerID
--FROM
--	Sales.Customer AS c
--WHERE
--	NOT EXISTS
--	(SELECT CustomerID)
