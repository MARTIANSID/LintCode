class Solution {
    public boolean find132pattern(int[] nums) {
        int n=nums.length;
        int[] left=new int[n];
        int min=(int)1e9;
        for(int i=0;i<nums.length;i++){
            min=Math.min(min,nums[i]);
            left[i]=min;
        }
        
        TreeMap<Integer,Integer> map=new TreeMap<>();
      
        for(int i=n-1;i>=0;i--){
            if(i>0&&i<n-1){
                int m2=left[i-1];
             Integer key= map.lowerKey(nums[i]);
                if(key!=null){
                    if(nums[i]>m2&&m2<key){
                        return true;
                    }
                }
            }
            map.put(nums[i],1);
        }
        return false;
    }
}