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
         Deque<pair> deque
            = new LinkedList<>();
            
          int ei=0,si=0,n=nums.length;
            boolean insert=false;
            List<Integer> ans=new ArrayList<>();
            
            while(ei<n){
                    while(ei<k-1){
                            if(deque.size()==0){
                                    deque.offer(new pair(nums[ei],ei));
                                    ei++;
                                    
                            }else{
                                    while(deque.size()>0&&nums[ei]>deque.peekLast().val){
                                            
                                             deque.pollLast();
                                    }
                                  
                                    deque.offer(new pair(nums[ei],ei));
                                    ei++;
                            }
                    }
                     while(deque.size()>0&&nums[ei]>deque.peekLast().val){
                                            
                                             deque.pollLast();
                                  }
                    
                    
                      deque.offer(new pair(nums[ei],ei));      
                    
                   
                    ei++;
                    ans.add(deque.peekFirst().val);
                    
                    si++;
                    
                   while(deque.size()>0&&deque.peekFirst().index<si){
                           deque.poll();
                           
                   }

                    
                   
                     
                    
                    
                    
            }
            
            // System.out.println(deque.peekFirst().val);
            
            // System.out.println(ans);
            
            int[] result=new int[ans.size()];
            for(int i=0;i<ans.size();i++){
                    result[i]=ans.get(i);
            }
            
            return result;
    }
}