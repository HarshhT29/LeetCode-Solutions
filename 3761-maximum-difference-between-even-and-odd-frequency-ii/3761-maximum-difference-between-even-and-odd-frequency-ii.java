class Solution {
    public int maxDifference(String s, int k) {
        char[] ch = s.toCharArray();
        int maxDiff = Integer.MIN_VALUE;

        for(int a=0;a<5;a++) {
            for(int b=0;b<5;b++) {
                if(a!=b) {
                    maxDiff = Math.max(maxDiff, helper(ch, k, a, b));
                }
            }
        }
        return maxDiff == Integer.MIN_VALUE ? -1 : maxDiff;
    }

    private int[] getPrefix(char[] ch, int digit) {
        int[] prefix = new int[ch.length+1];
        for(int i = 0; i < ch.length; i++) {
            prefix[i + 1] = prefix[i] + (ch[i] - '0' == digit?1:0);
        }
        return prefix;
    }
    private int helper(char[] ch, int k, int a, int b) {
        int[] preA = getPrefix(ch, a);
        int[] preB = getPrefix(ch, b);

        int[] minVal = new int[4];
        int[] minIdx = new int[4];

        Arrays.fill(minVal, Integer.MAX_VALUE);
        Arrays.fill(minIdx, -1);

        minVal[0] = 0;
        minIdx[0] = 0;

        int maxDiff = Integer.MIN_VALUE;

        for(int end=k;end<=ch.length;end++) {
            int parityA = preA[end] % 2;
            int parityB = preB[end] % 2;
            int parity = ((parityA ^ 1) << 1) + parityB;

            if(minVal[parity] != Integer.MAX_VALUE) {
                if(preB[end] - preB[minIdx[parity]] > 0) {
                    maxDiff = Math.max(maxDiff, (preA[end] - preB[end]) - minVal[parity]);
                }
            }

            int start = end - k + 1;
            parityA = preA[start] % 2;
            parityB = preB[start] % 2;
            parity = (parityA << 1) + parityB;
            int startDiff = preA[start] - preB[start];

            if(startDiff < minVal[parity]) {
                minVal[parity] = startDiff;
                minIdx[parity] = start;
            }
        }

        return maxDiff;
    }
}
