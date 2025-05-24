class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<words.length;i++) {
            for(char ch:words[i].toCharArray()) {
                if(ch==x) {
                    list.add(i);
                    break;
                }
            }
        }
        return list;
    }
}