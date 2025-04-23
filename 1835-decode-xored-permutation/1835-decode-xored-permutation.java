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