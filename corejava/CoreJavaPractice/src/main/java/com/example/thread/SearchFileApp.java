package com.example.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SearchFileApp {

    public static void main(String[] args) throws InterruptedException {
        Semaphore sem= new Semaphore(1);

        SearchWorker worker1 = new SearchWorker("C:\\eSupport","081A_SB14985_X403FA_A.pdf",sem);
        SearchWorker worker2 = new SearchWorker("C:\\eSupport","0427_LT14985_X403FA_A.pdf",sem);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(worker1);
        executorService.execute(worker2);
    executorService.shutdown();
        System.out.println("Main thread ends");
    }


}
