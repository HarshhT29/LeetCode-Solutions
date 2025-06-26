class Solution {
    public int longestSubsequence(String s, int k) {
        int z=0;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)=='0') {
                z++;
            }
        }
        int num=0,base=1,len=0;		
        for(int i=s.length()-1;i>=0;i--){
            if(num+base>k) break;
            if(s.charAt(i)=='1'){
               num+=base;
            } else {
                z--;
            }
            base*=2;
            len++;
        }
        return len+z;
    }
}