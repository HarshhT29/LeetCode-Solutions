class Solution {
    public int[] decode(int[] encoded) {
        int[] perm = new int[encoded.length+1];
        int xor = 0;
        for(int i=1;i<=perm.length;i++) {
            xor^=i;
        }
        for(int i=0;i<encoded.length;i++) {
            if((i&1)!=0) {
                xor^=encoded[i];
            }
        }
        perm[0] = xor;
        for(int i=1;i<perm.length;i++) {
            perm[i] = perm[i-1]^encoded[i-1];
        }

        return perm;
    }
}
/*
NOTE:
encoded[i] = perm[i]^pern[i+1];
n=5 perm = {a, b, c, d, e}
encoded[0] = a^b
encoded[1] = b^c
encoded[2] = c^d
encoded[3] = d^e
implies xor of odd index will have xor of first natural number except first element 
perm[0] found
then, perm[i] = perm[i-1]^encoded[i-1];
*/