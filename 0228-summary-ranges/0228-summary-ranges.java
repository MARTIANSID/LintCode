class Solution {
    public List<String> summaryRanges(int[] nums) {
        
        if(nums.length == 0)return new ArrayList<>();
        
        int first=nums[0];
        String range="";
        
        List<String> ans=new ArrayList<>();
        
        
        for(int i=1;i<nums.length;i++){
            if(nums[i]-nums[i-1]!=1){
                if(first!=nums[i-1])
                range=first+"->"+nums[i-1];
                else
                range=first+"";
                ans.add(range);
                first=nums[i];
            }
        }
        if(first!=nums[nums.length-1])
         range=first+"->"+nums[nums.length-1];
        else
          range=first+"";
        
        ans.add(range);
        
        return ans;
    }
}