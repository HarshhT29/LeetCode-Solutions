class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.equals(s2)) {
            return true;
        }
        int cnt = 0;
        int a = -1, b = -1;

        for(int i=0;i<s1.length();i++) {
            if(s1.charAt(i)!=s2.charAt(i)) {
                cnt++;
                if(cnt==1) {
                    a = i;
                } else if(cnt==2) {
                    b = i;
                } else {
                    return false;
                }
            }
        }
        return cnt==2 && s1.charAt(a)==s2.charAt(b) && s1.charAt(b)==s2.charAt(a);
    }
}