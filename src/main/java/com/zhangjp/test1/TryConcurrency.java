package com.zhangjp.test1;

import java.util.concurrent.TimeUnit;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: zhangjp
 * \* Date: 2018/12/23
 * \* Time: 20:53
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class TryConcurrency {

    public static void main(String[] args) {
        //新特性写法
        new Thread(TryConcurrency::browseNews).start();
        enjoyMusic();
    }

    private static void browseNews(){
        for (;;) {
            System.out.println("这是一条好新闻");
            sleep(1);
        }
    }

    private static void enjoyMusic(){
        for (;;){
            System.out.println("这是一首很棒的音乐");
            sleep(1);
        }
    }

    private static void sleep(int seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}