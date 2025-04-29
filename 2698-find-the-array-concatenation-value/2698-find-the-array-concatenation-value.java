class Solution {
    public long findTheArrayConcVal(int[] nums) {
        String s = new String();
        int i=0, j=nums.length-1;
        long ans = 0L;
        while(i<j) {
            s+=Integer.toString(nums[i]);
            s+=Integer.toString(nums[j]);
            ans += Long.parseLong(s);
            s = "";
            i++;
            j--;
        }
        ans+=((nums.length)%2!=0)?nums[i]:0;
        return ans;
    }
}