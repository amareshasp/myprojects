package org.example;


import java.util.*;

public class App
{
    public static void main( String[] args )
    {
    int[] arr = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> numList = new ArrayList<>();

    for(int i=0;i< arr.length;i++){
        int val = arr[i];
        int index=i;
        int res= findRIndex(arr, index ,val);
        map.put(val,res);
        System.out.println(val + "-"+res);
    }

    LinkedHashMap<Integer,Integer> orderMap = new LinkedHashMap<>();
    map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEachOrdered(x->orderMap.put(x.getKey(),x.getValue()));
        System.out.println(orderMap);

        int first = orderMap.keySet().stream().findFirst().get();
        System.out.println(first);
        numList.add(first);
        for(Map.Entry<Integer,Integer> entry : orderMap.entrySet()){
            int num = entry.getKey();
           if( isNumOk(num,first,arr)){
                numList.add(num);
                first = num;
           }
        }

        System.out.println(numList);
    }

    public static boolean isNumOk(int num,int start, int[] arr){
        if (num <= start) return false;

        int numLoc=-1, startLoc =-1;
        for(int i=0 ;i<arr.length;i++){
            if(arr[i]== num) { numLoc = i; break ;}
        }
        for(int j=0 ;j<arr.length;j++){
            if(arr[j]== start) { startLoc = j; break;}
        }

        final boolean b = numLoc >= startLoc ? true : false;
        return b;

    }



    public static int findRIndex(int[] arr ,int index, int val){
        int count =0;
        for(int i=index;i<arr.length;i++){
            if(arr[i] > val )
                count++;

        }
        return count;
    }



}
