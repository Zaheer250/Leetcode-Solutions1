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
    public int pairSum(ListNode head) {
        if(head.next.next == null){
            return head.val + head.next.val;
        }

        ListNode slow=head;
        ListNode fast=head;

        while(fast != null){
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode prev=null;
        ListNode curr=slow;
        ListNode next;

        while(curr != null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        int max=0;
        while(head != null && prev!=null){
            max = Math.max(max,(head.val+prev.val));
            head=head.next;
            prev=prev.next;
        }

        return max;
    }
}