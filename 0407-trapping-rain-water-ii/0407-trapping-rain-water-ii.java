class Solution {
    class Node {
        int r,c,h;
        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
        Node(int r, int c, int h) {
            this(r, c);
            this.h = h;
        }
    }

    private int[][] dir = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    public int trapRainWater(int[][] heightMap) {
        int n = heightMap.length;
        int m = heightMap[0].length;

        boolean[][] visited = new boolean[n][m];
        Queue<Node> minHeap = new PriorityQueue<>((a, b) -> a.h - b.h);

        for(int i=0;i<n;i++) {
            minHeap.offer(new Node(i, 0, heightMap[i][0]));
            minHeap.offer(new Node(i, m-1, heightMap[i][m-1]));
            visited[i][0] = visited[i][m-1] = true;
        }
        for(int i=0;i<m;i++) {
            minHeap.offer(new Node(0, i, heightMap[0][i]));
            minHeap.offer(new Node(n-1, i, heightMap[n-1][i]));
            visited[0][i] = visited[n-1][i] = true;
        }
        
        int volume = 0;

        while(!minHeap.isEmpty()) {
            Node curr = minHeap.poll();

            for(int i=0;i<4;i++) {
                int newR = curr.r + dir[i][0];
                int newC = curr.c + dir[i][1];

                if(newR>=n || newC>=m || newR<0 || newC<0 || visited[newR][newC]) {
                    continue;
                }
                if(curr.h > heightMap[newR][newC]) {
                    volume+=(curr.h - heightMap[newR][newC]);
                }
                Node newNode = new Node(newR, newC);
                newNode.h = Math.max(curr.h, heightMap[newR][newC]);
                minHeap.offer(newNode);
                visited[newR][newC] = true;
            }
        }
        return volume;
    }
}