class Solution {
        
        class pair{
                int val;
                int index;
                pair(int val,int index){
                        this.val=val;
                        this.index=index;
                }
        }
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->{
           return b.val-a.val;     
        });
            
            int ei=0,si=0,n=nums.length;
            List<Integer> list=new ArrayList<>();
            
            while(ei<n){
                    pq.add(new pair(nums[ei],ei));
                    ei++;
                    while(pq.size()<k){
                            pq.add(new pair(nums[ei],ei));
                            ei++;
                    }
                    
                    while(pq.peek().index<si){
                         pq.poll();   
                    }
                    si++;
                    
                    list.add(pq.peek().val);
                    
                    
        
                    
            }
            
            
            int[] ans=new int[list.size()];
            for(int i=0;i<list.size();i++){
                    ans[i]=list.get(i);
            }
            return ans;

    }
        
        //[1,3,-1]
        
}