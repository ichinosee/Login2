DROP DATABASE IF EXISTS OSSDB_scripts_SJIS;
CREATE DATABASE OSSDB_scripts_SJIS;


DROP TABLE IF EXISTS item;



CREATE TABLE login
(
 code SERIAL PRIMARY KEY,

 name TEXT,

);




INSERT INTO login(code,  name, price) VALUES(1, '田中', 50);
