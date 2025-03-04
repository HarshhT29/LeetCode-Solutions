class Solution {
    public boolean checkPowersOfThree(int n) {
        while(n>2 && n%3!=2) {
            n/=3;
        }
        return n%3!=2;
    }
}