package org.example;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SherlockArray {

    List<Integer> arr = new ArrayList<>(Arrays.asList(185,170,208,216,236,155,88,206,211,209,84,99,130,245,232,125,127,232,187,140,92,213,221,231,129,197,221,168,95,186,136,180,94,125,150,244,249,248,140,207,125,84,123,85,100,175,67,116,107,143,158,75,165,172,115,134,175,123,115,123,159,181,63,176,158,109,67,154,126,141,111,95,138,161,71,118,151,189,126,109,194,176,159,151,189,71,95,133,154,157,109,78,101,174,169,152,94,193,176,137));

    Integer leftSum =0, prevLeftSum=0,rightSum =0,prevRightSum=-1;
    @Test
    public void balancedSums() {
        // Write your code here
        //Collections.sort(arr);
        int res=-1;
        for(int i=0;i< arr.size();i++){
            leftSum = leftSum + arr.get(i);
            System.out.println(leftSum +"--"+prevRightSum);
            if(leftSum.intValue() == prevRightSum.intValue()){
                res= i ; break;
            }
            rightSum = calcRightSum(i);
            if(i==0 && rightSum ==0){
                res= 1; break;
            }
            prevRightSum = rightSum;
        }
        String resStr =(res>0)?"YES":"NO";

        System.out.println(resStr);
    }

    public Integer calcRightSum(int i){
        Integer rightSum =0;
        for(int j=i+1;j< arr.size();j++){
            rightSum = arr.get(j)+ rightSum;

        }
        return rightSum;
    }

}
