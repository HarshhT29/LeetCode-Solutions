class Solution {
    public int numberOfSubstrings(String s) {
        int[] freq = new int[3];
        int n = s.length();
        int i = 0, j = 0;
        int cnt = 0;
        while(j<n) {
            freq[s.charAt(j)-'a']++;
            while(freq[0]>0 && freq[1]>0 && freq[2]>0) {
                cnt += n-j;
                freq[s.charAt(i++)-'a']--;
            }
            j++;
        }
        return cnt;
    }
}