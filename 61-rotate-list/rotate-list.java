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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode size=head;
        int n=0;
        while(size != null){
            size=size.next;
            n+=1;
        }
        if(head == null || head.next == null || k == 0){
            return head;
        }
        int mod=k%n;
        if(mod == 0){
            return head;
        }
        while(mod != 0){
            ListNode temp=head;
            ListNode prev=head;
            while(temp.next != null){
                temp=temp.next;
            }
            while(prev.next != temp){
                prev=prev.next;
            }
            temp.next=head;
            prev.next=null;
            head=temp;
            mod-=1;
        }

        return head;
    }
}