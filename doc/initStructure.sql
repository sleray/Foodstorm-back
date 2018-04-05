------------------------------------------------------------
--        Script Postgre 
------------------------------------------------------------



------------------------------------------------------------
-- Table: INGREDIENT
------------------------------------------------------------
CREATE TABLE public.INGREDIENT(
	INGR_ID      INT  NOT NULL ,
	INGR_NAME    VARCHAR (50)  ,
	INGR_TYPE_ID INT   ,
	CONSTRAINT prk_constraint_INGREDIENT PRIMARY KEY (INGR_ID)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: INGREDIENT_TYPE
------------------------------------------------------------
CREATE TABLE public.INGREDIENT_TYPE(
	INGR_TYPE_ID   INT  NOT NULL ,
	INGR_TYPE_NAME VARCHAR (50)  ,
	CONSTRAINT prk_constraint_INGREDIENT_TYPE PRIMARY KEY (INGR_TYPE_ID)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: INGREDIENT_GROUP
------------------------------------------------------------
CREATE TABLE public.INGREDIENT_GROUP(
	INGR_GROUP_ID   INT  NOT NULL ,
	INGR_GROUP_NAME VARCHAR (50)  ,
	CONSTRAINT prk_constraint_INGREDIENT_GROUP PRIMARY KEY (INGR_GROUP_ID)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: have
------------------------------------------------------------
CREATE TABLE public.have(
	INGR_GROUP_ID INT  NOT NULL ,
	INGR_ID       INT  NOT NULL ,
	CONSTRAINT prk_constraint_have PRIMARY KEY (INGR_GROUP_ID,INGR_ID)
)WITHOUT OIDS;



ALTER TABLE public.INGREDIENT ADD CONSTRAINT FK_INGREDIENT_INGR_TYPE_ID FOREIGN KEY (INGR_TYPE_ID) REFERENCES public.INGREDIENT_TYPE(INGR_TYPE_ID);
ALTER TABLE public.have ADD CONSTRAINT FK_have_INGR_GROUP_ID FOREIGN KEY (INGR_GROUP_ID) REFERENCES public.INGREDIENT_GROUP(INGR_GROUP_ID);
ALTER TABLE public.have ADD CONSTRAINT FK_have_INGR_ID FOREIGN KEY (INGR_ID) REFERENCES public.INGREDIENT(INGR_ID);
