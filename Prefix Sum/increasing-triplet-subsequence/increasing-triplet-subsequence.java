class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n=nums.length;
        int[] prefixMax=new int[n];
        int[] prefixMin=new int[n];
        
        int min=(int)1e9;
        for(int i=0;i<n;i++){
             min=Math.min(nums[i],min);
            prefixMin[i]=min;
        }
        
        int max=-(int)1e9;
        for(int i=n-1;i>=0;i--){
            max=Math.max(max,nums[i]);
            prefixMax[i]=max;
        }
        
        for(int i=1;i<n-1;i++){
            if(prefixMin[i-1]<nums[i]&&nums[i]<prefixMax[i+1])return true;
        }
        return false;
    }
}