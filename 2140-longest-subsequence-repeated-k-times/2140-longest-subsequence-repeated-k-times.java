class Solution {
    public String longestSubsequenceRepeatedK(String s, int k) {
        int[] freq = new int[26];
        for(char ch:s.toCharArray()) {
            freq[ch-'a']++;
        }
        Queue<String> q = new LinkedList<>();
        String ans = new String();
        q.offer(ans);

        while(!q.isEmpty()) {
            String curr = q.poll();
            for(char i='a';i<='z';i++) {
                if(freq[i-'a']>=k && getCount(s, curr+i)>=k) {
                    ans = curr+i;
                    q.offer(ans);
                }
            }
        }
        return ans;
    }
    private int getCount(String s, String t) {
        int i=0;
        int j=0;
        int cnt = 0;
        while(i<s.length()) {
            if(s.charAt(i)==t.charAt(j)) {
                j++;
            }
            if(j==t.length()) {
                cnt++;
                j=0;
            }
            i++;
        }
        return cnt;
    }
}