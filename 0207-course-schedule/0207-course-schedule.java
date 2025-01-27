class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        
        for(int[] pair:prerequisites) {
            indegree[pair[0]]++;
        }
        List<Integer> topoOrder = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<indegree.length;i++) {
            if(indegree[i]==0) {
                q.add(i);
            }
        }

        while(!q.isEmpty()) {
            int curr = q.remove();
            topoOrder.add(curr);

            for(int[] pair:prerequisites) {
                if(curr==pair[1]) {
                    if(--indegree[pair[0]]==0) {
                        q.add(pair[0]);
                    }
                }
            }
        }
        return topoOrder.size()==numCourses;
    }
}