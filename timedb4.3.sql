/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : timedb

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2019-04-03 09:37:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_category`
-- ----------------------------
DROP TABLE IF EXISTS `tb_category`;
CREATE TABLE `tb_category` (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `c_name` char(10) NOT NULL,
  `status` char(4) NOT NULL DEFAULT '正常',
  PRIMARY KEY (`c_id`),
  KEY `c_name` (`c_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_category
-- ----------------------------
INSERT INTO `tb_category` VALUES ('1', '夏日清爽', '正常');
INSERT INTO `tb_category` VALUES ('2', '冬日温暖', '正常');
INSERT INTO `tb_category` VALUES ('3', '水果茶', '正常');
INSERT INTO `tb_category` VALUES ('4', '咖啡系列', '正常');
INSERT INTO `tb_category` VALUES ('9', '奶茶系列', '正常');

-- ----------------------------
-- Table structure for `tb_change`
-- ----------------------------
DROP TABLE IF EXISTS `tb_change`;
CREATE TABLE `tb_change` (
  `m_id` char(11) NOT NULL,
  `date` datetime NOT NULL,
  `restpoint` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`m_id`,`date`),
  CONSTRAINT `f_memb` FOREIGN KEY (`m_id`) REFERENCES `tb_member` (`m_id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_change
-- ----------------------------
INSERT INTO `tb_change` VALUES ('13751210785', '2019-03-27 13:42:12', '12');
INSERT INTO `tb_change` VALUES ('13751210789', '2019-01-23 17:17:09', '25');
INSERT INTO `tb_change` VALUES ('13751210789', '2019-01-23 17:18:09', '10');
INSERT INTO `tb_change` VALUES ('13751210789', '2019-01-23 17:19:09', '10');
INSERT INTO `tb_change` VALUES ('13751210789', '2019-01-23 17:52:34', '5');
INSERT INTO `tb_change` VALUES ('13751210789', '2019-01-23 17:54:39', '0');
INSERT INTO `tb_change` VALUES ('13751210789', '2019-03-05 20:11:12', '45');
INSERT INTO `tb_change` VALUES ('13751210789', '2019-03-26 19:41:40', '40');
INSERT INTO `tb_change` VALUES ('13751210789', '2019-03-28 00:07:26', '36');
INSERT INTO `tb_change` VALUES ('13751210789', '2019-03-28 00:10:03', '31');
INSERT INTO `tb_change` VALUES ('13751210789', '2019-03-28 10:59:10', '27');

-- ----------------------------
-- Table structure for `tb_deal`
-- ----------------------------
DROP TABLE IF EXISTS `tb_deal`;
CREATE TABLE `tb_deal` (
  `dd_id` char(12) NOT NULL,
  `dd_date` datetime NOT NULL,
  `total` float(5,2) NOT NULL,
  `e_id` int(11) NOT NULL,
  `isMer` char(2) DEFAULT '否',
  `m_id` char(11) DEFAULT NULL,
  `point` int(11) DEFAULT NULL,
  `num` int(11) NOT NULL,
  `status` char(4) NOT NULL DEFAULT '有效',
  PRIMARY KEY (`dd_id`),
  KEY `f_emp` (`e_id`),
  CONSTRAINT `f_emp` FOREIGN KEY (`e_id`) REFERENCES `tb_employe` (`e_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_deal
-- ----------------------------
INSERT INTO `tb_deal` VALUES ('201305240001', '2013-05-24 16:12:55', '10.00', '1', '否', '13751210789', '1', '1', '有效');
INSERT INTO `tb_deal` VALUES ('201711110001', '2017-11-11 15:40:55', '13.00', '1', '否', null, '0', '1', '有效');
INSERT INTO `tb_deal` VALUES ('201812190003', '2018-12-19 01:55:19', '20.00', '1', '', '', '0', '2', '有效');
INSERT INTO `tb_deal` VALUES ('201812190004', '2018-12-19 04:30:52', '13.00', '1', '', '', '0', '1', '有效');
INSERT INTO `tb_deal` VALUES ('201812190005', '2018-12-19 07:23:55', '13.00', '1', '是', '13751210789', '1', '1', '无效');
INSERT INTO `tb_deal` VALUES ('201812190006', '2018-12-19 07:24:34', '12.00', '1', '否', '', '0', '1', '有效');
INSERT INTO `tb_deal` VALUES ('201812190007', '2018-12-19 07:28:50', '34.00', '1', '是', '13751210789', '3', '3', '有效');
INSERT INTO `tb_deal` VALUES ('201812190008', '2018-12-19 07:30:49', '72.00', '1', '是', '13751210789', '6', '6', '有效');
INSERT INTO `tb_deal` VALUES ('201812230001', '2018-12-23 05:40:05', '69.00', '1', '否', '', '0', '6', '有效');
INSERT INTO `tb_deal` VALUES ('201812230002', '2018-12-23 05:42:58', '35.00', '1', '否', '', '0', '3', '有效');
INSERT INTO `tb_deal` VALUES ('201812230003', '2018-12-23 07:17:12', '69.00', '1', '否', '', '0', '6', '有效');
INSERT INTO `tb_deal` VALUES ('201812230004', '2018-12-23 19:20:12', '69.00', '1', '否', '', '0', '6', '有效');
INSERT INTO `tb_deal` VALUES ('201812300001', '2018-12-30 19:24:35', '22.00', '1', '否', '', '0', '2', '有效');
INSERT INTO `tb_deal` VALUES ('201812300002', '2018-12-30 19:31:45', '51.00', '1', '否', '', '0', '5', '有效');
INSERT INTO `tb_deal` VALUES ('201812300003', '2018-12-30 19:33:10', '12.00', '1', '否', '', '0', '1', '有效');
INSERT INTO `tb_deal` VALUES ('201812300004', '2018-12-30 20:37:07', '36.00', '1', '否', '', '0', '3', '有效');
INSERT INTO `tb_deal` VALUES ('201812300005', '2018-12-30 20:39:28', '10.20', '1', '是', '13751210789', '1', '1', '有效');
INSERT INTO `tb_deal` VALUES ('201812300006', '2018-12-30 20:41:32', '20.40', '1', '是', '13751210789', '2', '2', '有效');
INSERT INTO `tb_deal` VALUES ('201901030001', '2019-01-03 14:32:21', '6.80', '1', '是', '13751210789', '1', '1', '有效');
INSERT INTO `tb_deal` VALUES ('201901030002', '2019-01-03 14:35:12', '10.20', '1', '是', '13751210789', '1', '1', '有效');
INSERT INTO `tb_deal` VALUES ('201901030003', '2019-01-03 14:35:48', '10.20', '1', '是', '13751210789', '1', '1', '有效');
INSERT INTO `tb_deal` VALUES ('201901030004', '2019-01-03 16:21:36', '12.00', '1', '否', '', '0', '1', '有效');
INSERT INTO `tb_deal` VALUES ('201901030005', '2019-01-03 16:44:11', '15.00', '1', '否', '', '0', '1', '有效');
INSERT INTO `tb_deal` VALUES ('201901030006', '2019-01-03 16:47:18', '25.00', '1', '否', '', '0', '2', '有效');
INSERT INTO `tb_deal` VALUES ('201901040001', '2019-01-04 15:05:59', '13.00', '1', '否', '', '0', '1', '有效');
INSERT INTO `tb_deal` VALUES ('201901100001', '2019-01-10 16:02:27', '10.40', '1', '否', '', '0', '1', '有效');
INSERT INTO `tb_deal` VALUES ('201901100002', '2019-01-10 16:02:50', '16.00', '1', '否', '', '0', '1', '有效');
INSERT INTO `tb_deal` VALUES ('201901100003', '2019-01-10 16:19:29', '16.10', '1', '否', '', '0', '2', '有效');
INSERT INTO `tb_deal` VALUES ('201901190001', '2019-01-19 14:07:24', '16.00', '1', '否', '', '0', '1', '有效');
INSERT INTO `tb_deal` VALUES ('201901190002', '2019-01-19 16:55:20', '36.00', '1', '否', '', '0', '3', '有效');
INSERT INTO `tb_deal` VALUES ('201901230001', '2019-01-23 17:27:50', '9.40', '1', '是', '13751210789', '1', '1', '有效');
INSERT INTO `tb_deal` VALUES ('201902190001', '2019-02-19 17:33:21', '13.00', '1', '否', '', '0', '1', '有效');
INSERT INTO `tb_deal` VALUES ('201902190002', '2019-02-19 17:34:35', '10.00', '1', '否', '', '0', '1', '有效');
INSERT INTO `tb_deal` VALUES ('201902190004', '2019-02-19 17:36:04', '13.00', '1', '否', '', '0', '1', '有效');
INSERT INTO `tb_deal` VALUES ('201902190005', '2019-02-19 17:37:07', '18.00', '1', '否', '', '0', '1', '有效');
INSERT INTO `tb_deal` VALUES ('201902190006', '2019-02-19 17:38:05', '10.00', '1', '否', '', '0', '1', '有效');
INSERT INTO `tb_deal` VALUES ('201902190007', '2019-02-19 17:44:28', '99.00', '1', '否', '', '0', '8', '有效');
INSERT INTO `tb_deal` VALUES ('201902190009', '2019-02-19 17:46:54', '110.00', '1', '否', '', '0', '11', '有效');
INSERT INTO `tb_deal` VALUES ('201902190010', '2019-02-19 17:50:03', '127.00', '1', '否', '', '0', '10', '有效');
INSERT INTO `tb_deal` VALUES ('201902190011', '2019-02-19 17:57:38', '20.00', '1', '否', '', '0', '2', '有效');
INSERT INTO `tb_deal` VALUES ('201903010001', '2019-03-01 15:12:53', '14.00', '1', '否', '', '0', '1', '无效');
INSERT INTO `tb_deal` VALUES ('201903010002', '2019-03-01 17:18:15', '10.00', '1', '否', '', '0', '1', '有效');
INSERT INTO `tb_deal` VALUES ('201903010003', '2019-03-01 17:19:55', '50.00', '1', '否', '', '0', '5', '有效');
INSERT INTO `tb_deal` VALUES ('201903010004', '2019-03-01 17:20:17', '89.00', '1', '否', '', '0', '8', '有效');
INSERT INTO `tb_deal` VALUES ('201903010005', '2019-03-01 17:21:57', '89.00', '1', '否', '', '0', '8', '有效');
INSERT INTO `tb_deal` VALUES ('201903050001', '2019-03-05 20:10:45', '13.00', '1', '否', '', '0', '1', '有效');
INSERT INTO `tb_deal` VALUES ('201903060001', '2019-03-06 12:44:43', '12.00', '1', '否', '', '0', '1', '有效');
INSERT INTO `tb_deal` VALUES ('201903080001', '2019-03-08 15:09:54', '14.00', '1', '否', '', '0', '1', '有效');
INSERT INTO `tb_deal` VALUES ('201903080002', '2019-03-08 15:11:08', '11.10', '1', '是', '13751210789', '1', '1', '有效');
INSERT INTO `tb_deal` VALUES ('201903260001', '2019-03-26 23:52:43', '10.00', '1', '否', '', '0', '1', '有效');
INSERT INTO `tb_deal` VALUES ('201903260002', '2019-03-26 23:52:49', '10.00', '1', '否', '', '0', '1', '有效');
INSERT INTO `tb_deal` VALUES ('201903260003', '2019-03-26 23:52:55', '12.00', '1', '否', '', '0', '1', '有效');
INSERT INTO `tb_deal` VALUES ('201903260004', '2019-03-26 23:53:08', '35.00', '1', '否', '', '0', '3', '无效');
INSERT INTO `tb_deal` VALUES ('201903260005', '2019-03-26 23:54:28', '10.00', '1', '否', '', '0', '1', '有效');
INSERT INTO `tb_deal` VALUES ('201903270001', '2019-03-27 13:12:31', '12.80', '1', '是', '13751210789', '1', '1', '有效');
INSERT INTO `tb_deal` VALUES ('201903270002', '2019-03-27 13:14:04', '6.80', '1', '是', '13751210789', '1', '1', '有效');
INSERT INTO `tb_deal` VALUES ('201903270003', '2019-03-27 13:22:08', '11.10', '1', '是', '13751210785', '1', '1', '有效');
INSERT INTO `tb_deal` VALUES ('201903270004', '2019-03-27 13:24:16', '11.10', '1', '是', '13751210785', '1', '1', '有效');
INSERT INTO `tb_deal` VALUES ('201903270005', '2019-03-27 13:40:00', '8.50', '1', '是', '13751210785', '1', '1', '有效');
INSERT INTO `tb_deal` VALUES ('201903270006', '2019-03-27 13:41:57', '11.10', '1', '是', '13751210785', '1', '1', '有效');
INSERT INTO `tb_deal` VALUES ('201903270007', '2019-03-27 18:43:20', '11.90', '1', '是', '15625530202', '1', '1', '有效');
INSERT INTO `tb_deal` VALUES ('201903270008', '2019-03-27 18:45:03', '11.10', '1', '是', '15625530202', '1', '1', '有效');
INSERT INTO `tb_deal` VALUES ('201903270009', '2019-03-27 18:45:09', '13.00', '1', '否', '', '0', '1', '有效');
INSERT INTO `tb_deal` VALUES ('201903270010', '2019-03-27 18:48:28', '11.10', '1', '是', '15625530202', '1', '1', '有效');
INSERT INTO `tb_deal` VALUES ('201903270011', '2019-03-27 18:48:33', '13.00', '1', '否', '', '0', '1', '有效');
INSERT INTO `tb_deal` VALUES ('201903270012', '2019-03-27 18:49:51', '8.50', '1', '是', '15625530202', '1', '1', '有效');
INSERT INTO `tb_deal` VALUES ('201903270013', '2019-03-27 18:50:03', '8.50', '1', '是', '15625530202', '1', '1', '有效');
INSERT INTO `tb_deal` VALUES ('201903270014', '2019-03-27 18:50:25', '27.20', '1', '是', '15625530202', '3', '3', '有效');
INSERT INTO `tb_deal` VALUES ('201903270015', '2019-03-27 18:51:15', '12.00', '1', '否', '', '0', '1', '无效');
INSERT INTO `tb_deal` VALUES ('201903270016', '2019-03-27 18:51:24', '12.00', '1', '否', '', '0', '1', '有效');
INSERT INTO `tb_deal` VALUES ('201903270017', '2019-03-27 18:51:49', '13.00', '1', '否', '', '0', '1', '有效');
INSERT INTO `tb_deal` VALUES ('201903270018', '2019-03-27 18:53:33', '10.00', '1', '否', '', '0', '1', '无效');
INSERT INTO `tb_deal` VALUES ('201903270019', '2019-03-27 18:53:38', '10.00', '1', '否', '', '0', '1', '无效');
INSERT INTO `tb_deal` VALUES ('201903270020', '2019-03-27 18:53:52', '19.60', '1', '是', '13751210785', '2', '2', '无效');
INSERT INTO `tb_deal` VALUES ('201903270021', '2019-03-27 18:53:59', '10.00', '1', '否', '', '0', '1', '有效');
INSERT INTO `tb_deal` VALUES ('201903270022', '2019-03-27 21:42:49', '12.00', '1', '否', '', '0', '1', '有效');
INSERT INTO `tb_deal` VALUES ('201903270023', '2019-03-27 21:43:12', '12.00', '1', '否', '', '0', '1', '有效');
INSERT INTO `tb_deal` VALUES ('201903270024', '2019-03-27 21:43:40', '20.00', '1', '否', '', '0', '2', '有效');
INSERT INTO `tb_deal` VALUES ('201903270025', '2019-03-27 21:43:56', '42.00', '1', '否', '', '0', '3', '有效');
INSERT INTO `tb_deal` VALUES ('201903270026', '2019-03-27 21:44:10', '42.00', '1', '否', '', '0', '3', '有效');
INSERT INTO `tb_deal` VALUES ('201903270027', '2019-03-27 21:44:31', '28.00', '1', '否', '', '0', '2', '有效');
INSERT INTO `tb_deal` VALUES ('201903270028', '2019-03-27 21:49:58', '28.00', '1', '否', '', '0', '2', '有效');
INSERT INTO `tb_deal` VALUES ('201903270029', '2019-03-27 21:58:03', '26.00', '1', '否', '', '0', '2', '有效');
INSERT INTO `tb_deal` VALUES ('201903270030', '2019-03-27 21:58:35', '28.00', '1', '否', '', '0', '2', '有效');
INSERT INTO `tb_deal` VALUES ('201903270031', '2019-03-27 21:59:12', '28.00', '1', '否', '', '0', '2', '有效');
INSERT INTO `tb_deal` VALUES ('201903270032', '2019-03-27 22:09:14', '18.00', '1', '否', '', '0', '2', '有效');
INSERT INTO `tb_deal` VALUES ('201903270033', '2019-03-27 22:11:07', '35.00', '1', '否', '', '0', '3', '有效');
INSERT INTO `tb_deal` VALUES ('201903270034', '2019-03-27 22:11:53', '11.10', '1', '是', '13751210789', '1', '1', '有效');
INSERT INTO `tb_deal` VALUES ('201903270035', '2019-03-27 23:34:39', '23.00', '1', '是', '13751210777', '2', '2', '有效');
INSERT INTO `tb_deal` VALUES ('201903270036', '2019-03-27 23:35:54', '23.00', '1', '否', '', '0', '2', '有效');
INSERT INTO `tb_deal` VALUES ('201903270037', '2019-03-27 23:39:35', '23.00', '1', '否', '', '0', '2', '有效');
INSERT INTO `tb_deal` VALUES ('201903270038', '2019-03-27 23:43:43', '23.00', '1', '否', '', '0', '2', '有效');
INSERT INTO `tb_deal` VALUES ('201903270039', '2019-03-27 23:46:14', '10.00', '1', '否', '', '0', '1', '有效');
INSERT INTO `tb_deal` VALUES ('201903270040', '2019-03-27 23:47:21', '13.00', '1', '否', '', '0', '1', '有效');
INSERT INTO `tb_deal` VALUES ('201903270041', '2019-03-27 23:53:33', '13.00', '1', '否', '', '0', '1', '有效');
INSERT INTO `tb_deal` VALUES ('201903270042', '2019-03-27 23:59:55', '13.00', '1', '否', '', '0', '1', '有效');
INSERT INTO `tb_deal` VALUES ('201903280001', '2019-03-28 00:06:36', '23.00', '1', '否', '', '0', '2', '有效');
INSERT INTO `tb_deal` VALUES ('201903280002', '2019-03-28 00:06:58', '22.00', '1', '否', '', '0', '2', '有效');
INSERT INTO `tb_deal` VALUES ('201903280003', '2019-03-28 00:10:36', '8.00', '1', '否', '', '0', '1', '无效');
INSERT INTO `tb_deal` VALUES ('201903280004', '2019-03-28 09:48:14', '14.00', '1', '否', '', '0', '1', '无效');
INSERT INTO `tb_deal` VALUES ('201903280005', '2019-03-28 09:48:56', '12.00', '1', '是', '13751210789', '1', '1', '有效');
INSERT INTO `tb_deal` VALUES ('201903280006', '2019-03-28 09:50:02', '50.20', '1', '是', '13751210784', '5', '5', '有效');
INSERT INTO `tb_deal` VALUES ('201903280007', '2019-03-28 10:50:24', '24.00', '1', '否', '', '0', '2', '有效');
INSERT INTO `tb_deal` VALUES ('201903280008', '2019-03-28 10:52:39', '16.00', '1', '否', '', '0', '2', '有效');
INSERT INTO `tb_deal` VALUES ('201903280009', '2019-03-28 10:56:23', '75.00', '1', '否', '', '0', '10', '有效');
INSERT INTO `tb_deal` VALUES ('201903280010', '2019-03-28 10:57:18', '85.00', '1', '是', '12312345611', '10', '10', '有效');
INSERT INTO `tb_deal` VALUES ('201903280011', '2019-03-28 11:00:08', '13.00', '1', '否', '', '0', '1', '有效');
INSERT INTO `tb_deal` VALUES ('201903280012', '2019-03-28 11:00:17', '13.00', '1', '否', '', '0', '1', '有效');
INSERT INTO `tb_deal` VALUES ('201903280013', '2019-03-28 14:20:25', '9.90', '1', '否', '', '0', '1', '有效');
INSERT INTO `tb_deal` VALUES ('201903280014', '2019-03-28 14:24:14', '57.00', '1', '是', '13751210789', '6', '6', '无效');

-- ----------------------------
-- Table structure for `tb_detail`
-- ----------------------------
DROP TABLE IF EXISTS `tb_detail`;
CREATE TABLE `tb_detail` (
  `dd_id` char(12) NOT NULL,
  `c_id` int(11) NOT NULL,
  `c_name` char(10) NOT NULL,
  `d_id` int(11) NOT NULL,
  `d_name` char(10) NOT NULL,
  `num` int(11) NOT NULL,
  `price` float(5,2) NOT NULL,
  PRIMARY KEY (`dd_id`,`c_id`,`d_id`,`price`),
  KEY `f_d` (`d_id`),
  KEY `f_cid` (`c_id`),
  KEY `f_dname` (`d_name`),
  KEY `f_cname` (`c_name`),
  CONSTRAINT `f_cid` FOREIGN KEY (`c_id`) REFERENCES `tb_category` (`c_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `f_cname` FOREIGN KEY (`c_name`) REFERENCES `tb_category` (`c_name`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `f_dd` FOREIGN KEY (`dd_id`) REFERENCES `tb_deal` (`dd_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `f_dname` FOREIGN KEY (`d_name`) REFERENCES `tb_drink` (`d_name`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_detail
-- ----------------------------
INSERT INTO `tb_detail` VALUES ('201305240001', '2', '冬日温暖', '3', '红糖枸杞', '1', '10.00');
INSERT INTO `tb_detail` VALUES ('201711110001', '1', '夏日清爽', '1', '柠檬汽泡', '1', '12.00');
INSERT INTO `tb_detail` VALUES ('201812190003', '2', '冬日温暖', '3', '红糖枸杞', '2', '10.00');
INSERT INTO `tb_detail` VALUES ('201812190004', '1', '夏日清爽', '2', '芒果汽泡', '1', '13.00');
INSERT INTO `tb_detail` VALUES ('201812190005', '1', '夏日清爽', '2', '芒果汽泡', '1', '13.00');
INSERT INTO `tb_detail` VALUES ('201812190006', '1', '夏日清爽', '1', '柠檬汽泡', '1', '12.00');
INSERT INTO `tb_detail` VALUES ('201812190007', '2', '冬日温暖', '3', '红糖枸杞', '3', '10.00');
INSERT INTO `tb_detail` VALUES ('201812190008', '1', '夏日清爽', '1', '柠檬汽泡', '3', '12.00');
INSERT INTO `tb_detail` VALUES ('201812190008', '1', '夏日清爽', '2', '芒果汽泡', '2', '13.00');
INSERT INTO `tb_detail` VALUES ('201812190008', '2', '冬日温暖', '3', '红糖枸杞', '1', '10.00');
INSERT INTO `tb_detail` VALUES ('201812230001', '1', '夏日清爽', '1', '柠檬汽泡', '1', '12.00');
INSERT INTO `tb_detail` VALUES ('201812230001', '1', '夏日清爽', '2', '芒果汽泡', '1', '13.00');
INSERT INTO `tb_detail` VALUES ('201812230001', '1', '夏日清爽', '4', '翠峰茉莉', '1', '6.00');
INSERT INTO `tb_detail` VALUES ('201812230001', '1', '夏日清爽', '5', '芝士莓莓', '1', '18.00');
INSERT INTO `tb_detail` VALUES ('201812230001', '1', '夏日清爽', '6', '西瓜汽泡', '1', '10.00');
INSERT INTO `tb_detail` VALUES ('201812230001', '2', '冬日温暖', '3', '红糖枸杞', '1', '10.00');
INSERT INTO `tb_detail` VALUES ('201812230002', '1', '夏日清爽', '1', '柠檬汽泡', '1', '12.00');
INSERT INTO `tb_detail` VALUES ('201812230002', '1', '夏日清爽', '2', '芒果汽泡', '1', '13.00');
INSERT INTO `tb_detail` VALUES ('201812230002', '2', '冬日温暖', '3', '红糖枸杞', '1', '10.00');
INSERT INTO `tb_detail` VALUES ('201812230003', '1', '夏日清爽', '1', '柠檬汽泡', '1', '12.00');
INSERT INTO `tb_detail` VALUES ('201812230003', '1', '夏日清爽', '2', '芒果汽泡', '1', '13.00');
INSERT INTO `tb_detail` VALUES ('201812230003', '1', '夏日清爽', '4', '翠峰茉莉', '1', '6.00');
INSERT INTO `tb_detail` VALUES ('201812230003', '1', '夏日清爽', '5', '芝士莓莓', '1', '18.00');
INSERT INTO `tb_detail` VALUES ('201812230003', '1', '夏日清爽', '6', '西瓜汽泡', '1', '10.00');
INSERT INTO `tb_detail` VALUES ('201812230003', '2', '冬日温暖', '3', '红糖枸杞', '1', '10.00');
INSERT INTO `tb_detail` VALUES ('201812230004', '1', '夏日清爽', '1', '柠檬汽泡', '1', '12.00');
INSERT INTO `tb_detail` VALUES ('201812230004', '1', '夏日清爽', '2', '芒果汽泡', '1', '13.00');
INSERT INTO `tb_detail` VALUES ('201812230004', '1', '夏日清爽', '4', '翠峰茉莉', '1', '6.00');
INSERT INTO `tb_detail` VALUES ('201812230004', '1', '夏日清爽', '5', '芝士莓莓', '1', '18.00');
INSERT INTO `tb_detail` VALUES ('201812230004', '1', '夏日清爽', '6', '西瓜汽泡', '1', '10.00');
INSERT INTO `tb_detail` VALUES ('201812230004', '2', '冬日温暖', '3', '红糖枸杞', '1', '10.00');
INSERT INTO `tb_detail` VALUES ('201812300001', '1', '夏日清爽', '1', '柠檬汽泡', '1', '12.00');
INSERT INTO `tb_detail` VALUES ('201812300001', '2', '冬日温暖', '3', '红糖枸杞', '1', '10.00');
INSERT INTO `tb_detail` VALUES ('201812300002', '1', '夏日清爽', '1', '柠檬汽泡', '1', '12.00');
INSERT INTO `tb_detail` VALUES ('201812300002', '1', '夏日清爽', '2', '芒果汽泡', '1', '13.00');
INSERT INTO `tb_detail` VALUES ('201812300002', '1', '夏日清爽', '4', '翠峰茉莉', '1', '6.00');
INSERT INTO `tb_detail` VALUES ('201812300002', '1', '夏日清爽', '6', '西瓜汽泡', '1', '10.00');
INSERT INTO `tb_detail` VALUES ('201812300002', '2', '冬日温暖', '3', '红糖枸杞', '1', '10.00');
INSERT INTO `tb_detail` VALUES ('201812300003', '1', '夏日清爽', '1', '柠檬汽泡', '1', '12.00');
INSERT INTO `tb_detail` VALUES ('201812300004', '1', '夏日清爽', '1', '柠檬汽泡', '3', '12.00');
INSERT INTO `tb_detail` VALUES ('201812300005', '1', '夏日清爽', '1', '柠檬汽泡', '1', '10.20');
INSERT INTO `tb_detail` VALUES ('201812300006', '1', '夏日清爽', '1', '柠檬汽泡', '2', '10.20');
INSERT INTO `tb_detail` VALUES ('201901030001', '1', '夏日清爽', '4', '翠峰茉莉', '1', '6.80');
INSERT INTO `tb_detail` VALUES ('201901030002', '1', '夏日清爽', '1', '柠檬汽泡', '1', '10.20');
INSERT INTO `tb_detail` VALUES ('201901030003', '1', '夏日清爽', '1', '柠檬汽泡', '1', '10.20');
INSERT INTO `tb_detail` VALUES ('201901030004', '1', '夏日清爽', '1', '柠檬汽泡', '1', '12.00');
INSERT INTO `tb_detail` VALUES ('201901030005', '1', '夏日清爽', '2', '芒果汽泡', '1', '15.00');
INSERT INTO `tb_detail` VALUES ('201901030006', '1', '夏日清爽', '1', '柠檬汽泡', '1', '10.00');
INSERT INTO `tb_detail` VALUES ('201901030006', '1', '夏日清爽', '2', '芒果汽泡', '1', '15.00');
INSERT INTO `tb_detail` VALUES ('201901040001', '1', '夏日清爽', '2', '芒果汽泡', '1', '13.00');
INSERT INTO `tb_detail` VALUES ('201901100001', '1', '夏日清爽', '2', '芒果汽泡', '1', '10.40');
INSERT INTO `tb_detail` VALUES ('201901100002', '1', '夏日清爽', '4', '翠峰茉莉', '2', '16.00');
INSERT INTO `tb_detail` VALUES ('201901100003', '1', '夏日清爽', '2', '芒果汽泡', '1', '9.10');
INSERT INTO `tb_detail` VALUES ('201901100003', '2', '冬日温暖', '3', '红糖枸杞', '1', '7.00');
INSERT INTO `tb_detail` VALUES ('201901190001', '1', '夏日清爽', '12', '百香果可乐', '1', '16.00');
INSERT INTO `tb_detail` VALUES ('201901190002', '1', '夏日清爽', '1', '柠檬汽泡', '3', '36.00');
INSERT INTO `tb_detail` VALUES ('201901230001', '1', '夏日清爽', '2', '芒果汽泡', '1', '9.40');
INSERT INTO `tb_detail` VALUES ('201902190001', '1', '夏日清爽', '2', '芒果汽泡', '1', '13.00');
INSERT INTO `tb_detail` VALUES ('201902190002', '2', '冬日温暖', '3', '红糖枸杞', '1', '10.00');
INSERT INTO `tb_detail` VALUES ('201902190004', '1', '夏日清爽', '2', '芒果汽泡', '1', '13.00');
INSERT INTO `tb_detail` VALUES ('201902190005', '1', '夏日清爽', '5', '芝士莓莓', '1', '18.00');
INSERT INTO `tb_detail` VALUES ('201902190006', '2', '冬日温暖', '3', '红糖枸杞', '1', '10.00');
INSERT INTO `tb_detail` VALUES ('201902190007', '1', '夏日清爽', '1', '柠檬汽泡', '2', '24.00');
INSERT INTO `tb_detail` VALUES ('201902190007', '1', '夏日清爽', '2', '芒果汽泡', '5', '65.00');
INSERT INTO `tb_detail` VALUES ('201902190007', '2', '冬日温暖', '3', '红糖枸杞', '1', '10.00');
INSERT INTO `tb_detail` VALUES ('201902190009', '2', '冬日温暖', '3', '红糖枸杞', '11', '110.00');
INSERT INTO `tb_detail` VALUES ('201902190010', '1', '夏日清爽', '2', '芒果汽泡', '9', '117.00');
INSERT INTO `tb_detail` VALUES ('201902190010', '1', '夏日清爽', '4', '翠峰茉莉', '1', '10.00');
INSERT INTO `tb_detail` VALUES ('201902190011', '2', '冬日温暖', '3', '红糖枸杞', '2', '20.00');
INSERT INTO `tb_detail` VALUES ('201903010001', '1', '夏日清爽', '12', '百香果可乐', '1', '14.00');
INSERT INTO `tb_detail` VALUES ('201903010002', '2', '冬日温暖', '3', '红糖枸杞', '1', '10.00');
INSERT INTO `tb_detail` VALUES ('201903010003', '1', '夏日清爽', '4', '翠峰茉莉', '5', '50.00');
INSERT INTO `tb_detail` VALUES ('201903010004', '1', '夏日清爽', '1', '柠檬汽泡', '1', '12.00');
INSERT INTO `tb_detail` VALUES ('201903010004', '1', '夏日清爽', '2', '芒果汽泡', '1', '13.00');
INSERT INTO `tb_detail` VALUES ('201903010004', '1', '夏日清爽', '4', '翠峰茉莉', '1', '10.00');
INSERT INTO `tb_detail` VALUES ('201903010004', '1', '夏日清爽', '9', '荔枝汽泡', '1', '10.00');
INSERT INTO `tb_detail` VALUES ('201903010004', '1', '夏日清爽', '10', '西瓜汽泡', '1', '10.00');
INSERT INTO `tb_detail` VALUES ('201903010004', '1', '夏日清爽', '12', '百香果可乐', '1', '14.00');
INSERT INTO `tb_detail` VALUES ('201903010004', '2', '冬日温暖', '3', '红糖枸杞', '1', '10.00');
INSERT INTO `tb_detail` VALUES ('201903010004', '9', '奶茶系列', '11', '布丁奶茶', '1', '10.00');
INSERT INTO `tb_detail` VALUES ('201903010005', '1', '夏日清爽', '1', '柠檬汽泡', '1', '12.00');
INSERT INTO `tb_detail` VALUES ('201903010005', '1', '夏日清爽', '2', '芒果汽泡', '1', '13.00');
INSERT INTO `tb_detail` VALUES ('201903010005', '1', '夏日清爽', '4', '翠峰茉莉', '1', '10.00');
INSERT INTO `tb_detail` VALUES ('201903010005', '1', '夏日清爽', '9', '荔枝汽泡', '1', '10.00');
INSERT INTO `tb_detail` VALUES ('201903010005', '1', '夏日清爽', '10', '西瓜汽泡', '1', '10.00');
INSERT INTO `tb_detail` VALUES ('201903010005', '1', '夏日清爽', '12', '百香果可乐', '1', '14.00');
INSERT INTO `tb_detail` VALUES ('201903010005', '2', '冬日温暖', '3', '红糖枸杞', '1', '10.00');
INSERT INTO `tb_detail` VALUES ('201903010005', '9', '奶茶系列', '11', '布丁奶茶', '1', '10.00');
INSERT INTO `tb_detail` VALUES ('201903050001', '1', '夏日清爽', '2', '芒果汽泡', '1', '13.00');
INSERT INTO `tb_detail` VALUES ('201903060001', '1', '夏日清爽', '1', '柠檬汽泡', '1', '12.00');
INSERT INTO `tb_detail` VALUES ('201903080001', '1', '夏日清爽', '1', '柠檬汽泡', '1', '14.00');
INSERT INTO `tb_detail` VALUES ('201903080002', '1', '夏日清爽', '2', '芒果汽泡', '1', '11.10');
INSERT INTO `tb_detail` VALUES ('201903260001', '2', '冬日温暖', '3', '红糖枸杞', '1', '10.00');
INSERT INTO `tb_detail` VALUES ('201903260002', '1', '夏日清爽', '4', '翠峰茉莉', '1', '10.00');
INSERT INTO `tb_detail` VALUES ('201903260003', '1', '夏日清爽', '8', '草莓气泡', '1', '12.00');
INSERT INTO `tb_detail` VALUES ('201903260004', '1', '夏日清爽', '1', '柠檬汽泡', '1', '12.00');
INSERT INTO `tb_detail` VALUES ('201903260004', '1', '夏日清爽', '2', '芒果汽泡', '1', '13.00');
INSERT INTO `tb_detail` VALUES ('201903260004', '2', '冬日温暖', '3', '红糖枸杞', '1', '10.00');
INSERT INTO `tb_detail` VALUES ('201903260005', '2', '冬日温暖', '3', '红糖枸杞', '1', '10.00');
INSERT INTO `tb_detail` VALUES ('201903270001', '1', '夏日清爽', '2', '芒果汽泡', '1', '12.80');
INSERT INTO `tb_detail` VALUES ('201903270002', '1', '夏日清爽', '4', '翠峰茉莉', '1', '6.80');
INSERT INTO `tb_detail` VALUES ('201903270003', '1', '夏日清爽', '2', '芒果汽泡', '1', '11.10');
INSERT INTO `tb_detail` VALUES ('201903270004', '1', '夏日清爽', '2', '芒果汽泡', '1', '11.10');
INSERT INTO `tb_detail` VALUES ('201903270005', '2', '冬日温暖', '3', '红糖枸杞', '1', '8.50');
INSERT INTO `tb_detail` VALUES ('201903270006', '1', '夏日清爽', '2', '芒果汽泡', '1', '11.10');
INSERT INTO `tb_detail` VALUES ('201903270007', '1', '夏日清爽', '1', '柠檬汽泡', '1', '11.90');
INSERT INTO `tb_detail` VALUES ('201903270008', '1', '夏日清爽', '2', '芒果汽泡', '1', '11.10');
INSERT INTO `tb_detail` VALUES ('201903270009', '1', '夏日清爽', '2', '芒果汽泡', '1', '13.00');
INSERT INTO `tb_detail` VALUES ('201903270010', '1', '夏日清爽', '2', '芒果汽泡', '1', '11.10');
INSERT INTO `tb_detail` VALUES ('201903270011', '1', '夏日清爽', '2', '芒果汽泡', '1', '13.00');
INSERT INTO `tb_detail` VALUES ('201903270012', '2', '冬日温暖', '3', '红糖枸杞', '1', '8.50');
INSERT INTO `tb_detail` VALUES ('201903270013', '2', '冬日温暖', '3', '红糖枸杞', '1', '8.50');
INSERT INTO `tb_detail` VALUES ('201903270014', '1', '夏日清爽', '4', '翠峰茉莉', '1', '8.50');
INSERT INTO `tb_detail` VALUES ('201903270014', '1', '夏日清爽', '8', '草莓气泡', '1', '10.20');
INSERT INTO `tb_detail` VALUES ('201903270014', '2', '冬日温暖', '3', '红糖枸杞', '1', '8.50');
INSERT INTO `tb_detail` VALUES ('201903270015', '1', '夏日清爽', '8', '草莓气泡', '1', '12.00');
INSERT INTO `tb_detail` VALUES ('201903270016', '1', '夏日清爽', '8', '草莓气泡', '1', '12.00');
INSERT INTO `tb_detail` VALUES ('201903270017', '1', '夏日清爽', '2', '芒果汽泡', '1', '13.00');
INSERT INTO `tb_detail` VALUES ('201903270018', '2', '冬日温暖', '3', '红糖枸杞', '1', '10.00');
INSERT INTO `tb_detail` VALUES ('201903270019', '2', '冬日温暖', '3', '红糖枸杞', '1', '10.00');
INSERT INTO `tb_detail` VALUES ('201903270020', '1', '夏日清爽', '2', '芒果汽泡', '1', '11.10');
INSERT INTO `tb_detail` VALUES ('201903270020', '2', '冬日温暖', '3', '红糖枸杞', '1', '8.50');
INSERT INTO `tb_detail` VALUES ('201903270021', '2', '冬日温暖', '3', '红糖枸杞', '1', '10.00');
INSERT INTO `tb_detail` VALUES ('201903270022', '1', '夏日清爽', '1', '柠檬汽泡', '1', '12.00');
INSERT INTO `tb_detail` VALUES ('201903270023', '1', '夏日清爽', '1', '柠檬汽泡', '1', '12.00');
INSERT INTO `tb_detail` VALUES ('201903270024', '1', '夏日清爽', '4', '翠峰茉莉', '1', '10.00');
INSERT INTO `tb_detail` VALUES ('201903270024', '2', '冬日温暖', '3', '红糖枸杞', '1', '10.00');
INSERT INTO `tb_detail` VALUES ('201903270025', '3', '水果茶', '22', '鲜橙多多', '3', '42.00');
INSERT INTO `tb_detail` VALUES ('201903270026', '3', '水果茶', '22', '鲜橙多多', '3', '42.00');
INSERT INTO `tb_detail` VALUES ('201903270027', '3', '水果茶', '22', '鲜橙多多', '2', '28.00');
INSERT INTO `tb_detail` VALUES ('201903270028', '3', '水果茶', '22', '鲜橙多多', '2', '28.00');
INSERT INTO `tb_detail` VALUES ('201903270029', '1', '夏日清爽', '2', '芒果汽泡', '2', '26.00');
INSERT INTO `tb_detail` VALUES ('201903270030', '1', '夏日清爽', '2', '芒果汽泡', '1', '13.00');
INSERT INTO `tb_detail` VALUES ('201903270030', '1', '夏日清爽', '2', '芒果汽泡', '1', '15.00');
INSERT INTO `tb_detail` VALUES ('201903270031', '1', '夏日清爽', '2', '芒果汽泡', '1', '13.00');
INSERT INTO `tb_detail` VALUES ('201903270031', '1', '夏日清爽', '2', '芒果汽泡', '1', '15.00');
INSERT INTO `tb_detail` VALUES ('201903270032', '2', '冬日温暖', '3', '红糖枸杞', '1', '8.00');
INSERT INTO `tb_detail` VALUES ('201903270032', '2', '冬日温暖', '3', '红糖枸杞', '1', '10.00');
INSERT INTO `tb_detail` VALUES ('201903270033', '1', '夏日清爽', '2', '芒果汽泡', '1', '15.00');
INSERT INTO `tb_detail` VALUES ('201903270033', '1', '夏日清爽', '4', '翠峰茉莉', '1', '10.00');
INSERT INTO `tb_detail` VALUES ('201903270033', '2', '冬日温暖', '3', '红糖枸杞', '1', '10.00');
INSERT INTO `tb_detail` VALUES ('201903270034', '1', '夏日清爽', '2', '芒果汽泡', '1', '11.10');
INSERT INTO `tb_detail` VALUES ('201903270035', '1', '夏日清爽', '1', '柠檬汽泡', '1', '10.20');
INSERT INTO `tb_detail` VALUES ('201903270035', '1', '夏日清爽', '2', '芒果汽泡', '1', '12.80');
INSERT INTO `tb_detail` VALUES ('201903270036', '1', '夏日清爽', '2', '芒果汽泡', '1', '13.00');
INSERT INTO `tb_detail` VALUES ('201903270036', '2', '冬日温暖', '3', '红糖枸杞', '1', '10.00');
INSERT INTO `tb_detail` VALUES ('201903270037', '1', '夏日清爽', '2', '芒果汽泡', '1', '13.00');
INSERT INTO `tb_detail` VALUES ('201903270037', '1', '夏日清爽', '4', '翠峰茉莉', '1', '10.00');
INSERT INTO `tb_detail` VALUES ('201903270038', '1', '夏日清爽', '2', '芒果汽泡', '1', '13.00');
INSERT INTO `tb_detail` VALUES ('201903270038', '1', '夏日清爽', '4', '翠峰茉莉', '1', '10.00');
INSERT INTO `tb_detail` VALUES ('201903270039', '2', '冬日温暖', '3', '红糖枸杞', '1', '10.00');
INSERT INTO `tb_detail` VALUES ('201903270040', '1', '夏日清爽', '2', '芒果汽泡', '1', '13.00');
INSERT INTO `tb_detail` VALUES ('201903270041', '1', '夏日清爽', '2', '芒果汽泡', '1', '13.00');
INSERT INTO `tb_detail` VALUES ('201903270042', '1', '夏日清爽', '2', '芒果汽泡', '1', '13.00');
INSERT INTO `tb_detail` VALUES ('201903280001', '1', '夏日清爽', '2', '芒果汽泡', '1', '13.00');
INSERT INTO `tb_detail` VALUES ('201903280001', '1', '夏日清爽', '4', '翠峰茉莉', '1', '10.00');
INSERT INTO `tb_detail` VALUES ('201903280002', '1', '夏日清爽', '8', '草莓气泡', '1', '12.00');
INSERT INTO `tb_detail` VALUES ('201903280002', '2', '冬日温暖', '3', '红糖枸杞', '1', '10.00');
INSERT INTO `tb_detail` VALUES ('201903280003', '1', '夏日清爽', '4', '翠峰茉莉', '1', '8.00');
INSERT INTO `tb_detail` VALUES ('201903280004', '1', '夏日清爽', '1', '柠檬汽泡', '1', '14.00');
INSERT INTO `tb_detail` VALUES ('201903280005', '1', '夏日清爽', '1', '柠檬汽泡', '1', '12.00');
INSERT INTO `tb_detail` VALUES ('201903280006', '1', '夏日清爽', '1', '柠檬汽泡', '1', '10.20');
INSERT INTO `tb_detail` VALUES ('201903280006', '1', '夏日清爽', '2', '芒果汽泡', '1', '11.10');
INSERT INTO `tb_detail` VALUES ('201903280006', '1', '夏日清爽', '8', '草莓气泡', '2', '20.40');
INSERT INTO `tb_detail` VALUES ('201903280006', '1', '夏日清爽', '9', '荔枝汽泡', '1', '8.50');
INSERT INTO `tb_detail` VALUES ('201903280007', '2', '冬日温暖', '26', '可乐煲姜', '2', '24.00');
INSERT INTO `tb_detail` VALUES ('201903280008', '2', '冬日温暖', '26', '可乐煲姜', '2', '16.00');
INSERT INTO `tb_detail` VALUES ('201903280009', '2', '冬日温暖', '26', '可乐煲姜', '10', '75.00');
INSERT INTO `tb_detail` VALUES ('201903280010', '2', '冬日温暖', '13', '巧克力', '10', '85.00');
INSERT INTO `tb_detail` VALUES ('201903280011', '1', '夏日清爽', '2', '芒果汽泡', '1', '13.00');
INSERT INTO `tb_detail` VALUES ('201903280012', '1', '夏日清爽', '2', '芒果汽泡', '1', '13.00');
INSERT INTO `tb_detail` VALUES ('201903280013', '1', '夏日清爽', '2', '芒果汽泡', '1', '9.90');
INSERT INTO `tb_detail` VALUES ('201903280014', '1', '夏日清爽', '1', '柠檬汽泡', '1', '10.20');
INSERT INTO `tb_detail` VALUES ('201903280014', '1', '夏日清爽', '2', '芒果汽泡', '1', '11.10');
INSERT INTO `tb_detail` VALUES ('201903280014', '1', '夏日清爽', '4', '翠峰茉莉', '1', '8.50');
INSERT INTO `tb_detail` VALUES ('201903280014', '1', '夏日清爽', '8', '草莓气泡', '1', '10.20');
INSERT INTO `tb_detail` VALUES ('201903280014', '1', '夏日清爽', '9', '荔枝汽泡', '1', '8.50');
INSERT INTO `tb_detail` VALUES ('201903280014', '2', '冬日温暖', '3', '红糖枸杞', '1', '8.50');

-- ----------------------------
-- Table structure for `tb_drink`
-- ----------------------------
DROP TABLE IF EXISTS `tb_drink`;
CREATE TABLE `tb_drink` (
  `d_id` int(11) NOT NULL AUTO_INCREMENT,
  `d_name` char(10) NOT NULL,
  `c_id` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `status` char(4) NOT NULL,
  PRIMARY KEY (`d_id`),
  KEY `d_id` (`d_id`),
  KEY `f_c` (`c_id`),
  KEY `name_uni` (`d_name`) USING BTREE,
  CONSTRAINT `f_c` FOREIGN KEY (`c_id`) REFERENCES `tb_category` (`c_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_drink
-- ----------------------------
INSERT INTO `tb_drink` VALUES ('1', '柠檬汽泡', '1', '12', '在售');
INSERT INTO `tb_drink` VALUES ('2', '芒果汽泡', '1', '20', '在售');
INSERT INTO `tb_drink` VALUES ('3', '红糖枸杞', '2', '10', '在售');
INSERT INTO `tb_drink` VALUES ('4', '翠峰茉莉', '1', '10', '在售');
INSERT INTO `tb_drink` VALUES ('5', '芝士莓莓', '1', '18', '停售');
INSERT INTO `tb_drink` VALUES ('8', '草莓气泡', '1', '12', '在售');
INSERT INTO `tb_drink` VALUES ('9', '荔枝汽泡', '1', '10', '在售');
INSERT INTO `tb_drink` VALUES ('10', '西瓜汽泡', '1', '10', '在售');
INSERT INTO `tb_drink` VALUES ('11', '布丁奶茶', '9', '12', '在售');
INSERT INTO `tb_drink` VALUES ('12', '百香果可乐', '1', '14', '在售');
INSERT INTO `tb_drink` VALUES ('13', '巧克力', '2', '10', '在售');
INSERT INTO `tb_drink` VALUES ('14', '拿铁咖啡', '4', '15', '在售');
INSERT INTO `tb_drink` VALUES ('15', '卡布奇诺', '4', '18', '在售');
INSERT INTO `tb_drink` VALUES ('16', '摩卡咖啡', '4', '14', '在售');
INSERT INTO `tb_drink` VALUES ('17', '现磨咖啡', '4', '14', '在售');
INSERT INTO `tb_drink` VALUES ('19', '丝滑奶茶', '9', '10', '在售');
INSERT INTO `tb_drink` VALUES ('20', '焦糖奶茶', '9', '10', '在售');
INSERT INTO `tb_drink` VALUES ('21', '草莓多多', '3', '18', '在售');
INSERT INTO `tb_drink` VALUES ('22', '鲜橙多多', '3', '14', '在售');
INSERT INTO `tb_drink` VALUES ('23', '巨峰葡萄', '3', '16', '在售');
INSERT INTO `tb_drink` VALUES ('24', '冰霜西瓜汁', '3', '12', '在售');
INSERT INTO `tb_drink` VALUES ('25', '柠檬百香果', '3', '12', '在售');
INSERT INTO `tb_drink` VALUES ('26', '可乐煲姜', '2', '10', '在售');
INSERT INTO `tb_drink` VALUES ('27', '草莓奶茶', '9', '12', '在售');
INSERT INTO `tb_drink` VALUES ('28', '珍珠奶茶', '9', '10', '在售');
INSERT INTO `tb_drink` VALUES ('32', '元气芒芒', '3', '10', '在售');
INSERT INTO `tb_drink` VALUES ('33', '柠乐', '1', '6', '在售');
INSERT INTO `tb_drink` VALUES ('39', '黑砖奶茶', '9', '12', '在售');
INSERT INTO `tb_drink` VALUES ('50', '皇冠奶茶', '9', '13', '在售');
INSERT INTO `tb_drink` VALUES ('60', '蛋糕奶茶', '9', '10', '移除');

-- ----------------------------
-- Table structure for `tb_employe`
-- ----------------------------
DROP TABLE IF EXISTS `tb_employe`;
CREATE TABLE `tb_employe` (
  `e_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(8) NOT NULL,
  `sex` char(2) NOT NULL,
  `user` char(10) NOT NULL,
  `passwd` char(10) NOT NULL,
  `status` char(4) NOT NULL,
  PRIMARY KEY (`e_id`),
  UNIQUE KEY `only` (`user`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_employe
-- ----------------------------
INSERT INTO `tb_employe` VALUES ('1', '钟某', '男', 'kb', '123456', '正常');
INSERT INTO `tb_employe` VALUES ('2', '钟', '男', 'zonk', '456789', '正常');
INSERT INTO `tb_employe` VALUES ('10', '老板', '男', 'admin', '123456', '正常');
INSERT INTO `tb_employe` VALUES ('11', '香', '男', 'sam', '456789', '正常');

-- ----------------------------
-- Table structure for `tb_member`
-- ----------------------------
DROP TABLE IF EXISTS `tb_member`;
CREATE TABLE `tb_member` (
  `m_id` char(11) NOT NULL,
  `name` char(4) NOT NULL,
  `sex` char(2) NOT NULL,
  `point` int(11) NOT NULL,
  PRIMARY KEY (`m_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_member
-- ----------------------------
INSERT INTO `tb_member` VALUES ('13751111111', '香', '男', '0');
INSERT INTO `tb_member` VALUES ('13751210777', '洪', '男', '2');
INSERT INTO `tb_member` VALUES ('13751210785', '范', '女', '14');
INSERT INTO `tb_member` VALUES ('13751210788', '钟', '男', '0');
INSERT INTO `tb_member` VALUES ('13751210789', '洪', '男', '33');
INSERT INTO `tb_member` VALUES ('13751211111', '小钟', '男', '10');
INSERT INTO `tb_member` VALUES ('15019065728', '曾', '女', '10');
INSERT INTO `tb_member` VALUES ('15625530202', '陈', '男', '8');
