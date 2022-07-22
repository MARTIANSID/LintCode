class SmallestInfiniteSet {
    int cnt = 1;
    TreeSet<Integer> set;

    public SmallestInfiniteSet() {
        this.set = new TreeSet<>();
    }

    public int popSmallest() {
        
        Integer smallest=set.size()==0?null:set.first();
        int sm=0;
        if(smallest != null && smallest <= cnt){
            sm=smallest;
            set.remove(smallest);
        }else{
            sm=cnt;
            cnt++;
        }
        return sm;
    }

    public void addBack(int num) {
         if(num<cnt) set.add(num);
    }
}
/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
