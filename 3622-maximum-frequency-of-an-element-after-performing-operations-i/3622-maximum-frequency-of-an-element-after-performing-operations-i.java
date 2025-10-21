class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Arrays.sort(nums);
        Map<Integer, Integer> freq = new HashMap<>();
        int maxFreq = 0;
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            maxFreq = Math.max(maxFreq, freq.get(num));
        }
        Set<Integer> targets = new HashSet<>();
        for(int num : nums) {
            targets.add(num);
            targets.add(num - k);
            targets.add(num + k);
        }
        for(int target:targets) {
            int left = lowerBound(nums, target - k);
            int right = upperBound(nums, target + k);
            int reachable = right - left;
            int originalFreq = freq.getOrDefault(target, 0);
            int canChange = reachable - originalFreq;
            int totalFreq = originalFreq + Math.min(canChange, numOperations);
            maxFreq = Math.max(maxFreq, totalFreq);
        }
        return maxFreq;
    }
    private int lowerBound(int[] nums, int key) {
        int low = 0, high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < key) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
    private int upperBound(int[] nums, int key) {
        int low = 0, high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] <= key) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}