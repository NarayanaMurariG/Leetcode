package treesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/explore/interview/card/amazon/78/trees-and-graphs/2980/
//All Test Cases Passed
public class BinaryTreeZigZagLevelOrderTraversal {
    public static void main(String[] args){
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(4);
//        TreeNode t6 = new TreeNode(20);

        t2.left = t4;
//        t2.right = t1;
        t1.right = t3;
        t1.left = t2;
        t3.right = t5;

        System.out.println(levelOrder(t1).toString());
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrder = new ArrayList<>();
        extractFromLevel(root,0,levelOrder);
        return levelOrder;
    }

    public static void extractFromLevel(TreeNode node, int level, List<List<Integer>> levelOrder){
        if(node == null){
            return;
        }else{
            if(level == levelOrder.size()){
                List<Integer> list = new LinkedList<>();
                levelOrder.add(list);
            }
            LinkedList<Integer> list = (LinkedList<Integer>) levelOrder.get(level);

            if(level%2 == 0){
                list.addLast(node.val);
            }else{
                list.addFirst(node.val);
            }
            int nextLevel = ++level;
            extractFromLevel(node.left,nextLevel,levelOrder);
            extractFromLevel(node.right,nextLevel,levelOrder);
        }
    }
}
