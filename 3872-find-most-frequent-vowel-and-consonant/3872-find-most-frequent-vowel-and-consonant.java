class Solution {
    public int maxFreqSum(String s) {
        int[] freq = new int[26];
        int v=0,c=0;
        for(char ch:s.toCharArray()) {
            freq[ch-'a']++;
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u') {
                v = Math.max(v, freq[ch-'a']);
            } else {
                c = Math.max(c, freq[ch-'a']);
            }
        }
        return v+c;
    }
}