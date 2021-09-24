class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
 
        
        TreeMap<Integer,Integer> tree=new TreeMap<>();
        Arrays.sort(nums1);
        for(int i=0;i<nums1.length;i++){
             tree.put(nums1[i], tree.getOrDefault(nums1[i], 0) + 1);
        }
         
         
         int[] ans=new int[nums1.length];
         PriorityQueue<int[]>  pq=new PriorityQueue<>((a,b)->{
             return a[0]-b[0];
         });
        
        for(int i=0;i<nums2.length;i++){
            pq.add(new int[]{nums2[i],i});
        }
        
        
        while(pq.size()!=0){
          int[] a=  pq.poll();
         Integer val= tree.higherKey(a[0]);
            
            if(val!=null){
                ans[a[1]]=val;
               int x= tree.get(val);
                x--;
                if(x==0)tree.remove(val);
                else tree.put(val,x);
            }else{
                int v=tree.firstKey();
                ans[a[1]]= v;
                
                 int x= tree.get(v);
                x--;
                if(x==0)tree.remove(v);
                else tree.put(v,x);
            }
        }
    
        
        return ans;
        
    
    }
}