class TimeMap {
    HashMap<String,TreeMap<Integer,String>> map;
    public TimeMap() {
        this.map=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(map.containsKey(key)){
            
            map.get(key).put(timestamp,value);
            
        }else{
            TreeMap<Integer,String> tree=new TreeMap<>();
            tree.put(timestamp,value);
            map.put(key,tree);
        }
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key))return "";
       Integer k= map.get(key).floorKey(timestamp);
        if(k==null)return "";
        
        return map.get(key).get(k);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */