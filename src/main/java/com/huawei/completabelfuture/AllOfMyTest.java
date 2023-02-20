package com.huawei.completabelfuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @DESCRIPTION:
 * @PACKAGE_NAME:QinRui
 * @CREATE_DATE:2023/2/20_星期一_22:09
 */
public class AllOfMyTest {
    public static void main(String[] args) {
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
            System.out.println("执行任务1");
        });
        CompletableFuture<Void> voidCompletableFuture1 = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("执行任务2");
        });

        CompletableFuture<Void> all = CompletableFuture.allOf(voidCompletableFuture, voidCompletableFuture1).thenRun(() -> {
            System.out.println("以上二个任务已经全部执行完毕");
        });

        try {
            all.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
