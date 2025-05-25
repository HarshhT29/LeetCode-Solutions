class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        int res = 0;
        int bothSame = 0;
        for(String word:words) {
            String reverseWord = word.charAt(1)+""+word.charAt(0);
            if(map.containsKey(reverseWord)) {
                res+=4;
                map.put(reverseWord, map.get(reverseWord)-1);
                if(map.get(reverseWord)==0) {
                    map.remove(reverseWord);
                }
                if(word.charAt(0)==word.charAt(1)) {
                    bothSame--;
                }
            } else {
                map.put(word, map.getOrDefault(word, 0)+1);
                if(word.charAt(0)==word.charAt(1)) {
                    bothSame++;
                }
            }
        }        
        return bothSame>0?res+2:res;
    }
}