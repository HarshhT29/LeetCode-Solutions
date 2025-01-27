class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjList = new List[numCourses];
        for (int[] pair : prerequisites) {
            if (adjList[pair[1]] == null) {
                adjList[pair[1]] = new ArrayList<>();
            }
            adjList[pair[1]].add(pair[0]);
        }
        int[] visited = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                if (detectCycle(adjList, visited, i)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean detectCycle(List<Integer>[] adjList, int[] visited, int src) {
        if(visited[src]!=0) {
            return visited[src]==1;
        }
        visited[src]=1;
        if(adjList[src]!=null) {
            for(int node:adjList[src]) {
            if(detectCycle(adjList, visited, node)) {
                return true;
            }
        }
        }
        visited[src]=2;
        return false;
    }
}


/*
BFS SOLUTION TOPO SORT KAHN'S ALGO
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
*/