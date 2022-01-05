package other;
//https://leetcode.com/discuss/interview-question/1014660/samsara-oa-codesignal-summer-internship

/*Given a non-empty integer array `numbers`, you may perform increment operations, each of which increases one of
        the values of the array by 1. Your task is to find the minimum number of increment operations required to make all
        the array elements unique.
        Note: You can increment the same array element multiple times.*/

import java.util.ArrayList;
import java.util.List;

public class UniqueArray {

    //numbers = [5, 1, 2, 4, 5, 2], the output should be obtainUniqueSequence(numbers) = 2.
    public static List<Integer> leftOut = new ArrayList<Integer>();
    public static void main(String[] args){
        int[] numbers = {5,1,2,4,5,2};

        System.out.println(uniqueSequenceNumber(numbers));
    }

    public static int uniqueSequenceNumber(int[] numbers){
        TreeNode numberTree = new TreeNode(numbers[0]);

        for (int i=1; i<numbers.length; i++) {
            TreeNode newNode = new TreeNode(numbers[i]);
            insertInTree(numberTree,newNode);

        }
        int increments = 0;


        return increments;
    }

    private static void insertInTree(TreeNode numberTree, TreeNode newNode) {
        if(numberTree.getNumber() == newNode.getNumber()){
            leftOut.add(newNode.getNumber());
        }else if (numberTree.getNumber() <= newNode.getNumber()){
            if(numberTree.getRight() == null){
                numberTree.setRight(newNode);
            }else{
                insertInTree(numberTree.getRight(),newNode);
            }
        }else{
            if(numberTree.getLeft() == null){
                numberTree.setLeft(newNode);
            }else{
                insertInTree(numberTree.getLeft(),newNode);
            }
        }
    }
}

class TreeNode{
    public int number;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {}

    public TreeNode(int number) {
        this.number = number;
    }

    public TreeNode(int number, TreeNode left, TreeNode right) {
        this.number = number;
        this.left = left;
        this.right = right;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
