drop table if exists book;

CREATE TABLE book (
  book_id number(12),
  title varchar(80) NOT NULL,
  price number(10,2) NOT NULL,
  publish_time date DEFAULT NULL,
  blob_content blob,
  PRIMARY KEY (book_id)
) ;

drop table if exists  editor;
CREATE TABLE editor (
  editor_id number(12) ,
  name varchar(80) NOT NULL,
  sex char(1) DEFAULT NULL,
  PRIMARY KEY (editor_id)
) ;

drop table if exists  book_editor;
CREATE TABLE book_editor (
  book_id number(12)NOT NULL,
  editor_id number(12)  NOT NULL,
  PRIMARY KEY (book_id,editor_id)
);
