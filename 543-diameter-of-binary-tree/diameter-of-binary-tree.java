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
    static class Info{
        int diam;
        int ht;
        public Info(int diam, int ht){
            this.diam=diam;
            this.ht=ht;
        }
    }

    public static int height(TreeNode root){
        if(root == null){
            return 0;
        }
        int lh=height(root.left);
        int rh=height(root.right);
        return (int)Math.max(lh,rh)+1;
    }

    public static Info diameter(TreeNode root){
        if(root == null){
            return new Info(0,0);
        }
        Info lt=diameter(root.left);
        Info rt=diameter(root.right);
        int diam=Math.max(Math.max(lt.diam,rt.diam),(lt.ht+rt.ht+1));
        int ht=Math.max(lt.ht,rt.ht)+1;

        return new Info(diam,ht);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        Info ans=diameter(root);
        return ans.diam-1;
    }
}