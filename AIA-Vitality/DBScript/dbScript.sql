DROP TABLE AIA_SETTINGS;

DROP TABLE AIA_USERS;

DROP TABLE AIA_SEQUENCE;

DROP TABLE AIA_REPORT;

DROP TABLE HK_APPROACH_SILVER;

DROP TABLE HK-ENGAGEMENT_REMINDER1;

DROP TABLE HK-DOWNGRADE_WARNING;

DROP TABLE HK-APPROACH_PLATINUM;

DROP TABLE HK-APPROACH_GOLD;

DROP TABLE HK-ADIDAS_MICOACH_CONCENT_REMINDER;

DROP TABLE HK-ACHIEVE_SILVER;

DROP TABLE HK-ACHIEVE_PLATINUM;

DROP TABLE HK-ACHIEVE_GOLD;

//Creating tables


CREATE TABLE AIA_USERS (
  USER_ID INTEGER NOT NULL,
  USER_NAME VARCHAR(20) NOT NULL,
  FIRST_NAME VARCHAR(20) NULL,
  LAST_NAME VARCHAR(20) NULL,
  PASS VARCHAR(45) NULL,
  CREATED_DATE DATE NULL,
  CREATED_BY VARCHAR(20) NULL,
  MODIFIED_DATE DATE NULL,
  MODIFIED_BY VARCHAR(20) NULL,
  CONSTRAINT pk_USER_ID PRIMARY KEY (USER_ID));
  
  CREATE TABLE AIA_SETTINGS (
  SETTINGS_ID INTEGER NOT NULL,
  USER_ID INTEGER NOT NULL,
  PLATFORM VARCHAR(25) NOT NULL,
  URL VARCHAR(60) NULL,
  PASSWORD_2 VARCHAR(50) NULL,
  ORGANISATION VARCHAR(50) NULL,
  CREATED_DATE DATE NULL,
  MODIFIED_DATE DATE NULL,
  CREATED_DY VARCHAR(25) NULL,
  MODIFIED_BY VARCHAR(25) NULL,
  STATUS_2 VARCHAR(2) NULL,
  PORT VARCHAR(25) NULL,
  CONSTRAINT pk_SETTINGS_ID PRIMARY KEY (SETTINGS_ID),
  CONSTRAINT fk_USER_ID FOREIGN KEY (USER_ID) REFERENCES AIA_USERS(USER_ID));

CREATE TABLE AIA_REPORT (
  AIA_REPORT_ID INTEGER NOT NULL,
  FILE_NAME INTEGER NULL,
  RECORD_COUNT INTEGER NULL,
  RECORD_PENDING INTEGER NULL,
  RECORD_PROCESSED INTEGER NULL,
  RECORD_SUCCESS INTEGER NULL,
  RECORD_FAILED INTEGER NULL,
  PROCESS_DATE INTEGER NULL,
  PRIMARY KEY(AIA_REPORT_ID));

CREATE TABLE AIA_SEQUENCE (
  AIA_SEQUENCE_ID INTEGER NOT NULL,
  TABLE_NAME VARCHAR(50) NULL,
  NEXT_ID INTEGER NULL,
  INCREMENT_VALUE INTEGER NULL,
  PRIMARY KEY(AIA_SEQUENCE_ID));

CREATE TABLE HK_ACHIEVE_GOLD (
  HK_ACHIEVE_GOLD_ID INTEGER NOT NULL,
  MEMBER_FIRST_NAMES VARCHAR(25) NULL,
  MEMBER_SURNAME VARCHAR(25) NULL,
  EMAIL_ADDRESS VARCHAR(25) NULL,
  AIA_VITALITY_MEMBER_NUMBER VARCHAR(25) NULL,
  ENTITY_REFERENCE_NUMBER VARCHAR(25) NULL,
  LANGUAGE_PREFERENCE VARCHAR(25) NULL,
  RECORD_STATUS VARCHAR(2) NULL,
  PROCESS_DATE DATE NULL,
  RECORD_ID VARCHAR(25) NOT NULL,
  PRIMARY KEY(HK_ACHIEVE_GOLD_ID));

CREATE TABLE HK_ACHIEVE_PLATINUM (
  HK_ACHIEVE_PLATINUM_ID INTEGER NOT NULL,
  MEMBER_FIRST_NAMES VARCHAR(25) NULL,
  MEMBER_SURNAME VARCHAR(25) NULL,
  EMAIL_ADDRESS VARCHAR(25) NULL,
  AIA_VITALITY_MEMBER_NUMBER VARCHAR(25) NULL,
  ENTITY_REFERENCE_NUMBER VARCHAR(25) NULL,
  LANGUAGE_PREFERENCE VARCHAR(25) NULL,
  GENDER VARCHAR(2) NULL,
  CLIENT_ID VARCHAR(25) NULL,
  POINTS_BALANCE VARCHAR(25) NULL,
  RECORD_STATUS VARCHAR(25) NULL,
  PROCESS_DATE DATE NULL,
  RECORD_ID VARCHAR(25) NOT NULL,
  PRIMARY KEY(HK_ACHIEVE_PLATINUM_ID));

