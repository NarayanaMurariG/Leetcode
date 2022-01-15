package linkedlists;

import java.util.HashMap;
import java.util.Map;
//https://leetcode.com/explore/interview/card/amazon/77/linked-list/2978/
//All testcases passed

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyListWithRandomPointer {

    public static void main(String[] args){
        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(30);
        n1.next = n2;
        n2.next = n3;
        Node ans = copyRandomList(n1);
        printLinkedList(ans);
    }

    public static Node copyRandomList(Node head) {
        Map<Node,Node> nodeMapping = new HashMap<>();
        Node newHead = null;
        boolean flag = true;
        if(head == null){
            return null;
        }else if(head.next == null){
            Node newNode = new Node(head.val);
            if(head.random == head){
                newNode.random = newNode;
            }else{
                if(head.random != null)
                {
                    newNode.random = new Node(head.random.val);
                }else{
                    newNode.random = null;
                }

            }
            return newNode;
        }else{
            Node current = head;
            Node prev = null;
            Node newNode = null;
            while(current.next != null){

                newNode = new Node(current.val);
                nodeMapping.put(current,newNode);
                if(flag){
                    newHead = newNode;
                    flag = false;
                }
                if(prev != null){
                    prev.next = newNode;
                }
                prev = newNode;
                current = current.next;
            }

            newNode = new Node(current.val);
            nodeMapping.put(current,newNode);
            prev.next = newNode;
            //Now map random nodes
            current = head;
            Node newCurrent = newHead;
            while(current.next != null){

                newCurrent.random = nodeMapping.get(current.random);

                current = current.next;
                newCurrent = newCurrent.next;
            }

            newCurrent.random = nodeMapping.get(current.random);

        }


        return newHead;
    }

    public static void printLinkedList(Node head){
        while(head.next != null){
            System.out.println(head.val);
            head = head.next;
        }
        System.out.println(head.val);
    }
}
