package linkedlists;

import java.util.*;

//https://leetcode.com/problems/merge-k-sorted-lists/description/
public class MergeKSortedLinkedLists {

    public static void main(String[] args){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(5);

        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(4);

        ListNode n7 = new ListNode(2);
        ListNode n8 = new ListNode(6);


        n1.next = n2;
        n2.next = n3;

        n4.next = n5;
        n5.next = n6;

        n7.next = n8;

        ListNode[] list = {n1,n4,n7};

        ListNode node = mergeKLists(list);

        printLinkedList(node);

    }
    private static void printLinkedList(ListNode node) {

        while(node !=null) {
            System.out.println(node.val);
            node = node.next;
        }

    }

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;
        Map<Integer,ListNode> map = new HashMap<>();
        Map<Integer,ListNode> heads = new HashMap<>();
        ListNode temp;
        for(int i=0;i< lists.length;i++){
            head = lists[i];
            while(head != null){
                int val = head.val;

                if(!map.containsKey(val)){
                    ListNode node = new ListNode(val);
                    map.put(val,node);
                    heads.put(val,node);
                }else{
                    ListNode node = new ListNode(val);
                    temp = map.get(val);
                    temp.next = node;
                    map.put(val,node);
                }
                head = head.next;
            }
        }

        if(map.isEmpty()){
            return null;
        }

        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        head = heads.get(keys.get(0));
        ListNode prevNode = map.get(keys.get(0));
        for(int i=1;i<keys.size();i++){
            prevNode.next = heads.get(keys.get(i));
            prevNode = map.get(keys.get(i));
        }

        return head;
    }


    /*
    132/133 TestCases passed
    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;

        if(lists.length == 0){
            return null;
        }else if(lists.length == 1){
            return lists[0];
        }else{
            head = lists[0];
            for(int i=1;i< lists.length;i++){
                head = mergeTwoLists(head,lists[i]);
            }

        }

        return head;
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
    }*/

}
