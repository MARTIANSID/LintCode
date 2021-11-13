class Solution {
    public int numTriplets(int[] nums1, int[] nums2) {
        //solve for type-1
        
        HashMap<Long,Long> map=new HashMap<>();
        
        long ans=0;
        for(int ele:nums1){
            long no=(long)((long)ele*(long)ele);
            // System.out.println(no);
            map =new HashMap<>();
            for(int e:nums2){
                           
                if(map.containsKey(no/e)&&no%e==0){
                    ans+=map.get(no/e);
                }
                map.put((long)e,map.getOrDefault((long)e,(long)0)+1);
            }
        }
        
        
           
        //solve for type-2
        
        map=new HashMap<>();
        
         for(int ele:nums2){
             long no=(long)((long)ele*(long)ele);
             map=new HashMap<>();
            for(int e:nums1){
                if(map.containsKey(no/e)&&no%e==0){
                    
                    ans+=map.get(no/e);
                }
                map.put((long)e,map.getOrDefault((long)e,(long)0)+1);
            }
        }
        
        
        return (int) ans;
    
     
    }
}