class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<groupSizes.length;i++) {
            map.computeIfAbsent(groupSizes[i], a-> new ArrayList<>());
            map.get(groupSizes[i]).add(i);
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int key:map.keySet()) {
            List<Integer> curr = map.get(key);
            for(int i=0;i<curr.size();i++) {
                List<Integer> temp = new ArrayList<>();
                while(i<curr.size() && (i%key)<key-1) {
                    temp.add(curr.get(i));
                    i++;
                }
                if(i<curr.size()) {
                    temp.add(curr.get(i));
                }
                res.add(temp);
            }
        }
        return res;
    }
}