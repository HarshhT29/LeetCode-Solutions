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
    public TreeNode recoverFromPreorder(String traversal) {
        Stack<TreeNode> st = new Stack<>();
        int n = traversal.length();
        int i = 0;

        while(i<n) {
            int depth = 0;
            while(i<n && traversal.charAt(i)=='-') {
                depth++;
                i++;
            }

            int val = 0;
            while(i<n && traversal.charAt(i)>='0' && traversal.charAt(i)<='9') {
                val = val*10 + (traversal.charAt(i)-'0');
                i++;
            }

            TreeNode node = new TreeNode(val);

            while(st.size()>depth) {
                st.pop();
            }

            if(!st.isEmpty()) {
                TreeNode top = st.peek();
                if(top.left==null) {
                    top.left = node;
                } else {
                    top.right = node;
                }
            }
            st.push(node);
        }
        while(st.size()>1) {
            st.pop();
        }
        return st.peek();
    }
}