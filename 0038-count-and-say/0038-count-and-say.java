class Solution {
    public String countAndSay(int n) {
        if(n==1) {
            return "1";
        }
        String curr = countAndSay(n-1);

        int len = curr.length();
        StringBuilder res = new StringBuilder();

        int cnt = 1;
        char ch = curr.charAt(0);

        for(int i=0;i<len-1;i++) {
            if(curr.charAt(i)==curr.charAt(i+1)) {
                cnt++;
            } else {
                res.append(cnt);
                res.append(ch);
                ch = curr.charAt(i+1);
                cnt = 1;
            }
        }
        res.append(cnt);
        res.append(curr.charAt(len-1));
        return res.toString();
    }
}