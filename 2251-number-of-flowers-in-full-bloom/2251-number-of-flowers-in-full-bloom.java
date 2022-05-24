class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        int nF=flowers.length;
        int nP=persons.length;
        
        TreeMap<Integer,Integer> tree=new TreeMap<>();
        
        for(int[] flower:flowers){
            int l=flower[0],r=flower[1];
            tree.put(l,tree.getOrDefault(l,0)+1);
            tree.put(r+1,tree.getOrDefault(r+1,0)-1);
        }
        
        
       HashMap<Integer,Integer> map=new HashMap<>();
        
        int sum=0;
       for (Map.Entry<Integer, Integer>entry : tree.entrySet()){
           sum+=entry.getValue();
           map.put(entry.getKey(),sum);
       }

        
        int[] ans=new int[nP];
        int index=0;
        for(int ele:persons){   
           Integer lower= tree.floorKey(ele);
            if(lower!=null)
            ans[index++]=map.get(lower);
            else
            ans[index++]=0;
        }
        return ans;
    }
}