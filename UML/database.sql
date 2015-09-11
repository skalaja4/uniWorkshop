--------------------------------------------------------
--  DDL for Table BRANCH
--------------------------------------------------------

  CREATE TABLE "WORKSHOP"."BRANCH" 
   (	"ID" VARCHAR2(20 BYTE), 
	"NAME" VARCHAR2(30 BYTE), 
	"ADDRESS" VARCHAR2(60 BYTE), 
	"PARRENTBRANCH" VARCHAR2(20 BYTE)
   );
--------------------------------------------------------
--  DDL for Table EMPLOYEE
--------------------------------------------------------

  CREATE TABLE "WORKSHOP"."EMPLOYEE" 
   (	"ID" VARCHAR2(20 BYTE), 
	"FIRSTNAME" VARCHAR2(30 BYTE), 
	"LASTNAME" VARCHAR2(50 BYTE), 
	"BIRTHDAY" DATE, 
	"BRANCH" VARCHAR2(20 BYTE), 
	"CATEGORY" VARCHAR2(20 BYTE), 
	"PLAN" NUMBER
   );
--------------------------------------------------------
--  DDL for Table EVALUATION
--------------------------------------------------------

  CREATE TABLE "WORKSHOP"."EVALUATION" 
   (	"ID" NUMBER, 
	"NAME" VARCHAR2(40 BYTE), 
	"FILL_DATE" DATE, 
	"QUESTION1" NUMBER, 
	"QUESTION2" NUMBER, 
	"QUESTION3" NUMBER, 
	"QUESTION4" NUMBER, 
	"QUESTION5" NUMBER, 
	"QUESTION6" NUMBER, 
	"QUESTION7" NUMBER, 
	"QUESTION8" NUMBER, 
	"QUESTION9" NUMBER, 
	"QUESTION10" VARCHAR2(4000 BYTE)
   );
--------------------------------------------------------
--  DDL for Table EVALUATIONPLAN
--------------------------------------------------------

  CREATE TABLE "WORKSHOP"."EVALUATIONPLAN" 
   (	"ID" NUMBER, 
	"NAME" VARCHAR2(40 BYTE), 
	"EXPIRATION" DATE, 
	"BRANCH" VARCHAR2(20 BYTE)
   );
--------------------------------------------------------
--  DDL for Index BRANCH_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "WORKSHOP"."BRANCH_PK" ON "WORKSHOP"."BRANCH" ("ID");
--------------------------------------------------------
--  DDL for Index EMPLOYEE_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "WORKSHOP"."EMPLOYEE_PK" ON "WORKSHOP"."EMPLOYEE" ("ID");
--------------------------------------------------------
--  DDL for Index EMPLOYEE_PLAN
--------------------------------------------------------

  CREATE INDEX "WORKSHOP"."EMPLOYEE_PLAN" ON "WORKSHOP"."EMPLOYEE" ("PLAN");
--------------------------------------------------------
--  DDL for Index EVALUATION_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "WORKSHOP"."EVALUATION_PK" ON "WORKSHOP"."EVALUATION" ("ID");
--------------------------------------------------------
--  DDL for Index EVALUATIONPLAN_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "WORKSHOP"."EVALUATIONPLAN_PK" ON "WORKSHOP"."EVALUATIONPLAN" ("ID");
--------------------------------------------------------
--  Constraints for Table BRANCH
--------------------------------------------------------

  ALTER TABLE "WORKSHOP"."BRANCH" MODIFY ("ADDRESS" NOT NULL ENABLE);
  ALTER TABLE "WORKSHOP"."BRANCH" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "WORKSHOP"."BRANCH" ADD CONSTRAINT "BRANCH_PK" PRIMARY KEY ("ID")
  USING INDEX ;
  ALTER TABLE "WORKSHOP"."BRANCH" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table EMPLOYEE
--------------------------------------------------------

  ALTER TABLE "WORKSHOP"."EMPLOYEE" MODIFY ("BRANCH" NOT NULL ENABLE);
  ALTER TABLE "WORKSHOP"."EMPLOYEE" MODIFY ("BIRTHDAY" NOT NULL ENABLE);
  ALTER TABLE "WORKSHOP"."EMPLOYEE" MODIFY ("LASTNAME" NOT NULL ENABLE);
  ALTER TABLE "WORKSHOP"."EMPLOYEE" MODIFY ("FIRSTNAME" NOT NULL ENABLE);
  ALTER TABLE "WORKSHOP"."EMPLOYEE" MODIFY ("CATEGORY" NOT NULL ENABLE);
  ALTER TABLE "WORKSHOP"."EMPLOYEE" ADD CONSTRAINT "EMPLOYEE_PK" PRIMARY KEY ("ID")
  USING INDEX;
  ALTER TABLE "WORKSHOP"."EMPLOYEE" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table EVALUATION
