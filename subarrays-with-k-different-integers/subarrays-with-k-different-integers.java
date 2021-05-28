class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
       
            return atMostK(nums,k)-atMostK(nums,k-1);
                
    }
        
        public int atMostK(int[] nums,int k){
                 int si=0;
        int ei=0;
        int n=nums.length;
        int[] freq=new int[20001];
        int distinct=0;    
                int ans=0;
            
                 while(ei<n){
         freq[nums[ei]]++;
        int x=freq[nums[ei]];
                        ei++;
                         
                         if(x==1){
                                 distinct++;
                                 
                         }
                         
                         while(distinct>k){
                                 freq[nums[si]]--;
                                 
                                 if(freq[nums[si]]==0)
                                        distinct--;
                                 si++;
                         }
                         
                         ans+=ei-si;
                       
                         
                         
                         
         }
                
               
            
            return ans;
        }
}