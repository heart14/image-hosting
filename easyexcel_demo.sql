/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : localhost:3306
 Source Schema         : easyexcel_demo

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 04/11/2019 18:06:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for multi_treat_info
-- ----------------------------
DROP TABLE IF EXISTS `multi_treat_info`;
CREATE TABLE `multi_treat_info`  (
  `id` varchar(13) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'id',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `art_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'ART方式',
  `cycle_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '周期类型',
  `age_area` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '年龄段',
  `treat_cycles` int(11) NULL DEFAULT NULL COMMENT '治疗周期数',
  `total_eggs` int(11) NULL DEFAULT NULL COMMENT '获卵总数',
  `for_fertilized_eggs` int(11) NULL DEFAULT NULL COMMENT '拟用于受精卵数',
  `isci_mii_eggs` int(11) NULL DEFAULT NULL COMMENT 'ICSI MII总卵子数',
  `twopn_fertilized_num` int(11) NULL DEFAULT NULL COMMENT '2PN受精数',
  `twopn_fertilized_cleavage_num` int(11) NULL DEFAULT NULL COMMENT '2PN受精卵裂数',
  `total_good_embryo_num` int(11) NULL DEFAULT NULL COMMENT '总优质胚胎数',
  `cancel_cycles` int(11) NULL DEFAULT NULL COMMENT '取消周期数',
  `non_trans_embryo_cycles` int(11) NULL DEFAULT NULL COMMENT '无可移植胚胎周期数',
  `embryo_freezing_cycles` int(11) NULL DEFAULT NULL COMMENT '全胚冷冻周期数',
  `transplant_cycles` int(11) NULL DEFAULT NULL COMMENT '移植周期数',
  `total_trans_embryo_num` int(11) NULL DEFAULT NULL COMMENT '总移植胚胎数',
  `settle_preg_sac_num` int(11) NULL DEFAULT NULL COMMENT '总着床孕囊数',
  `clinical_pregnancy_cycles` int(11) NULL DEFAULT NULL COMMENT '临床妊娠周期数',
  `multiple_embryos_cycles` int(11) NULL DEFAULT NULL COMMENT '多胎周期数',
  `ectopic_pregnancy_cycles` int(11) NULL DEFAULT NULL COMMENT '宫外孕周期数',
  `abortion_cycles` int(11) NULL DEFAULT NULL COMMENT '流产周期数',
  `childbirth_cycles` int(11) NULL DEFAULT NULL COMMENT '分娩周期数',
  `living_cycles` int(11) NULL DEFAULT NULL COMMENT '活产周期数',
  `living_boy_num` int(11) NULL DEFAULT NULL COMMENT '活产胎儿数（男）',
  `living_girl_num` int(11) NULL DEFAULT NULL COMMENT '活产胎儿数（女）',
  `congenital_disability_num` int(11) NULL DEFAULT NULL COMMENT '出生缺陷数',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for total_treat_info
-- ----------------------------
DROP TABLE IF EXISTS `total_treat_info`;
CREATE TABLE `total_treat_info`  (
  `id` varchar(13) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'id',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `years` int(11) NULL DEFAULT NULL COMMENT '数据年份',
  `primary_infertility_cycles` int(11) NULL DEFAULT NULL COMMENT '原发不孕周期数',
  `secondary_sterility_cycles` int(11) NULL DEFAULT NULL COMMENT '继发不孕周期数',
  `oviduct_factor_cycles` int(11) NULL DEFAULT NULL COMMENT '输卵管因素周期数',
  `ovulation_disorder_cycles` int(11) NULL DEFAULT NULL COMMENT '排卵障碍周期数',
  `ovary_decline_cycles` int(11) NULL DEFAULT NULL COMMENT '卵巢功能减退周期数',
  `endometriosis_cycles` int(11) NULL DEFAULT NULL COMMENT '子宫内膜异位周期数',
  `azoospermia_cycles` int(11) NULL DEFAULT NULL COMMENT '无精症周期数',
  `oligozoospermia_cycles` int(11) NULL DEFAULT NULL COMMENT '少弱精子症周期数',
  `deformity_sperm_cycles` int(11) NULL DEFAULT NULL COMMENT '畸精症周期数',
  `unknown_reason_cycles` int(11) NULL DEFAULT NULL COMMENT '不明原因周期数',
  `both_factors_cycles` int(11) NULL DEFAULT NULL COMMENT '双方因素周期数',
  `aih_cycles` int(11) NULL DEFAULT NULL COMMENT 'AIH周期数',
  `aid_cycles` int(11) NULL DEFAULT NULL COMMENT 'AID周期数',
  `ivf_cycles` int(11) NULL DEFAULT NULL COMMENT 'IVF周期数',
  `icsi_cycles` int(11) NULL DEFAULT NULL COMMENT 'ICSI周期数',
  `ivf_icsi_cycles` int(11) NULL DEFAULT NULL COMMENT 'IVF+ICSI周期数',
  `pgd_cycles` int(11) NULL DEFAULT NULL COMMENT 'PGD周期数',
  `pgs_cycles` int(11) NULL DEFAULT NULL COMMENT 'PGS周期数',
  `sperm_ivf_icsi_cycles` int(11) NULL DEFAULT NULL COMMENT '供精IVF/ICSI周期数',
  `egg_ivf_icsi_cycles` int(11) NULL DEFAULT NULL COMMENT '受卵IVF/ICSI周期数',
  `fet_cycles` int(11) NULL DEFAULT NULL COMMENT 'FET周期数',
  `fresh_stimulate_treat_cycles` int(11) NULL DEFAULT NULL COMMENT '新鲜刺激周期治疗周期总数',
  `fresh_stimulate_egg_cycles` int(11) NULL DEFAULT NULL COMMENT '新鲜刺激周期取卵周期总数',
  `fresh_stimulate_transplant_cycles` int(11) NULL DEFAULT NULL COMMENT '新鲜刺激周期移植周期总数',
  `fresh_stimulate_embryo_trans_cycles` int(11) NULL DEFAULT NULL COMMENT '新鲜刺激周期单胚胎移植周期总数',
  `total_gn_cost` int(11) NULL DEFAULT NULL COMMENT '总Gn用量',
  `total_gn_days` int(11) NULL DEFAULT NULL COMMENT '总Gn天数',
  `total_egg_num` int(11) NULL DEFAULT NULL COMMENT '总获卵数',
  `total_embryo_num` int(11) NULL DEFAULT NULL COMMENT '总移植胚胎数',
  `ohss_cycles` int(11) NULL DEFAULT NULL COMMENT '中重度OHSS周期数',
  `postoperate_bleeding_cycles` int(11) NULL DEFAULT NULL COMMENT '术后出血（>300ml）周期数',
  `postoperate_pelvic_infection_cycles` int(11) NULL DEFAULT NULL COMMENT '术后盆腔感染周期数',
  `other_complication_cycles` int(11) NULL DEFAULT NULL COMMENT '其他并发症周期数',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新日期',
  `status` int(1) NULL DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
