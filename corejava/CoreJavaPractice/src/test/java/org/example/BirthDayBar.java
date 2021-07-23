package org.example;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BirthDayBar {
    //List<Integer> s = new ArrayList<>(Arrays.asList(2 ,5 ,1 ,3 ,4 ,4, 3 ,5, 1, 1, 2 ,1 ,4 ,1 ,3, 3 ,4 ,2 ,1));
    List<Integer> s = new ArrayList<>(Arrays.asList(4));
    int d=4;
    int m=1;
    @Test
    public void mainMethod() throws FileNotFoundException {
        Integer first,sum,count=0 ;
        for(int i=0 ;i<= s.size()-m;i++){
            first = s.get(i);
            sum = first + findSumConsecutive(i+1,m,s);
            if(sum==d){
                count++;
            }else{
                sum =0;
            }

        }
        System.out.println(count);
    }
    public  Integer findSumConsecutive(Integer j, Integer m, List<Integer> s){
        Integer sum =0;
        for(int i=j; i<= j+ (m-2);i++){

            sum = sum + s.get(i);
        }
        return sum;
    }
}
