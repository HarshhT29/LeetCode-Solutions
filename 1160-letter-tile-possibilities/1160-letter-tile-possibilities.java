class Solution {
    private boolean[] visited;
    private Set<String> set;
    public int numTilePossibilities(String tiles) {
        visited = new boolean[tiles.length()];
        set = new HashSet<>();
        helper(tiles, "");
        return set.size()-1;
    }
    private void helper(String tiles, String curr) {
        set.add(curr);
        for(int i=0;i<tiles.length();i++) {
            if(!visited[i]) {
                visited[i] = true;
                helper(tiles, curr + tiles.charAt(i));
                visited[i] = false;
            }
        }
    }
}