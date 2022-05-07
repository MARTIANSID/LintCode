class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        Set<String> set=new HashSet<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
           String sub="";
            int count=0;
            for(int j=i;j<n;j++){
                sub+=nums[j]+",";
                if(nums[j]%p==0)count++;
                if(count > k)break;
                set.add(sub);
            }
        }
        return set.size();
    }
}