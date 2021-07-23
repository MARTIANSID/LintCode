class KthLargest {

    PriorityQueue<Integer> pq;
    int k;
    public KthLargest(int k, int[] nums) {
        this.pq=new PriorityQueue<>();
        this.k=k;
        for(int a:nums){
           if(pq.size()<k){
            pq.add(a);
        }else if(pq.size()==k){
            if(pq.peek()<a){
                pq.poll();
                pq.add(a);
            }
        }
        }
            
    }
    
    public int add(int val) {
        if(pq.size()<k){
            pq.add(val);
        }else if(pq.size()==k){
            if(pq.peek()<val){
                pq.poll();
                pq.add(val);
            }
        }
        
        return pq.peek();
        
        
          
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */