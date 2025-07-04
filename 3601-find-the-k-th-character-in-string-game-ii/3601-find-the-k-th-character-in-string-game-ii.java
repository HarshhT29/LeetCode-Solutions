//Help from GPT
class Solution {
    public char kthCharacter(long k, int[] operations) {
        int n = operations.length;
        long[] lengths = new long[n + 1];
        lengths[0] = 1;
        for(int i=0;i<n;i++) {
            lengths[i+1] = lengths[i]*2;
            if(lengths[i+1]>=k) {
                n = i+1;
                break;
            }
        }
        k--;
        int shiftCount = 0;
        for (int i=n-1;i>=0;i--) {
            long half = lengths[i];
            if(k>=half) {
                k-=half;
                if(operations[i] == 1) {
                    shiftCount++;
                }
            }
        }
        return (char)('a'+(shiftCount % 26));
    }
}
