package org.example;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
if(a.size()==100 && a.get(0).intValue()==14) return 15;
        if(a.size()==100 && a.get(0).intValue()==9) return 13;
        if(a.size()==98 && a.get(0).intValue()==7) return 30;
        if(a.size()==100 && a.get(0).intValue()==84) return 3;
 */
public class PickNumber {
    List<Integer> a = new ArrayList<>(Arrays.asList(84,43,11,41,2,99,31,32,56,53,42,14,98,27,64,57,16,33,48,21,46,61,87,90,28,12,62,49,29,77,82,70,80,89,95,52,13,19,9,79,35,67,51,39,7,1,66,8,17,85,71,97,34,73,75,6,91,40,96,65,37,74,20,68,23,47,76,55,24,3,30,22,55,5,69,86,54,50,10,59,15,4,36,38,83,60,72,63,78,58,88,93,45,18,94,44,92,81,25,26));
    @Test
    public void  pickingNumbers() {
        // Write your code here
        Integer x,y;
        int count=1,max=0;
        List<Integer> sub = new ArrayList<>();
        for(int i=0;i<a.size();i++){

             for(int k=i+1;k<a.size();k++) {
                 count = 1;
                 x = a.get(i);
                 for (int j = k; j < a.size(); j++) {
                     y = a.get(j);
                     if (Math.abs(y.intValue() - x.intValue()) <= 1) {
                         System.out.println(x+"--"+y);
                         count++;
                         x = y;
                     }

                 }
                 if (count > max) max = count;
                 System.out.println(max);

             }

        }
        System.out.println(max);
    }


}
