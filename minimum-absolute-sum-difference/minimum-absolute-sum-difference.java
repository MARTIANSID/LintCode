class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
            int n=nums1.length;
            
            TreeMap<Integer,Integer> tree=new TreeMap<>();
            for(int i=0;i<n;i++){
                tree.put(nums1[i],i);
            }
        
        
        int gain=0,replaceIndex=0,replaceWithIndex=0;
        for(int i=0;i<n;i++){
        Integer x= tree.floorKey(nums2[i]);
        Integer y=tree.ceilingKey(nums2[i]);
        if(x!=null&&x!=nums1[i]){
          int val=  Math.abs((nums2[i]-nums1[i]))-Math.abs((nums2[i]-x));
            if(val>gain){
                gain=val;
                replaceIndex=i;
                replaceWithIndex=tree.get(x);
            }
            
        }
            
            if(y!=null&&y!=nums1[i]){
          int val=  Math.abs((nums2[i]-nums1[i]))-Math.abs((nums2[i]-y));
            if(val>gain){
                gain=val;
                replaceIndex=i;
                replaceWithIndex=tree.get(y);
            }
            
        }
            
        }
        
        nums1[replaceIndex]=nums1[replaceWithIndex];
        int mod=(int)1e9+7;
        long ans=0;
        for(int i=0;i<n;i++){
            ans= (ans+Math.abs(nums2[i]-nums1[i]))%mod;
        }
        return (int)(ans%mod);
    }
}
