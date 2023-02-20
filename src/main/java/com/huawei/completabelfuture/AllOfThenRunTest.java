package com.huawei.completabelfuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @DESCRIPTION: 孙悟空分出2个分身（线程），分身1-打游戏，分身2-搞学习，分身3-吃午饭；分身1把游戏打完了，分身2把学习搞完了，分身3才允许吃饭
 * @PACKAGE_NAME:QinRui
 * @CREATE_DATE:2023/2/20_星期一_21:42
 */
public class AllOfThenRunTest {
    public static void main(String[] args) {
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
            try {
                Thread.currentThread().sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            duty1();
        });

        CompletableFuture<Void> voidCompletableFuture1 = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            duty2();
        });

        CompletableFuture<Void> all = CompletableFuture.allOf(voidCompletableFuture, voidCompletableFuture1).thenRun(() -> {
            duty3();
        });

        try {
            // 等待获取返回结果，会阻塞main线程，外部异常处理
            all.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    static void duty1() {
        System.out.println("分身：" + Thread.currentThread().getName() + "打游戏");
    }

    static void duty2() {
        System.out.println("分身：" + Thread.currentThread().getName() + "搞学习");
    }

    static void duty3() {
        System.out.println("分身：" + Thread.currentThread().getName() + "吃饭");
    }
}
