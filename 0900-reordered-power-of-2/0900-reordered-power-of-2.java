class Solution {
    public boolean reorderedPowerOf2(int n) {
         Set<String> powerSet = new HashSet<>();
        for(int i = 0; i < 31; i++) {
            powerSet.add(sorted(Integer.toString(1 << i)));
        }
        return powerSet.contains(sorted(Integer.toString(n)));
    }
    private String sorted(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}