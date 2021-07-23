class Solution {
    public int partitionDisjoint(int[] nums) {
        int n=nums.length;
        int[] preMax=new int[n];
        int[] preMin=new int[n];
        int min=(int)1e9,max=-(int)1e9;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
            preMax[i]=max;
        }
        
        for(int i=n-1;i>=0;i--){
            min=Math.min(min,nums[i]);
            preMin[i]=min;
        }
        int i=0;
        int  ma= preMax[i];
        int mi=preMin[i+1];
        while(ma>mi){
            i++;
            ma=preMax[i];
            mi=preMin[i+1];
        }
        return i+1;
        
    }
}

// [5,0,3|,8,6]/
