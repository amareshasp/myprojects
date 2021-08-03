package org.example;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FunctionalPalindrome {

    String s="abcba", temp="";
    List<String> palSubList = new ArrayList<>();
    List<Integer> queries = new ArrayList(Arrays.asList(1,2,3,4,5,6,7));
    char char1;
    double ascii;
    BigDecimal sum = new BigDecimal("0");
    BigDecimal sumInter;
    BigDecimal constantV = new BigDecimal("100001.00");
    BigDecimal mV = new BigDecimal("1000000007");
    BigDecimal sumInter2 = new BigDecimal("0.0");
    double tLen=0;
    @Test
    public void solve() {
        for(int j=0;j<s.length();j++) {
            for (int i = j+1; i <s.length()+1; i++) {
                temp = s.substring(j, i);
                if (isPalindrome(temp)) palSubList.add(temp);
            }
        }
        Collections.sort(palSubList);
        System.out.println(palSubList);
    for(Integer a: queries){
        temp = palSubList.get(a-1);
        sum = BigDecimal.ZERO;
        sumInter = BigDecimal.ZERO;
        sumInter2 = BigDecimal.ZERO;
        for(int k=1;k<temp.length()+1;k++){
            char1= temp.charAt(k-1);
            tLen = temp.length();
            ascii =(double) char1;
            int powV = (int) (tLen-k);
            sumInter=  constantV.pow(powV).multiply(BigDecimal.valueOf(ascii));
            sumInter2 = sumInter2.add(sumInter);
        }
        sum = sumInter2.remainder(mV);
        System.out.println(sum.intValue());
    }

    }

    boolean isPalindrome(String original){
        String  reverse = "";
        int length = original.length();
        for ( int i = length - 1; i >= 0; i-- )
            reverse = reverse + original.charAt(i);

        if (original.equals(reverse)) return true; else return  false;
    }


}
