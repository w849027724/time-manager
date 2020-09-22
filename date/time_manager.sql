/*
 Navicat Premium Data Transfer

 Source Server         : 124.70.40.151
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : 124.70.40.151:3306
 Source Schema         : time_manager

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 22/09/2020 18:31:02
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
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of label_info
-- ----------------------------
INSERT INTO `label_info` VALUES (1, '1', 'LV1.时间菜鸟', 0, 100, 1, '2020-09-16 16:49:14', 1, '2020-09-16 16:49:18');
INSERT INTO `label_info` VALUES (2, '2', 'LV2.时间新手', 100, 10000000, 1, '2020-09-16 17:07:30', 1, '2020-09-16 17:07:33');

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
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of message_info
-- ----------------------------

-- ----------------------------
-- Table structure for plan_info
-- ----------------------------
DROP TABLE IF EXISTS `plan_info`;
CREATE TABLE `plan_info`  (
  `plan_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '计划id',
  `plan_status` tinyint(4) NULL DEFAULT NULL COMMENT '计划状态 0：未开始  1：已完成',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `plan_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '计划名字',
  `plan_type` tinyint(4) NOT NULL COMMENT '计划类型 0：打卡  2：计时 3：限时',
  `plan_frequency_type` tinyint(4) NULL DEFAULT NULL COMMENT '计划频次类型  0：一次  1.每日  2.自定义',
  `plan_frequency_days` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '计划频次日期 星期1-星期7',
  `plan_time` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '计划时间',
  `plan_start_time` datetime(0) NULL DEFAULT NULL COMMENT '计划开始时间',
  `plan_end_time` datetime(0) NOT NULL COMMENT '计划结束时间',
  `plan_second` bigint(20) NOT NULL COMMENT '计划秒数',
  `plan_times` bigint(20) NULL DEFAULT NULL COMMENT '计划完成次数',
  `plan_top` tinyint(4) NULL DEFAULT NULL COMMENT '置顶计划  0：不是  1：是',
  `remarks` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_by` bigint(20) NOT NULL,
  `create_time` datetime(0) NOT NULL,
  `modified_by` bigint(20) NOT NULL,
  `modified_time` datetime(0) NOT NULL,
  PRIMARY KEY (`plan_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of plan_info
-- ----------------------------
INSERT INTO `plan_info` VALUES (3, 0, 2, '打卡', 0, 0, '', '00:00', '2020-09-22 00:00:00', '2020-09-22 00:00:00', 0, 0, 0, '打卡', 0, '2020-09-22 17:51:37', 0, '2020-09-22 17:51:37');
INSERT INTO `plan_info` VALUES (4, 0, 2, '计时', 1, 0, '', '05:00', '2020-09-22 00:00:00', '2020-09-22 00:00:00', 1800, 0, 0, '计时', 0, '2020-09-22 17:52:45', 0, '2020-09-22 17:52:45');
INSERT INTO `plan_info` VALUES (5, 0, 2, '长计划', 2, 0, '', '00:00', '2020-09-22 00:00:00', '2020-09-27 00:00:00', 0, 0, 1, '长计划', 0, '2020-09-22 17:54:40', 0, '2020-09-22 17:54:40');

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
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of plan_stat
-- ----------------------------
INSERT INTO `plan_stat` VALUES (33, 3, 0, 0, NULL, 0, '2020-09-22 17:51:50', 0, '2020-09-22 17:51:50');
INSERT INTO `plan_stat` VALUES (34, 4, 0, 0, NULL, 0, '2020-09-22 17:52:50', 0, '2020-09-22 17:52:50');
INSERT INTO `plan_stat` VALUES (35, 5, 0, 0, NULL, 0, '2020-09-22 17:54:40', 0, '2020-09-22 17:54:40');

-- ----------------------------
-- Table structure for plan_user_day
-- ----------------------------
DROP TABLE IF EXISTS `plan_user_day`;
CREATE TABLE `plan_user_day`  (
  `plan_user_day_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户每日计划',
  `plan_id` bigint(20) NOT NULL COMMENT '计划id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `plan_day` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '日期  yyyy-MM-dd',
  `plan_day_status` tinyint(4) NOT NULL COMMENT '计划状态 1：未开始  2：进行中 3：未完成 4：已完成',
  `start_time` datetime(0) NULL DEFAULT NULL COMMENT '开始时间  hh:mm:ss',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '结束时间 hh:mm:ss',
  `finish_day` tinyint(4) NULL DEFAULT NULL COMMENT '完成时间',
  `last_day` tinyint(4) NULL DEFAULT NULL COMMENT '剩余时间',
  `create_by` bigint(20) NOT NULL,
  `create_time` datetime(0) NOT NULL,
  `modified_by` bigint(20) NOT NULL,
  `modified_time` datetime(0) NOT NULL,
  PRIMARY KEY (`plan_user_day_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户每日的计划列表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of plan_user_day
-- ----------------------------
INSERT INTO `plan_user_day` VALUES (5, 3, 2, '2020-09-22', 0, NULL, NULL, NULL, NULL, 0, '2020-09-22 17:51:50', 0, '2020-09-22 17:51:50');
INSERT INTO `plan_user_day` VALUES (6, 4, 2, '2020-09-22', 0, NULL, NULL, NULL, NULL, 0, '2020-09-22 17:52:50', 0, '2020-09-22 17:52:50');
INSERT INTO `plan_user_day` VALUES (7, 5, 2, '2020-09-22', 0, NULL, NULL, 0, 4, 0, '2020-09-22 17:54:41', 0, '2020-09-22 17:54:41');

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
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

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
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

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
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '经验和计划的秒数挂钩' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user_exper
-- ----------------------------
INSERT INTO `user_exper` VALUES (1, 2, '2', 8619, 0, '2020-09-11 17:47:13', 0, '2020-09-11 17:47:13');
INSERT INTO `user_exper` VALUES (2, 3, '1', 0, 0, '2020-09-11 17:47:56', 0, '2020-09-11 17:47:56');
INSERT INTO `user_exper` VALUES (3, 4, '1', 5400, 0, '2020-09-17 12:43:10', 0, '2020-09-17 12:43:10');
INSERT INTO `user_exper` VALUES (4, 5, '1', 0, 0, '2020-09-17 12:49:04', 0, '2020-09-17 12:49:04');
INSERT INTO `user_exper` VALUES (6, 7, '1', 0, 0, '2020-09-17 16:13:55', 0, '2020-09-17 16:13:55');

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
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (2, 'aaa', 'aaa', ' ', '摩登猪头', 0, '2020-09-11 17:46:59', 0, '2020-09-11 17:46:59');
INSERT INTO `user_info` VALUES (3, 'bbb', 'bbb', ' ', 'bbb', 0, '2020-09-11 17:47:53', 0, '2020-09-11 17:47:53');
INSERT INTO `user_info` VALUES (4, '123456', '123456', '', '123456', 0, '2020-09-17 12:43:10', 0, '2020-09-17 12:43:10');
INSERT INTO `user_info` VALUES (5, 'zl', '123456', '', '123456', 0, '2020-09-17 12:49:04', 0, '2020-09-17 12:49:04');
INSERT INTO `user_info` VALUES (7, '1234', '12345678', '', '12', 0, '2020-09-17 16:13:54', 0, '2020-09-17 16:13:54');

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
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user_stat
-- ----------------------------
INSERT INTO `user_stat` VALUES (1, 2, 35, 30, 28, 0, '2020-09-11 17:47:20', 0, '2020-09-11 17:47:20');
INSERT INTO `user_stat` VALUES (2, 3, 222, 3432, 222, 0, '2020-09-11 17:47:56', 0, '2020-09-11 17:47:56');
INSERT INTO `user_stat` VALUES (3, 4, 1, 0, 0, 0, '2020-09-17 12:43:10', 0, '2020-09-17 12:43:10');
INSERT INTO `user_stat` VALUES (4, 5, 4, 0, 29, 0, '2020-09-17 12:49:04', 0, '2020-09-17 12:49:04');
INSERT INTO `user_stat` VALUES (6, 7, 0, 0, 0, 0, '2020-09-17 16:13:55', 0, '2020-09-17 16:13:55');

SET FOREIGN_KEY_CHECKS = 1;
