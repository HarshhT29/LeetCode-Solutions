public class Solution {

    public int numSteps(String s) {
        int n = s.length();
        int operations=0,carry=0;
        
        for (int i=n-1;i>0;i--) {
            int digit = (s.charAt(i)-'0')+carry;
            if ((digit&1)!=0) {
                operations+=2;
                carry=1;
            } else {
                operations++;
            }
        }
        return operations+carry;
    }
}