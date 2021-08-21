class Solution {
    public int movesToMakeZigzag(int[] nums) {
         // first go for even indexed
        //  then go for odd indexed
        if(nums.length==1)return 0;
           int min=(int)1e9;
            int ans1=0;
        for(int i=0;i<nums.length;i+=2){
            if(i==0){
              
                if(nums[i]>=nums[i+1]){
                    ans1+=nums[i]-nums[i+1]+1;
                }
                }else{
                    int max=-(int)1e9;
                int m=(int)1e9;
                    int left=i-1>=0?nums[i-1]:-(int)1e9;
                    int right=i+1<nums.length?nums[i+1]:-(int)1e9;
                    
                    max=Math.max(left,right);
                  if(left==-(int)1e9)left=(int)1e9;
                if(right==-(int)1e9)right=(int)1e9;
                 
                 m=Math.min(left,right);
                   
            
                if(nums[i]>=m){
                        ans1+=nums[i]-m+1;
                    }
                    
                }
            }
       
        
              

        min=ans1;
      
        ans1=0;
        for(int i=1;i<nums.length;i+=2){
                    int max=-(int)1e9;
                    int m=(int)1e9;
                    int left=i-1>=0?nums[i-1]:-(int)1e9;
                    int right=i+1<nums.length?nums[i+1]:-(int)1e9;
                    max=Math.max(left,right);
              if(left==-(int)1e9)left=(int)1e9;
                if(right==-(int)1e9)right=(int)1e9;
                    m=Math.min(left,right);
                   
                 if(nums[i]>=m){
                        ans1+=nums[i]-m+1;
                    }
            
        }
        
        
       
        
        
        min=Math.min(min,ans1);
        return min;
        
    }
}
// 10-3-1
// 9 6 1 6 2
// 9 6 7 6 2