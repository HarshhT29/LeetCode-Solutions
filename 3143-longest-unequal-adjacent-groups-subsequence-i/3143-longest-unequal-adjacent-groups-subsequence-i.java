class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> list = new ArrayList<>();
        list.add(words[0]);
        int mark = groups[0];

        for(int i=1;i<groups.length;i++) {
            if(groups[i]!=mark) {
                list.add(words[i]);
                mark = groups[i];
            }
        }
        return list;
    }
}