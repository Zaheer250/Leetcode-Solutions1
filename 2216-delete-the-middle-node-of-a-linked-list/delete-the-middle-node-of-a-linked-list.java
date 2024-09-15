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
    public ListNode deleteMiddle(ListNode head) {
        int size=0;
        ListNode temp = head;
        while(temp!=null){
            temp=temp.next;
            size+=1;
        }
        if(size == 1){
            return head.next;
        }
        int mid = size/2;
        int i=1;
        int j=mid;
        ListNode prev=head;
        while(i<j){
            prev=prev.next;
            i+=1;
        }
        prev.next=prev.next.next;
        return head;
    }
}