/*
	First Query
*/
SELECT
	COUNT(*)
FROM
	Sales.SalesPerson;

/*
	Second Query
*/
SELECT
	FirstName,
	LastName 
FROM
	Person.Person
WHERE
	FirstName LIKE 'B%';


/*
	Third Query
*/
SELECT 
	FirstName,
	LastName
FROM 
	Person.Person p
	join 
	HumanResources.Employee e
	ON 
	p.BusinessEntityID = e.BusinessEntityID
WHERE
	e.JobTitle IN ('Design Engineer', 'Tool Designer', 'Marketing Assistant');

/*
	Fourth Query
*/
--select NAME, Weight from Production.Product

SELECT
	p.Name,
	p.Color
FROM
	Production.Product p
WHERE
	p.Weight = (
				SELECT 
					MAX(Weight)
				FROM
					Production.Product
				)

/* 5th query*/
SELECT
	Description,
	ISNULL(MaxQty, 0.00)
FROM
	Sales.SpecialOffer

/*6th query*/
--select * from Sales.CurrencyRate

SELECT
	AVG(SalesCurrRate.AverageRate) "Average exchange rate for the day"
FROM
	Sales.CurrencyRate SalesCurrRate
WHERE
	SalesCurrRate.FromCurrencyCode = 'USD'
	AND
	SalesCurrRate.ToCurrencyCode = 'GBP'
	AND
	YEAR(SalesCurrRate.CurrencyRateDate) = 2011


/* 7th query */
SELECT 
	ROW_NUMBER() OVER (ORDER BY FirstName) AS RowNum1,
	FirstName,
	LastName
FROM 
	Person.Person 
WHERE 
	FirstName LIKE '%ss%';


/* 8th query */
SELECT BusinessEntityId AS SalesPersonID, 
		CASE 
			WHEN CommissionPct = 0 THEN 'Band 0'
			WHEN CommissionPct <= 1 THEN 'Band 1'
			WHEN CommissionPct <= 1.5 THEN 'Band 2'
			ELSE 'Band 3'
		END AS 'Commision Band'
FROM Sales.SalesPerson;

/* 9th query */
--EXEC dbo.uspGetEmployeeManagers @BusinessEntityID=48;
WITH CTE AS
(	
	SELECT
		p.BusinessEntityID,
		p.FirstName,
		p.LastName,
		p.PersonType,

		e.OrganizationNode,
		e.OrganizationLevel,
		e.JobTitle
	FROM
		Person.Person AS p
		JOIN HumanResources.Employee AS e
		ON
		p.BusinessEntityID = e.BusinessEntityID
	WHERE
		p.FirstName = 'Ruth'
		AND
		p.LastName = 'Ellerbrock'
)
Select * FROM CTE c

SELECT 
    p.FirstName, 
    p.LastName,
    e.OrganizationLevel,
    CAST(e.OrganizationNode AS VARCHAR(20)) AS 'OrgNodeString'
FROM 
    HumanResources.Employee AS e
	INNER JOIN 
	person.person AS p ON e.BusinessEntityID = p.BusinessEntityID
	INNER JOIN
	CTE a ON a.OrganizationNode.IsDescendantOf(e.OrganizationNode) = 1

	

/* 10th query */
--select * from Production.Product
SELECT
	a.ProductID, a.StockLevel
FROM
	(SELECT
		ProductID, dbo.ufnGetStock(ProductID) as StockLevel
	FROM
		Production.Product) AS a
WHERE 
	a.StockLevel = (SELECT MAX(dbo.ufnGetStock(ProductID)) FROM Production.Product)


