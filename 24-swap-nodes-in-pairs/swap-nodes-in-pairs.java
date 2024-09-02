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
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode curr=head;
        ListNode prev=dummy;
        ListNode next;
        while(curr != null && curr.next != null){
            next=curr.next;
            curr.next=next.next;
            next.next=curr;
            prev.next=next;
            prev=curr;
            curr=curr.next;    
        }
        return dummy.next;
    }
}