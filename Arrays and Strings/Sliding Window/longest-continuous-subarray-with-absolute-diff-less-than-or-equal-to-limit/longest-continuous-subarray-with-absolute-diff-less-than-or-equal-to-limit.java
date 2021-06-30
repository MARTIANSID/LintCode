class Solution {
        class pair{
                int index;
                int val;
                pair(int index,int val){
                        this.index=index;
                        this.val=val;
                }
        }
    public int longestSubarray(int[] nums, int limit) {
        
            PriorityQueue<pair> pqmax=new PriorityQueue<>((a,b)->{
                    return b.val-a.val;
            });
            
                PriorityQueue<pair> pqmin=new PriorityQueue<>((a,b)->{
                        return a.val-b.val;
                });
            
         int ei=0,si=0,n=nums.length,max=0;
            
           while(ei<n){
                   pqmax.add(new pair(ei,nums[ei]));
                   pqmin.add(new pair(ei,nums[ei]));
                   ei++;
                   
                  while(pqmax.peek().val-pqmin.peek().val>limit){
                          si++;
                        while(pqmax.peek().index<si){
                                pqmax.poll();
                        }
                          
                            while(pqmin.peek().index<si){
                                pqmin.poll();
                        }
                          
                  }
                   
                    while(pqmax.peek().index<si){
                                pqmax.poll();
                        }
                          
                            while(pqmin.peek().index<si){
                                pqmin.poll();
                        }
                   
                   
                   
                   
                   max=Math.max(max,ei-si);
                   
                   
           }
            
            return max;
            
    }
}