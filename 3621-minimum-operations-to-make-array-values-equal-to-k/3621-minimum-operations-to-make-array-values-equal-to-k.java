class Solution {
    public int minOperations(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int num:nums) {
            if(num>k) {
                set.add(num);
            } else if(num==k) {
                continue;
            } else {
                return -1;
            }
        }
        return set.size();
    }
}