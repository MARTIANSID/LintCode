class Solution {
    public List<Long> minOperations(int[] nums, int[] queries) {
        int n=nums.length;
        Arrays.sort(nums);
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int i=0;i<n;i++){
            if(!map.containsKey(nums[i]))
            map.put(nums[i],i);
        }
        long[] left=new long[n];
        long[] right=new long[n];
        
        long sum=0;
        
        
        for(int i=0;i<n;i++){
            sum+=nums[i];
            left[i]=sum;
        }
        
        sum=0;
        for(int i=n-1;i>=0;i--){
            sum+=nums[i];
            right[i]=sum;
        }
        
        List<Long> ans=new ArrayList<>();
        for(int q:queries){
            Integer upper=map.ceilingKey(q);
            int index=-1;
            if(upper == null){
                index=n;
            }else{
                index=map.get(upper);
            }
            long l=0,r=0;
            if(index-1>=0){
                l=Math.abs(((long)q*index)-(left[index-1]));
            }
            if(index!=n){
                r=Math.abs((long)q*(n-index)-(right[index]));
            }
            
            ans.add((l+r));
        }
        return ans;
    }
    
}


