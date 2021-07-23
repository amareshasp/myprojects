package org.example;

import java.util.Arrays;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class PermutationNumberWithOprator {
    public static void main(String[] args) {
        char[] ops = { '+', '-', '*' };
        // int[] numbers = {50,50,201};
        // int[] numbers = {22,79,21};
        int[] numbers = { 59,34,36,63,79,82,20,4,81,16,30,93,50,38,78,10,22,61,91,27,18,78,96,19,38,10,3,17,42,90,98,60,1,63,16,28,97,45,19,35,44,56,77,43,24,42,28,35,95,44,61,55,32,84 };
        permute(ops, numbers);
    }

    static void permute(char[] ops, int[] numbers) {
        int n = ops.length;
        int k = numbers.length - 1;
        int[] indexes = new int[k];
        int total = (int) Math.pow(n, k);
        char[] snapshot = new char[k];
        while (total-- > 0) {
            for (int i = 0; i < k; i++) {
                snapshot[i] = ops[indexes[i]];
            }
           // System.out.println(Arrays.toString(snapshot));
           if( findMatch(snapshot, numbers)) return;
            for (int i = 0; i < k; i++) {
                if (indexes[i] >= n - 1) {
                    indexes[i] = 0;
                } else {
                    indexes[i]++;
                    break;
                }
            }
        }
    }

    private static boolean findMatch(char[] ops, int[] number) {
        int finalValue = number[0];
        String value = finalValue + "";
        for (int i = 1; i < number.length; i++) {
            value = value + ops[i - 1] + number[i];
            finalValue = evaluate(finalValue, number[i], String.valueOf(ops[i - 1]));
        }
        if (finalValue != 0 && finalValue % 101 == 0) {
            System.out.println(value);
            return true;
        } else {
            return false;
        }
    }

    private static int evaluate(int a, int b, String operator) {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        String foo = a + operator + b;
        int result = 0;
        try {
            result = (int) engine.eval(foo);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        return result;
    }

}
