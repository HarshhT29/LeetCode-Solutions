class Solution {
    private final int MOD = 1000000007;
    public int countGoodNumbers(long n) {
        if(n==1) {
            return 5;
        }
        long prime = n/2;
        long even = n%2==0?prime:prime+1;

        long totalPrime = pow(4, prime);
        long totalEven = pow(5, even);

        long total = (totalPrime*totalEven)%MOD;

        return (int)total;
    }
    private long pow(long base, long exp) {
        long res = 1L;
        while(exp>0) {
            if((exp&1)==1){
                res = (res*base)%MOD;
            }
            base = (base*base)%MOD;
            exp>>=1;
        }
        return res;
    }
}

/*
NOTE:
Issko Math.pow se calculate kar sakte hai but large exponents mei 
Math.pow mei precision loss hota hai 
 */