CREATE TABLE HK_ACHIEVE_SILVER (
  HK_ACHIEVE_SILVER_ID INTEGER NOT NULL,
  MEMBER_FIRST_NAMES VARCHAR(25) NULL,
  MEMBER_SURNAME VARCHAR(25) NULL,
  EMAIL_ADDRESS VARCHAR(25) NULL,
  AIA_VITALITY_MEMBER_NUMBER VARCHAR(25) NULL,
  ENTITY_REFERENCE_NUMBER VARCHAR(25) NULL,
  VITALITY_STATUS VARCHAR(25) NULL,
  POINTS_BALANCE VARCHAR(25) NULL,
  GENDER VARCHAR(2) NULL,
  CLIENT_ID VARCHAR(25) NULL,
  LANGUAGE_PREFERENCE VARCHAR(25) NULL,
  RECORD_STATUS VARCHAR(2) NULL,
  PROCESS_DATE DATE NULL,
  RECORD_ID VARCHAR(25) NOT NULL,
  PRIMARY KEY(HK_ACHIEVE_SILVER_ID));

CREATE TABLE HK_ADIDAS_MICOACH_CONCENT_REMINDER (
  HK_ADIDAS_MICOACH_CONCENT_REMINDER_ID INTEGER NOT NULL,
  MEMBER_FIRST_NAMES VARCHAR(25) NULL,
  MEMBER_SURNAME VARCHAR(25) NULL,
  EMAIL_ADDRESS VARCHAR(25) NULL,
  AIA_VITALITY_MEMBER_NUMBER VARCHAR(25) NULL,
  ENTITY_REFERENCE_NUMBER VARCHAR(25) NULL,
  CLIENT_ID VARCHAR(25) NULL,
  LANGUAGE_PREFERENCE VARCHAR(25) NULL,
  RECORD_STATUS VARCHAR(2) NULL,
  PROCESS_DATE DATE NULL,
  RECORD_ID VARCHAR(25) NOT NULL,
  PRIMARY KEY(HK_ADIDAS_MICOACH_CONCENT_REMINDER_ID));

CREATE TABLE HK_APPROACH_GOLD (
  HK_APPROACH_GOLD_ID INTEGER NOT NULL,
  MEMBER_FIRST_NAMES VARCHAR(25) NULL,
  MEMBER_SURNAME VARCHAR(25) NULL,
  EMAIL_ADDRESS VARCHAR(25) NULL,
  AIA_VITALITY_MEMBER_NUMBER VARCHAR(25) NULL,
  ENTITY_REFERENCE_NUMBER VARCHAR(25) NULL,
  VITALITY_STATUS VARCHAR(25) NULL,
  POINTS_BALANCE VARCHAR(25) NULL,
  POINTS_TO_GOLD VARCHAR(25) NULL,
  GENDER VARCHAR(2) NULL,
  SMOKER_IND VARCHAR(25) NULL,
  MEMBER_EXPIRY_DATE DATE NULL,
  CLIENT_ID VARCHAR(25) NULL,
  LANGUAGE_PREFERENCE VARCHAR(25) NULL,
  RECORD_STATUS VARCHAR(2) NULL,
  PROCESS_DATE DATE NULL,
  RECORD_ID VARCHAR(25) NOT NULL,
  PRIMARY KEY(HK_APPROACH_GOLD_ID));

CREATE TABLE HK_APPROACH_PLATINUM (
  HK_APPROACH_PLATINUM_ID INTEGER NOT NULL,
  MEMBER_FIRST_NAMES VARCHAR(25) NULL,
  MEMBER_SURNAME VARCHAR(25) NULL,
  EMAIL_ADDRESS VARCHAR(25) NULL,
  AIA_VITALITY_MEMBER_NUMBER VARCHAR(25) NULL,
  ENTITY_REFERENCE_NUMBER VARCHAR(25) NULL,
  VITALITY_STATUS VARCHAR(25) NULL,
  POINTS_BALANCE VARCHAR(25) NULL,
  POINTS_TO_GOLD VARCHAR(25) NULL,
  GENDER VARCHAR(2) NULL,
  SMOKER_IND VARCHAR(25) NULL,
  MEMBER_EXPIRY_DATE DATE NULL,
  CLIENT_ID VARCHAR(25) NULL,
  LANGUAGE_PREFERENCE VARCHAR(25) NULL,
  RECORD_STATUS VARCHAR(2) NULL,
  PROCESS_DATE DATE NULL,
  RECORD_ID VARCHAR(25) NOT NULL,
  PRIMARY KEY(HK_APPROACH_PLATINUM_ID));

