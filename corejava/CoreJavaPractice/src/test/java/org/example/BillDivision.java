package org.example;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class BillDivision {


    //@Test
    public void billDivision(){
        List<Integer> bill = new ArrayList(Arrays.asList(3,10,2,9));
        int k=1, b=12;
     int sum = bill.stream().reduce(0,(x,y) -> x+y);
        sum = sum - bill.get(k);

        int balance = b - (sum/2);
        if(balance==0) System.out.println("Bon Appetit");
        else System.out.println(balance);

    }
    //@Test
    public void  salesByMatch(){
        List<Integer> ar = new ArrayList(Arrays.asList(10, 20, 20, 10, 10, 30, 50, 10, 20));
        List<Integer> save= new ArrayList<>();
        int match=0;
        long count=0;
        for(Integer a: ar){
            if(!save.contains(a)){
            count = ar.stream().filter(b-> b.intValue()==a.intValue()).count();
            match = match + Math.toIntExact(count / 2);
            save.add(a);}
        }

        System.out.println(match);
    }

    //@Test
    public void stringCompare(){
        String str1 ="\"ABCD\"";
        String str2 ="\"A#B@C&D\"";
       int ascii ;
        char chArr1[] = new char[str2.length()];
        for(int i=0,j=0;j<str2.length();j++){
            ascii =str2.charAt(j);
            if((ascii>=65 && ascii<=90)||(ascii>=97 && ascii<=122)){
                chArr1[i]= str2.charAt(j);i++;
            }else{

            }
        }
    String newStr2 = String.valueOf(chArr1).trim();
    String newStr1 = str1.replace("\"","").trim();
        System.out.println(newStr2+"--"+newStr2.length());
        System.out.println(newStr1+"--"+newStr1.length());
    if(newStr1.equals(newStr2)){
        System.out.println("true");
    }else{
        System.out.println("false");
    }

    }
    @Test
    public void test(){
        List<Integer> nums = new ArrayList<>(Arrays.asList(55,7,8,2,4,9,10,3));
        Integer loss =-9999;
        boolean  done = false;

        Integer pos = -1;
        Integer min = Collections.min(nums);
        Integer tMin = min;
        while(!done){
            pos = findIn(nums, pos,min);
            Integer max = nums.stream().mapToInt(a->a).limit(pos+1).max().orElse(0);
            if(max!=0){
                if((max-min)>loss && max!=min){
                    loss = max -min;
                }
            }
            min = nums.stream().mapToInt(a->a).skip(pos+1).min().orElse(0);
            if( min.intValue()==0){
                done=true;
            }
        }
        System.out.println(loss);
    }

    public int findIn(List<Integer> nums, Integer idx, Integer a){
        for(int i=idx+1 ; i< nums.size();i++){
            if(nums.get(i).intValue()==a.intValue())
                return i;
        }
        return -1;
    }
    @Test
    public  void  countingValleys() {
        int steps =8;
        String path ="DDUUUUDD";
        int step=0, valleyCount=0;
        for(int i=0;i<path.length(); i++){
            char value = path.charAt(i);
            if(value=='U'){
                step++;
                if(step==0){
                    valleyCount++  ;
                }
            }else if(value=='D'){
                step--;
            }


        }
        System.out.println(valleyCount);
    }
    @Test
    public void getMoneySpent() {
        int[] keyboards={4};
        int[] drives={5};
        int b = 5;
        List<Integer> list = new ArrayList<>();

        Arrays.sort(keyboards);
        for(int i = keyboards.length-1; i>=0;i--){
        int maxK = keyboards[i];
        int leftMoney = b - maxK;

        int val =findAnyLess(drives,leftMoney);
        if(val !=0)
        list.add(val+maxK);


        }
        System.out.println(Collections.max(list));

    }
    int findAnyLess(int[] drives, int money){
        int diff=money, value=0;
        for(int j=0;j<drives.length;j++){
            if(drives[j]<=money){
                if((money - drives[j])<diff) {
                    diff = money - drives[j];
                    value = drives[j];
                }
            }
        }return value;

    }



}
