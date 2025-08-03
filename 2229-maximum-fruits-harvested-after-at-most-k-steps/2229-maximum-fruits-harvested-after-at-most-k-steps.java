class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length;
        List<int[]> left = new ArrayList<>();
        int i = 0;
        while(i < n && fruits[i][0] <= startPos) {
            int dist = startPos - fruits[i][0];
            int cnt  = fruits[i][1];
            left.add(new int[]{dist, cnt});
            i++;
        }

        Collections.reverse(left);
        List<int[]> right = new ArrayList<>();

        while(i < n) {
            int dist = fruits[i][0] - startPos;
            int cnt  = fruits[i][1];
            right.add(new int[]{dist, cnt});
            i++;
        }

        int[] psumL = new int[left.size() + 1];
        int[] psumR = new int[right.size() + 1];
        for(int j = 0; j < left.size(); j++) {
            psumL[j + 1] = psumL[j] + left.get(j)[1];
        }
        for(int j = 0; j < right.size(); j++) {
            psumR[j + 1] = psumR[j] + right.get(j)[1];
        }

        int maxCollected = 0;
        for(int steps = 0; steps <= k; steps++) {
            int leftCount  = ub(left, steps);
            int rightCount = ub(right, k - 2 * steps);

            maxCollected = Math.max(maxCollected, psumL[leftCount] + psumR[rightCount]);

            rightCount = ub(right, steps);
            leftCount  = ub(left, k - 2 * steps);
            maxCollected = Math.max(maxCollected, psumL[leftCount] + psumR[rightCount]);
        }
        return maxCollected;
    }

    private int ub(List<int[]> arr, int steps) {
        int low = 0, high = arr.size();
        while(low < high) {
            int mid = (low + high) / 2;
            if(arr.get(mid)[0] <= steps) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
