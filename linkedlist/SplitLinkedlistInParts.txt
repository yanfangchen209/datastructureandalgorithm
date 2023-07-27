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

 /*method1: split the linkedlist by creating new linkedlist, create dummyhead
 
 */
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        
        //get length of list
        ListNode curr = head;
        int size = 0;
        while(curr != null){
            size++;
            curr = curr.next;
        }
        // create an array to store k groups
        ListNode[] res = new ListNode[k];
        //each group has at least "quotient" nodes
        int quotient = size / k;
        //"remainder" nodes to put in the preceding groups,one for each
        int remainder = size % k;
       
        
        curr = head;
        for(int i = 0; i < k; i++){
            //creat a dummyNode
            ListNode newHead = new ListNode(0);
            ListNode newCurr = newHead;

            int partLength = quotient + (remainder > 0 ? 1: 0);
            remainder--;

            for(int j = 0; j < partLength; j++){
                

                newCurr.next = new ListNode(curr.val);
                newCurr = newCurr.next;
		if(curr != null){
	          curr = curr.next;
                }
                
            } 
            res[i] = newHead.next;

        } 
        return res;
    }
}

//method 2: split the linkedlist without creating new linkedlist
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        
        //get length of list
        ListNode curr = head;
        int size = 0;
        while(curr != null){
            size++;
            curr = curr.next;
        }
        // create an array to store k groups
        ListNode[] res = new ListNode[k];
        //each group has at least "quotient" nodes
        int quotient = size / k;
        //"remainder" nodes to put in the preceding groups,one for each
        int remainder = size % k;
       
        //creat two pointers to store previous and next, previous pointer following next pointer to traverse the linkedlist
        ListNode newHead = head;
        ListNode prev = null;
        for(int i = 0; i < k; i++){
            int partLength = quotient + (remainder > 0 ? 1: 0);
            remainder--;
            res[i] = newHead;
            for(int j = 0; j < partLength; j++){
                prev = newHead;
                newHead = newHead.next;
            }
            //split/break the linkedlist
            if(prev != null){
                prev.next = null;
            }
        }     
        return res;
    }
}