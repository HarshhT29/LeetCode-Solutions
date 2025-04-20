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

/*
NOTE::-->
Each answers[i] means the rabbit sees answers[i] others of the same color, so total in its group = answers[i] + 1.
Count how many times each answers[i] appears.
For each unique answers[i], divide the count into groups of (answers[i] + 1).
Total rabbits = groups * (answers[i] + 1)
*/