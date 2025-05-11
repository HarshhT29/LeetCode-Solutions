class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int odd = 0;
        for(int x:arr) {
            if((x&1)==1)
                odd++;
            else
                odd = 0;
            if(odd==3) return true;
        }
        return false;
    }
}