CREATE TABLE AUTHORITY (
   ID BIGINT GENERATED BY DEFAULT AS IDENTITY,
   NAME VARCHAR(255),
   PRIMARY KEY (ID)
);

CREATE TABLE USERS_AUTHORITIES (
   USER_ID BIGINT NOT NULL,
   AUTHORITY_ID BIGINT NOT NULL,
   PRIMARY KEY (USER_ID, AUTHORITY_ID)
);