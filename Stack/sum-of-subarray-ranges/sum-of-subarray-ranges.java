class Solution {
    public long subArrayRanges(int[] nums) {
        // [1,2,3]
        int n=nums.length;
        
        Stack<Integer> st=new Stack<>();
        
        int[] left=new int[n];
        
        int[] right=new int[n];
        
        Arrays.fill(left,-1);
        Arrays.fill(right,n);
        
        //left greater
       for(int i=0;i<n;i++){
           while(st.size()>0&&nums[st.peek()]<nums[i])st.pop();
           
           if(st.size()>0)left[i]=st.peek();
           
           st.push(i);
       }
        
    //right greater
        
        st.clear();
        for(int i=n-1;i>=0;i--){
             while(st.size()>0&&nums[st.peek()]<=nums[i])st.pop();
           if(st.size()>0)right[i]=st.peek();
            st.push(i);
        }
        
        long largerSum=0;
        
        for(int i=0;i<n;i++){
            long l=i-left[i];
            long r=right[i]-i;
            largerSum+=nums[i]*l*r;
        }
        
        left =new int[n];
        right=new int[n];
        Arrays.fill(left,-1);
        Arrays.fill(right,n);
        
        st.clear();
        
         for(int i=0;i<n;i++){
           while(st.size()>0&&nums[st.peek()]>nums[i])st.pop();
           
           if(st.size()>0)left[i]=st.peek();
           
           st.push(i);
       }
        
  
        
        st.clear();
        for(int i=n-1;i>=0;i--){
             while(st.size()>0&&nums[st.peek()]>=nums[i])st.pop();
           if(st.size()>0)right[i]=st.peek();
            st.push(i);
        }
        
        
        long smallerSum=0;
        
          for(int i=0;i<n;i++){
            long l=i-left[i];
            long r=right[i]-i;
            smallerSum+=nums[i]*l*r;
        }
        
        return largerSum-smallerSum;
        
        
    }
}