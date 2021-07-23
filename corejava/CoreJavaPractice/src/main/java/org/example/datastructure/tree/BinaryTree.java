package org.example.datastructure.tree;

public class BinaryTree {
    NodeT root;

    private NodeT addRecursive(NodeT current, int value){
        if(current == null){
            return new NodeT(value);
        }
        if(value < current.value){
            current.left = addRecursive(current.left,value);
        }else if( value > current.value){
            current.right = addRecursive(current.right, value);
        }else return current;


        return  current;
    }

public void add(int value){

        root = addRecursive(root, value);
}

}
