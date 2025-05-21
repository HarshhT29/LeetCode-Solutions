class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(k>pq.size()) {
                    pq.offer(matrix[i][j]);
                } else if(pq.peek()>matrix[i][j]) {
                    pq.poll();
                    pq.offer(matrix[i][j]);
                }
            }
        }
        return pq.peek();
    }
}