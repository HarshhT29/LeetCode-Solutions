class Solution {
    public int minimumPairRemoval(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        for(int num:nums) {
            arr.add(num);
        }
        int count = 0;
        while (arr.size() > 1) {
            boolean isSorted = true;
            int minSum = Integer.MAX_VALUE;
            int targetIndex = -1;           
            for (int i = 0; i < arr.size() - 1; i++) {
                int sum = arr.get(i) + arr.get(i + 1);

                if (arr.get(i) > arr.get(i + 1)) {
                    isSorted = false; 
                }
                if (sum < minSum) {
                    minSum = sum;
                    targetIndex = i;
                }
            }
            if (isSorted) {
                break;
            }

            count++;
            arr.set(targetIndex, minSum);
            arr.remove(targetIndex + 1);
        }

        return count;
    }
}