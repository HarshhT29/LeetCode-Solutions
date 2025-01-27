class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        int[] indegree = new int[numCourses];
        for(int[] pair:prerequisites) {
            indegree[pair[1]]++;
        }

        List<Set<Integer>> track = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<indegree.length;i++) {
            track.add(new HashSet<>());
            if(indegree[i]==0) {
                q.add(i);
            }
        }

        while(!q.isEmpty()) {
            int curr = q.remove();

            for(int[] pair:prerequisites) {
                if(curr==pair[0]) {
                    track.get(pair[1]).add(curr);
                    track.get(pair[1]).addAll(track.get(curr));
                    if(--indegree[pair[1]]==0) {
                        q.add(pair[1]);
                    }
                }
            }
        }

        List<Boolean> res = new ArrayList<>();
        for(int[] query:queries) {
            res.add(track.get(query[1]).contains(query[0]));
        }
        return res;
    }
}