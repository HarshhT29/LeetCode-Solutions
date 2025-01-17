class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int cnt=0,i=0;
        int n=s.length,m=g.length;
        while(i<n && cnt<m) {
            if(s[i]>=g[cnt])
                cnt++;
            i++;
        }
        return cnt;
    }
}