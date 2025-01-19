class Solution {
    class Node {
        int row;
        int col;
        int time;

        Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
        Node(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    private int[] dir = {-1, 0, 1, 0, -1};

    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;

        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b)->a.time-b.time);
        minHeap.add(new Node(0, 0, 0));

        while(!minHeap.isEmpty()) {
            Node curr = minHeap.poll();
            
            if(curr.row==n-1 && curr.col==m-1) {
                return curr.time;
            }
            for(int i=0;i<4;i++) {
                int newRow = curr.row + dir[i];
                int newCol = curr.col + dir[i+1];

                if(newRow>=n || newCol>=m || newRow<0 || newCol<0) {
                    continue;
                }
                if(!visited[newRow][newCol]) {
                    Node newNode = new Node(newRow, newCol);
                    newNode.time = Math.max(curr.time, moveTime[newRow][newCol])+1;
                    minHeap.offer(newNode);
                    visited[newRow][newCol] = true;
                }
            }
        } 
        return -1;
    }
}