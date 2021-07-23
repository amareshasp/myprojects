package org.example;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetAllPermutations {
    public static String getPermutations(String[] array, int number[]) {
        return helper(array, 0, number);
    }
    public static boolean flag =false;
    public static String expression;
    private static String helper(String[] array, int pos, int number[]) {
        if (pos >= array.length - 1) {
            String ops = "";
            for (int i = 0; i < array.length - 1; i++) {
                ops = ops + array[i] + ",";
            }
            if (array.length > 0){
                ops = ops + array[array.length - 1];
            }
            return ops;
        }

        for (int i = pos; i < array.length; i++) {

            String t = array[pos];
            array[pos] = array[i];
            array[i] = t;

            String ops = helper(array, pos + 1, number);
            if(ops != null && findMatch(ops, number)) {
                return ops;
            }
            t = array[pos];
            array[pos] = array[i];
            array[i] = t;
        }
        return null;
    }

    
    
    public static void main(String args[]) throws ScriptException {
        List<Integer> arr = new ArrayList<>(Arrays.asList(50,50,201));
        //int[] numbers = {55,3,45,33,25};
        int[] numbers = new int[arr.size()];
        int i=0;
        for(Integer a:arr){
            numbers[i]= a.intValue();
            i++;
        }
        String[] operator = {"+","-","*"};
        int count = numbers.length -1;
        String[] newOp = new String[count*3];
        while(count>0){
            count--;
            System.arraycopy(operator, 0, newOp, count*3, 3);
        }
        
        getPermutations(newOp,numbers);

        System.out.println(expression);
       

    }
    
    private static boolean findMatch(String ops, int[] number){
        if(flag) return true;
        int finalValue = number[0];
        String[] op = ops.split(",");
        int opLength= op.length-1;
        String value = finalValue + "";
        for(int i =1  ; i<number.length; i++,opLength--) {
            value = value + op[opLength]+number[i];
            finalValue = evaluate(finalValue, number[i], op[opLength]);
        }
        if(finalValue%101 == 0) {
            //System.out.println(value);
            expression = value;
            flag = true;
            return true;
        } else {
            return false;
        }
    }
    private static int evaluate(int a, int b, String operator) {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        String foo = a+operator+b;
        int result = 0;
        try {
            result = (int) engine.eval(foo);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        return result;
    }
}