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
    int totalcnt=0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return 0;
        }
        evalSum(root, targetSum, 0);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return totalcnt;
    }

    public void evalSum(TreeNode root, int targetSum, long currSum){
        if(root == null){
            return;
        }

        currSum += root.val;
        if(currSum == targetSum){
            totalcnt+=1;
        }
        evalSum(root.left, targetSum, currSum);
        evalSum(root.right, targetSum, currSum);
    }
}