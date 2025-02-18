class Solution {
    public int[] diStringMatch(String s) {
        int n = s.length();
        int[] prem = new int[n+1];
        int sm = 0, l = n;
        for(int i=0;i<n;i++) {
            prem[i] = s.charAt(i)=='I'?sm++:l--;
        }
        prem[n]=l;
        return prem;
    }
}