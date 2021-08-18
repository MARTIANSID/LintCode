class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        
        int mod=(int)1e9+7;
        int i=0,j=nums.length-1;
       long ans=0;
        
         long[] modPow = new long[nums.length + 1];
        modPow[0] = 1;
        for (int k = 1; k < modPow.length; k++) {
            modPow[k] = 2 * modPow[k-1] %mod;
        }
        while(i<=j){
            int  min=nums[i];
            int max=nums[j];
            if(min+max<=target){
                ans=(ans+modPow[j-i])%mod;
                i++;
            }else{
                j--;
            }
        }
        return (int)(ans%mod);
    }
}
// 3 5 6
// 3 5 
// 3 5 6 



// [3,5,6,7]
// 356