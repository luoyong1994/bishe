drop database if exists mynote;
create database mynote;
use mynote;
CREATE TABLE sysuser(
  user_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  user_name VARCHAR(255) NOT NULL,
  user_password VARCHAR(255) NOT NULL,
  user_phone VARCHAR(255) NOT NULL
) ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;


create table user_role(
	id int NOT NULL,
	user_id INT NOT NULL,
	role_id int NOT null
) ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;


create TABLE sysrole(
	role_id int not NULL PRIMARY KEY AUTO_INCREMENT,
	role_desc VARCHAR(20) not NULL 
) ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;


create TABLE role_source(
	id int NOT NULL,
	role_id INT NOT NULL,
	source_id INT NOT NULL
)ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;

create TABLE resource(
	source_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	source_name VARCHAR(40) NOT NULL,
	source_url VARCHAR(100) NOT null,
	source_type VARCHAR(10) NOT NULL,
	source_parentId int,
	source_sort int(2) NOT NULL
) ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;


CREATE TABLE artic(
  artic_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  artic_title VARCHAR(100) NOT NULL,
  artic_content VARCHAR(2000) NOT NULL,
  artic_type VARCHAR(2) NOT NULL
) ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;
