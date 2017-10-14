SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
`id` bigint not null AUTO_INCREMENT,
`account` varchar(32) not null,
`passworld` varchar(64) not null,
`grade` tinyint  DEFAULT '0',
`jurisdiction` tinyint  DEFAULT '0',
PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`(
`id` bigint not null AUTO_INCREMENT,
`username` varchar(64) not null,
`passworld` varchar(64) not null,
`token` varchar(128) not null,
`role` tinyint ,
 `sex` varchar(32) ,
 `tel` varchar(64) ,
  `email` varchar(64),
 `state` tinyint,
`createTime` DATETIME not null,
`login` DATETIME ,
 `ip` varchar(64) not null,
 PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `t_addressManger`;
CREATE TABLE `t_addressManger`(
`id` bigint not null AUTO_INCREMENT,
`userID` bigint not null,
`receivePeople` varchar(64) not null,
`receiveTel` varchar(64) not null,
`province` varchar(32) not null,
`city` varchar(32) not null,
`county` varchar (32) not null,
`addressDetail` varchar(128) ,
`isDefault` tinyint ,
PRIMARY KEY (`id`),
KEY `addressid` (`userID`),
CONSTRAINT `addressid` FOREIGN KEY (`userID`) REFERENCES `t_user` (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `t_creditManger`;
CREATE TABLE `t_creditManger`(
 `id` bigint not null AUTO_INCREMENT,
 `userID` bigint not null,
 `creditSum` bigint ,
 `consumedCredit` bigint,
 `getCredit` bigint,
 PRIMARY KEY (`id`),
KEY `credit` (`userID`),
CONSTRAINT `credit` FOREIGN KEY (`userID`) REFERENCES `t_user` (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `t_creditDetail`;
CREATE TABLE `t_creditDetail`(
  `id` bigint not null AUTO_INCREMENT,
  `creditID` bigint not null,
  `userID` bigint not null,
  `addCredit` bigint,
  `consumCredit` bigint,
  PRIMARY KEY (`id`),
  KEY `creditdetailid` (`creditID`),
  KEY `cdetail` (`userID`),
  CONSTRAINT `creditdetailid` FOREIGN KEY (`creditID`) REFERENCES `t_creditManger`(`id`),
  CONSTRAINT `cdetail` FOREIGN KEY (`userID`) REFERENCES `t_user`(`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;



