class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] freq = new int[A.length+1];
        int[] res = new int[A.length];

        for(int i=0;i<A.length;i++) {
            freq[A[i]]++;
            freq[B[i]]++;

            if(i!=0) {
                res[i]+=res[i-1];
            }
            if(A[i]!=B[i] && freq[A[i]]==2) {
                res[i]+=1;
            }
            if(freq[B[i]]==2) {
                res[i]+=1;
            }
        }
        
        return res;
    }
}