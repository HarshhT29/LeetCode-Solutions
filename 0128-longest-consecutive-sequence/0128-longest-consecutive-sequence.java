class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num:nums) {
            set.add(num);
        }
        int max = 0;
        for(int num:set) {
            if(!set.contains(num-1)) {
                int next = num;
                while(set.contains(next)) {
                    next++;
                }
                max = Math.max(max, next-num);
            }
        }
        return max;
    }
}