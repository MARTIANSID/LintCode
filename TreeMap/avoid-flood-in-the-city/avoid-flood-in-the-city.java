class Solution {
    public int[] avoidFlood(int[] rains) {
            HashMap<Integer,Integer> map=new HashMap<>();
            TreeMap<Integer,Integer> tree=new TreeMap<>();
            int[] ans=new int[rains.length];
        for(int i=0;i<rains.length;i++){
            if(rains[i]==0){
                ans[i]=1;
              tree.put(i,0);
            }else{
                if(map.containsKey(rains[i])){
                  Integer x= tree.higherKey(map.get(rains[i]));
                    if(x==null)return new int[]{};
                    else{
                        map.remove(rains[i]);
                       ans[x]=rains[i];
                        tree.remove(x);
                    }
                    map.put(rains[i],i);
                }
                else{
                    map.put(rains[i],i);
                }
            }
        }
        
        
        for(int i=0;i<ans.length;i++){
            if(rains[i]>0)ans[i]=-1;
        }
      
         return  ans;
    }
}