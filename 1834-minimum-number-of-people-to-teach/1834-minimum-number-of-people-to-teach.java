class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        Set<Integer> set = new HashSet<>();
        for(int[] fs:friendships) {
            Map<Integer, Integer> map = new HashMap<>();
            boolean flag = false;
            for(int lan:languages[fs[0]-1]) {
                map.put(lan, 1);
            }
            for(int lan:languages[fs[1]-1]) {
                if(map.containsKey(lan)) {
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                set.add(fs[0]-1);
                set.add(fs[1]-1);
            }
        }
        int maxCnt = 0;
        int[] cnt = new int[n+1];
        for(int fs:set) {
            for(int lan:languages[fs]) {
                cnt[lan]++;
                maxCnt = Math.max(maxCnt, cnt[lan]);
            }
        }
        return set.size()-maxCnt;
    }
}