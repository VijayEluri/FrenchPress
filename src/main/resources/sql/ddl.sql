DROP TABLE IF EXISTS mediaitems;
DROP TABLE IF EXISTS attachments;
DROP TABLE IF EXISTS settings;
DROP TABLE IF EXISTS pages;
DROP TABLE IF EXISTS comments;
DROP TABLE IF EXISTS posts;
DROP TABLE IF EXISTS sequence;
DROP TABLE IF EXISTS users;

CREATE TABLE IF NOT EXISTS SEQUENCE (SEQ_NAME VARCHAR(50) NOT NULL, SEQ_COUNT DECIMAL(38), PRIMARY KEY (SEQ_NAME));
INSERT INTO SEQUENCE(SEQ_NAME, SEQ_COUNT) values ('SEQ_GEN', 0);

CREATE TABLE IF NOT EXISTS mediaitems (ID BIGINT NOT NULL, version BIGINT NOT NULL, NAME VARCHAR(255), FILESIZE BIGINT NOT NULL, MIMETYPE VARCHAR(255), UPLOADEDDATE TIMESTAMP, CONTENTS LONGBLOB, PRIMARY KEY (ID));
CREATE TABLE IF NOT EXISTS comments (ID BIGINT NOT NULL, AUTHOR_ID BIGINT, POST_ID BIGINT, AUTHORNAME VARCHAR(255), AUTHOREMAIL VARCHAR(255), AUTHORURL VARCHAR(255), BODY TEXT, COMMENTDATE TIMESTAMP, PRIMARY KEY (ID));
CREATE TABLE IF NOT EXISTS pages (ID BIGINT NOT NULL, version BIGINT NOT NULL, BODY TEXT, TITLE VARCHAR(255), AUTHOR_ID BIGINT, PRIMARY KEY (ID));
CREATE TABLE IF NOT EXISTS users (ID BIGINT NOT NULL, version BIGINT NOT NULL, EMAILADDRESS VARCHAR(255), FIRSTNAME VARCHAR(255), LASTNAME VARCHAR(255), PASSWORD VARCHAR(255), USERROLE VARCHAR(255), PRIMARY KEY (ID));
CREATE TABLE IF NOT EXISTS settings (ID BIGINT NOT NULL, PRIMARY KEY (ID));
CREATE TABLE IF NOT EXISTS attachments (ID BIGINT NOT NULL, version BIGINT NOT NULL, MIMETYPE VARCHAR(255), NAME VARCHAR(255), PRIMARY KEY (ID));
CREATE TABLE IF NOT EXISTS posts (ID BIGINT NOT NULL, version BIGINT NOT NULL, BODY TEXT, SLUG VARCHAR(255), TITLE VARCHAR(255), AUTHOR_ID BIGINT, POSTED TIMESTAMP, PRIMARY KEY (ID));
ALTER TABLE posts ADD CONSTRAINT UNQ_posts_0 UNIQUE (slug);
ALTER TABLE posts ADD CONSTRAINT FK_posts_AUTHOR_ID FOREIGN KEY (AUTHOR_ID) REFERENCES users (ID);
ALTER TABLE comments ADD CONSTRAINT FK_comments_AUTHOR_ID FOREIGN KEY (AUTHOR_ID) REFERENCES users (ID);
ALTER TABLE comments ADD CONSTRAINT FK_comments_POST_ID FOREIGN KEY (POST_ID) REFERENCES posts (ID);
ALTER TABLE pages ADD CONSTRAINT FK_pages_AUTHOR_ID FOREIGN KEY (AUTHOR_ID) REFERENCES users (ID);

