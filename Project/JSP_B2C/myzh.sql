/*
Navicat MySQL Data Transfer
Source Host     : localhost:3306
Source Database : myzh
Target Host     : localhost:3306
Target Database : myzh
Date: 2015-01-24 19:06:08
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `account_id` int(11) NOT NULL auto_increment,
  `act_no` varchar(255) default NULL,
  `bal` double default NULL,
  `user_id` int(11) default NULL,
  PRIMARY KEY  (`account_id`),
  KEY `FK_qc7yw9e8rjb74ql6jmygv90se` (`user_id`),
  CONSTRAINT `FK_qc7yw9e8rjb74ql6jmygv90se` FOREIGN KEY (`user_id`) REFERENCES `nickname` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1', '111', '888888.88', '1');
INSERT INTO `account` VALUES ('2', '222', '888888.88', '1');
INSERT INTO `account` VALUES ('3', '333', '888888.88', '1');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `category_id` int(11) NOT NULL,
  `category_name` varchar(30) NOT NULL,
  PRIMARY KEY  (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', 'Camera');
INSERT INTO `category` VALUES ('2', 'Phones');
INSERT INTO `category` VALUES ('3', 'Computer');

-- ----------------------------
-- Table structure for category_son
-- ----------------------------
DROP TABLE IF EXISTS `category_son`;
CREATE TABLE `category_son` (
  `id` int(11) NOT NULL auto_increment,
  `category_id` int(11) NOT NULL,
  `category_son_id` int(11) NOT NULL,
  `category_son_name` varchar(30) NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `category_id` (`category_id`),
  KEY `category_son_id` (`category_son_id`),
  CONSTRAINT `category_son_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category_son
-- ----------------------------
INSERT INTO `category_son` VALUES ('1', '3', '1', 'Sony');
INSERT INTO `category_son` VALUES ('2', '2', '1', 'Iphone');
INSERT INTO `category_son` VALUES ('3', '1', '1', 'canon');
INSERT INTO `category_son` VALUES ('4', '3', '2', 'Sam');

-- ----------------------------
-- Table structure for customs
-- ----------------------------
DROP TABLE IF EXISTS `customs`;
CREATE TABLE `customs` (
  `c_name` varchar(70) default NULL,
  `c_birth` datetime NOT NULL,
  `c_tel` varchar(50) default NULL,
  `c_num` int(10) NOT NULL,
  `c_sex` varchar(50) default NULL,
  PRIMARY KEY  (`c_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customs
-- ----------------------------

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `d_no` int(11) NOT NULL default '0',
  `d_name` varchar(255) default NULL,
  `d_tell` varchar(255) default NULL,
  PRIMARY KEY  (`d_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('80001', '游戏系', '87818083');
INSERT INTO `dept` VALUES ('80002', '软件工程系', '87818998');
INSERT INTO `dept` VALUES ('80003', '管理系', '87818428');
INSERT INTO `dept` VALUES ('80004', '国际经贸系', '87818259');

-- ----------------------------
-- Table structure for dingdan
-- ----------------------------
DROP TABLE IF EXISTS `dingdan`;
CREATE TABLE `dingdan` (
  `c_id` varchar(10) default NULL,
  `o_date` varchar(50) default NULL,
  `o_name` varchar(50) default NULL,
  KEY `fk_cpu_model` (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dingdan
-- ----------------------------
INSERT INTO `dingdan` VALUES ('44', '44', '44');
INSERT INTO `dingdan` VALUES ('44', '44', '44');
INSERT INTO `dingdan` VALUES ('44', '44', '44');
INSERT INTO `dingdan` VALUES ('44', '44', '44');

-- ----------------------------
-- Table structure for economy
-- ----------------------------
DROP TABLE IF EXISTS `economy`;
CREATE TABLE `economy` (
  `f_price` decimal(5,0) default NULL,
  `f_name` char(255) default NULL,
  `f_id` char(80) NOT NULL,
  `f_date` date default NULL,
  PRIMARY KEY  (`f_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of economy
-- ----------------------------
INSERT INTO `economy` VALUES ('6', 'apple', 'a1', '2013-10-02');
INSERT INTO `economy` VALUES ('4', 'melon', 'a2', '2013-09-27');
INSERT INTO `economy` VALUES ('4', 'banana', 'b1', '2013-10-06');
INSERT INTO `economy` VALUES ('9', 'orange', 'b2', '2013-09-27');
INSERT INTO `economy` VALUES ('2', 'lemon', 'b6', '2013-09-25');
INSERT INTO `economy` VALUES ('85', 'cherry', 'c1', '2013-10-04');
INSERT INTO `economy` VALUES ('13', 'berry', 'c3', '2013-10-04');
INSERT INTO `economy` VALUES ('10', 'grape', 'd3', '2013-09-30');
INSERT INTO `economy` VALUES ('13', 'mango', 'e5', '2013-09-28');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `sex` varchar(50) NOT NULL,
  `job` varchar(20) default NULL,
  `Salary` float(10,0) default NULL,
  `dept_no` int(10) default NULL,
  `hiredate` date default NULL,
  PRIMARY KEY  (`id`),
  KEY `ff` (`dept_no`),
  CONSTRAINT `ff` FOREIGN KEY (`dept_no`) REFERENCES `dept` (`d_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('1001', 'smith', '男', '教师', '5000', '80001', '2008-08-08');
INSERT INTO `employee` VALUES ('1002', 'allen', '男', '辅导员', '4000', '80001', '2011-04-15');
INSERT INTO `employee` VALUES ('1003', 'ward', '男', '教师', '4200', '80001', '2012-03-01');
INSERT INTO `employee` VALUES ('1004', 'jones', '女', '教师', '4200', '80002', '2012-03-01');
INSERT INTO `employee` VALUES ('1005', 'martin', '女', '教务员', '3700', '80002', '2009-07-01');
INSERT INTO `employee` VALUES ('1006', 'blake', '男', '教师', '8000', '80002', '2003-02-01');
INSERT INTO `employee` VALUES ('1007', 'clark', '女', '教师', '6300', '80003', '2004-08-01');
INSERT INTO `employee` VALUES ('1008', 'scott', '女', '辅导员', '5500', '80003', '2006-08-01');
INSERT INTO `employee` VALUES ('1009', 'king', '男', '教师', '4800', '80004', '2010-12-24');
INSERT INTO `employee` VALUES ('1010', 'turner', '男', '辅导员', '5700', '80004', '2004-08-01');
INSERT INTO `employee` VALUES ('1011', 'adams', '男', '辅导员', '3600', '80004', '2011-04-15');
INSERT INTO `employee` VALUES ('1012', 'james', '女', '教师', '4600', '80004', '2007-09-01');

-- ----------------------------
-- Table structure for hibernate_unique_key
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_unique_key`;
CREATE TABLE `hibernate_unique_key` (
  `next_hi` int(11) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hibernate_unique_key
-- ----------------------------
INSERT INTO `hibernate_unique_key` VALUES ('1');

-- ----------------------------
-- Table structure for nickname
-- ----------------------------
DROP TABLE IF EXISTS `nickname`;
CREATE TABLE `nickname` (
  `user_id` int(11) NOT NULL auto_increment,
  `Nickname_name` varchar(255) default NULL,
  `Nickname_password` varchar(255) default NULL,
  PRIMARY KEY  (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of nickname
-- ----------------------------
INSERT INTO `nickname` VALUES ('1', 'ccc', '123434457');

-- ----------------------------
-- Table structure for person
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `id` int(11) NOT NULL,
  `type` varchar(255) NOT NULL,
  `name` varchar(255) default NULL,
  `sex` varchar(255) default NULL,
  `age` int(11) default NULL,
  `sno` varchar(255) default NULL,
  `school` varchar(255) default NULL,
  `no` varchar(255) default NULL,
  `salary` double default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of person
-- ----------------------------
INSERT INTO `person` VALUES ('1', 'Person', 'zzz', 'm', '22', null, null, null, null);
INSERT INTO `person` VALUES ('2', 'Student', null, null, '0', '111', 'www', null, null);
INSERT INTO `person` VALUES ('3', 'Teacher', null, null, '0', null, null, '1111', '100000.88');

-- ----------------------------
-- Table structure for pet
-- ----------------------------
DROP TABLE IF EXISTS `pet`;
CREATE TABLE `pet` (
  `name` varchar(255) NOT NULL,
  `owner` varchar(255) default NULL,
  `species` varchar(255) NOT NULL,
  `sex` char(255) NOT NULL,
  `birth` year(4) NOT NULL,
  `death` year(4) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pet
-- ----------------------------
INSERT INTO `pet` VALUES ('Buffy', null, 'dog', 'f', '2009', null);
INSERT INTO `pet` VALUES ('Fang', 'KEVIN', 'dog', 'm', '2000', null);
INSERT INTO `pet` VALUES ('Chirpy', 'vicen', 'bird', 'f', '2008', null);

-- ----------------------------
-- Table structure for present
-- ----------------------------
DROP TABLE IF EXISTS `present`;
CREATE TABLE `present` (
  `id` int(11) NOT NULL default '0',
  `present_statrttime` date NOT NULL,
  `present_endtime` date NOT NULL,
  `present_condition` varchar(30) NOT NULL,
  `present_name` varchar(30) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of present
-- ----------------------------

-- ----------------------------
-- Table structure for register
-- ----------------------------
DROP TABLE IF EXISTS `register`;
CREATE TABLE `register` (
  `id` int(11) NOT NULL auto_increment,
  `user_n` varchar(20) NOT NULL,
  `password` varchar(10) NOT NULL,
  `address` varchar(50) NOT NULL,
  `email` varchar(30) NOT NULL,
  `phone` varchar(25) NOT NULL,
  `city` varchar(50) NOT NULL,
  `country` varchar(50) NOT NULL,
  `add_time` datetime default NULL,
  `Ip` varchar(20) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of register
-- ----------------------------
INSERT INTO `register` VALUES ('4', 'Visitor', '1', '1', '1', '1', '1', '1', '2013-12-22 12:14:05', '172.16.142.46');
INSERT INTO `register` VALUES ('16', 'admin', 'aa123', 'gz', 'aasuperkey@163.com', '020-87112566', 'gz', 'china', '2013-12-21 21:29:08', '172.16.142.46');
INSERT INTO `register` VALUES ('17', 'woaini', 'aaaaa', 'aa', 'aasuperkey@163.com', '080-87112566', 'aa', 'china', '2013-12-21 21:35:44', '172.16.142.46');
INSERT INTO `register` VALUES ('18', 'stliverpool', '11111', 'USA', '11111@qq.com', '0754-88888888', 'NewYork', 'china', '2013-12-25 21:50:21', '172.16.142.154');

-- ----------------------------
-- Table structure for shop_message
-- ----------------------------
DROP TABLE IF EXISTS `shop_message`;
CREATE TABLE `shop_message` (
  `id` int(10) NOT NULL auto_increment,
  `shop_id` int(20) NOT NULL,
  `uid` int(50) NOT NULL,
  `level` int(4) NOT NULL,
  `message` varchar(50) NOT NULL,
  `time_date` datetime NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `shop_id` (`shop_id`),
  KEY `uid` (`uid`),
  CONSTRAINT `shop_id` FOREIGN KEY (`shop_id`) REFERENCES `shoplistinfo` (`shop_id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `uid` FOREIGN KEY (`uid`) REFERENCES `register` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop_message
-- ----------------------------
INSERT INTO `shop_message` VALUES ('1', '7', '4', '3', 'dfsdfsfsdf', '2013-12-22 12:14:38');
INSERT INTO `shop_message` VALUES ('2', '10', '4', '4', '我飞', '2013-12-22 12:17:00');
INSERT INTO `shop_message` VALUES ('3', '10', '4', '4', '我飞', '2013-12-22 12:17:02');
INSERT INTO `shop_message` VALUES ('4', '10', '4', '4', '我飞', '2013-12-22 12:17:03');
INSERT INTO `shop_message` VALUES ('5', '10', '4', '2', '我飞', '2013-12-22 12:17:06');
INSERT INTO `shop_message` VALUES ('6', '11', '4', '2', 'fsdfsdfsdfsdf', '2013-12-22 12:17:14');
INSERT INTO `shop_message` VALUES ('7', '11', '4', '2', 'fsdfsdfsdfsdf', '2013-12-22 12:17:16');
INSERT INTO `shop_message` VALUES ('8', '11', '4', '2', 'fsdfsdfsdfsdf', '2013-12-22 12:17:17');
INSERT INTO `shop_message` VALUES ('9', '12', '4', '3', 'dsfdsfsdf', '2013-12-22 12:17:25');
INSERT INTO `shop_message` VALUES ('10', '12', '4', '3', 'dsfdsfsdf', '2013-12-22 12:17:26');
INSERT INTO `shop_message` VALUES ('11', '12', '4', '3', '我飞', '2013-12-22 12:17:27');
INSERT INTO `shop_message` VALUES ('12', '4', '16', '3', 'sdfsdfsdf', '2013-12-22 12:17:42');
INSERT INTO `shop_message` VALUES ('13', '4', '16', '2', 'sdfsdfsdf', '2013-12-22 12:17:43');
INSERT INTO `shop_message` VALUES ('14', '4', '16', '4', 'sdfsdfsdf', '2013-12-22 12:17:46');
INSERT INTO `shop_message` VALUES ('15', '6', '16', '4', 'dfsdfsdf', '2013-12-22 12:17:54');
INSERT INTO `shop_message` VALUES ('16', '6', '16', '4', 'dfsdfsdf', '2013-12-22 12:17:55');
INSERT INTO `shop_message` VALUES ('17', '9', '16', '3', 'dfsdfsd', '2013-12-22 12:18:11');
INSERT INTO `shop_message` VALUES ('18', '9', '16', '4', 'dfsdfsd', '2013-12-22 12:18:14');
INSERT INTO `shop_message` VALUES ('19', '13', '16', '4', 'dsfdsfdsfdsf', '2013-12-22 12:18:44');
INSERT INTO `shop_message` VALUES ('20', '13', '16', '2', 'dsfdsfdsfdsf', '2013-12-22 12:18:47');
INSERT INTO `shop_message` VALUES ('21', '5', '16', '3', 'aadasdasd', '2013-12-22 12:20:12');
INSERT INTO `shop_message` VALUES ('22', '1', '16', '4', 'fdfsdfsdf', '2013-12-22 12:20:28');
INSERT INTO `shop_message` VALUES ('23', '7', '16', '3', 'ffffff', '2013-12-22 12:29:06');
INSERT INTO `shop_message` VALUES ('24', '7', '16', '4', 'fffff', '2013-12-22 12:29:09');
INSERT INTO `shop_message` VALUES ('25', '7', '16', '4', 'ffffffff', '2013-12-22 12:29:13');
INSERT INTO `shop_message` VALUES ('26', '7', '16', '4', 'ffffffff', '2013-12-22 12:29:14');
INSERT INTO `shop_message` VALUES ('27', '7', '16', '4', 'ffffffff', '2013-12-22 12:29:15');
INSERT INTO `shop_message` VALUES ('28', '9', '16', '4', 'fffffff', '2013-12-22 12:29:27');
INSERT INTO `shop_message` VALUES ('29', '9', '16', '4', 'fffffff', '2013-12-22 12:29:28');
INSERT INTO `shop_message` VALUES ('30', '9', '16', '4', 'fffffff', '2013-12-22 12:29:30');
INSERT INTO `shop_message` VALUES ('31', '6', '16', '5', 'fffffffff', '2013-12-22 12:29:49');
INSERT INTO `shop_message` VALUES ('32', '6', '16', '5', 'fffffffff', '2013-12-22 12:29:51');
INSERT INTO `shop_message` VALUES ('33', '9', '16', '4', 'fffff', '2013-12-22 12:30:03');
INSERT INTO `shop_message` VALUES ('34', '9', '16', '4', 'fffff', '2013-12-22 12:30:04');
INSERT INTO `shop_message` VALUES ('35', '14', '16', '4', 'ffffff', '2013-12-22 12:30:15');
INSERT INTO `shop_message` VALUES ('36', '14', '16', '3', 'ffffff', '2013-12-22 12:30:24');
INSERT INTO `shop_message` VALUES ('37', '14', '16', '1', 'ffffff', '2013-12-22 12:30:26');
INSERT INTO `shop_message` VALUES ('38', '14', '16', '5', 'ffffff', '2013-12-22 12:30:28');
INSERT INTO `shop_message` VALUES ('43', '13', '4', '3', 'fdsfsdfsdf', '2013-12-22 22:47:14');
INSERT INTO `shop_message` VALUES ('44', '13', '4', '3', 'fdsfsdfsd', '2013-12-22 22:49:02');
INSERT INTO `shop_message` VALUES ('56', '10', '4', '4', '我飞', '2013-12-22 23:14:39');
INSERT INTO `shop_message` VALUES ('57', '1', '18', '1', 'fuck', '2013-12-25 21:54:04');

-- ----------------------------
-- Table structure for shoplistinfo
-- ----------------------------
DROP TABLE IF EXISTS `shoplistinfo`;
CREATE TABLE `shoplistinfo` (
  `shop_id` int(15) NOT NULL auto_increment,
  `shop_name` varchar(50) NOT NULL,
  `shop_amount` int(10) NOT NULL,
  `shop_price` bigint(20) NOT NULL,
  `shop_msg` varchar(50) default NULL,
  `shop_category` int(10) default NULL,
  `shop_son_category` int(10) default NULL,
  PRIMARY KEY  (`shop_id`),
  KEY `shop_category` (`shop_category`),
  KEY `shop_son_category` (`shop_son_category`),
  CONSTRAINT `shoplistinfo_ibfk_3` FOREIGN KEY (`shop_category`) REFERENCES `category` (`category_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `shoplistinfo_ibfk_4` FOREIGN KEY (`shop_son_category`) REFERENCES `category_son` (`category_son_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shoplistinfo
-- ----------------------------
INSERT INTO `shoplistinfo` VALUES ('1', 'camera', '10', '15000', 'Imge/Shop_Imgae/canon.jpg', '1', '1');
INSERT INTO `shoplistinfo` VALUES ('4', 'iphone', '10', '111111', 'Imge/Shop_Imgae/iphone_4.jpg', '2', '1');
INSERT INTO `shoplistinfo` VALUES ('5', 'iphone2', '10', '111111', 'Imge/Shop_Imgae/iphone_5.jpg', '2', '1');
INSERT INTO `shoplistinfo` VALUES ('6', 'iphone3', '10', '1111111', 'Imge/Shop_Imgae/iphone_6.jpg', '2', '1');
INSERT INTO `shoplistinfo` VALUES ('7', 'samsung1', '10', '11554', 'Imge/Shop_Imgae/samsung_tab_6.jpg', '3', '2');
INSERT INTO `shoplistinfo` VALUES ('9', 'samsung3', '10', '11111', 'Imge/Shop_Imgae/samsung_tab_5.jpg', '3', '2');
INSERT INTO `shoplistinfo` VALUES ('10', 'sony', '10', '1113', 'Imge/Shop_Imgae/sony_vaio_1.jpg', '3', '1');
INSERT INTO `shoplistinfo` VALUES ('11', 'sony2', '10', '1112', 'Imge/Shop_Imgae/sony_vaio_2.jpg', '3', '1');
INSERT INTO `shoplistinfo` VALUES ('12', 'sony3', '10', '1111', 'Imge/Shop_Imgae/sony_vaio_3.jpg', '3', '1');
INSERT INTO `shoplistinfo` VALUES ('13', 'camera1', '10', '11111', 'Imge/Shop_Imgae/canon_1.jpg', '1', '1');
INSERT INTO `shoplistinfo` VALUES ('14', 'camera2', '11', '1111', 'Imge/Shop_Imgae/canon_2.jpg', '1', '1');

-- ----------------------------
-- Table structure for stu
-- ----------------------------
DROP TABLE IF EXISTS `stu`;
CREATE TABLE `stu` (
  `studentid` int(11) NOT NULL default '0',
  `sex` char(255) default NULL,
  `age` int(11) default NULL,
  `name` varchar(50) default NULL,
  UNIQUE KEY `studentid` (`studentid`),
  KEY `sex_2` (`sex`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stu
-- ----------------------------
INSERT INTO `stu` VALUES ('8001', 'm', '19', 's');
INSERT INTO `stu` VALUES ('8002', 'm', '20', 'xg');
INSERT INTO `stu` VALUES ('8003', 'f', '20', 'gfs');
INSERT INTO `stu` VALUES ('8004', 'f', '18', 'ff');
INSERT INTO `stu` VALUES ('8005', 'm', '21', 'fs');
INSERT INTO `stu` VALUES ('8006', 'f', '21', 'ttty');

-- ----------------------------
-- Table structure for student_tuition
-- ----------------------------
DROP TABLE IF EXISTS `student_tuition`;
CREATE TABLE `student_tuition` (
  `Studentid` int(50) NOT NULL default '0',
  `Sex` varchar(25) default NULL,
  `Age` int(11) default NULL,
  `Score` int(11) default NULL,
  `tuition` decimal(8,2) default NULL,
  `Cardid` varchar(50) default NULL,
  `credit` float(8,2) default NULL,
  PRIMARY KEY  (`Studentid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student_tuition
-- ----------------------------
INSERT INTO `student_tuition` VALUES ('8001', 'm', '19', '-92', '3.14', '110108198802135623', '-0.90');
INSERT INTO `student_tuition` VALUES ('8002', 'm', '20', '89', '6.38', '330523198511230235', '-20.90');
INSERT INTO `student_tuition` VALUES ('8003', 'f', '20', '-61', '2.90', '202052198605302012', '9.30');
INSERT INTO `student_tuition` VALUES ('8004', 'f', '18', '72', '0.43', '110145198706231235', '8.90');
INSERT INTO `student_tuition` VALUES ('8005', 'm', '21', '63', '2.03', '110132198504242352', '218.50');
INSERT INTO `student_tuition` VALUES ('8006', 'f', '21', '-83', '1.89', '110132198904282332', '5.72');

-- ----------------------------
-- Table structure for time_1
-- ----------------------------
DROP TABLE IF EXISTS `time_1`;
CREATE TABLE `time_1` (
  `y` varchar(50) default NULL,
  `f` float default NULL,
  `d` date default NULL,
  `ti_me` varchar(20) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of time_1
-- ----------------------------
INSERT INTO `time_1` VALUES ('2012', '3.1', '2014-03-03', '18：06：06');

-- ----------------------------
-- View structure for soft
-- ----------------------------
DROP VIEW IF EXISTS `soft`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `soft` AS select `employee`.`name` AS `name`,`employee`.`sex` AS `sex`,`employee`.`Salary` AS `salary` from `employee` where (`employee`.`dept_no` = (select `dept`.`d_no` AS `d_no` from `dept` where (`dept`.`d_name` = _utf8'软件工程系')));

-- ----------------------------
-- Procedure structure for all_stu
-- ----------------------------
DROP PROCEDURE IF EXISTS `all_stu`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `all_stu`()
begin
DECLARE num INT; 
      
	 while num<=5 Do
         set num = num + 1;
          insert into stu values (19,'m',18,'sss')  ;
          end while;
end;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for myProc
-- ----------------------------
DROP PROCEDURE IF EXISTS `myProc`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `myProc`()
BEGIN
        DECLARE i,j INT DEFAULT 1;
        outer_loop: LOOP
            SET j=1;
              inner_loop: LOOP
                   SELECT CONCAT(i," times ", j," is ",i*j);
                  SET j=j+1;
                  IF j>12 THEN
                        LEAVE inner_loop;
                   END IF;
              END LOOP inner_loop;
              SET i=i+1;
              IF i>12 THEN
                   LEAVE outer_loop;
              END IF;
         END LOOP outer_loop;
  END;;
DELIMITER ;

-- ----------------------------
-- Function structure for count_e
-- ----------------------------
DROP FUNCTION IF EXISTS `count_e`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `count_e`() RETURNS int(11)
begin
  DECLARE v_index INT;	
  select count(*) into v_index  from employee;
  return v_index;
end;;
DELIMITER ;
