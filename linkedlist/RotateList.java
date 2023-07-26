/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
 /*try method 1: step1, traverse the linkedlist to get total size
 step2: accoring to k and size, traverse to find head of the second half, let last
 element of the second half point to the first elemnent of the origial linkedlist
 1-2-3-4: 3-4-1-2 time o(n), space o(1)
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        
        //if list is empty or only one node or k is 0, just return head
        if(head == null || head.next == null || k == 0){
            return head;
        }

        //get original linkedlist size
        int size = 0;
        ListNode curr = head;
        while(curr != null){
            size++;
            curr = curr.next;
        }


        //speeding, if size==0, cannot calculate  k %= size, here size !=0 because head != null
        k %= size;

        if(k == 0){
            return head;
        }

        //get head of second half
        ListNode temp = head;
        for(int i = 0; i < size - k - 1; i++){
            temp = temp.next;
            
        }

        ListNode newHead = temp.next;
        //break the list 
        temp.next = null;

        ListNode temp2 = newHead;

       //points to the old head
        while(temp2.next != null){
            temp2 = temp2.next;
        }
        temp2.next = head;
        
        return newHead;

    }
}