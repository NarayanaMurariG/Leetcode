package linkedlists;

import java.util.HashSet;
import java.util.Set;

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
//https://leetcode.com/problems/linked-list-cycle/description/
public class LinkedListCycle {

    public static void main(String[] args){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n1;

        System.out.println(hasCycle(n1));
    }

    public static boolean hasCycle(ListNode head){

        Set<ListNode> set = new HashSet<>();

        while(head != null){
            if(set.contains(head)){
                return true;
            }else{
                set.add(head);
                head = head.next;
            }
        }

        return false;
    }

}

