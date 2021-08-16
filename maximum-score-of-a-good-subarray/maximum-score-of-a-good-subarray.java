class Solution {
    public int maximumScore(int[] nums, int k) {
        int n=nums.length,max=0;
        Stack<Integer> st=new Stack<>();
        int[] left=new int[n];
        int[] right=new int[n];
        
        Arrays.fill(left,-1);
        Arrays.fill(right,n);
        
        for(int i=n-1;i>=0;i--){
            while(st.size()>0&&nums[st.peek()]>=nums[i]){
                st.pop();
            }
            if(st.size()>0){
                right[i]=st.peek();
            }
            st.push(i);
        }
        
        
        st.clear();
        
        for(int i=0;i<n;i++){
        while(st.size()>0&&nums[st.peek()]>=nums[i]){
                st.pop();
            }
            if(st.size()>0){
                left[i]=st.peek();
            }
            st.push(i);
        }
        
        
    
        
        
        for(int i=0;i<n;i++){
            int x2=right[i]-1;
            int x1=left[i]+1;
            
            if(k<=x2&&k>=x1){
                max=Math.max(max,nums[i]*(x2-x1+1));
                
            }
                
            
        }
        
        return max;
        
        
        
    }
}