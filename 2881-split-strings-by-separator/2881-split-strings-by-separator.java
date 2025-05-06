class Solution {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> list = new ArrayList<>();
        for(String word:words) {
            String[] str = word.split("["+separator+"]");
            for(String s:str) {
                if(!s.isEmpty()) {
                    list.add(s);
                }
            }
        }
        return list;
    }
}