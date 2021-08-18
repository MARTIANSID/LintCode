class Solution {
    public int smallestDistancePair(int[] nums, int k) {
     
        
        Arrays.sort(nums);
        int l=0,r=nums[nums.length-1]-nums[0];
        while(l<=r){
            int mid=(l+r)/2;
            
            int i=0,j=1,count=0;
            while(i<=j&&j<nums.length){
                if(nums[j]-nums[i]<=mid){
                    count+=j-i;
                    j++;
                }else{
                    i++;
                }
               
            }

            if(count>=k){
                r=mid-1;
            }else{  
                l=mid+1;
            }
            
        }
        
        return l;
            
    }
    
}


// [62,100,4]

