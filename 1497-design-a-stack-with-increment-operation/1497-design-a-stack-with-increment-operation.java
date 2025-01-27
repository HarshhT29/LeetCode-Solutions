class CustomStack {
    private int[] array;
    private int top;
    public CustomStack(int maxSize) {
        array = new int[maxSize];
        top = -1;
    }
    
    public void push(int x) {
        if(top < array.length-1) {
            array[++top] = x;
        }
    }
    
    public int pop() {
        if(top>-1) {
            return array[top--];
        }
        return -1;
    }
    
    public void increment(int k, int val) {
        int n = Math.min(k, top+1);
        for(int i=0;i<n;i++) {
            array[i]+=val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */