CREATE TABLE tomcat$sessions
(
  id VARCHAR NOT NULL,
  app VARCHAR,
  data BLOB,
  lastaccess BIGINT NOT NULL,
  maxinactive INT NOT NULL,
  valid char(1) NOT NULL,
  PRIMARY KEY (id)
)