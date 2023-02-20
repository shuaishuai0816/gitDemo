package com.huawei.completabelfuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @DESCRIPTION: 并行任务-runAfterBothAsync()
 * 任务1和任务2之间没有任何关系可以并行，任务3需要等到任务1和任务2都完成之后才能执行
 *
 * 先输出 duty2，等待五秒之后输出duty1，最后输出duty3
 * @PACKAGE_NAME:QinRui
 * @CREATE_DATE:2023/2/20_星期一_21:58
 */
public class AllOfRunAfterBothAsync {
    public static void main(String[] args) {
        try {
            Void voidCompletableFuture = CompletableFuture.runAsync(() -> {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                AllOfThenRunTest.duty1();
            }).runAfterBothAsync(CompletableFuture.runAsync(() -> {
                        AllOfThenRunTest.duty2();
                    }), () -> {
                        AllOfThenRunTest.duty3();
                    }
            ).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
