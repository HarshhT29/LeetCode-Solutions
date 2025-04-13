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
        List<String> paths = new ArrayList<>();
        getPaths(root, paths, new String());
        return paths;
    }
    private void getPaths(TreeNode root, List<String> paths, String path) {
        if(root.left==null && root.right==null) {
            path+=root.val;
            paths.add(path);
            return ;
        }
        if(root.left!=null) {
            getPaths(root.left, paths, path+root.val+"->");
        }
        if(root.right!=null) {
            getPaths(root.right, paths, path+root.val+"->");
        }
    }
}