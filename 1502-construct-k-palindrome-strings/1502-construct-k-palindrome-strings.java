class Solution {
    public boolean canConstruct(String s, int k) {
        if(k>s.length()) {
            return false;
        }
        int[] freq = new int[26];
        for(char ch:s.toCharArray()) {
            freq[ch-'a']++;
        }
        int cnt=0;
        for(int i=0;i<26;i++) {
            if((freq[i]&1)!=0) {
                cnt++;
            }
        }
        return k>=cnt;
    }
}