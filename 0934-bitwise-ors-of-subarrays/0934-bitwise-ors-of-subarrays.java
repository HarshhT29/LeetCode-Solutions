class Solution {
    Set<Integer> result = new HashSet<>();
    Map<Integer, Set<Integer>> memo = new HashMap<>();
    public int subarrayBitwiseORs(int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            dfs(i, arr, 0);
        }
        return result.size();
    }
    private void dfs(int i, int[] arr, int currOr) {
        if(i==arr.length) 
            return;

        currOr |= arr[i];
        Set<Integer> seenAtI = memo.get(i);
        if(seenAtI != null && seenAtI.contains(currOr)) 
            return;
        if(seenAtI == null) {
            seenAtI = new HashSet<>();
            memo.put(i, seenAtI);
        }
        seenAtI.add(currOr);
        result.add(currOr);
        dfs(i+1, arr, currOr);
    }
}
