class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length + k-1;
        int i=0,j=i+1;
        int cnt = 0;

        while(i<colors.length) {
            j=i+1;
            while(j<n && (colors[j%colors.length] != colors[(j-1)%colors.length])) {
                j++;
            }
            if(j-i>=k) {
                cnt += j-i-k+1;
            }
            i = j;
        }
        return cnt;
    }
}