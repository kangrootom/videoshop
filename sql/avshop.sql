/*
Navicat MySQL Data Transfer

Source Server         : con_1
Source Server Version : 50519
Source Host           : localhost:3306
Source Database       : avshop

Target Server Type    : MYSQL
Target Server Version : 50519
File Encoding         : 65001

Date: 2018-09-01 19:39:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `avshop`
-- ----------------------------
CREATE DATABASE `avshop`;
USE `avshop`;
DROP TABLE IF EXISTS `avshop`;
CREATE TABLE `avshop` (
  `avid` int(11) NOT NULL AUTO_INCREMENT,
  `avname` varchar(100) DEFAULT NULL,
  `avtitle` varchar(100) NOT NULL DEFAULT '钢铁侠',
  `avdesc` text NOT NULL,
  `avcreatetime` datetime DEFAULT NULL,
  `avimgsrc` varchar(100) NOT NULL,
  `avvideosrc` varchar(100) NOT NULL,
  `avstatus` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`avid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of avshop
-- ----------------------------
INSERT INTO `avshop`(avname,avtitle,avdesc,avcreatetime,avimgsrc,avvideosrc,avstatus) VALUES ('电影', '屌丝男士', '屌丝爱看的电影 ', '2016-05-01 22:31:20', 'img/1.jpg', '/video/av01.mp4', '1');
INSERT INTO `avshop`(avname,avtitle,avdesc,avcreatetime,avimgsrc,avvideosrc,avstatus) VALUES ('电影', '屌丝男士', '屌丝爱看的电影 ', '2016-05-01 22:31:20', 'img/2.jpg', '/video/av02.mp4', '1');
INSERT INTO `avshop`(avname,avtitle,avdesc,avcreatetime,avimgsrc,avvideosrc,avstatus) VALUES ('电影', '屌丝男士', '屌丝爱看的电影 ', '2016-05-01 22:31:20', 'img/3.jpg', '/video/av03.mp4', '1');
INSERT INTO `avshop`(avname,avtitle,avdesc,avcreatetime,avimgsrc,avvideosrc,avstatus) VALUES ('电影', '屌丝男士', '屌丝爱看的电影 ', '2016-05-01 22:31:20', 'img/4.jpg', '/video/av04.mp4', '1');
INSERT INTO `avshop`(avname,avtitle,avdesc,avcreatetime,avimgsrc,avvideosrc,avstatus) VALUES ('电影', '屌丝男士', '屌丝爱看的电影 ', '2016-05-01 22:31:20', 'img/5.jpg', '/video/av05.mp4', '1');
INSERT INTO `avshop`(avname,avtitle,avdesc,avcreatetime,avimgsrc,avvideosrc,avstatus) VALUES ('电影', '屌丝男士', '屌丝爱看的电影 ', '2016-05-01 22:31:20', 'img/6.jpg', '/video/av06.mp4', '1');
INSERT INTO `avshop`(avname,avtitle,avdesc,avcreatetime,avimgsrc,avvideosrc,avstatus) VALUES ('电影', '屌丝男士', '屌丝爱看的电影 ', '2016-05-01 22:31:20', 'img/7.jpg', '/video/av07.mp4', '1');
INSERT INTO `avshop`(avname,avtitle,avdesc,avcreatetime,avimgsrc,avvideosrc,avstatus) VALUES ('电影', '屌丝男士', '屌丝爱看的电影 ', '2016-05-01 22:31:20', 'img/8.jpg', '/video/av08.mp4', '1');
INSERT INTO `avshop`(avname,avtitle,avdesc,avcreatetime,avimgsrc,avvideosrc,avstatus) VALUES ('电影', '屌丝男士', '屌丝爱看的电影 ', '2016-05-01 22:31:20', 'img/9.jpg', '/video/av09.mp4', '1');
INSERT INTO `avshop`(avname,avtitle,avdesc,avcreatetime,avimgsrc,avvideosrc,avstatus) VALUES ('电影', '屌丝男士', '屌丝爱看的电影 ', '2016-05-01 22:31:20', 'img/10.jpg', '/video/av10.mp4', '1');
INSERT INTO `avshop`(avname,avtitle,avdesc,avcreatetime,avimgsrc,avvideosrc,avstatus) VALUES ('电影', '屌丝男士', '屌丝爱看的电影 ', '2016-05-01 22:31:20', 'img/11.jpg', '/video/av011.mp4', '1');
INSERT INTO `avshop`(avname,avtitle,avdesc,avcreatetime,avimgsrc,avvideosrc,avstatus) VALUES ('电影', '屌丝男士', '屌丝爱看的电影 ', '2016-05-01 22:31:20', 'img/12.jpg', '/video/av12.mp4', '1');
