package com.zhangjp.join;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: zhangjp
 * \* Date: 2019/2/16
 * \* Time: 10:54
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class FightQueryTask extends Thread implements FightQuery{

    private final String origin;

    private final String destination;

    private final List<String> fightList = new ArrayList<>();

    public FightQueryTask(String airline,String origin,String destination){
        super("["+airline+"]");
        this.origin = origin;
        this.destination = destination;
    }

    @Override
    public void run(){
        System.out.printf("%s-query from %s to %s \n",getName(),origin,destination);
        int randomVal = ThreadLocalRandom.current().nextInt(10);
        try {
            TimeUnit.SECONDS.sleep(randomVal);
            this.fightList.add(getName()+"-查询时间："+randomVal+"秒");
            System.out.printf("The Fight:%s list query successful\n",getName());
        } catch (Exception e) {

        } finally {

        }
    }

    @Override
    public List<String> get() {
        return this.fightList;
    }
}