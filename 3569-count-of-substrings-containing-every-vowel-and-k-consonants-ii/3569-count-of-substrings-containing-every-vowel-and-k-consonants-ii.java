class Solution {
    public long countOfSubstrings(String word, int k) {
        return helper(word, k) - helper(word, k+1);
    }
    private boolean isVowel(char ch) {
        return ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u';
    }
    private long helper(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int i=0,j=0;
        long cnt = 0, con = 0;

        while(j<n) {
            if(!isVowel(s.charAt(j))) {
                con++;
            } else {
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0)+1);
            }
            while(map.size()==5 && con>=k) {
                cnt += n-j;
                if(!isVowel(s.charAt(i))) {
                    con--;
                } else {
                    map.put(s.charAt(i), map.get(s.charAt(i))-1);
                    if(map.get(s.charAt(i))==0) {
                        map.remove(s.charAt(i));
                    }
                }
                i++;
            }
            j++;
        }
        return cnt;
    }

}