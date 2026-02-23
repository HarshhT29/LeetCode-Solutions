class Solution {
    public boolean hasAllCodes(String s, int k) {
        HashSet<Integer> set = new HashSet<>();
        // Iterate through string to find all substrings of length k and Use hashCode() to store unique representations
        for (int i = 0; i + k <= s.length(); i++) set.add(s.substring(i, i + k).hashCode());
        // Check if unique substrings found equals 2^k
        return set.size() == Math.pow(2, k);
    }
}