class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n=nums.length;
        int max=1<<maximumBit;
        int[] left=new int[n];
        int xor=0;
        
        for(int i=0;i<n;i++){
            xor^=nums[i];
            left[i]=xor;
        }
        
        int[] storeAnsToQuery=new int[n];
        int index=0;
        
        for(int i=n-1;i>=0;i--){
            int ans=0;
            for(int j=maximumBit-1;j>=0;j--){
                int x=1<<j;
                if((left[i]&x)==0){
                    ans +=x;
                }
            }
            storeAnsToQuery[index++]=ans;
        }
        
        return storeAnsToQuery; 
    }
}