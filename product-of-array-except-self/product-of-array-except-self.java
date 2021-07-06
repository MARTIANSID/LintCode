class Solution {
    public int[] productExceptSelf(int[] nums) {
            if(nums.length==1){
                    
                    int[] a=new int[1];
                    a[0]=1;
                    return a;
            }
            
            
        int[] leftprod=new int[nums.length];
            int product=1;
           for(int i=0;i<nums.length;i++){
                  product*=nums[i];
                   leftprod[i]=product;
           }
            
            int[] rightprod=new int[nums.length];
            
            product=1;
            for(int i=nums.length-1;i>=0;i--){
                    product*=nums[i];
                    rightprod[i]=product;
            }
            
            int[] ans=new int[nums.length];
            
            for(int i=0;i<nums.length;i++){
                   if(i==0){
                          ans[i]=rightprod[1];
                   }else if(i==nums.length-1){
                           
                           ans[i]=leftprod[i-1];
                   }else{
                           int  x=rightprod[i+1]*leftprod[i-1];
                           ans[i]=x;
                   }
            }
            
            return ans;
            

    }
}




