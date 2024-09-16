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
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        findPaths(root, "", result);
        return result;
    }

    public static void findPaths(TreeNode node, String path, ArrayList<String> result) {
        if (node == null) {
            return;
        }
        if (path.isEmpty()) {
            path = Integer.toString(node.val);
        } else {
            path = path + "->" + node.val;
        }
        if (node.left == null && node.right == null) {
            result.add(path);
        }
        findPaths(node.left, path, result);
        findPaths(node.right, path, result);
    }
}