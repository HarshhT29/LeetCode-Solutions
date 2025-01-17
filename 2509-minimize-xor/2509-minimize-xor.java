class Solution {
    public int minimizeXor(int num1, int num2) {
        int setBitsNum2 = getSetBits(num2);
        int totalBitsNum1 = noOfBits(num1);
        int n = Math.max(totalBitsNum1, setBitsNum2);
        int ans = 0;
        for(int i=n-1;i>=0 && setBitsNum2>0;i--) {
            int value = num1&(1<<i);
            if(value>0) {
                ans+=(1<<i);
                setBitsNum2--;
            }
        }
        for(int i=0;i<n && setBitsNum2>0;i++) {
            int value = num1&(1<<i);
            if(!(value>0)) {
                ans+=(1<<i);
                setBitsNum2--;
            }
        }
        return ans;
    }
    private int getSetBits(int n) {
        if(n==0 || n==1) {
            return n;
        }
        int cnt=0;
        while(n>0) {
            if((n&1)==1) {
                cnt++;
            }
            n>>=1;
        }
        return cnt;
    }
    private int noOfBits(int n) {
        int cnt=0;
        while(n>0) {
            cnt++;
            n>>=1;
        }
        return cnt;
    }
}