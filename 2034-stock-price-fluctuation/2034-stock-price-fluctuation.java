class StockPrice {
    
    HashMap<Integer,Integer> map;
    TreeMap<Integer,HashMap<Integer,Integer>> tree;
    
    public StockPrice() {
        this.map=new HashMap<>();
        this.tree=new TreeMap<>();
    }
    
    
    int curr=0;
    int latest=0;
    
    public void update(int timestamp, int price) {
        if(map.containsKey(timestamp)){
            
            int oldPrice=map.get(timestamp);
            
             tree.get(oldPrice).remove(timestamp);
            if(tree.get(oldPrice).size()==0)tree.remove(oldPrice);
                  
            
          
            if(tree.containsKey(price)){
                tree.get(price).put(timestamp,price);
            }else{
                HashMap<Integer,Integer> m=new HashMap<>();
                m.put(timestamp,price);
                tree.put(price,m);
            }
            
        }else{
             if(tree.containsKey(price)){
                tree.get(price).put(timestamp,price);
            }else{
                HashMap<Integer,Integer> m=new HashMap<>();
                m.put(timestamp,price);
                tree.put(price,m);
            }
                    
        }
            map.put(timestamp,price);
        
            if(timestamp>=latest){
                latest=timestamp;
                curr=price;
            }
        
    }
    
    public int current() {
        return curr;
    }
    
    public int maximum() {
        return tree.lastEntry().getKey();
    }
    
    public int minimum() {
        return tree.firstEntry().getKey();
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */