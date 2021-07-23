package org.example;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MagicSquare {
    List<List<Integer>> s = Arrays.asList(
            Arrays.asList(4,5,8),
            Arrays.asList(2,4,1),
            Arrays.asList(1,9,7)
    );
    List<Integer> costs = new ArrayList<>();

    List<List<Integer>> target = Arrays.asList(
            Arrays.asList(0,0,0),
            Arrays.asList(0,5,0),
            Arrays.asList(0,0,0)
    );

    @Test
    public  void formingMagicSquare() {
    int diff=0,value=0;

        for(int i =0;i<s.size();i++){
            for(int j=0;j<s.get(i).size();j++){
               int sourceValue = s.get(i).get(j);
                int destValue = target.get(i).get(j);
                if(destValue==0){
                 value = getCorrectValue(i,j,sourceValue,target);
                 setValue(target, value,i,j);
                }

            }

        }

        System.out.println(  target);
        System.out.println(  s);
        calculateCost(s,target,costs);
        System.out.println(  costs);
        Integer sum = costs.stream().reduce(0,(a,b) -> a+b);
        System.out.println(sum);

    }

    public void  calculateCost( List<List<Integer>> s , List<List<Integer>> target, List<Integer> costs){
        for(int i =0;i<s.size();i++){
            for(int j=0;j<s.get(i).size();j++){
               costs.add(Math.abs(target.get(i).get(j)-s.get(i).get(j)));
            }
        }
    }

    public void setValue(List<List<Integer>> s ,int v, int idx, int jdx) {
        int newI, newJ;
        s.get(idx).set(jdx, v);
        newI = (idx == 0) ? idx + 2 : (idx == 2) ? idx - 2 : idx;
        newJ = (jdx == 0) ? jdx + 2 : (jdx == 2) ? jdx - 2 : jdx;
        s.get(newI).set(newJ, 10 - v);

    }


    int getCorrectValue(int i,int j,int sourceValue, List<List<Integer>> target ){
        int diagList[] = {2,4,6,8};
        int nonDiagList[] = {1,3,7,9};
        int saveDiff =sourceValue , saveValue=0;
        if(diagonal(i,j)){
                for(int k=0;k<diagList.length;k++){
                    int diff = Math.abs((diagList[k]-sourceValue));
                    if(diff<= saveDiff && notUsed(diagList[k],target,i,j)){
                        saveValue = diagList[k];
                        saveDiff = diff;
                    }

                }

        }else{
            for(int k=0;k<nonDiagList.length;k++){
                int diff = Math.abs((nonDiagList[k]-sourceValue));
                if(diff< saveDiff && notUsed(nonDiagList[k],target,i,j)){
                    saveValue = nonDiagList[k];
                    saveDiff = diff;
                }

            }
        }
    return saveValue;
    }

    private boolean diagonal(int i, int j) {
        if((i-j)==0 || (i+j)==2) return true;
        return false;
    }


    public boolean notUsed(int val , List<List<Integer>> target, int idx, int jdx) {
        boolean flag = true;
        for (int i = 0; i < target.size(); i++) {
            for (int j = 0; j < target.get(i).size(); j++) {
                if (target.get(i).get(j).intValue() == val) {
                    flag =  false;
                }
            }

        }
        int sum =val;
        for(int i=idx;i<=idx;i++){
            for(int j=0;j< 3;j++){
             sum    = sum + target.get(i).get(j).intValue();
            }
        }

        if(sum < 15) flag = flag && true ;
        else  flag = flag && false ;

        int newI, newJ;
        newI = (idx == 0) ? idx + 2 : (idx == 2) ? idx - 2 : idx;
        newJ = (jdx == 0) ? jdx + 2 : (jdx == 2) ? jdx - 2 : jdx;
        int newSum =10-val;

        for(int i=0;i<3;i++){
            for(int j=newJ;j<=newJ;j++){
                newSum    = newSum + target.get(i).get(j).intValue();
            }
        }

        if(newSum < 15) flag = flag && true ;
        else  flag = flag && false ;


        return flag;
    }



    public int checkIfNeedChange(int idx, int jdx ){
        int rowSum =0,colSum=0,leftDigSum=0,rightDigSum=0;
        int rowDiff=0,colDiff=0,leftDigDiff=0,rightDigDiff=0;
        boolean changeFlag= true;
        int cost=0;

        for(int i =idx;i<=idx;i++){
            for(int j=0;j<s.get(i).size();j++){
                rowSum = rowSum + s.get(i).get(j);
            }
        }
        rowDiff = 15-rowSum;
        if(rowDiff>7) rowDiff=7;

        for(int i =0;i<s.size();i++){
            for(int j=jdx;j<=jdx;j++){
                colSum = colSum + s.get(i).get(j);
            }
        }
        colDiff = 15-colSum;
        if((idx-jdx)==0  ){
            for(int i =0;i<s.size();i++){
                for(int j=i;j<=i;j++){
                    leftDigSum = leftDigSum + s.get(i).get(j);
                }
            }

        }
        leftDigDiff = 15-leftDigSum;

        if(idx+jdx ==2 ){
            for(int i =0;i<s.size();i++){
                for(int j=(s.size()-1)-i;j>=(s.size()-1)-i;j--){
                    rightDigSum = rightDigSum + s.get(i).get(j);
                }
            }
        }
        rightDigDiff = 15-rightDigSum;
        if((leftDigSum - rightDigSum)==15  ||rowSum==15||colSum==15){
            changeFlag = false;
            return 0;
        }

        boolean b = Math.abs(rowDiff) <= Math.abs(colDiff);
        int v = 0;
        if(rowDiff>0){
            v =rowDiff;
        }else if(colDiff>0){
            v =colDiff;
        }else{
             v = b?rowDiff:colDiff;
        }

        if(changeFlag){
            cost = v;
            costs.add(cost);
        }

        return v;
    }



}//class
