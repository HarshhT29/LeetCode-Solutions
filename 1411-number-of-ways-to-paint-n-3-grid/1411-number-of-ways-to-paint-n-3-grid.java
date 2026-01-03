class Solution {
    int mod = 1000000007;
    public int numOfWays(int n) {
        if(n==1) return 12;
        long[] an = new long[n+1];
        long[] bn = new long[n+1];
        an[2] =6; bn[2] =6;

        for(int i=3;i<=n;i++){
            an[i] = (2*((an[i-1]+bn[i-1])%mod))%mod;
            bn[i] = ((2*an[i-1])%mod +(3*bn[i-1])%mod)%mod;
        }

        return (int)(((4*an[n])%mod + (5*bn[n])%mod)%mod);
    }
}