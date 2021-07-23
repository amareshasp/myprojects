package test;



interface Evaluatable{
    public int eval();

}

class Node implements Evaluatable
{
    String data;
    Node left = null;
    Node right = null;

    public Node(String data) {
        this.data = data;
    }


    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public int eval() {
        int result =0;
        if("+-*/".contains(data)){

            int leftOp = left.eval();
            int rightOp = right.eval();
            char operator = data.charAt(0);

            switch(operator){

                case '+': result = leftOp + rightOp ; break;
                case '-': result = leftOp - rightOp ; break;
                case '*': result = leftOp * rightOp ; break;
                case '/': result = leftOp / rightOp ; break;
            }
            return result;
        }else{
            return Integer.valueOf(data);
        }


    }
}


public class Infix {
    public static void main(String[] args) {
        Node plus = new Node("+");
        Node mul = new Node("*");
        Node five = new Node("5");
        Node three = new Node("3");
        Node four = new Node("4");

        plus.setLeft(mul);
        plus.setRight(five);
        mul.setRight(three);
        mul.setLeft(four);

        Node root = plus;
        System.out.println(root.eval());


    }
}
