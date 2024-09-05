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
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Long> lt = new ArrayList<>();

        while (!queue.isEmpty()) {
            long levelSum = 0;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levelSum += (long)node.val;
                if (node.left != null){
                    queue.add(node.left);
                } 
                if (node.right != null){
                    queue.add(node.right);
                } 
            }

            lt.add(levelSum);
        }
        Collections.sort(lt, Collections.reverseOrder());
        if(lt.size() < k){
            return -1;
        }
        return lt.get(k - 1); 
    }
}