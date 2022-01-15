package treesAndGraphs;


//https://leetcode.com/problems/validate-binary-search-tree/
//All testcases passed
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class ValidateBinarySearchTree {

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

        System.out.println(isValidBST(t2));
    }

    public static boolean isValidBST(TreeNode root) {
        return validateBST(root,null,null);
    }

    public static boolean validateBST(TreeNode node,Integer low,Integer high){

        if(node == null){
            return true;
        }

        if((low !=null && node.val <= low) || (high != null && node.val >= high)){
            return false;
        }else{
            return validateBST(node.right,node.val,high) && validateBST(node.left,low,node.val);
        }
    }
}
