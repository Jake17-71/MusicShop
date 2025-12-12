ALTER TABLE supplies
DROP
CONSTRAINT FK_SUPPLIES_ON_SUPPLIER
GO

DECLARE
@sql [nvarchar](MAX)
SELECT @sql = N'ALTER TABLE supplies DROP CONSTRAINT ' + QUOTENAME([df].[name])
FROM [sys].[columns] AS [c]
    INNER JOIN [sys].[default_constraints] AS [df]
ON [df].[object_id] = [c].[default_object_id]
WHERE [c].[object_id] = OBJECT_ID(N'supplies')
  AND [c].[name] = N'supplier_id'
    EXEC sp_executesql @sql
    GO

ALTER TABLE supplies
DROP
COLUMN supplier_id
GO