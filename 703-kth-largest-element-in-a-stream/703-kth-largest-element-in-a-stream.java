class KthLargest {
    
    PriorityQueue<Integer> pq;
    
    int[] arr;
    
    int k;
    
    
    public KthLargest(int k, int[] nums) {
        this.pq=new PriorityQueue<>();
        int n=nums.length;
        this.k=k;
        
        for(int ele : nums){
            if(pq.size()<k)pq.add(ele);
            else{
                pq.add(ele);
                pq.poll();
            }
        }
        
        
    }
    
    public int add(int val) {
         if(pq.size()<k)pq.add(val);
            else{
                pq.add(val);
                pq.poll();
            }
        
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */