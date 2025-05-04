class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int n = distance.length;
        int i=start;
        int j=destination;
        int clock = 0, counterClock = 0;
        while(i!=destination) {
            clock+=distance[i];
            i=(i+1)%n;
        }
        while(j!=start) {
            counterClock+=distance[j];
            j=(j+1)%n;
        }
        return Math.min(clock, counterClock);
    }
}