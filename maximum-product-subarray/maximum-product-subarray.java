class Solution {
    public int maxProduct(int[] nums) {
   int[] pre=new int[nums.length];
      int count=0;
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]<0)count++;
            if(nums[i]==0)count=0;
            pre[i]=count;
        }
        
        int p=1,m=-(int)1e9;
        int[] arr=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0)
            p*=nums[i];
            else p=1;
            arr[i]=p;
            m=Math.max(m,nums[i]);
            
        }
        int mp=m;
        boolean pos=true;
        int index=(int)1e9;
        int prod=1;
        int ans=0;
        int max=-(int)1e9;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                max=Math.max(ans,max);
                    mp=Math.max(0,mp);

                ans=0;
                pos=true;
                index=(int)1e9;
                prod=1;
            }else{
                if(nums[i]<0){
                 
                    
                    if(pos==false){
                        prod*=nums[i];
                        mp=Math.max(mp,prod);
                        pos=true;
                        ans++;
                        index=Math.min(index,i);
                    }else{
                        if(i+1<nums.length&&pre[i+1]!=0){
                            prod*=nums[i];
                           
                            pos=false;
                            ans++;
                            index=Math.min(index,i);
                        }else{
                        
                         if(index!=(int)1e9){   
                        max= Math.max(ans,max);
                           ans=i-(index+1)+1;
                            
                            mp=Math.max(mp,arr[i]/arr[index]);
                             prod=arr[i]/arr[index];
                            
                       
                         }else{
                             prod=1;
                             ans=0;
                         }
        
                        pos=true;
                        }
                    }
                    
                    
                    
                }else{
                    prod*=nums[i];
                    mp=Math.max(mp,prod);

                    ans++;
                }
            }
            
          
        }
        
      
        max=Math.max(max,ans);
       
        return mp;
        
    }
}