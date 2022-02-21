class Solution {
    public int shortestSubarray(int[] nums, int k) {
         int n=nums.length;
       TreeMap<Long,Integer> tree=new TreeMap<>();
        
        tree.put((long)0,-1);
        
        Long sum=(long)0;
        
        int  min=(int)1e10;
        
        for(int i=0;i<n;i++){
            sum+=nums[i];
            Long val=tree.floorKey(sum-(long)k);
            while(val!=null){
                min=Math.min(min,(i-tree.get(val)));
                tree.remove(val);
                val=tree.lowerKey(val);
            }
            
            tree.put(sum,i);
        }
        
        return min==(int)1e10?-1:min;
    }
}