class Solution {
    private List<String> res;
    public List<String> validStrings(int n) {
        res = new ArrayList<>();
        helper(new String(), n);
        return res;
    }
    private void helper(String s, int n) {
        if(s.length()>n) {
            return ;
        }
        if(s.length()==n) {
            res.add(s);
        }
        if(s.length()==0 || s.charAt(s.length()-1)=='1') {
            helper(s+"0", n);
        }
        helper(s+"1", n);
    }
}