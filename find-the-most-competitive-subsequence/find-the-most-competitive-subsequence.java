class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> st=new Stack<>();
            
        int n=nums.length;
            
         for(int i=0;i<nums.length;i++){
                 int x=n-i-1;
                 while(st.size()>0&&st.peek()>nums[i]&&st.size()+x>=k){
                         st.pop();
                 }
                 
                 st.push(nums[i]);
         }
            
          while(st.size()>k){
                  st.pop();
          }
            
            int[] ans=new int[k];
            
            for(int i=0;i<st.size();i++){
                    ans[i]=st.get(i);
            }
            return ans;
    }
}