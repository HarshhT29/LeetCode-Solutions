class Solution {
    public int minimumLength(String s) {
        int[] freq = new int[26];
        for(char ch:s.toCharArray()) {
            freq[ch-'a']++;
        }
        int cnt = 0;
        for(int i=0;i<26;i++) {
            if(freq[i]<3) {
                cnt+=freq[i];
            } else {
                cnt=((freq[i]&1)==0)?cnt+2:cnt+1;
            }
        }
        return cnt;
    }
}