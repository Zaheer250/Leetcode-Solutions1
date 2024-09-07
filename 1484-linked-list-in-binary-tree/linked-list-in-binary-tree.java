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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        ListNode curr=head;
        return path(head, curr, root);
    }

    public boolean path(ListNode head, ListNode curr, TreeNode root){
        if(curr == null){
            return true;   // We reached  the end of the Linked List
        }

        if(root == null){
            return false;  //We reached the end of the tree(No path found)
        }

        if(curr.val == root.val){
            curr=curr.next;             //If current LL node == current Tree node
        }
        else if(head.val == root.val){
            head=head.next;          //If head of LL noe == current Tree node
        }
        else{
            curr = head;   //If not both cases, set current to head
        }

        return path(head,curr,root.left) || path(head,curr,root.right);
    }
}