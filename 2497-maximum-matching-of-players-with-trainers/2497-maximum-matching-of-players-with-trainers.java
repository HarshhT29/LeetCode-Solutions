class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int cnt = 0;
        int i=0;
        while(i<players.length && cnt<trainers.length) {
            if(players[i]<=trainers[cnt]) {
                i++;
            }
            cnt++;
        }
        return i;
    }
}