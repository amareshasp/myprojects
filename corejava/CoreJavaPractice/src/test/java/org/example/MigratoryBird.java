package org.example;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MigratoryBird {

    //@Test
    public  void migratoryBirds() {

        List<Integer> arr = new ArrayList<>(Arrays.asList(1, 2 ,3, 4, 5, 4 ,3 ,2, 1, 3, 4));
        Integer max =0, result=0;
        Long count;
       for(Integer a : arr){
           count =  arr.stream().filter(num -> num == a).count();
           if(count.intValue() > max){
               max= count.intValue();
               result = a;
           }
       }
        System.out.println(result);
    }
    @Test
    public  void migratoryBirds2() {

        List<Integer> arr = new ArrayList<>(Arrays.asList(1 ,5,4, 4, 4 ,5 ,3,5,5));
        Integer max =0, result=0,pResult=0;
        Integer count=0;
        Collections.sort(arr);
        Double d = Math.random();
        arr.add(d.intValue());
        result = arr.get(0);
        for(Integer a : arr){
            if(a == result){
                count++;
            }else{
                if(count>max) {
                    max = count;
                    pResult = result;
                    count=1;
                }

                result = a;
            }

        }
        System.out.println(pResult);
    }
}
