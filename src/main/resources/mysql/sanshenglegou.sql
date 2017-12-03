SET FOREIGN_KEY_CHECKS=0;
-- 管理员表
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `id` bigint not null AUTO_INCREMENT,
  `account` varchar(32) not null comment'账户名',
  `passworld` varchar(64) not null comment'密码',
  `grade` tinyint  DEFAULT '0'comment'管理员等级',
  `jurisdiction` varchar(128)  DEFAULT '0' comment'描述',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
INSERT INTO `t_admin` (`id`,`account`,`passworld`,`grade`,`jurisdiction`)
VALUES(1,'admin','admin',1,'');

-- 轮播图表
DROP TABLE IF EXISTS `t_banner`;
CREATE TABLE `t_banner` (
  `id` bigint not null AUTO_INCREMENT,
  `imageurl` varchar(62) not null comment'图片地址',
  `isstart`  tinyint DEFAULT '1',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- 用户表
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`(
  `id` bigint not null AUTO_INCREMENT,
  `username` varchar(64) not null comment'昵称',
  `OpenID` varchar(64) not null comment'用户的openid',
  `token` varchar(128) not null comment'token值',
  `role` tinyint DEFAULT '0' comment'是否会员',
  `city` varchar(64) comment'城市',
  `province` varchar(64) comment'省',
  `country` varchar(64) comment'国家',
  `sex` varchar(32) comment'性别',
  `tel` varchar(64) comment'电话',
  `email` varchar(64) comment'邮箱',
  `headimage` varchar(128) comment'头像图片',
  `state` tinyint DEFAULT '1' comment'是否启用用户 1为启用',
  `createTime` DATETIME comment'创建时间',
  `login` DATETIME comment'登入时间' ,
  `ip` varchar(64) comment'最近一次的登入的ip地址' ,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- 用户地址管理表
DROP TABLE IF EXISTS `t_addressManger`;
CREATE TABLE `t_addressManger`(
  `id` bigint not null AUTO_INCREMENT,
  `userID` bigint not null comment'用户id',
  `receivePeople` varchar(64) not null comment'收货人',
  `receiveTel` varchar(64) not null comment'收货人电话',
  `province` varchar(32) not null comment'省',
  `city` varchar(32) not null comment'市',
  `county` varchar (32) not null comment'县',
  `addressDetail` varchar(128) comment'详细地址' ,
  `isDefault` tinyint comment'是否为默认地址',
  PRIMARY KEY (`id`),
  KEY `addressid` (`userID`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- 积分管理表
DROP TABLE IF EXISTS `t_creditManger`;
CREATE TABLE `t_creditManger`(
  `id` bigint not null AUTO_INCREMENT,
  `userID` bigint not null comment'用户的id',
  `creditSum` bigint comment'积分总和',
  `consumedCredit` bigint comment'消费积分',
  `getCredit` bigint comment'获得积分',
  PRIMARY KEY (`id`),
  KEY `credit` (`userID`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- 用户积分表细节
DROP TABLE IF EXISTS `t_creditDetail`;
CREATE TABLE `t_creditDetail`(
  `id` bigint not null AUTO_INCREMENT,
  `creditID` bigint not null comment'积分id',
  `userID` bigint not null comment'用户id',
  `addCredit` bigint comment'增加的积分',
  `consumCredit` bigint comment'消费积分',
  `status` tinyint,
  `changTime` DATETIME,
  PRIMARY KEY (`id`),
  KEY `creditdetailid` (`creditID`),
  KEY `cdetail` (`userID`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
-- 优惠券表
DROP TABLE IF EXISTS `t_coupan`;
CREATE TABLE `t_coupan`(
  `id` bigint not null AUTO_INCREMENT,
  `available` varchar(64),
  `discount` varchar(64),
  `denominations`varchar(64),
  `origin_condition`varchar(64),
  `reason` varchar(64),
  `value` varchar(64),
  `condition` varchar(64),
  `name` varchar(64),
  `start_at` varchar(64),
  `end_at` varchar(64),
  PRIMARY KEY (`id`)

)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;





-- 用户收藏表
DROP TABLE IF EXISTS `t_collect`;
CREATE TABLE `t_collect`(
  `id` bigint not null AUTO_INCREMENT,
  `userID`  bigint not null comment'用户id',
  `goodsID` bigint not null comment'商品id',
  `createTime` DATETIME not null comment'收藏时间',
  PRIMARY KEY (`id`),
  KEY `collectid` (`userID`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- 文章管理
DROP TABLE IF EXISTS `t_article`;
CREATE TABLE `t_article`(
  `id` bigint not null AUTO_INCREMENT,
  `content` varchar(5000) comment'内容',
  `title` varchar(64) comment'标题',
  `looksum` bigint comment'是否启用',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- 村庄的头条页
DROP TABLE IF EXISTS `t_articleculture`;
CREATE TABLE `t_articleculture`(
  `id` bigint not null AUTO_INCREMENT,
  `title` varchar(64) not null comment'标题',
  `content` varchar(5000)comment'内容',
  `looksum` bigint comment'是否启用',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- 店铺表
DROP TABLE IF EXISTS `t_store`;
CREATE TABLE `t_store`(
  `id` bigint not null AUTO_INCREMENT,
  `createTime` datetime comment'创建时间',
  `storeName` varchar(64) not null comment'店铺名字',
  `storeAddress` varchar(64) comment'店铺地址',
  `storeType` varchar(32) not null comment'店铺类型',
  `storer` varchar(32) not null comment'店主',
  `stroelogo` varchar(64) comment'店铺logo',
  `scope` varchar(64) comment'店铺行业',
  `tel` varchar(64) comment'电话',
  `isAuth` tinyint DEFAULT '1' comment'是否启用',
  `storeUserID` bigint not null comment'用户id',
  `passworld` varchar(64) not null comment'密码',
  `introduce` varchar(128) comment'描述',
  `type` tinyint comment'店铺属于那种类型',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- 订单表
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order`(
  `id` bigint not null AUTO_INCREMENT,
  `userID` bigint not null comment'用户id',
  `storeID` bigint not null comment'商铺id',
  `orderCode` bigint not null comment'订单流水号',
  `goodsName` varchar(64) not null comment'商品名称',
  `goodsID` bigint not null comment'商品id',
  `addressID`bigint comment'地址管理表id',
  `marketPricce` FLOAT(10,2) comment'市场价',
  `memberPrice` FLOAT(10,2) comment'会员价',
  `goodSum` int(10) DEFAULT '0' comment'商品数量',
  `priceSum` FLOAT(10,2) comment'总价',
  `sendTime` DATETIME comment'发货时间',
  `createTime` DATETIME comment'创建时间',
  `payTime` DATETIME comment'支付时间',
  `cancel` DATETIME comment'取消时间',
  `completeTime` DATETIME comment'完成时间',
  `logistics` varchar(32) comment'物流单位',
  `message` varchar(1200) comment'留言',
  `logisticsCode`bigint comment'物流编码',
  `isPay` tinyint DEFAULT '0' comment'订单状态' ,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- 收入表
DROP TABLE IF EXISTS `t_income`;
CREATE TABLE `t_income`(
  `id` bigint not null AUTO_INCREMENT,
  `orderCode` bigint not null comment'订单流水号',
  `orderId` bigint not null comment'订单id',
  `payName` varchar(128) comment'支付人',
  `payID` bigint comment'支付id',
  `price` FLOAT(10,2) comment'总价',
  `payTime` DATETIME comment'支付时间',
  `stutas` tinyint DEFAULT '0' comment'状态',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- 支出表
DROP TABLE IF EXISTS `t_outcome`;
CREATE TABLE `t_outcome`(
  `id` bigint not null AUTO_INCREMENT,
  `orderCode` bigint not null comment'订单流水号',
  `payName` varchar(128) comment'收款人',
  `payAcount` bigint comment'收款账号',
  `price` FLOAT(10,2) comment'金额',
  `dopayName` varchar(128) comment'审核人',
  `payTime` DATETIME comment'支付时间',
  `stutas` tinyint DEFAULT '0' comment'状态',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- 会员申请
DROP TABLE IF EXISTS `t_memberApply`;
CREATE TABLE `t_memberApply`(
  `id` bigint not null AUTO_INCREMENT,
  `userID` bigint comment'用户id',
  `username`varchar(128) comment'用户名字',
  `identityImage` varchar(128) comment'身份证证明',
  `identityImages` varchar(128) comment'身份证反面',
  `bankacount` varchar(128) comment'银行账户',
  `appleTime` DATETIME comment'申请时间',
  `stutas` tinyint DEFAULT '0' comment'状态',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- 村村通申请
DROP TABLE IF EXISTS `t_villageApply`;
CREATE TABLE `t_villageApply`(
  `id` bigint not null AUTO_INCREMENT,
  `userID` bigint comment'用户id',
  `username`varchar(128) comment'申请者名字',
  `identityImage` varchar(128) comment'身份证正面',
  `identityImages` varchar(128) comment'身份证反面',
  `bankacount` varchar(128) comment'银行账户',
  `appleTime` DATETIME comment'申请时间',
  `stutas` tinyint DEFAULT '0' comment'状态',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- 店铺申请
DROP TABLE IF EXISTS `t_storeApply`;
CREATE TABLE `t_storeApply`(
  `id` bigint not null AUTO_INCREMENT,
  `userID` bigint comment'申请者id',
  `username`varchar(128) comment'申请者名字',
  `identityImage` varchar(128) comment'身份证正面',
  `identityImages` varchar(128) comment'身份证反面',
  `bankacount` varchar(128) comment'银行账户',
  `tel` varchar(128) comment'电话',
  `businessImages` varchar(128) comment'营业执照',
  `appleTime` DATETIME comment'申请时间',
  `stutas` tinyint DEFAULT '0'comment'状态',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- 提现申请
DROP TABLE IF EXISTS `t_withDrawApply`;
CREATE TABLE `t_withDrawApply`(
  `id` bigint not null AUTO_INCREMENT,
  `userID` bigint comment'申请id',
  `username`varchar(128) comment'申请者名字',
  `storeName`varchar(128) comment'店铺名字',
  `price` FLOAT(10,2) comment'金额',
  `bankacount` varchar(128) comment'银行账户',
  `appleTime` DATETIME comment'申请时间',
  `stutas` tinyint DEFAULT '0' comment'状态',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- 物流表
DROP TABLE IF EXISTS `t_logistics`;
CREATE TABLE `t_logistics`(
  `id` bigint not null AUTO_INCREMENT,
  `orderId` bigint not null comment'订单id',
  `userID` bigint not null comment'用户id',
  `logisticsName` varchar(32) not null comment'物流名称',
  `logisticsState` varchar(64) comment'物流编号' ,
  PRIMARY KEY(`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
-- 商品类型
DROP TABLE IF EXISTS `t_goodsType`;
CREATE TABLE `t_goodsType`(
  `id` bigint not null,
  `TypeName` varchar(32) comment'类别名称',
  `fatherTypeID` bigint comment'父级id',
  `isFather` tinyint DEFAULT '0'comment'是否为父级',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO `t_goodsType` (`id`,`TypeName`,`fatherTypeID`,`isFather`)
VALUES(1,'综合',0,1),
  (2,'主商城',0,1),
  (3,'鱼禽肉蛋',1,0),
  (4,'蔬菜花果',1,0),
  (5,'园林花卉',1,0),
  (6,'粮油食品',1,0),
  (7,'农机设备',1,0),
  (8,'生态花果',1,0),
  (9,'土地改良',1,0),
  (10,'有机种植',1,0),
  (11,'农副产品',1,0),
  (12,'虫草保健',1,0),
  (13,'食品保健',2,0),
  (14,'美容护理',2,0),
  (15,'手机数码',2,0),
  (16,'装修建材',2,0),
  (17,'男女服饰',2,0),
  (18,'鞋帽箱包',2,0),
  (19,'饰品摆件',2,0),
  (20,'珠宝首饰',2,0),
  (21,'日用刚需',2,0),
  (22,'母婴童装',2,0);

-- 商品表
DROP TABLE IF EXISTS `t_goods`;
CREATE TABLE `t_goods`(
  `id` bigint not null AUTO_INCREMENT,
  `goodsName` varchar(128) comment'商品名称',
  `TypeID` bigint not null comment'类型id',
  `goodsSum` bigint comment'商品库存',
  `marketPrive` FLOAT(10,2) comment'市场价',
  `memberPrice` FLOAT(10,2) comment'会员价',
  `sendCredit` int comment'赠送积分',
  `storeID` bigint not null comment'店铺id',
  `shop` varchar(32) not null comment'店铺名称',
  `soldamount` bigint comment'售出数量',
  `isstart` tinyint DEFAULT "1" comment'是否上架',
  `createTime` DATETIME comment'创建时间',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
-- 积分商品表
DROP TABLE IF EXISTS `t_creditgoods`;
CREATE TABLE `t_creditgoods`(
  `id` bigint not null AUTO_INCREMENT,
  `creditgood` varchar(128) comment'积分商品名称',
  `imageurl` varchar(128) comment'积分商品图片',
  `cregoodsSum` bigint comment'积分商品库存',
  `soldamount` bigint comment'售出数量',
  `isstart` tinyint DEFAULT "1" comment'是否上架',
  `createTime` DATETIME comment'创建时间',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


-- 商品图片表
DROP TABLE IF EXISTS `t_goodsImage`;
CREATE TABLE `t_goodsImage`(
  `id` bigint not null AUTO_INCREMENT,
  `goodsID` bigint not null comment'图片id',
  `IamgeAddress` varchar(128) comment'图片地址',
  `isKeyIamge` tinyint DEFAULT '0' comment'是否为主图',
  `createTime` datetime comment'创建时间',
  PRIMARY KEY (`id`),
  KEY `imageid` (`goodsID`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- 商品细节
DROP TABLE IF EXISTS `t_goodsDetail`;
CREATE TABLE `t_goodsDetail`(
  `id` bigint not null AUTO_INCREMENT,
  `goodsID` bigint not null comment'商品id',
  `content` varchar(2280) comment'描述',
  PRIMARY KEY (`id`),
  KEY `imageid` (`goodsID`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- 评价表
DROP TABLE IF EXISTS `t_evaluate`;
CREATE TABLE `t_evaluate`(
  `id` bigint not null AUTO_INCREMENT,
  `goodsID` bigint not null comment'商品id',
  `userID` bigint not null comment'用户id',
  `content` varchar(64) comment'内容',
  PRIMARY KEY (`id`),
  KEY `evgoods` (`goodsID`),
  KEY `evuserid` (`userID`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- 购物车
DROP TABLE IF EXISTS `t_shoppingcart`;
CREATE TABLE `t_shoppingcart`(
  `id` bigint not null AUTO_INCREMENT,
  `goodsID` bigint not null comment'商品id',
  `storeID` bigint not null comment'店铺id',
  `userID` bigint not null comment'用户id',
  `storeName` varchar(64) comment'店铺名称',
  `goodsName` varchar(64) comment'商品名称',
  `memberPrice`FLOAT(5,2) comment'价格' ,
  `number`bigint comment'数量',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;








