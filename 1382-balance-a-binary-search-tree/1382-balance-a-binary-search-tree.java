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
    private List<Integer> nodes = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        return balanceBSTutils_(0,nodes.size()-1);
    }
    private TreeNode balanceBSTutils_(int low, int high) {
        if(low>high)
            return null;
        int mid = low + (high - low)/2;

        TreeNode node = new TreeNode(nodes.get(mid));
        node.left = balanceBSTutils_(low, mid-1);
        node.right = balanceBSTutils_(mid+1, high);

        return node;
    }
    private void inorder(TreeNode root) {
        if(root==null)
            return ;
        inorder(root.left);
        nodes.add(root.val);
        inorder(root.right);
    }
}