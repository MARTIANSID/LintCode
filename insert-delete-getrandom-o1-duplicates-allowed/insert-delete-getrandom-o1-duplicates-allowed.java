class RandomizedCollection {
    HashMap<Integer,HashSet<Integer>> map;
    
    List<Integer> nums;
    
    int start=0;
    int end=0;
    
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map=new HashMap<>();
        nums=new ArrayList<>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        
       if(end>=nums.size()){
           nums.add(val);
       }else{
           nums.set(end,val);
       }
        if(map.containsKey(val)){
            map.get(val).add(end);
            end++;
           
            return false;
        }else{
            HashSet<Integer> set=new HashSet<>();
            set.add(end);
            map.put(val,set);
            
            end++;
            
            return true;
            
        }
        
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
         // System.out.println(map);
        if(map.containsKey(val)){
        int loc = map.get(val).iterator().next();
           
	    map.get(val).remove(loc);
            
            swap(loc,end-1);
          
        if(loc!=end-1){
            map.get(nums.get(loc)).remove(end-1);
            map.get(nums.get(loc)).add(loc);
        }
            
            end--;
            if(map.get(val).size()==0)map.remove(val);
           
            return true;
        }else{
            return false;
        }
        
    }
    
    public void swap(int i,int j){
        // System.out.println(nums.get(i));
        // System.out.println(nums.get(j));

        
        int temp=nums.get(i);
        nums.set(i,nums.get(j));
        nums.set(j,temp);
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        Random r=new Random();        
      	int randomNumber=r.nextInt(end);
        return nums.get(randomNumber);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */