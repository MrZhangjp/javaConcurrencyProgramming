package com.zhangjp.test1;

import java.util.concurrent.TimeUnit;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: zhangjp
 * \* Date: 2019/2/16
 * \* Time: 9:43
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class Interrupt {

    /**
     * 注意点：
     * Thread.interrupted()  判断线程是否被中断，判断的同时会把中断标识擦除
     * Thread.currentThread().isInterrupted() 判断线程是否已经被中断，只判断，不会擦除中断的标识
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Main thread is interrupt?"+Thread.interrupted());

        Thread.currentThread().interrupt();

        System.out.println("Main thread is interrupt?"+Thread.currentThread().isInterrupted());

        try {
            TimeUnit.MINUTES.sleep(1);
        } catch (Exception e) {
            System.out.println("I will be interrupt still");
        } finally {

        }
    }
}