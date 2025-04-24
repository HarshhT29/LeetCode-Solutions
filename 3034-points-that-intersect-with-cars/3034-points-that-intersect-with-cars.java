class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        nums.sort((a, b) -> Integer.compare(a.get(0), b.get(0)));
        int sum = 0;
        int start=nums.get(0).get(0);
        int end=nums.get(0).get(1);
        for(int i=1;i<nums.size();i++) {
            int currStart = nums.get(i).get(0);
            int currEnd = nums.get(i).get(1);
            if(currStart<=end) {
                end = Math.max(end, currEnd);
            } else {
                sum+=(end-start+1);
                start = currStart;
                end = currEnd;
            }
        }
        sum+=(end-start+1);
        return sum;
    }
}