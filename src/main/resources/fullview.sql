drop database if exists fullview;
create database fullview;
use fullview;
CREATE TABLE sysuser(
  user_id VARCHAR(100) NOT NULL PRIMARY KEY,
  user_name VARCHAR(255) NOT NULL,
  user_password VARCHAR(255) NOT NULL,
  user_phone VARCHAR(255) NOT NULL,
  user_type VARCHAR(2)
) ENGINE=INNODB  DEFAULT CHARSET=utf8;
--0是校外用户 1是校内用户   2是管理员

create table user_role(
	id VARCHAR(100) NOT NULL,
	user_id VARCHAR(100) NOT NULL,
	role_id VARCHAR(100) NOT null
) ENGINE=INNODB  DEFAULT CHARSET=utf8;


create TABLE sysrole(
	role_id VARCHAR(100) not NULL PRIMARY KEY,
	role_desc VARCHAR(20) not NULL
) ENGINE=INNODB  DEFAULT CHARSET=utf8;


create TABLE role_source(
	id VARCHAR(100) NOT NULL,
	role_id VARCHAR(100) NOT NULL,
	source_id VARCHAR(100) NOT NULL
)ENGINE=INNODB  DEFAULT CHARSET=utf8;

create TABLE resource(
	source_id VARCHAR(100) NOT NULL PRIMARY KEY,
	source_name VARCHAR(40) NOT NULL,
	source_url VARCHAR(100) NOT null,
	source_type VARCHAR(10) NOT NULL,
	source_parentId VARCHAR(100),
	source_sort VARCHAR(100) NOT NULL
) ENGINE=INNODB  DEFAULT CHARSET=utf8;

create TABLE region(
	id VARCHAR(100) NOT NULL PRIMARY KEY,
	imagepath VARCHAR(200) NOT NULL,
	notify VARCHAR(500) NOT null
) ENGINE=INNODB  DEFAULT CHARSET=utf8;

create TABLE comment(
	id VARCHAR(100) NOT NULL PRIMARY KEY,
	regionId VARCHAR(100) NOT NULL,
	comment VARCHAR(500) NOT null
) ENGINE=INNODB  DEFAULT CHARSET=utf8;
