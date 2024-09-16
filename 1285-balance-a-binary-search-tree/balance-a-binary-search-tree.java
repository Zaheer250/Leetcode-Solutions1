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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> lt=new ArrayList<>();
        inorder(root,lt);
        return createBST(lt,0,lt.size()-1);
    }

    public TreeNode createBST(List<Integer> lt, int start, int end){
        if(start > end){
            return null;
        }

        int mid = (start+end) / 2;
        TreeNode node = new TreeNode(lt.get(mid));
        node.left=createBST(lt,start,mid-1);
        node.right=createBST(lt,mid+1,end);

        return node;
    }

    public void inorder(TreeNode root, List<Integer> lt){
        if(root == null){
            return;
        }
        inorder(root.left, lt);
        lt.add(root.val);
        inorder(root.right, lt);
    }
}