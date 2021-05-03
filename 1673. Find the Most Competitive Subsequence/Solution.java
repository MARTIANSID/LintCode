class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
     
            Stack<Integer> st=new Stack<>();
            
            // int n=nums.length;
            int n=nums.length-1;
            int x=k;
            
            for(int i=0;i<nums.length;i++){
                                   

                    while(st.size()>0&&st.size()+n>=x&&st.peek()>nums[i]){
                            st.pop();
                    }
                   
                   n--;
                    if(st.size()>0&&st.size()==k&&st.peek()<nums[i])continue;
                          st.push(nums[i]);
                    
                    
            }
            
            int[] ans=new int[k];
            
            for(int i=0;i<k;i++){
                    ans[i]=st.get(i);
            }
            
            return ans; 
            
          
}
}