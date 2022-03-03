class Solution {
    public int singleNumber(int[] nums) {
        int[] freq=new int[32];
        
        int n=nums.length;
        
        for(int i=0;i<32;i++){
            for(int j=0;j<n;j++){
                int x=1<<i;
               if((nums[j]&x)!=0){
                    freq[i]++;
                }
            } 
        }
        
        int ans=0;
        for(int i=0;i<32;i++){
            if(freq[i]%3!=0){
                ans+=(1<<i);
            }
        }
        return ans;
    }
}