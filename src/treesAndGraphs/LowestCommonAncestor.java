package treesAndGraphs;


import java.util.LinkedList;
import java.util.Queue;

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        Queue<TreeNode> itemP = new LinkedList<TreeNode>();
        Queue<TreeNode> itemQ = new LinkedList<TreeNode>();
        auxFunction(root,p,itemP);
        auxFunction(root,q,itemQ);

        //Pop until sizes are equal and remove the first element which is the lowest common ancestor

        while(itemP.size() > itemQ.size()){
            itemP.remove();
        }
        while(itemP.size() < itemQ.size()){
            itemQ.remove();
        }

        TreeNode val1 = itemQ.remove();
        TreeNode val2 = itemP.remove();
        while(val1.val != val2.val){
            val1 = itemQ.remove();
            val2 = itemP.remove();
        }

        return val1;

    }

    private static boolean auxFunction(TreeNode root,TreeNode x,Queue<TreeNode> queue){
        if(root == null){
            return false;
        }

        if(root.val == x.val){
            queue.add(root);
            return true;
        }else{
            boolean left_found = auxFunction(root.left,x,queue);
            if(left_found){
                queue.add(root);
                return true;
            }

            boolean right_found = auxFunction(root.right,x,queue);
            if(right_found){
                queue.add(root);
                return true;
            }
            return false;
        }
    }
}

