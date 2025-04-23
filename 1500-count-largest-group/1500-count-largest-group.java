class Solution {
    public int countLargestGroup(int n) {
        Map<Integer,Integer> map = new HashMap<>();
        int gLen = 0;
        for(int i=1;i<=n;i++) {
            int sum = digitSum(i);
            map.put(sum, map.getOrDefault(sum, 0)+1);
            gLen = Math.max(gLen, map.get(sum));
        }
        int groups = 0;
        for(int key:map.keySet()) {
            if(map.get(key)==gLen) {
                groups++;
            }
        }
        return groups;
    }
    private int digitSum(int n) {
        if(n<10) {
            return n;
        }
        int sum = 0;
        while(n>0) {
            sum+=(n%10);
            n/=10;
        }
        return sum;
    }

}