class Solution {
    public int countPalindromicSubsequence(String s) {
        int[] firstOccur = new int[26];
        int[] lastOccur = new int[26];
        Arrays.fill(firstOccur, -1);
        
        int n = s.length();
        for(int i=0;i<n;i++) {
            if(firstOccur[s.charAt(i)-'a']==-1) {
                firstOccur[s.charAt(i)-'a']=i;
            }
            lastOccur[s.charAt(i)-'a'] = i;
        }
        int res = 0;
        for(int i=0;i<26;i++) {
            Set<Character> set = new HashSet<>();
            for(int j=firstOccur[i]+1;j<lastOccur[i];j++) {
                set.add(s.charAt(j));
            }
            res+=set.size();
        }

        return res;
    }
}