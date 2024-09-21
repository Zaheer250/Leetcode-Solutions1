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
    public int maxLevelSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int reqlevel=0;
        int max=Integer.MIN_VALUE;
        int level=1;
        while(!q.isEmpty()){
            int size = q.size();
            int sum = 0;
            while(size != 0){
                TreeNode curr = q.remove();
                sum += curr.val;
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
                size-=1;
            }
            if(sum > max){
                max = sum;
                reqlevel = level;
            }
            level+=1;
        }

        return reqlevel;
    }
}