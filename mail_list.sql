/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : mail_list

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 19/09/2020 17:01:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for classes
-- ----------------------------
DROP TABLE IF EXISTS `classes`;
CREATE TABLE `classes`  (
  `classes_id` int(0) NOT NULL COMMENT '班级id',
  `classes_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '班级名称',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '班级描述',
  PRIMARY KEY (`classes_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of classes
-- ----------------------------
INSERT INTO `classes` VALUES (1, '一班', NULL);
INSERT INTO `classes` VALUES (2, '二班', NULL);
INSERT INTO `classes` VALUES (3, '三班', NULL);
INSERT INTO `classes` VALUES (4, '四班', NULL);
INSERT INTO `classes` VALUES (5, '五班', NULL);

-- ----------------------------
-- Table structure for specialities
-- ----------------------------
DROP TABLE IF EXISTS `specialities`;
CREATE TABLE `specialities`  (
  `specialities_id` int(0) NOT NULL COMMENT '专业id',
  `specialities_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '专业名称',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`specialities_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of specialities
-- ----------------------------
INSERT INTO `specialities` VALUES (1, '软件工程', NULL);
INSERT INTO `specialities` VALUES (2, '网络工程', NULL);
INSERT INTO `specialities` VALUES (3, '可视化技术', NULL);
INSERT INTO `specialities` VALUES (4, '卓越班', NULL);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `student_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '学生id',
  `student_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '学号',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `student_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '学生姓名',
  `student_tele` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '学生电话',
  `student_email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '学生邮箱',
  `specialities_id` int(0) NOT NULL COMMENT '专业id',
  `grade` bigint(0) NOT NULL COMMENT '届',
  `classes` int(0) NOT NULL COMMENT '班级',
  `city` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '所在城市',
  `company` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '所在公司',
  `enable_flag` int(0) NOT NULL DEFAULT 0 COMMENT '启用标识，默认为0未启用',
  `login_number` int(0) NOT NULL DEFAULT 0 COMMENT '登录次数',
  `last_login` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后一次登陆时间',
  PRIMARY KEY (`student_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, '5601117056', '1431881135', '李帅', '13870985025', '5601117056@email.ncu.edu.cn', 1, 2017, 1, '上海', '这是修改字段', 1, 16, '2020-09-19 16:34:48');
INSERT INTO `student` VALUES (9, '6109117208', '6109117208', '彭瀚林', '15717093862', '15717093862@qq.com', 1, 2017, 4, '深圳', '阿里', 1, 0, '2020-09-19 13:22:42');
INSERT INTO `student` VALUES (10, '6109117209', '6109117209', '汪晨旭', '15717093862', '15717093862@qq.com', 1, 2017, 2, '南昌', NULL, 1, 0, '2020-09-19 13:22:43');
INSERT INTO `student` VALUES (11, '8002117305', '8002117305', '刘家成', '13879133091', '13879133091@qq.com', 1, 2017, 3, '抚州', NULL, 1, 0, '2020-09-19 13:22:43');
INSERT INTO `student` VALUES (12, '8002117220', '8002117220', '彭奕涛', '18770910526', '18770910526@qq.com', 1, 2020, 4, '南昌', NULL, 1, 0, '2020-09-19 13:22:43');
INSERT INTO `student` VALUES (13, '6109117079', '6109117079', '赖振辉', '18507091908', '18507091908@qq.com', 1, 2017, 1, '深圳', '腾讯', 1, 0, '2020-09-19 12:13:11');
INSERT INTO `student` VALUES (14, '6109117207', '6109117207', '陈以源', '13576269357', '13576269357@qq.com', 1, 2017, 1, '南昌', NULL, 1, 0, '2020-09-19 12:13:13');
INSERT INTO `student` VALUES (15, '6109117103', '6109117103', '黄兆俊', '18970927608', '18970927608@qq.com', 1, 2017, 1, '南昌', NULL, 1, 0, '2020-09-19 12:13:14');
INSERT INTO `student` VALUES (16, '6109117214', '6109117214', '黄锵锵', '17370837613', '17370837613@qq.com', 1, 2017, 1, '深圳', NULL, 1, 0, '2020-09-19 12:13:16');
INSERT INTO `student` VALUES (17, '6109117191', '6109117191', '刘鑫恺', '17370837231', '17370837231@qq.com', 1, 2017, 1, '吉安', NULL, 1, 0, '2020-09-19 12:13:18');
INSERT INTO `student` VALUES (18, '6109117212', '6109117212', '何一凡', '13870860414', '13870860414@qq.com', 1, 2017, 1, '汉中', NULL, 1, 0, '2020-09-19 12:13:20');
INSERT INTO `student` VALUES (19, '6109117056', '6109117056', '敖俊', '17370838281', '17370838281@qq.com', 1, 2017, 2, '萍乡', NULL, 1, 0, '2020-09-19 13:22:43');
INSERT INTO `student` VALUES (20, '6109117009', '6109117009', '蓝茜', '18070595868', '18070595868@qq.com', 1, 2017, 2, '南平', NULL, 1, 0, '2020-09-19 13:22:43');
INSERT INTO `student` VALUES (21, '6109117121', '6109117121', '冯所葳', '13767405474', '13767405474@qq/com', 1, 2017, 2, '文昌', NULL, 1, 0, '2020-09-19 13:22:43');
INSERT INTO `student` VALUES (22, '6109117169', '6109117169', '曾辉', '17707066364', '17707066364@qq.com', 1, 2020, 2, '吉安', NULL, 1, 0, '2020-09-19 13:22:43');
INSERT INTO `student` VALUES (23, '6109117059', '6109117059', '管德钧', '15170633528', '15170633528@qq.com', 1, 2017, 2, '赣州', NULL, 1, 0, '2020-09-19 13:23:01');
INSERT INTO `student` VALUES (24, '6109117099', '6109117099', '邵琦', '13870995227', '13870995227@qq.com', 1, 2017, 2, '宜春', NULL, 1, 0, '2020-09-19 13:23:01');
INSERT INTO `student` VALUES (25, '6109117100', '6109117100', '涂会超', '13647000562', '13647000562@qq.com', 1, 2017, 2, '宁波', NULL, 1, 0, '2020-09-19 13:23:01');
INSERT INTO `student` VALUES (26, '6109117155', '6109117155', '刘瑾瑶', '17370838175', '17370838175@qq.com', 1, 2017, 2, '贵阳', NULL, 1, 0, '2020-09-19 13:23:01');
INSERT INTO `student` VALUES (27, '8003117031', '8003117031', '文宇轩', '15979135791', '15979135791@qq.com', 1, 2017, 2, '南昌', NULL, 1, 0, '2020-09-19 16:38:40');
INSERT INTO `student` VALUES (28, '6109117228', '6109117228', '田亮海', '18379982711', '18379982711@qq.com', 2, 2018, 3, '南昌', NULL, 1, 0, '2020-09-19 16:38:41');
INSERT INTO `student` VALUES (29, '6109117202', '6109117202', '吴继登', '13767429384', '13767429384@qq.com', 2, 2018, 3, '达州', NULL, 1, 0, '2020-09-19 16:38:41');
INSERT INTO `student` VALUES (30, '6105117043', '6105117043', '黄金秀', '17370838559', '17370838559@qq.com', 2, 2018, 3, '深圳', NULL, 0, 0, NULL);
INSERT INTO `student` VALUES (32, '5701117147', '5701117147', '张佳辰', '18016708265', '18016708265@qq.com', 1, 2017, 1, '泉州', NULL, 0, 0, NULL);
INSERT INTO `student` VALUES (33, '5601117071', '5601117071', '黄嘉祥', '13879113316', '13879113316@qq.com', 2, 2018, 3, '平顶山', NULL, 1, 0, '2020-09-19 13:23:10');
INSERT INTO `student` VALUES (34, '7904117029', '7904117029', '宋中正', '13870883151', '13870883151@qq.com', 1, 2020, 2, '南昌', NULL, 0, 0, NULL);

SET FOREIGN_KEY_CHECKS = 1;