CREATE TABLE HK_DOWNGRADE_WARNING (
  HK_DOWNGRADE_WARNING_ID INTEGER NOT NULL,
  MEMBER_FIRST_NAMES VARCHAR(25) NULL,
  MEMBER_SURNAME VARCHAR(25) NULL,
  EMAIL_ADDRESS VARCHAR(25) NULL,
  AIA_VITALITY_MEMBER_NUMBER VARCHAR(25) NULL,
  ENTITY_REFERENCE_NUMBER VARCHAR(25) NULL,
  VITALITY_STATUS VARCHAR(25) NULL,
  POINTS_TO_MAINTAIN_STATUS VARCHAR(25) NULL,
  GENDER VARCHAR(2) NULL,
  MEMBER_EXPIRY_DATE DATE NULL,
  SMOKER_IND VARCHAR(25) NULL,
  CLIENT_ID VARCHAR(25) NULL,
  LANGUAGE_PREFERENCE VARCHAR(25) NULL,
  RECORD_STATUS VARCHAR(2) NULL,
  PROCESS_DATE DATE NULL,
  RECORD_ID VARCHAR(25) NOT NULL,
  PRIMARY KEY(HK_DOWNGRADE_WARNING_ID));

CREATE TABLE HK_ENGAGEMENT_REMINDER1 (
  HK_ENGAGEMENT_REMINDER1_ID INTEGER NOT NULL,
  MEMBER_FIRST_NAMES VARCHAR(25) NULL,
  MEMBER_SURNAME VARCHAR(25) NULL,
  EMAIL_ADDRESS VARCHAR(25) NULL,
  AIA_VITALITY_MEMBER_NUMBER VARCHAR(25) NULL,
  ENTITY_REFERENCE_NUMBER VARCHAR(25) NULL,
  VITALITY_STATUS VARCHAR(25) NULL,
  POINTS_TO_MAINTAIN_STATUS VARCHAR(25) NULL,
  GENDER VARCHAR(2) NULL,
  MEMBER_EXPIRY_DATE DATE NULL,
  SMOKER_IND VARCHAR NULL,
  CLIENT_ID VARCHAR(25) NULL,
  LANGUAGE_PREFERENCE VARCHAR(25) NULL,
  RECORD_STATUS VARCHAR(2) NULL,
  PROCESS_DATE DATE NULL,
  RECORD_ID VARCHAR(25) NOT NULL,
  PRIMARY KEY(HK_ENGAGEMENT_REMINDER1_ID));

CREATE TABLE HK_APPROACH_SILVER (
  HK_APPROACH_SILVER_ID INTEGER NOT NULL,
  MEMBER_FIRST_NAMES VARCHAR(25) NULL,
  MEMBER_SURNAME VARCHAR(25) NULL,
  EMAIL_ADDRESS VARCHAR(25) NULL,
  AIA_VITALITY_MEMBER_NUMBER VARCHAR(25) NULL,
  ENTITY_REFERENCE_NUMBER VARCHAR(25) NULL,
  VITALITY_STATUS VARCHAR(25) NULL,
  POINTS_BALANCE VARCHAR(25) NULL,
  POINTS_TO_SILVER VARCHAR(25) NULL,
  GENDER VARCHAR(2) NULL,
  SMOKER_IND VARCHAR(25) NULL,
  MEMBER_EXPIRY_DATE DATE NULL,
  CLIENT_ID VARCHAR(25) NULL,
  LANGUAGE_PREFERENCE VARCHAR(25) NULL,
  RECORD_STATUS VARCHAR(2) NULL,
  PROCESS_DATE DATE NULL,
  RECORD_ID VARCHAR(25) NOT NULL,
  PRIMARY KEY(HK_APPROACH_SILVER_ID));
  
  CREATE TABLE HK_ENGAGEMENT_REMINDER2 (
  HK_ENGAGEMENT_REMINDER2_ID INTEGER NOT NULL,
  MEMBER_FIRST_NAMES VARCHAR(25) NULL,
  MEMBER_SURNAME VARCHAR(25) NULL,
  EMAIL_ADDRESS VARCHAR(25) NULL,
  AIA_VITALITY_MEMBER_NUMBER VARCHAR(25) NULL,
  ENTITY_REFERENCE_NUMBER VARCHAR(25) NULL,
  CLIENT_ID VARCHAR(25) NULL,
  LANGUAGE_PREFERENCE VARCHAR(25) NULL,
  RECORD_STATUS VARCHAR(2) NULL,
  PROCESS_DATE DATE NULL,
  RECORD_ID VARCHAR(25) NOT NULL,
  PRIMARY KEY(HK_ENGAGEMENT_REMINDER2_ID));
  
  CREATE TABLE HK_ENGAGEMENT_REMINDER3 (
  HK_ENGAGEMENT_REMINDER3_ID INTEGER NOT NULL,
  MEMBER_FIRST_NAMES VARCHAR(25) NULL,
  MEMBER_SURNAME VARCHAR(25) NULL,
  EMAIL_ADDRESS VARCHAR(25) NULL,
  AIA_VITALITY_MEMBER_NUMBER VARCHAR(25) NULL,
  ENTITY_REFERENCE_NUMBER VARCHAR(25) NULL,
  CLIENT_ID VARCHAR(25) NULL,
  LANGUAGE_PREFERENCE VARCHAR(25) NULL,
  RECORD_STATUS VARCHAR(2) NULL,
  PROCESS_DATE DATE NULL,
  RECORD_ID VARCHAR(25) NOT NULL,
  PRIMARY KEY(HK_ENGAGEMENT_REMINDER3_ID));
  GO
  


