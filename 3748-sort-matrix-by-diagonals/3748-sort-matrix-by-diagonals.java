class Solution {
    public int[][] sortMatrix(int[][] grid) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid.length;j++) {
                int key = j-i;
                if(!map.containsKey(key)) {
                    map.put(key, new PriorityQueue<>(key<=0?Collections.reverseOrder(): Comparator.naturalOrder()));
                }
                map.get(key).add(grid[i][j]);
            }
        }

        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid.length;j++) {
                grid[i][j] = map.get(j-i).poll();
            }
        }
        return grid;
    }
}