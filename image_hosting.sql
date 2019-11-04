/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : localhost:3306
 Source Schema         : image_hosting

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 04/11/2019 18:06:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for image_info
-- ----------------------------
DROP TABLE IF EXISTS `image_info`;
CREATE TABLE `image_info`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '图片id',
  `filename` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '上传文件时所用的文件名',
  `storename` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '上传后的文件名',
  `file_id` int(11) NULL DEFAULT NULL COMMENT 'sm.ms方图片id',
  `size` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文件大小',
  `width` int(11) NULL DEFAULT NULL COMMENT '图片的宽度',
  `height` int(11) NULL DEFAULT NULL COMMENT '图片的高度',
  `hash` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '随机字符串，用于删除文件',
  `delete_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '删除上传的图片文件专有链接',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图片服务器地址',
  `path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图片的相对地址',
  `msg` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '错误信息，上传失败时出现',
  `status` int(1) NULL DEFAULT NULL COMMENT '图片状态 1上传成功 0上传失败 -1已删除',
  `user_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户id',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '上传时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `page` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图片信息页面',
  `request_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'sm.ms请求编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of image_info
-- ----------------------------
INSERT INTO `image_info` VALUES ('0369f9dc30714937994091bc5164dab4', '00a6c147bd5a1365cd07d71c98e340505876d6c56eca62db05521d83f0c63bf3.jpg', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Image upload repeated limit, this image exists at: https://i.loli.net/2019/11/01/8b1cn62axZqC3EL.jpg', 0, 'heartzz1', '2019-11-01 14:10:10', NULL, NULL, NULL);
INSERT INTO `image_info` VALUES ('055778ffed8d455391b88f5e89ac8c0b', '0fcf72bb1a8fa867f3861dc6af981fa4f0d6a6ad1cd68c5359c61e124a8a6be7.jpg', 'z82eEawIUZQA7yN.jpg', 0, '977843', 1920, 1080, 'Khy9iNeIFcfLkxR8P1OnV2tUaB', 'https://sm.ms/delete/Khy9iNeIFcfLkxR8P1OnV2tUaB', 'https://i.loli.net/2019/11/01/z82eEawIUZQA7yN.jpg', '/2019/11/01/z82eEawIUZQA7yN.jpg', 'Upload success.', 1, 'heartzz1', '2019-11-01 15:00:48', NULL, 'https://sm.ms/image/z82eEawIUZQA7yN', 'C142397E-F670-4F87-A920-CDED39F6FE53');
INSERT INTO `image_info` VALUES ('1a2c9b00923a4183b49ba522d963edac', '0cdc42bf4fb7f20c5df6fe02ee69bccb906cc8fefd32c598644d920a1d7a1c8a.jpg', 'oyz8IxSHspGNEl6.jpg', 0, '301414', 1080, 1920, 'nacOYvM3Iprz89tsgkRiw4BWd1', 'https://sm.ms/delete/nacOYvM3Iprz89tsgkRiw4BWd1', 'https://i.loli.net/2019/11/01/oyz8IxSHspGNEl6.jpg', '/2019/11/01/oyz8IxSHspGNEl6.jpg', 'Upload success.', 1, 'heartzz1', '2019-11-01 14:10:51', NULL, 'https://sm.ms/image/oyz8IxSHspGNEl6', '1D044D9D-07C4-48AF-87E1-3F0E31CD6FAB');
INSERT INTO `image_info` VALUES ('1fe689fd28ca490f86973bd5b8de611a', '0ba03691b401397396d8c00d7a2564582bd7cbbc05d76e7ebde973524a44bd36.jpg', 'SkwGLZmAgcEu6Y5.jpg', 0, '350942', 1080, 1920, 'karuNmdCGpvyE7BjAQ5Tn4lHRP', 'https://sm.ms/delete/karuNmdCGpvyE7BjAQ5Tn4lHRP', 'https://i.loli.net/2019/11/01/SkwGLZmAgcEu6Y5.jpg', '/2019/11/01/SkwGLZmAgcEu6Y5.jpg', 'Upload success.', 1, 'heartzz1', '2019-11-01 14:10:29', NULL, 'https://sm.ms/image/SkwGLZmAgcEu6Y5', '07892456-3D98-4858-9A58-336F6B599A16');
INSERT INTO `image_info` VALUES ('25fa167c5edd48bc965ea57c8490514b', '00b06537974143664c10613ced6b93ead2fb9eda04d787c844a9a6274220cba2.jpg', 'aL8e9w1PuRk7gEW.jpg', 0, '616952', 1920, 1080, '34go7q1yhYGbsKPC5luSLVcN2r', 'https://sm.ms/delete/34go7q1yhYGbsKPC5luSLVcN2r', 'https://i.loli.net/2019/11/01/aL8e9w1PuRk7gEW.jpg', '/2019/11/01/aL8e9w1PuRk7gEW.jpg', 'Upload success.', 1, 'heartzz1', '2019-11-01 14:10:19', NULL, 'https://sm.ms/image/aL8e9w1PuRk7gEW', '4FF159AC-6DFC-4752-9E08-660166F9A15E');
INSERT INTO `image_info` VALUES ('3e54e01f0763418f9b560bbe103df848', '01b51d84effdd472ba45a1221ad67953697c46368677b0af8c5168e79781e83f.jpg', 'GakpFt5nZUPQRuJ.jpg', 0, '137019', 1920, 1080, '2mPBA6lZhLwKGnJiFHCOQXpryY', 'https://sm.ms/delete/2mPBA6lZhLwKGnJiFHCOQXpryY', 'https://i.loli.net/2019/11/01/GakpFt5nZUPQRuJ.jpg', '/2019/11/01/GakpFt5nZUPQRuJ.jpg', 'Upload success.', 1, 'heartzz1', '2019-11-01 15:00:54', NULL, 'https://sm.ms/image/GakpFt5nZUPQRuJ', '2E668C89-7349-4CBB-A898-E8E39B996C80');
INSERT INTO `image_info` VALUES ('4368d776eee74c21b9d2920629e3dd34', '01eb899655ff7a025481ee545a3b53767cdeb3b3095241077b462af50de09671.jpg', 'rJuVijeoIcPfxBA.jpg', 0, '421468', 1920, 1080, 'jEwvRHcyuAIQq7r49fmKLnb8FO', 'https://sm.ms/delete/jEwvRHcyuAIQq7r49fmKLnb8FO', 'https://i.loli.net/2019/11/01/rJuVijeoIcPfxBA.jpg', '/2019/11/01/rJuVijeoIcPfxBA.jpg', 'Upload success.', 1, 'heartzz1', '2019-11-01 15:00:58', NULL, 'https://sm.ms/image/rJuVijeoIcPfxBA', '4611F336-49E6-45E4-8E61-C84724FA4ACB');
INSERT INTO `image_info` VALUES ('46d879d242ea4c978931a3a6170ef63f', '001f88190906fd16aa23615878d98189caf26e853be3918ffee181321fc60504.jpg', '5eAJ4yrQfmSlB2Y.jpg', 0, '518324', 1080, 1920, 'dBMRDzGrgEToxPaLvNWtXwyHeO', 'https://sm.ms/delete/dBMRDzGrgEToxPaLvNWtXwyHeO', 'https://i.loli.net/2019/11/01/5eAJ4yrQfmSlB2Y.jpg', '/2019/11/01/5eAJ4yrQfmSlB2Y.jpg', 'Upload success.', 1, 'heartzz1', '2019-11-01 15:00:52', NULL, 'https://sm.ms/image/5eAJ4yrQfmSlB2Y', 'AAFD4269-ED19-41AA-9988-4A500CF09301');
INSERT INTO `image_info` VALUES ('498baaa21c904117a4c2f4b2dd3c2138', '0a2b776c0447fe30dbd705e87187e4b21fdebdb4f2a9e082b6db917d5ad6e57c.jpg', 'tR8HiozsF7K3BNV.jpg', 0, '402257', 1920, 1080, 'Ghj4zH2X638JsfYBDlM1Kyvqxt', 'https://sm.ms/delete/Ghj4zH2X638JsfYBDlM1Kyvqxt', 'https://i.loli.net/2019/11/01/tR8HiozsF7K3BNV.jpg', '/2019/11/01/tR8HiozsF7K3BNV.jpg', 'Upload success.', 1, 'heartzz1', '2019-11-01 14:10:24', NULL, 'https://sm.ms/image/tR8HiozsF7K3BNV', '3356B834-2EA7-469E-A9B8-7E7ADF052810');
INSERT INTO `image_info` VALUES ('5826c29732a44a0e81e2374786dc9eea', 'QQ图片20191014151611.jpg', '3px7vL6q84OMlcw.jpg', 0, '61245', 640, 640, 'Va475KwR1L63vhYWGiynFgN2rt', 'https://sm.ms/delete/Va475KwR1L63vhYWGiynFgN2rt', 'https://i.loli.net/2019/10/31/3px7vL6q84OMlcw.jpg', '/2019/10/31/3px7vL6q84OMlcw.jpg', 'Upload success.', 1, 'heartzz1', '2019-10-31 17:30:20', NULL, 'https://sm.ms/image/3px7vL6q84OMlcw', '04F34133-9477-4963-9DBB-5F5A5E3AD8EB');
INSERT INTO `image_info` VALUES ('6d6d67adcd4248faabe7da418afec0d7', 'index_bg.jpg', '1TkBCWKszIcLyvu.jpg', 0, '191690', 1500, 1083, 'Y5NZARIQ8j7necHvyuG1iU9EVz', 'https://sm.ms/delete/Y5NZARIQ8j7necHvyuG1iU9EVz', 'https://i.loli.net/2019/10/31/1TkBCWKszIcLyvu.jpg', '/2019/10/31/1TkBCWKszIcLyvu.jpg', 'Upload success.', 1, 'heartzz1', '2019-10-31 17:41:07', NULL, 'https://sm.ms/image/1TkBCWKszIcLyvu', '4917BB1F-9E3B-4A72-B45A-09F74772ABA5');
INSERT INTO `image_info` VALUES ('88ca346d16e64899ae094f799ce3eae1', '0f1d7c31b08553595ab6ef04bd7b22dbf08f2d71bebf483ebe6e41943f52be01.jpg', 'Z5JndfhgL4Ep872.jpg', 0, '573216', 1080, 1920, '9PyVaWbzLGsn51ZxhDo6jAfkTB', 'https://sm.ms/delete/9PyVaWbzLGsn51ZxhDo6jAfkTB', 'https://i.loli.net/2019/11/01/Z5JndfhgL4Ep872.jpg', '/2019/11/01/Z5JndfhgL4Ep872.jpg', 'Upload success.', 1, 'heartzz1', '2019-11-01 15:00:42', NULL, 'https://sm.ms/image/Z5JndfhgL4Ep872', '03490178-216B-45C1-86C9-285115B456A8');
INSERT INTO `image_info` VALUES ('897071f95f254554839799971c2b653f', '0d92305dcfd2162df67970985615d47e502c6a5f5d6ec04184e8bc6f15e94672.jpg', 'GZmbOK2TUuXE7dS.jpg', 0, '283227', 1080, 1920, 'swpUNSanQoWRJ3hOTzbePmdY2x', 'https://sm.ms/delete/swpUNSanQoWRJ3hOTzbePmdY2x', 'https://i.loli.net/2019/11/01/GZmbOK2TUuXE7dS.jpg', '/2019/11/01/GZmbOK2TUuXE7dS.jpg', 'Upload success.', 1, 'heartzz1', '2019-11-01 15:00:38', NULL, 'https://sm.ms/image/GZmbOK2TUuXE7dS', '89E38965-FE5A-4343-B3BD-2266FBA28E3B');
INSERT INTO `image_info` VALUES ('a8dc9b7a08b347a196096fb87eddb55a', '0fcdfc9e7985a7383045f1277a1de77685f7ab606845213c4d5a88b510af2651.jpg', 'wsqxjuJdH78yBYv.jpg', 0, '445080', 1080, 1920, 'KjpBEotvnq9k7hl1OIeJWMGbHR', 'https://sm.ms/delete/KjpBEotvnq9k7hl1OIeJWMGbHR', 'https://i.loli.net/2019/11/01/wsqxjuJdH78yBYv.jpg', '/2019/11/01/wsqxjuJdH78yBYv.jpg', 'Upload success.', 1, 'heartzz1', '2019-11-01 15:00:45', NULL, 'https://sm.ms/image/wsqxjuJdH78yBYv', 'C0FD01A5-D3F2-46C9-9B29-04D50C8039FF');
INSERT INTO `image_info` VALUES ('d0225f6e84164d529077fe78f16e9e19', '0cb8263e19cf9da3de59ea8acc89ef4012d9cd2f5efe6146ee80a047ccc667ed.jpg', 'Vh4QiYDMnBLEUpG.jpg', 0, '680587', 1080, 1920, 'sA4d7zaCiq3eT8ED1XjxyMuFUr', 'https://sm.ms/delete/sA4d7zaCiq3eT8ED1XjxyMuFUr', 'https://i.loli.net/2019/11/01/Vh4QiYDMnBLEUpG.jpg', '/2019/11/01/Vh4QiYDMnBLEUpG.jpg', 'Upload success.', 1, 'heartzz1', '2019-11-01 14:10:46', NULL, 'https://sm.ms/image/Vh4QiYDMnBLEUpG', '103DFDDA-C269-458C-836A-7870668A1E69');
INSERT INTO `image_info` VALUES ('da45c34fa08a4b9bb4bf3ea07266f581', '0cb943d9051ca3e3a28630332caa2c9a2265a9d63733699e2b025475d68e144c.jpg', 'Q4nIbhw3HZ89UKx.jpg', 0, '1089454', 1920, 1080, 'wDkbiL7etGRXlWYyH2VcIFf1M5', 'https://sm.ms/delete/wDkbiL7etGRXlWYyH2VcIFf1M5', 'https://i.loli.net/2019/11/01/Q4nIbhw3HZ89UKx.jpg', '/2019/11/01/Q4nIbhw3HZ89UKx.jpg', 'Upload success.', 1, 'heartzz1', '2019-11-01 14:10:39', NULL, 'https://sm.ms/image/Q4nIbhw3HZ89UKx', '81DC233E-71FC-42E1-A752-AA4A420733EF');

-- ----------------------------
-- Table structure for user_auths
-- ----------------------------
DROP TABLE IF EXISTS `user_auths`;
CREATE TABLE `user_auths`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键',
  `user_id` varchar(0) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户主键',
  `identity_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '登录类型：普通用户名登录、手机号登录、邮箱登录、第三方登录',
  `identifier` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '登录标识：用户名、手机号、邮箱、第三方唯一标识',
  `credential` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码凭证：站内用户保存密码，站外用户保存token之类',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `user_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户主键',
  `user_status` int(1) NULL DEFAULT NULL COMMENT '用户状态 1 正常，-1 无效',
  `nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户昵称',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户头像',
  `login_ip` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '本次登录ip',
  `last_login_ip` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '上次登录ip',
  `login_time` datetime(0) NULL DEFAULT NULL COMMENT '本次登录时间',
  `last_login_time` datetime(0) NULL DEFAULT NULL COMMENT '上次登录时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
