class Solution {
    public String defangIPaddr(String address) {
        StringBuilder defanged = new StringBuilder();
        for(char ch:address.toCharArray()) {
            if(ch=='.') {
                defanged.append("[");
                defanged.append(".");
                defanged.append("]");
            } else {
                defanged.append(ch);
            }
        }
        return defanged.toString();
    }
}