/*
 Navicat Premium Data Transfer

 Source Server         : Local
 Source Server Type    : MySQL
 Source Server Version : 50520
 Source Host           : localhost:3306
 Source Schema         : ttmsnew

 Target Server Type    : MySQL
 Target Server Version : 50520
 File Encoding         : 65001

 Date: 20/01/2021 12:05:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`  (
  `cus_id` int(11) NOT NULL AUTO_INCREMENT,
  `cus_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `cus_gender` smallint(6) DEFAULT 1 COMMENT '˵����\r\n            0 Ů\r\n            1 ��',
  `cus_telnum` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `cus_email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `cus_uid` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `cus_pwd` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '��½����',
  `cus_status` smallint(6) DEFAULT 1 COMMENT '˵����\r\n            0������\r\n            1������',
  `cus_balance` decimal(10, 0) DEFAULT 1000 COMMENT '�˻����',
  `cus_paypwd` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '֧������',
  PRIMARY KEY (`cus_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for data_dict
-- ----------------------------
DROP TABLE IF EXISTS `data_dict`;
CREATE TABLE `data_dict`  (
  `dict_id` int(11) NOT NULL AUTO_INCREMENT,
  `super_dict_id` int(11) DEFAULT NULL COMMENT '��id',
  `dict_index` int(11) DEFAULT NULL COMMENT 'ͬ��˳��',
  `dict_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `dict_value` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`dict_id`) USING BTREE,
  INDEX `FK_super_child_dict`(`super_dict_id`) USING BTREE,
  CONSTRAINT `FK_super_child_dict` FOREIGN KEY (`super_dict_id`) REFERENCES `data_dict` (`dict_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of data_dict
-- ----------------------------
INSERT INTO `data_dict` VALUES (1, NULL, 1, '�����ֵ�', '��');
INSERT INTO `data_dict` VALUES (2, 1, 1, 'PLAYTYPE', 'ӰƬ����');
INSERT INTO `data_dict` VALUES (3, 1, 2, 'PLAYLANG', 'ӰƬ����');
INSERT INTO `data_dict` VALUES (4, 1, 3, '��ʧЧʱ��', '10');
INSERT INTO `data_dict` VALUES (5, 2, 1, 'History', '��ʷ');
INSERT INTO `data_dict` VALUES (6, 2, 2, 'Anime', '����');
INSERT INTO `data_dict` VALUES (7, 2, 3, 'Drama', '����');
INSERT INTO `data_dict` VALUES (8, 2, 4, 'Horror', '�ֲ�');
INSERT INTO `data_dict` VALUES (9, 2, 5, 'War', 'ս��');
INSERT INTO `data_dict` VALUES (10, 2, 6, 'Sci-Fi', '�ƻ�');
INSERT INTO `data_dict` VALUES (11, 2, 7, 'Romance', '����');
INSERT INTO `data_dict` VALUES (12, 2, 8, 'Comedy', 'ϲ��');
INSERT INTO `data_dict` VALUES (13, 2, 9, 'Action', '����');
INSERT INTO `data_dict` VALUES (14, 3, 1, 'Chinese', '����');
INSERT INTO `data_dict` VALUES (15, 3, 2, 'English', 'Ӣ��');
INSERT INTO `data_dict` VALUES (16, 3, 3, 'Japanese', '����');
INSERT INTO `data_dict` VALUES (17, 3, 4, 'Korean', '����');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `emp_id` int(11) NOT NULL AUTO_INCREMENT,
  `dict_id` int(11) DEFAULT NULL,
  `emp_no` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `emp_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `emp_gender` smallint(6) DEFAULT 1 COMMENT '˵����\r\n            0��Ů\r\n            1����',
  `emp_telnum` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `emp_email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `emp_pwd` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `emp_status` smallint(6) DEFAULT 1 COMMENT '˵����\r\n            0������\r\n            1������',
  PRIMARY KEY (`emp_id`) USING BTREE,
  INDEX `FK_emp_position`(`dict_id`) USING BTREE,
  CONSTRAINT `FK_emp_position` FOREIGN KEY (`dict_id`) REFERENCES `data_dict` (`dict_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for play
-- ----------------------------
DROP TABLE IF EXISTS `play`;
CREATE TABLE `play`  (
  `play_id` int(11) NOT NULL AUTO_INCREMENT,
  `dict_type_id` int(11) DEFAULT NULL,
  `dict_lang_id` int(11) DEFAULT NULL,
  `play_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `play_introduction` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `play_image` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `play_video` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `play_length` int(11) DEFAULT NULL,
  `play_ticket_price` decimal(10, 2) DEFAULT NULL,
  `play_status` smallint(6) DEFAULT NULL COMMENT 'ȡֵ���壺\r\n            0���������ݳ�\r\n            1���Ѱ����ݳ�\r\n            -1������',
  PRIMARY KEY (`play_id`) USING BTREE,
  INDEX `FK_dict_lan_play`(`dict_lang_id`) USING BTREE,
  INDEX `FK_dict_type_play`(`dict_type_id`) USING BTREE,
  CONSTRAINT `FK_dict_lan_play` FOREIGN KEY (`dict_lang_id`) REFERENCES `data_dict` (`dict_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_dict_type_play` FOREIGN KEY (`dict_type_id`) REFERENCES `data_dict` (`dict_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of play
-- ----------------------------
INSERT INTO `play` VALUES (1, 7, 14, '�Һ��ҵļ���', '��Ӱ���Һ��ҵļ��硷����2020����죬�������Һ��ҵ���������崴���ķ�ʽ��������ı�����ܼ��ƣ����Ƶ����ܵ��ݣ���һ�׵����ܲ߻������ơ���ῡ���˼�ϡ��Ʒ�&���ħ���˳�&���ü�ֱ�ִ��������¡�', 'images/property/1.jpg', NULL, 120, 35.00, 0);
INSERT INTO `play` VALUES (2, 7, 14, '�ߺŷ�������', '��7�ŷ������\r\n���������ִ�����������������¡�֣���������Żݵ����ݵ�ϲ���Ӱ��ӰƬ���������ܲ���֮ԩ�����������ú�Ϊ�˸�����ϴȥԩ������иŬ����Ů��֮��Ĺ��¡���Ƭ��2013��1��23���ں�����ӳ������Ϊ2013�꺫����ӰƱ��������һ��\r\n\r\n1997�ֻ꣬��6���ͯ���̵����������������(12��)���ã��������Σ��Ϳɰ���Ů����ʤ���������Σ�����Ϊ����������Ȼ����ƶ��ȴ�����Ҹ���ĳ�죬ִ��ΪŮ��������Ůսʿ����������������һ����ͯ�չռ�ɱ���������߾��Ǿ���ֳ���Ů���������¶���֪���㲻��״������ͷ���Ծͱ�Ͷ���������7���η��У��ۼ�����˽������ơ�թƭ���޴��ơ�ͨ�鷸���򷶡����ŷ���������ٷ����ֲ���嶾��ȫ�ġ�������ҡ������ú��Ӱ㴿����Ľ����ж����⼸�����󻵵���������������ϧð�ս���ʤ�����η��븸����ᡣ�ڰ�����ļ����ڣ�7���η�����������', 'images/property/5.jpg', NULL, 108, 30.00, 0);
INSERT INTO `play` VALUES (3, 9, 14, '�����', '���������\r\n��һ����Ե�������Ӱ���Ļ���ý(����)��˾����ѩ�Ļ�ͶӰ�����޹�˾���ϳ�Ʒ��Է����ִ������ῡ��պ졢���ة�����������ݵĵ�Ӱ��������������й��������˼��뿹������,���վ�չ������ս��Ϊ�������ߡ���Ҫ�����˿�սʱ�ڣ�������ɽ��������Ϊ��С�ң�Ϊ�˹��ҷ�����Ӣ��ɱ�У�Ϊ�ڻ����������ܲ����ˣ���ǿ����վ�����д���춯�ؿ���ʷʫ�Ĺ��¡���������������ʮ����ʿС��ɽ���ս���͡�����Ӫ���ս����ԭ�͹��£�ƽ���ӽǵĶ������˿��գ�ǿ��ڡ�����ת�����������\r\n\r\n����������Զ�����������Ϊʷ��,���й�����ս��������ʤ��������һ��ս�ۡ�������ʿɽս�ۡ�ΪԨԴ,��Ҫ�����˿�սʱ��,����ɽҰ���˷����վȹ�,���¾�ս�ܺ����˷�ɽ������������,����д���춯�ؿ���ʷʫ�Ĺ��¡� [1] ��Ը������ū��������,1937���ڿ����ĸ����¼����˿��������վȹ�����,��Ϊ����,���վ����Ƕ��¡�1938���վ���ı���ַ�,���˳����ʮ����սʿ������ȫ���������,Ϊ�����ܲ�ͻΧ��Ⱥ��ת��Ӯ�ñ���ʱ�䡣', 'images/property/6.jpg', NULL, 125, 33.00, 0);
INSERT INTO `play` VALUES (4, 7, 14, 'ϲ��', '��ϲ����\r\n��ϲ�������ɱ����չⶦʢӰ���Ļ����޹�˾����������Ӱ���Ļ����޹�˾��Ʒ����Ʒ��������ִ�������ɽࡢ�Ź������ݡ���Ƭ�����������������ԭ��ͬ��С˵�ı�ĵ�Ӱ�������˳ɼ����쵫�Ҿ�ƶ���Ľ���ѧ����ϲ���ڷɻ�����ʶ�˸���Ů�ôϻۣ��˺���Ǳ��丸�׺��ֳ�׷���������丸�ô���չ��һ�����飬����Ҳ��˳��׸ı�Ĺ��¡�\r\n\r\nϲ�������ɽ��Σ����ͥ������ֹ��Ӣ��ѧҵ���ع��ڣ��ڷɻ��Ͻ�ʶ�˵����ɰ��ĸ���ǧ���ôϻۣ������� �Σ����ع����Ⱥ�������ĸ�׹�������δ�����ĸ���������ҪǮ�ƣ��������ϳ��޼ҿɹ顣�üҰ���ϲ��������������ͬʱϲ��Ҳ�����ü����˵ĸ������С�������Ҫ�ܶ�ܶమ��ϲ������Ȼӵ����ѡ��ܶ�ܶ�Ǯ�Ļ��ᣬ�����ϲ���ܷ����װ�������С���', 'images/property/8.jpg', NULL, 153, 42.00, 0);
INSERT INTO `play` VALUES (5, 6, 14, '������', '������Ӱ�����������Ĺ��·����ڷ����ս�󡣽�����������������Ӯ�÷����սʤ������Ϊ���Ի������䰲����Ȼ����һ�в�δ������һ��żȻ��������������ԭ���������ս��֮�������Ÿ������ı����������ʼ̤��̽Ѱ�������;......', 'images/property/2.jpg', NULL, 110, 40.00, 0);
INSERT INTO `play` VALUES (6, 7, 14, '���', '2008��8��15�գ��������˻�Ů�ű������й�VS���������Ž�˿���۾�����ƽ������ �Σ����������ӽ���ϯ�ϣ��������ȣ�Ŀ����磻�й��ӽ������Һͣ��Ʋ� �Σ�վ�ڳ��ߣ�ȫ���ע�����Ц�ݡ����Һ�������ƽ��Ŀ��������⣬���Ͼ�������Ӱ�ڱ����������ߣ��й�Ů����ʮ����ĳ���ͼ���������򿪡���', 'images/property/3.jpg', NULL, 135, 38.00, 0);
INSERT INTO `play` VALUES (7, 7, 14, 'һ��͵���', '��һ��͵��ҡ�\r\n���ɳ¿������ƣ������ִ�������Ȼ�����ų������P�������ݵ�ũ�����ϲ��Ƭ����Ƭ�����������Ը�����������˴Ӵ���лص�����ǧ���կ������ҵ�ó̵Ĺ��¡�\r\n\r\nκ���������Ȼ �Σ�������������ų� �Σ�������Ⱥ�����P �Σ������Ը�����������˴Ӵ���лص�����ǧ���կ����Ե�ɺ��ºϻ�ɵ��̡�����������������·��һ�ļ���Я�ֿ�����ҵ֮�ã����������˵������磬�������ǰѳ�����Ķ�������ũ������Ҳ��Ҫ��ũ��Ķ�������ȥ�����կ������롱����������ϸı��������ˣ�������һ�δ����һĵ��Ĵ�ҵ�ó̡�', 'images/property/7.jpg', NULL, 147, 35.00, 0);
INSERT INTO `play` VALUES (8, 13, 14, '���ȷ�', '�й������ع�����Ӣ�������Ӷ����֯�������ǡ���ܣ��ص�Ů��Fareeda�������� �Σ�Ҳ�������У��⵽׷ɱ��ǧ��һ��֮�ʣ����ȷ���ʰ����Ŷӳ�Ϊ����Ψһ��ϣ��������ָ���ƻ�ͥ�������Σ���������������Σ����ſ����������Σ������ţ�ĸ�������Σ����������͢�Σ�����ɵļ��ȷ��ж�С�飬������أ�շתȫ�����ʩչ����Ӫ�ȡ�������ʵĹ����У������֡������ǡ�����ķ��Ｏ�Ż��߻���һ��������ı����', 'images/property/4.jpg', NULL, 108, 36.00, 0);
INSERT INTO `play` VALUES (9, 7, 14, '\r\n����ʱ�価ͷ����', '�ָ������ �Σ�һ�δ�����ʱ�գ�ֻΪ��������ٻ����һͩ �Σ��ٴ�������һ��ֻ��һ���ˣ�ϣ����ͷ���㣬��βҲ���㡣2020����Ϧ������ĸ��: ����ʱ�価ͷ���㡣', 'images/property/9.jpg', NULL, 115, 37.00, 0);

-- ----------------------------
-- Table structure for resource
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource`  (
  `res_id` int(11) NOT NULL AUTO_INCREMENT,
  `res_parent` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `res_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `res_URL` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`res_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for role_resource
-- ----------------------------
DROP TABLE IF EXISTS `role_resource`;
CREATE TABLE `role_resource`  (
  `role_res_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `res_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`role_res_id`) USING BTREE,
  INDEX `FK_res_role`(`res_id`) USING BTREE,
  INDEX `FK_role_resource`(`role_id`) USING BTREE,
  CONSTRAINT `FK_res_role` FOREIGN KEY (`res_id`) REFERENCES `resource` (`res_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_role_resource` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles`  (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sale
-- ----------------------------
DROP TABLE IF EXISTS `sale`;
CREATE TABLE `sale`  (
  `sale_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `emp_id` int(11) DEFAULT NULL,
  `cus_id` int(11) DEFAULT NULL,
  `sale_time` datetime DEFAULT NULL,
  `sale_payment` decimal(10, 2) DEFAULT NULL,
  `sale_change` decimal(10, 2) DEFAULT NULL,
  `sale_type` smallint(6) DEFAULT NULL COMMENT '���ȡֵ���壺\r\n            1�����۵�\r\n            -1���˿',
  `sale_status` smallint(6) DEFAULT NULL COMMENT '���۵�״̬���£�\r\n            0��������\r\n            1���Ѹ���',
  `sale_sort` smallint(6) DEFAULT NULL COMMENT 'ȡֵ˵����\r\n            1���˿��Թ�/��Ʊ\r\n            0����ƱԱ����/��Ʊ',
  PRIMARY KEY (`sale_ID`) USING BTREE,
  INDEX `FK_customer_sale`(`cus_id`) USING BTREE,
  INDEX `FK_employee_sale`(`emp_id`) USING BTREE,
  CONSTRAINT `FK_customer_sale` FOREIGN KEY (`cus_id`) REFERENCES `customer` (`cus_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_employee_sale` FOREIGN KEY (`emp_id`) REFERENCES `employee` (`emp_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sale_item
-- ----------------------------
DROP TABLE IF EXISTS `sale_item`;
CREATE TABLE `sale_item`  (
  `sale_item_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ticket_id` bigint(20) DEFAULT NULL,
  `sale_ID` bigint(20) DEFAULT NULL,
  `sale_item_price` decimal(10, 2) DEFAULT NULL,
  PRIMARY KEY (`sale_item_id`) USING BTREE,
  INDEX `FK_sale_sale_item`(`sale_ID`) USING BTREE,
  INDEX `FK_ticket_sale_item`(`ticket_id`) USING BTREE,
  CONSTRAINT `FK_sale_sale_item` FOREIGN KEY (`sale_ID`) REFERENCES `sale` (`sale_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_ticket_sale_item` FOREIGN KEY (`ticket_id`) REFERENCES `ticket` (`ticket_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for schedule
-- ----------------------------
DROP TABLE IF EXISTS `schedule`;
CREATE TABLE `schedule`  (
  `sched_id` int(11) NOT NULL AUTO_INCREMENT,
  `studio_id` int(11) DEFAULT NULL,
  `play_id` int(11) DEFAULT NULL,
  `sched_time` datetime NOT NULL,
  `sched_ticket_price` decimal(10, 2) DEFAULT NULL,
  `sched_status` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`sched_id`) USING BTREE,
  INDEX `FK_play_sched`(`play_id`) USING BTREE,
  INDEX `FK_studio_sched`(`studio_id`) USING BTREE,
  CONSTRAINT `FK_play_sched` FOREIGN KEY (`play_id`) REFERENCES `play` (`play_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_studio_sched` FOREIGN KEY (`studio_id`) REFERENCES `studio` (`studio_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for seat
-- ----------------------------
DROP TABLE IF EXISTS `seat`;
CREATE TABLE `seat`  (
  `seat_id` int(11) NOT NULL AUTO_INCREMENT,
  `studio_id` int(11) DEFAULT NULL,
  `seat_row` int(11) DEFAULT NULL,
  `seat_column` int(11) DEFAULT NULL,
  `seat_status` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`seat_id`) USING BTREE,
  INDEX `FK_studio_seat`(`studio_id`) USING BTREE,
  CONSTRAINT `FK_studio_seat` FOREIGN KEY (`studio_id`) REFERENCES `studio` (`studio_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for studio
-- ----------------------------
DROP TABLE IF EXISTS `studio`;
CREATE TABLE `studio`  (
  `studio_id` int(11) NOT NULL AUTO_INCREMENT,
  `studio_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `studio_row_count` int(11) DEFAULT NULL,
  `studio_col_count` int(11) DEFAULT NULL,
  `studio_introduction` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `studio_status` smallint(6) DEFAULT 1 COMMENT '˵����\r\n   0������\r\n   1������',
  PRIMARY KEY (`studio_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of studio
-- ----------------------------
INSERT INTO `studio` VALUES (1, '1����', 8, 8, '1����', 1);
INSERT INTO `studio` VALUES (2, '����MAX��', 8, 8, '����MAX��', 1);
INSERT INTO `studio` VALUES (3, 'ȫ����MAX��', 10, 10, 'ȫ����MAX��', 1);
INSERT INTO `studio` VALUES (4, 'VIP��', 8, 8, 'VIP��', 1);
INSERT INTO `studio` VALUES (5, '�ű���', 9, 9, '�ű���', 1);

-- ----------------------------
-- Table structure for ticket
-- ----------------------------
DROP TABLE IF EXISTS `ticket`;
CREATE TABLE `ticket`  (
  `ticket_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `seat_id` int(11) DEFAULT NULL,
  `sched_id` int(11) DEFAULT NULL,
  `ticket_price` decimal(10, 2) DEFAULT NULL,
  `ticket_status` smallint(6) DEFAULT NULL COMMENT '�������£�\r\n            0��������\r\n            1������\r\n            9������',
  `ticket_locktime` timestamp NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '����ʱ��(�µ������)',
  PRIMARY KEY (`ticket_id`) USING BTREE,
  INDEX `FK_sched_ticket`(`sched_id`) USING BTREE,
  INDEX `FK_seat_ticket`(`seat_id`) USING BTREE,
  CONSTRAINT `FK_sched_ticket` FOREIGN KEY (`sched_id`) REFERENCES `schedule` (`sched_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_seat_ticket` FOREIGN KEY (`seat_id`) REFERENCES `seat` (`seat_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for usr_role
-- ----------------------------
DROP TABLE IF EXISTS `usr_role`;
CREATE TABLE `usr_role`  (
  `usr_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `emp_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`usr_role_id`) USING BTREE,
  INDEX `FK_role_user`(`role_id`) USING BTREE,
  INDEX `FK_user_role`(`emp_id`) USING BTREE,
  CONSTRAINT `FK_role_user` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_user_role` FOREIGN KEY (`emp_id`) REFERENCES `employee` (`emp_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;


/*
CREATE VIEW ticketMang AS
SELECT
  p.play_name,
  SUM(si.sale_item_price) AS revenue_per_play
FROM
  sale s
  JOIN sale_item si ON s.sale_ID = si.sale_ID
  JOIN ticket t ON si.ticket_id = t.ticket_id
  JOIN schedule sch ON t.sched_id = sch.sched_id
  JOIN play p ON sch.play_id = p.play_id
WHERE
  s.sale_type = 1 AND s.sale_status = 1
GROUP BY
  p.play_name;

CREATE VIEW employee_sales_performance AS
SELECT e.emp_name, SUM(s.sale_payment) AS sales_performance
FROM sale s
JOIN employee e ON s.emp_id = e.emp_id
WHERE s.sale_type = 1 AND s.sale_status = 1
GROUP BY e.emp_id;

CREATE VIEW play_revenue_by_type_and_language AS
SELECT
  d1.dict_value AS play_type,
  d2.dict_value AS play_language,
  SUM(si.sale_item_price) AS revenue_per_type_language
FROM sale s
JOIN sale_item si ON s.sale_ID = si.sale_ID
JOIN ticket t ON si.ticket_id = t.ticket_id
JOIN schedule sch ON t.sched_id = sch.sched_id
JOIN play p ON sch.play_id = p.play_id
LEFT JOIN data_dict d1 ON p.dict_type_id = d1.dict_id
LEFT JOIN data_dict d2 ON p.dict_lang_id = d2.dict_id
WHERE s.sale_type = 1 AND s.sale_status = 1
GROUP BY d1.dict_value, d2.dict_value;

drop view pending_tickets;
-- ����һ����ͼ����ʾ�����Ѿ���������δ��Ʊ��Ʊ
CREATE VIEW `pending_tickets` AS
SELECT
  t.`ticket_id`,
  t.`seat_id`,
  t.`sched_id`,
  t.`ticket_price`,
  se.`studio_id`,
  se.`seat_row`,
  se.`seat_column`,
  p.`play_name`,
  p.`play_length`,
  sch.`sched_time`,
  t.`ticket_status`
FROM
  `ticket` t
JOIN
  `seat` se ON t.`seat_id` = se.`seat_id`
JOIN
  `schedule` sch ON t.`sched_id` = sch.`sched_id`
JOIN
  `play` p ON sch.`play_id` = p.`play_id`
WHERE
  t.`ticket_status` = 9;
*/

