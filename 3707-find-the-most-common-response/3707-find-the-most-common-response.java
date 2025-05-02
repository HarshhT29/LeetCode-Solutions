class Solution {
    public String findCommonResponse(List<List<String>> responses) {
        List<Set<String>> lSet = new ArrayList<>();
        for(List<String> response:responses) {
            Set<String> set = new HashSet<>();
            for(String res:response) {
                set.add(res);
            }
            lSet.add(set);
        }
        Map<String, Integer> map = new HashMap<>();
        for(Set<String> set:lSet) {
            for(String s:set) {
                map.put(s, map.getOrDefault(s, 0)+1);
            }
        }
        int max = -1;
        String ans = new String();
        for(String s:map.keySet()) {
            if(map.get(s)>max) {
                max = map.get(s);
                ans = s;
            } else if(max==map.get(s)) {
                if(s.compareTo(ans)<0) {
                    ans = s;
                }
            }
        }
        return ans;
    }
}