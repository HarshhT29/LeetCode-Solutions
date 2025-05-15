class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return helper(s,new HashSet<>(wordDict),0,new Boolean[s.length()]);
    }
    private boolean helper(String s,Set<String> wordDict,int i,Boolean[] dp) {
        if(i==s.length())
            return true;
        if(dp[i]!=null)
            return dp[i];
        for(int j=i;j<s.length();j++) {
            if(wordDict.contains(s.substring(i,j+1)))
                if(helper(s,wordDict,j+1,dp))
                    return dp[i]=true;
        }
        return dp[i]=false;
    }
}