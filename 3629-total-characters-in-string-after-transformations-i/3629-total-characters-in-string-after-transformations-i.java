class Solution {
    private final int MOD = 1000000007;
    public int lengthAfterTransformations(String s, int t) {
        long[] freq = new long[26];
        for(char ch:s.toCharArray()) {
            freq[ch-'a']++;
        }

        while(t-->0) {
            long[] nextFreq = new long[26];
            for(int i=0;i<26;i++) {
                if(i==25) {
                    nextFreq[0] = (nextFreq[0]+freq[25])%MOD;
                    nextFreq[1] = (nextFreq[1]+freq[25])%MOD;
                } else {
                    nextFreq[i+1] = (nextFreq[i+1]+freq[i])%MOD;
                }
            }
            freq = nextFreq;
        }

        long res = 0L;
        for(long count:freq) {
            res = (res+count)%MOD;
        }
        return (int)res;
    }
}
