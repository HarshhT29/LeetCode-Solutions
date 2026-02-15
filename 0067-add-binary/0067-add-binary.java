class Solution {
    public String addBinary(String a, String b) {
        int aLen = a.length()-1;
        int bLen = b.length()-1;
        int carry = 0;
        StringBuilder res = new StringBuilder();
        while(aLen>=0 || bLen>=0 || carry!=0) {
            int sum = carry;
            if(aLen>=0) {
                sum += a.charAt(aLen--)-'0';
            }
            if(bLen>=0) {
                sum += b.charAt(bLen--)-'0';
            }
            res.append(sum % 2);
            carry = sum/2;
        }
        return res.reverse().toString();
    }
}