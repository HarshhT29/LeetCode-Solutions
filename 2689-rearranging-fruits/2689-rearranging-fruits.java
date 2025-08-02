class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int fruit : basket1) freq.put(fruit, freq.getOrDefault(fruit, 0) + 1);
        for (int fruit : basket2) freq.put(fruit, freq.getOrDefault(fruit, 0) + 1);

        long min = Long.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() % 2 != 0) return -1;
            min = Math.min(min, entry.getKey());
        }

        List<Long> fruits_to_swap = new ArrayList<>();
        Map<Integer, Integer> count1 = new HashMap<>();
        for (int fruit : basket1) count1.put(fruit, count1.getOrDefault(fruit, 0) + 1);

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int fruit = entry.getKey();
            int diff = count1.getOrDefault(fruit, 0) - (entry.getValue() / 2);
            for (int i = 0; i < Math.abs(diff); i++) {
                fruits_to_swap.add((long)fruit);
            }
        }
        
        Collections.sort(fruits_to_swap);

        long totalCost = 0;
        int swapsToMake = fruits_to_swap.size() / 2;
        for (int i = 0; i < swapsToMake; i++) {
            totalCost += Math.min(fruits_to_swap.get(i), 2 * min);
        }
        
        return totalCost;
    }
}