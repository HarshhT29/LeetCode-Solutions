//Crazzy solution by GPT

class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        IntHashSet result = new IntHashSet(1 << 20); // global distinct ORs

        // prev[] holds distinct OR results for subarrays ending at previous index
        int[] prev = new int[32];
        int prevSize = 0;

        for (int x : arr) {
            // build curr from prev extended with x, plus x itself
            int[] curr = new int[32];
            int currSize = 0;

            // extend previous ORs
            for (int i = 0; i < prevSize; i++) {
                int orVal = prev[i] | x;
                // dedupe in curr array
                if (!containsInArray(curr, currSize, orVal)) {
                    curr[currSize++] = orVal;
                }
            }
            // include subarray consisting of x alone
            if (!containsInArray(curr, currSize, x)) {
                curr[currSize++] = x;
            }

            // add all of curr to global result
            for (int i = 0; i < currSize; i++) {
                result.add(curr[i]);
            }

            // roll curr -> prev
            System.arraycopy(curr, 0, prev, 0, currSize);
            prevSize = currSize;
        }

        return result.size();
    }

    // helper: linear scan small array for containment
    private boolean containsInArray(int[] arr, int size, int val) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == val) return true;
        }
        return false;
    }

    // Simple int hash set with open addressing, sentinel -1 (valid ORs are >= 0)
    static class IntHashSet {
        private int[] table;
        private int used; // number of stored elements
        private int threshold;

        public IntHashSet(int capacity) {
            // round up to power of two
            int sz = 1;
            while (sz < capacity) sz <<= 1;
            table = new int[sz];
            for (int i = 0; i < sz; i++) table[i] = -1; // empty marker
            used = 0;
            threshold = (int)(sz * 0.7);
        }

        private void resize() {
            int[] old = table;
            int newSize = old.length << 1;
            table = new int[newSize];
            for (int i = 0; i < newSize; i++) table[i] = -1;
            used = 0;
            threshold = (int)(newSize * 0.7);
            // reinsert
            for (int v : old) {
                if (v != -1) add(v);
            }
        }

        public boolean contains(int x) {
            int mask = table.length - 1;
            int idx = mix(x) & mask;
            while (true) {
                int t = table[idx];
                if (t == -1) return false;
                if (t == x) return true;
                idx = (idx + 1) & mask;
            }
        }

        public void add(int x) {
            if (used >= threshold) resize();
            int mask = table.length - 1;
            int idx = mix(x) & mask;
            while (true) {
                int t = table[idx];
                if (t == -1) {
                    table[idx] = x;
                    used++;
                    return;
                }
                if (t == x) return; // already present
                idx = (idx + 1) & mask;
            }
        }

        public int size() {
            return used;
        }

        // mixing function (can be simple since inputs are non-negative and varied)
        private int mix(int x) {
            x ^= (x >>> 16);
            x *= 0x7feb352d;
            x ^= (x >>> 15);
            x *= 0x846ca68b;
            x ^= (x >>> 16);
            return x;
        }
    }
}
