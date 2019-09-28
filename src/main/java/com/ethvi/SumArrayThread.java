package com.ethvi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author ethvi
 * @Description:
 * @Date: 2019/8/17 15:34
 */
public class SumArrayThread {
    public static void main(String[] args) throws InterruptedException {
        int coreNum = 10;

        int[] array = new int[100000];
        for (int i = 1; i < array.length; i++)
            array[i] = i;

        int k = array.length/coreNum;
        int[][] temp = new int[coreNum][k];
        for (int i = 0; i < temp.length; i++)
            temp[i] = Arrays.copyOfRange(array, i *k, (i + 1) * k);

        ExecutorService service =
                new ThreadPoolExecutor(
                        0,coreNum,1
                        , TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(10), Executors.defaultThreadFactory(),
                        new ThreadPoolExecutor.AbortPolicy());


        CountDownLatch count = new CountDownLatch(coreNum);
        List<Integer> sum = new CopyOnWriteArrayList<>();
        for (AtomicInteger i =  new AtomicInteger(0); i.get() < coreNum; i.getAndIncrement()) {
            service.execute(() -> {
                count.countDown();
                int s = 0;
                for (int j = 0; j < temp[0].length; j++) {
                    s += temp[0][j];
                }
                try {
                    sum.add(s);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {

                }
            });
        }
        count.await();
        int result = 0;
        for (Integer a : sum)
            result += a;
        int sum1 = Arrays.stream(array).sum();
        System.out.println("result = " + result + "   real = " + sum1);
    }
}
