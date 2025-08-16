class Solution {
    public int maximum69Number (int num) {
        String numString = Integer.toString(num);
        StringBuilder res = new StringBuilder();
        boolean flag = false;
        for(char ch:numString.toCharArray()) {
            if(!flag && ch=='6') {
                res.append("9");
                flag = true;
            } else {
                res.append(ch);
            }
        }
        return Integer.parseInt(res.toString());
    }
}