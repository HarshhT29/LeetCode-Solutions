class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        Stack<Integer> st = new Stack<>();
        for(int num:nums) {
            while(!st.isEmpty()) {
                int num_gcd = gcd(st.peek(), num);
                if(num_gcd==1) {
                    break;
                }
                num = (st.pop()/num_gcd)*num;
            }
            st.add(num);
        }
        List<Integer> res = new ArrayList<>();
        for(int s:st) {
            res.add(s);
        }
        return res;
    }
    private int gcd(int x, int y) {
        if(y==0) {
            return x;
        }
        return gcd(y, x%y);
    }
}