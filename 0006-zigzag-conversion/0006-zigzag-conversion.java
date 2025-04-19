class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1) {
            return s;
        }
        StringBuilder str = new StringBuilder();
        for(int i=0;i<numRows;i++) {
            int increment = (numRows-1)*2;
            for(int j=i;j<s.length();j+=increment) {
                str.append(s.charAt(j));
                if(i>0 && i<numRows-1 && (j+increment-2*i)<s.length()) {
                    str.append(s.charAt((j+increment-2*i)));
                }
            }
        }
        return str.toString();
    }
}