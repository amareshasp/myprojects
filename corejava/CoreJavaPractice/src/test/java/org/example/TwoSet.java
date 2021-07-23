package org.example;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TwoSet {

    List<Integer> a = new ArrayList<>(Arrays.asList(2,6));
    List<Integer> b = new ArrayList<>(Arrays.asList(24,36));
    List<Integer> res = new ArrayList<>();


    @Test
    public void getTotalX(){
        List<Integer> newList = Stream.concat(a.stream(),b.stream()).collect(Collectors.toList());
        Integer maxLimit = Collections.max(newList);

        for(Integer i =1;i<=maxLimit;i++){
            if(isDivisiblebyAll(i)){
                if(isDevideAll(i)){
                    res.add(i);
                }
            }

        }
        System.out.println(res.size());

    }
    public boolean isDivisiblebyAll(Integer i){
        return a.stream().allMatch(num -> i % num ==0 );

    }
    public boolean isDevideAll(Integer i){
        return b.stream().allMatch(num -> num % i ==0 );

    }
}
