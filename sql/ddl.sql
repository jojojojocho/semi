drop table if exists board CASCADE;
create table board
(
 postnum bigint AUTO_INCREMENT,
 title varchar(255),
 name varchar(255),
 body varchar(255),
 time varchar(255),
 primary key (postnum)
);