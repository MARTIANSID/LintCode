class Solution {
    public int arrayNesting(int[] nums) {
            int n=nums.length;  
        
       
        
       
        int max=0;
        for(int i=0;i<n;i++){
               int val=nums[i];
            if(val==-1)continue;
            int count=0;
            while(true){
                
                if(nums[val]==-1)break;
               
               
                
                int x=nums[val];
                 nums[val]=-1;
                val=x;
                count++;
            }
            max=Math.max(max ,count);
                
        }
        return max;
    }
}
