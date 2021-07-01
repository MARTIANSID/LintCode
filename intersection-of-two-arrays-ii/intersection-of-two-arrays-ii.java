class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map1=new HashMap<>();
        HashMap<Integer,Integer> map2=new HashMap<>();
         
           for(int ele:nums1){
                     map1.put(ele,map1.getOrDefault(ele,0) + 1);
           }
            
            for(int ele:nums2){
                    map2.put(ele,map2.getOrDefault(ele,0)+1);
            }
            
            List<Integer> result=new ArrayList<>();
            
            HashSet<Integer> uni=new HashSet<>();
            
            for(int ele:nums1){
              if(uni.add(ele)){
                int x=    map1.getOrDefault(ele,0);
                int y=map2.getOrDefault(ele,0);
                int n=Math.min(x,y);
                for(int i=0;i<n;i++){
                        result.add(ele);
                }
                    
              }
                    
                     
            }
            
            int[] ans=new int[result.size()];
            for(int i=0;i<ans.length;i++){
                    ans[i]=result.get(i);
            }
            
            return ans;
            
    }
}