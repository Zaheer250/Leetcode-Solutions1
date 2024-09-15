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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        if(root.val < key){
            root.right = deleteNode(root.right,key);
        }
        else if(root.val > key){
            root.left = deleteNode(root.left,key);
        }
        else{
            //Case-1(No children present)
            if(root.left == null && root.right == null){
                return null;
            }
            //Case-2(Single child present)
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            //Case-3(Both children present)(IMPORTANT CASE)
            else{
                TreeNode inorderS = findinorderS(root.right);
                root.val = inorderS.val;
                root.right = deleteNode(root.right, inorderS.val);
            }
        }
        return root;
    }

    public static TreeNode findinorderS(TreeNode root){
        while(root.left != null){
            root=root.left;
        }
        return root;
    }
}