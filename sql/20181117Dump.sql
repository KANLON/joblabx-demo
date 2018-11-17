/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.1.33-community : Database - test
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`test` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `test`;

/*Table structure for table `joblabx_data` */

DROP TABLE IF EXISTS `joblabx_data`;

CREATE TABLE `joblabx_data` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sex` char(1) DEFAULT NULL,
  `school` varchar(20) DEFAULT NULL,
  `year` int(4) DEFAULT NULL,
  `j_value` varchar(8) DEFAULT NULL,
  `department` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=185 DEFAULT CHARSET=utf8;

/*Data for the table `joblabx_data` */

insert  into `joblabx_data`(`id`,`sex`,`school`,`year`,`j_value`,`department`) values (1,'F','昆明理工大学',2018,'8','管理与经济学院'),(2,'M','河北科技大学',2018,'26','理学院'),(3,'F','赤峰学院',2018,'46','建筑与机械工程学院'),(4,'M','六盘水师范学院',2018,'4','数学与信息工程学院'),(5,'M','昆明理工大学',2018,'2','电力工程学院'),(6,'M','四川信息职业技术学院',2016,'995','信息工程系'),(7,'M','石家庄铁道大学',2018,'4','2018新生学院'),(8,'M','西南医科大学',2018,'18','2018级临床办'),(9,'M','广西民族大学',2015,'549','管理学院'),(10,'F','南京邮电大学',2018,'4','2018新生学院'),(11,'M','西南医科大学',2018,'0','医学影像系'),(12,'F','陕西科技大学',2018,'58','文理学院'),(13,'M','南京邮电大学',2018,'20','2018新生学院'),(14,'M','河北工程大学',2017,'2','水利水电学院'),(15,'M','六盘水师范学院',2018,'4','建筑艺术学院'),(16,'M','湖南工业大学',2018,'2','交通工程学院'),(17,'M','黑龙江大学',2018,'20','中俄学院'),(18,'M','西华大学',2018,'30','计算机与软件工程学院'),(19,'M','东北石油大学',2018,'2','外国语学院'),(20,'F','聊城大学',2018,'24','生命科学学院'),(21,'F','内蒙古财经大学',2018,'18','职业学院'),(22,'F','安徽师范大学',2018,'30','环境科学与工程学院'),(23,'M','西华大学',2018,'18','电气与电子信息学院'),(24,'F','南京邮电大学',2018,'18','2018新生学院'),(25,'M','西华大学',2018,'58',NULL),(26,'F','广西师范大学',2017,'364','生命科学学院'),(27,'F','曲靖师范学院',2017,'1376','信息工程学院'),(28,'F','广西师范大学',2016,'1298','教育学部'),(29,'M','毕节医学高等专科学校',2017,'512','临床医学系'),(30,'M','上海教育',2017,'553',NULL),(31,'M','西南石油大学',2017,'2100','材料科学与工程学院'),(32,'F','广西师范大学',2017,'380','设计学院'),(33,'M','玉溪师范学院',2017,'565','教师教育学院'),(34,'M','贵州理工学院',2016,'451','矿业工程学院'),(35,'M','广西师范大学',2016,'655','计算机科学与信息工程学院'),(36,'M','石河子大学',2017,'276','水利建筑工程学院'),(37,'F','武夷学院',2016,'4269','人文与教师教育学院'),(38,'F','曲靖师范学院',2017,'1066','化学与环境科学学院'),(39,'F','易班大学',2018,'911',NULL),(40,'M','桂林理工大学',2017,'210','材料科学与工程学院'),(41,'M','广西师范大学',2017,'1299','职业技术师范学院'),(42,'F','广东第二师范学院',2017,'6142','数学系'),(43,'M','河北大学',2017,'355','经济学院'),(44,'M','广西农业职业技术学院',2017,'252','机电工程系'),(45,'F','桂林理工大学',2016,'706','理学院'),(46,'M','广西师范大学',2016,'1523','职业技术师范学院'),(47,'M','四川化工职业技术学院',2017,'1066','信息工程系'),(48,'F','广西师范大学',2017,'916','职业技术师范学院'),(49,'F','昆明学院',2014,'3106','社会管理学院'),(50,'M','贵州大学',2017,'111','阳明学院'),(51,'F','广西师范大学',2015,'499','国际文化教育学院'),(52,'M','贵州理工学院',2017,'575','经济管理学院'),(53,'F','广西师范大学',2017,'914','法学院／政治与公共管理学院'),(54,'F','绵阳师范学院',2016,'4180','文学与历史学院'),(55,'F','广西师范大学',2016,'436','职业技术师范学院'),(56,'M','贵州工程应用技术学院',2016,'7985','机械工程学院'),(57,'M','北海职业学院',2017,'197','机电工程系'),(58,'F','绵阳师范学院',2017,'2537','传媒学院'),(59,'M','广西师范大学',2016,'5648','职业技术师范学院'),(60,'M','绵阳师范学院',2016,'232','马克思主义学院'),(61,'M','佛山科学技术学院',2017,'4995','电子信息工程学院'),(62,'M','陕西科技大学',2017,'5811','机电工程学院'),(63,'M','成都农业科技职业学院',2016,'2868','现代农业分院'),(64,'M','广西师范大学',2016,'2214','设计学院'),(65,'M','广西师范大学',2008,'5058','外国语学院'),(66,'M','广西农业职业技术学院',2017,'400','生物技术系'),(67,'M','贵州理工学院',2015,'291','食品药品制造工程学院'),(68,'M','石河子大学',2017,'415','理学院'),(69,'M','铜仁学院',2017,'2067','农林工程与规划学院'),(70,'M','石河子大学',2017,'128','水利建筑工程学院'),(71,'M','陕西科技大学',2017,'1789','化学与化工学院'),(72,'M','石河子大学',2016,'488','经济与管理学院'),(73,'F','桂林理工大学',2016,'421','理学院'),(74,'F','广东石油化工学院',2017,'1757','理学院'),(75,'M','广西科技大学',2016,'1523','体育学院'),(76,'F','德宏职业学院',2017,'330','临床系'),(77,'M','广东科学技术职业学院',2016,'224','计算机工程技术学院'),(78,'F','陕西科技大学',2017,'2761','食品与生物工程学院'),(79,'M','沈阳建筑大学',2017,'532','土木工程学院'),(80,'M','广西师范大学',2017,'2337','体育学院'),(81,'M','昆明理工大学',2017,'1245','材料科学与工程学院'),(82,'F','昆明学院',2014,'1493','社会管理学院'),(83,'M','上海海洋大学',2009,'20779','宣传部'),(84,'M','东华大学',2000,'6036','纺织学院'),(85,'M','贵州工程应用技术学院',2016,'2309','机械工程学院'),(86,'F','广西师范大学',2016,'3047','体育学院'),(87,'M','广西民族大学',2017,'493','理学院'),(88,'M','榆林学院',2016,'1118','化学与化工学院'),(89,'F','广西师范大学',2017,'319','职业技术师范学院'),(90,'M','广西经贸职业技术学院',2016,'7490','贸易与管理系'),(91,'M','上海海事大学',2014,'248',NULL),(92,'F','广西民族大学',2016,'459','商学院'),(93,'F','昆明理工大学',2018,'8','管理与经济学院'),(94,'M','河北科技大学',2018,'26','理学院'),(95,'F','赤峰学院',2018,'46','建筑与机械工程学院'),(96,'M','六盘水师范学院',2018,'4','数学与信息工程学院'),(97,'M','昆明理工大学',2018,'2','电力工程学院'),(98,'M','四川信息职业技术学院',2016,'995','信息工程系'),(99,'M','石家庄铁道大学',2018,'4','2018新生学院'),(100,'M','西南医科大学',2018,'18','2018级临床办'),(101,'M','广西民族大学',2015,'549','管理学院'),(102,'F','南京邮电大学',2018,'4','2018新生学院'),(103,'M','西南医科大学',2018,'0','医学影像系'),(104,'F','陕西科技大学',2018,'58','文理学院'),(105,'M','南京邮电大学',2018,'20','2018新生学院'),(106,'M','河北工程大学',2017,'2','水利水电学院'),(107,'M','六盘水师范学院',2018,'4','建筑艺术学院'),(108,'M','湖南工业大学',2018,'2','交通工程学院'),(109,'M','黑龙江大学',2018,'20','中俄学院'),(110,'M','西华大学',2018,'30','计算机与软件工程学院'),(111,'M','东北石油大学',2018,'2','外国语学院'),(112,'F','聊城大学',2018,'24','生命科学学院'),(113,'F','内蒙古财经大学',2018,'18','职业学院'),(114,'F','安徽师范大学',2018,'30','环境科学与工程学院'),(115,'M','西华大学',2018,'18','电气与电子信息学院'),(116,'F','南京邮电大学',2018,'18','2018新生学院'),(117,'M','西华大学',2018,'58',NULL),(118,'F','广西师范大学',2017,'364','生命科学学院'),(119,'F','曲靖师范学院',2017,'1376','信息工程学院'),(120,'F','广西师范大学',2016,'1298','教育学部'),(121,'M','毕节医学高等专科学校',2017,'512','临床医学系'),(122,'M','上海教育',2017,'553',NULL),(123,'M','西南石油大学',2017,'2100','材料科学与工程学院'),(124,'F','广西师范大学',2017,'380','设计学院'),(125,'M','玉溪师范学院',2017,'565','教师教育学院'),(126,'M','贵州理工学院',2016,'451','矿业工程学院'),(127,'M','广西师范大学',2016,'655','计算机科学与信息工程学院'),(128,'M','石河子大学',2017,'276','水利建筑工程学院'),(129,'F','武夷学院',2016,'4269','人文与教师教育学院'),(130,'F','曲靖师范学院',2017,'1066','化学与环境科学学院'),(131,'F','易班大学',2018,'911',NULL),(132,'M','桂林理工大学',2017,'210','材料科学与工程学院'),(133,'M','广西师范大学',2017,'1299','职业技术师范学院'),(134,'F','广东第二师范学院',2017,'6142','数学系'),(135,'M','河北大学',2017,'355','经济学院'),(136,'M','广西农业职业技术学院',2017,'252','机电工程系'),(137,'F','桂林理工大学',2016,'706','理学院'),(138,'M','广西师范大学',2016,'1523','职业技术师范学院'),(139,'M','四川化工职业技术学院',2017,'1066','信息工程系'),(140,'F','广西师范大学',2017,'916','职业技术师范学院'),(141,'F','昆明学院',2014,'3106','社会管理学院'),(142,'M','贵州大学',2017,'111','阳明学院'),(143,'F','广西师范大学',2015,'499','国际文化教育学院'),(144,'M','贵州理工学院',2017,'575','经济管理学院'),(145,'F','广西师范大学',2017,'914','法学院／政治与公共管理学院'),(146,'F','绵阳师范学院',2016,'4180','文学与历史学院'),(147,'F','广西师范大学',2016,'436','职业技术师范学院'),(148,'M','贵州工程应用技术学院',2016,'7985','机械工程学院'),(149,'M','北海职业学院',2017,'197','机电工程系'),(150,'F','绵阳师范学院',2017,'2537','传媒学院'),(151,'M','广西师范大学',2016,'5648','职业技术师范学院'),(152,'M','绵阳师范学院',2016,'232','马克思主义学院'),(153,'M','佛山科学技术学院',2017,'4995','电子信息工程学院'),(154,'M','陕西科技大学',2017,'5811','机电工程学院'),(155,'M','成都农业科技职业学院',2016,'2868','现代农业分院'),(156,'M','广西师范大学',2016,'2214','设计学院'),(157,'M','广西师范大学',2008,'5058','外国语学院'),(158,'M','广西农业职业技术学院',2017,'400','生物技术系'),(159,'M','贵州理工学院',2015,'291','食品药品制造工程学院'),(160,'M','石河子大学',2017,'415','理学院'),(161,'M','铜仁学院',2017,'2067','农林工程与规划学院'),(162,'M','石河子大学',2017,'128','水利建筑工程学院'),(163,'M','陕西科技大学',2017,'1789','化学与化工学院'),(164,'M','石河子大学',2016,'488','经济与管理学院'),(165,'F','桂林理工大学',2016,'421','理学院'),(166,'F','广东石油化工学院',2017,'1757','理学院'),(167,'M','广西科技大学',2016,'1523','体育学院'),(168,'F','德宏职业学院',2017,'330','临床系'),(169,'M','广东科学技术职业学院',2016,'224','计算机工程技术学院'),(170,'F','陕西科技大学',2017,'2761','食品与生物工程学院'),(171,'M','沈阳建筑大学',2017,'532','土木工程学院'),(172,'M','广西师范大学',2017,'2337','体育学院'),(173,'M','昆明理工大学',2017,'1245','材料科学与工程学院'),(174,'F','昆明学院',2014,'1493','社会管理学院'),(175,'M','上海海洋大学',2009,'20779','宣传部'),(176,'M','东华大学',2000,'6036','纺织学院'),(177,'M','贵州工程应用技术学院',2016,'2309','机械工程学院'),(178,'F','广西师范大学',2016,'3047','体育学院'),(179,'M','广西民族大学',2017,'493','理学院'),(180,'M','榆林学院',2016,'1118','化学与化工学院'),(181,'F','广西师范大学',2017,'319','职业技术师范学院'),(182,'M','广西经贸职业技术学院',2016,'7490','贸易与管理系'),(183,'M','上海海事大学',2014,'248',NULL),(184,'F','广西民族大学',2016,'459','商学院');

/*Table structure for table `joblabx_data_temp` */

DROP TABLE IF EXISTS `joblabx_data_temp`;

CREATE TABLE `joblabx_data_temp` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `sex` char(1) DEFAULT NULL COMMENT '性别',
  `school` varchar(20) DEFAULT NULL COMMENT '学校',
  `YEAR` int(4) DEFAULT NULL COMMENT '入学年份',
  `j_value` varchar(8) DEFAULT NULL COMMENT 'J值',
  `ctime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `mtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `dr` int(1) NOT NULL DEFAULT '0' COMMENT '是否有效,标记删除',
  `excel_id` int(11) DEFAULT NULL,
  `department` varchar(30) DEFAULT NULL COMMENT '学院名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学校学年J值临时表';

/*Data for the table `joblabx_data_temp` */

/* Procedure structure for procedure `pro_test2` */

/*!50003 DROP PROCEDURE IF EXISTS  `pro_test2` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `pro_test2`()
begin
	declare i int default 1;
	while i<=10 do
		insert into xxx_emp(empno,ename) value(i,concat('name',i));
		set i=i+1;
end while;
commit;
end */$$
DELIMITER ;

/* Procedure structure for procedure `pro_test3` */

/*!50003 DROP PROCEDURE IF EXISTS  `pro_test3` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `pro_test3`()
begin
	declare i int default 1;
	while (i<=10) do
		insert into xxx_emp(empno,ename) value(i,concat('name',i));
		set i=i+1;
end while;
commit;
end */$$
DELIMITER ;

/* Procedure structure for procedure `test_insert` */

/*!50003 DROP PROCEDURE IF EXISTS  `test_insert` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `test_insert`()
BEGIN 
DECLARE i INT DEFAULT 1;
WHILE i<=100000 
DO 
INSERT INTO xxx_emp(empno,ename) VALUE(i,CONCAT('name',i)); 
SET i=i+1; 
END WHILE ; 
commit; 
END */$$
DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;