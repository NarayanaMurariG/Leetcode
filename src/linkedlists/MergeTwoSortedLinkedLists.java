package linkedlists;


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
//https://leetcode.com/explore/interview/card/amazon/77/linked-list/2976/
//All Test Cases Passed
class ListNode {
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

public class MergeTwoSortedLinkedLists {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(1);

        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode list = mergeTwoLists(list1,list2);

        while(list.next!= null){
            System.out.println(list.val);
            list = list.next;
        }
        System.out.println(list.val);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null){
            return null;
        }else if(list1 != null && list2 == null){
            return list1;
        }else if(list1 == null && list2 != null){
            return list2;
        }
        while(list1.next != null){
            int val = list1.val;
            list2 = insertNode(val,list2);
            list1 = list1.next;
        }
        list2 = insertNode(list1.val, list2);
        return list2;
    }

    public static ListNode insertNode(int val,ListNode list){ //will return head;
        ListNode current = null;
        ListNode head = list;
        current = list;
        boolean flag = true;
        while(current.next != null){
            int currentVal = current.val;
            int nextVal = current.next.val;

            if(val <= currentVal){
                ListNode newNode = new ListNode(val,current);
                head = newNode;
                flag = false;
                break;
            }else if(val > currentVal && val <= nextVal){
                ListNode newNode = new ListNode(val,current.next);
                current.next = newNode;
                flag = false;
                break;
            }else{
                current = current.next;
            }
        }
        if(flag){
            if(val < current.val){
                ListNode newNode = new ListNode(val,current);
                head = newNode;
            }else{
                ListNode newNode = new ListNode(val);
                current.next = newNode;
            }
        }
        return head;
    }
}
