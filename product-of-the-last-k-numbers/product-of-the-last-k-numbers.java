class ProductOfNumbers {
 
    
    List<Long> prefix;
    
    int lastZero=-1;
    
    
    public ProductOfNumbers() {
        prefix=new ArrayList<>();
        prefix.add((long)1);
    }
    
    public void add(int num) {
        
        if(num==0){
            prefix.add((long)1);
            lastZero=prefix.size()-1;
        }else{
            prefix.add(prefix.get(prefix.size()-1)*num);
        }
        
        
    }
    
    public int getProduct(int k) {
        if(lastZero==-1||lastZero<=prefix.size()-1-k)
            if(lastZero==prefix.size()-1-k)return (int)(long)(prefix.get(prefix.size()-1));
            else return (int)(prefix.get(prefix.size()-1)/prefix.get(prefix.size()-1-k));
            
        else return 0;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */