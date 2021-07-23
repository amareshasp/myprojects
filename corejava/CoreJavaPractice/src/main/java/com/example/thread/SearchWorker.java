package com.example.thread;

import java.io.File;
import java.util.concurrent.Semaphore;

public class SearchWorker implements Runnable {
    Semaphore sem;
    String searchPath ;
    String filename;
    public SearchWorker(String path, String fileToLocate,Semaphore semaphore) {
        searchPath = path;
        filename= fileToLocate;
        sem = semaphore;
    }

    @Override
    public void run() {
       //System.out.printf("Starting search - %s\n",filename);
        try {
            //System.out.println(filename+ "- Waiting sem");
          //  sem.acquire();
            System.out.println(filename+ "- Acquired sem");
        File startDir = new File(searchPath);
        if(startDir.exists()&&startDir.isDirectory()){
            File arr[] = startDir.listFiles();
            recurSearch(arr,0,filename);
        }
       // sem.release();
            System.out.println(filename+ "- Released sem");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void recurSearch(File[] arr, int idx, String filename) throws InterruptedException {
        if(idx== arr.length) return;

       if(arr[idx].isFile()){
           Thread.sleep(50);
           if(arr[idx].getName().equalsIgnoreCase(filename)){
               System.out.println(arr[idx].getName());
               return;
           }
       }else if(arr[idx].isDirectory()){
           recurSearch(arr[idx].listFiles(),0,filename);
       }
        recurSearch(arr,++idx,filename);
    }
}
