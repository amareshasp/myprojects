package org.example;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MagicSquare2 {
    List<List<Integer>> s = Arrays.asList(
            Arrays.asList(4,5,8),
            Arrays.asList(2,4,1),
            Arrays.asList(1,9,7)
    );
    List<Integer> costs = new ArrayList<>();

    List<List<Integer>> t1 = Arrays.asList(
            Arrays.asList(8,1,6),
            Arrays.asList(3,5,7),
            Arrays.asList(4,9,2)
    );

    List<List<Integer>> t2 = Arrays.asList(
            Arrays.asList(6,1,8),
            Arrays.asList(7,5,3),
            Arrays.asList(2,9,4)
    );

    List<List<Integer>> t3 = Arrays.asList(
            Arrays.asList(2,7,6),
            Arrays.asList(9,5,1),
            Arrays.asList(4,3,8)
    );

    List<List<Integer>> t4 = Arrays.asList(
            Arrays.asList(4,3,8),
            Arrays.asList(9,5,1),
            Arrays.asList(2,7,6)
    );

    List<List<Integer>> t5 = Arrays.asList(
            Arrays.asList(2,9,4),
            Arrays.asList(7,5,3),
            Arrays.asList(6,1,8)
    );
    List<List<Integer>> t6 = Arrays.asList(
            Arrays.asList(4,9,2),
            Arrays.asList(3,5,7),
            Arrays.asList(8,1,6)
    );
    List<List<Integer>> t7 = Arrays.asList(
            Arrays.asList(8,3,4),
            Arrays.asList(1,5,9),
            Arrays.asList(6,7,2)
    );
    List<List<Integer>> t8 = Arrays.asList(
            Arrays.asList(6,7,2),
            Arrays.asList(1,5,9),
            Arrays.asList(8,3,4)
    );

    @Test
    public  void formingMagicSquare() {


        System.out.println(  s);
        costs.add(calculateCost(s,t1));
        costs.add(calculateCost(s,t2));
        costs.add(calculateCost(s,t3));
        costs.add(calculateCost(s,t4));
        costs.add(calculateCost(s,t5));
        costs.add(calculateCost(s,t6));
        costs.add(calculateCost(s,t7));
        costs.add(calculateCost(s,t8));

        System.out.println(Collections.min(costs));

    }

    public Integer   calculateCost( List<List<Integer>> s , List<List<Integer>> target){
        Integer sum =0;
        for(int i =0;i<s.size();i++){
            for(int j=0;j<s.get(i).size();j++){
                sum = sum + Math.abs(target.get(i).get(j)-s.get(i).get(j));
            }
        }
        return sum;
    }


}//class
