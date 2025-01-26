class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        List<Deque<Integer>> groups = new ArrayList<>();
        Map<Integer, Integer> mapNumToGrp = new HashMap<>();

        List<Integer> sortedNums = new ArrayList<>(nums.length);
        for(int num:nums) {
            sortedNums.add(num);
        }
        Collections.sort(sortedNums);

        for(int sNum:sortedNums) {
            if(groups.isEmpty() || Math.abs(sNum-groups.get(groups.size()-1).getLast())>limit) {
                groups.add(new ArrayDeque<>());
            }
            groups.get(groups.size()-1).addLast(sNum);
            mapNumToGrp.put(sNum, groups.size()-1);
        }

        int[] res = new int[nums.length];
        for(int i=0;i<nums.length;i++) {
            int grpIndex = mapNumToGrp.get(nums[i]);
            res[i] = groups.get(grpIndex).removeFirst();
        }

        return res;
    }
}