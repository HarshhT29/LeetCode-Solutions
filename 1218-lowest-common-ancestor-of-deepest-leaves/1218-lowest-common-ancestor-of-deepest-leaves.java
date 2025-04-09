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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();
        dfs(root, map);

        return findLCA(root, map);
    }
    private int dfs(TreeNode root, Map<TreeNode, Integer> map) {
        if(root==null) {
            return 0;
        }
        int left = dfs(root.left, map);
        int right = dfs(root.right, map);
        int depth = Math.max(left, right)+1;

        map.put(root, depth);
        return depth;
    }
    private TreeNode findLCA(TreeNode root, Map<TreeNode, Integer> map) {
        if(root==null) {
            return null;
        }
        int left = root.left!=null?map.get(root.left):0;
        int right = root.right!=null?map.get(root.right):0;
        
        if(left==right) {
            return root;
        } else if(left>right) {
            return findLCA(root.left, map);
        } else {
            return findLCA(root.right, map);
        }
    }
}