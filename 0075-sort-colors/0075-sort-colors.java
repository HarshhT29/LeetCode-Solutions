class Solution {
    public void sortColors(int[] nums) {
        int red=0,white=0,blue=0;
        for(int x:nums) {
            red=x==0?red+1:red;
            white=x==1?white+1:white;
            blue=x==2?blue+1:blue;
        }
        int i=0;
        while(red-->0)
            nums[i++] = 0;
        while(white-->0)
            nums[i++] = 1;
        while(blue-->0)
            nums[i++] = 2;
    }
}