/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost:3306
 Source Schema         : jeecg-boot

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : 65001

 Date: 14/04/2022 18:39:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for student_info
-- ----------------------------
DROP TABLE IF EXISTS `student_info`;
CREATE TABLE `student_info`  (
  `idcard` int(8) NOT NULL COMMENT '学号',
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '姓名',
  `gender` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '未知' COMMENT '性别',
  `grade` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '年级',
  `major` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '专业',
  `stucla` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '班级',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '电话',
  `fpath` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '照片路径',
  `isin` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '未知' COMMENT '在寝状态',
  PRIMARY KEY (`idcard`)
) ENGINE = InnoDB;



DROP TABLE IF EXISTS `student_face`;
CREATE TABLE `student_face`  (
  `idcard` int(8) NOT NULL COMMENT '学号',
  `face_id` varchar(31) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '人脸id',
  `face_feature` blob NULL COMMENT '人脸特征',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  FOREIGN KEY (`idcard`) REFERENCES `student_info` (`idcard`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB;



DROP TABLE IF EXISTS `student_backtime`;
CREATE TABLE `student_backtime`  (
  `idcard` int(8) NOT NULL COMMENT '学号',
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `backtime` timestamp(0) NULL DEFAULT NULL COMMENT '归寝时间',
  `backstatus` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '未知' COMMENT '归寝状态',
  FOREIGN KEY (`idcard`) REFERENCES `student_info` (`idcard`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB;



DROP TABLE IF EXISTS `student_outtime`;
CREATE TABLE `student_outtime`  (
  `idcard` int(8) NOT NULL COMMENT '学号',
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `outtime` timestamp(0) NULL DEFAULT NULL COMMENT '出寝时间',
  FOREIGN KEY (`idcard`) REFERENCES `student_info` (`idcard`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB;



DROP TABLE IF EXISTS `student_abnormal`;
CREATE TABLE `student_abnormal`  (
  `num` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `idcard` int(8) NOT NULL COMMENT '学号',
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '姓名',
  `grade` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '年级',
  `major` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '专业',
  `stucla` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '班级',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '电话',
  `abntime` timestamp(0) NULL DEFAULT NULL COMMENT '日期',
  PRIMARY KEY (`num`),
  FOREIGN KEY (`idcard`) REFERENCES `student_info` (`idcard`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1;
