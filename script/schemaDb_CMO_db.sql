--
-- Database: cmo_db
--

CREATE DATABASE cmo_db;

-- ENTITIES

--
-- Schema entity account
--

CREATE TABLE IF NOT EXISTS "account" (
	Description varchar(130)  NOT NULL,
	MaxCredit int  NOT NULL,
	Name varchar(130)  NOT NULL,
	
	_id SERIAL PRIMARY KEY

);

--
-- Schema entity country
--

CREATE TABLE IF NOT EXISTS "country" (
	Code varchar(130)  NOT NULL,
	Name varchar(130)  NOT NULL,
	
	_id SERIAL PRIMARY KEY

);

--
-- Schema entity creditline
--

CREATE TABLE IF NOT EXISTS "creditline" (
	CreditLimit int  NOT NULL,
	EndDate date  NOT NULL,
	GroupCreditLimit int ,
	StartDate date  NOT NULL,
	Type varchar(130)  NOT NULL,
	
	_id SERIAL PRIMARY KEY

);

--
-- Schema entity lessor
--

CREATE TABLE IF NOT EXISTS "lessor" (
	Genesis varchar(130)  NOT NULL,
	Name varchar(130)  NOT NULL,
	Number varchar(130)  NOT NULL,
	Share int  NOT NULL,
	Type varchar(130)  NOT NULL,
	
	_id SERIAL PRIMARY KEY

);

--
-- Schema entity organization
--

CREATE TABLE IF NOT EXISTS "organization" (
	Active bool ,
	ExternalID varchar(130)  NOT NULL,
	FormalName varchar(130) ,
	Liable bool ,
	SearchName varchar(130) ,
	Type varchar(130) ,
	
	_id SERIAL PRIMARY KEY

);

--
-- Schema entity user
--

CREATE TABLE IF NOT EXISTS "user" (
	mail varchar(130) ,
	name varchar(130) ,
	password varchar(130)  NOT NULL,
	roles varchar(130) ,
	surname varchar(130) ,
	username varchar(130)  NOT NULL,
	
	_id SERIAL PRIMARY KEY

);


-- Security

ALTER TABLE "user" ALTER COLUMN "password" TYPE varchar(128);

INSERT INTO "user" (username, password, _id) VALUES ('admin', '62f264d7ad826f02a8af714c0a54b197935b717656b80461686d450f7b3abde4c553541515de2052b9af70f710f0cd8a1a2d3f4d60aa72608d71a63a9a93c0f5', 1);

CREATE TABLE IF NOT EXISTS "roles" (
	role varchar(30) ,
	
	-- RELAZIONI

	_user INTEGER  NOT NULL REFERENCES "user"(_id),
	_id SERIAL PRIMARY KEY 

);
INSERT INTO "roles" (role, _user, _id) VALUES ('ADMIN', '1', 1);




-- relation 1:m Lessor Account - Lessor
ALTER TABLE account ADD COLUMN Lessor INTEGER  REFERENCES "lessor"(_id);

-- relation 1:m Organization CreditLine - Organization
ALTER TABLE creditline ADD COLUMN Organization INTEGER  REFERENCES "organization"(_id);

-- relation 1:m Country Lessor - Country
ALTER TABLE lessor ADD COLUMN Country INTEGER  REFERENCES "country"(_id);

-- relation 1:m OperatingEntity Lessor - Lessor
ALTER TABLE lessor ADD COLUMN OperatingEntity INTEGER  REFERENCES "lessor"(_id);

-- relation 1:m Country Organization - Country
ALTER TABLE organization ADD COLUMN Country INTEGER  REFERENCES "country"(_id);

-- relation 1:m Lessor Organization - Lessor
ALTER TABLE organization ADD COLUMN Lessor INTEGER  REFERENCES "lessor"(_id);

-- relation 1:m LiableParent Organization - Organization
ALTER TABLE organization ADD COLUMN LiableParent INTEGER  REFERENCES "organization"(_id);

-- relation 1:m Parent Organization - Organization
ALTER TABLE organization ADD COLUMN Parent INTEGER  REFERENCES "organization"(_id);

-- relation 1:m UtlimateParent Organization - Organization
ALTER TABLE organization ADD COLUMN UtlimateParent INTEGER  REFERENCES "organization"(_id);
