class ProductOfNumbers {
    private List<Integer> prefix;
    public ProductOfNumbers() {
        this.prefix = new ArrayList<>();
    }
    
    public void add(int num) {
        if(num==0) {
            prefix.clear();
        } else if(prefix.isEmpty()) {
            this.prefix.add(num);
        } else {
            this.prefix.add(num*this.prefix.get(prefix.size()-1));
        }
    }
    
    public int getProduct(int k) {
        if(k>prefix.size()) {
            return 0;
        }
        if(k==prefix.size()) {
            return this.prefix.get(prefix.size()-1);
        }
        return prefix.get(prefix.size()-1)/prefix.get(prefix.size()-1-k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */