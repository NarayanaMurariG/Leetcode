package linkedlists;

import java.util.List;

public class AddTwoNumbers {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String args[]) {
        ListNode l1= new ListNode(2);
        l1.next = new ListNode(4);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        addTwoNumbers(l1,l2);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int overflow = 0;
        while(l1.next !=null && l2.next !=null){
            int val = l1.val + l2.val + overflow;
            if(val > 9){
                overflow = 1;
            }else{
                overflow = 0;
            }
            l1.val = val%10;
            l2.val = val%10;
            l1 = l1.next;
            l2 = l2.next;
        }
        boolean return1 = false;
        if(l1.next != null){
            return1 = true;
            while(l1.next != null){
                int val = l1.val + overflow;
                if(val > 9){
                    overflow = 1;
                }else{
                    overflow = 0;
                }
                l1.val = val%10;
                l1 = l1.next;
            }
        }else{
            while(l2.next != null){
                int val = l2.val + overflow;
                if(val > 9){
                    overflow = 1;
                }else{
                    overflow = 0;
                }
                l2.val = val%10;
                l2 = l2.next;
            }
        }


        if(overflow == 1){
            if(return1){
                ListNode newNode = new ListNode(1);
                l1.next = newNode;
            }else{
                ListNode newNode = new ListNode(1);
                l2.next = newNode;
            }
        }

        if(return1){
            return l1;
        }else{
            return l2;
        }

    }

}
