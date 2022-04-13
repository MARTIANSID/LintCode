class MyHashSet {

    LinkedList<Integer>[] buckets;
    int size=700;
    
    public MyHashSet() {
        this.buckets=new LinkedList[this.size];
        
        for(int i=0;i<size;i++){
            buckets[i]=new LinkedList<>();
        }
    }
    
    private int getBucket(int key){
        return key % size;
    }
    
    public void add(int key) {
        int bucket=getBucket(key);
        
        if(!contains(key))
        buckets[bucket].add(key);
    }
    
    public void remove(int key) {
        int bucket=getBucket(key);
        
       LinkedList<Integer> list= buckets[bucket];
    
        int index=0;
        for(int k:list){
            if(k == key){
                buckets[bucket].remove(index);
                break;
            }
            index++;
        }
    }
    
    public boolean contains(int key) {
         int bucket=getBucket(key);
        
       LinkedList<Integer> list= buckets[bucket];
    
        for(int k:list){
            if(k == key){
                return true;
            }
        }
        
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */