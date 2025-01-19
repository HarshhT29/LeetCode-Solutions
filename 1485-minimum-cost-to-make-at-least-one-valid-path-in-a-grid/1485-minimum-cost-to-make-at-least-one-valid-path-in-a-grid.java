class Solution {
    class Node {
        int row;
        int col;
        int cost;

        Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
        Node(int row, int col, int cost) {
            this(row, col);
            this.cost = cost;
        }
    }
    private int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int minCost(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<Node> minHeap = new PriorityQueue<>((a, b) -> a.cost-b.cost);
        minHeap.offer(new Node(0, 0, 0));
        boolean[][] visited = new boolean[n][m];

        while(!minHeap.isEmpty()) {
            Node curr = minHeap.poll();
            if(visited[curr.row][curr.col]) {
                continue;
            }
            visited[curr.row][curr.col] = true;

            if(curr.row==n-1 && curr.col==m-1) {
                return curr.cost;
            }

            for(int i=0;i<4;i++) {
                int newRow = curr.row + dir[i][0];
                int newCol = curr.col + dir[i][1];

                if(newRow>=n || newRow<0 || newCol>=m || newCol<0 || visited[newRow][newCol]) {
                    continue;
                }
                int newCost = curr.cost + (i+1==grid[curr.row][curr.col]?0:1);
                Node newNode = new Node(newRow, newCol, newCost);
                minHeap.offer(newNode);
            }
        }
        return -1;
    }
}