# Write your MySQL query statement below
SELECT
    D.name AS Department,
    E.name AS Employee,
    E.salary AS Salary
FROM
    Employee E 
JOIN
    Department D
ON
    E.departmentId = D.id
WHERE
    E.salary = (
        SELECT 
            MAX(salary)
        FROM
            Employee e1
        WHERE
            e1.departmentId = E.departmentId
    );