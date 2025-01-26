class Solution {
    //Elements swappable grp banate hai, yahin swapping sirf
    //same grp ke elements mei hi possible hai.
    //Saare grp elements ko aise arrange karo ki vo 
    //actual array mei relatively sorted rahe

    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        List<Deque<Integer>> groups = new ArrayList<>();
        Map<Integer, Integer> mapNumToGrp = new HashMap<>(); //map all nums[i] with there respective group
        
        //Sort karne ke baad sare grp elements sath mei aajayenge
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

        //Dequeue se phela element utha te jao
        int[] res = new int[nums.length];
        for(int i=0;i<nums.length;i++) {
            int grpIndex = mapNumToGrp.get(nums[i]);
            res[i] = groups.get(grpIndex).removeFirst();
        }

        return res;
    }
}