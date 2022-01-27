class AllOne { 
    
    TreeMap<Integer,HashMap<String,Integer>> tree;
    HashMap<String,Integer> map;
    
    public AllOne() {
        this.tree=new TreeMap<>();
        this.map=new HashMap<>();
    }
    
    public void inc(String key) {
        if(map.containsKey(key)){
           int oldCount= map.get(key);
            
            int newCount=oldCount+1;
            
            map.put(key,newCount);
            
            tree.get(oldCount).remove(key);
            if(tree.get(oldCount).size()==0)tree.remove(oldCount);
            
            if(tree.containsKey(newCount)){
                tree.get(newCount).put(key,newCount);
            }else{
                HashMap<String,Integer> m=new HashMap<>();
                m.put(key,newCount);
                tree.put(newCount,m);
            }
        }else{
                map.put(key,1);
             if(tree.containsKey(1)){
                tree.get(1).put(key,1);
            }else{
                HashMap<String,Integer> m=new HashMap<>();
                m.put(key,1);
                tree.put(1,m);
            }
        }
    }
    
    public void dec(String key) {
         int oldCount= map.get(key);
            
            int newCount=oldCount-1;
            if(newCount>0){
                map.put(key,newCount);    
            }else{
                map.remove(key);
            }
            
            tree.get(oldCount).remove(key);
            if(tree.get(oldCount).size()==0)tree.remove(oldCount);
            
            if(newCount>0){
                if(tree.containsKey(newCount)){
                tree.get(newCount).put(key,newCount);
            }else{
                HashMap<String,Integer> m=new HashMap<>();
                m.put(key,newCount);
                tree.put(newCount,m);
            }            
        }

    }
    
    public String getMaxKey() {
        if(tree.size()==0)return "";
       HashMap<String,Integer> m= tree.lastEntry().getValue();    
        
        return (String)(m.entrySet().iterator().next().getKey());
    }
    
    public String getMinKey() {
         if(tree.size()==0)return "";
       HashMap<String,Integer> m= tree.firstEntry().getValue();    
       return (String)(m.entrySet().iterator().next().getKey());

    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */