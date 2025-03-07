class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean[] seive = new boolean[right+1];
        Arrays.fill(seive, true);
        seive[0] = seive[1] = false;
        for(int i=2;i*i<=right;i++) {
            if(seive[i]) {
                for(int j=i*i;j<=right;j+=i) {
                    seive[j] = false;
                }
            }
        }
        
        int[] nums = {-1, -1};
        int prevPrime = -1;
        for(int i=left;i<=right;i++) {
            if(seive[i]) {
                if(prevPrime!=-1) {
                    if(nums[0]==-1 || (nums[1]-nums[0])>(i-prevPrime)) {
                        nums[0] = prevPrime;
                        nums[1] = i;
                    }
                }
                prevPrime = i;
            }
        }

        return nums;
    }
}