class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        
        TreeMap<Integer,Integer> map=new TreeMap<>();
        
        for(int i=0;i<nums2.length;i++){
            map.put(nums2[i],i);
        }
        
        int ans=0;
        for(int i=0;i<nums1.length;i++){
          Integer x=  map.ceilingKey(nums1[i]);
            if(x!=null){
               int index= map.get(x);
                if(index>=i){
                    ans=Math.max(ans,index-i);
                }
            }
        }
        return ans;
    }
}




// r=null
// [0,1,2,3]
// p  q

// n*log*m