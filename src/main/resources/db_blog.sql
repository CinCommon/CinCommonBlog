/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.7.14 : Database - db_blog
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_blog` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `db_blog`;

/*Table structure for table `t_bloginfo` */

DROP TABLE IF EXISTS `t_bloginfo`;

CREATE TABLE `t_bloginfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) DEFAULT NULL,
  `summary` varchar(400) DEFAULT NULL,
  `releaseDate` datetime DEFAULT NULL,
  `clickCount` int(11) DEFAULT NULL,
  `replyCount` int(11) DEFAULT NULL,
  `content` text,
  `typeId` int(11) DEFAULT NULL,
  `keyword` varchar(200) DEFAULT NULL,
  `authorId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_t_bloginfo` (`typeId`),
  CONSTRAINT `FK_t_bloginfo` FOREIGN KEY (`typeId`) REFERENCES `t_blogtype` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8;

/*Data for the table `t_bloginfo` */

insert  into `t_bloginfo`(`id`,`title`,`summary`,`releaseDate`,`clickCount`,`replyCount`,`content`,`typeId`,`keyword`,`authorId`) values (57,'第一篇博客','我疯啦啊啊啊我疯啦啊啊我疯啦啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊我疯啦啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊','2017-07-28 15:07:24',17,0,'<p>我疯啦啊啊啊我疯啦啊啊我疯啦啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊我疯啦啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊我疯啦啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊我疯啦啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊<img src=\"/static/userImages/20180128/1517123149286092663.jpg\" title=\"1517123149286092663.jpg\" alt=\"RanbowSixLogo1.jpg\"/>啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊我疯啦啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊我疯啦啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊我疯啦啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊我疯啦啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊我疯啦啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊我疯啦啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊我疯啦啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊我疯啦</p>',4,'',1),(58,'再来一篇','Java大法好Java大法好Java大法好Java大法好Java大法好Java大法好Java大法好Java大法好Java大法好Java大法好Java大法好Java大法好Java大法好Java大法好Java大法好Java大法好Java大法好真是好真是好真是好真是好真是好真是好真是好就是好好的一比public s','2018-01-28 18:02:45',1,0,'<p style=\"white-space: normal;\">Java大法好Java大法好Java大法好Java大法好Java大法好Java大法好Java大法好Java大法好Java大法好Java大法好Java大法好Java大法好Java大法好Java大法好Java大法好Java大法好Java大法好</p><p style=\"white-space: normal;\">真是好真是好真是好真是好真是好真是好真是好</p><p style=\"white-space: normal;\">就是好</p><p style=\"white-space: normal;\">好的一比</p><pre class=\"brush:java;toolbar:false\">public&nbsp;static&nbsp;void&nbsp;main(String&nbsp;[]&nbsp;args)&nbsp;{\n&nbsp;&nbsp;&nbsp;&nbsp;System.out.println(&quot;哇哇哇,&nbsp;马晨功是傻逼&quot;);\n}</pre><p style=\"white-space: normal;\"><br/></p><p><br/></p>',1,'',NULL);

/*Table structure for table `t_blogtype` */

DROP TABLE IF EXISTS `t_blogtype`;

CREATE TABLE `t_blogtype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `typeName` varchar(30) DEFAULT NULL,
  `typeOrder` int(3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `t_blogtype` */

insert  into `t_blogtype`(`id`,`typeName`,`typeOrder`) values (1,'Java',1),(2,'Mysql',5),(3,'React',3),(4,'IT之路',6),(5,'随心生活',7),(7,'shiro',4),(9,'webservice',5),(10,'jsoup',4);

/*Table structure for table `t_comments` */

DROP TABLE IF EXISTS `t_comments`;

CREATE TABLE `t_comments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_comments` */

/*Table structure for table `t_link` */

DROP TABLE IF EXISTS `t_link`;

CREATE TABLE `t_link` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `linkName` varchar(100) DEFAULT NULL,
  `linkUrl` varchar(200) DEFAULT NULL,
  `linkOrder` int(3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `t_link` */

insert  into `t_link`(`id`,`linkName`,`linkUrl`,`linkOrder`) values (1,'谷歌','http://www.google.com.tw',1),(2,'小图标素材网','http://www.easyicon.net/',5),(3,'正则表达式测试','https://www.debuggex.com/',3);

/*Table structure for table `t_userinfo` */

DROP TABLE IF EXISTS `t_userinfo`;

CREATE TABLE `t_userinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(50) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `profile` varchar(100) DEFAULT NULL,
  `imageURL` varchar(100) DEFAULT NULL,
  `shortName` varchar(50) DEFAULT NULL,
  `whatsup` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `t_userinfo` */

insert  into `t_userinfo`(`id`,`userName`,`password`,`profile`,`imageURL`,`shortName`,`whatsup`) values (1,'CinCommon','08c139e602673f1bb4ac17a13dfc39f1',NULL,NULL,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
