class Solution {
    private Set<String> set;
    public String findDifferentBinaryString(String[] nums) {
        set = new HashSet<>();
        helper("", nums[0].length());
        for(String s:nums) {
            set.remove(s);
        }
        for(String s:set) {
            return s;
        }
        return new String();
    }
    private void helper(String bin, int n) {
        if(n==0) {
            // System.out.println(bin);
            set.add(bin);
            return ;
        }
        helper(bin+"0", n-1);
        helper(bin+"1", n-1);
    }
}