class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<String, Integer> map = new HashMap<>();
        int cnt = 0;
        for(int[] dom:dominoes) {
            String key = Math.max(dom[0], dom[1])+","+Math.min(dom[1], dom[0]);
            cnt+=map.getOrDefault(key, 0);
            map.put(key, map.getOrDefault(key, 0)+1);
        }
        return cnt;
    }
}