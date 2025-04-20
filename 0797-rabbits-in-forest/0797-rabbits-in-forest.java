class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int answer:answers) {
            map.put(answer, map.getOrDefault(answer, 0)+1);
        }
        int rabbits = 0;
        for(int x:map.keySet()) {
            int groups = (map.get(x)+x)/(x+1);
            rabbits+=(groups*(x+1));
        }
        return rabbits;
    }
}