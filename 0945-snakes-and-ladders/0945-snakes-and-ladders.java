class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] cells = new int[n*n+1];

        boolean leftToRight = true;
        int idx = 1;
        for (int row = n - 1; row >= 0; row--) {
            if (leftToRight) {
                for (int col = 0; col < n; col++) {
                    cells[idx++] = board[row][col];
                }
            } else {
                for (int col = n - 1; col >= 0; col--) {
                    cells[idx++] = board[row][col];
                }
            }
            leftToRight = !leftToRight;
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n * n + 1];
        queue.add(1);
        visited[1] = true;
        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int curr = queue.poll();
                if (curr == n * n) return moves;

                for (int i = 1; i <= 6 && curr + i <= n * n; i++) {
                    int next = curr + i;
                    if (cells[next] != -1) {
                        next = cells[next];
                    }
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.add(next);
                    }
                }
            }
            moves++;
        }
        return -1;
    }
}