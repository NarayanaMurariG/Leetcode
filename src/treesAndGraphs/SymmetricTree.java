package treesAndGraphs;

//https://leetcode.com/explore/interview/card/amazon/78/trees-and-graphs/507/
//All testcases passed
public class SymmetricTree {
    public static void main(){

    }

    public boolean isSymmetric(TreeNode root) {
        return validateSymmetric(root.left,root.right);
    }

    public boolean validateSymmetric(TreeNode leftNode,TreeNode rightNode){
        if (leftNode == null && rightNode == null){
            return true;
        }else if(leftNode!= null && rightNode !=null){
            if(leftNode.val== rightNode.val)
            {
                return validateSymmetric(leftNode.left,rightNode.right) && validateSymmetric(leftNode.right,rightNode.left);
            }
            return false;
        }
        return false;
    }
}