--------------------------------------------------------

  ALTER TABLE "WORKSHOP"."EVALUATION" MODIFY ("QUESTION10" NOT NULL ENABLE);
  ALTER TABLE "WORKSHOP"."EVALUATION" MODIFY ("QUESTION9" NOT NULL ENABLE);
  ALTER TABLE "WORKSHOP"."EVALUATION" MODIFY ("QUESTION8" NOT NULL ENABLE);
  ALTER TABLE "WORKSHOP"."EVALUATION" MODIFY ("QUESTION7" NOT NULL ENABLE);
  ALTER TABLE "WORKSHOP"."EVALUATION" MODIFY ("QUESTION6" NOT NULL ENABLE);
  ALTER TABLE "WORKSHOP"."EVALUATION" MODIFY ("QUESTION5" NOT NULL ENABLE);
  ALTER TABLE "WORKSHOP"."EVALUATION" MODIFY ("QUESTION4" NOT NULL ENABLE);
  ALTER TABLE "WORKSHOP"."EVALUATION" MODIFY ("QUESTION3" NOT NULL ENABLE);
  ALTER TABLE "WORKSHOP"."EVALUATION" MODIFY ("QUESTION2" NOT NULL ENABLE);
  ALTER TABLE "WORKSHOP"."EVALUATION" MODIFY ("QUESTION1" NOT NULL ENABLE);
  ALTER TABLE "WORKSHOP"."EVALUATION" MODIFY ("FILL_DATE" NOT NULL ENABLE);
  ALTER TABLE "WORKSHOP"."EVALUATION" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "WORKSHOP"."EVALUATION" ADD CONSTRAINT "EVALUATION_PK" PRIMARY KEY ("ID")
  USING INDEX;
  ALTER TABLE "WORKSHOP"."EVALUATION" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table EVALUATIONPLAN
--------------------------------------------------------

  ALTER TABLE "WORKSHOP"."EVALUATIONPLAN" MODIFY ("EXPIRATION" NOT NULL ENABLE);
  ALTER TABLE "WORKSHOP"."EVALUATIONPLAN" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "WORKSHOP"."EVALUATIONPLAN" ADD CONSTRAINT "EVALUATIONPLAN_PK" PRIMARY KEY ("ID")
  USING INDEX;
  ALTER TABLE "WORKSHOP"."EVALUATIONPLAN" MODIFY ("BRANCH" NOT NULL ENABLE);
  ALTER TABLE "WORKSHOP"."EVALUATIONPLAN" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table BRANCH
--------------------------------------------------------

  ALTER TABLE "WORKSHOP"."BRANCH" ADD CONSTRAINT "BRANCH_FK_BRANCH" FOREIGN KEY ("PARRENTBRANCH")
	  REFERENCES "WORKSHOP"."BRANCH" ("ID") ON DELETE SET NULL ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table EMPLOYEE
--------------------------------------------------------

  ALTER TABLE "WORKSHOP"."EMPLOYEE" ADD CONSTRAINT "EMPLOYEE_FK_BRANCH" FOREIGN KEY ("BRANCH")
	  REFERENCES "WORKSHOP"."BRANCH" ("ID") ON DELETE SET NULL ENABLE;
  ALTER TABLE "WORKSHOP"."EMPLOYEE" ADD CONSTRAINT "EMPLOYEE_FK_PLAN" FOREIGN KEY ("PLAN")
	  REFERENCES "WORKSHOP"."EVALUATIONPLAN" ("ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table EVALUATIONPLAN
--------------------------------------------------------

  ALTER TABLE "WORKSHOP"."EVALUATIONPLAN" ADD CONSTRAINT "EVALUATIONPLAN_FK_BRANCH" FOREIGN KEY ("BRANCH")
	  REFERENCES "WORKSHOP"."BRANCH" ("ID") ENABLE;


--------------------------------------------------------
--  DDL for Sequence EVALUATION_PLAN_SEQUENCE
--------------------------------------------------------

   CREATE SEQUENCE  "WORKSHOP"."EVALUATION_PLAN_SEQUENCE"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence EVALUATION_SEQUENCE
--------------------------------------------------------

   CREATE SEQUENCE  "WORKSHOP"."EVALUATION_SEQUENCE"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
