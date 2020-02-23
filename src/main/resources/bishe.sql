drop database if exists bishe;
create database bishe;
use bishe;
create TABLE sysuser(
    id varchar(50) NOT NULL PRIMARY KEY comment 'id',
    username varchar(50) comment '用户名',
    name VARCHAR(100) NOT NULL comment '姓名',
    password VARCHAR(50) NOT NULL comment '密码',
    qq varchar(50) comment '人员qq号',
    tel varchar(11) not null comment '电话',
    random varchar(32) comment '密码加盐'
) ENGINE=INNODB  DEFAULT CHARSET=utf8;

insert into sysuser(id,username,name,password,tel,qq)values ("07e31d155fb34323973c23d0c24d093e","admin132","admin","66854f1b110143269dbffdd806fa66eb","15096618134","1411548549");
create table user_role(
  id int NOT NULL comment 'id',
  userId INT NOT NULL comment '用户id',
  roleId int NOT null comment '角色id'
) ENGINE=INNODB DEFAULT CHARSET=utf8;

create TABLE sysrole(
  id int not NULL PRIMARY KEY  comment '角色id',
  roleName varchar2(20) not null comment '角色名'
  roleDesc VARCHAR(20) not NULL comment '角色名称'
) ENGINE=INNODB DEFAULT CHARSET=utf8;

create TABLE role_source(
	id int NOT NULL COMMENT 'id',
	roleId INT NOT NULL comment '角色id',
	sourceId INT NOT NULL comment '资源id'
)ENGINE=INNODB DEFAULT CHARSET=utf8;

#这也就是菜单表
create TABLE resource(
	id INT NOT NULL PRIMARY KEY  comment '资源id',
	Name VARCHAR(40) NOT NULL comment '资源名字',
	router VARCHAR(100) NOT null comment '路由',
	type VARCHAR(10) NOT NULL comment '资源类型',
	parentId int comment '资源父id',
	sort int(2) NOT NULL comment '资源序号'
) ENGINE=INNODB  DEFAULT CHARSET=utf8;

#待扩展就是权限表，更加细粒度的控制

#店铺订单信息添加表
create table inorder(
  id varchar(50) NOT NULL PRIMARY KEY  comment '项目编号',
  shop varchar(50) comment '店铺',
  wantName varchar(50) comment '旺旺名',
  serviceQQ varchar(50) comment '客服qq',
  customerQQ varchar(50) comment '客户qq',
  projectName varchar(100) comment '项目名',
  technology varchar(50) comment '使用技术',
  orderDate varchar(14) comment '接单时间',
  totalAmt decimal(10,3) comment '项目总金额',
  bookAmt decimal(10,3) comment '项目定金',
  projectProcess varchar(2) comment '外包结账: 1-开发结账,2-论文结账,3-外包结账完成',
  programAmt decimal(10,3) comment '程序金额',
  paperTitle varchar(200) comment '论文题目',
  paperAmt  decimal(10,3) comment '论文金额',
  orderBillStatue varchar(1) comment '订单结账状态：0-订单未结账，1-订单已结账',
  programBillDate  varchar(50) comment '技术结账时间',
  parperBillDate varchar(50) comment  '论文结账时间',
  comcustBillDate varchar(50) comment '客户结账时间'
) ENGINE=INNODB DEFAULT CHARSET=utf8;
# 附件目录
create table annex(
  orderId varchar(50) PRIMARY KEY comment '项目编号',
  docPath varchar(200) comment '需求说明文档路径',
  docName varchar(50) comment '文件名',
  imagePath varchar(500) comment '图片路径，用;分割',
  remarks varchar(500) comment '备注'
)ENGINE=INNODB  DEFAULT CHARSET=utf8;

#订单派送情况统计表
create table  outorder(
  orderId varchar(50) not null primary key comment '项目编号',
  totalAmt decimal(10,3) comment '项目总价',
  programAmt decimal(10,3) comment '程序价钱',
  paperAmt decimal(10,3) comment '论文价钱',
  programname varchar(100) comment '程序技术姓名',
  papername varchar(100) comment '论文技术姓名',
  tel varchar(11) comment '技术电话',
  projectProcess varchar(2) comment '流水接单，项目进度:0-未接单，1-开发中，2-开发完成',
  orderDate varchar(20) comment '接单时间',
  qq varchar(50) comment '技术qq',
  papertel varchar(11) comment '论文技术电话',
  paperqq varchar(50) comment '论文技术qq'
) ENGINE=INNODB  DEFAULT CHARSET=utf8;
# 分类
create table classify(
  id varchar(50) not null PRIMARY KEY comment 'id',
  name varchar(50) not null comment '分类名'
)ENGINE=INNODB  DEFAULT CHARSET=utf8;

# 订单流水
create table acceptorderflow(
  flowNo varchar(50) primary key comment '流水号',
  orderId varchar(50) not null comment '项目编号',
  programname varchar(50) not null comment '姓名',
  price decimal(10,3) comment '出价位',
  tel varchar(14) comment '电话',
  qq varchar(50) comment 'qq号',
  orderDate varchar(14) comment '下单日期'
)ENGINE=INNODB  DEFAULT CHARSET=utf8;