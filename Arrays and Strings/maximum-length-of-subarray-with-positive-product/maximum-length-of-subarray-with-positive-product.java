class Solution {
    public int getMaxLen(int[] nums) {
        int[] pre=new int[nums.length];
      int count=0;
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]<0)count++;
            if(nums[i]==0)count=0;
            pre[i]=count;
        }
        
        boolean pos=true;
        int index=(int)1e9;
        int prod=1;
        int ans=0;
        int max=-(int)1e9;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                max=Math.max(ans,max);
                ans=0;
                pos=true;
                index=(int)1e9;
                // prod=1;
            }else{
                if(nums[i]<0){
                 
                    index=Math.min(index,i);
                    if(pos==false){
                        // prod*=nums[i];
                        pos=true;
                        ans++;
                    }else{
                        if(i+1<nums.length&&pre[i+1]!=0){
                            // prod*=nums[i];
                            // System.out.println(nums[i]);
                            pos=false;
                            ans++;
                        }else{
                            // System.out.println(ans);
                            // System.out.println(nums[i]);
                         if(index!=(int)1e9){
                               max= Math.max(ans,max);
                           ans=i-(index+1)+1;
                            
                        while(nums[index]>0){
                            index++;
                        }
                         }else{
                             ans=0;
                         }
        
                        pos=true;
                        }
                    }
                    
                    
                    
                }else{
                    ans++;
                }
            }
            
            // System.out.println(prod);
        }
        
        // System.out.println(ans);
        max=Math.max(max,ans);
       
        return max;
    }
}