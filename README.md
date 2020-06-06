**JDBC - Java DataBase Connectivity**

**JDBC** — платформенно-независимый стандарт взаимодействия Java-приложений с различными СУБД. JDBC реализован в виде пакета java.sql, входящего в состав Java SE (Standart Edition).

JDBC позволяет устанавливать соединение с базой данных согласно специально описанному URL. Драйверы могут загружаться во время работы программы динамически.
- Для соединение с базой данных необходимо использовать класс, реализующий 
- Для соединение с базой данных необходимо использовать класс, реализующий интерфейс java.sql.Connection. 
- После соединение с базой данных, можно создавать объекты класса **Statement** для выполнения запросов к базе данных.
При работе с базой данных используют следующие типы **Statement**ов, различающихся по назначению:

-	java.sql.Statement — Statement общего назначения;
-	java.sql.PreparedStatement — Statement выполнения запросов c параметрами, обозначенными символом '?' в теле запроса;
-	java.sql.CallableStatement — Statement вызова хранимых процедур.
Интерфейс java.sql.ResultSet позволяет извлекать информацию из базы данных.

**Преимущества использования JDBC**

Основными преимуществами JDBC являются:
-	JDBC позволяет работать с СУБД без глубоких знаний специфики конкретной базы данных;
- При смене СУБД исходный код приложения практически не меняется, если программа была разработана в соответствии со стандартом SQL (без использования отличительных особенностей предыдущей СУБД);
-	Не требуются дополнительные установки и настройки программы, работающей с базой данных;
-	К СУБД можно подсоединиться с использованием URL.

**SQL Structured Query Language**
SQL (Structured Query Language — язык структурированных запросов) - это непроцедурный язык программирования, используемый для работы с информацией реляционной базы данных, которая управляется соответствующей системой управления базами данных (СУБД).

Первоначально SQL был основным средством доступа пользователя к информации базы данных и позволял выполнять следующие операции с таблицами БД:
-	создание новой таблицы;
-	добавление записей в таблицу;
-	изменение содержимого записей;
-	удаление записей из таблицы;
- чтение записей из одной или нескольких таблиц;
- изменение структур таблиц.

По мере развития СУБД **SQL** усложнился и обогатился новыми конструкциями типа индексы, представления, триггеры, хранимые процедуры — и стал приобретать черты, свойственные языкам программирования. Изначально SQL создавался как простой стандартизированный язык извлечения и управления данными, содержащимися в реляционной СУБД. Но со временем он усложнился настолько, что превратился в инструмент разработчика, а не конечного пользователя.
Таким образом использование **SQL** сводится, по сути, к формированию всевозможных выборок строк и совершению операций над всеми записями, входящими в набор.

**SQL** состоит из четырех отдельных частей:
1.	**DDL** (Data Definition Language) - язык определения данных; используется для определения структур хранящихся в БД данных. Операторы DDL позволяют создавать, изменять и удалять объекты в БД. Допустимые типы объектов зависят от используемой СУБД и обычно включают базы данных, пользователей, таблицы, представления, хранимые процедуры и ряд более вспомогательных объектов типа роли и индексы. Список некоторых операторов:
-	Операторы DDL (Data Definition Language) - операторы определения объектов базы данных
-	CREATE SCHEMA - создать схему БД;
-	DROP SHEMA - удалить схему БД;
-	CREATE TABLE - создать таблицу;
-	ALTER TABLE - изменить структуру таблицы;
-	DROP TABLE - удалить таблицу;
-	CREATE DATABASE - создать базу данных;
-	DROP DATABASE - удалить базу данных;
-	CREATE SEQUENCE - создать последовательность;
-	DROP SEQUENCE - удалить последовательность;
-	CREATE VIEW - создать представление;
-	DROP VIEW - удалить представление;
-	CREATE INDEX - создать индекс;
-	DROP INDEX - удалить индекс;
-	CREATE CONSTRAINT - создать ограничение (Primary Key, Foreign Key);
-	DROP CONSTRAINT - удалить ограничение (Primary Key, Foreign Key).

2.  **DML** (Data Manipulation Language) - язык манипуляции данными; используется для извлечения, вставки, изменения и удаления данных в таблицах. Операторы DML :
-	SELECT - чтение инфомации (из одной или нескольких таблиц);
-	INSERT - добавить строки в таблицу;
-	UPDATE - изменить строки в таблице;
-	DELETE - удалить строки в таблице;

3.  **DCL** (Data Control Language) - язык определения доступа к данным; используется для контроля доступа к информации БД. Операторы DCL определяют привилегии пользователя и позволяют выдавать и отбирать права на использование DDL и DML определенных операторов к определенным объектам БД.
-	GRANT - предоставление доступа пользователю или приложению на манипулирование объектами;
-	DENY — явный запрет доступа для пользователя;
-	REVOKE - отмена запрета или разрешения пользователя.

4.	**TCL** (Transaction Control Language) - язык управления транзакциями; используется для контроля обработки транзакций в БД. Операторы TCL включают, как правило, оператор commit для сохранения изменений, сделанных в ходе транзакции, и rollback для их отмены. Оператор savepoint можно использовать для разбиения транзакции на несколько частей, и, в зависимости от определенных условий, часть из них "откатить".
-	BEGIN TRANSACTION — начать транзакцию;
- COMMIT - зафиксировать внесенные изменения;
-	ROLLBACK - откатить внесенные изменения.
   Необходимо отметить, что **SQL** реализует декларативную парадигму программирования: с помощью данного языка пользователь описывает запрос, а СУБД принимает решение, как этот запрос выполнить, т.е. планирует элементарные операции, необходимые для выполнения данного запроса.

![операторы](https://user-images.githubusercontent.com/61631173/83947359-0fc14b80-a81f-11ea-8e51-8362174bef44.PNG)
