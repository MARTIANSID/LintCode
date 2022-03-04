class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n=nums.length;
        int max=(1<<maximumBit)-1;
        
        int[] left=new int[n];
        int xor=0;
        
        for(int i=0;i<n;i++){
            xor^=nums[i];
            left[i]=xor;
        }
        
        int[] storeAnsToQuery=new int[n];
        int index=0;
        
        for(int i=n-1;i>=0;i--){
            storeAnsToQuery[index++]=((max)^left[i]);
        }
        
        return storeAnsToQuery; 
    }
}