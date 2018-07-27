/*
Navicat MySQL Data Transfer

Source Server         : 内网开发
Source Server Version : 50557
Source Host           : localhost:3306
Source Database       : fast_web_example

Target Server Type    : MYSQL
Target Server Version : 50557
File Encoding         : 65001

Date: 2018-07-07 11:58:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `system_log`
-- ----------------------------
DROP TABLE IF EXISTS `system_log`;
CREATE TABLE `system_log` (
  `id` bigint(40) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(40) DEFAULT NULL COMMENT '用户标识',
  `user_name` varchar(100) DEFAULT NULL COMMENT '用户姓名',
  `user_ip` varchar(100) DEFAULT NULL COMMENT 'IP地址',
  `operation` varchar(100) DEFAULT NULL COMMENT '用户操作',
  `method` varchar(200) DEFAULT NULL COMMENT '请求方法',
  `params` varchar(5000) DEFAULT NULL COMMENT '请求参数',
  `execution_time` bigint(40) NOT NULL COMMENT '执行时长(毫秒)',
  `created_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统日志';

-- ----------------------------
-- Records of system_log
-- ----------------------------

-- ----------------------------
-- Table structure for `system_menu`
-- ----------------------------
DROP TABLE IF EXISTS `system_menu`;
CREATE TABLE `system_menu` (
  `id` bigint(40) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '父菜单ID，一级菜单为0',
  `category` tinyint(1) NOT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `name` varchar(50) NOT NULL COMMENT '菜单名称',
  `url` varchar(200) DEFAULT NULL COMMENT '菜单URL',
  `perms` varchar(500) DEFAULT NULL COMMENT '授权(如：system:user:view)',
  `icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `sort` int(11) NOT NULL COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=143 DEFAULT CHARSET=utf8 COMMENT='菜单管理';

-- ----------------------------
-- Records of system_menu
-- ----------------------------
INSERT INTO `system_menu` VALUES ('1', '0', '0', '系统管理', null, null, 'system', '1');
INSERT INTO `system_menu` VALUES ('11', '1', '1', '账号管理', 'system/user', null, 'user', '1');
INSERT INTO `system_menu` VALUES ('12', '1', '1', '角色管理', 'system/role', null, 'role', '2');
INSERT INTO `system_menu` VALUES ('13', '1', '1', '菜单管理', 'system/menu', null, 'menu', '3');
INSERT INTO `system_menu` VALUES ('14', '1', '1', '日志管理', 'system/log', null, 'log', '4');
INSERT INTO `system_menu` VALUES ('111', '11', '2', '查看', null, 'system:user:view', null, '1');
INSERT INTO `system_menu` VALUES ('112', '11', '2', '新增', null, 'system:user:add', null, '2');
INSERT INTO `system_menu` VALUES ('113', '11', '2', '修改', null, 'system:user:update', null, '3');
INSERT INTO `system_menu` VALUES ('114', '11', '2', '删除', null, 'system:user:delete', null, '4');
INSERT INTO `system_menu` VALUES ('121', '12', '2', '查看', null, 'system:role:view', null, '1');
INSERT INTO `system_menu` VALUES ('122', '12', '2', '新增', null, 'system:role:add', null, '2');
INSERT INTO `system_menu` VALUES ('123', '12', '2', '修改', null, 'system:role:update', null, '3');
INSERT INTO `system_menu` VALUES ('124', '12', '2', '删除', null, 'system:role:delete', null, '4');
INSERT INTO `system_menu` VALUES ('131', '13', '2', '查看', null, 'system:menu:view', null, '1');
INSERT INTO `system_menu` VALUES ('132', '13', '2', '新增', null, 'system:menu:add', null, '2');
INSERT INTO `system_menu` VALUES ('133', '13', '2', '修改', null, 'system:menu:update', null, '3');
INSERT INTO `system_menu` VALUES ('134', '13', '2', '删除', null, 'system:menu:delete', null, '4');
INSERT INTO `system_menu` VALUES ('141', '14', '2', '查看', null, 'system:log:view', null, '1');
INSERT INTO `system_menu` VALUES ('142', '14', '2', '删除', null, 'system:log:delete', null, '2');

-- ----------------------------
-- Table structure for `system_role`
-- ----------------------------
DROP TABLE IF EXISTS `system_role`;
CREATE TABLE `system_role` (
  `id` bigint(40) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL COMMENT '角色名称',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `created_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='角色';

-- ----------------------------
-- Records of system_role
-- ----------------------------
INSERT INTO `system_role` VALUES ('1', '管理员', '管理员拥有所有权限', '2018-07-04 16:46:32');

-- ----------------------------
-- Table structure for `system_role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `system_role_menu`;
CREATE TABLE `system_role_menu` (
  `id` bigint(40) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(40) DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(40) DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_role_id_menu_id` (`role_id`,`menu_id`) USING BTREE,
  KEY `fk_system_role_menu_menu_id` (`menu_id`),
  CONSTRAINT `fk_system_role_menu_menu_id` FOREIGN KEY (`menu_id`) REFERENCES `system_menu` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_system_role_menu_role_id` FOREIGN KEY (`role_id`) REFERENCES `system_role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COMMENT='角色与菜单对应关系';

-- ----------------------------
-- Records of system_role_menu
-- ----------------------------
INSERT INTO `system_role_menu` VALUES ('1', '1', '1');
INSERT INTO `system_role_menu` VALUES ('2', '1', '11');
INSERT INTO `system_role_menu` VALUES ('3', '1', '12');
INSERT INTO `system_role_menu` VALUES ('4', '1', '13');
INSERT INTO `system_role_menu` VALUES ('5', '1', '14');
INSERT INTO `system_role_menu` VALUES ('6', '1', '111');
INSERT INTO `system_role_menu` VALUES ('7', '1', '112');
INSERT INTO `system_role_menu` VALUES ('8', '1', '113');
INSERT INTO `system_role_menu` VALUES ('9', '1', '114');
INSERT INTO `system_role_menu` VALUES ('10', '1', '121');
INSERT INTO `system_role_menu` VALUES ('11', '1', '122');
INSERT INTO `system_role_menu` VALUES ('12', '1', '123');
INSERT INTO `system_role_menu` VALUES ('13', '1', '124');
INSERT INTO `system_role_menu` VALUES ('14', '1', '131');
INSERT INTO `system_role_menu` VALUES ('15', '1', '132');
INSERT INTO `system_role_menu` VALUES ('16', '1', '133');
INSERT INTO `system_role_menu` VALUES ('17', '1', '134');
INSERT INTO `system_role_menu` VALUES ('18', '1', '141');
INSERT INTO `system_role_menu` VALUES ('19', '1', '142');

-- ----------------------------
-- Table structure for `system_user`
-- ----------------------------
DROP TABLE IF EXISTS `system_user`;
CREATE TABLE `system_user` (
  `id` bigint(40) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL COMMENT '姓名',
  `user_face` varchar(200) DEFAULT NULL COMMENT '头像',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '加密密码',
  `role_id` bigint(40) DEFAULT NULL COMMENT '角色编号',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) DEFAULT NULL COMMENT '手机号',
  `state` tinyint(4) NOT NULL DEFAULT '0' COMMENT '状态  0：禁用   1：正常',
  `created_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  KEY `fk_system_user_role_id` (`role_id`),
  CONSTRAINT `fk_system_user_role_id` FOREIGN KEY (`role_id`) REFERENCES `system_role` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='系统用户';

-- ----------------------------
-- Records of system_user
-- ----------------------------
INSERT INTO `system_user` VALUES ('1', '管理员', null, 'admin', '21232f297a57a5a743894a0e4a801fc3', '1', 'xtotly@aliyun.com', '15868458379', '1', '2018-07-04 16:51:44');
