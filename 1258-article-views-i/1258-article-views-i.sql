# Write your MySQL query statement below

SELECT DISTINCT author_id AS id FROM VIEWS
    WHERE author_id = viewer_id ORDER BY author_id;