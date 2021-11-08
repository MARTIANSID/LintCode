class Solution {
    public int maxResult(int[] nums, int k) {
        int n=nums.length;
        
      // algo---  // we will use dp starting from back with que to maintain the max
        
          Deque<Integer> dq
            = new LinkedList<>();
        
        int ei=n-1,si=n-1;
        
        int[] dp=new int[n];
        
        
       
        while(ei>=0){
           
           while(dq.size()>0&&si<dq.peekLast()){
                dq.removeLast();
           }
             while(dq.size()>0&&si<dq.peekFirst()){
                dq.removeFirst();
           }
            
            if(dq.size()==0)
            dp[ei]+=nums[ei];
            else
            dp[ei]=nums[ei]+dp[dq.peekFirst()];
            
            while(dq.size()>0&&dp[ei]>dp[dq.peekLast()]){
            dq.removeLast();
            }
            dq.add(ei);
            ei--;
            
            if(si-ei>k)si--;
        }
        
       
        
        return dp[0];
        
    }
}