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
    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode, TreeNode> parent = getParents(root);
        TreeNode startNode = search(root, start);

        int time = 0;
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(startNode);
        visited.add(startNode);

        while(!q.isEmpty()) {
            int size = q.size();
            boolean burned = false;

            for(int i=0;i<size;i++) {
                TreeNode curr = q.poll();
                if(curr.left!=null && !visited.contains(curr.left)) {
                    burned = true;
                    visited.add(curr.left);
                    q.offer(curr.left);
                }
                if(parent.containsKey(curr) && !visited.contains(parent.get(curr))) {
                    burned = true;
                    visited.add(parent.get(curr));
                    q.offer(parent.get(curr));
                }
                if(curr.right!=null && !visited.contains(curr.right)) {
                    burned = true;
                    visited.add(curr.right);
                    q.offer(curr.right);
                }
            }
            if(burned) {
                time++;
            }
        }
        return time;
    }
    private Map<TreeNode, TreeNode> getParents(TreeNode root) {
        if(root==null) {
            return new HashMap<>();
        }
        Map<TreeNode, TreeNode> ctp = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            TreeNode curr = q.poll();
            if(curr.left!=null) {
                ctp.put(curr.left, curr);
                q.offer(curr.left);
            }
            if(curr.right!=null) {
                ctp.put(curr.right, curr);
                q.offer(curr.right);
            }
        }
        return ctp;
    }
    private TreeNode search(TreeNode root, int targetValue) {
        if(root==null) {
            return null;
        }
        if(root.val==targetValue) {
            return root;
        }
        TreeNode left = search(root.left, targetValue);
        if(left!=null){
            return left;
        } else {
            return search(root.right, targetValue);
        }
    }
}