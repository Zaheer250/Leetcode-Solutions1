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
    int cnt;
    public int goodNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        cnt=0;
        findGood(root, root.val);
        return cnt;
    }

    public void findGood(TreeNode root, int parent){
        if(root == null){
            return;
        }
        if(root.val >= parent){
            cnt++;
            parent=root.val;
        }
        findGood(root.left, parent);
        findGood(root.right, parent);
    }
}