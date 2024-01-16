class RandomizedSet {
    
    HashMap<Integer,Integer> map;
    List<Integer> arr=new ArrayList<>();
    Random rand;

    public RandomizedSet() {
        this.arr=new ArrayList<>();
        this.map=new HashMap<>();
        this.rand = new Random();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        
        arr.add(val);
        map.put(val,arr.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        int index = map.get(val);
        
        int lastVal=arr.get(arr.size()-1);
        arr.set(arr.size()-1,arr.get(index));
        arr.set(index,lastVal);
        map.put(lastVal,index);
        arr.remove(arr.size()-1);
        map.remove(val);
        
        return true;
    }
    
    public int getRandom() {
        int n = rand.nextInt(arr.size());
        return arr.get(n);

    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */