package com.example.heart.imagehosting.utils;

import com.example.heart.imagehosting.common.SysErrorCode;
import com.example.heart.imagehosting.exception.AppBizException;

/**
 * @ClassName: SnowFlake
 * @Description: 雪花算法
 * @Author: jayhe
 * @Date: 2020/1/16 16:16
 * @Version: v1.0
 */
public class SnowFlake {

    /**
     * 起始的时间戳:这个时间戳自己随意获取，比如自己代码的时间戳
     */
    private final static long START_STMP = 1577808000000L;

    /**
     * 每一部分占用的位数
     */
    //序列号占用的位数
    private final static long SEQUENCE_BIT = 12;
    //机器标识占用的位数
    private final static long MACHINE_BIT = 5;
    //数据中心占用的位数
    private final static long DATACENTER_BIT = 5;

    /**
     * 每一部分的最大值：先进行左移运算，再同-1进行异或运算；异或：相同位置相同结果为0，不同结果为1
     */
    //用位运算计算出最大支持的数据中心数量：31
    private final static long MAX_DATACENTER_NUM = -1L ^ (-1L << DATACENTER_BIT);
    //用位运算计算出最大支持的机器数量：31
    private final static long MAX_MACHINE_NUM = -1L ^ (-1L << MACHINE_BIT);
    //用位运算计算出12位能存储的最大正整数：4095
    private final static long MAX_SEQUENCE = -1L ^ (-1L << SEQUENCE_BIT);

    /**
     * 每一部分向左的位移
     */
    //机器标志较序列号的偏移量
    private final static long MACHINE_LEFT = SEQUENCE_BIT;
    //数据中心较机器标志的偏移量
    private final static long DATACENTER_LEFT = SEQUENCE_BIT + MACHINE_BIT;
    //时间戳较数据中心的偏移量
    private final static long TIMESTMP_LEFT = DATACENTER_LEFT + DATACENTER_BIT;


    //数据中心
    private static long datacenterId;
    //机器标识
    private static long machineId;
    //序列号
    private static long sequence = 0L;
    //上一次时间戳
    private static long lastStmp = -1L;

    /**
     * 此处无参构造私有，同时没有给出有参构造，在于避免以下两点问题：
     * 1、私有化避免了通过new的方式进行调用，主要是解决了在for循环中通过new的方式调用产生的id不一定唯一问题问题，
     * 因为用于记录上一次时间戳的lastStmp永远无法得到比对；
     * 2、没有给出有参构造在第一点的基础上考虑了一套分布式系统产生的唯一序列号应该是基于相同的参数
     */
    private SnowFlake() {
    }

    /**
     * 生成下一个ID
     *
     * @return
     */
    public static synchronized long nextId() {
        //获取当前时间戳
        long currStmp = getNewstmp();

        // 如果当前时间戳小于上次时间戳则抛出异常
        if (currStmp < lastStmp) {
            throw new AppBizException(SysErrorCode.SnowFlakeException.getCode(), SysErrorCode.SnowFlakeException.getMsg());
        }
        //相同毫秒内
        if (currStmp == lastStmp) {
            //相同毫秒内，序列号自增
            sequence = (sequence + 1) & MAX_SEQUENCE;
            //同一毫秒的序列数已经达到最大
            if (sequence == 0L) {

                // 获取下一时间的时间戳并赋值给当前时间戳
                currStmp = getNextMill();
            }
        } else {
            //不同毫秒内，序列号置为0
            sequence = 0L;
        }
        //当前时间戳存档记录，用于下次产生id时对比是否为相同时间戳
        lastStmp = currStmp;

        //时间戳部分
        return (currStmp - START_STMP) << TIMESTMP_LEFT
                //数据中心部分
                | datacenterId << DATACENTER_LEFT
                //机器标识部分
                | machineId << MACHINE_LEFT
                //序列号部分
                | sequence;
    }

    /**
     * 获取下一时间的时间戳
     *
     * @return
     */
    private static long getNextMill() {
        long mill = getNewstmp();
        while (mill <= lastStmp) {
            mill = getNewstmp();
        }
        return mill;
    }

    /**
     * 获取当前时间戳
     *
     * @return
     */
    private static long getNewstmp() {
        return System.currentTimeMillis();
    }

}
