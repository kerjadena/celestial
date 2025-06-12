No.1
SELECT d.name AS department_name, SUM(e.salary) AS total_salary
FROM departments d
JOIN employees e ON d.id = e.department_id
GROUP BY d.name
ORDER BY total_salary DESC;

No.2
SELECT e.name
FROM employees e
LEFT JOIN employee_projects ep ON e.id = ep.employee_id
WHERE ep.employee_id IS NULL;

No.3

No.4

No.5
SELECT e.name, COUNT(DISTINCT ep.project_id) AS project_count
FROM employees e
JOIN employee_projects ep ON e.id = ep.employee_id
GROUP BY e.id, e.name
HAVING COUNT(DISTINCT ep.project_id) >= 2;


 -->
