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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> lt1 = new ArrayList<>();
        List<Integer> lt2 = new ArrayList<>();

        leaves(root1, lt1);
        leaves(root2, lt2);

        if(lt1.size() != lt2.size()){
            return false;
        }

        return lt1.equals(lt2);

    }

    public void leaves(TreeNode root, List<Integer> lt){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            lt.add(root.val);
            return;
        }
        leaves(root.left, lt);
        leaves(root.right, lt);
    }
}