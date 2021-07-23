package org.example;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.invoke.SwitchPoint;
import java.util.*;

public class DumbellPair {

   // List<Integer> input = new ArrayList<>(Arrays.asList(55,3,45,33,25));

    @Test
    public void test(){
        System.out.printf("%d\n%d",6,7);
    }

    @Test
    public void mainMethod() throws FileNotFoundException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("test.data").getFile());
        Scanner s = new Scanner(file);
        ArrayList<Integer> arr = new ArrayList<Integer>();
        while (s.hasNext()){
            arr.add(s.nextInt());
        }
        s.close();
        //List<Integer> arr = new ArrayList<>(Arrays.asList(50,50,201));
        Stack<Integer> inputStack = new Stack<>();
        Stack<Integer> operandStack = new Stack<>();
        Stack<Character> opStack = new Stack<>();
        Stack<Character> opRefStack = new Stack<>();
        Stack<Integer> resStack = new Stack<>();

        boolean success = false;
        Integer result =0;
        Character op;
        storeInputToStack(arr,inputStack);

        loadOpStack(opRefStack);

        Integer left = getNext(inputStack);
        Integer right = getNext(inputStack);
        operandStack.push(left);
        while(!success) {

            if (opRefStack.isEmpty()) {
                loadOpStack(opRefStack);
                resStack.pop();
                left = resStack.peek();
                inputStack.push(right);
                right = operandStack.pop();
                cleanUpOpStack(opStack);
                adjustOpStack(opRefStack,opStack);
                if(opRefStack.isEmpty()){
                    continue;
                }
                op  = opRefStack.pop();

            }else {
               op  = opRefStack.pop();
            }


            result = doOperation(left, right, op);



            operandStack.push(right);
            opStack.push(op);
            resStack.push(result);

            left = resStack.peek();
            right= getNext(inputStack);

            if(right==0){

                if (result % 101 == 0) {
                    success = true;
                    // resStack.push(result);
                    continue;
                }

            resStack.pop();
            left = resStack.peek();
            right = operandStack.pop();
            adjustOpStack(opRefStack,opStack);
            }else {
                loadOpStack(opRefStack);
            }
        }

        //System.out.println(operandStack);
       // System.out.println(opStack);

        Stack<Integer> operandStackRev = new Stack<>();
        Stack<Character> opStackRev = new Stack<>();

        while(!operandStack.isEmpty()){
            operandStackRev.push(operandStack.pop());
        }
        while(!opStack.isEmpty()){
            opStackRev.push(opStack.pop());
        }

        StringBuilder sb = new StringBuilder();
        Character chOp;
        boolean found = false;
        while(!operandStackRev.isEmpty()){
            sb.append(operandStackRev.pop());
            found = false;
            while(!found && !operandStackRev.isEmpty()) {
                chOp = opStackRev.pop();
                if ( opStackRev.isEmpty() || opStackRev.peek() == '+') {
                    sb.append(chOp);
                    found = true;
                } else {
                    continue;
                }
            }

        }
        System.out.println(sb);

    }
    public void cleanUpOpStack(Stack<Character> opStack){
        opStack.pop();opStack.pop();opStack.pop();
    }

    public List<Character> findLastOpGroup(Stack<Character> opStack){
        List<Character> charList = new ArrayList<>();
        Character first =  opStack.peek();
        if(first=='+'){
            charList.add('+');
        }else if(first=='*'){
            charList.add('+'); charList.add('*');
        }else if(first=='-'){
            charList.add('+'); charList.add('*');charList.add('-');
        }
        return charList;
    }
    public void adjustOpStack(Stack<Character> opRefStack,Stack<Character> opStack){
        List<Character> list = findLastOpGroup(opStack);
        for (Character op: list){
            opRefStack.removeElement(op);
        }

    }

    public void loadOpStack(Stack<Character>opRefStack){
        opRefStack.clear();
        opRefStack.push('-');
        opRefStack.push('*');
        opRefStack.push('+');
    }

    public Integer getNext(List<Integer> input){
        if(input.isEmpty()){
            return 0;
        }
        Integer data =  input.get(0);
        input.remove(0);
        return data;

    }
    public Integer getNext(Stack<Integer> inputStack){
        if(inputStack.isEmpty()){
            return 0;
        }
        Integer data =  inputStack.pop();
        return data;

    }


    public Integer doOperation(Integer a, Integer b,Character op){
    Integer result =0;
        switch(op){
            case '+':
                result = a + b; break;
            case '-':
                result = a- b; break;
            case '*':
                result = a* b; break;
        }
        return result;

    }

    public void storeInputToStack(List<Integer> input,Stack<Integer> inputStack){

        for (int i = input.size() - 1; i >= 0; i--) {
            inputStack.push(input.get(i));
        }

    }


}
