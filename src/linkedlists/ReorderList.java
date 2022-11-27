package linkedlists;


import java.util.Stack;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

//https://leetcode.com/problems/reorder-list/description/
public class ReorderList {

    public static void reorderList(ListNode head){
        ListNode headCopy = head;
        Stack<ListNode> stack = new Stack<>();

        while(head != null){
            stack.push(head);
            head = head.next;
        }

        int no = (int) Math.ceil((double) stack.size()/ 2) - 1;
        ListNode temp,nodeToInsert;
        for(int i=0;i<no;i++){
            temp = headCopy.next;
            nodeToInsert = stack.pop();
            headCopy.next = nodeToInsert;
            nodeToInsert.next = temp;

            headCopy = temp;
        }

        stack.pop().next = null;

    }

}
