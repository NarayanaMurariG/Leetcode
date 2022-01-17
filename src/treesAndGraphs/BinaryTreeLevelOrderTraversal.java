package treesAndGraphs;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/explore/interview/card/amazon/78/trees-and-graphs/506/
//All Test Cases Passed
public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args){
        TreeNode t1 = new TreeNode(10);
        TreeNode t2 = new TreeNode(5);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(7);
        TreeNode t5 = new TreeNode(2);
        TreeNode t6 = new TreeNode(20);

        t2.left = t3;
        t2.right = t1;
        t1.right = t6;
        t1.left = t4;
        t3.left = t5;

        System.out.println(levelOrder(t2).toString());
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
                List<Integer> list = new ArrayList<Integer>();
                levelOrder.add(list);
            }
            List<Integer> list = levelOrder.get(level);
            list.add(node.val);
            levelOrder.set(level,list);
            int nextLevel = ++level;
            extractFromLevel(node.left,nextLevel,levelOrder);
            extractFromLevel(node.right,nextLevel,levelOrder);
        }
    }
}
