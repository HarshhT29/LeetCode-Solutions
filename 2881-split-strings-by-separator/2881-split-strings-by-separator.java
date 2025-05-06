class Solution {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> list = new ArrayList<>();
        for(String word:words) {
            String[] s = word.split("["+separator+"]");
            for(int i=0;i<s.length;i++) {
                if(s[i].length()>0) {
                    list.add(s[i]);
                }
            }
        }
        return list;
    }
}