class Solution {
    public int minimumDeletions(String word, int k) {
        int[] freq = new int[26];
        for(char w:word.toCharArray()) {
            freq[w-'a']++;
        }
        int minDelete = word.length();
        for(int a:freq) {
            if(a==0) {
                continue;
            }
            int cnt = 0;
            for(int b:freq) {
                if(b==0) {
                    continue;
                }
                if(a>b) {
                    cnt += b;
                } else {
                    cnt += Math.max(b-a-k, 0);
                }
            }
            minDelete = Math.min(minDelete, cnt);
        }
        return minDelete;
    }
}