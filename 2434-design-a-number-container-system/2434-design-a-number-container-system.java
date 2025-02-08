class NumberContainers {
    private Map<Integer, Integer> indexToNum;
    private Map<Integer, PriorityQueue<Integer>> numToIndex;

    public NumberContainers() {
        this.indexToNum = new HashMap<>();
        this.numToIndex = new HashMap<>();
    }
    
    public void change(int index, int number) {
        indexToNum.put(index, number);
        numToIndex.computeIfAbsent(number, i->new PriorityQueue<>()).add(index);
    }
    
    public int find(int number) {
        if(!numToIndex.containsKey(number)) {
            return -1;
        }
        while(!numToIndex.get(number).isEmpty()) {
            int i = numToIndex.get(number).peek();
            if(indexToNum.get(i)==number) {
                return i;
            }
            numToIndex.get(number).poll();
        }
        return -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */