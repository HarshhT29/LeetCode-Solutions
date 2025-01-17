class Solution {
    public int maxScore(String s) {
        int one = 0 , zero = 0;
        int res = 0;

        for(char ch:s.toCharArray()) {
            if(ch=='1') {
                one++;
            }
        }
        for(int i=0;i<s.length()-1;i++) {
            char ch = s.charAt(i);
            if(ch=='1') {
                one--;
            } else {
                zero++;
            }
            res = Math.max(res, one+zero);
        }
        return res;
    }
}