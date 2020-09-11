/*
 Navicat Premium Data Transfer

 Source Server         : 149.28.213.252
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : 149.28.213.252:3306
 Source Schema         : time_manager

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 11/09/2020 16:50:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for label_info
-- ----------------------------
DROP TABLE IF EXISTS `label_info`;
CREATE TABLE `label_info`  (
  `label_info_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '称号详情id',
  `label_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '称号编码',
  `label_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '称号名字',
  `label_stat_exper` bigint(20) NOT NULL COMMENT '称号开始所需经验',
  `label_end_exper` bigint(20) NOT NULL COMMENT '称号结束所需经验',
  `create_by` bigint(20) NOT NULL,
  `create_time` datetime(0) NOT NULL,
  `modified_by` bigint(20) NOT NULL,
  `modified_time` datetime(0) NOT NULL,
  PRIMARY KEY (`label_info_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of label_info
-- ----------------------------

-- ----------------------------
-- Table structure for message_info
-- ----------------------------
DROP TABLE IF EXISTS `message_info`;
CREATE TABLE `message_info`  (
  `message_info_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '消息id',
  `message_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '消息类型',
  `message_value` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '消息值',
  `user_id` bigint(20) NULL DEFAULT NULL,
  `create_by` bigint(20) NOT NULL,
  `create_time` datetime(0) NOT NULL,
  `modified_by` bigint(20) NOT NULL,
  `modified_time` datetime(0) NOT NULL,
  PRIMARY KEY (`message_info_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of message_info
-- ----------------------------

-- ----------------------------
-- Table structure for plan_info
-- ----------------------------
DROP TABLE IF EXISTS `plan_info`;
CREATE TABLE `plan_info`  (
  `plan_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '计划id',
  `plan_status` tinyint(4) NULL DEFAULT NULL COMMENT '计划状态 1：未开始  2：进行中 3：未完成 4：已完成',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `plan_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '计划名字',
  `plan_type` tinyint(4) NOT NULL COMMENT '计划类型 1：一次  2.每日 3.工作日 4.非工作日',
  `plan_start_time` datetime(0) NOT NULL COMMENT '计划开始时间',
  `plan_end_time` datetime(0) NOT NULL COMMENT '计划结束时间',
  `plan_second` bigint(20) NOT NULL COMMENT '计划秒数',
  `create_by` bigint(20) NOT NULL,
  `create_time` datetime(0) NOT NULL,
  `modified_by` bigint(20) NOT NULL,
  `modified_time` datetime(0) NOT NULL,
  PRIMARY KEY (`plan_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of plan_info
-- ----------------------------
INSERT INTO `plan_info` VALUES (1, 1, 1, 'test', 1, '2020-09-10 17:37:42', '2020-09-24 17:37:44', 123, 1, '2020-09-10 17:37:56', 1, '2020-09-10 17:37:59');

-- ----------------------------
-- Table structure for plan_stat
-- ----------------------------
DROP TABLE IF EXISTS `plan_stat`;
CREATE TABLE `plan_stat`  (
  `plan_stat_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '计划统计id',
  `plan_id` bigint(20) NOT NULL COMMENT '计划id',
  `plan_fabulous` int(11) NOT NULL COMMENT '计划点赞',
  `plan_joins` int(11) NOT NULL COMMENT '计划参与数',
  `plan_join_user` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '计划参与用户（json格式   user_id集合 英文逗号隔开）',
  `create_by` bigint(20) NOT NULL,
  `create_time` datetime(0) NOT NULL,
  `modified_by` bigint(20) NOT NULL,
  `modified_time` datetime(0) NOT NULL,
  PRIMARY KEY (`plan_stat_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of plan_stat
-- ----------------------------
INSERT INTO `plan_stat` VALUES (1, 1, 0, 0, NULL, 1, '2020-09-10 17:38:21', 1, '2020-09-10 17:38:26');

-- ----------------------------
-- Table structure for sys_params
-- ----------------------------
DROP TABLE IF EXISTS `sys_params`;
CREATE TABLE `sys_params`  (
  `sys_params_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '系统参数id',
  `sys_params_key` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '系统参数key',
  `sys_params_value` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '系统参数value',
  `sys_params_extend` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '系统参数 扩展字段( json格式)',
  `create_by` bigint(20) NOT NULL,
  `create_time` datetime(0) NOT NULL,
  `modified_by` bigint(20) NOT NULL,
  `modified_time` datetime(0) NOT NULL,
  PRIMARY KEY (`sys_params_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_params
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `sys_user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '系统用户id',
  `sys_user_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '系统用户名字',
  `sys_user_password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '系统用户密码',
  `create_by` bigint(20) NOT NULL,
  `create_time` datetime(0) NOT NULL,
  `modified_by` bigint(20) NOT NULL,
  `modified_time` datetime(0) NOT NULL,
  PRIMARY KEY (`sys_user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------

-- ----------------------------
-- Table structure for user_exper
-- ----------------------------
DROP TABLE IF EXISTS `user_exper`;
CREATE TABLE `user_exper`  (
  `user_exper_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户经验表id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `label_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户称号',
  `user_exper` bigint(20) NOT NULL COMMENT '用户经验',
  `create_by` bigint(20) NOT NULL,
  `create_time` datetime(0) NOT NULL,
  `modified_by` bigint(20) NOT NULL,
  `modified_time` datetime(0) NOT NULL,
  PRIMARY KEY (`user_exper_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '经验和计划的秒数挂钩' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_exper
-- ----------------------------

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `user_password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `user_avatar` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '用户头像',
  `user_nickname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户昵称',
  `create_by` bigint(20) NOT NULL,
  `create_time` datetime(0) NOT NULL,
  `modified_by` bigint(20) NOT NULL,
  `modified_time` datetime(0) NOT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (1, 'admin', '123456', NULL, 'admin', 1, '2020-09-10 10:58:41', 1, '2020-09-10 10:58:45');

-- ----------------------------
-- Table structure for user_stat
-- ----------------------------
DROP TABLE IF EXISTS `user_stat`;
CREATE TABLE `user_stat`  (
  `user_stat_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户统计id',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `plan_total` int(11) NULL DEFAULT NULL COMMENT '发起计划总数',
  `plan_finish` int(11) NULL DEFAULT NULL COMMENT '计划完成总数',
  `plan_fabulous` int(11) NULL DEFAULT NULL COMMENT '计划点赞总数',
  `create_by` bigint(20) NOT NULL,
  `create_time` datetime(0) NOT NULL,
  `modified_by` bigint(20) NOT NULL,
  `modified_time` datetime(0) NOT NULL,
  PRIMARY KEY (`user_stat_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_stat
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
