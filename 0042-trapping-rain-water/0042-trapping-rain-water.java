class Solution {
    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        leftMax[0] = height[0];
        for(int i=1;i<leftMax.length;i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }
        rightMax[rightMax.length-1] = height[height.length-1];
        for(int i=rightMax.length-2;i>=0;i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }
        int water = 0;
        for(int i=0;i<height.length;i++) {
            water += (Math.min(rightMax[i], leftMax[i])-height[i]);
        }
        return water;
    }

    // public int trap(int[] height) {
    //     int i = 0;
    //     int j = height.length-1;
    //     int leftMax = 0, rightMax = 0;
    //     int water = 0;
    //     while(i<j) {
    //         if(height[j] > height[i]) {
    //             leftMax = Math.max(leftMax, height[i]);
    //             water += leftMax - height[i];
    //             i++;
    //         } else {
    //             rightMax = Math.max(rightMax, height[j]);
    //             water += rightMax - height[j];
    //             j--;
    //         }
    //     }
    //     return water;
    // }
}