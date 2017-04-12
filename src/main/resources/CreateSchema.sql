-- Create MySQL schema to store GitHub Login id and URL (join to other elements later)

CREATE SCHEMA github;

-- Create Login storage table

CREATE TABLE github.logins (login VARCHAR(200), url VARCHAR(200));

-- Test Row
-- INSERT INTO github.logins (login, url) VALUES ("xxxx", "yyyyy");