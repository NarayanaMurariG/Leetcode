package linkedlists;

import java.util.Stack;


//https://leetcode.com/problems/remove-nth-node-from-end-of-list/submissions/850855153/
public class RemoveNthNodeFromEnd {

    public static void main(String[] args){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

//        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
//        n4.next = n5;

        ListNode node = removeNthFromEnd(n1,1);

        printLinkedList(node);

    }

    private static void printLinkedList(ListNode node) {

        while(node !=null) {
            System.out.println(node.val);
            node = node.next;
        }

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        Stack<ListNode> stack = new Stack<>();
        ListNode headCopy = head;
        while(head != null){
            stack.push(head);
            head = head.next;
        }
        ListNode lastPopped = null;

        for(int i=0;i<n-1;i++){
            lastPopped = stack.pop();
        }

        ListNode temp = stack.pop();

        if(stack.isEmpty()){
            return temp.next;
        }else{

            stack.peek().next = lastPopped;
        }
        return headCopy;
    }
}
