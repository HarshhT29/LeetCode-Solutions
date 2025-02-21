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
class FindElements {
    private TreeNode root;
    public FindElements(TreeNode root) {
        this.root = root;
        helper(root, 0);
    }
    
    public boolean find(int target) {
        return findUtil(root, target);
    }
    private boolean findUtil(TreeNode root, int target) {
        if(root==null) {
            return false;
        }
        if(root.val==target) {
            return true;
        }
        return findUtil(root.left, target) || findUtil(root.right, target);
    }

    private void helper(TreeNode root, int x) {
        if(root==null) {
            return ;
        }
        root.val = x;
        helper(root.left, 2*(root.val)+1);
        helper(root.right, 2*(root.val)+2);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */