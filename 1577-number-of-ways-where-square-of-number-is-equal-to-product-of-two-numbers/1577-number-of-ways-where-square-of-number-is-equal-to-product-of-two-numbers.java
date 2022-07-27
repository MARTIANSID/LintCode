class Solution {
    public int numTriplets(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        int ans=0;
        
        HashMap<Long,Integer> map=new HashMap<>();
    
        for(int ele:nums1){
            long square=(long)((long)ele*(long)ele);
            map.put(square,map.getOrDefault(square,0)+1);
        }
        for(int i=0;i<n2;i++){
            for(int j=i+1;j<n2;j++){
                long square=(long)((long)nums2[i]*(long)nums2[j]);
                ans+=(map.getOrDefault(square,0));
            }
        }
        map=new HashMap<>();
        
        for(int ele:nums2){
            long square=(long)((long)ele*(long)ele);
            map.put(square,map.getOrDefault(square,0)+1);
        }
        for(int i=0;i<n1;i++){
            for(int j=i+1;j<n1;j++){
                long square=(long)((long)nums1[i]*(long)nums1[j]);
                ans+=(map.getOrDefault(square,0));
            }
        }
        return ans;
    }
}