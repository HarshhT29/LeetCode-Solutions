class Solution {
    private final int MOD = 1000000007;
    public int[] productQueries(int n, int[][] queries) {
        List<Integer> setBitVal = new ArrayList<>();
        int val = 1;
        while(n>0) {
            if((n&1)!=0) {
                setBitVal.add(val);
            }
            val<<=1;
            n>>=1;
        }
        int[] res = new int[queries.length];
        int idx = 0;
        for(int[] query:queries) {
            long prod = 1L;
            for(int i=query[0];i<=query[1];i++) {
                prod = (prod*(setBitVal.get(i))) % MOD;
            }
            res[idx++] = (int) prod;
        }
        return res;
    }
}