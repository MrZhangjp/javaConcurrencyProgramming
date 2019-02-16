package com.zhangjp.join;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: zhangjp
 * \* Date: 2019/2/16
 * \* Time: 11:50
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class FigthQueryExample {
    private static List<String> fightCompany = Arrays.asList("南航","东航","国航");

    private static List<String> search(String original,String dest){
        final List<String> result = new ArrayList<>();
        List<FightQueryTask> tasks = fightCompany.stream().map(f ->createSearchTask(f,original,dest))
                .collect(Collectors.toList());

        tasks.forEach(Thread::start);

        tasks.forEach(t ->{
            try {
                t.join();
            } catch (InterruptedException e) {

            } finally {

            }
        });

        tasks.stream().map(FightQuery::get).forEach(result::addAll);

        return result;
    }

    private static FightQueryTask createSearchTask(String figth,String original,String dest){
        return new FightQueryTask(figth,original,dest);
    }


    public static void main(String[] args) {
        List<String> results = search("广州","上海");
        System.out.println("=======results========");
        results.forEach(System.out::println);
    }
}