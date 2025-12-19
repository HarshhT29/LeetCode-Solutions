class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {

        // Build graph: person -> (neighbor, meeting time)
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] m : meetings) {
            int u = m[0], v = m[1], t = m[2];
            graph[u].add(new int[]{v, t});
            graph[v].add(new int[]{u, t});
        }

        // earliest[i] = earliest time person i knows the secret
        int[] earliest = new int[n];
        Arrays.fill(earliest, Integer.MAX_VALUE);

        // Min-heap ordered by time
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );

        // Initial secret holders
        earliest[0] = 0;
        earliest[firstPerson] = 0;
        pq.offer(new int[]{0, 0});
        pq.offer(new int[]{0, firstPerson});

        // Dijkstra-style BFS
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int time = curr[0];
            int person = curr[1];

            // Skip outdated entries
            if (time > earliest[person]) continue;

            for (int[] nei : graph[person]) {
                int nextPerson = nei[0];
                int meetTime = nei[1];

                // Can share only if meeting happens after knowing the secret
                if (meetTime >= time && meetTime < earliest[nextPerson]) {
                    earliest[nextPerson] = meetTime;
                    pq.offer(new int[]{meetTime, nextPerson});
                }
            }
        }

        // Collect all people who know the secret
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (earliest[i] != Integer.MAX_VALUE) {
                ans.add(i);
            }
        }
        return ans;
    }
}
