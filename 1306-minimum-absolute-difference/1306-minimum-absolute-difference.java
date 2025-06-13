class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;

        for(int i=0;i<arr.length-1;i++) {
            minDiff = Math.min(minDiff, Math.abs(arr[i+1]-arr[i]));
        }
        for(int i=0;i<arr.length-1;i++) {
            if(arr[i+1]-arr[i] == minDiff) {
                list.add(Arrays.asList(arr[i], arr[i+1]));
            }
        }
        return list;
    }
}