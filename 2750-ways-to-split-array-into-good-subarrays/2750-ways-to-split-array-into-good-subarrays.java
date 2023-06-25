class Solution {
    int mod=(int)1e9+7;
    public int numberOfGoodSubarraySplits(int[] nums) {
    
        int n=nums.length,one=0;
        
        List<Integer> ones=new ArrayList<>();
        
        for(int i=0;i<n;i++){
            
            if(nums[i] == 1){
                one++;
                ones.add(i);
            }
        }
        long cnt=1;
        
        for(int i=0;i<ones.size()-1;i++){
          
            cnt=(cnt*(ones.get(i+1)-ones.get(i)))%mod;
        }
        
        if(one == 0)return 0;
        
        return (int)(cnt%mod);
    }
}