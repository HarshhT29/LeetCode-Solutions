class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==1)
            return 1;
        HashSet<Character> set = new HashSet<>();
        int start=0,end=0,ans=0;
        int n = s.length();
        while(end<n) {
            char ch = s.charAt(end);
            if(!set.contains(ch)) {
                set.add(ch);
                end++;
            } else {
                set.remove(s.charAt(start++));
            }
            ans = Math.max(ans,end-start);
        }
        return ans;
    }
}