class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int cnt=0;
        for(int i=low;i<=high;i++) {
            if(helper(i)) {
                cnt++;
            }
        }
        return cnt;
    }
    private boolean helper(int num) {
        String s = String.valueOf(num);
        int n = s.length();
        if(n%2!=0) {
            return false;
        }
        String p1 = s.substring(0, (n/2));
        String p2 = s.substring((n/2), n);
        return sum(p1)==sum(p2);
    }
    private int sum(String s) {
        int n = Integer.parseInt(s);
        int sum = 0;
        while(n>0) {
            sum+=(n%10);
            n/=10;
        }
        return sum;
    }
}