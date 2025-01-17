class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] w2MaxFreq = new int[26];
        for(String word2: words2) {
            int[] tempFreq = getFreq(word2);
            for(int i=0;i<26;i++) {
                w2MaxFreq[i] = Math.max(w2MaxFreq[i], tempFreq[i]);
            }
        }

        List<String> res = new ArrayList<>();
        for(int i=0;i<words1.length;i++) {
            int[] tempFreq = getFreq(words1[i]);
            boolean isNotUniversal = false;
            for(int j=0;j<26;j++) {
                if(tempFreq[j]<w2MaxFreq[j]) {
                    isNotUniversal = true;
                    break;
                }
            }
            if(!isNotUniversal) {
                res.add(words1[i]);
            }
        }
        return res;
    }
    
    private int[] getFreq(String s) {
        int[] freq = new int[26];
        for(char ch:s.toCharArray()) {
            freq[ch-'a']++;
        }
        return freq;
    }
}