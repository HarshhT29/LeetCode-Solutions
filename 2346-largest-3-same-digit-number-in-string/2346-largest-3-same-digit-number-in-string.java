class Solution {
    public String largestGoodInteger(String num) {
        String[] set = {
            "000", "111", "222", 
            "333", "444", "555", 
            "666", "777", "888",
            "999"
        };
        String curr = new String();
        for(String s:set) {
            if(num.contains(s)) {
                if(curr.equals("") || Integer.parseInt(curr)<Integer.parseInt(s)) {
                    curr = s;
                }
            }
        }
        return curr;
    }
}