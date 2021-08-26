class Solution {

    //o(n) tc ,  // o(n) space 
    public int maxProduct(int[] nums) {
        
        int max=-(int)1e9;
        int maxEndingAti=1;
        int minEndingAti=1;

        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                max=Math.max(0,max);
                maxEndingAti=1;
                minEndingAti=1;
            }
            int mx=maxEndingAti;
            int mi=minEndingAti;
            maxEndingAti=Math.max(nums[i],Math.max(nums[i]*mx,nums[i]*mi));
            minEndingAti=Math.min(nums[i],Math.min(nums[i]*mx,nums[i]*mi));
            max=Math.max(max,maxEndingAti);
        }

        return max;
    }
    //o(n) , o(1) space
   
        public int mp(int[] nums) {
            
            int max=-(int)1e9;
            int maxEndingAti=1;
            int minEndingAti=1;
    
            for(int i=0;i<nums.length;i++){
                if(nums[i]==0){
                    max=Math.max(0,max);
                    maxEndingAti=1;
                    minEndingAti=1;
                }
                int mx=maxEndingAti;
                int mi=minEndingAti;
                maxEndingAti=Math.max(nums[i],Math.max(nums[i]*mx,nums[i]*mi));
                minEndingAti=Math.min(nums[i],Math.min(nums[i]*mx,nums[i]*mi));
                max=Math.max(max,maxEndingAti);
            }
    
            return max;
        }
    

}
