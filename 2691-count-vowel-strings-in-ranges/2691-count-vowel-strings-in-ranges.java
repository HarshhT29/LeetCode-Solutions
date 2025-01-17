class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] mark = new int[words.length];
        for(int i=0;i<mark.length;i++) {
            if(isVowel(words[i].charAt(0)) && isVowel(words[i].charAt(words[i].length()-1))) {
                mark[i] = 1;
            }
            if(i>0) {
                mark[i] += mark[i-1];
            }
        }
    
        int[] res = new int[queries.length];
        for(int i=0;i<res.length;i++) {
            int r = queries[i][1];
            int l = queries[i][0];
            res[i] = l==0?mark[r]:(mark[r] - mark[l-1]);
        }
        
        return res;
    }
    private boolean isVowel(char ch) {
        if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u') {
            return true;
        }
        return false;
    }
}