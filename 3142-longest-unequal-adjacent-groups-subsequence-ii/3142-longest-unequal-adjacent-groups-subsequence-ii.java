class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int[][] distance = new int[words.length][words.length];
        for(int[] d:distance) {
            Arrays.fill(d, -1);
        }
        precomputeHD(words, distance);

        int[] dp = new int[words.length];
        int[] parent = new int[words.length];
        Arrays.fill(parent, -1);
        Arrays.fill(dp, 1);

        int maxLength = 1;
        int lastIndex = 0;

        for(int i=1;i<words.length;i++) {
            for(int j=0;j<i;j++) {
                if(groups[i]!=groups[j] && words[i].length()==words[j].length() && distance[i][j] == 1) {
                    if(dp[i]-dp[j] < 1) {
                        dp[i] = dp[j] + 1;
                        parent[i] = j;
                    }
                }
            }
            if(dp[i] > maxLength) {
                maxLength = dp[i];
                lastIndex = i;
            }
        }

        List<Integer> indices = new ArrayList<>();
        int current = lastIndex;
        while(current != -1) {
            indices.add(current);
            current = parent[current];
        }
        Collections.reverse(indices);

        List<String> result = new ArrayList<>();
        for(int idx:indices) {
            result.add(words[idx]);
        }
        return result;
    }
    private void precomputeHD(String[] words, int[][] distance) {
        for(int i=0;i<words.length;i++) {
            for(int j=i+1;j<words.length;j++) {
                if(words[i].length()==words[j].length()) {
                    distance[i][j] = getHammingDistance(words[i], words[j]);
                    distance[j][i] = distance[i][j];
                }
            }
        }
    }

    private int getHammingDistance(String a, String b) {
        int dis = 0;
        for(int i=0;i<a.length();i++) {
            if(a.charAt(i)!=b.charAt(i)) {
                dis++;
            }
        }
        return dis;
    }
}