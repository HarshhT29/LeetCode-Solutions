class Solution {
    class Node implements Comparable<Node> {
        private int rating;
        private int index;

        private Node(int rating, int index) {
            this.rating = rating;
            this.index = index;
        }

        @Override
        public int compareTo(Node obj) {
            return Integer.compare(this.rating, obj.rating);
        }
    }
    
    public int candy(int[] ratings) {
        Node[] cdn = new Node[ratings.length];
        for(int i=0;i<ratings.length;i++) {
            cdn[i] = new Node(ratings[i], i);
        }
        Arrays.sort(cdn);
        int[] res = new int[cdn.length];
        Arrays.fill(res, 1);
        for(Node node:cdn) {
            int idx = node.index;
            if(idx>0 && ratings[idx]>ratings[idx-1]) {
                res[idx] = Math.max(res[idx], res[idx-1]+1);
            }
            if(idx<ratings.length-1 && ratings[idx]>ratings[idx+1]) {
                res[idx] = Math.max(res[idx], res[idx+1]+1);
            }
        }
        int sum = 0;
        for(int r:res) {
            sum+=r;
        }
        return sum;
    }
}