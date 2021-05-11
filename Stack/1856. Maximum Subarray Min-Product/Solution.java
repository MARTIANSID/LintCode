class Solution {
    int mod = (int)(1e9 + 7);
  public int maxSumMinProduct(int[] nums) {
      Stack<Integer> st=new Stack<>();
          
       int[] left=new int[nums.length];
       int[] right=new int[nums.length];
         Arrays.fill(left,-1);
         Arrays.fill(right,nums.length);
          
        for(int i=0;i<nums.length;i++){
                while(st.size()>0&&nums[st.peek()]>=nums[i]){
                        st.pop();
                        
                }
                
                if(st.size()>0){
                        left[i]=st.peek();
                }
                
                st.push(i);
        }  
          
          st.clear();
          
          
          for(int i=nums.length-1;i>=0;i--){
                  while(st.size()>0&&nums[st.peek()]>=nums[i]){
                          st.pop();
}
                   if(st.size()>0){
                        right[i]=st.peek();
                }
                
                st.push(i);
                  
          }
          
          long[] prefixSum=new long[nums.length];
          
         long sum=0;
          for(int i=0;i<nums.length;i++){
                  sum=(sum+(long)nums[i]);
                  prefixSum[i]=sum;
               
          }
        // System.out.println(right[2]);
        
          
          long max=0;
          for(int i=0;i<nums.length;i++){
                  int r=right[i];
                  int l=left[i];
                  
                  long m=prefixSum[r-1];
               long  ss=m;
                  if(left[i]!=-1)
                   ss=(prefixSum[r-1]-prefixSum[l]);
                  // System.out.println(ss);
                  
          max  =      Math.max(max,(long)((ss)*(long)nums[i]));
                  
                  
                  
                  
          }
          return (int)(max%mod);
          
  }
}