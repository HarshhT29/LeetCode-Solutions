class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        HashMap<Integer,Integer> balls = new HashMap<>();
        Map<Integer,Set<Integer>> map = new HashMap<>();
        int[] ans = new int[queries.length];
        for(int i=0;i<queries.length;i++) {
            int x = queries[i][0];
            int y = queries[i][1];
            int prevColor = balls.containsKey(x)==false?0:balls.get(x);
            if(prevColor!=0) {
                map.get(prevColor).remove(x);
                if((map.get(prevColor).size())==0){
                    map.remove(prevColor);
                }
            }
            if(!map.containsKey(y)) {
                map.put(y,new HashSet<>());
            }
            map.get(y).add(x);
            balls.put(x,y);
            ans[i] = map.size();
        }
        return ans;
    }
}