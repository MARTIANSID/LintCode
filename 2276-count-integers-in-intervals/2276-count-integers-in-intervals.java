class CountIntervals {
    
    int count;
    TreeMap<Integer,Integer> tree;
    public CountIntervals() {
        this.count=0;
        this.tree=new TreeMap<>();
    }
    
    public void add(int left, int right) {
          int l=left,r=right;
          Integer lower=  tree.floorKey(right);
          while(lower!=null){
             int val= tree.get(lower);
              if(val >= left){
                  l=Math.min(l,lower);
                  r=Math.max(r,val);
                  count-=(val-lower+1);
                  tree.remove(lower);
              }else{
                  break;
              }
              lower=tree.lowerKey(lower);
          }
        
        tree.put(l,r);
    
        count+=(r-l+1);
    }
    
    public int count() {
        return this.count;
    }
}

/**
 * Your CountIntervals object will be instantiated and called as such:
 * CountIntervals obj = new CountIntervals();
 * obj.add(left,right);
 * int param_2 = obj.count();
 */