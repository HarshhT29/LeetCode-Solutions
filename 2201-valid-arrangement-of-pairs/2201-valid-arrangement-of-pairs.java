class Solution {
    private Map<Integer, List<Integer>> adjList;
    private Map<Integer, Integer> in;
    private Map<Integer, Integer> out;
    private Stack<Integer> path;

    public Solution() {
        adjList = new HashMap<>();
        in = new HashMap<>();
        out = new HashMap<>();
        path = new Stack<>();
    }

    public int[][] validArrangement(int[][] pairs) {
        for(int[] pair:pairs) {
            adjList.computeIfAbsent(pair[0], p -> new ArrayList<>()).add(pair[1]);
            out.put(pair[0], out.getOrDefault(pair[0], 0)+1);
            in.put(pair[1], in.getOrDefault(pair[1], 0)+1);
        }
        int start = -1;
        for(int outKey:out.keySet()) {
            if(out.get(outKey)-in.getOrDefault(outKey, 0)==1) {
                start = outKey;
                break;
            }
        }
        if(start==-1) {
            start = pairs[0][0];
        }
        getPath(start);

        int[][] validPath = new int[pairs.length][pairs[0].length];
        int i = 0;
        while(i<validPath.length && !path.isEmpty()) {
            validPath[i][0] = path.pop();
            validPath[i][1] = path.peek();
            i++;
        }
        return validPath;
    }
    private void getPath(int src) {
        while(out.getOrDefault(src,0)>0) {
            out.put(src, out.get(src)-1);
            int next = adjList.get(src).get(out.get(src));
            getPath(next);
        }
        path.push(src);
    }
}