DROP TABLE IF EXISTS `t_collect`;
CREATE TABLE `t_collect`(
`id` bigint not null AUTO_INCREMENT,
`userID`  bigint not null,
`goodsID` bigint not null,
`createTime` DATETIME not null,
PRIMARY KEY (`id`),
KEY `collectid` (`userID`),
CONSTRAINT `collectid` FOREIGN KEY (`userID`) REFERENCES `t_user` (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `t_recommend`;
CREATE TABLE `t_recommend`(
`id` bigint not null AUTO_INCREMENT,
`userID` bigint not null,
`createTime` DATETIME not null,
`type` varchar(32) not null,
`isCheck` tinyint not null,
`recommendName` varchar(64) not null,
PRIMARY KEY (`id`),
KEY `recommendid` (`userID`),
CONSTRAINT `recommendid` FOREIGN KEY (`userID`) REFERENCES `t_user` (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `t_offLine`;
CREATE TABLE `t_offLine`(
`id` bigint not null AUTO_INCREMENT,
`userID` bigint not null,
`offlinrUserID` bigint not null,
`fatherUserID` bigint not null,
`isFather` tinyint not null,
`createTime` DATETIME not null,
 PRIMARY KEY (`id`),
 KEY `offlineid` (`userID`),
 CONSTRAINT `offlineid` FOREIGN KEY (`userID`) REFERENCES `t_user` (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `t_sign`;
CREATE TABLE `t_sign`(
`id` bigint not null AUTO_INCREMENT,
`userID` bigint not null,
`expersum` bigint ,
`monthSignCount` int,
`lastSiglns` datetime,
PRIMARY KEY (`id`),
KEY `signid` (`userID`),
CONSTRAINT `signid` FOREIGN KEY (`userID`) REFERENCES `t_user` (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `t_siglnDetail`;
CREATE TABLE `t_siglnDetail`(
	`id` bigint not null AUTO_INCREMENT,
	`signID` bigint not null,
	`userID` bigint not null,
	`expencePiont` int,
	`tradePoint` int,
	`dataCreate` datetime,
	PRIMARY KEY (`id`),
	KEY `sdetailid` (`userID`),
	KEY `sdetailsi` (`signID`),
	CONSTRAINT `sdetailid` FOREIGN KEY (`userID`) REFERENCES `t_user` (`id`),
	CONSTRAINT `sdetailsi` FOREIGN KEY (`signID`) REFERENCES `t_sign` (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `t_Advertsing`;
CREATE TABLE `t_Advertsing` (
	`id` bigint not null AUTO_INCREMENT,
	`name` varchar(32),
	`body` varchar(500),
	`linkUrl` varchar(32),
	`imageId` bigint,
	`stardate` datetime,
	`enddate` datetime,
	`dataCreate` datetime,
	PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE if EXISTS `t_AdvertsingPosing`;
CREATE TABLE `t_AdvertsingPosing`(
	`id` bigint not null AUTO_INCREMENT,
	`description` varchar(64),
	`imageId` bigint,
	`isEnable` ENUM('1','0') DEFAULT '1',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE if EXISTS `t_AdvertsinglnPosing`;
CREATE TABLE `t_AdvertsinglnPosing`(
	`advertsingID` bigint,
	`postingID` bigint
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
ALTER TABLE `t_AdvertsinglnPosing` ADD CONSTRAINT ap_pk PRIMARY KEY(`advertsingID`,`postingID`);
ALTER TABLE `t_AdvertsinglnPosing` ADD CONSTRAINT ap_pk1 FOREIGN KEY (`advertsingID`) REFERENCES `t_Advertsing`(`id`);
ALTER TABLE `t_AdvertsinglnPosing` ADD CONSTRAINT ap_pk2  FOREIGN KEY (`postingID`) REFERENCES `t_AdvertsingPosing`(`id`);
ALTER TABLE `t_AdvertsinglnPosing` DROP FOREIGN KEY ap_pk1;
ALTER TABLE `t_AdvertsinglnPosing` DROP FOREIGN KEY ap_pk2;

DROP TABLE IF EXISTS `t_article`;
CREATE TABLE `t_article`(
`id` bigint not null AUTO_INCREMENT,
`content` varchar(5000),
`title` varchar(64),
`looksum` bigint,
 PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `t_articleculture`;
CREATE TABLE `t_articleculture`(
`id` bigint not null AUTO_INCREMENT,
`title` varchar(64) not null,
`content` varchar(5000),
`looksum` bigint,
PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `t_store`;
CREATE TABLE `t_store`(
`id` bigint not null AUTO_INCREMENT,
`createTime` datetime,
`storeName` varchar(64) not null,
`storeAddress` varchar(64),
`storeType` varchar(32) not null,
`storer` varchar(32) not null,
`stroelogo` varchar(64),
`scope` varchar(64),
`tel` varchar(64),
`isAuth` tinyint DEFAULT '0',
`storeUserID` bigint not null,
`passworld` varchar(64) not null,
`introduce` varchar(128),
PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order`(
`id` bigint not null AUTO_INCREMENT,
`userID` bigint not null,
`orderCode` bigint not null,
`goodsName` varchar(64) not null,
`goodsID` bigint not null,
`marketPricce` bigint,
`memberPrice` bigint,
`goodSum` int(10) DEFAULT '0',
`priceSum` int(11),
`sendTime` DATETIME,
`logistics` varchar(32),
`payTime` DATETIME,
`isreceive` tinyint DEFAULT '0',
`isPay` tinyint DEFAULT '0',
PRIMARY KEY (`id`),
KEY `orderid` (`userID`),
CONSTRAINT `orderid` FOREIGN KEY (`userID`) REFERENCES `t_user`(`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `t_logistics`;
CREATE TABLE `t_logistics`(
`id` bigint not null AUTO_INCREMENT,
`orderId` bigint not null,
`userID` bigint not null,
`logisticsName` varchar(32) not null,
`logisticsState` varchar(64) ,
PRIMARY KEY(`id`),
KEY `logisticsid` (`orderId`),
KEY `luserid` (`userID`),
CONSTRAINT `logisticsid`FOREIGN KEY (`orderId`) REFERENCES `t_order` (`id`),
CONSTRAINT `luserid` FOREIGN KEY (`userID`) REFERENCES `t_user`(`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `t_orderDetail`;
CREATE TABLE `t_orderDetail`(
`id` bigint not null AUTO_INCREMENT,
`orderId` bigint not null,
`orderState` varchar(32),
 PRIMARY KEY (`id`),
 KEY `orderdetailid` (`orderId`),
 CONSTRAINT `orderdetailid` FOREIGN KEY (`orderId`) REFERENCES `t_order` (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `t_goodsBand`;
CREATE TABLE `t_goodsBand`(
`id` bigint not null AUTO_INCREMENT,
`bandName` varchar(32) not null,
`description` varchar(128),
PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `t_goodsType`;
CREATE TABLE `t_goodsType`(
`id` bigint not null,
`TypeName` varchar(32),
`fatherTypeID` bigint,
`isFather` tinyint DEFAULT '0',
PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `t_goodsAttribute`;
CREATE TABLE `t_goodsAttribute`(
`id`bigint not null AUTO_INCREMENT,
`attributeName` varchar(32),
`TypeID` bigint not null,
`isKey` tinyint DEFAULT '0',
PRIMARY KEY (`id`),
KEY `attributeid` (`TypeID`),
CONSTRAINT `attributeid` FOREIGN KEY (`TypeID`) REFERENCES `t_goodsType` (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `t_goods`;
CREATE TABLE `t_goods`(
`id` bigint not null AUTO_INCREMENT,
`goodsName` varchar(128),
`goodsBandID` bigint not null,
`TypeID` bigint not null,
`goodsSum` bigint,
`marketPrive` bigint,
`memberPrice` bigint,
`sendCredit` int,
`storeID` bigint not null,
`shop` varchar(32) not null,
`soldamount` bigint ,
`createTime` DATETIME,
PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `t_goodsImage`;
CREATE TABLE `t_goodsImage`(
`id` bigint not null AUTO_INCREMENT,
`goodsID` bigint not null,
`IamgeAddress` varchar(128),
`isKeyIamge` tinyint DEFAULT '0',
`createTime` datetime,
PRIMARY KEY (`id`),
KEY `imageid` (`goodsID`),
CONSTRAINT `imageid` FOREIGN KEY (`goodsID`) REFERENCES `t_goods` (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `t_evaluate`;
CREATE TABLE `t_evaluate`(
`id` bigint not null AUTO_INCREMENT,
`goodsID` bigint not null,
`userID` bigint not null,
`content` varchar(64),
PRIMARY KEY (`id`),
KEY `evgoods` (`goodsID`),
KEY `evuserid` (`userID`),
CONSTRAINT `evgoods` FOREIGN KEY (`goodsID`) REFERENCES `t_goods`(`id`),
CONSTRAINT `userID` FOREIGN KEY (`userID`) REFERENCES `t_user` (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `t_shoppingcart`;
CREATE TABLE `t_shoppingcart`(
`id` bigint not null AUTO_INCREMENT,
`goodsID` bigint not null,
`storeID` bigint not null,
`userID` bigint not null,
`storeName` varchar(64),
`goodsName` varchar(64),
`memberPrice`bigint,
`number`bigint,
 PRIMARY KEY (`id`),
 KEY `cartid`(`goodsID`),
 KEY `shopcartid` (`userID`),
 CONSTRAINT `cartid` FOREIGN KEY (`goodsID`) REFERENCES `t_goods`(`id`),
 CONSTRAINT `shopcartid` FOREIGN KEY (`userID`) REFERENCES `t_user`(`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;








