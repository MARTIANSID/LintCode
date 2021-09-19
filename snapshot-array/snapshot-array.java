class SnapshotArray {

    TreeMap<Integer,Integer>[]  versions;
    int snapId=0;
    public SnapshotArray(int length) {
       versions=new TreeMap[length];
        for(int i=0;i<length;i++){
            versions[i]=new TreeMap<>();
            versions[i].put(0,0);
        }
        
        
    }
    
    public void set(int index, int val) {
        
        versions[index].put(snapId,val);
        
    }
    
    public int snap() {
        return snapId++;
    }
    
    public int get(int index, int snap_id) {
        
        return versions[index].floorEntry(snap_id).getValue();
        
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */