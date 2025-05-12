class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] freq = getFreq(digits);
        List<Integer> list = new ArrayList<>();
        for(int i=100;i<1000;i++) {
            if((i&1)==0) {
                int[] digitCount = getDigitFreq(i);
                boolean flag = false;
                for(int j=0;j<10;j++) {
                    if(freq[j]<digitCount[j]) {
                        flag = true;
                        break;
                    }
                }
                if(!flag) {
                    list.add(i);
                }
            }
        }
        int i=0;
        int[] ans = new int[list.size()];
        for(int x:list) {
            ans[i++] = x;
        }
        return ans;
    }
    private int[] getFreq(int[] nums) {
        int[] freq = new int[10];
        for(int num:nums) {
            freq[num]++;
        }
        return freq;
    }
    private int[] getDigitFreq(int n) {
        int[] freq = new int[10];
        while(n>0) {
            int rem = n%10;
            freq[rem]++;
            n/=10;
        }
        return freq;
    }
}