class Solution {
    public int maxDifference(String s) {
        int[] freq = new int[26];
        int maxOdd = 0;
        int minEven = 101;
        for(int ch:s.toCharArray()) {
            freq[ch-'a']++;
        }
        for(int i=0;i<26;i++) {
            if(freq[i]>0 && (freq[i]&1)==0) {
                minEven = Math.min(minEven, freq[i]);
            }
            if((freq[i]&1)!=0) {
                maxOdd = Math.max(maxOdd, freq[i]);
            }
        }
        return maxOdd - minEven;
    }
}