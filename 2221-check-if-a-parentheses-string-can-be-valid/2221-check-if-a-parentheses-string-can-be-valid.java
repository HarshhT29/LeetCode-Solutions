class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if((n&1)!=0) {
            return false;
        }
        int open=0, unlocked=0;
        for(int i=0;i<n;i++) {
            if(locked.charAt(i)=='0') {
                unlocked++;
            } else if(s.charAt(i)=='(') {
                open++;
            } else if(s.charAt(i)==')') {
                if(open>0) {
                    open--;
                } else if(unlocked>0) {
                    unlocked--;
                } else {
                    return false;
                }
            }
        }

        int bal=0;
        for(int i=n-1;i>=0;i--) {
            if(locked.charAt(i)=='0') {
                bal--;
                unlocked--;
            } else if(s.charAt(i)=='(') {
                open--;
                bal++;
            } else if(s.charAt(i)==')') {
                bal--;
            }
            if(bal>0) {
                return false;
            }
            if(open==0 && unlocked==0) {
                return true;
            }
        }
        return !(open>0);
    }
}