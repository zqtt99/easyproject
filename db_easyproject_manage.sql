# Host: 127.0.0.1  (Version: 5.5.15)
# Date: 2023-03-11 21:21:02
# Generator: MySQL-Front 5.3  (Build 4.269)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "admin"
#

DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='管理员表';

#
# Data for table "admin"
#

INSERT INTO `admin` VALUES (1,'admin','admin');

#
# Structure for table "user"
#

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `country` varchar(255) DEFAULT NULL COMMENT '国家',
  `name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `phone` varchar(255) DEFAULT NULL COMMENT '联系方式',
  `purpose` varchar(255) DEFAULT NULL COMMENT '用途',
  `status` int(11) DEFAULT NULL COMMENT '审核状态（0未审核，1通过，2驳回）',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

#
# Data for table "user"
#

INSERT INTO `user` VALUES (1,'1','1','1','1','1','1','1',1),(2,'soloyao','123456','343722243@qq.com','中国','张三','15235332536','测试111',1);
