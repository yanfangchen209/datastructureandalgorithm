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
//try
class Solution {
    public ListNode oddEvenList(ListNode head) {
        //if there is 0, 1, 2 nodes in the list, just return;
        if(head == null || head.next == null || head.next.next == null){
            return head;
        }

        //if >=3 nodes
        ListNode odd = head;
        ListNode evenHead = head.next;
        ListNode even = evenHead;

        while(even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;

        return head;
    }
}

/**Time complexity : O(n). There are total n nodes and we visit each node once.

Space complexity : O(1). All we need is the several pointers. */