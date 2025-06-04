class Solution {
    public int maxArea(int[] height) {
        int i = 0, j = height.length-1;
        int max = 0;
        while(i<height.length && j>=0) {
            int h = Math.min(height[i], height[j]);
            max = Math.max(max, h*(j-i));
            if(height[i]>height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return max;
    }
}