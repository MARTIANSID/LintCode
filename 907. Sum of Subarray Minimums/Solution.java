class Solution {
    // https://leetcode.com/problems/sum-of-subarray-minimums/discuss/178876/stack-solution-with-very-detailed-explanation-step-by-step  for explaination
    public int sumSubarrayMins(int[] arr) {
        Stack<Integer> st=new Stack<>();
      
            
           int[] left=new int[arr.length];
           int[] right=new int[arr.length];
            
            int mod=(int)1e9+7;
            
            Arrays.fill(left,-1);
            Arrays.fill(right,arr.length);
            
            
            //left
            for(int i=0;i<arr.length;i++){
                   
                    while(st.size()>0&&arr[st.peek()]>=arr[i]){
                            
                           st.pop();
                   } 
                    
                    if(st.size()>0){
                            left[i]=st.peek();
                    }
                    
                    
                    st.push(i);
                    
            }
            st.clear();
            
           //right
            for(int i=arr.length-1;i>=0;i--){
                    
                      while(st.size()>0&&arr[st.peek()]>arr[i]){
                            
                           st.pop();
                   } 
                    
                    if(st.size()>0){
                            right[i]=st.peek();
                    }
                    
                    st.push(i);

                    
            }
            int ans=0;
            for(int i=0;i<arr.length;i++){
                    int dist1= right[i]-i;
                    int dist2= i-left[i];
                    
                    ans= (ans+ (dist1)%mod*(dist2)%mod*arr[i])%mod;
                    
                    
            }
          
            return ans;
    }
}