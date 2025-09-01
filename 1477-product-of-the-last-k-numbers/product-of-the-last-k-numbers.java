class ProductOfNumbers {
    List<Integer> prefix ;
    public ProductOfNumbers() {
        prefix = new ArrayList<>();
    }
    
    public void add(int num) {
        if(num==0) {
            prefix.clear();
        }
        else if(prefix.isEmpty()) {
            prefix.add(num);
        } else{
            prefix.add(num * prefix.get(prefix.size()-1));
        }
    }
    
    public int getProduct(int k) {
        int size = prefix.size();
        if (k > size) {
            return 0;  // because a zero was added within the last k numbers
        }
        if (k == size) {
            return prefix.get(size - 1);
        }
        return prefix.get(size - 1) / prefix.get(size - k - 1);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */