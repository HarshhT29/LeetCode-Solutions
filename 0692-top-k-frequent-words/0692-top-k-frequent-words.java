class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(String word:words) {
            map.put(word, map.getOrDefault(word, 0)+1);
        }
        Queue<Pair<String, Integer>> pq = new PriorityQueue<>(
            (a, b) -> {
                if(a.getValue().equals(b.getValue())) {
                    return b.getKey().compareTo(a.getKey());
                } else {
                    return Integer.compare(a.getValue(), b.getValue());
                }
            }
        );
        
        for(String key:map.keySet()) {
            pq.offer(new Pair(key, map.get(key)));
            if(pq.size() > k) {
                pq.poll();
            } 
        }
        List<String> list = new ArrayList<>();
        while(!pq.isEmpty()) {
            list.add(pq.poll().getKey());
        }
        Collections.reverse(list);
        return list;
    }
}