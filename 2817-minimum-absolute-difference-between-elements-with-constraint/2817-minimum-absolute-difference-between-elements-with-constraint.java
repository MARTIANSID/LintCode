class Solution {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        int n=nums.size();
        
        TreeSet<Integer> set=new TreeSet<>();
        
        int min=(int)1e9;
        
        for(int i=x;i<n;i++){
            int index=i-x;
            set.add(nums.get(index));
            
            Integer upper=set.ceiling(nums.get(i));
            if(upper!=null){
                min=Math.min(min,Math.abs(upper-nums.get(i)));
            }
            Integer lower=set.floor(nums.get(i));
            if(lower!=null){
                min=Math.min(min,Math.abs(lower-nums.get(i)));
            }
        }
        return min;
    }
}