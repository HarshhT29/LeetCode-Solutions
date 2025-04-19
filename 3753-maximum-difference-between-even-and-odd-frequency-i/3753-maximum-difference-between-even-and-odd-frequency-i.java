class Solution {
    public int maxDifference(String s) {
        int[] freq = new int[26];
        for(char ch:s.toCharArray()) {
            freq[ch-'a']++;
        }
        int max = 0, min = Integer.MAX_VALUE;
        for(int i=0;i<26;i++) {
            if(freq[i]!=0 && freq[i]%2==0) {
                min = Math.min(min, freq[i]);
            } else {
                max = Math.max(max, freq[i]);
            }
        }
        return max-min;
    }
}