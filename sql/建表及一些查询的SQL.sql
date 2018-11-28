USE test;
CREATE TABLE userinfo (
  id INT(20)  PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(20) DEFAULT NULL,
  PASSWORD VARCHAR(20) DEFAULT NULL
) ENGINE=INNODB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8


DESC person
SELECT * FROM person LIMIT 0,2;
UPDATE person SET pname='王五五',sex='1' WHERE pid=16;


SELECT * FROM person WHERE pid IN (1,2,3)
ALTER TABLE person ADD school VARCHAR(4)
ALTER TABLE person ADD 毕业年份 VARCHAR(4)

ALTER TABLE person ADD YEAR INT(4)
UPDATE person SET YEAR =2014 WHERE pid IN(1,2,3,4,54)


UPDATE person SET 毕业年份=2018
UPDATE person SET school ='广东大学' WHERE pid IN (3,34,5,56,78,8,9)
COMMIT


USE test

-- 建热身题表
CREATE TABLE joblabx_data(
	id INT(11) PRIMARY KEY AUTO_INCREMENT,
	sex CHAR(1),
	school VARCHAR(20),
	department VARCHAR(30),
	YEAR INT(4),
	j_value VARCHAR(8)
)ENGINE=INNODB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='学校学年J值表'

ALTER TABLE joblabx_data  ADD department VARCHAR(30);
ALTER TABLE joblabx_data_temp  ADD department VARCHAR(30) COMMENT '学院名';

-- 模拟数据
INSERT INTO joblabx_data(sex,school,YEAR,j_value) 
VALUES('M','河男大学',2017,233),
('F','河北大sd学',2013,236),
('M','河北sd大学',2014,234),
('M','河北大sd学',2017,234)

SELECT * FROM joblabx_data; 
-- 截断表
TRUNCATE TABLE joblabx_data;
-- 删除表
DROP TABLE joblabx_data;

-- 按照学校统计
SELECT COUNT(*) num,school FROM joblabx_data GROUP BY school; 

-- 按照入学年份统计
SELECT COUNT(*) num,YEAR FROM joblabx_data GROUP BY YEAR;
-- 更改表字段
ALTER TABLE joblabx_data MODIFY j_value VARCHAR(8)

SELECT * FROM joblabx_data WHERE j_value>255
-- 截断表
TRUNCATE TABLE joblabx_data;
TRUNCATE TABLE joblabx_data_temp;

USE test;

SELECT * FROM joblabx_data_temp;

-- 创建热身题表2，临时表用于存储上一个excel表的数据
CREATE TABLE joblabx_data_temp(
	id INT(11) PRIMARY KEY AUTO_INCREMENT COMMENT '主键id',
	sex CHAR(1) COMMENT '性别',
	school VARCHAR(20) COMMENT '学校',
	YEAR INT(4) COMMENT '入学年份',
	j_value VARCHAR(8) COMMENT 'J值',
	-- 由于不能同时创建两个default timestamp默认值所以将创建时间的默认值修改为'0000-00-00 00:00:00'
	ctime TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
	mtime TIMESTAMP NOT NULL DEFAULT NOW() COMMENT '修改时间',
	dr INT(1) NOT NULL DEFAULT 0 COMMENT '是否有效,标记删除'
)ENGINE=INNODB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='学校学年J值临时表';

-- 测试时间的表
CREATE TABLE test_datatime(
 id INT(11) PRIMARY KEY AUTO_INCREMENT COMMENT '主键id',
 ctime TIMESTAMP NOT NULL DEFAULT NOW() COMMENT '创建时间',
 mtime TIMESTAMP NOT NULL DEFAULT DATE_FORMAT(NOW(),'%y-%m-%d %H:%i:%s') COMMENT '修改时间',
 dr TINYINT(1) NOT NULL DEFAULT 0 COMMENT '是否删除'
)ENGINE=INNODB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='测试时间的表'
SELECT * FROM test_datatime;
INSERT INTO test_datatime VALUES(1,'2018-11-14 11:33:00',NOW(),0);
INSERT INTO test_datatime(id,mtime) VALUES(2,NOW());
DROP TABLE test_datatime;


-- 将查询男女数量，并将行列转置
USE test;
-- 查询男女数量
SELECT sex,COUNT(*) num FROM joblabx_data WHERE sex = 'M'GROUP BY sex;
-- 
SELECT SUM(IF(sex = 'M',num,0)) AS '男' ,SUM(IF(sex = 'F',num,0)) AS '女' FROM(
 SELECT sex,COUNT(*) num FROM joblabx_data GROUP BY sex
) group_table

SELECT SUM(IF(sex = 'M',num,0)) AS '男' ,SUM(IF(sex = 'F',num,0)) AS '女' FROM(SELECT sex,COUNT(*) num FROM joblabx_data GROUP BY sex) group_table LIMIT 0,1


-- 临时表
SELECT * FROM joblabx_data_temp;
ALTER TABLE joblabx_data_temp ADD excel_id INT(11) ;



-- 获取数量前5的学校
SELECT school,COUNT(*) num FROM joblabx_data GROUP BY school ORDER BY num DESC LIMIT 0,5

SELECT * FROM joblabx_data  ORDER BY YEAR DESC LIMIT 0,200;


SELECT SUM(IF(sex = 'M',num,0)) AS '男' ,SUM(IF(sex = 'F',num,0)) AS '女' FROM(SELECT sex,COUNT(*) num FROM joblabx_data GROUP BY sex) group_table
USE test;
-- 创建学校表
CREATE TABLE school_data(
	id INT(11) PRIMARY KEY AUTO_INCREMENT COMMENT '主键id',
	nid INT(11) NOT NULL COMMENT 'excel表序号',
	province VARCHAR(10) COMMENT '省份',
	school VARCHAR(20) COMMENT '学校',
	school_code CHAR(10) COMMENT '代码',
	blong_to VARCHAR(20) COMMENT '所属',
	city VARCHAR(20) COMMENT '城市',
	education CHAR(2) COMMENT '学历'
)ENGINE=INNODB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='学校情况表';

DROP TABLE school_data

TRUNCATE TABLE school_data;

SELECT * FROM school_data;
DESC school_data;

ALTER TABLE school_data MODIFY school_code CHAR(10);


SELECT * FROM joblabx_data;

DELETE  FROM joblabx_data WHERE id IN (1,2,3,4,5,6);

-- 查询出各个省份的数量
SELECT province,COUNT(*) num FROM(
SELECT jd.*,sd.province FROM joblabx_data jd 
LEFT JOIN  school_data sd ON jd.school=sd.school
) jd_sd
GROUP BY jd_sd.province;


