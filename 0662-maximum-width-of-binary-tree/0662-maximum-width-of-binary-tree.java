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
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair<TreeNode, Long>> q = new LinkedList<>();
        q.offer(new Pair<TreeNode, Long>(root, 1L));
        
        long maxWidth = 0;
        while(!q.isEmpty()) {
            long max = Long.MIN_VALUE;
            long min = Long.MAX_VALUE;
            int n = q.size();
            for(int j=0;j<n;j++) {
                Pair curr = q.poll();
                TreeNode node = (TreeNode)curr.getKey();
                long i = (long)curr.getValue();
                if(node.left!=null) {
                    q.offer(new Pair<TreeNode, Long>(node.left, 2*i));
                }
                if(node.right!=null) {
                    q.offer(new Pair<TreeNode, Long>(node.right, 2*i+1));
                }
                max = Math.max(max, i);
                min = Math.min(min, i);
            }
            maxWidth = Math.max(maxWidth, max-min+1);
        }
        return (int)maxWidth;
    }
}